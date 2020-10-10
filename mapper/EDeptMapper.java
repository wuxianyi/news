package com.bdqn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.entity.EDept;

public interface EDeptMapper extends BaseMapper<EDept>{
    /**
     * ��ҳ��ѯ
     * @param currPage
     * @param pageSize
     * @param dept
     * @return
     */
	List<EDept> pageFind(@Param("currPage")int currPage,@Param("pageSize")int pageSize,@Param("dept")EDept dept);
	
	/**
	 * ����������ѯ��������
	 * @param dept
	 * @return
	 */
	int pageFindCount(@Param("dept")EDept dept);
	
	/**
	 * ͨ��������������
	 * @param name
	 * @return
	 */
	int checkName(String name);
	
	/**
	 * ��ѯ����
	 * @return
	 */
	List<EDept> findAll(@Param("isCharge")Integer isCharge,@Param("deptId")Integer deptId);
}