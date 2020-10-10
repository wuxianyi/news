package com.bdqn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.entity.ECategory;
import com.bdqn.vo.AuthorityVo;
import com.bdqn.vo.ECategorySearchVo;
import com.bdqn.vo.ECategoryVo;

public interface ECategoryMapper extends BaseMapper<ECategory>{
    /**
     * ��ҳ��ѯ
     * @param currPage
     * @param pageSize
     * @param svo
     * @return
     */
	List<ECategoryVo> pageFind(@Param("currPage")int currPage,@Param("pageSize")int pageSize,@Param("svo")ECategorySearchVo svo);
	
	/**
	 * ����������ѯ��������
	 * @param svo
	 * @return
	 */
	int pageFindCount(@Param("svo")ECategorySearchVo svo);
	
	/**
	 * ����������Ʋ�ѯ����
	 * @param categoryName
	 * @return
	 */
	int findByCategoryName(String categoryName);
	
	/**
	 * ����Ȩ�޲�ѯ����
	 * @return
	 */
	List<ECategory> findAllCategory(@Param("vo")AuthorityVo vo);
}