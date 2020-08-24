package cn.aimasa.hetongfenglei.pojo.vo.req;

import org.springframework.web.multipart.MultipartFile;

public class VoFileReq {
    private Integer id;
    private Integer userid;
    private MultipartFile content;
    private String  classfiyField;
    private String  filename;

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

    public MultipartFile getContent() {
        return content;
    }

    public void setContent(MultipartFile content) {
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
