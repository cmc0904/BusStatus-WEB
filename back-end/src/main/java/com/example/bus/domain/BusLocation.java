package com.example.bus.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BusLocation {

    private String endBus;
    private String lowPlate;
    private String plateNo;
    private String plateType;
    private String remainSeatCnt;
    private String routeId;
    private String stationId;
    private String stationSeq;

}
