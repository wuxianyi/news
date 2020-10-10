package com.bdqn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdqn.constants.EmpConstants;
import com.bdqn.entity.EEmp;
import com.bdqn.service.EEmpService;

@Controller
public class LoginController {

	@Autowired
	private EEmpService empService;
	
	@RequestMapping("/login")
	public String login(String username,String password,HttpSession session,Model model){
		EEmp emp = empService.findByUsernameAndPwd(username, password);
		if(emp != null){
			session.setAttribute(EmpConstants.CURRENT_USER_SESSION_FLAG, emp);
			session.setAttribute(EmpConstants.CURRENT_USER_ISCHARGE, emp.getIsCharge().toString());
			session.setAttribute(EmpConstants.CURRENT_USER_DEPTID, emp.getDeptId().toString());
			session.setAttribute(EmpConstants.CURRENT_USER_CREATEID, emp.getId().toString());
			return "index";
		}
		model.addAttribute("msg", "用户名或密码错误！");
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
	
}
