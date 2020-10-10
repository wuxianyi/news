package com.bdqn.service;

import com.bdqn.entity.ENews;
import com.bdqn.util.PageUtil;
import com.bdqn.vo.ENewsSearchVo;

public interface ENewsService {

	/**
	 * 分页
	 * @param currPage
	 * @param pageSize
	 * @param svo
	 * @return
	 */
	PageUtil pageFind(int currPage, int pageSize, ENewsSearchVo svo);

	/**
	 * 添加
	 * @param news
	 */
	void addNews(ENews news);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	ENews findById(Integer id);
	
	/**
	 * 修改
	 * @param news
	 */
	void updateNews(ENews news);
	
	/**
	 * 状态删除
	 * @param news
	 */
	void deleteNews(ENews news);
}