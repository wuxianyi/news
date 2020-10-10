package com.bdqn.controller;

import java.util.List;

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
import com.bdqn.entity.EDept;
import com.bdqn.service.EDeptService;
import com.bdqn.util.PageUtil;

@Controller
public class EDeptController {

	@Autowired
	private EDeptService deptService;
	
	@RequestMapping("depts")
	public String pageFind(@RequestParam(defaultValue="1")int currPage,@RequestParam(defaultValue="5")int pageSize,EDept dept,Model model){
		PageUtil pageUtil = deptService.pageFind(currPage, pageSize, dept);
		model.addAttribute("pageUtil", pageUtil);
		model.addAttribute("dept", dept);
		return "dept/dept_list";
	}
	
	@GetMapping("dept")
	public String toAddDeptPage(){
		return "dept/dept_add";
	}
	
	@ResponseBody
	@RequestMapping("checkName")
	public String checkName(@RequestParam(name="param")String name){
		String flag = deptService.checkName(name);
		return flag;
	}
	
	@PostMapping("dept")
	public String addDept(EDept dept){
		deptService.insert(dept);
		return "redirect:depts";
	}
	
	@GetMapping("dept/{id}")
	public String toUpdateDeptPage(@PathVariable Integer id,Model model){
		EDept dept = deptService.selectByPrimaryKey(id);
		model.addAttribute("dept", dept);
		return "dept/dept_update";
	}
	
	@PutMapping("dept")
	public String updateDept(EDept dept){
		deptService.updateByPrimaryKeySelective(dept);
		return "redirect:depts";
	}
	
	@DeleteMapping("dept/{id}")
	public String deleteDept(@PathVariable Integer id){
		EDept dept = new EDept();
		dept.setId(id);
		deptService.deleteById(dept);
		return "redirect:../depts";
	}
	
	@ResponseBody
	@RequestMapping("/findAllDept")
	public String findAllDept(HttpSession session){
		int deptId = Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_DEPTID));
		int isCharge =Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_ISCHARGE));
		String jsonArr = deptService.findAllDept(isCharge,deptId);
		return jsonArr;
	}
}
