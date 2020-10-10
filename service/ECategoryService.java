package com.bdqn.service;

import com.bdqn.entity.ECategory;
import com.bdqn.util.PageUtil;
import com.bdqn.vo.AuthorityVo;
import com.bdqn.vo.ECategorySearchVo;

public interface ECategoryService {

	/**
	 * ��ҳ��ѯ
	 * @param currPage
	 * @param pageSize
	 * @param category
	 * @return
	 */
	PageUtil pageFind(int currPage, int pageSize, ECategorySearchVo svo);
	
	/**
	 * ���
	 * @param category
	 */
	void insert(ECategory category);
	
	/**
	 * �޸�
	 * @param category
	 */
	void updateCategory(ECategory category);
	
	/**
	 * ״̬ɾ��
	 * @param category
	 */
	void deleteCategory(ECategory category);

	/**
	 * ͨ��id����
	 * @param id
	 * @return
	 */
	ECategory findById(int id);
	
	/**
	 * ����������Ʋ�ѯ����
	 * @param categoryName
	 * @return
	 */
	String checkCategoryName(String categoryName);
	
	/**
	 * ����jsonArr
	 * @return
	 */
	String findAllCategory(AuthorityVo vo);
}