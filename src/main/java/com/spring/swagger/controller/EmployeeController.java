package com.spring.swagger.controller;

import com.spring.swagger.model.Employee;
import com.spring.swagger.dao.EmployeeRepository;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//http://localhost:8080
@Api(value = "This is The Employee Controller", description = "Controller Layer")
@Tag(name = "Employee Controller Layer", description = "Controller Layer")
@RestController
@RequestMapping("/api")
//http://localhost:8080/api
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    //http://localhost:8080/api/save
   @PostMapping("save")
   @Operation(description = "save Employee", summary = "save Employee",
   tags ="Employee Controller Layer",
   responses = {
           @ApiResponse(responseCode = "201", description = "Created")
   })
   public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return  ResponseEntity.status(HttpStatus.CREATED).body(
                employeeRepository.save(employee));

    }
    @GetMapping("/show")
    @Tag(name = "Employee Controller Layer")
    public Employee show(@RequestParam Long id){
      return   employeeRepository.findById(id).get();
    }
    @DeleteMapping("/delete")
    @Tag(name = "Employee Controller Layer")
    public void delete(@RequestParam Long id){
        employeeRepository.deleteById(id);
    }
    @PutMapping("/edit")
    @Tag(name = "Employee Controller Layer")
    public Employee edit(@RequestBody Employee employee){
        return   employeeRepository.save(employee);
    }
}
