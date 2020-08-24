package cn.aimasa.hetongfenglei.pojo.vo.req;

import java.util.List;

public class VoFilesReq {
    private int nameId;
    private List<String> contents;
    private String userName;


    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
