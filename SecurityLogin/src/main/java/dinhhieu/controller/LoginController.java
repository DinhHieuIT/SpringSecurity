package dinhhieu.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dinhhieu.entities.Student;
import dinhhieu.service.StudentService;

@Controller
public class LoginController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping ("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/signup")
	public String signUpForm(Model model) {
		model.addAttribute("student", new Student());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signUp(@ModelAttribute Student student) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(student.getPassword());
		student.setPassword(encodedPassword);
		studentService.save(student);
		return "redirect:/";	
	}
	
//	@GetMapping("/signin")
//	public String signInPage(Model model) {
//		model.addAttribute("student", new Student());
//		return "signin";
//	}
//	@PostMapping("/signin")
//	public String signIn(@ModelAttribute Student student, Model model) {
//	
//		//Student studentLogin = studentService.findByEmail(student.getEmail());
//		Student s1 = studentService.findByEmail(student.getEmail());
//		boolean b1 = s1.getPassword().equals(student.getPassword());
//		if(s1 != null && b1 ) {
//			List<Student> students = studentService.getAllStudent();
//			model.addAttribute("students", students);
//			return "students";	
//		}
//		return "redirect:/";
//	}
	
	@GetMapping("/students")
	public String getAllStudent(Model model) {
		List<Student> students = studentService.getAllStudent();
		model.addAttribute("students", students);
		return "students";
	}
//	@PostMapping("/logout")
//	public String signout(HttpServletRequest request) {
//		request.getSession().invalidate();
//		return "redirect:/";
//	}
	

}
