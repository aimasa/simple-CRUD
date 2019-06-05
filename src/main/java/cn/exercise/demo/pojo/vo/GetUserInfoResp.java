package cn.exercise.demo.pojo.vo;

import cn.exercise.demo.pojo.vo.resp.VoGetUserInfoResp;

/**
 * 用户的个人信息以及不同操作对应的info
 * @author zhy
 *
 */
public class GetUserInfoResp {
	private String info;
	private VoGetUserInfoResp voGetUserInfoResp;

	public VoGetUserInfoResp getVoGetUserInfoResp() {
		return voGetUserInfoResp;
	}

	public void setVoGetUserInfoResp(VoGetUserInfoResp voGetUserInfoResp) {
		this.voGetUserInfoResp = voGetUserInfoResp;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
