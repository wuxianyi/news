package com.bdqn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdqn.constants.EmpConstants;
import com.bdqn.entity.EEmp;
import com.bdqn.service.EEmpService;
import com.bdqn.util.PageUtil;
import com.bdqn.vo.EEmpSearchVo;

@Controller
public class EEmpController {

	@Autowired
	private EEmpService empService;
	
	@RequestMapping("/emps")
	public String pageFind(@RequestParam(defaultValue="1")int currPage, @RequestParam(defaultValue="5")int pageSize, EEmpSearchVo svo,Model model,HttpSession session){
		int deptId = Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_DEPTID));
		int isCharge =Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_ISCHARGE));
		svo.setDeptId(deptId);
		svo.setIsCharge(isCharge);
		PageUtil pageUtil = empService.pageFind(currPage, pageSize, svo);
		model.addAttribute("pageUtil", pageUtil);
		model.addAttribute("svo", svo);
		return "emp/emp_list";
	}
	
	@GetMapping("/emp")
	public String toAddEmp(){
		return "emp/emp_add";
	}
	
	@PostMapping("/emp")
	public String addEmp(EEmp emp){
		empService.addEmp(emp);
		return "redirect:emps";
	}
	
	@ResponseBody
	@RequestMapping("/checkUsername")
	public String checkUsername(@RequestParam(name="param")String username){
		String flag = empService.checkUsername(username);
		return flag;
	}
	
	@GetMapping("/emp/{id}")
	public String toUpdateEmp(@PathVariable Integer id,Model model){
		EEmp emp = empService.findById(id);
		model.addAttribute("emp", emp);
		return "emp/emp_update";
	}
	
	@PutMapping("/emp")
	public String updateEmp(EEmp emp){
		empService.updateEmp(emp);
		return "redirect:emps";
	}
	
	@DeleteMapping("/emp/{id}")
	public String deleteEmp(@PathVariable Integer id){
		EEmp emp = new EEmp();
		emp.setId(id);
		empService.deleteEmp(emp);
		return "redirect:../emps";
	}
}
