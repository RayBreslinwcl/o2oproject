package com.java.o2o.web.shopadmin;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.o2o.dto.ShopExecution;
import com.java.o2o.entitiy.PersonInfo;
import com.java.o2o.entitiy.Shop;
import com.java.o2o.enums.ShopStateEnum;
import com.java.o2o.service.ShopService;
import com.java.o2o.util.HttpServletRequestUtil;
import com.java.o2o.util.ImageUtil;
import com.java.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by Administrator on 2020/2/17.
 * ShopManagementController 控制层
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;

    /**
     * 注册商铺
     * @param request 包含客户访问请求的所有信息！都可以通过request的相应的方法获得
     * @return
     */
    @RequestMapping(value = "/registershop",method = RequestMethod.POST)
    @ResponseBody //将返回Map转换为json字符串
    private Map<String ,Object> registerShop(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //1.接收并转换相应的参数，包括店铺信息以及图片信息
        String shopStr= HttpServletRequestUtil.getString(request,"shopStr");
        ObjectMapper mapper=new ObjectMapper();
        Shop shop=null;

        try {
            shop=mapper.readValue(shopStr,Shop.class);
//            shop=mapper.readValues(shopStr,Shop.class);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
            return modelMap;
        }
        //图片
        CommonsMultipartFile shopImg=null;
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        if(commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest) request;
            shopImg=(CommonsMultipartFile)multipartHttpServletRequest.getFile("shopImg");
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","上传图片不能为空");
            return modelMap;
        }
        //2.注册店铺
        if(shop!=null&&shopImg!=null){
            PersonInfo owner=new PersonInfo();
            owner.setUserId(1L);
            shop.setOwner(owner);

            //shopImg直接转换为File
            File shopImgFile=new File(PathUtil.getImgBasePath()+ PathUtil.getRandomFileName());
            try {
                shopImgFile.createNewFile();
            }catch (IOException e){
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
                return modelMap;
            }
            try {
                inputStreamToFile(shopImg.getInputStream(),shopImgFile);
            } catch (IOException e) {
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
                return modelMap;
            }

            //addShop参数变为File，是因为方便在service层直接测试
//            ShopExecution se=shopService.addShop(shop,shopImg);
            ShopExecution se=shopService.addShop(shop,shopImgFile);

            //判断最终状态
            if(se.getState()== ShopStateEnum.Check.getState()){
                modelMap.put("success",true);
            }else {
                modelMap.put("success",false);
                modelMap.put("errMsg",se.getStateInfo());
            }
            return modelMap;
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入店铺信息");
            return modelMap;
        }

        //3.返回结果

//        return null;
    }

    private static void inputStreamToFile(InputStream ins,File file){
        OutputStream os=null;

        try {
            os=new FileOutputStream(file);
            int bytesRead=0;
            byte[] buffer=new byte[1024];
            while ((bytesRead=ins.read(buffer))!=-1){
                os.write(buffer,0,bytesRead);
            }
        } catch (Exception e) {
            throw new RuntimeException("调用inputStreamToFile产生异常："+e.getMessage());
//            e.printStackTrace();
        }finally {
            try {
                if(os!=null){
                    os.close();
                }
                if(ins!=null){
                    ins.close();;
                }
            }catch (IOException e){
                throw new RuntimeException("inputStreamToFile关闭io产生异常："+e.getMessage());
            }
        }
    }
}
