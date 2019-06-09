package hu.ordersystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hu.ordersystem.mapper.PersonnelMapper;
import hu.ordersystem.poji.Personnel;
import hu.ordersystem.service.PersonnelService;

@Service
public class PersonnelServiceImpl implements PersonnelService {

	@Resource
	private PersonnelMapper personnelMapper;
	
	//��ѯ���ж���������
	@Override
	public List<Personnel> selAllPersonnel() {
		
		return personnelMapper.selPersonnel();
	}

	//��ҳ��ѯ����������
	@Override
	public List<Personnel> selPersonnelPage(int startId, int endId) {
		
		return personnelMapper.selPersonnelPage(startId, endId);
	}

	//��ѯ�����˵���������
	@Override
	public int selAllPersonnelCount() {
		
		return personnelMapper.selAllPersonnelCount();
	}

	//�����������Ҷ����˵���Ϣ
	@Override
	public List<Personnel> selPersonnelByCondition(String personnelName, String personnelIdnum, String departName,String restaurantName) {
		
		return personnelMapper.selPersonnelByCondition(personnelName, personnelIdnum, departName, restaurantName);
	}

	//����������������
	@Override
	public int selPersonnelByConditionCount(String personnelName, String personnelIdnum, String departName,
			String restaurantName) {
		
		return personnelMapper.selPersonnelByConditionCount(personnelName, personnelIdnum, departName, restaurantName);
	}

	//�����ֻ��ŵ�һ����Ϣ
	@Override
	public Personnel selPersonnelByPhoneLimitOne(String phone) {
		return personnelMapper.selPersonnelByPhoneLimitOne(phone);
	}

	//����һ��������Ϣ
	@Override
	public int insPersonnel(Personnel personnel) {
		return personnelMapper.insPersonnel(personnel);
	}

	//�����ֻ��źʹ���ʱ�������Ϣ
	@Override
	public Personnel selPersonnelByPhoneAndDate(Personnel personnel) {
		return personnelMapper.selPersonnelByPhoneAndDate(personnel);
	}

	//���ݵ绰�������һ����ϸ����Ϣ
	@Override
	public Personnel selPersonnelByPhone(String phone) {
		return personnelMapper.selPersonnelByPhone(phone);
	}

	//����personnel����Ϣ
	@Override
	public int udpPersonnelInfo(Personnel personnel) {
		return personnelMapper.udpPersonnelInfo(personnel);
	}

}
