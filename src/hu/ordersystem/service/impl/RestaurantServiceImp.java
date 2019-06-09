package hu.ordersystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hu.ordersystem.mapper.RestaurantMapper;
import hu.ordersystem.poji.Restaurant;
import hu.ordersystem.service.RestaurantService;

@Service
public class RestaurantServiceImp implements RestaurantService {

	@Resource
	private RestaurantMapper restaurantMapper;
	
	//餐厅管理的分页查询
	@Override
	public List<Restaurant> selRestaurantPaging(int startId, int pageSize) {
		return restaurantMapper.selRestaurantPaging(startId, pageSize);
	}

	//查询能显示餐厅的数目
	@Override
	public int selRestaurantShowCount() {
		return restaurantMapper.selPestaurantShowCount();
	}

	//更改信息
	@Override
	public int updRestaurantById(Restaurant restaurant) {
		
		return restaurantMapper.updRestaurantById(restaurant);
	}

	//根据负责人电话查询负责人姓名
	@Override
	public String selRestaurantManagerNameByManagerPhone(String phone) {
		return restaurantMapper.selRestaurantManagerNameByManagerPhone(phone);
	}

	//添加餐厅信息
	@Override
	public int insRestaurantInfo(Restaurant restaurant) {
		
		return restaurantMapper.insRestaurantInfo(restaurant);
	}

	//伪删除餐厅信息
	@Override
	public int delRestaurantInfo(int id) {
		return restaurantMapper.delRestaurantInfo(id);
	}

	
	//查询所有显示的餐厅信息
	@Override
	public List<Restaurant> selRestaurantByIsShow() {
		
		return restaurantMapper.selRestaurantByIsShow();
	}

}
