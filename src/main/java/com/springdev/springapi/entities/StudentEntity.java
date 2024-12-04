package com.springdev.springapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private LocalDate dateofjoining;
    private boolean isActive;
}
