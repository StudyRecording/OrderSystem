package hu.ordersystem.service;

import hu.ordersystem.poji.Admin;

public interface AdminService {
	//����admin�˻�
	Admin selAdmin(String adminUsername,String adminPwd);
	//�޸�admin��Ϣ
	int updAdmin(Admin admin);
	//�޸�admin����
	int updPwd(Admin admin);
	
	//���ݵ�¼�����ֻ��ţ�����ѯ�û���Ϣ
	Admin selAdminByLoginName(String loginPhone);
	
	//����admin��Ϣ
	int updAdminInfo(Admin admin);
	
	int insAdmin(Admin admin);
}
