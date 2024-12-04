package com.springdev.springapi.repositories;

import com.springdev.springapi.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRep extends JpaRepository<StudentEntity,Long> {
}
