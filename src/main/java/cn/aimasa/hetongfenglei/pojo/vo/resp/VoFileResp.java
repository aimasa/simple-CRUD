package cn.aimasa.hetongfenglei.pojo.vo.resp;

import org.springframework.web.multipart.MultipartFile;

public class VoFileResp {
    private Integer id;
    private Integer userid;
    private byte[] content;
    private String  classfiyField;
    private String  filename;
    private String Code;
    private String describe;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

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
}
