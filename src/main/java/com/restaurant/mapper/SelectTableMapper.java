package com.restaurant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.restaurant.entity.Table;

public interface SelectTableMapper {

	/**
	 * 根据状态查询 0为未上桌 1为以上桌
	 * @return
	 */
	@Select("select * from tables where tableState=#{tableState}")
	List<Table> selectTable(@Param("tableState") Integer tableState);
	
	/**
	 * 更具桌子编号模糊查询状态为1
	 * @return
	 */
	@Select("select * from tables "
			+ "where tableCode like #{tableCode} "
			+ "and tableState=#{tableState}")
	List<Table> selectTableLike(@Param("tableCode") String tableCode, @Param("tableState") Integer tableState);
	
	/**
	 * 更新状态
	 */
	@Update("update tables set tableState=#{tableState} where tableCode=#{tableCode}")
	int updateState(@Param("tableState") Integer tableState, @Param("tableCode") String tableCode);
}
