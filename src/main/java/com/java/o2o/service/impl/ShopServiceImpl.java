package com.java.o2o.service.impl;

import com.java.o2o.dao.ShopDao;
import com.java.o2o.dto.ShopExecution;
import com.java.o2o.entitiy.Shop;
import com.java.o2o.enums.ShopStateEnum;
import com.java.o2o.service.ShopService;
import com.java.o2o.util.ImageUtil;
import com.java.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by Administrator on 2020/2/17.
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional //添加事务
//    public ShopExecution addShop(Shop shop, File shopImg) {
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        if(shop==null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);//没有商铺信息
        }
        try {
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            int effectedNum=shopDao.insertShop(shop);
            if(effectedNum<=0){
                throw new RuntimeException("店铺创建失败！"); //RuntimeException会使事务回滚，shopDao.insertShop失效
            }else {
                //存储图片
                if(shopImgInputStream!=null){
                    try {
                        addShopImg(shop,shopImgInputStream,fileName);
                    }catch (Exception e){
                        throw new RuntimeException("addShopImg error:"+e.getMessage());
                    }
                    //因为存储图片之后才会有图片地址，所以，需要更新图片地址
                    effectedNum=shopDao.updateShop(shop);
                    if(effectedNum<=0){
                        throw new RuntimeException("更新图片地址失败！");
                    }
                }

            }
        }catch (Exception e){
            throw new RuntimeException("addShop error:"+e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.Check,shop);

    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream,String fileName){
        //获取shop图片目录的相对值路径
        String dest= PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr= ImageUtil.generateThumbnail(shopImgInputStream,fileName,dest);
        shop.setShopImg(shopImgAddr);
    }
}
