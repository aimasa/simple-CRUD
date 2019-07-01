package cn.exercise.demo.dao.mapper;

import java.util.Map;

import java.util.Map.Entry;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.exercise.demo.StudyDemoApplication;
import cn.exercise.demo.dao.mapper.UserPersonMapper;
import cn.exercise.demo.pojo.po.tables.pojos.UserInfo;

/**
 * 测试dao层的语法是否有错误
 * 
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
	public Integer id;
	private Map<Integer, UserInfo> arrayUserInfo;

	@Before
	public void start() {
		userInfo = new UserInfo();
		System.out.println("开始测试");
		arrayUserInfo = new HashMap<Integer, UserInfo>();
		for (int i = 0; i < 5; i++) {
//			userInfo.setId(188);
			userInfo.setAge(11);
			userInfo.setSex("女");
			userInfo.setUserName("beatiful girl");
			UserInfo tempUserInfo = userPersonMapper.addUser(userInfo);
			Assert.assertNotNull("未能成功生成id", tempUserInfo.getId());
			id = tempUserInfo.getId();
			arrayUserInfo.put(id, tempUserInfo);
		}

	}

	@After
	public void end() {
//		id = id + 1;
		System.out.println("测试结束");
	}

//	@Ignore
	@Test
	public void addUser() {
//		userInfo.setId(24);
//		userInfo.setAge(11);
//		userInfo.setSex("女");
//		userInfo.setUserName("beatiful girl");

//			userInfo = arrayUserInfo.get(i);
		UserInfo tempUserInfo = userPersonMapper.addUser(userInfo);
		Assert.assertNotNull("插入数据失败", tempUserInfo);
		Assert.assertEquals("插入年龄错误", tempUserInfo.getAge(), userInfo.getAge());
		Assert.assertEquals("插入性别错误", tempUserInfo.getSex(), userInfo.getSex());
		Assert.assertEquals("插入昵称错误", tempUserInfo.getUserName(), userInfo.getUserName());
	}

//	@Ignore
	@Test
	public void getUser() {
		for (Entry<Integer, UserInfo> tempUser : arrayUserInfo.entrySet()) {
			UserInfo tempUserInfo = userPersonMapper.getUser(tempUser.getKey());
			Assert.assertNotNull("获取数据失败", tempUserInfo);
			Assert.assertNotNull("获取id失败", tempUserInfo.getId());
			Assert.assertNotNull("获取sex失败", tempUserInfo.getSex());
			Assert.assertNotNull("获取username失败", tempUserInfo.getUserName());
			Assert.assertNotNull("获取年龄失败", tempUserInfo.getAge());
		}
//		UserInfo tempUserInfo = userPersonMapper.getUser(88);
//		Assert.assertNull("获取数据失败", tempUserInfo);
	}

//	@Ignore
	@Test
	public void updateUser() {
		for (Entry<Integer, UserInfo> tempUser : arrayUserInfo.entrySet()) {
			userInfo = new UserInfo();
			userInfo.setId(tempUser.getKey());
			userInfo.setUserName("two days");
			UserInfo tempUserInfo = userPersonMapper.updateUserInfo(userInfo);
			Assert.assertNotNull("更新数据失败", tempUserInfo);
			Assert.assertEquals("更新id错误", tempUserInfo.getId(), userInfo.getId());
			Assert.assertEquals("更新昵称错误", tempUserInfo.getUserName(), userInfo.getUserName());
		}
	}

//	@Ignore
	@Test
	public void deleUser() {
		for (Entry<Integer, UserInfo> tempUser : arrayUserInfo.entrySet()) {
			Boolean isSuccess = userPersonMapper.deleUserInfo(tempUser.getKey());
			Assert.assertTrue("删除失败", isSuccess);
		}
//		Boolean isFail = userPersonMapper.deleUserInfo()
	}
}
