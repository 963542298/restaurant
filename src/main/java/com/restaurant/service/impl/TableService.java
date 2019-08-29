package com.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.restaurant.entity.Table;
import com.restaurant.mapper.SelectTableMapper;
import com.restaurant.service.ITableService;

@Service
public class TableService implements ITableService{

	@Autowired
	private SelectTableMapper stm;

	/**
	 * 分页查询餐桌
	 */
	@Override
	public PageInfo<Table> showTables(Integer tableState, Integer page, Integer pageSize) {
		page = page == null ? 1 : page;
		pageSize = pageSize == null ? 10: pageSize;
		System.out.println(page + "--"+pageSize);
		//在帮助类中传入分页参数
		PageHelper.startPage(page, pageSize);
		List<Table> list = stm.selectTable(tableState);
		System.out.println("list  :  "+list);
		PageInfo<Table> pageList = new PageInfo<Table>(list);
		return pageList;
	}

	/**
	 * 模糊查询
	 */
	@Override
	public PageInfo<Table> selectTableLike(String tableCode, Integer tableState, Integer page, Integer pageSize) {
		page = page == null ? 1 : page;
		pageSize = pageSize == null ? 10: pageSize;
		System.out.println(page + "--"+pageSize);
		//在帮助类中传入分页参数
		PageHelper.startPage(page, pageSize);
		List<Table> list =stm.selectTableLike("%"+tableCode+"%", tableState);
		System.out.println("list  :  "+list);
		PageInfo<Table> pageList = new PageInfo<Table>(list);
		return pageList;
	}

	/**
	 * 根据餐桌编号来改变餐桌的状态
	 */
	@Override
	public int updateState(Integer tableState, String tableCode) {
		return stm.updateState(tableState, tableCode);
	}
	
}
