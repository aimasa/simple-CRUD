package cn.aimasa.hetongfenglei.dao.mapper;

import java.util.Map;

import java.util.Map.Entry;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;

import cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.aimasa.hetongfenglei.StudyDemoApplication;

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
	File file;
	@Autowired
    FileMapper fileMapper;
	public Integer id;
	private Map<Integer, File> arrayUserInfo;

	@Before
	public void start() {
		file = new File();
		System.out.println("开始测试");
		arrayUserInfo = new HashMap<>();
		for (int i = 0; i < 5; i++) {
//			userInfo.setId(188);
			file.setFilename("11");
			file.setUserid(123);
			file.setClassfiyField("123");
			file.setContent("1234".getBytes());
			File resultFile = fileMapper.addFile(file);
			Assert.assertNotNull("未能成功生成id", resultFile.getId());
			id = resultFile.getId();
			arrayUserInfo.put(id, resultFile);
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
		File tempUserInfo = fileMapper.addFile(file);
		Assert.assertNotNull("插入数据失败", tempUserInfo);
		Assert.assertEquals("插入年龄错误", tempUserInfo.getFilename(), file.getFilename());
		Assert.assertEquals("插入性别错误", tempUserInfo.getClassfiyField(), file.getClassfiyField());
		Assert.assertEquals("插入昵称错误", tempUserInfo.getUserid(), file.getUserid());
	}

//	@Ignore
	@Test
	public void getUser() {
		for (Entry<Integer, File> tempUser : arrayUserInfo.entrySet()) {
			File tempUserInfo = fileMapper.getFile(tempUser.getKey());
			Assert.assertNotNull("获取数据失败", tempUserInfo);
			Assert.assertNotNull("获取id失败", tempUserInfo.getId());
			Assert.assertNotNull("获取FileName失败", tempUserInfo.getFilename());
			Assert.assertNotNull("获取usernameid失败", tempUserInfo.getUserid());
			Assert.assertNotNull("获取分类类别失败", tempUserInfo.getClassfiyField());
		}
//		UserInfo tempUserInfo = userPersonMapper.getUser(88);
//		Assert.assertNull("获取数据失败", tempUserInfo);
	}

//	@Ignore
	@Test
	public void updateUser() {
		for (Entry<Integer, File> tempUser : arrayUserInfo.entrySet()) {
			file = new File();
			file.setId(tempUser.getKey());
			file.setUserid(123);
			File tempUserInfo = fileMapper.updateFile(file);
			Assert.assertNotNull("更新数据失败", tempUserInfo);
			Assert.assertEquals("更新id错误", tempUserInfo.getId(), file.getId());
			Assert.assertEquals("更新userid错误", tempUserInfo.getUserid(), file.getUserid());
		}
	}

//	@Ignore
	@Test
	public void deleUser() {
		for (Entry<Integer, File> tempUser : arrayUserInfo.entrySet()) {
			Boolean isSuccess = fileMapper.deleFile(tempUser.getKey());
			Assert.assertTrue("删除失败", isSuccess);
		}
//		Boolean isFail = userPersonMapper.deleUserInfo()
	}
}
