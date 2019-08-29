package com.restaurant.service.impl;

import com.restaurant.entity.Details;
import com.restaurant.entity.Food;
import com.restaurant.entity.WrapperUtil;
import com.restaurant.mapper.DetailsMapper;
import com.restaurant.service.IDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsService implements IDetailsService {

    @Autowired
    private DetailsMapper detailsMapper;

    @Override
    public List<Details> queryDetailsByOrdersId(Integer ordersid) {
        return detailsMapper.queryDetailsByOrdersId(ordersid);
    }

    /**
     * 插入订单详情
     * @param wrapperUtil
     * @return
     */
    public int addDetails(WrapperUtil wrapperUtil){
        return detailsMapper.addDetails(
                wrapperUtil.getOrderid(), wrapperUtil.getFoodList(), wrapperUtil.getIntegerList());
    }
}
