package hu.ordersystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hu.ordersystem.mapper.PersonnelMapper;
import hu.ordersystem.poji.Personnel;
import hu.ordersystem.service.PersonnelService;

@Service
public class PersonnelServiceImpl implements PersonnelService {

	@Resource
	private PersonnelMapper personnelMapper;
	
	//查询所有订餐人数据
	@Override
	public List<Personnel> selAllPersonnel() {
		
		return personnelMapper.selPersonnel();
	}

	//分页查询订餐人数据
	@Override
	public List<Personnel> selPersonnelPage(int startId, int endId) {
		
		return personnelMapper.selPersonnelPage(startId, endId);
	}

	//查询订餐人的数据总数
	@Override
	public int selAllPersonnelCount() {
		
		return personnelMapper.selAllPersonnelCount();
	}

	//根据条件查找订餐人的信息
	@Override
	public List<Personnel> selPersonnelByCondition(String personnelName, String personnelIdnum, String departName,String restaurantName) {
		
		return personnelMapper.selPersonnelByCondition(personnelName, personnelIdnum, departName, restaurantName);
	}

	//符合条件的数据数
	@Override
	public int selPersonnelByConditionCount(String personnelName, String personnelIdnum, String departName,
			String restaurantName) {
		
		return personnelMapper.selPersonnelByConditionCount(personnelName, personnelIdnum, departName, restaurantName);
	}

	//符合手机号的一条信息
	@Override
	public Personnel selPersonnelByPhoneLimitOne(String phone) {
		return personnelMapper.selPersonnelByPhoneLimitOne(phone);
	}

	//插入一条订餐信息
	@Override
	public int insPersonnel(Personnel personnel) {
		return personnelMapper.insPersonnel(personnel);
	}

	//根据手机号和创建时间查找信息
	@Override
	public Personnel selPersonnelByPhoneAndDate(Personnel personnel) {
		return personnelMapper.selPersonnelByPhoneAndDate(personnel);
	}

	//根据电话号码查找一条详细的信息
	@Override
	public Personnel selPersonnelByPhone(String phone) {
		return personnelMapper.selPersonnelByPhone(phone);
	}

	//更新personnel的信息
	@Override
	public int udpPersonnelInfo(Personnel personnel) {
		return personnelMapper.udpPersonnelInfo(personnel);
	}

}
