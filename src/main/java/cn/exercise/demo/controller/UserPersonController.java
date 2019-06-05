package cn.exercise.demo.controller;

import cn.exercise.demo.pojo.vo.GetUserInfoResp;
import cn.exercise.demo.pojo.vo.req.VoGetUserInfoReq;

/**
 * 接收来自service层转发的数据，并且存到GetUserInfoResp中返回
 * @author zhy
 *
 */
public interface UserPersonController {
	
	/**
	 * 获取该id的用户信息
	 * @param id 想要的用户信息的id
	 * @return 所有用户信息以及对应信息
	 */
    public GetUserInfoResp getUserInfo(String id);
    
    /**
     * 更新用户信息，返回更新完成的内容
     * @param voGetUserInfoReq 需要更新的信息以及用户id
     * @return 更新完成的用户信息
     */
    
    public GetUserInfoResp updateUserInfo(VoGetUserInfoReq voGetUserInfoReq);
    
    /**
     * 添加用户的信息，返回添加成功的用户信息
     * @param voGetUserInfoReq 添加的用户信息
     * @return 添加成功的信息
     */
    public GetUserInfoResp addUserInfo(VoGetUserInfoReq voGetUserInfoReq);
    
    /**
     * 根据对应id删除用户信息
     * @param id 需要删除的用户的id
     * @return false:该用户不存在，true:用户存在，删除成功
     */
    public Boolean deleUserInfo(String id);
}
