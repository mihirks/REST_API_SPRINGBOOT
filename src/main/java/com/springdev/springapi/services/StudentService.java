package com.springdev.springapi.services;

import com.springdev.springapi.dto.StudentDTO;
import com.springdev.springapi.entities.StudentEntity;
import com.springdev.springapi.repositories.StudentRep;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    final StudentRep studentRep;
    final ModelMapper modelMapper;

    public StudentService(StudentRep studentRep, ModelMapper modelMapper) {
        this.studentRep = studentRep;
        this.modelMapper = modelMapper;
    }


    public StudentDTO getStudentById(Long id) throws Exception{
        try {
            StudentEntity SE= studentRep.getById(id);
            return modelMapper.map(SE,StudentDTO.class );
        }
        catch (Exception e){
            throw new EntityNotFoundException("Entity not found");
        }

//        return new StudentDTO(SE.getId(),SE.getName(),SE.getDateofjoining(),SE.isActive());

    }
    public StudentDTO createNewStudent(StudentDTO stdDTO){
        StudentEntity SE= modelMapper.map(stdDTO,StudentEntity.class);
        return modelMapper.map(studentRep.save(SE),StudentDTO.class);

    }
    public List<StudentDTO> getAllStudent(){
//        StudentEntity SE= modelMapper.map(stdDTO,StudentEntity.class);
        List<StudentDTO> list = new ArrayList<>();
        for (StudentEntity SE : studentRep.findAll()) {
            StudentDTO map = modelMapper.map(SE, StudentDTO.class);
            list.add(map);
        }
        return list;

    }
    public boolean deleteStudent(Long id){
        boolean isPresent =studentRep.existsById(id);
        if (isPresent){
            studentRep.deleteById(id);
            return true;

        }
        else {
            return false;
        }

    }
}
