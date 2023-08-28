package com.example.bus.service;

import com.example.bus.component.BusInfoCrawler;

import com.example.bus.domain.Bus;
//import com.example.bus.domain.MessageBody;
import com.example.bus.domain.MessageBodyBus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BusApiService {
    private final BusInfoCrawler busInfoCrawler;

    public BusApiService(BusInfoCrawler busInfoCrawler) {
        this.busInfoCrawler = busInfoCrawler;
    }


    public Bus getBusListById(String busNum) throws Exception {
        Bus<List<MessageBodyBus>> busRouteList = busInfoCrawler.getBusRouteList(busNum);


        return busRouteList;
    }

    public Bus getRouteInformation(String routeId) throws Exception {
        Bus busRouteList = busInfoCrawler.getBusRouteInformation(routeId);

        return busRouteList;
    }

    public Bus getRouteStations(String routeId) throws Exception {
        Bus busRouteList = busInfoCrawler.getRouteStations(routeId);

        return busRouteList;
    }

    public Bus getBusLocation(String routeId) throws Exception {
        Bus busRouteList = busInfoCrawler.getBusLocations(routeId);

        return busRouteList;
    }

}

