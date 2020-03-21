package com.atguigu.bean;

import java.sql.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
/**
 * 员工表
 * @author 李宗效
 */
public class Employee {

	private Integer id;
	
	@NotEmpty
	@Length(min=6,max=18)
	private String lastName;
	
	@Email
	private String email;
	
	//1 male, 0 female
	private Integer gender;
	
	//@Past，必须是过去的时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	private Date birth;

	@NumberFormat(pattern="#,###,##")
	private Double salary;
	
	private Department department;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee(Integer id, @NotEmpty @Length(min = 6, max = 18) String lastName, @Email String email,
			Integer gender, @Past Date birth, Double salary, Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.birth = birth;
		this.salary = salary;
		this.department = department;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", birth="
				+ birth + ", salary=" + salary + ", department=" + department + "]";
	}

}
