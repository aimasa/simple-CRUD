package cn.exercise.demo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cn.exercise.demo.controller.UserPersonController;
import cn.exercise.demo.pojo.dto.VoGetUserPersonMapper;
import cn.exercise.demo.pojo.vo.GetUserInfoResp;
import cn.exercise.demo.pojo.vo.req.VoGetUserInfoReq;
import cn.exercise.demo.service.UserPersonService;

@RestController
public class UserPersonControllerImpl implements UserPersonController {
	@Autowired
	private UserPersonService userPersonService;
	
	/**
	 * 获取该id的用户信息
	 * @param id 想要的用户信息的id
	 * @return 所有用户信息以及对应信息
	 */
	@GetMapping("/getuser/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Override
	public GetUserInfoResp getUserInfo(@PathVariable(value = "id", required = true) String id) {
		GetUserInfoResp getUserInfoResp = new GetUserInfoResp();
		if(!id.equals(1)) {
			throw new IllegalArgumentException("ERROR");
		}
		getUserInfoResp.setInfo("获取用户信息成功");
		getUserInfoResp.setVoGetUserInfoResp(
				VoGetUserPersonMapper.INSTANCE.toVoUserInfoResp(userPersonService.GetUserInfo(id)));
		return getUserInfoResp;
	}
	
    /**
     * 更新用户信息，返回更新完成的内容
     * @param voGetUserInfoReq 需要更新的信息以及用户id
     * @return 更新完成的用户信息
     */
	@PutMapping("/updateuser")
	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public GetUserInfoResp updateUserInfo(@RequestBody VoGetUserInfoReq voGetUserInfoReq) {
		GetUserInfoResp getUserInfoResp = new GetUserInfoResp();
		getUserInfoResp.setInfo("更新信息成功");
		getUserInfoResp.setVoGetUserInfoResp(VoGetUserPersonMapper.INSTANCE.toVoUserInfoResp(userPersonService
				.updateUserInfo(VoGetUserPersonMapper.INSTANCE.fromBoGetUserInfoReq(voGetUserInfoReq))));
		return getUserInfoResp;
	}

	/**
     * 添加用户的信息，返回添加成功的用户信息
     * @param voGetUserInfoReq 添加的用户信息
     * @return 添加成功的信息
     */
	@PostMapping("/adduser")
	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public GetUserInfoResp addUserInfo(@RequestBody VoGetUserInfoReq voGetUserInfoReq) {
		GetUserInfoResp getUserInfoResp = new GetUserInfoResp();
		if(!voGetUserInfoReq.getId().equals(1)) {
			throw new IllegalArgumentException("ERROR");
		}
		
		getUserInfoResp.setInfo("添加信息成功");
		getUserInfoResp.setVoGetUserInfoResp(
				VoGetUserPersonMapper.INSTANCE.toVoUserInfoResp(
				userPersonService.addUserInfo(VoGetUserPersonMapper.INSTANCE.fromBoGetUserInfoReq(voGetUserInfoReq))));
		return getUserInfoResp;
	}
	
    /**
     * 根据对应id删除用户信息
     * @param id 需要删除的用户的id
     */
	@DeleteMapping("/deleuser/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Override
	public void deleUserInfo(@PathVariable(value = "id", required = true) String id) {
		userPersonService.deleUserInfo(id);
	}


}
