package cn.aimasa.hetongfenglei.service.impl;

import cn.aimasa.hetongfenglei.pojo.bo.resp.ContactClassify;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.apache.commons.io.IOUtils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class CloseableHttpClientToInterfaceImp {

    private static String tokenString = "";
    private static String AUTH_TOKEN_EXPIRED = "AUTH_TOKEN_EXPIRED";

    /**
     * 以get方式调用第三方接口
     *
     * @param url
     * @return
     */
    public String doGet(String url) {

        Request request = new Request.Builder().url(url).build();
        return null;


    }

    /**
     * 以post方式调用第三方接口
     *
     * @param url
     * @param content
     * @return
     */
    public List<String> doPost(String url, MultipartFile content) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");

        List<Byte[]> contents = new ArrayList<>();

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("path", content.getOriginalFilename(),
                        RequestBody.create(content.getBytes(), MediaType.parse("application/octet-stream")))
                .build();
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() == 200) {
            String json = response.body().string();
            ContactClassify cc = JSONObject.parseObject(json, ContactClassify.class);
            return cc.getAccuracy();
        }
        return null;
    }

//
//    /**
//     * 测试
//     */
//    public void test(String path) throws IOException {
//
//        File file = new File(path);
//        FileItem item = new DiskFileItemFactory().createItem("file"
//                , MediaType.parse("text/plain").type()
//                , true
//                , file.getName());
//        try (InputStream input = new FileInputStream(file);
//             OutputStream os = item.getOutputStream()) {
//            // 流转移
//            IOUtils.copy(input, os);
//        } catch (Exception e) {
//            throw new IllegalArgumentException("Invalid file: " + e, e);
//        }
//
//        MultipartFile content = new CommonsMultipartFile(item);
//        try {
//            //首先获取token
//            List<String> response = new CloseableHttpClientToInterfaceImp().doPost("123", "http://0.0.0.0:8899/contact/classify", content);
//
//            //如果返回的结果是list形式的，需要使用JSONObject.parseArray转换
////            List<Result> list = JSONObject.parseArray(response, Result.class);
//
//            System.out.println(response);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        new CloseableHttpClientToInterfaceImp().test("F:/contact_classfiy/00/【租房合同书】个人租房合同书样本.docx");
//    }
}
