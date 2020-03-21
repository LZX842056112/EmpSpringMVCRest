package com.atguigu.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.atguigu.bean.Department;

@Repository
public class DepartmentDao {

	private static Map<Integer, Department> departments = null;
	
	static{
		departments = new HashMap<Integer, Department>();
		
		departments.put(101, new Department(101, "D-AA"));
		departments.put(102, new Department(102, "D-BB"));
		departments.put(103, new Department(103, "D-CC"));
		departments.put(104, new Department(104, "D-DD"));
		departments.put(105, new Department(105, "D-EE"));
	}
	/**
	 * 查询所有部门
	 * @return
	 */
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	/**
	 * 根据id查询部门
	 * @param id
	 * @return
	 */
	public Department getDepartment(Integer id){
		return departments.get(id);
	}
	
}
