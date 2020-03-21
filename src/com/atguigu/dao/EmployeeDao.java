package com.atguigu.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.atguigu.bean.Department;
import com.atguigu.bean.Employee;

@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static{
		employees = new HashMap<Integer, Employee>();

		employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
		employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
		employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
		employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
		employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
	}
	
	private static Integer initId = 1006;
	/**
	 * 保存，修改员工 6
	 * @param employee
	 */
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		//根据部门id查询所在部门信息，设置到员工对象中
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	/**
	 * 查询全部员工信息
	 * @return
	 */
	public Collection<Employee> getAll(){
		return employees.values();
	}
	/**
	 * 根据id查询员工
	 * @param id
	 * @return
	 */
	public Employee get(Integer id){
		return employees.get(id);
	}
	/**
	 * 根据id删除员工
	 * @param id
	 */
	public void delete(Integer id){
		employees.remove(id);
	}
}
