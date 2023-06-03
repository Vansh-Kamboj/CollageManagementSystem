package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
//	public List<Student> findAll();
	//public  Student  save(Student student);
//	public Student getByid(Long id);
//	public void deleteById(Long id);

}
