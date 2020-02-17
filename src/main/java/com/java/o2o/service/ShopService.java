package com.java.o2o.service;

import com.java.o2o.dto.ShopExecution;
import com.java.o2o.entitiy.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Administrator on 2020/2/17.
 */
public interface ShopService {
    /**
     * 添加商铺
     * @return
     */
//    ShopExecution addShop(Shop shop,File shopImg);
    ShopExecution addShop(Shop shop,InputStream shopImgInputStream,String fileName); //因为无法从inputstream中获得filename名称
}
