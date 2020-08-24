package cn.aimasa.hetongfenglei.service;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cn.aimasa.hetongfenglei.pojo.bo.req.BoFileReq;
import cn.aimasa.hetongfenglei.pojo.bo.req.BoGetUserInfoReq;
import cn.aimasa.hetongfenglei.pojo.bo.resp.BoFileResp;
import cn.aimasa.hetongfenglei.pojo.bo.resp.BoFilesResp;
import cn.aimasa.hetongfenglei.pojo.bo.resp.BoGetUserInfoResp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * 转发dao层处理好的数据
 * @author zhy
 *
 */
public interface FileService {
	
	/**
	 * 根据id获得想要的用户信息
	 * @param id 想查找的用户对应的id
	 * @return 数据库中对应的用户的所有信息
	 */
    public BoFileResp GetFile(@Valid @NotBlank String id);
    
    /**
     * 根据id去查找需要删除的用户信息
     * @param id 需要删除的用户的id
     * @return 是否存在这个用户并且删除成功
     */
    public Boolean deleFile(@Valid @NotBlank String id);
    
    /**
     * 根据用户id去更新想要更新的用户某些信息
     * @param boFileReq （id必填，否则不会更新信息）除了用户id外所有需要更新的信息
     * @return 更新完成的用户信息
     */
    public BoFileResp updateFile(@Valid @NotNull BoFileReq boFileReq) throws IOException;
    
    /**
     * 添加用户信息（id可以不填）
     * @param boFileReq 添加的用户所有信息
     * @return 添加成功的用户信息
     */
    public BoFileResp addFile(@Valid @NotNull BoFileReq boFileReq) throws IOException;

    public void gainFiles(String filter, String id, ZipOutputStream zip) throws IOException ;

}
