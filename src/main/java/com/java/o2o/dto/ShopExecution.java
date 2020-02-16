package com.java.o2o.dto;

import com.java.o2o.entitiy.Shop;
import com.java.o2o.enums.ShopStateEnum;

import java.util.List;

/**
 * Created by Administrator on 2020/2/16.
 * 店铺和controller层交互的对象：DTO
 */
public class ShopExecution {
    //结果状态
    private int state;
    //状态标识
    private String stateInfo;
    //店铺数量
    private int count;
    //操作的shop（增删改查的时候用到）
    private Shop shop;
    //操作的shop（增删改查的时候用到）
    private List<Shop> shopList;

    //构造函数
    public ShopExecution() {
    }
    //店铺操作失败的时候，使用的构造器
    //查询失败，所以没必要返回shop这个对象
    public ShopExecution(ShopStateEnum stateEnum){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
    }
    //店铺操作成功的时候，使用的构造器
    //当查询的是一个商店的时候
    public ShopExecution(ShopStateEnum stateEnum,Shop shop){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.shop=shop;
    }
    //店铺操作成功的时候，使用的构造器
    //当查询的是一系列商店列表的时候
    public ShopExecution(ShopStateEnum stateEnum,List<Shop> shopList){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.shopList=shopList;
    }


    //getter/setter

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
