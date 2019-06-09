package hu.ordersystem.poji;

import java.io.Serializable;

public class Admin implements Serializable{
	private int id;
	private String adminUsername;
	private String adminPwd;
	private String adminName;
	private int adminSex;
	private String adminIdnum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public int getAdminSex() {
		return adminSex;
	}
	public void setAdminSex(int adminSex) {
		this.adminSex = adminSex;
	}
	public String getAdminIdnum() {
		return adminIdnum;
	}
	public void setAdminIdnum(String adminIdnum) {
		this.adminIdnum = adminIdnum;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminUsername=" + adminUsername + ", adminPwd=" + adminPwd + ", adminName="
				+ adminName + ", adminSex=" + adminSex + ", adminIdnum=" + adminIdnum + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminIdnum == null) ? 0 : adminIdnum.hashCode());
		result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
		result = prime * result + ((adminPwd == null) ? 0 : adminPwd.hashCode());
		result = prime * result + adminSex;
		result = prime * result + ((adminUsername == null) ? 0 : adminUsername.hashCode());
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (adminIdnum == null) {
			if (other.adminIdnum != null)
				return false;
		} else if (!adminIdnum.equals(other.adminIdnum))
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (adminPwd == null) {
			if (other.adminPwd != null)
				return false;
		} else if (!adminPwd.equals(other.adminPwd))
			return false;
		if (adminSex != other.adminSex)
			return false;
		if (adminUsername == null) {
			if (other.adminUsername != null)
				return false;
		} else if (!adminUsername.equals(other.adminUsername))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	public Admin(int id, String adminUsername, String adminPwd, String adminName, int adminSex, String adminIdnum) {
		super();
		this.id = id;
		this.adminUsername = adminUsername;
		this.adminPwd = adminPwd;
		this.adminName = adminName;
		this.adminSex = adminSex;
		this.adminIdnum = adminIdnum;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
