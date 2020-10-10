package com.bdqn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.entity.ECategory;
import com.bdqn.vo.AuthorityVo;
import com.bdqn.vo.ECategorySearchVo;
import com.bdqn.vo.ECategoryVo;

public interface ECategoryMapper extends BaseMapper<ECategory>{
    /**
     * 分页查询
     * @param currPage
     * @param pageSize
     * @param svo
     * @return
     */
	List<ECategoryVo> pageFind(@Param("currPage")int currPage,@Param("pageSize")int pageSize,@Param("svo")ECategorySearchVo svo);
	
	/**
	 * 根据条件查询到总条数
	 * @param svo
	 * @return
	 */
	int pageFindCount(@Param("svo")ECategorySearchVo svo);
	
	/**
	 * 根据类别名称查询条数
	 * @param categoryName
	 * @return
	 */
	int findByCategoryName(String categoryName);
	
	/**
	 * 根据权限查询所有
	 * @return
	 */
	List<ECategory> findAllCategory(@Param("vo")AuthorityVo vo);
}