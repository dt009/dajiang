package com.dajiang.app.base.po.dmo;

/**
 * Created by Joe on 2017/9/23.
 */
public class RegionDTO extends BaseDTO {

    private Integer regionId;

    private String regionName;

    private Integer regionLevel;

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }
}
