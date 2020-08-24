package cn.aimasa.hetongfenglei.service.impl;

import cn.aimasa.hetongfenglei.pojo.bo.req.BoFileReq;
import cn.aimasa.hetongfenglei.pojo.bo.resp.BoFileResp;
import cn.aimasa.hetongfenglei.pojo.bo.resp.BoFilesResp;
import cn.aimasa.hetongfenglei.pojo.dto.BoFileMapper;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.jooq.Condition;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.aimasa.hetongfenglei.dao.mapper.FileMapper;
import cn.aimasa.hetongfenglei.service.FileService;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.*;

import javax.servlet.http.HttpServletResponse;

import static cn.aimasa.hetongfenglei.pojo.po.Tables.FILE;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 服务层，简单的数据转发
 * 
 * @author zhy
 *
 */
@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileMapper fileMapper;

	/**
	 * 根据id获得想要的用户信息
	 * 
	 * @param id 想查找的用户对应的id
	 * @return 数据库中对应的用户的所有信息
	 */
	@Override
	public BoFileResp GetFile(String id) {
		Assert.notNull(id, "id值为空");
		BoFileResp boFileResp = BoFileMapper.INSTANCE
				.toBoFile(fileMapper.getFile(Integer.valueOf(id)));
		Assert.notNull(boFileResp, "没有该用户");
		return boFileResp;
	}



	/**
	 * 根据id去查找需要删除的用户信息
	 * 
	 * @param id 需要删除的用户的id
	 * @return 是否存在这个用户并且删除成功
	 */
	@Override
	public Boolean deleFile(String id) {
		Assert.notNull(id, "id值为空");
		
		Boolean isSuccess = fileMapper.deleFile(Integer.valueOf(id));
		Assert.isTrue(isSuccess, "数据库中不存在该用户");
		return isSuccess;
	}

	/**
	 * 根据用户id去更新想要更新的用户某些信息
	 * 
	 * @param boFileReq （id必填，否则不会更新信息）除了用户id外所有需要更新的信息
	 * @return 更新完成的用户信息
	 */
	@Override
	public BoFileResp updateFile(BoFileReq boFileReq)  throws IOException {
		Assert.notNull(boFileReq, "需要更新的信息为空");
		Assert.notNull(boFileReq.getId(), "需要更新的文件id为空");
		BoFileResp boFileResp = BoFileMapper.INSTANCE.toBoFile(fileMapper
				.updateFile(BoFileMapper.INSTANCE.fromBoFile(boFileReq)));
		Assert.notNull(boFileResp, "信息更新失败，数据库中不存在该用户");
		return boFileResp;
	}

	/**
	 * 添加用户信息（id可以不填）
	 * 
	 * @param boFileReq 添加的用户所有信息
	 * @return 添加成功的用户信息
	 */
	@Override
	public BoFileResp addFile(BoFileReq boFileReq) throws IOException {
		Assert.notNull(boFileReq.getContent(), "没有输入上传文件内容");
		Assert.notNull(boFileReq.getFilename(), "没有输入文件名字");
		Assert.notNull(boFileReq.getUserid(), "没有输入文件用户id");
		String pro = classfiyFiles(boFileReq.getContent(), "http://0.0.0.0:8899/contact/classify");
		boFileReq.setClassfiyField(pro);
		BoFileResp boFileResp = BoFileMapper.INSTANCE.toBoFile(
				fileMapper.addFile(BoFileMapper.INSTANCE.fromBoFile(boFileReq)));
		Assert.notNull(boFileResp, "添加失败");
		return boFileResp;
	}


	public static String classfiyFiles (MultipartFile contents, String url)throws IOException {
		CloseableHttpClientToInterfaceImp httpClient = new CloseableHttpClientToInterfaceImp();
		List<String> pres = httpClient.doPost(url, contents);
		return pres.get(0);
	}

	public void gainFiles(String filter, String id, ZipOutputStream zip) throws IOException {
		if(!filter.isEmpty()){
			filter += ",";
		}else{
			filter = "";
		}
		filter += "userid=" + id;
		List<BoFileResp> boFilesResp = BoFileMapper.INSTANCE
				.toBoFiles(fileMapper.getFiles(null, DSL.condition(gainCondition(filter))));
		if(boFilesResp == null){
			zip.close();
			return;
		}
		try {
			downloadFiles(boFilesResp, zip);
		} catch (Exception e) {
			throw new IOException("下载合同失败");
		}

	}

	public void downloadFiles(List<BoFileResp> fileResps, ZipOutputStream zos) throws Exception {
		try {
			downloadToLoad(zos, fileResps);
		}
		catch (IOException e){
			throw new IOException("下载合同失败");
		}
	}

	private static void downloadToLoad(ZipOutputStream zos, List<BoFileResp> boFileResps) throws IOException {
		int i = 0;
		for(BoFileResp boFileResp: boFileResps){
			String fileName = boFileResp.getFilename();
			String superFileName = boFileResp.getClassfiyField();

			ZipEntry zipEntry = new ZipEntry(superFileName + "/"+ i++ + "-" + fileName);
			zos.putNextEntry(zipEntry);
			zos.write(boFileResp.getContent());
			zos.closeEntry();
		}
		zos.close();

	}

	public static File multipartFileToFile(MultipartFile multipartFile) throws IOException {
		String fileName = multipartFile.getOriginalFilename();

		String filePath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/") + "fileUpload";
		String fileTotalName = filePath + File.separator + fileName;
		File file = new File(fileTotalName);
		multipartFile.transferTo(file);
		return file;
	}
	private static String gainCondition(String filters){
		List<String> contents = new ArrayList<>();
		String[] subFilters = filters.trim().split(",");
		for(String subFilter : subFilters){
			String[] ft = subFilter.split("=");
			StringBuffer sb = new StringBuffer();
			String content = ft[0].trim().toLowerCase();
			sb.append("`");
			sb.append(content);
			sb.append("`");
			sb.append("=");
			sb.append(ft[1].trim().toLowerCase());
			contents.add(sb.toString());
		}
		return String.join(" and ", contents);


	}



}
