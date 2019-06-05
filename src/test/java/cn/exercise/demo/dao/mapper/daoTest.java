package cn.exercise.demo.dao.mapper;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import cn.example.demo.StudyDemoApplication;
import cn.exercise.demo.dao.mapper.UserPersonMapper;
import cn.exercise.demo.pojo.po.tables.pojos.UserInfo;


/**
 * 测试dao层的语法是否有错误
 * @author zhy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StudyDemoApplication.class)
@Transactional
public class daoTest {
	UserInfo userInfo;
	@Autowired
	UserPersonMapper userPersonMapper;
    public Integer id = 10;
	@Before
	public void start() {
		userInfo = new UserInfo();
		System.out.println("开始测试");
		userInfo.setId(id);
		userInfo.setAge(11);
		userInfo.setSex("女");
		userInfo.setUserName("beatiful girl");
		userPersonMapper.addUser(userInfo);
		
	}

	@After
	public void end() {
		id = id + 1;
		System.out.println("测试结束");
	}

	@Test
	public void addUser() {
		userInfo.setId(24);
		userInfo.setAge(11);
		userInfo.setSex("女");
		userInfo.setUserName("beatiful girl");
		userPersonMapper.addUser(userInfo);
		System.out.print("123");
	}

	@Test
	public void getUser() {
		userPersonMapper.getUser(id.toString());
	}

	@Test
	public void updateUser() {
		userInfo = new UserInfo();
		userInfo.setId(id);
		userInfo.setUserName("two days");
		userPersonMapper.updateUserInfo(userInfo);

	}
	
	@Test
	public void deleUser() {
		Boolean isSuccess = userPersonMapper.deleUserInfo(id.toString());
	    System.out.println(isSuccess);
	}
}
