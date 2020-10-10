package com.bdqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.constants.CategoryConstants;
import com.bdqn.entity.ECategory;
import com.bdqn.mapper.ECategoryMapper;
import com.bdqn.util.PageUtil;
import com.bdqn.vo.AuthorityVo;
import com.bdqn.vo.ECategorySearchVo;
import com.bdqn.vo.ECategoryVo;

import net.sf.json.JSONArray;

@Service
public class ECategoryServiceImpl implements ECategoryService {

	@Autowired
	private ECategoryMapper categoryMapper;
	/* (non-Javadoc)
	 * @see com.bdqn.service.ECategoryService#pageFind(int, int, com.bdqn.entity.ECategory)
	 */
	@Override
	public PageUtil pageFind(int currPage,int pageSize,ECategorySearchVo svo){
		List<ECategoryVo> list = categoryMapper.pageFind(currPage, pageSize, svo);
		int count = categoryMapper.pageFindCount(svo);
		PageUtil pageUtil = new PageUtil(currPage, pageSize, count, list);
		return pageUtil;
	}
	@Override
	public void insert(ECategory category) {
		categoryMapper.insert(category);
	}
	@Override
	public void updateCategory(ECategory category) {
		categoryMapper.updateByPrimaryKeySelective(category);
	}
	@Override
	public void deleteCategory(ECategory category) {
		category.setStatus(CategoryConstants.STATUS_DELETE);
		categoryMapper.updateByPrimaryKeySelective(category);
	}
	@Override
	public ECategory findById(int id) {
		ECategory category = categoryMapper.selectByPrimaryKey(id);
		return category;
	}
	@Override
	public String checkCategoryName(String categoryName) {
		int flag = categoryMapper.findByCategoryName(categoryName);
		return flag==0?"y":"该类别名称已存在";
	}
	@Override
	public String findAllCategory(AuthorityVo vo) {
		List<ECategory> list = categoryMapper.findAllCategory(vo);
		JSONArray arr = JSONArray.fromObject(list);
		return arr.toString();
	}
	
	
}
