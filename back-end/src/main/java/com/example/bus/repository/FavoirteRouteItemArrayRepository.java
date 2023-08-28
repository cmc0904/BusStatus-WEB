package com.example.bus.repository;

import com.example.bus.domain.FavoritesBusRoute;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FavoirteRouteItemArrayRepository implements FavoriteRouteRepository{

    private static final List<String> favoritesBusRouteList = new ArrayList<>();

    @Override
    public String addFavoriteBusRouteItem(String routeId) {
        favoritesBusRouteList.add(routeId);

        return routeId;
    }

    @Override
    public String deleteFavoriteBusRouteItem(String routeId) {
        favoritesBusRouteList.remove(favoritesBusRouteList.indexOf(routeId));
        return routeId;
    }

    @Override
    public List<String> getAllFavoriteBusRouteItem() {
        return favoritesBusRouteList;
    }

    @Override
    public boolean isExistFavoriteItemInArray(String routeId) {
        return !favoritesBusRouteList.contains(routeId);
    }
}
