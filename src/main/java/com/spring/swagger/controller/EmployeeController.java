package com.spring.swagger.controller;

import com.spring.swagger.model.Employee;
import com.spring.swagger.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//http://localhost:8080
@RestController
@RequestMapping("/api")
//http://localhost:8080/api
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    //http://localhost:8080/api/save
   @PostMapping("save")
    public void save(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }
    @GetMapping("/show")
    public Employee show(@RequestParam Long id){
      return   employeeRepository.findById(id).get();
    }
    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        employeeRepository.deleteById(id);
    }
    @PutMapping("/edit")
    public Employee edit(@RequestBody Employee employee){
        return   employeeRepository.save(employee);
    }
}
