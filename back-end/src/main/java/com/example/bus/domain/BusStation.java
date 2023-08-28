package com.example.bus.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BusStation {
    private String centerYn;
    private String districtCd;
    private String mobileNo;
    private String regionName;
    private String stationId;
    private String stationName;
    private String x;
    private String y;
    private String stationSeq;
    private boolean turnYn;

}
