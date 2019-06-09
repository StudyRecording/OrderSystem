package hu.ordersystem.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.ordersystem.poji.Admin;
import hu.ordersystem.poji.BackUp;
import hu.ordersystem.poji.Depart;
import hu.ordersystem.poji.PermisPageInfo;
import hu.ordersystem.poji.Personnel;
import hu.ordersystem.poji.TableReturn;
import hu.ordersystem.service.AdminService;
import hu.ordersystem.service.BackupService;
import hu.ordersystem.service.DepartService;
import hu.ordersystem.service.PersonnelService;

@Controller
@RequestMapping("/set")
public class SetPageController {

	private final Logger logger=Logger.getLogger(SetPageController.class);
	
	@Resource
	private AdminService adminServiceImpl;
	
	@Resource
	private PersonnelService personnelServiceImpl;
	
	@Resource
	private DepartService departServiceImpl;
	
	@Resource
	private BackupService backupServiceImpl;
	
	/**
	 * ҳ����ת���޸ĸ�����Ϣҳ��
	 * @return
	 */
	@RequestMapping("/persionInfo")
	public String persionInfo() {
		return "set/persionInfo";
	}
	@RequestMapping("/accountPrivileges")
	public String accountPrivileges() {
		return "set/accountPrivileges";
	}
	
	@RequestMapping("/backup")
	public String backup() {
		return "set/backup";
	}
	/**
	 * ҳ����ת���޸��������
	 * @return
	 */
	@RequestMapping("/pwdChange")
	public String pwdChange() {
		return "set/pwdChange";
	}
	
	/**
	 * δ����ajax���������޸ĸ�����Ϣ
	 * @param map
	 * @param req
	 * @param resp
	 * @return
	 */
//	@RequestMapping("/updateAdmin")
//	@ResponseBody
//	public void updateAdmin(@RequestParam("adminName") String adminName,@RequestParam("adminSex") String adminSex,@RequestParam("adminIdnum") String adminIdnum,HttpServletRequest req) {
//		
//		System.out.println("ִ��updateAdmin");
//		Admin admin=new Admin();
//		admin.setAdminIdnum(adminIdnum);
//		admin.setAdminSex(Integer.parseInt(adminSex));
//		admin.setAdminName(adminName);
//		int id=((Admin)req.getSession().getAttribute("admin")).getId();		
//		admin.setId(id);
//		
//		int index=adminServiceImpl.updAdmin(admin);
//		if(index>0) {
//			System.out.println("�޸ĳɹ�");
//		}else {
//			System.out.println("�޸�ʧ��");
//		}
//	}
	
	/**
	 * ����ajax���������޸ĸ�����Ϣ
	 * @param map	��ҳ���д�����������
	 * @param req	HttpServletRequest
	 * @return		���ݿ��޸ĵ�������������
	 */
	@RequestMapping("/updateAdmin")
	@ResponseBody
	public int updateAdmin(@RequestBody Map<String,String> map,HttpServletRequest req) {
		
		
		Admin admin=new Admin();
		admin.setAdminIdnum(map.get("adminIdnum"));
		admin.setAdminSex(Integer.parseInt(map.get("adminSex")));
		admin.setAdminName(map.get("adminName"));
		int id=((Admin)req.getSession().getAttribute("admin")).getId();		
		admin.setId(id);
		
		int index=adminServiceImpl.updAdmin(admin);

		return index;
	}
	
	/**
	 * �޸�����(ajax����)
	 * @param map ��ҳ���д�������ֵ
	 * @param req HttpServletRequest
	 * @return	     ���ݿ�����ִ�гɹ�������
	 */
	@RequestMapping("/updatePwd")
	@ResponseBody
	public String updatePwd(@RequestParam("newPwd") String newPwd,HttpServletRequest req) {
		
		
		Admin admin=new Admin();
		//admin.setAdminPwd(map.get("newPwd"));
		admin.setAdminPwd(newPwd);
		
		int id=((Admin)req.getSession().getAttribute("admin")).getId();		
		admin.setId(id);
		int index=adminServiceImpl.updPwd(admin);
		if(index>0) {
			Admin ad=(Admin) req.getSession().getAttribute("admin");
			ad.setAdminPwd(newPwd);
			req.getSession().setAttribute("admin", ad);
			return "<h2>Password is changed</h2>";
		}else {
			return "<h2>Password change failed</h2>";
		}
		
	}
	
