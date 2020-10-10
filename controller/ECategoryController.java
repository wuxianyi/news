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
import com.bdqn.entity.ECategory;
import com.bdqn.service.ECategoryService;
import com.bdqn.util.PageUtil;
import com.bdqn.vo.AuthorityVo;
import com.bdqn.vo.ECategorySearchVo;

@Controller
public class ECategoryController {

	@Autowired
	private ECategoryService categoryService;
	
	@RequestMapping("/categories")
	public String pageFind(@RequestParam(defaultValue="1")int currPage,@RequestParam(defaultValue="5")int pageSize,ECategorySearchVo svo,Model model,HttpSession session){
		int deptId = Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_DEPTID));
		int isCharge =Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_ISCHARGE));
		svo.setDeptId(deptId);
		svo.setIsCharge(isCharge);
		PageUtil pageUtil = categoryService.pageFind(currPage, pageSize, svo);
		model.addAttribute("pageUtil", pageUtil);
		model.addAttribute("category", svo);
		return "category/category_list";
	}
	
	@GetMapping("/category")
	public String toAddCategoryPage(){
		return "category/category_add";
	}
	
	@PostMapping("/category")
	public String addCategory(ECategory category, HttpSession session){
		//获取登录用户的id
		int createId =Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_CREATEID));
		category.setCreateId(createId);
		
		categoryService.insert(category);
		return "redirect:categories";
	}
	
	@ResponseBody
	@RequestMapping("/checkCategoryName")
	public String checkCategoryName(@RequestParam(name="param")String categoryName){
		String flag = categoryService.checkCategoryName(categoryName);
		return flag;
	}
	
	@GetMapping("/category/{id}")
	public String toUpdateCategory(@PathVariable Integer id,Model model){
		ECategory category = categoryService.findById(id);
		model.addAttribute("category", category);
		return "category/category_update";
	}
	
	@PutMapping("/category")
	public String updateCategory(ECategory category){
		categoryService.updateCategory(category);
		return "redirect:categories";
	}
	
	@DeleteMapping("/category/{id}")
	public String deleteCategory(@PathVariable Integer id){
		ECategory category = new ECategory();
		category.setId(id);
		categoryService.deleteCategory(category);
		return "redirect:../categories";
	}
	
	@ResponseBody
	@RequestMapping("/findAllCategory")
	public String findAllCategory(AuthorityVo vo,HttpSession session){
		int deptId = Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_DEPTID));
		int isCharge =Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_ISCHARGE));
		int createId =Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_CREATEID));
		vo.setDeptId(deptId);
		vo.setIsCharge(isCharge);
		vo.setCreateId(createId);
		String allCategory = categoryService.findAllCategory(vo);
		return allCategory;
	}
}
