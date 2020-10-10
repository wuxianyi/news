package com.bdqn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.entity.EEmp;
import com.bdqn.vo.EEmpSearchVo;
import com.bdqn.vo.EEmpVo;

public interface EEmpMapper  extends BaseMapper<EEmp> {
    /**
     * ��ҳ��ѯ
     * @param currPage
     * @param pageSize
     * @param emp
     * @return
     */
	List<EEmpVo> pageFind(@Param("currPage")int currPage,@Param("pageSize")int pageSize,@Param("svo")EEmpSearchVo svo);
	
	/**
	 * ����������ѯ��������
	 * @param emp
	 * @return
	 */
	int pageFindCount(@Param("svo")EEmpSearchVo svo);
	
	/**
	 * �����û�����ѯ�Ƿ����
	 * @param username
	 * @return
	 */
	int findByUsername(String username);
	
	/**
	 * �����û������������
	 * @param username
	 * @param password
	 * @return
	 */
	EEmp findByUsernameAndPwd(@Param("username")String username,@Param("password")String password);
}