	@RequestMapping("/searchAccount")
	public String searchAccount(String loginUser,HttpServletRequest req) {
		Admin admin=adminServiceImpl.selAdminByLoginName(loginUser);
		String sex=null;
		
		if(admin!=null) {
			if(admin.getAdminSex()==1) {
				sex="��";
			}else if(admin.getAdminSex()==0) {
				sex="Ů";
			}else {
				sex="";
			}
			PermisPageInfo ppi=new PermisPageInfo(loginUser, "admin",admin.getAdminName(),
					sex, "ϵͳ����Ա", admin.getAdminIdnum(), true);
			req.setAttribute("accountPermis", ppi);
			
		}else {
			Personnel personnel=personnelServiceImpl.selPersonnelByPhone(loginUser);
			System.out.println(personnel);
			if(personnel!=null) {
				int personnelSex=personnel.getPersonnelSex();
				if(personnelSex==1) {
					sex="��";
				}else if(personnelSex==0) {
					sex="Ů";
				}else {
					sex="";
				}
				PermisPageInfo ppi=new PermisPageInfo(loginUser,"normolUser",
						personnel.getPersonnelName(), sex, 
						personnel.getDepart().getDepartName(), 
						personnel.getPersonnelIdnum(), true);
				
				req.setAttribute("accountPermis", ppi);
			}else {
				PermisPageInfo ppi=new PermisPageInfo(loginUser,"", "", "", "", "", false);
				req.setAttribute("accountPermis", ppi);
			}
			
		}
		
		List<Depart> departList=departServiceImpl.selAllDepart();
		System.out.println(departList);
		req.setAttribute("allDepart", departList);
		
		return "set/permisUpdate";
	}
	
	/**
	 * ajax�û�Ȩ�޸���
	 * @param map ����json��Ϣ
	 * @param req
	 * @return
	 */
	@RequestMapping("/permissionAssignment")
	@ResponseBody
	public int permissionAssignment(@RequestBody Map<String,String> map,HttpServletRequest req) {
		System.out.println("map�����ݣ�"+map);
		String role=map.get("role");
		System.out.println("role��ֵ��"+role);
		int num=0;
		if(role.equals("admin")) {
			Admin admin=new Admin();
			admin.setAdminIdnum(map.get("persionIdnum"));
			admin.setAdminName(map.get("persionName"));
			//admin.setAdminPwd("000000");
			admin.setAdminSex(Integer.parseInt(map.get("persionSex")));
			admin.setAdminUsername(map.get("loginName"));
			System.out.println("admin������"+admin);
			if(map.get("hava").equals("true")) {
				//����
				num=adminServiceImpl.updAdminInfo(admin);
			}else {
				//����
				admin.setAdminPwd("000000");
				num=adminServiceImpl.insAdmin(admin);
				System.out.println("admin��num"+num);
			}
		}else {
			Personnel personnel=new Personnel();
			personnel.setDepartId(Integer.parseInt(map.get("persionDepart")));
	
			personnel.setPersonnelIdnum(map.get("persionIdnum"));
			personnel.setPersonnelName(map.get("persionName"));
			personnel.setPersonnelPhone(map.get("loginName"));
			personnel.setPersonnelSex(Integer.parseInt(map.get("persionSex")));
			
			
			
			if(map.get("hava").equals("true")) {
				//����
				num=personnelServiceImpl.udpPersonnelInfo(personnel);
			}else {
				//����
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
				String date=dateFormat.format(new Date());
				personnel.setPersonnelDate(date);
				//Ĭ�϶�����
				personnel.setRestaurantId(2);
				
				num=personnelServiceImpl.insPersonnel(personnel);
				
			}
				
		}
		return num;
	}
	
