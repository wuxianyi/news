package com.bdqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bdqn.constants.NewsConstants;
import com.bdqn.entity.ENews;
import com.bdqn.mapper.ENewsMapper;
import com.bdqn.util.PageUtil;
import com.bdqn.vo.ENewsSearchVo;
import com.bdqn.vo.ENewsVo;

@Service
public class ENewsServiceImpl implements ENewsService {

	@Autowired
	private ENewsMapper newsMapper;
	
	/* (non-Javadoc)
	 * @see com.bdqn.service.ENewsService#pageFind(int, int, com.bdqn.vo.ENewsSearchVo)
	 */
	@Override
	public PageUtil pageFind(int currPage, int pageSize, ENewsSearchVo svo){
		List<ENewsVo> list = newsMapper.pageFind(currPage, pageSize, svo);
		int count = newsMapper.pageFindCount(svo);
		PageUtil pageUtil = new PageUtil(currPage, pageSize, count, list);
		return pageUtil;
	}

	@Override
	public void addNews(ENews news) {
		newsMapper.insert(news);
	}

	@Override
	public ENews findById(Integer id) {
		ENews news = newsMapper.selectByPrimaryKey(id);
		return news;
	}

	@Override
	public void updateNews(ENews news) {
		newsMapper.updateByPrimaryKeySelective(news);
	}

	@Override
	public void deleteNews(ENews news) {
		news.setStatus(NewsConstants.STATUS_DELETE);
		newsMapper.updateByPrimaryKeySelective(news);
	}
}
