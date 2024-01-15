package com.spring.swagger.controller;

import com.spring.swagger.model.Employee;
import com.spring.swagger.dao.EmployeeRepository;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//http://localhost:8080
@Api(value = "This is The Employee Controller", description = "Controller layer")
@Tag(name = "Employee Controller Layer")
@RestController
@RequestMapping("/api")
//http://localhost:8080/api
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    //http://localhost:8080/api/save
   @PostMapping("save")
   @Tag(name = "Employee Controller Layer")
   public void save(@RequestBody Employee employee){
        employeeRepository.save(employee);
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
