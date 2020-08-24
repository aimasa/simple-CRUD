package cn.aimasa.hetongfenglei.pojo.dto;

import cn.aimasa.hetongfenglei.pojo.bo.req.BoFileReq;
import cn.aimasa.hetongfenglei.pojo.bo.resp.BoFileResp;
import cn.aimasa.hetongfenglei.pojo.bo.resp.BoFilesResp;
import cn.aimasa.hetongfenglei.pojo.po.tables.pojos.File;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.util.List;

@Mapper(imports = {java.io.IOException.class, java.util.List.class})
public interface BoFileMapper {

    BoFileMapper INSTANCE = Mappers.getMapper(BoFileMapper.class);

    @Mapping(target = "content", expression = "java(boFileReq.getContent().getBytes())")
    File fromBoFile(BoFileReq boFileReq) throws IOException;
//    @Mapping(target = "content", expression = "java(null)")
    BoFileResp toBoFile(File file);
//    @Mapping(target = "content", expression = "java(null)")
//    BoFileResp toBoFile(File file);

    List<BoFileResp> toBoFiles(List<File> files);



}
