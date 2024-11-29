package com.codingshuttle.office.ofiice.controllers;

import com.codingshuttle.office.ofiice.dto.DepartmentDTO;
import com.codingshuttle.office.ofiice.exceptions.ResourceNotFoundException;
import com.codingshuttle.office.ofiice.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentByID(@PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.getDepartmentByID(departmentId));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewEmployee(@Valid @RequestBody DepartmentDTO inputDepartment) {
        DepartmentDTO savedDepartment = departmentService.createNewDepartment(inputDepartment);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@Valid @RequestBody DepartmentDTO departmentDTO, @PathVariable Long departmentId) {
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentId, departmentDTO));
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId) {
        boolean gotDeleted = departmentService.deleteDepartmentById(departmentId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updatePartialDepartmentById(@Valid @RequestBody Map<String, Object> updates, @PathVariable Long departmentId) {
        DepartmentDTO departmentDTO = departmentService.updatePartialDepartmentById(departmentId, updates);
        if(departmentDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departmentDTO);
    }
}
