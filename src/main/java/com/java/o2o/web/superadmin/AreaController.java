package com.java.o2o.web.superadmin;

import com.java.o2o.entitiy.Area;
import com.java.o2o.service.AreaService;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/2/14.
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {
    Logger logger= LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private AreaService areaService;//需要接口的时候，将实体类注入

    @RequestMapping(value = "/listarea",method = RequestMethod.GET) //通过get返回，get是会把路径放到url，所以，不安全；post安全
    @ResponseBody //返回对象以json字符串返回前端
    private Map<String,Object> listArea(){
        logger.info("========start Method: listArea========");
        long startTime=System.currentTimeMillis();
        //最终返回对象
        //是一个键值对：每个键包含对应不同信息
        Map<String,Object> modelMap=new HashMap<String ,Object>();
        List<Area> list=new ArrayList<Area>();
        try {
            list=areaService.getAreaList();
            modelMap.put("rows",list);//rows存储行数据
            modelMap.put("total",list.size());//total存储总共大小
        }catch (Exception e){
            e.printStackTrace();
            modelMap.put("success",false);//否则存储失败
            modelMap.put("errMsg",e.toString());//打印失败信息
        }
        long endTime=System.currentTimeMillis();
        logger.error("test error!");
        logger.debug("costTime:[{}ms]",endTime-startTime);
        logger.info("========end Method: listArea========");
        return modelMap;
        /**
         * 测试结果：【成功~】
         * http://localhost:9090/superadmin/listarea：
         结果：
         {"total":2,"rows":[{"areaId":1,"areaName":"南天门","areaDesc":null,"priority":3,"createTime":null,"lastEditTime":null},{"areaId":2,"areaName":"北天门","areaDesc":null,"priority":2,"createTime":null,"lastEditTime":null}]}
         */

    }
}
