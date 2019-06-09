package hu.ordersystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hu.ordersystem.poji.Restaurant;

/**
 * 餐厅的数据库操作
 * @author 28763
 *
 */
public interface RestaurantMapper {
	
	//查询所有未删除的餐厅的信息
	@Select("select id,restaurant_name restaurantName,restaurant_addr restaurantAddr,restaurant_manager restaurantManager,restaurant_managerphone restaurantManagerphone,is_show isShow from restaurant where is_show is true")
	List<Restaurant> selRestaurantByIsShow();

	//根据id查询餐厅信息
	@Select("select id,restaurant_name restaurantName,restaurant_addr restaurantAddr,restaurant_manager restaurantManager,restaurant_managerphone restaurantManagerphone,is_show isShow from restaurant where id=#{0}")
	Restaurant selRestaurantById(int id);
	
	//餐厅的分页查询
	@Select("select id,restaurant_name restaurantName,restaurant_addr restaurantAddr,restaurant_manager restaurantManager,restaurant_managerphone restaurantManagerphone,is_show isShow from restaurant where is_show is true limit #{param1},#{param2}")
	List<Restaurant> selRestaurantPaging(int startId,int pageSize);
	
	//查询所有能显示(未删除的餐厅)的数目
	@Select("select count(*) from restaurant where is_show is true")
	int selPestaurantShowCount();
	
	//更新餐厅信息
	//@Update("update restaurant set restaurant_name=#{param1},restaurant_addr=#{param2},restaurant_manager=#{param3},restaurant_managerphone=#{param4} where id=#{param5}")
	//int updRestaurantById(String name,String addr,String manager,String phone,int id);
	@Update("update restaurant set restaurant_name=#{restaurantName},restaurant_addr=#{restaurantAddr},restaurant_manager=#{restaurantManager},restaurant_managerphone=#{restaurantManagerphone} where id=#{id}")
	int updRestaurantById(Restaurant restaurant);
	
	//根据负责人电话查找负责人姓名
	@Select("select restaurant_manager from restaurant where restaurant_managerphone=#{0} limit 1")
	String selRestaurantManagerNameByManagerPhone(String phone);
	
	
	//添加餐厅信息
	@Insert("insert into restaurant values(default,#{restaurantName},#{restaurantAddr},#{restaurantManager},#{restaurantManagerphone},true)")
	int insRestaurantInfo(Restaurant restaurant);
	
	//伪删除餐厅信息
	@Update("update restaurant set is_show=false where id=#{0}")
	int delRestaurantInfo(int id);
}
