package com.bdqn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.entity.EDept;

public interface EDeptMapper extends BaseMapper<EDept>{
    /**
     * 分页查询
     * @param currPage
     * @param pageSize
     * @param dept
     * @return
     */
	List<EDept> pageFind(@Param("currPage")int currPage,@Param("pageSize")int pageSize,@Param("dept")EDept dept);
	
	/**
	 * 根据条件查询到总条数
	 * @param dept
	 * @return
	 */
	int pageFindCount(@Param("dept")EDept dept);
	
	/**
	 * 通过姓名查找条数
	 * @param name
	 * @return
	 */
	int checkName(String name);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<EDept> findAll(@Param("isCharge")Integer isCharge,@Param("deptId")Integer deptId);
}