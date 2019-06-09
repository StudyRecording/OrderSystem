package hu.ordersystem.service;

import hu.ordersystem.poji.Admin;

public interface AdminService {
	//查找admin账户
	Admin selAdmin(String adminUsername,String adminPwd);
	//修改admin信息
	int updAdmin(Admin admin);
	//修改admin密码
	int updPwd(Admin admin);
	
	//根据登录名（手机号）来查询用户信息
	Admin selAdminByLoginName(String loginPhone);
	
	//更新admin信息
	int updAdminInfo(Admin admin);
	
	int insAdmin(Admin admin);
}
