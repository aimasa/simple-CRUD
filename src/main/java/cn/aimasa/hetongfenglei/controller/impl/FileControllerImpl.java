package cn.aimasa.hetongfenglei.controller.impl;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import cn.aimasa.hetongfenglei.controller.FileController;
import cn.aimasa.hetongfenglei.pojo.bo.req.BoFileReq;
import cn.aimasa.hetongfenglei.pojo.bo.resp.BoFileResp;
import cn.aimasa.hetongfenglei.pojo.dto.VoFileMapper;
import cn.aimasa.hetongfenglei.pojo.vo.req.VoFileReq;
import cn.aimasa.hetongfenglei.pojo.vo.resp.VoFileResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import cn.aimasa.hetongfenglei.service.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipOutputStream;

@RestController
@CrossOrigin
public class FileControllerImpl implements FileController {
	@Autowired
	private FileService fileService;

	/**
	 * 获取该id的用户信息
	 * @param id 想要的文件信息的id
	 * @return 所有用户信息以及对应信息
	 */
	@GetMapping("/contacts/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Override
	public VoFileResp getFile(@PathVariable(value = "id", required = true) String id, HttpServletResponse response) throws UnsupportedEncodingException {
		BoFileResp boFileResp = fileService.GetFile(id);
		return VoFileMapper.INSTANCE.fromBoFileResp(boFileResp);
	}

	@GetMapping("/download/contacts/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Override
	public byte[] downloadFile(@PathVariable(value = "id", required = true) String id, HttpServletResponse response) throws UnsupportedEncodingException {
		BoFileResp boFileResp = fileService.GetFile(id);
		response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(boFileResp.getFilename(), "UTF-8"));
		return boFileResp.getContent();
	}
	@GetMapping("/{userid}/contacts")
	@ResponseStatus(HttpStatus.OK)
	@Override
	public void gainContact(@PathVariable(value = "userid", required = true) String id, @RequestParam(value = "filter", defaultValue = "") String filter, HttpServletResponse response) throws IOException {

		String zipName = "合同.zip";
//		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(zipName, "UTF-8"));
		OutputStream outputStream = response.getOutputStream();
		ZipOutputStream zos = new ZipOutputStream(outputStream);
		fileService.gainFiles(filter, id, zos);
	}
    /**
     * 更新用户信息，返回更新完成的内容
     * @param voFileReq 需要更新的信息以及文件id
     * @return 更新完成的用户信息
	 *
     */
	@PutMapping("/contact/update")
	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public VoFileResp updateFile(@RequestBody VoFileReq voFileReq) throws IOException {
		return VoFileMapper.INSTANCE.fromBoFileResp(fileService.updateFile(VoFileMapper.INSTANCE.toBoFileReq(voFileReq)));
	}

	@GetMapping("/user/id")
	@ResponseStatus(HttpStatus.OK)
	@Override
	public int gainId(){
		Random random = new Random();
		int id = random.nextInt(Integer.MAX_VALUE);
		return id;
	}
	/**
     * 添加用户的信息，返回添加成功的用户信息
     * @param file 添加的文件信息
     * @return 添加成功的信息
     */
	@PostMapping("/contact/add/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public VoFileResp addFile(@PathVariable(value = "id", required = true) String id, @RequestBody MultipartFile file) throws IOException {
		BoFileReq boFileReq = new BoFileReq();
		boFileReq.setFilename(file.getOriginalFilename());
		boFileReq.setContent(file);
		boFileReq.setUserid(Integer.valueOf(id));
		return VoFileMapper.INSTANCE.fromBoFileResp(fileService.addFile(boFileReq));
	}

    /**
     * 根据对应id删除用户信息
     * @param id 需要删除的用户的id
     */
	@DeleteMapping("/contact/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Override
	public void deleFile(@PathVariable(value = "id", required = true) String id) {
		Boolean result = fileService.deleFile(id);
		if(!result){
			new Throwable("删错错误");
		}
	}



}
