package com.spring.swagger.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;

//http://localhost:8080
@Api( description = "Controller Player Layer")
@RestController
@RequestMapping("/api")
//http://localhost:8080/api
public class PlayerController {

    @GetMapping("/name")
    @ApiOperation(value = "get Name",notes = "Empty Object",tags ="employee-controller" )
    //@ApiOperation(value = "get Name",notes = "Empty Object",tags = "employee-controller\n")
    public String getName(){
        return "Mahmoud Khalil";
    }

    @GetMapping("/student")
    public String geStudent(){
        return "I am Student (Mahmoud Khalil)";
    }

}
