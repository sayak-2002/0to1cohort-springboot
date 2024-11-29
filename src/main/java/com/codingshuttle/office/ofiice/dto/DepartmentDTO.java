package com.codingshuttle.office.ofiice.dto;

import com.codingshuttle.office.ofiice.annotations.Password;
import com.codingshuttle.office.ofiice.annotations.PrimeNumber;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @AssertTrue(message="Department should be active")
    @JsonProperty("isActive")
    private Boolean isActive;
    @PastOrPresent(message = "created at date cannot be of future")
    private LocalDate createdAt;
    @PrimeNumber
    private Integer primeNumber;
    @Password
    private String password;
}
