package com.java.o2o.service;

import com.java.o2o.BaseTest;
import com.java.o2o.dto.ShopExecution;
import com.java.o2o.entitiy.Area;
import com.java.o2o.entitiy.PersonInfo;
import com.java.o2o.entitiy.Shop;
import com.java.o2o.entitiy.ShopCategory;
import com.java.o2o.enums.ShopStateEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Date;

/**
 * Created by Administrator on 2020/2/17.
 */
public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() {
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
        shop.setShopName("测试的店铺2");
        shop.setShopDesc("test2");
        shop.setShopAddr("testaddr2");

        shop.setPhone("1388888888");
        shop.setShopImg("test1");
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setEnableStatus(ShopStateEnum.Check.getState());
        shop.setAdvice("审核中");

        File shopImg=new File("E:/Tools/picture/测试图片1.png");
//        CommonsMultipartFile cmf=new CommonsMultipartFile();
        ShopExecution se = shopService.addShop(shop,shopImg);
        Assert.assertEquals(ShopStateEnum.Check.getState(),se.getState());

        /**
         * 成功
         * Creating a new SqlSession
         Registering transaction synchronization for SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1339e7aa]
         JDBC Connection [com.mchange.v2.c3p0.impl.NewProxyConnection@172b013] will be managed by Spring
         ==>  Preparing: INSERT INTO tb_shop(owner_id,area_id,shop_category_id, shop_name,shop_desc,shop_addr,phone,shop_img, priority,create_time,last_edit_time, enable_status,advice) VALUES (?,?,?, ?,?,?,?,?, ?,?,?, ?,?)
         ==> Parameters: 1(Long), 2(Long), null, 测试的店铺2(String), test2(String), testaddr2(String), 1388888888(String), test1(String), null, 2020-02-17 13:40:07.072(Timestamp), 2020-02-17 13:40:07.072(Timestamp), 0(Integer), 审核中(String)
         <==    Updates: 1
         Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1339e7aa]
         Fetched SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1339e7aa] from current transaction
         ==>  Preparing: UPDATE tb_shop SET shop_name=?, shop_desc=?, shop_addr=?, phone=?, shop_img=?, last_edit_time=?, create_time=?, enable_status=?, advice=?, area_id=?, shop_category_id=?, owner_id=? WHERE shop_id=?
         ==> Parameters: 测试的店铺2(String), test2(String), testaddr2(String), 1388888888(String), upload\images\item\shop\30\2020021713400720934.png(String), 2020-02-17 13:40:07.072(Timestamp), 2020-02-17 13:40:07.072(Timestamp), 0(Integer), 审核中(String), 2(Long), null, 1(Long), 30(Long)
         <==    Updates: 1
         Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1339e7aa]
         Transaction synchronization committing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1339e7aa]
         Transaction synchronization deregistering SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1339e7aa]
         Transaction synchronization closing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@1339e7aa]
         */
    }
}
