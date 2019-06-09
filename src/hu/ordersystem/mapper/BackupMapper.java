package hu.ordersystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import hu.ordersystem.poji.BackUp;

public interface BackupMapper {

	//添加备份
	@Insert("insert into sql_backup values(default,#{backupDate},#{backupName},#{backupPath})")
	int insBackupInfo(BackUp backup);
	
	//分页查询所有备份
	@Select("select id,backup_date backupDate,backup_name backupName,backup_path backupPath from sql_backup limit #{param1},#{param2}")
	List<BackUp> selPageBackup(int startId,int pageSize);
	
	//查询所有数据的数量
	@Select("select count(*) from sql_backup")
	int selAllBackupCount();
	
	//根据id查询备份信息
	@Select("select id,backup_date backupDate,backup_name backupName,backup_path backupPath from sql_backup where id=#{0}")
	BackUp selBackupById(int id);
}
