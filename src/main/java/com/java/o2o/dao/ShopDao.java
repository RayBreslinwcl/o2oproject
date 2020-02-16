package com.java.o2o.dao;

import com.java.o2o.entitiy.Shop;

/**
 * Created by Administrator on 2020/2/16.
 */
public interface ShopDao {

    /**
     * 新增shop商铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);
}
