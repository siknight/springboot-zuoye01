package com.lisi.controller;


import com.lisi.service.StudentService;
import com.lisi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    StudentService service;



    @GetMapping("/pageselect.do")
    @ResponseBody
    public Result findAllStudentByPage(@RequestParam(name="pageNum",defaultValue = "1")Integer pageNum){
        System.out.println("pagenum="+pageNum);
        return service.findAllStudentByPage(pageNum);
    }

    @PutMapping("/studentadd.do")
    @ResponseBody
    public Result addStudentById( String studentName,String age,String sex, String adress){
        return service.addStudentById(studentName,age,sex,adress);
    }

    @PostMapping("/studentupdate.do")
    @ResponseBody
    public Result updateStudentById( String studentName,String age,String sex, String address,Integer id){
        return service.updateStudentById(studentName,age,sex,address,id);
    }

    @DeleteMapping("/navdelete.do")
    @ResponseBody
    public Result deleteNavById(Integer id){
        return service.deleteStudentById(id);
    }
}
