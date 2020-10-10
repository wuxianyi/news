package com.bdqn.service;

import java.util.List;

import com.bdqn.entity.EDept;
import com.bdqn.util.PageUtil;

public interface EDeptService {

	/**
	 * ��ҳ��ѯ
	 * @param currPage
	 * @param pageSize
	 * @param dept
	 * @return
	 */
	PageUtil pageFind(int currPage, int pageSize, EDept dept);

	/**
	 * ��鲿�������Ƿ��ظ�
	 * @param name
	 */
	String checkName(String name);
	
	/**
	 * ���
	 * @param dept
	 */
	void insert(EDept dept);

	/**
	 * ѡ�����޸�
	 * @param dept
	 */
	void updateByPrimaryKeySelective(EDept dept);
	
	/**
	 * ͨ��id��ѯ
	 * @param id
	 * @return
	 */
	EDept selectByPrimaryKey (Integer id);
	
	/**
	 * ״̬ɾ��
	 * @param dept
	 */
	void deleteById(EDept dept);
	
	/**
	 * ����Ȩ�޲�ѯ����
	 * @return
	 */
	String findAllDept(Integer isCharge,Integer deptId);
}