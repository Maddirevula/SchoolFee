package com.example.CrudOpearations.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "STTM_STUDENT")
public class Student {
	@Id
	@Column(name = "STUDENT_ID")
	private String studentId;

	@Column(name = "STUDENT_NUMBER")
	private String studentNumber;

	@Column(name = "STUDENT_NAME")
	private String studentName;

	@Column(name = "ST_GRADE")
	private String stGrade;

	@Column(name = "ST_SECTION")
	private String stSection;

	@Column(name = "ST_CATEGORY")
	private String stCategory;

	@Column(name = "REG_DATE")
	private Date regDate;

	@Column(name = "ADDR1")
	private String addr1;

	@Column(name = "ADDR2")
	private String addr2;

	@Column(name = "CITY")
	private String city;

	@Column(name = "PHONE_NO")
	private String phoneNo;

}
