package dinhhieu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dinhhieu.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT u FROM Student u WHERE u.email =  :email") 
	public Student findByEmail(@Param("email") String email);
	
	
}
