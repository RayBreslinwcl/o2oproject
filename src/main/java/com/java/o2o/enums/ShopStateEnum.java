package com.java.o2o.enums;

/**
 * Created by Administrator on 2020/2/16.
 * 商铺状态枚举
 */
public enum ShopStateEnum {
    Check(0,"核审中"),OFFLINE(-1,"非法店铺"),SUCCESS(1,"操作成功"),
    PASS(2,"通过认证"),INNER_ERROR(-1001,"内部系统错误"),
    NULL_SHOPID(-1002,"ShopId为空");

    private int state;//状态码
    private String stateInfo;//状态描述信息

    private ShopStateEnum(int state,String stateInfo){
        this.state=state;
        this.stateInfo=stateInfo;
    }

    /**
     * 返回状态码为index的枚举变量
     * @param index
     * @return
     */
    public static ShopStateEnum stateOf(int index){
        for (ShopStateEnum state: values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
