package com.example.Sambook.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository studentRepository;
	
	public List<Student> findAll(){
		List<Student> students = new ArrayList<>();
		
		studentRepository.findAll()
		.forEach(students::add);
		
		return students;
	}
	
	// add student
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	
	// GET student by id
	public Optional<Student> getStudent(String id){
		return studentRepository.findById(id);
	}
	
	// update student
	public void updateStudent(String id, Student student) {
		studentRepository.save(student);
	}
	
	// delete student
	public void deleteStudent(String id) {
		studentRepository.deleteById(id);
	}

}
