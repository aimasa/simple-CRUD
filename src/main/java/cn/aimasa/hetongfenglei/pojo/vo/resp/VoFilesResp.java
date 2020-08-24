package cn.aimasa.hetongfenglei.pojo.vo.resp;

import cn.aimasa.hetongfenglei.pojo.bo.resp.BoFileResp;
import cn.aimasa.hetongfenglei.pojo.bo.resp.BoFilesResp;
import cn.aimasa.hetongfenglei.pojo.po.tables.File;

import java.util.List;

public class VoFilesResp {


    private List<BoFileResp> voFileRespList;
    private String Code;
    private String describe;

    public List<BoFileResp> getVoFileRespList() {
        return voFileRespList;
    }

    public void setVoFileRespList(List<BoFileResp> voFileRespList) {
        this.voFileRespList = voFileRespList;
    }

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
}
