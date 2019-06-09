package hu.ordersystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hu.ordersystem.poji.Admin;

/**
 * ����Ա��������ݲ����
 * @author 28763
 *
 */
public interface AdminMapper {
	
	//�����û����������ѯadmin�Ƿ����
	@Select("select id,admin_username adminUsername,admin_pwd adminPwd,admin_name adminName,admin_sex adminSex,admin_idnum adminIdnum from administrator where admin_username=#{param1} and admin_pwd=#{param2}")
	Admin checkAdmin(String adminUsername,String adminPwd);
	
	//����admin�˻���Ϣ
	@Update("update administrator set admin_sex=#{adminSex},admin_name=#{adminName},admin_idnum=#{adminIdnum} where id=#{id}")
	int updateAdmin(Admin admin);
	
	//����admin�˻�����
	@Update("update administrator set admin_pwd=#{adminPwd} where id=#{id}")
	int updatePwd(Admin admin);
	
	//���ݵ�¼�����ֻ��ţ�����ѯ�û���Ϣ
	@Select("select id,admin_username adminUsername,admin_pwd adminPwd,admin_name adminName,admin_sex adminSex,admin_idnum adminIdnum from administrator where admin_username=#{0}")
	Admin selAdminByLoginName(String loginPhone);
	
	//����admin�Ĳ�����Ϣ
	@Update("update administrator set admin_idnum=#{adminIdnum},admin_name=#{adminName},admin_sex=#{adminSex} where admin_username=#{adminUsername} ")
	int updAdminInfo(Admin admin);
	
	//���admin��Ϣ
	@Insert("insert into administrator values(default,#{adminUsername},#{adminPwd},#{adminName},#{adminSex},#{adminIdnum})")
	int insAdmin(Admin admin);
}
