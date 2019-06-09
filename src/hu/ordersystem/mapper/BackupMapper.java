package hu.ordersystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import hu.ordersystem.poji.BackUp;

public interface BackupMapper {

	//��ӱ���
	@Insert("insert into sql_backup values(default,#{backupDate},#{backupName},#{backupPath})")
	int insBackupInfo(BackUp backup);
	
	//��ҳ��ѯ���б���
	@Select("select id,backup_date backupDate,backup_name backupName,backup_path backupPath from sql_backup limit #{param1},#{param2}")
	List<BackUp> selPageBackup(int startId,int pageSize);
	
	//��ѯ�������ݵ�����
	@Select("select count(*) from sql_backup")
	int selAllBackupCount();
	
	//����id��ѯ������Ϣ
	@Select("select id,backup_date backupDate,backup_name backupName,backup_path backupPath from sql_backup where id=#{0}")
	BackUp selBackupById(int id);
}
