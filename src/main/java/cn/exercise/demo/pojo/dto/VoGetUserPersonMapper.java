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
	
	/**
	 * controller层的数据传到service层
	 * @param voGetUserInfoReq controller层的数据格式
	 * @return BoGetUserInfoReq数据格式
	 */
	BoGetUserInfoReq fromBoGetUserInfoReq(VoGetUserInfoReq voGetUserInfoReq);
	
	/**
	 * service层的数据传回controller层
	 * @param boGetUserInfoResp service层的数据格式
	 * @return VoGetUserInfoResp层的数据格式
	 */
	VoGetUserInfoResp toVoUserInfoResp(BoGetUserInfoResp boGetUserInfoResp);

}
