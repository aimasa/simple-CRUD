package cn.exercise.demo.dao.mapper;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
    public Integer id ;
	@Before
	public void start() {
		userInfo = new UserInfo();
		System.out.println("开始测试");
		userInfo.setId(id);
		userInfo.setAge(11);
		userInfo.setSex("女");
		userInfo.setUserName("beatiful girl");
		UserInfo tempUserInfo = userPersonMapper.addUser(userInfo);
		id = tempUserInfo.getId();
		
	}

	@After
	public void end() {
//		id = id + 1;
		System.out.println("测试结束");
	}

	@Test
	public void addUser() {
//		userInfo.setId(24);
		userInfo.setAge(11);
		userInfo.setSex("女");
		userInfo.setUserName("beatiful girl");
		UserInfo tempUserInfo = userPersonMapper.addUser(userInfo);
		Assert.assertNotNull("插入数据失败", tempUserInfo);
		Assert.assertEquals("插入年龄错误",tempUserInfo.getAge() , userInfo.getAge());
		Assert.assertEquals("插入性别错误",tempUserInfo.getSex() , userInfo.getSex());
		Assert.assertEquals("插入昵称错误",tempUserInfo.getUserName() , userInfo.getUserName());
	}

	@Test
	public void getUser() {
		UserInfo tempUserInfo = userPersonMapper.getUser(id);
		Assert.assertNotNull("获取数据失败", tempUserInfo);
		Assert.assertNotNull("获取id失败", tempUserInfo.getId());
		Assert.assertNotNull("获取sex失败", tempUserInfo.getSex());
		Assert.assertNotNull("获取username失败", tempUserInfo.getUserName());
		Assert.assertNotNull("获取年龄失败", tempUserInfo.getAge());
	}

	@Test
	public void updateUser() {
		userInfo = new UserInfo();
		userInfo.setId(id);
		userInfo.setUserName("two days");
		UserInfo tempUserInfo = userPersonMapper.updateUserInfo(userInfo);
		Assert.assertNotNull("更新数据失败", tempUserInfo);
		Assert.assertEquals("插入id错误",tempUserInfo.getId() , userInfo.getId());
		Assert.assertEquals("插入昵称错误",tempUserInfo.getUserName() , userInfo.getUserName());
	}
	
	@Test
	public void deleUser() {
		Boolean isSuccess = userPersonMapper.deleUserInfo(id);
	    System.out.println(isSuccess);
	}
}
