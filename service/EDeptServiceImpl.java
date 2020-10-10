package com.bdqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.constants.DeptConstants;
import com.bdqn.entity.EDept;
import com.bdqn.mapper.EDeptMapper;
import com.bdqn.util.PageUtil;

import net.sf.json.JSONArray;

@Service
public class EDeptServiceImpl implements EDeptService {

	@Autowired
	private EDeptMapper deptMapper;
	
	/* (non-Javadoc)
	 * @see com.bdqn.service.EDeptService#pageFind(int, int, com.bdqn.entity.EDept)
	 */
	@Override
	public PageUtil pageFind(int currPage,int pageSize,EDept dept){
		List<EDept> list = deptMapper.pageFind(currPage, pageSize, dept);
		int count = deptMapper.pageFindCount(dept);
		PageUtil pageUtil = new PageUtil(currPage, pageSize, count, list);
		return pageUtil;
	}
	@Override
	public String checkName(String name) {
		int flag = deptMapper.checkName(name);
		return flag==0?"y":"该部门已存在";
	}
	@Override
	public void insert(EDept dept) {
		deptMapper.insert(dept);
	}
	@Override
	public void updateByPrimaryKeySelective(EDept dept) {
		deptMapper.updateByPrimaryKeySelective(dept);
	}
	@Override
	public EDept selectByPrimaryKey(Integer id) {
		EDept dept = deptMapper.selectByPrimaryKey(id);
		return dept;
	}
	@Override
	public void deleteById(EDept dept) {
		dept.setStatus(DeptConstants.DEPT_STATUS_DELETE);
		deptMapper.updateByPrimaryKeySelective(dept);
	}
	@Override
	public String findAllDept(Integer isCharge,Integer deptId) {
		List<EDept> list = deptMapper.findAll(isCharge,deptId);
		JSONArray arr = JSONArray.fromObject(list);
		return arr.toString();
	}
}
