package com.bdqn.service;

import org.apache.ibatis.annotations.Param;

import com.bdqn.entity.EEmp;
import com.bdqn.util.PageUtil;
import com.bdqn.vo.EEmpSearchVo;

public interface EEmpService {

	/**
	 * ��ҳ��ѯ
	 * @param currPage
	 * @param pageSize
	 * @param svo
	 * @return
	 */
	PageUtil pageFind(int currPage, int pageSize, EEmpSearchVo svo);

	/**
	 * ���
	 * @param emp
	 */
	void addEmp(EEmp emp);
	
	/**
	 * ����
	 * @param username
	 * @return
	 */
	String checkUsername(String username);
	
	/**
	 * ����id���� 
	 * @param id
	 * @return
	 */
	EEmp findById(Integer id);
	
	/**
	 * �޸�
	 * @param emp
	 */
	void updateEmp(EEmp emp);
	
	/**
	 * ״̬ɾ��
	 * @param emp
	 */
	void deleteEmp(EEmp emp);
	
	/**
	 * �����û������������
	 * @param username
	 * @param password
	 * @return
	 */
	EEmp findByUsernameAndPwd(String username,String password);
}