package com.chitransh.jpaApp;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chitransh.jpaApp.model.Student;
import com.chitransh.jpaApp.repositories.StudentRepository;

public class StudentPersistenceTest extends ParentTest{
	
	@Autowired
	private StudentRepository studentRepository;
	
	//@Test
	public void testStudentCreation(){
		Student student =new Student("Chitransh","Selwaria","A", LocalDateTime.of(2016,01,28,02,30));
		Student createdStudent = studentRepository.save(student);
		assertNotNull("used id not present", createdStudent.getStudentId());
		
	}
	
	@Test
	public void testFindStudentById(){
		Student student = studentRepository.findOne(1L);
		assertNotEquals("student name not present", student.getFirstName());
	}
	
	@Test
	public void testFindAll(){
		List<Student> students = studentRepository.findAll();
		assertTrue("student list is empty", students.size()>0);
	}
	
	@Test
	public void testUpdateStudent(){
		Student student = studentRepository.findOne(1L);
		student.setLastName("Jain");
		Student updateStudent = studentRepository.save(student);
		assertEquals("Jain", updateStudent.getLastName());
	}
	
	//@Test
	public void testDeleteStudent(){
		Student student = studentRepository.findOne(1L);
		studentRepository.delete(student);
		Student delStudent = studentRepository.findOne(1L);
		assertNull("student seems to be not deleted", delStudent);
	}
	
	@Test
	public void testFindByLastName(){
		List<Student> students = studentRepository.findByLastName("Jain");
		assertTrue("student List is empty", students.size()>0);
	}
	
	@Test
	public void testCountByLastName(){
		Long count =  studentRepository.countByLastName("Jain");
		assertTrue("student list is empty", count>0);
	}
	
	@Test 
	public void testFindByFirstNameandLastName(){
		Optional<Student> studentOptional = studentRepository.findByFirstNameAndLastName("Chitransh", "Jain");
		assertTrue("student not found with the specified first and last name", studentOptional.isPresent());
	}
	
	@Test
	public void testFindByFirstNameOrLastName(){
		List<Student> students = studentRepository.findByFirstNameOrLastName("Chitransh", "Jain");
		assertTrue("student list is empty", students.size()>0);
	}
	
	@Test
	public void testFindDistinctByFirstName(){
		List<Student> students = studentRepository.findDistinctByFirstName("Chitransh");
		assertTrue("students list is empty", students.size()>0);
	}
	
	@Test
	public void testfindFirst3ByLastNameOrderByFirstNameAsc(){
		List<Student> students = studentRepository.findFirst3ByLastNameOrderByFirstNameAsc("Jain");
		assertTrue("student list is empty", students.size()>0);
	}
	
	

}
