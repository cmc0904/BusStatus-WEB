package com.example.bus.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MessageBodyBusRouteInformation {
    private String companyId;
    private String companyName;
    private String companyTel;
    private String districtCd;
    private String downFirstTime;
    private String downLastTime;
    private String endMobileNo;
    private String endStationId;
    private String endStationName;
    private String peekAlloc;
    private String regionName;
    private String routeId;
    private String routeName;
    private String routeTypeCd;
    private String routeTypeName;
    private String startMobileNo;
    private String startStationId;
    private String startStationName;
    private String upFirstTime;
    private String upLastTime;
    private String nPeekAlloc;
}
