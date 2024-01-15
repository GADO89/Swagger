package com.spring.swagger.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    @ApiModelProperty(value = "This is the id of the Employee")
    private Long id;

    @ApiModelProperty(value = "This is the Full Name of the Employee",required = false)
    private String fullName;

    private String age;

    private String phone;

    private String address;

}
