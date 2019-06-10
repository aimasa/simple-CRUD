package cn.exercise.demo.pojo.dto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cn.exercise.demo.pojo.bo.req.BoGetUserInfoReq;
import cn.exercise.demo.pojo.bo.resp.BoGetUserInfoResp;
import cn.exercise.demo.pojo.po.tables.pojos.UserInfo;

/**
 * po层数据映射到bo层
 * @author zhy
 *
 */
@Mapper
public interface BoGetUserPersonMapper {
    BoGetUserPersonMapper INSTANCE = Mappers.getMapper(BoGetUserPersonMapper.class);
    
    /**
     * 把service层处理好的数据转换成dao层数据
     * @param boGetUserInfoReq service层的数据格式
     * @return 数据表的数据格式
     */
    UserInfo fromBoGetUserInfoResp(BoGetUserInfoReq boGetUserInfoReq);
    
    /**
     * 把dao层处理好的返回数据转换为service层数据
     * @param userInfo 返回的数据表的数据格式
     * @return BoGetUserInfoResp数据格式
     */
    BoGetUserInfoResp toBoGetUserInfoResp(UserInfo userInfo);
    
}
