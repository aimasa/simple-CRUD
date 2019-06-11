package cn.exercise.demo.service;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cn.exercise.demo.pojo.bo.req.BoGetUserInfoReq;
import cn.exercise.demo.pojo.bo.resp.BoGetUserInfoResp;

/**
 * 转发dao层处理好的数据
 * @author zhy
 *
 */
public interface UserPersonService {
	
	/**
	 * 根据id获得想要的用户信息
	 * @param id 想查找的用户对应的id
	 * @return 数据库中对应的用户的所有信息
	 */
    public BoGetUserInfoResp GetUserInfo(@Valid @NotBlank String id);
    
    /**
     * 根据id去查找需要删除的用户信息
     * @param id 需要删除的用户的id
     * @return 是否存在这个用户并且删除成功
     */
    public Boolean deleUserInfo(@Valid @NotBlank String id);
    
    /**
     * 根据用户id去更新想要更新的用户某些信息
     * @param boGetUserInfoReq （id必填，否则不会更新信息）除了用户id外所有需要更新的信息
     * @return 更新完成的用户信息
     */
    public BoGetUserInfoResp updateUserInfo(@Valid @NotNull BoGetUserInfoReq boGetUserInfoReq);
    
    /**
     * 添加用户信息（id可以不填）
     * @param boGetUserInfoReq 添加的用户所有信息
     * @return 添加成功的用户信息
     */
    public BoGetUserInfoResp addUserInfo(@Valid @NotNull BoGetUserInfoReq boGetUserInfoReq);
}
