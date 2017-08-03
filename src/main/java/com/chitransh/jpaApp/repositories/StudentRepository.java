package com.chitransh.jpaApp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chitransh.jpaApp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	public Optional<Student> findByFirstName(String firstName);
	
	public List<Student> findByLastName(String lastName);
	
	public Long countByLastName(String lastName);
	
	public Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	public List<Student> findByFirstNameOrLastName(String firstName, String lastName);
	
	public List<Student> findDistinctByFirstName(String firstName);
	
	public List<Student> findFirst3ByLastNameOrderByFirstNameAsc(String lName);
}
