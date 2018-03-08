package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.List;

public class CKOQueryReqDTO extends BaseDTO {

    private List<Integer> regionIds;

    private String keyWord;

    public List<Integer> getRegionIds() {
        return regionIds;
    }

    public void setRegionIds(List<Integer> regionIds) {
        this.regionIds = regionIds;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
