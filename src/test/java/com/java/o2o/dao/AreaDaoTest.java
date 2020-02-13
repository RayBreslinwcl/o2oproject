package com.java.o2o.dao;

import com.java.o2o.BaseTest;
import com.java.o2o.entitiy.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2020/2/13.
 */
public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> areaList=areaDao.queryArea();
        //判断数据库中是否只有两条数据
        Assert.assertEquals(2,areaList.size());
//        assertEquals();

        /**
         * 结果：通过
         JDBC Connection [com.mchange.v2.c3p0.impl.NewProxyConnection@769a1df5] will not be managed by Spring
         ==>  Preparing: SELECT area_id, area_name, area_desc, priority, create_time, last_edit_time FROM tb_area ORDER BY priority DESC
         ==> Parameters:
         <==    Columns: area_id, area_name, area_desc, priority, create_time, last_edit_time
         <==        Row: 1, 南天门, null, 3, null, null
         <==        Row: 2, 北天门, null, 2, null, null
         <==      Total: 2
         Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@5276d6ee]
         */
    }
}
