package com.atguigu.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.bean.Department;
import com.atguigu.bean.Employee;
import com.atguigu.dao.DepartmentDao;
import com.atguigu.dao.EmployeeDao;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	DepartmentDao departmentDao;
	
	/**
	 * 查询所有员工
	 * @return
	 */
	@RequestMapping("/emps")
	public String getEmps(Model model) {
		Collection<Employee> all = employeeDao.getAll();
		model.addAttribute("emps",all);
		return "list";
	}
	
	/**
	 * 去员工添加页面，之前查询所有部门信息，进行展示
	 * @return
	 */
	@RequestMapping("/toaddpage")
	public String toAddPage(Model model) {
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts",departments);
		model.addAttribute("employee", new Employee());
		return "add";
	}
	
	/**
	 * 保存员工
	 * @return
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String addEmp(Employee employee){
		System.out.println("要添加的员工" + employee);
		employeeDao.save(employee);
		//重定向查询所有员工请求
		return "redirect:/emps";
	}
	
	/**
	 * 查询员工，来到修改页面，回显
	 * @return
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String getEmp(@PathVariable("id")Integer id,Model model){
		//查出员工信息
		Employee employee = employeeDao.get(id);
		//放在请求域中
		model.addAttribute("employee",employee);
		//继续查出部门信息放在隐含域模型中
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts", departments);
		return "edit";
	}
	
	/**
	 * 修改
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.PUT)
	public String updaeEmp(@ModelAttribute("employee")Employee employee){
		System.out.println("要修改的员工" + employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	/**
	 * 提前获取请求id，查询员工
	 * @param id
	 * @param model
	 */
	@ModelAttribute
	public void myModelAttribute(@RequestParam(value="id",required=false)Integer id,Model model) {
		if (id != null) {
			Employee employee = employeeDao.get(id);
			model.addAttribute("employee",employee);
		}
		System.out.println("haha");
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("id")Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
}
