package com.example.controller;

import com.example.model.Student;
import com.example.service.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudent<Student> service;
    public ModelAndView getAll(){
        List<Student> students = service.findAll();
        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("listStudent",students);
        return modelAndView;
    }

}
