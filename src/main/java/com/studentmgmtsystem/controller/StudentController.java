package com.studentmgmtsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmgmtsystem.model.Student;
import com.studentmgmtsystem.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	// display list of students
	@GetMapping("/students")
	public String viewHomePage(Model model) {
		model.addAttribute("listStudents", studentService.getAllStudents());
		return "students"; // <- trỏ tới trang frontend: students.html
	}

	@GetMapping("/students/new")
	public String createNewStudent(Model model) {
		Student st = new Student();
		model.addAttribute("student", st);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";

	}

	// Delete student by id
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

}
