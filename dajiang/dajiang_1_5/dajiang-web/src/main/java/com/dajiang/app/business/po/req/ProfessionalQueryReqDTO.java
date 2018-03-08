package com.dajiang.app.business.po.req;

import com.dajiang.app.base.po.dmo.BaseDTO;

import java.util.List;

public class ProfessionalQueryReqDTO extends BaseDTO {

    private String keyWord;

    private List<Integer> professionalTypeIds;

    private List<Integer> regionIds;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public List<Integer> getProfessionalTypeIds() {
        return professionalTypeIds;
    }

    public void setProfessionalTypeIds(List<Integer> professionalTypeIds) {
        this.professionalTypeIds = professionalTypeIds;
    }

    public List<Integer> getRegionIds() {
        return regionIds;
    }

    public void setRegionIds(List<Integer> regionIds) {
        this.regionIds = regionIds;
    }
}
