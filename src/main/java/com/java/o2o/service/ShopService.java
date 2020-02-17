package com.java.o2o.service;

import com.java.o2o.dto.ShopExecution;
import com.java.o2o.entitiy.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

/**
 * Created by Administrator on 2020/2/17.
 */
public interface ShopService {
    /**
     * 添加商铺
     * @param shop
     * @param shopImg
     * @return
     */
    ShopExecution addShop(Shop shop,File shopImg);
}
