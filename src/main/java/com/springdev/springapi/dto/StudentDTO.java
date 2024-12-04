package com.springdev.springapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private long id;
    private String name;
    private LocalDate dateofjoining;
    private boolean isActive;


}
