package cn.exercise.demo.pojo.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cn.exercise.demo.pojo.bo.req.BoGetUserInfoReq;
import cn.exercise.demo.pojo.bo.resp.BoGetUserInfoResp;
import cn.exercise.demo.pojo.vo.req.VoGetUserInfoReq;
import cn.exercise.demo.pojo.vo.resp.VoGetUserInfoResp;

/**
 * vo和bo相互间的映射
 * @author Mloong
 *
 */
@Mapper
public interface VoGetUserPersonMapper {
	VoGetUserPersonMapper INSTANCE = Mappers.getMapper(VoGetUserPersonMapper.class);
	
	BoGetUserInfoReq fromBoGetUserInfoReq(VoGetUserInfoReq voGetUserInfoReq);
	
	VoGetUserInfoResp toVoUserInfoResp(BoGetUserInfoResp boGetUserInfoResp);

}
