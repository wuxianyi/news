package com.bdqn.service;

import java.util.List;

import com.bdqn.entity.EDept;
import com.bdqn.util.PageUtil;

public interface EDeptService {

	/**
	 * 分页查询
	 * @param currPage
	 * @param pageSize
	 * @param dept
	 * @return
	 */
	PageUtil pageFind(int currPage, int pageSize, EDept dept);

	/**
	 * 检查部门名称是否重复
	 * @param name
	 */
	String checkName(String name);
	
	/**
	 * 添加
	 * @param dept
	 */
	void insert(EDept dept);

	/**
	 * 选择性修改
	 * @param dept
	 */
	void updateByPrimaryKeySelective(EDept dept);
	
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	EDept selectByPrimaryKey (Integer id);
	
	/**
	 * 状态删除
	 * @param dept
	 */
	void deleteById(EDept dept);
	
	/**
	 * 根据权限查询所有
	 * @return
	 */
	String findAllDept(Integer isCharge,Integer deptId);
}