package com.bdqn.service;

import com.bdqn.entity.ENews;
import com.bdqn.util.PageUtil;
import com.bdqn.vo.ENewsSearchVo;

public interface ENewsService {

	/**
	 * ��ҳ
	 * @param currPage
	 * @param pageSize
	 * @param svo
	 * @return
	 */
	PageUtil pageFind(int currPage, int pageSize, ENewsSearchVo svo);

	/**
	 * ���
	 * @param news
	 */
	void addNews(ENews news);
	
	/**
	 * ����id����
	 * @param id
	 * @return
	 */
	ENews findById(Integer id);
	
	/**
	 * �޸�
	 * @param news
	 */
	void updateNews(ENews news);
	
	/**
	 * ״̬ɾ��
	 * @param news
	 */
	void deleteNews(ENews news);
}