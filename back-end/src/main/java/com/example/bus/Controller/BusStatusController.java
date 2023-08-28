package com.example.bus.Controller;


import com.example.bus.domain.Bus;
//import com.example.bus.domain.MessageBody;
import com.example.bus.domain.FavoritesBusRoute;
import com.example.bus.service.FavoritRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bus.service.BusApiService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class BusStatusController {

    private final BusApiService busApiService;
    private final FavoritRouteService favoritRouteService;
    @Autowired
    public BusStatusController(BusApiService busApiService, FavoritRouteService favoritRouteService) {
        this.busApiService = busApiService;
        this.favoritRouteService = favoritRouteService;
    }

    @CrossOrigin
    @GetMapping(value = "/busLists/{busNum}/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBusLists(@PathVariable String busNum, @PathVariable String type) {
        try {
            Bus busList = busApiService.getBusListById(busNum);
            return ResponseEntity.ok(busList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin
    @GetMapping(value = "/routeInformation/{routeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRouteInformation(@PathVariable String routeId) {
        try {
            Bus busInformation = busApiService.getRouteInformation(routeId);
            return ResponseEntity.ok(busInformation);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin
    @GetMapping(value = "/routeStations/{routeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRouteStations(@PathVariable String routeId) {
        try {
            Bus busStations = busApiService.getRouteStations(routeId);
            return ResponseEntity.ok(busStations);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin
    @GetMapping(value = "/busLocation/{routeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getBusLocation(@PathVariable String routeId) {
        try {
            Bus busLocation = busApiService.getBusLocation(routeId);
            return ResponseEntity.ok(busLocation);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin
    @PostMapping("/follow/{routeId}")
    public ResponseEntity addFollowItem(@PathVariable String routeId) {
        try {
            String favoritesBusRoute = favoritRouteService.followRouteItem(routeId);
            return ResponseEntity.ok(favoritesBusRoute);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin
    @PostMapping("/unfollow/{routeId}")
    public ResponseEntity removeFollowItem(@PathVariable String routeId) {
        try {
            String favoritesBusRoute = favoritRouteService.unfollowRouteItem(routeId);
            return ResponseEntity.ok(favoritesBusRoute);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @CrossOrigin
    @GetMapping(value = "/getFollowList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllFollowList() {
        try {
            List<String> favoritesBusRoutes = favoritRouteService.getAllFollowItems();
            return ResponseEntity.ok(favoritesBusRoutes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin
    @GetMapping(value = "/chFavoriteIte/{routeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity checkFavoriteItemInArray(@PathVariable String routeId) {
        try {
            boolean favoritesBusRoutes = favoritRouteService.isExistFavoriteItem(routeId);
            return ResponseEntity.ok(favoritesBusRoutes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

