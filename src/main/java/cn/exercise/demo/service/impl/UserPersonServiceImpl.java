package cn.exercise.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

	@Autowired
	private UserPersonMapper userPersonMapper;

	/**
	 * 根据id获得想要的用户信息
	 * 
	 * @param id 想查找的用户对应的id
	 * @return 数据库中对应的用户的所有信息
	 */
	@Override
	public BoGetUserInfoResp GetUserInfo(String id) {
		Assert.notNull(id, "id值为空");
		BoGetUserInfoResp boGetUserInfoResp = BoGetUserPersonMapper.INSTANCE
				.toBoGetUserInfoResp(userPersonMapper.getUser(Integer.valueOf(id)));
		Assert.notNull(boGetUserInfoResp, "没有该用户");
		return boGetUserInfoResp;
	}

	/**
	 * 根据id去查找需要删除的用户信息
	 * 
	 * @param id 需要删除的用户的id
	 * @return 是否存在这个用户并且删除成功
	 */
	@Override
	public Boolean deleUserInfo(String id) {
		Assert.notNull(id, "id值为空");
		Boolean isSuccess = userPersonMapper.deleUserInfo(Integer.valueOf(id));
		Assert.isTrue(isSuccess, "数据库中不存在该用户");
		return isSuccess;
	}

	/**
	 * 根据用户id去更新想要更新的用户某些信息
	 * 
	 * @param boGetUserInfoReq （id必填，否则不会更新信息）除了用户id外所有需要更新的信息
	 * @return 更新完成的用户信息
	 */
	@Override
	public BoGetUserInfoResp updateUserInfo(BoGetUserInfoReq boGetUserInfoReq) {
		Assert.notNull(boGetUserInfoReq, "需要更新的信息为空");
		Assert.notNull(boGetUserInfoReq.getId(), "需要更新的用户id为空");
		BoGetUserInfoResp boGetUserInfoResp = BoGetUserPersonMapper.INSTANCE.toBoGetUserInfoResp(userPersonMapper
				.updateUserInfo(BoGetUserPersonMapper.INSTANCE.fromBoGetUserInfoResp(boGetUserInfoReq)));
		Assert.notNull(boGetUserInfoResp, "信息更新失败，数据库中不存在该用户");
		return boGetUserInfoResp;
	}

	/**
	 * 添加用户信息（id可以不填）
	 * 
	 * @param boGetUserInfoReq 添加的用户所有信息
	 * @return 添加成功的用户信息
	 */
	@Override
	public BoGetUserInfoResp addUserInfo(BoGetUserInfoReq boGetUserInfoReq) {
		Assert.notNull(boGetUserInfoReq.getAge(), "没有输入年纪");
		Assert.notNull(boGetUserInfoReq.getSex(), "没有输入性别");
		Assert.notNull(boGetUserInfoReq.getUserName(), "没有输入性别");
		BoGetUserInfoResp boGetUserInfoResp = BoGetUserPersonMapper.INSTANCE.toBoGetUserInfoResp(
				userPersonMapper.addUser(BoGetUserPersonMapper.INSTANCE.fromBoGetUserInfoResp(boGetUserInfoReq)));
		Assert.notNull(boGetUserInfoResp, "添加失败");
		return boGetUserInfoResp;
	}

}
