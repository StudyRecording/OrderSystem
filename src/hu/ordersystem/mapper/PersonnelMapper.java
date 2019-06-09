package hu.ordersystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hu.ordersystem.poji.Personnel;

/**
 * 对订餐人员的数据库操作
 * @author 28763
 *
 */
public interface PersonnelMapper {
	//查询所有订餐人员的信息(采用N+1方式，配置文件:PersonnelMapper.xml)
	List<Personnel> selPersonnel();
	
	//分页查询
	List<Personnel> selPersonnelPage(int startId,int endId);
	
	//查询订餐人数据总数
	int selAllPersonnelCount();
	
	//根据条件动态查找订餐人信息
	List<Personnel> selPersonnelByCondition(
			@Param("personnelName") String personnelName,
			@Param("personnelIdnum") String personnelIdnum,
			@Param("departName") String departName,
			@Param("restaurantName") String restaurantName
			);

	//根据条件动态查找订餐人信息的数据总数
	int selPersonnelByConditionCount(
			@Param("personnelName") String personnelName,
			@Param("personnelIdnum") String personnelIdnum,
			@Param("departName") String departName,
			@Param("restaurantName") String restaurantName
			);
	
	//根据电话号码查找订餐人一条信息	
	Personnel selPersonnelByPhoneLimitOne(@Param("phone") String phone);
	
	//根据电话号码查找订餐人的一条信息
	Personnel selPersonnelByPhone(String phone);
	//插入一条订餐人信息
	int insPersonnel(Personnel personnel);
	
	//根据创建时间和手机号查找个人信息
	Personnel selPersonnelByPhoneAndDate(Personnel personnel);
	
	//根据id查询个人信息
	Personnel selPersonnelById(int id);
	
	//更新personnel信息
	int udpPersonnelInfo(Personnel personnel);
	
}
