package cn.aimasa.hetongfenglei.pojo.bo.resp;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class BoFileResp {
    private Integer id;
    private Integer userid;
    private byte[] content;
    private String  classfiyField;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getClassfiyField() {
        return classfiyField;
    }

    public void setClassfiyField(String classfiyField) {
        this.classfiyField = classfiyField;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    private String  filename;

}
