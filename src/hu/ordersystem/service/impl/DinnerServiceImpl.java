package hu.ordersystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hu.ordersystem.mapper.DinnerMapper;
import hu.ordersystem.poji.Dining;
import hu.ordersystem.service.DinnerService;

@Service
public class DinnerServiceImpl implements DinnerService {

	@Resource
	private DinnerMapper dinnerMapper;

	//�������һ����������
	@Override
	public Dining selLastOneOrderNumber() {
		
		return dinnerMapper.selLastOneOrderNumber();
	}

	//����һ�������Ϣ
	@Override
	public int insDining(Dining dinner) {
		return dinnerMapper.insDinner(dinner);
	}

	//��ҳ��ѯһҳ������
	@Override
	public List<Dining> selPageDinner(int startId, int pageSize) {
		return dinnerMapper.selPageDinner(startId, pageSize);
	}

	//��ѯ�������ݵ�����
	@Override
	public int selDinnerCount() {
		return dinnerMapper.setDinnerCount();
	}

	//�����ɲ����ڲ�ѯ����
	@Override
	public List<Dining> selPageDinnerByDinnerDate(int StartId, int pageSize, String dinnerStartDate,
			String dinnerEndDate) {
		return dinnerMapper.selPageDinnerByDinnerDate(StartId, pageSize, dinnerStartDate, dinnerEndDate);
	}

	//�����ɲ����ڼ��������������������
	@Override
	public int selDinnerCountByDinnerDate(String dinnerStartDate, String dinnerEndDate) {
		return dinnerMapper.selDinnerCountByDinnerDate(dinnerStartDate, dinnerEndDate);
	}
	
	
}
