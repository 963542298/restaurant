package com.restaurant.entity;

import java.io.Serializable;

/**
 * 餐桌实体类
 */
public class Table implements Serializable{

	private String tableCode;
	
	private Integer tableState;

	public Table() {
	}

	public Table(String tableCode, Integer tableState) {
		super();
		this.tableCode = tableCode;
		this.tableState = tableState;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public Integer getTableState() {
		return tableState;
	}

	public void setTableState(Integer tableState) {
		this.tableState = tableState;
	}
	
	
}
