package com.example.bus.domain;

public class MessageBodyBus {

    private String districtCd;
    private String regionName;
    private String routeId;
    private String routeName;
    private String routeTypeCd;
    private String routeTypeName;

    public String getDistrictCd() {
        return districtCd;
    }
    public void setDistrictCd(String districtCd) {
        this.districtCd = districtCd;
    }
    public String getRegionName() {
        return regionName;
    }
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    public String getRouteId() {
        return routeId;
    }
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
    public String getRouteName() {
        return routeName;
    }
    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
    public String getRouteTypeCd() {
        return routeTypeCd;
    }
    public void setRouteTypeCd(String routeTypeCd) {
        this.routeTypeCd = routeTypeCd;
    }
    public String getRouteTypeName() {
        return routeTypeName;
    }
    public void setRouteTypeName(String routeTypeName) {
        this.routeTypeName = routeTypeName;
    }

}