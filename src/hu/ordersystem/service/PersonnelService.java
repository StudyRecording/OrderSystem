package hu.ordersystem.service;

import java.util.List;

import hu.ordersystem.poji.Personnel;

public interface PersonnelService {
	
	List<Personnel> selAllPersonnel();
	
	List<Personnel> selPersonnelPage(int startId,int endId);
	
	int selAllPersonnelCount();
	
	List<Personnel> selPersonnelByCondition(String personnelName,String personnelIdnum,String departName,String restaurantName);

	int selPersonnelByConditionCount(String personnelName,String personnelIdnum,String departName,String restaurantName);
	
	Personnel selPersonnelByPhoneLimitOne(String phone);
	
	int insPersonnel(Personnel personnel);
	
	Personnel selPersonnelByPhoneAndDate(Personnel personnel);
	
	Personnel selPersonnelByPhone(String phone);
	
	int udpPersonnelInfo(Personnel personnel);
}
