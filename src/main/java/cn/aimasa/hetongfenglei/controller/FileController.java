package cn.aimasa.hetongfenglei.controller;



import cn.aimasa.hetongfenglei.pojo.vo.req.VoFileReq;
import cn.aimasa.hetongfenglei.pojo.vo.resp.VoFileResp;
import cn.aimasa.hetongfenglei.pojo.vo.resp.VoFilesResp;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 接收来自service层转发的数据，并且存到GetUserInfoResp中返回
 * @author zhy
 *
 */
public interface FileController {
	
	/**
	 * 获取该id的用户信息
	 * @param id 想要的用户信息的id
	 * @return 所有用户信息以及对应信息
	 */
    public VoFileResp getFile(@Valid @NotBlank String id, HttpServletResponse response) throws UnsupportedEncodingException;

    /**
     * 更新用户信息，返回更新完成的内容
     * @param voFileReq 需要更新的信息以及用户id
     * @return 更新完成的用户信息
     */
    public VoFileResp updateFile(@Valid @NotNull VoFileReq voFileReq) throws IOException;
    
    /**
     * 添加用户的信息，返回添加成功的用户信息
     * @param file 添加的文件信息
     * @param id 上传文件的用户id
     * @return 添加成功的信息
     */
    public VoFileResp addFile(@Valid @NotNull String id, @Valid @NotNull MultipartFile file) throws IOException;
    
    /**
     * 根据对应id删除用户信息
     * @param id 需要删除的文件的id
     * 
     */
    public void deleFile(@Valid @NotBlank String id);

    public byte[] downloadFile(String id, HttpServletResponse response) throws UnsupportedEncodingException;

    public void gainContact(String id, String filter, HttpServletResponse response) throws IOException;

    public int gainId();
}
