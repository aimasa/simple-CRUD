package cn.aimasa.hetongfenglei.service;

import cn.aimasa.hetongfenglei.pojo.bo.resp.ContactClassify;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface CloseableHttpClientToInterface {

    /**
     * 以get方式调用第三方接口
     *
     * @param url
     * @return
     */
    public String doGet(String url);

    /**
     * 以post方式调用第三方接口
     *
     * @param url
     * @param content
     * @return
     */
    public List<String> doPost(String url, MultipartFile content) throws IOException;
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
