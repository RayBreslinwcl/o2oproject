package com.java.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2020/2/17.
 * 解析http请求的工具类
 */
public class HttpServletRequestUtil {
    /**
     * 返回整型
     * @param request
     * @param key
     * @return
     */
    public static int getInt(HttpServletRequest request,String key){
        try {
            return Integer.parseInt(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }
    /**
     * 返回长整型
     * @param request
     * @param key
     * @return
     */
    public static long getLong(HttpServletRequest request,String key){
        try {
            return Long.valueOf(request.getParameter(key));//.parseInt(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }
    /**
     * 返回double
     * @param request
     * @param key
     * @return
     */
    public static double getDouble(HttpServletRequest request,String key){
        try {
            return  Double.valueOf(request.getParameter(key)); //Integer.parseInt(request.getParameter(key));
        }catch (Exception e){
            return -1d;
        }
    }
    /**
     * 返回布尔
     * @param request
     * @param key
     * @return
     */
    public static boolean getBoolean(HttpServletRequest request,String key){
        try {
            return  Boolean.valueOf(request.getParameter(key)); //Integer.parseInt(request.getParameter(key));
        }catch (Exception e){
            return false;
        }
    }

    public static String getString(HttpServletRequest request,String key){
        try {
            String result=request.getParameter(key);
            if(request!=null){
                result=result.trim();//去除空格
            }
            if("".equals(result)){
                result=null;
            }
            return result;

        }catch (Exception e){
            return null; //错误返回空
        }
    }

}
