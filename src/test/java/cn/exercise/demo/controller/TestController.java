package cn.exercise.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.apache.naming.ContextAccessController;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import cn.exercise.demo.StudyDemoApplication;
import cn.exercise.demo.pojo.bo.req.BoGetUserInfoReq;
import cn.exercise.demo.pojo.bo.resp.BoGetUserInfoResp;
import cn.exercise.demo.service.UserPersonService;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StudyDemoApplication.class)
public class TestController {
	@Autowired
	private UserPersonController userPersonController;
	private MockMvc mockMvc;
	private BoGetUserInfoResp boGetUserInfoResp;

	private String testData;
//	@Mock
//	private VoGetUserInfoReq voGetUserInfoReq;

	@MockBean
	private UserPersonService userPersonService;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(userPersonController).build();
		testData = "{\"id\":\"88\",\"userName\":\"66\",\"sex\":\"男\"}";
		
	}

	
	//post put patch 201 \delete 204 no_content void\ get 200
	
//	@Ignore
	@Test
	public void addUserTest() throws Exception {
		boGetUserInfoResp = new BoGetUserInfoResp();
		boGetUserInfoResp.setAge(23);
		boGetUserInfoResp.setSex("男");
		boGetUserInfoResp.setUserName("nuonuo");
		boGetUserInfoResp.setId(88);

//		String testData = "{\"userName\":\"lala\",\"age\":23,\"sex\":\"男\"}";

//		given(userPersonService.addUserInfo(Mockito.any())).willReturn(boGetUserInfoResp);
		when(userPersonService.addUserInfo(Mockito.any(BoGetUserInfoReq.class))).thenReturn(boGetUserInfoResp);
//		System.out.println(userPersonService.addUserInfo(null));
		mockMvc.perform(post("/adduser").content(testData).contentType("application/json;charset=UTF-8")
				.accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isCreated())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.voGetUserInfoResp.userName").value("nuonuo"))
				.andExpect(jsonPath("$.voGetUserInfoResp.sex").value("男"))
				.andExpect(jsonPath("$.voGetUserInfoResp.age").value(23));
		
	}

//	@Ignore
	@Test
	public void getUserTest() throws Exception {
		boGetUserInfoResp = new BoGetUserInfoResp();
		boGetUserInfoResp.setAge(23);
		boGetUserInfoResp.setSex("男");
		boGetUserInfoResp.setUserName("nuonuo");
		boGetUserInfoResp.setId(88);
		when(userPersonService.GetUserInfo(Mockito.anyString())).thenReturn(boGetUserInfoResp);

//		String userId = Integer.toString(boGetUserInfoResp.getId());
//		mockMvc.perform(
//				get("/getuser/88").contentType("application/json;charset=UTF-8").accept(MediaType.APPLICATION_JSON))
//				.andDo(print()).andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(jsonPath("$.voGetUserInfoResp.userName").value("nuonuo"))
//				.andExpect(jsonPath("$.voGetUserInfoResp.sex").value("男"))
//				.andExpect(jsonPath("$.voGetUserInfoResp.age").value(23));
		
		try {
			mockMvc.perform(
					get("/getuser/88").contentType("application/json;charset=UTF-8").accept(MediaType.APPLICATION_JSON))
					.andDo(print()).andExpect(content().contentType("application/json;charset=UTF-8"));
		} catch (Exception e) {
			if (e instanceof IllegalArgumentException) {
				String exceptErrorString = "ERROR";
				assertEquals(exceptErrorString, e.getCause().getMessage(),
						String.format("未抛出预期异常:[%s]", exceptErrorString));
			}
		}
		
	}

//	@Ignore
	@Test
	public void testUpdateUserInfo() throws Exception {
		boGetUserInfoResp = new BoGetUserInfoResp();
		boGetUserInfoResp.setAge(23);
		boGetUserInfoResp.setSex("男");
		boGetUserInfoResp.setUserName("nuonuo");
		boGetUserInfoResp.setId(88);
		when(userPersonService.updateUserInfo(Mockito.any(BoGetUserInfoReq.class))).thenReturn(boGetUserInfoResp);
		mockMvc.perform(put("/updateuser").content(testData).contentType("application/json;charset=UTF-8")
				.accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.voGetUserInfoResp.userName").value("nuonuo"))
				.andExpect(jsonPath("$.voGetUserInfoResp.sex").value("男"))
				.andExpect(jsonPath("$.voGetUserInfoResp.age").value(23));
		
	}

//	@Ignore
	@Test
	public void testDeleteUserInfo() throws Exception {
		when(userPersonService.deleUserInfo("88")).thenReturn(true);
		mockMvc.perform(
				delete("/deleuser/88").contentType("application/json;charset=UTF-8").accept(MediaType.APPLICATION_JSON))
				.andDo(print());
		when(userPersonService.deleUserInfo("44")).thenReturn(false);
		mockMvc.perform(
				delete("/deleuser/44").contentType("application/json;charset=UTF-8").accept(MediaType.APPLICATION_JSON))
				.andDo(print());
	}
}
