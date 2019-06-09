package hu.ordersystem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hu.ordersystem.mapper.AdminMapper;
import hu.ordersystem.poji.Admin;
import hu.ordersystem.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminMapper adminMapper;
	
	@Override
	public Admin selAdmin(String adminUsername, String adminPwd) {
		return adminMapper.checkAdmin(adminUsername, adminPwd);
	}
	
	@Override
	public int updAdmin(Admin admin) {
		
		return adminMapper.updateAdmin(admin);
	}

	@Override
	public int updPwd(Admin admin) {
		
		return adminMapper.updatePwd(admin);
	}

	@Override
	public Admin selAdminByLoginName(String loginPhone) {
		return adminMapper.selAdminByLoginName(loginPhone);
	}

	@Override
	public int updAdminInfo(Admin admin) {
		return adminMapper.updAdminInfo(admin);
	}

	@Override
	public int insAdmin(Admin admin) {
		return adminMapper.insAdmin(admin);
	}

}
