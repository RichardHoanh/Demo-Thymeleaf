package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Home {
    //Hàm hiển thị
    @GetMapping("/home")
    public String toan(Model model) {
        model.addAttribute("student", StudentService.students);
//        Chuyển đến home.jsp
        return "home";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        StudentService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public String showFormCreate() {
        return "formCreate";
    }

    @PostMapping("/create")
    public String create(Student student) {
        StudentService.students.add(student);
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String showFormEdit(Model model, @RequestParam int id) {
        model.addAttribute("edit", StudentService.findStudentById(id));
        return "formEdit";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam int id, String name, int age) {
        int index=StudentService.findIndexById(id);
        Student student =new Student(id,name,age);
        StudentService.students.set(index,student);
        return "redirect:/home";
    }


// Cách 2:
    //    @PostMapping("/edit")
//    public String edit(@RequestParam int id,String name,int age) {
//
//        StudentService.findStudentById(id).setAge(age);
//        StudentService.findStudentById(id).setName(name);
//        return "redirect:/home";
//    }

//    Cách 3:
//    @PostMapping("/edit")
//    public String edit(Student student) {
//        StudentService.delete(student.getId());
//        StudentService.students.add(student);
//
//        return "redirect:/home";
//    }


//    @GetMapping("/search")
//    public String search(Model model,@RequestParam String search) {
//        Student student= StudentService.searchStudent(search);
//        List<Student> students=new ArrayList<>();
//        students.add(student);
//        model.addAttribute("student",students);
//        return "home";
//    }

    @GetMapping("/search")
    public String search(Model model,@RequestParam String search) {
        List<Student> list=StudentService.searchStudent(search);
        model.addAttribute("student",list);
        return "home";
    }


}
