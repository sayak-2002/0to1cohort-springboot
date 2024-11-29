package com.codingshuttle.office.ofiice.service;


import com.codingshuttle.office.ofiice.dto.DepartmentDTO;
import com.codingshuttle.office.ofiice.entity.DepartmentEntity;
import com.codingshuttle.office.ofiice.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;
    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }
    public DepartmentDTO getDepartmentByID(Long departmentId) {
        isExistsByDepartmentID(departmentId);
        return departmentRepository
                .findById(departmentId)
                .map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDTO.class))
                .get();
    }
    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }
    public DepartmentDTO createNewDepartment(DepartmentDTO inputDepartment) {
        DepartmentEntity toSaveEntity = modelMapper.map(inputDepartment, DepartmentEntity.class);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(toSaveEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }
    public boolean isExistsByDepartmentID(Long departmentId) {
        boolean exists = departmentRepository.existsById(departmentId);
        if(!exists) return false;
        return true;
    }
    public DepartmentDTO updateDepartmentById(Long departmentId, DepartmentDTO departmentDTO) {
        isExistsByDepartmentID(departmentId);
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }
    public boolean deleteDepartmentById(Long departmentId) {
        isExistsByDepartmentID(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }
    public DepartmentDTO updatePartialDepartmentById(Long departmentId, Map<String, Object> updates) {
        isExistsByDepartmentID(departmentId);
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).get();

        updates.forEach((field, newValue) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(DepartmentEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, departmentEntity, newValue);
        });

        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDTO.class);
    }

}
