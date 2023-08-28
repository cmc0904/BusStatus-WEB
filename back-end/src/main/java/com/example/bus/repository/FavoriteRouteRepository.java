package com.example.bus.repository;

import com.example.bus.domain.FavoritesBusRoute;

import java.util.List;
import java.util.Optional;

public interface FavoriteRouteRepository {

    String addFavoriteBusRouteItem(String routeId);

    String deleteFavoriteBusRouteItem(String routeId);
    List<String> getAllFavoriteBusRouteItem();

     boolean isExistFavoriteItemInArray(String routeId);
}
