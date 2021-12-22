package dinhhieu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dinhhieu.entities.Student;
import dinhhieu.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	
	public void save(Student student) {
		studentRepo.save(student);
	}
	
	public Student findByEmail(String email) {
		Student student = studentRepo.findByEmail(email);
		System.out.println("Xem thay khong " +student.getName());
		return student;
	}
	
	public List<Student> getAllStudent(){
		List<Student> students = studentRepo.findAll();
		return students;
	}

}
