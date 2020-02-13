package com.java.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 初始化
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit：spring配置文件位置
//@ContextConfiguration({ "classpath:spring/spring-redis.xml","classpath:spring/spring-dao.xml",
//		"classpath:spring/spring-service.xml" })
@ContextConfiguration({ "classpath:spring/spring-dao.xml",
		"classpath:spring/spring-service.xml" })
public class BaseTest {

}