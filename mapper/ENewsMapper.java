package com.bdqn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bdqn.entity.ENews;
import com.bdqn.vo.ENewsSearchVo;
import com.bdqn.vo.ENewsVo;

public interface ENewsMapper extends BaseMapper<ENews>{
    /**
     * 分页
     * @param currPage
     * @param pageSize
     * @param svo
     * @return
     */
	List<ENewsVo> pageFind(@Param("currPage")int currPage, @Param("pageSize")int pageSize, @Param("svo")ENewsSearchVo svo);
	
	/**
	 * 根据条件查询到总条数
	 * @param svo
	 * @return
	 */
	int pageFindCount(@Param("svo")ENewsSearchVo svo);
	
	
}