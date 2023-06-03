//package com.example.demo.repo;
//
//public interface StudentRepository {
//
//}
package com.example.demo.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long>{
//	public List<Student> findAll();
	//public  Student  save(Student student);
//	public Student getByid(Long id);
//	public void deleteById(Long id);

}
