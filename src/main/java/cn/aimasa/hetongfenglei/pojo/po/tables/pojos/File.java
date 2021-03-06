/*
 * This file is generated by jOOQ.
 */
package cn.aimasa.hetongfenglei.pojo.po.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class File implements Serializable {

    private static final long serialVersionUID = 941313124;

    private Integer id;
    private Integer userid;
    private byte[]  content;
    private String  classfiyField;
    private String  filename;

    public File() {}

    public File(File value) {
        this.id = value.id;
        this.userid = value.userid;
        this.content = value.content;
        this.classfiyField = value.classfiyField;
        this.filename = value.filename;
    }

    public File(
        Integer id,
        Integer userid,
        byte[]  content,
        String  classfiyField,
        String  filename
    ) {
        this.id = id;
        this.userid = userid;
        this.content = content;
        this.classfiyField = classfiyField;
        this.filename = filename;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public byte[] getContent() {
        return this.content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getClassfiyField() {
        return this.classfiyField;
    }

    public void setClassfiyField(String classfiyField) {
        this.classfiyField = classfiyField;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("File (");

        sb.append(id);
        sb.append(", ").append(userid);
        sb.append(", ").append("[binary...]");
        sb.append(", ").append(classfiyField);
        sb.append(", ").append(filename);

        sb.append(")");
        return sb.toString();
    }
}
