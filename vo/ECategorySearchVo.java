package com.bdqn.vo;

import com.bdqn.entity.ECategory;

public class ECategorySearchVo{

	//Ȩ�ޱ���
	private Integer isCharge;
	private Integer deptId;
	//��������
	private String categoryName;
	public Integer getIsCharge() {
		return isCharge;
	}
	public void setIsCharge(Integer isCharge) {
		this.isCharge = isCharge;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
