package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public static List<Student> students =new ArrayList<>();
    static {
        students.add(new Student(1,"Kim",18));
        students.add(new Student(2,"Bình",19));
        students.add(new Student(3,"Mai",20));
    }
    public static void delete (int id){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId()==id){
                students.remove(i);
            }
        }
    }
    public static Student findStudentById(int id){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId()==id){
                return students.get(i);
            }
        }
        return null;
    }
    public static int findIndexById(int id){
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
//    public static Student searchStudent(String str){
//        for (int i = 0; i < students.size(); i++) {
//            if(students.get(i).getName().toUpperCase().contains(str.toUpperCase())){
//                return students.get(i);
//            }
//
//        }
//        return null;
//    }

    public static List<Student> searchStudent(String str){
        List<Student> listSearch=new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getName().toUpperCase().contains(str.toUpperCase())){
                listSearch.add(students.get(i));
            }
        }
        return listSearch ;
    }

}
