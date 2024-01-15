package com.spring.swagger.controller;

import com.spring.swagger.model.Employee;
import com.spring.swagger.dao.EmployeeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//http://localhost:8080
@Api( description = "Controller Employee Layer")
@RestController
@RequestMapping("/api")
//http://localhost:8080/api
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    //http://localhost:8080/api/save
   @PostMapping("/save")
   @ApiOperation(value = "Save Employee",notes ="You muss pass object of Employee" )
   public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return  ResponseEntity.status(HttpStatus.CREATED).body(
                employeeRepository.save(employee));

    }
    @GetMapping("/show")
    @ApiOperation(value = "show Employee",notes ="You muss pass id of Employee" )
    public ResponseEntity<Employee> show(@RequestParam Long id){
      return ResponseEntity.status(HttpStatus.OK).body(

                employeeRepository.findById(id).get());
    }
    @DeleteMapping("/delete")
    @ApiOperation(value = "delete Employee",notes ="You muss pass id of Employee" )
    public void delete(@RequestParam Long id){
        employeeRepository.deleteById(id);
    }

    @PutMapping("/edit")
    @ApiOperation(value = "edit Employee",notes ="You muss pass object of Employee" )
    public Employee edit(@RequestBody Employee employee){
        return   employeeRepository.save(employee);
    }
}
