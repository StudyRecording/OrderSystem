package hu.ordersystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hu.ordersystem.poji.Restaurant;

/**
 * ���������ݿ����
 * @author 28763
 *
 */
public interface RestaurantMapper {
	
	//��ѯ����δɾ���Ĳ�������Ϣ
	@Select("select id,restaurant_name restaurantName,restaurant_addr restaurantAddr,restaurant_manager restaurantManager,restaurant_managerphone restaurantManagerphone,is_show isShow from restaurant where is_show is true")
	List<Restaurant> selRestaurantByIsShow();

	//����id��ѯ������Ϣ
	@Select("select id,restaurant_name restaurantName,restaurant_addr restaurantAddr,restaurant_manager restaurantManager,restaurant_managerphone restaurantManagerphone,is_show isShow from restaurant where id=#{0}")
	Restaurant selRestaurantById(int id);
	
	//�����ķ�ҳ��ѯ
	@Select("select id,restaurant_name restaurantName,restaurant_addr restaurantAddr,restaurant_manager restaurantManager,restaurant_managerphone restaurantManagerphone,is_show isShow from restaurant where is_show is true limit #{param1},#{param2}")
	List<Restaurant> selRestaurantPaging(int startId,int pageSize);
	
	//��ѯ��������ʾ(δɾ���Ĳ���)����Ŀ
	@Select("select count(*) from restaurant where is_show is true")
	int selPestaurantShowCount();
	
	//���²�����Ϣ
	//@Update("update restaurant set restaurant_name=#{param1},restaurant_addr=#{param2},restaurant_manager=#{param3},restaurant_managerphone=#{param4} where id=#{param5}")
	//int updRestaurantById(String name,String addr,String manager,String phone,int id);
	@Update("update restaurant set restaurant_name=#{restaurantName},restaurant_addr=#{restaurantAddr},restaurant_manager=#{restaurantManager},restaurant_managerphone=#{restaurantManagerphone} where id=#{id}")
	int updRestaurantById(Restaurant restaurant);
	
	//���ݸ����˵绰���Ҹ���������
	@Select("select restaurant_manager from restaurant where restaurant_managerphone=#{0} limit 1")
	String selRestaurantManagerNameByManagerPhone(String phone);
	
	
	//��Ӳ�����Ϣ
	@Insert("insert into restaurant values(default,#{restaurantName},#{restaurantAddr},#{restaurantManager},#{restaurantManagerphone},true)")
	int insRestaurantInfo(Restaurant restaurant);
	
	//αɾ��������Ϣ
	@Update("update restaurant set is_show=false where id=#{0}")
	int delRestaurantInfo(int id);
}
