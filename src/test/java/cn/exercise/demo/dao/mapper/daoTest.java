package cn.exercise.demo.dao.mapper;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


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
		Assert.notNull(tempUserInfo, "插入失败");
	}

	@Test
	public void getUser() {
		UserInfo tempUserInfo = userPersonMapper.getUser(id);
		Assert.notNull(tempUserInfo, "获取信息失败");
	}

	@Test
	public void updateUser() {
		userInfo = new UserInfo();
		userInfo.setId(id);
		userInfo.setUserName("two days");
		UserInfo tempUserInfo = userPersonMapper.updateUserInfo(userInfo);
		Assert.notNull(tempUserInfo, "更新信息失败");
	}
	
	@Test
	public void deleUser() {
		Boolean isSuccess = userPersonMapper.deleUserInfo(id);
	    System.out.println(isSuccess);
	}
}
