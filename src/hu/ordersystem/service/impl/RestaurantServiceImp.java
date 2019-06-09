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
	
	//��������ķ�ҳ��ѯ
	@Override
	public List<Restaurant> selRestaurantPaging(int startId, int pageSize) {
		return restaurantMapper.selRestaurantPaging(startId, pageSize);
	}

	//��ѯ����ʾ��������Ŀ
	@Override
	public int selRestaurantShowCount() {
		return restaurantMapper.selPestaurantShowCount();
	}

	//������Ϣ
	@Override
	public int updRestaurantById(Restaurant restaurant) {
		
		return restaurantMapper.updRestaurantById(restaurant);
	}

	//���ݸ����˵绰��ѯ����������
	@Override
	public String selRestaurantManagerNameByManagerPhone(String phone) {
		return restaurantMapper.selRestaurantManagerNameByManagerPhone(phone);
	}

	//��Ӳ�����Ϣ
	@Override
	public int insRestaurantInfo(Restaurant restaurant) {
		
		return restaurantMapper.insRestaurantInfo(restaurant);
	}

	//αɾ��������Ϣ
	@Override
	public int delRestaurantInfo(int id) {
		return restaurantMapper.delRestaurantInfo(id);
	}

	
	//��ѯ������ʾ�Ĳ�����Ϣ
	@Override
	public List<Restaurant> selRestaurantByIsShow() {
		
		return restaurantMapper.selRestaurantByIsShow();
	}

}
