package hu.ordersystem.service;

import java.util.List;

import hu.ordersystem.poji.Restaurant;

public interface RestaurantService {
	
	List<Restaurant> selRestaurantPaging(int startId,int pageSize);
	
	int selRestaurantShowCount();
	
	int updRestaurantById(Restaurant restaurant);
	
	String selRestaurantManagerNameByManagerPhone(String phone);
	
	int insRestaurantInfo(Restaurant restaurant);
	
	int delRestaurantInfo(int id);
	
	List<Restaurant> selRestaurantByIsShow();
}
