package dinhhieu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import dinhhieu.entities.Student;
import dinhhieu.repository.StudentRepository;

public class CustomStudentDetailsService implements UserDetailsService {
    
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Student student = studentRepo.findByEmail(email);
		if(student == null) {
			throw new UsernameNotFoundException("Email not found");
		}
		return new CustomStudentDetails(student);
	}

}