	@RequestMapping("/addBackup")
	@ResponseBody
	public int addBackup(HttpServletRequest req) {
		//�������
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String date=dateFormat.format(new Date());
		BackUp backup=new BackUp();
		backup.setBackupDate(date);
		//��ò�����
		String adminName=((Admin)req.getSession().getAttribute("admin")).getAdminName();
		backup.setBackupName(adminName);
		//��ñ���·��
		String path=req.getServletContext().getRealPath("/backup");
		//System.out.println("path·����"+path);
		String fileName=date+".sql";
		String pathAll=path+"/"+fileName;
		//pathAll=pathAll.replaceAll("\", "//");
		backup.setBackupPath(pathAll);
		boolean flage=false;
		int num=0;
		try {
			flage=exportDatabaseTool(path,fileName);
		} catch (InterruptedException e) {
			System.out.println("����ʧ��");
			
		}
		if(flage) {
			num=backupServiceImpl.insBackupInfo(backup);
		}
		
		return num;
	}
	
	//��ȡ���ݱ����Ϣ
	@RequestMapping("/getBackup")
	@ResponseBody
	public TableReturn<BackUp> getBackup(int page,int limit){
		
		int startId=(page-1)*limit+1;
		int pageSize=limit;
		List<BackUp> backupList=backupServiceImpl.selPageBackup(startId-1, pageSize);
		int total=backupServiceImpl.selAllBackupCount();
		TableReturn<BackUp> tr=new TableReturn<BackUp>(total, 0, "", backupList);
		
		return tr;
	}
	
	@RequestMapping("/restore")
	@ResponseBody
	public int restore(@Param("id") int id) {
		//��ȡ�����ļ�·��
		BackUp backup=backupServiceImpl.selBackupById(id);
		String path=backup.getBackupPath();
		System.out.println("·��Ϊ��"+path);
		//��ԭ������
		String command = "mysql -hlocalhost -uscott -phu970218 --default-character-set=utf8 order_system";
		
		//ִ��
		boolean isSuccess = recover(command, path);
		if(isSuccess) {
			System.out.println("ִ�гɹ�");
			return 1;
		}else{
			System.out.println("ִ��ʧ��");
			return 0;
		}
	}
	/**
	 * ���ݿⱸ�ݹ���
	 * @param savePath ����·��
	 * @param fileName �ļ���
	 * @return
	 * @throws InterruptedException
	 */
    private boolean exportDatabaseTool( String savePath, String fileName) throws InterruptedException {  
        File saveFile = new File(savePath);  
        if (!saveFile.exists()) {// ���Ŀ¼������  
            saveFile.mkdirs();// �����ļ���  
        }  
        if(!savePath.endsWith(File.separator)){  
            savePath = savePath + File.separator;  
        }  
          
        PrintWriter printWriter = null;  
        BufferedReader bufferedReader = null;  
        try {  
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));  
            Process process = Runtime.getRuntime().exec(" mysqldump -h127.0.0.1 -uscott -phu970218 --set-charset=UTF8 order_system");  
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");  
            bufferedReader = new BufferedReader(inputStreamReader);  
            String line;  
            while((line = bufferedReader.readLine())!= null){  
                printWriter.println(line);  
            }  
            printWriter.flush();  
            if(process.waitFor() == 0){//0 ��ʾ�߳�������ֹ��  
                return true;  
            }  
        }catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (bufferedReader != null) {  
                    bufferedReader.close();  
                }  
                if (printWriter != null) {  
                    printWriter.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    } 
    
    /**
     * ���ݿ⻹ԭ
     * @param command ������
     * @param savePath ��ԭ·��
     * @return
     */
    private boolean recover(String command, String savePath) {
        boolean flag;
        Runtime r = Runtime.getRuntime();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            Process p = r.exec(command);
            OutputStream os = p.getOutputStream();
            FileInputStream fis = new FileInputStream(savePath);
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            br = new BufferedReader(isr);
            String s;
            StringBuffer sb = new StringBuffer("");
            while ((s = br.readLine()) != null) {
                sb.append(s + System.lineSeparator());
            }
            s = sb.toString();
            OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
            bw = new BufferedWriter(osw);
            bw.write(s);
            bw.flush();
            flag = true;
        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
        } finally {
            try {
                if (null != bw) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
 
            try {
                if (null != br) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
