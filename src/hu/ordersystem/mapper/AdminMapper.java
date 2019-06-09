package hu.ordersystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hu.ordersystem.poji.Admin;

/**
 * 管理员的相关数据层操作
 * @author 28763
 *
 */
public interface AdminMapper {
	
	//根据用户名和密码查询admin是否存在
	@Select("select id,admin_username adminUsername,admin_pwd adminPwd,admin_name adminName,admin_sex adminSex,admin_idnum adminIdnum from administrator where admin_username=#{param1} and admin_pwd=#{param2}")
	Admin checkAdmin(String adminUsername,String adminPwd);
	
	//更新admin账户信息
	@Update("update administrator set admin_sex=#{adminSex},admin_name=#{adminName},admin_idnum=#{adminIdnum} where id=#{id}")
	int updateAdmin(Admin admin);
	
	//更改admin账户密码
	@Update("update administrator set admin_pwd=#{adminPwd} where id=#{id}")
	int updatePwd(Admin admin);
	
	//根据登录名（手机号）来查询用户信息
	@Select("select id,admin_username adminUsername,admin_pwd adminPwd,admin_name adminName,admin_sex adminSex,admin_idnum adminIdnum from administrator where admin_username=#{0}")
	Admin selAdminByLoginName(String loginPhone);
	
	//更新admin的部分信息
	@Update("update administrator set admin_idnum=#{adminIdnum},admin_name=#{adminName},admin_sex=#{adminSex} where admin_username=#{adminUsername} ")
	int updAdminInfo(Admin admin);
	
	//添加admin信息
	@Insert("insert into administrator values(default,#{adminUsername},#{adminPwd},#{adminName},#{adminSex},#{adminIdnum})")
	int insAdmin(Admin admin);
}
