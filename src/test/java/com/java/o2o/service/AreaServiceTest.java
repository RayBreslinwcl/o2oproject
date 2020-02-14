package com.java.o2o.service;

import com.java.o2o.BaseTest;
import com.java.o2o.entitiy.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2020/2/14.
 */
public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService; //areaServiceImpl自动注入到areaService这个接口，实现这个接口

    @Test
    public void testGetAreaList(){
        List<Area> areaList=areaService.getAreaList();
        Assert.assertEquals("南天门",areaList.get(0).getAreaName());
        /**
         * 结果：成功
         * JDBC Connection [com.mchange.v2.c3p0.impl.NewProxyConnection@47c81abf] will not be managed by Spring
         ==>  Preparing: SELECT area_id, area_name, area_desc, priority, create_time, last_edit_time FROM tb_area ORDER BY priority DESC
         ==> Parameters:
         <==    Columns: area_id, area_name, area_desc, priority, create_time, last_edit_time
         <==        Row: 1, 南天门, null, 3, null, null
         <==        Row: 2, 北天门, null, 2, null, null
         <==      Total: 2
         Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@49b2a47d]
         */
    }
}
