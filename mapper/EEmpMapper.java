package com.bdqn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.entity.EEmp;
import com.bdqn.vo.EEmpSearchVo;
import com.bdqn.vo.EEmpVo;

public interface EEmpMapper  extends BaseMapper<EEmp> {
    /**
     * 分页查询
     * @param currPage
     * @param pageSize
     * @param emp
     * @return
     */
	List<EEmpVo> pageFind(@Param("currPage")int currPage,@Param("pageSize")int pageSize,@Param("svo")EEmpSearchVo svo);
	
	/**
	 * 根据条件查询到总条数
	 * @param emp
	 * @return
	 */
	int pageFindCount(@Param("svo")EEmpSearchVo svo);
	
	/**
	 * 根据用户名查询是否存在
	 * @param username
	 * @return
	 */
	int findByUsername(String username);
	
	/**
	 * 根据用户名和密码查找
	 * @param username
	 * @param password
	 * @return
	 */
	EEmp findByUsernameAndPwd(@Param("username")String username,@Param("password")String password);
}