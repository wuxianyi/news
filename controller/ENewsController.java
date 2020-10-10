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

import com.bdqn.constants.EmpConstants;
import com.bdqn.entity.ENews;
import com.bdqn.service.ENewsService;
import com.bdqn.util.PageUtil;
import com.bdqn.vo.ENewsSearchVo;

@Controller
public class ENewsController {

	@Autowired
	private ENewsService newsService;
	
	@RequestMapping("/newss")
	public String pageFind(@RequestParam(defaultValue="1")int currPage, @RequestParam(defaultValue="5")int pageSize, ENewsSearchVo svo,Model model,HttpSession session){
		int deptId = Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_DEPTID));
		int isCharge =Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_ISCHARGE));
		int createId =Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_CREATEID));
		svo.setDeptId(deptId);
		svo.setIsCharge(isCharge);
		svo.setCreateId(createId);
		PageUtil pageUtil = newsService.pageFind(currPage, pageSize, svo);
		model.addAttribute("pageUtil", pageUtil);
		model.addAttribute("svo", svo);
		return "news/news_list";
	}
	
	@GetMapping("/news")
	public String toAddNewsPage(){
		return "news/news_add";
	}
	
	@PostMapping("/news")
	public String addNews(ENews news,HttpSession session){
		//获取登录用户的id
		int createId =Integer.parseInt((String) session.getAttribute(EmpConstants.CURRENT_USER_CREATEID));
		news.setCreateId(createId);
		newsService.addNews(news);
		return "redirect:newss";
	}
	
	@GetMapping("/news/{id}")
	public String toUpdateNewsPage(@PathVariable Integer id,Model model){
		ENews news = newsService.findById(id);
		model.addAttribute("news", news);
		return "news/news_update";
	}
	
	@PutMapping("/news")
	public String updateNews(ENews news){
		newsService.updateNews(news);
		return "redirect:newss";
	}
	
	@DeleteMapping("/news/{id}")
	public String deleteNews(@PathVariable Integer id){
		ENews news = new ENews();
		news.setId(id);
		newsService.deleteNews(news);
		return "redirect:../newss";
	}
}
