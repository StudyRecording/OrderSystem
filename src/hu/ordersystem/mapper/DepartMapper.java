package hu.ordersystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hu.ordersystem.poji.Depart;

/**
 * 部门的数据库操作
 * @author 28763
 *
 */
public interface DepartMapper {

	//根据id查询部门信息
	@Select("select id,depart_name departName from depart where id=#{0}")
	Depart selDepartById(int id);
	
	//查询所有数据
	@Select("select id,depart_name departName,isShow from depart where isShow is true")
	List<Depart> selAllDepart();
	
	//部门总数
	@Select("select count(*) from depart where isShow is true")
	int selAllDepartCount();
	
	//查询固定id范围内的数据
	@Select("select id,depart_name departName from depart where id>=#{param1} and id<=#{param2} and isShow is true") 
	List<Depart> selDepartByIdRange(int startId,int endId);
	 
	@Update("update depart set depart_name=#{param1} where id=#{param2} and isShow is true")
	int updDepartById(String name,int id);
	
	@Select("select id,depart_name departName from depart where isShow is true limit #{param1},#{param2}")
	List<Depart> selDepartPaging(int startId,int pageSize);
	
	@Delete("delete from depart where id=#{0}")
	int delDepartById(int id);
	
	@Insert("insert into depart values(default,#{0},true)")
	int insertDepart(String name);
}
