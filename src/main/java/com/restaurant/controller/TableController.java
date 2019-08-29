package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.restaurant.entity.Table;
import com.restaurant.service.ITableService;

@CrossOrigin
@Controller
public class TableController {

	@Autowired
	private ITableService its;
	
	/**
	 * 分页查询已使用的餐桌
	 * @param tableState 餐桌编号
	 * @param page 页码
	 * @param pageSize 页面大小
	 * @return 返回list
	 */
	@RequestMapping("/desk/tables4.action")
	public @ResponseBody PageInfo<Table> showTables(String tableCode,Integer tableState, Integer page, Integer pageSize){
		PageInfo<Table> pageList=null;
		if(tableCode == null && tableState == 1) {
			 pageList = its.showTables(tableState, page, pageSize);
		}else if(tableCode != null && tableState == 1){
			 pageList = its.selectTableLike("%"+tableCode+"%", tableState, page, pageSize);
		}else if(tableCode == null && tableState == 0) {
			pageList = its.showTables(tableState, page, pageSize);
		}else if(tableCode != null && tableState == 0) {
			pageList = its.selectTableLike("%"+tableCode+"%", tableState, page, pageSize);
		}
		System.out.println("pageList:"+pageList);
		System.out.println("tableCode:=="+tableCode);
		System.out.println("tableState:=="+tableState);
		return pageList;
	}
	
	
	@RequestMapping("/desk/updateTableState.action")
	public String updateState(Integer tableState, String tableCode) {
		its.updateState(tableState, tableCode);
		return "/desk/tables4.action";		
	}
}
