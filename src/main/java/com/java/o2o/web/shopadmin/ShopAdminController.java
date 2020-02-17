package com.java.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2020/2/17.
 * 后台路径管理
 */
@Controller
@RequestMapping(value = "shopadmin",method = RequestMethod.GET)
public class ShopAdminController {
    /**
     * 注册商铺的页面
     * @return
     */
    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        return "shop/shopoperation";
        //最终地址是：E:\Tools\WorkspaceforMyeclipse\o2oproject\src\main\resources\spring\spring-web.xml
        //定义的3.定义视图解析器中
        //为：/WEB-INF/html/shop/shopoperation.html

        /**
         * 测试：【成功】
         * 访问localhost:9090/shopadmin/shopoperation即可
         */
    }
}
