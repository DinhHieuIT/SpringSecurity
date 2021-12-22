package dinhhieu.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import dinhhieu.entities.Student;

public class CustomStudentDetails implements UserDetails {
	
	private Student student;
	
	public CustomStudentDetails(Student student) {
		this.student = student;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return null;
	}

	@Override
	public String getPassword() {
		
		return student.getPassword();
	}

	@Override
	public String getUsername() {
		
		return student.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	
}
