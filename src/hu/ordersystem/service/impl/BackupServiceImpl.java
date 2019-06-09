package hu.ordersystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hu.ordersystem.mapper.BackupMapper;
import hu.ordersystem.poji.BackUp;
import hu.ordersystem.service.BackupService;

@Service
public class BackupServiceImpl implements BackupService {

	@Resource
	private  BackupMapper backupMapper;
	
	@Override
	public int insBackupInfo(BackUp backup) {
		return backupMapper.insBackupInfo(backup);
	}

	//��ѯ���еı�����Ϣ
	@Override
	public List<BackUp> selPageBackup(int startId,int pageSize) {
		return backupMapper.selPageBackup(startId,pageSize);
	}

	//��ѯ�������ݵ�����
	@Override
	public int selAllBackupCount() {
		return backupMapper.selAllBackupCount();
	}

	//����id��ѯ������Ϣ
	@Override
	public BackUp selBackupById(int id) {
		return backupMapper.selBackupById(id);
	}

}
