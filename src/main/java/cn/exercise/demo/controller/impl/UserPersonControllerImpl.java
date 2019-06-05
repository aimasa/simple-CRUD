package cn.exercise.demo.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/getuser/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public GetUserInfoResp getUserInfo(@PathVariable(value = "id",required = true) String id) {
		GetUserInfoResp getUserInfoResp = new GetUserInfoResp();
		getUserInfoResp.setInfo("获取用户信息成功");
		getUserInfoResp.setVoGetUserInfoResp(
				VoGetUserPersonMapper.INSTANCE.toVoUserInfoResp(userPersonService.GetUserInfo(id)));
		return getUserInfoResp;
	}

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

	@PostMapping("/adduser")
	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public GetUserInfoResp addUserInfo(@RequestBody VoGetUserInfoReq voGetUserInfoReq) {
		if(voGetUserInfoReq == null) {
			return null;
		}
		GetUserInfoResp getUserInfoResp = new GetUserInfoResp();
		getUserInfoResp.setInfo("添加信息成功");
		getUserInfoResp.setVoGetUserInfoResp(VoGetUserPersonMapper.INSTANCE.toVoUserInfoResp(userPersonService
				.addUserInfo(VoGetUserPersonMapper.INSTANCE.fromBoGetUserInfoReq(voGetUserInfoReq))));
		return getUserInfoResp;
	}
    @DeleteMapping("/deleuser/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	@Override
	public Boolean deleUserInfo(@PathVariable(value = "id", required = true) String id) {
		return userPersonService.deleUserInfo(id);
	}

}
