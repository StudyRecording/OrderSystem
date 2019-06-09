package hu.ordersystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hu.ordersystem.poji.Personnel;

/**
 * �Զ�����Ա�����ݿ����
 * @author 28763
 *
 */
public interface PersonnelMapper {
	//��ѯ���ж�����Ա����Ϣ(����N+1��ʽ�������ļ�:PersonnelMapper.xml)
	List<Personnel> selPersonnel();
	
	//��ҳ��ѯ
	List<Personnel> selPersonnelPage(int startId,int endId);
	
	//��ѯ��������������
	int selAllPersonnelCount();
	
	//����������̬���Ҷ�������Ϣ
	List<Personnel> selPersonnelByCondition(
			@Param("personnelName") String personnelName,
			@Param("personnelIdnum") String personnelIdnum,
			@Param("departName") String departName,
			@Param("restaurantName") String restaurantName
			);

	//����������̬���Ҷ�������Ϣ����������
	int selPersonnelByConditionCount(
			@Param("personnelName") String personnelName,
			@Param("personnelIdnum") String personnelIdnum,
			@Param("departName") String departName,
			@Param("restaurantName") String restaurantName
			);
	
	//���ݵ绰������Ҷ�����һ����Ϣ	
	Personnel selPersonnelByPhoneLimitOne(@Param("phone") String phone);
	
	//���ݵ绰������Ҷ����˵�һ����Ϣ
	Personnel selPersonnelByPhone(String phone);
	//����һ����������Ϣ
	int insPersonnel(Personnel personnel);
	
	//���ݴ���ʱ����ֻ��Ų��Ҹ�����Ϣ
	Personnel selPersonnelByPhoneAndDate(Personnel personnel);
	
	//����id��ѯ������Ϣ
	Personnel selPersonnelById(int id);
	
	//����personnel��Ϣ
	int udpPersonnelInfo(Personnel personnel);
	
}
