package cn.exercise.demo.service.impl;

import org.springframework.stereotype.Service;

import cn.exercise.demo.dao.mapper.UserPersonMapper;
import cn.exercise.demo.pojo.bo.req.BoGetUserInfoReq;
import cn.exercise.demo.pojo.bo.resp.BoGetUserInfoResp;
import cn.exercise.demo.pojo.dto.BoGetUserPersonMapper;
import cn.exercise.demo.service.UserPersonService;

/**
 * 服务层，简单的数据转发
 * 
 * @author zhy
 *
 */
@Service
public class UserPersonServiceImpl implements UserPersonService {

	private UserPersonMapper userPersonMapper;

	@Override
	public BoGetUserInfoResp GetUserInfo(String id) {
		return BoGetUserPersonMapper.INSTANCE.toBoGetUserInfoResp(userPersonMapper.getUser(id));
	}

	@Override
	public Boolean deleUserInfo(String id) {
		return userPersonMapper.deleUserInfo(id);
	}

	@Override
	public BoGetUserInfoResp updateUserInfo(BoGetUserInfoReq boGetUserInfoReq) {
		return BoGetUserPersonMapper.INSTANCE.toBoGetUserInfoResp(userPersonMapper
				.updateUserInfo(BoGetUserPersonMapper.INSTANCE.fromBoGetUserInfoResp(boGetUserInfoReq)));
	}

	@Override
	public BoGetUserInfoResp addUserInfo(BoGetUserInfoReq boGetUserInfoReq) {
		return BoGetUserPersonMapper.INSTANCE.toBoGetUserInfoResp(userPersonMapper
				.updateUserInfo(BoGetUserPersonMapper.INSTANCE.fromBoGetUserInfoResp(boGetUserInfoReq)));
	}

}
