package net.springboot.rest_api.controller;
import net.springboot.rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @GetMapping("student")
    public Student getStudent() {
       Student student = new Student(
         1,
         "Hari",
         "Nair"
       );
        return student;
    }

    //using responseEntity
    @GetMapping("studentRes")
    public ResponseEntity<Student> getStudentRes() {
        Student student = new Student(
                1,
                "Hari",
                "Nair"
        );
        //return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header","Hari")
                .body(student);
    }
    @GetMapping("list-students")
    public List<Student> getStudents(){
      List<Student> students = new ArrayList<>();
      students.add(new Student(1,"Hari","Nair"));
      students.add(new Student(2,"Harsh","Nair"));
      return students;
    };
    //with path variable
    //http://localhost:8080/student-path/6
   @GetMapping("student-path/{id}")
    public Student studentPathVariable(@PathVariable int id){
       return new Student(id,"Hari","Nair");
   };
   // request param
   //http://localhost:8080/students/query?id=1

    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id){
       return new Student(id, "Hari","Nair");
    };
    //http post request
    // needs @postmapping and @Requestbody annotaions for post
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
    return student;
    }

    //put request
    @PutMapping("update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int id){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //delete method

    @DeleteMapping("deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id){
        return  "Student Deleted";
    };

}
