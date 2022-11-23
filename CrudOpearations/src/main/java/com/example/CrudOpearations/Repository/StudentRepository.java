package com.example.CrudOpearations.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.CrudOpearations.Model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
	@Modifying
	@Transactional
	@Query("update Student st set st.studentName=:studName where st.studentId=:studId")
	public void updateStudById(@Param("studName") String studName, @Param("studId")  String studId);

}
