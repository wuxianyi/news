package com.bdqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.constants.EmpConstants;
import com.bdqn.entity.EEmp;
import com.bdqn.mapper.EEmpMapper;
import com.bdqn.util.PageUtil;
import com.bdqn.vo.EEmpSearchVo;
import com.bdqn.vo.EEmpVo;

@Service
public class EEmpServiceImpl implements EEmpService {

	@Autowired
	private EEmpMapper empMapper;
	
	/* (non-Javadoc)
	 * @see com.bdqn.service.EEmpService#pageFind(int, int, com.bdqn.vo.EEmpSearchVo)
	 */
	@Override
	public PageUtil pageFind(int currPage, int pageSize, EEmpSearchVo svo){
		List<EEmpVo> list = empMapper.pageFind(currPage, pageSize, svo);
		int count = empMapper.pageFindCount(svo);
		PageUtil pageUtil = new PageUtil(currPage, pageSize, count, list);
		return pageUtil;
	}

	@Override
	public void addEmp(EEmp emp) {
		empMapper.insert(emp);
	}

	@Override
	public String checkUsername(String username) {
		int flag = empMapper.findByUsername(username);
		return flag==0?"y":"该用户名已存在";
	}

	@Override
	public EEmp findById(Integer id) {
		EEmp emp = empMapper.selectByPrimaryKey(id);
		return emp;
	}

	@Override
	public void updateEmp(EEmp emp) {
		empMapper.updateByPrimaryKeySelective(emp);
	}

	@Override
	public void deleteEmp(EEmp emp) {
		emp.setStatus(EmpConstants.STATUS_DELETE);
		empMapper.updateByPrimaryKeySelective(emp);
	}

	@Override
	public EEmp findByUsernameAndPwd(String username, String password) {
		EEmp emp = empMapper.findByUsernameAndPwd(username, password);
		return emp;
	}

	
	
}
