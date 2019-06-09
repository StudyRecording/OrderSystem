package hu.ordersystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import hu.ordersystem.poji.Dining;

public interface DinnerMapper {
	
	//查找最后一个订单单号
	@Select("select order_number orderNumber from dining order by id DESC limit 1")
	Dining selLastOneOrderNumber();
	
	//新增一条订餐信息
	@Insert("insert into dining values(default,#{orderNumber},#{personnelId},#{dinnerNumber},#{orderDate},#{dinnerDate},#{dinnerTime},#{dinnerWay},#{dinnerInstructions})")
	int insDinner(Dining dinner);
	
	//分页查询所有的信息
	List<Dining> selPageDinner(int StartId,int pageSize);
	
	//查询表中数据数量
	@Select("select count(*) from dining")
	int setDinnerCount();
	
	//根据派餐日期分页搜索所有信息
	List<Dining> selPageDinnerByDinnerDate(int StartId,int pageSize,String dinnerStartDate,String dinnerEndDate);

	//根据派餐日期分页搜索数据的数量
	@Select("select count(*) from dining where dinner_date>=#{param1} and dinner_date<=#{param2}")
	int selDinnerCountByDinnerDate(String dinnerStartDate,String dinnerEndDate);
}
