package com.bdqn.mapper;

public interface BaseMapper<E> {

	int deleteByPrimaryKey(Integer id);

    int insert(E record);

    int insertSelective(E record);

    E selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(E record);

    int updateByPrimaryKey(E record);
}
