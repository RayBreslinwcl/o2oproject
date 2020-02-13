package com.java.o2o.dao;

import com.java.o2o.entitiy.Area;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2020/2/13.
 */
public interface AreaDao {

    /**
     * 列出区域列表
     * @return
     */
    List<Area> queryArea();
}
