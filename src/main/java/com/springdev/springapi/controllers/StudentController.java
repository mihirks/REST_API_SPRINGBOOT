package com.springdev.springapi.controllers;

//GET
//POST /employees/{}
//DELETE /employees/{}

import com.springdev.springapi.dto.StudentDTO;
import com.springdev.springapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
//@RequestMapping(name = "/student")
public class StudentController {

    private final StudentService studentServ;

    public StudentController(StudentService studentServ) {
        this.studentServ = studentServ;
    }

    @GetMapping(path = "/student/{id}")

    public StudentDTO getStudent(@PathVariable("id") Long stdid) throws Exception {
        try {
            return studentServ.getStudentById(stdid);
        }
        catch (Exception e){
            throw e;
        }
//        return new StudentDTO(stdid,"ram", LocalDate.now(),true);
    }
    @GetMapping(path = "/student")

    public List<StudentDTO> getAllStudent() throws Exception {
        try {
            return studentServ.getAllStudent();
        }
        catch (Exception e){
            throw e;
        }
//        return new StudentDTO(stdid,"ram", LocalDate.now(),true);
    }
    @PostMapping(path = "/student")
    public StudentDTO CreateStudent(@RequestBody StudentDTO stdDTO){
        return studentServ.createNewStudent(stdDTO);
    }

    @DeleteMapping(path = "/std/{id}")
    public boolean deleteStdbyId(@PathVariable("id") Long stdid){
        return studentServ.deleteStudent(stdid);
    }
}
