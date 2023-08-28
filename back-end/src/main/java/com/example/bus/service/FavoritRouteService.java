package com.example.bus.service;

import com.example.bus.domain.FavoritesBusRoute;
import com.example.bus.repository.FavoriteRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritRouteService {

    private FavoriteRouteRepository favoriteRouteRepository;

    @Autowired
    public FavoritRouteService(FavoriteRouteRepository favoriteRouteRepository) {
        this.favoriteRouteRepository = favoriteRouteRepository;
    }

    public String followRouteItem(String favoritesBusRoute) {
        try {
            Integer checkInteger = Integer.valueOf(favoritesBusRoute);

        } catch (Exception e) {
            System.out.println("favoritesBusRoute = " + favoritesBusRoute);
            return null;
        }
        String fa = favoriteRouteRepository.addFavoriteBusRouteItem(favoritesBusRoute);
        return fa;
    }

    public String unfollowRouteItem(String favoritesBusRoute) {
        String fa = favoriteRouteRepository.deleteFavoriteBusRouteItem(favoritesBusRoute);
        return fa;
    }

    public List<String> getAllFollowItems() {
        List<String> fa = favoriteRouteRepository.getAllFavoriteBusRouteItem();
        return fa;
    }

    public boolean isExistFavoriteItem(String routeId) {
        boolean fa = favoriteRouteRepository.isExistFavoriteItemInArray(routeId);
        return fa;
    }
}
