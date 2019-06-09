package hu.ordersystem.service;

import java.util.List;

import hu.ordersystem.poji.BackUp;

public interface BackupService {
	int insBackupInfo(BackUp backup);
	
	List<BackUp> selPageBackup(int startId,int pageSize);
	
	int selAllBackupCount();
	
	BackUp selBackupById(int id);
}
