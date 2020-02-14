package com.java.o2o.service.impl;

import com.java.o2o.dao.AreaDao;
import com.java.o2o.entitiy.Area;
import com.java.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/2/14.
 */
@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    private AreaDao areaDao;

    public List<Area> getAreaList(){
        return  areaDao.queryArea();
    }
}
