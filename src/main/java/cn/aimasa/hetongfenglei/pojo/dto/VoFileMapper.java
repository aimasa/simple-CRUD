package cn.aimasa.hetongfenglei.pojo.dto;

import cn.aimasa.hetongfenglei.pojo.bo.req.BoFileReq;
import cn.aimasa.hetongfenglei.pojo.bo.resp.BoFileResp;
import cn.aimasa.hetongfenglei.pojo.vo.req.VoFileReq;
import cn.aimasa.hetongfenglei.pojo.vo.resp.VoFileResp;
import cn.aimasa.hetongfenglei.pojo.vo.resp.VoFilesResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VoFileMapper {

    VoFileMapper INSTANCE = Mappers.getMapper(VoFileMapper.class);

    BoFileReq toBoFileReq(VoFileReq voFileReq);

    VoFileResp fromBoFileResp(BoFileResp boFileResp);



}
