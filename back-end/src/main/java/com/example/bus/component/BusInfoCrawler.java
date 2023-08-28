//package com.example.bus.component;
//
//
//import com.example.bus.domain.*;
////import com.example.bus.domain.MessageBody;
//import com.fasterxml.jackson.databind.JsonNode;
//import org.apache.http.util.EntityUtils;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClients;
//import java.io.IOException;
//import java.util.List;
//
//@Component
//public class BusInfoCrawler {
//    private static final String API_KEY = "1234567890";
//    private static final String BASE_URL = "http://openapi.gbis.go.kr/ws/rest";
//    private static ObjectMapper mapper = new XmlMapper();
//
//    public Bus getBusRouteList(String busNum) throws Exception {
//        String url = BASE_URL + "/busrouteservice?serviceKey=" + API_KEY + "&keyword=" + busNum;
//        HttpClient client = HttpClients.createDefault();
//        HttpGet request = new HttpGet(url);
//
//        HttpResponse response = client.execute(request);
//
//        Bus<List<MessageBodyBus>> value = mapper.readValue(response.getEntity().getContent(), Bus.class);
//
//        return value;
//
//    }
//
//    public Bus getBusRouteInformation(String routeId) throws Exception {
//        String url = BASE_URL + "/busrouteservice/info?serviceKey=" + API_KEY + "&routeId=" + routeId;
//        HttpClient client = HttpClients.createDefault();
//        HttpGet request = new HttpGet(url);
//        HttpResponse response = client.execute(request);
//
//        //	응답
//        Bus<MessageBodyBusRouteInformation> value = mapper.readValue(response.getEntity().getContent(), Bus.class);
//
//        return value;
//
//    }
//
//    public Bus getRouteStations(String routeId) throws Exception {
//        String url = BASE_URL + "/busrouteservice/station?serviceKey=" + API_KEY + "&routeId=" + routeId;
//        HttpClient client = HttpClients.createDefault();
//        HttpGet request = new HttpGet(url);
//        HttpResponse response = client.execute(request);
//
//        //	응답
//        Bus<List<BusStation>> value = mapper.readValue(response.getEntity().getContent(), Bus.class);
//
//        return value;
//
//    }
//
//    public Bus getBusLocations(String routeId) throws Exception {
//        String url = BASE_URL + "/buslocationservice?serviceKey=" + API_KEY + "&routeId=" + routeId;
//        HttpClient client = HttpClients.createDefault();
//        HttpGet request = new HttpGet(url);
//        HttpResponse response = client.execute(request);
//
//        //	응답
//        Bus<List<BusLocation>> value = mapper.readValue(response.getEntity().getContent(), Bus.class);
//
//        return value;
//
//    }
//
//}
//


package com.example.bus.component;

import com.example.bus.domain.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class BusInfoCrawler {
    private static final String API_KEY = "1234567890";
    private static final String BASE_URL = "http://openapi.gbis.go.kr/ws/rest";
    private static ObjectMapper mapper = new XmlMapper();

    private HttpResponse sendHttpRequest(String url) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        return client.execute(request);
    }

    private <T> Bus<T> processResponse(HttpResponse response, Class<T> valueType) throws IOException {
        Bus<T> value = mapper.readValue(EntityUtils.toString(response.getEntity()), Bus.class);
        return value;
    }

    private String buildApiUrl(String servicePath, String params) {
        return BASE_URL + servicePath + "?serviceKey=" + API_KEY + params;
    }

    public Bus getBusRouteList(String busNum) throws Exception {
        String url = buildApiUrl("/busrouteservice", "&keyword=" + busNum);
        HttpResponse response = sendHttpRequest(url);
        return processResponse(response, List.class);
    }

    public Bus getBusRouteInformation(String routeId) throws Exception {
        String url = buildApiUrl("/busrouteservice/info", "&routeId=" + routeId);
        HttpResponse response = sendHttpRequest(url);
        return processResponse(response, MessageBodyBusRouteInformation.class);
    }

    public Bus getRouteStations(String routeId) throws Exception {
        String url = buildApiUrl("/busrouteservice/station", "&routeId=" + routeId);
        HttpResponse response = sendHttpRequest(url);
        return processResponse(response, List.class);
    }

    public Bus getBusLocations(String routeId) throws Exception {
        String url = buildApiUrl("/buslocationservice", "&routeId=" + routeId);
        HttpResponse response = sendHttpRequest(url);
        return processResponse(response, List.class);
    }
}

