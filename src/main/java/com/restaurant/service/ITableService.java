package com.restaurant.service;

import com.github.pagehelper.PageInfo;
import com.restaurant.entity.Table;

public interface ITableService {

	
	/**
	 *  根据状态分页查询餐桌
	 * @param tableState 餐桌编号
	 * @param page 页码
	 * @param pageSize 页面大小
	 * @return
	 */
	PageInfo<Table> showTables(Integer tableState, Integer page, Integer pageSize);
	
	/**
	 * 根据不同状态查询不同餐桌
	 * @param tableCode 餐桌编号
	 * @param tableState 餐桌状态
	 * @param page 页码
	 * @param pageSize 页面大小
	 * @return 返回list
	 */
	PageInfo<Table> selectTableLike(String tableCode, Integer tableState, Integer page, Integer pageSize);
	
	/**
	 * 更新餐桌状态
	 * @param tableState 餐桌状态
	 * @param tableCode 餐桌编号
	 * @return 
	 */
	int updateState(Integer tableState, String tableCode);
	
}
