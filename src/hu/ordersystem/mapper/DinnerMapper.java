package hu.ordersystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import hu.ordersystem.poji.Dining;

public interface DinnerMapper {
	
	//�������һ����������
	@Select("select order_number orderNumber from dining order by id DESC limit 1")
	Dining selLastOneOrderNumber();
	
	//����һ��������Ϣ
	@Insert("insert into dining values(default,#{orderNumber},#{personnelId},#{dinnerNumber},#{orderDate},#{dinnerDate},#{dinnerTime},#{dinnerWay},#{dinnerInstructions})")
	int insDinner(Dining dinner);
	
	//��ҳ��ѯ���е���Ϣ
	List<Dining> selPageDinner(int StartId,int pageSize);
	
	//��ѯ������������
	@Select("select count(*) from dining")
	int setDinnerCount();
	
	//�����ɲ����ڷ�ҳ����������Ϣ
	List<Dining> selPageDinnerByDinnerDate(int StartId,int pageSize,String dinnerStartDate,String dinnerEndDate);

	//�����ɲ����ڷ�ҳ�������ݵ�����
	@Select("select count(*) from dining where dinner_date>=#{param1} and dinner_date<=#{param2}")
	int selDinnerCountByDinnerDate(String dinnerStartDate,String dinnerEndDate);
}
