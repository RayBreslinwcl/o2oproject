package com.java.o2o.dao;

import com.java.o2o.BaseTest;
import com.java.o2o.entitiy.Area;
import com.java.o2o.entitiy.PersonInfo;
import com.java.o2o.entitiy.Shop;
import com.java.o2o.entitiy.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Administrator on 2020/2/16.
 */
public class ShopDaoTest extends BaseTest {

    @Autowired
    private ShopDao shopDao;

    /**
     * 插入
     */
//    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2L);

        //设置shop
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("testaddr1");

        shop.setPhone("1388888888");
        shop.setShopImg("test1");
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");

        int effectedNum = shopDao.insertShop(shop);
        Assert.assertEquals(1, effectedNum);
        /**
         * 测试：成功
         * DBC Connection [com.mchange.v2.c3p0.impl.NewProxyConnection@59e32960] will not be managed by Spring
         ==>  Preparing: INSERT INTO tb_shop(owner_id,area_id,shop_category_id, shop_name,shop_desc,shop_addr,phone,shop_img, priority,create_time,last_edit_time, enable_status,advice) VALUES (?,?,?, ?,?,?,?,?, ?,?,?, ?,?)
         ==> Parameters: 1(Long), 2(Long), null, 测试的店铺(String), test(String), testaddr1(String), 1388888888(String), test1(String), null, 2020-02-16 11:03:56.083(Timestamp), 2020-02-16 11:03:56.083(Timestamp), 1(Integer), 审核中(String)
         <==    Updates: 1
         Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@2474f125]
         */
    }


    @Test
    /**
     * 更新
     */
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(29L);
//        PersonInfo owner = new PersonInfo();
//        Area area = new Area();
//        ShopCategory shopCategory = new ShopCategory();
//        owner.setUserId(1L);
//        area.setAreaId(3L);

        //设置shop
//        shop.setOwner(owner);
//        shop.setArea(area);
//        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test：更新为中文");
        shop.setShopAddr("testaddr1：更新为中文");
        shop.setLastEditTime(new Date());
//        shop.setEnableStatus(1);
//        shop.setAdvice("审核中");

        int effectedNum = shopDao.updateShop(shop);
        Assert.assertEquals(1, effectedNum);

        /**
         * 测试成功
         * JDBC Connection [com.mchange.v2.c3p0.impl.NewProxyConnection@c7ba306] will not be managed by Spring
         ==>  Preparing: UPDATE tb_shop SET shop_name=?, shop_desc=?, shop_addr=?, last_edit_time=? WHERE shop_id=?
         ==> Parameters: 测试的店铺(String), test：更新为中文(String), testaddr1：更新为中文(String), 2020-02-16 11:31:01.653(Timestamp), 29(Long)
         <==    Updates: 1
         Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@732d0d24]
         */
    }

}
