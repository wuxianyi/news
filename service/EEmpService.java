package com.bdqn.service;

import org.apache.ibatis.annotations.Param;

import com.bdqn.entity.EEmp;
import com.bdqn.util.PageUtil;
import com.bdqn.vo.EEmpSearchVo;

public interface EEmpService {

	/**
	 * 分页查询
	 * @param currPage
	 * @param pageSize
	 * @param svo
	 * @return
	 */
	PageUtil pageFind(int currPage, int pageSize, EEmpSearchVo svo);

	/**
	 * 添加
	 * @param emp
	 */
	void addEmp(EEmp emp);
	
	/**
	 * 查重
	 * @param username
	 * @return
	 */
	String checkUsername(String username);
	
	/**
	 * 根据id查找 
	 * @param id
	 * @return
	 */
	EEmp findById(Integer id);
	
	/**
	 * 修改
	 * @param emp
	 */
	void updateEmp(EEmp emp);
	
	/**
	 * 状态删除
	 * @param emp
	 */
	void deleteEmp(EEmp emp);
	
	/**
	 * 根据用户名和密码查找
	 * @param username
	 * @param password
	 * @return
	 */
	EEmp findByUsernameAndPwd(String username,String password);
}