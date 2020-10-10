package com.bdqn.service;

import com.bdqn.entity.ECategory;
import com.bdqn.util.PageUtil;
import com.bdqn.vo.AuthorityVo;
import com.bdqn.vo.ECategorySearchVo;

public interface ECategoryService {

	/**
	 * 分页查询
	 * @param currPage
	 * @param pageSize
	 * @param category
	 * @return
	 */
	PageUtil pageFind(int currPage, int pageSize, ECategorySearchVo svo);
	
	/**
	 * 添加
	 * @param category
	 */
	void insert(ECategory category);
	
	/**
	 * 修改
	 * @param category
	 */
	void updateCategory(ECategory category);
	
	/**
	 * 状态删除
	 * @param category
	 */
	void deleteCategory(ECategory category);

	/**
	 * 通过id查找
	 * @param id
	 * @return
	 */
	ECategory findById(int id);
	
	/**
	 * 根据类别名称查询条数
	 * @param categoryName
	 * @return
	 */
	String checkCategoryName(String categoryName);
	
	/**
	 * 返回jsonArr
	 * @return
	 */
	String findAllCategory(AuthorityVo vo);
}