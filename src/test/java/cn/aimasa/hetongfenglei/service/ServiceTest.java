//package cn.aimasa.hetongfenglei.service;
//
//import static org.mockito.Mockito.when;
//
//import java.util.List;
//import java.util.ArrayList;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import cn.aimasa.hetongfenglei.StudyDemoApplication;
//import cn.aimasa.hetongfenglei.dao.mapper.FileMapper;
//import cn.aimasa.hetongfenglei.pojo.bo.req.BoGetUserInfoReq;
//import cn.aimasa.hetongfenglei.pojo.bo.resp.BoGetUserInfoResp;
//import cn.aimasa.hetongfenglei.pojo.po.tables.pojos.UserInfo;
//import cn.aimasa.hetongfenglei.service.impl.FileServiceImpl;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = StudyDemoApplication.class)
//public class ServiceTest {
//
//	@Autowired
//	private FileServiceImpl userPersonService;
//
//
//	@MockBean
//	private FileMapper fileMapper;
//
//	private BoGetUserInfoReq boGetUserInfoReq;
//
//	private List<UserInfo> userInfoList;
//
//	@Before
//	public void initData() {
//		UserInfo userInfo = new UserInfo();
//		userInfoList = new ArrayList<UserInfo>();
//		boGetUserInfoReq = new BoGetUserInfoReq();
//		boGetUserInfoReq.setId(23);
//		boGetUserInfoReq.setAge(6);
//		boGetUserInfoReq.setSex("女");
//		boGetUserInfoReq.setUserName("haaa");
//		for(int i = 0; i < 5; i++) {
//		userInfo.setAge(20);
//		userInfo.setId(55);
//		userInfo.setUserName("haha");
//		userInfo.setSex("女");
//		userInfoList.add(userInfo);}
//	}
////    @Ignore
//	@Test
//	public void testAddUser() {
//		for(int i = 0; i < userInfoList.size(); i++) {
//		when(fileMapper.addUser(Mockito.any(UserInfo.class))).thenReturn(userInfoList.get(i));
//		BoGetUserInfoResp boGetUserInfoResp = userPersonService.addUserInfo(boGetUserInfoReq);
//		Assert.assertEquals("插入年龄错误",boGetUserInfoResp.getAge() , userInfoList.get(i).getAge());
//		Assert.assertEquals("插入性别错误",boGetUserInfoResp.getSex() , userInfoList.get(i).getSex());
//		Assert.assertEquals("插入昵称错误",boGetUserInfoResp.getUserName() , userInfoList.get(i).getUserName());
//	}}
////    @Ignore
//	@Test
//	public void testUpdateInfo() {
//    	for(int i = 0; i < userInfoList.size(); i++) {
//		when(fileMapper.updateUserInfo(Mockito.any(UserInfo.class))).thenReturn(userInfoList.get(i));
//		BoGetUserInfoResp boGetUserInfoResp = userPersonService.updateUserInfo(boGetUserInfoReq);
//		Assert.assertEquals("插入年龄错误",boGetUserInfoResp.getAge() , userInfoList.get(i).getAge());
//		Assert.assertEquals("插入性别错误",boGetUserInfoResp.getSex() , userInfoList.get(i).getSex());
//		Assert.assertEquals("插入昵称错误",boGetUserInfoResp.getUserName() , userInfoList.get(i).getUserName());
//	}}
////    @Ignore
//    @Test
//    public void testGetUserInfo() {
//    	for(int i = 0; i < userInfoList.size(); i++) {
//    	when(fileMapper.getUser(Mockito.anyInt())).thenReturn(userInfoList.get(i));
//    	BoGetUserInfoResp boGetUserInfoResp = userPersonService.GetUserInfo("1264");
//		Assert.assertEquals("插入年龄错误",boGetUserInfoResp.getAge() , userInfoList.get(i).getAge());
//		Assert.assertEquals("插入性别错误",boGetUserInfoResp.getSex() , userInfoList.get(i).getSex());
//		Assert.assertEquals("插入昵称错误",boGetUserInfoResp.getUserName() , userInfoList.get(i).getUserName());
//    }}
////    @Ignore
//    @Test
//    public void testDeleteUser() {
//    	for(int i = 0; i < userInfoList.size(); i++) {
//    		String id = "454";
//    	when(fileMapper.deleUserInfo(Mockito.anyInt())).thenReturn(true);
//
//    	Boolean isSuccess = userPersonService.deleUserInfo(id);
//    	Assert.assertTrue("插入失败",isSuccess);
//
//    	}
////    	when(userPersonMapper.deleUserInfo(Mockito.anyInt())).thenReturn(false);
////    	Boolean isSuccess1 = userPersonService.deleUserInfo("123");
////    	Assert.assertTrue("插入沒有失敗",!isSuccess1);
//    }
//}
