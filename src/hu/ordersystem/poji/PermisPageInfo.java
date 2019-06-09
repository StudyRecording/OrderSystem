package hu.ordersystem.poji;

public class PermisPageInfo {
	
	//用户登录账号（手机号）
	private String loginName;
	private String role;
	public PermisPageInfo(String loginName, String role, String persionName, String persionSex, String persionDepart,
			String persionIdnum, boolean hava) {
		super();
		this.loginName = loginName;
		this.role = role;
		this.persionName = persionName;
		this.persionSex = persionSex;
		this.persionDepart = persionDepart;
		this.persionIdnum = persionIdnum;
		this.hava = hava;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public PermisPageInfo(String loginName, String persionName, String persionSex, String persionDepart,
			String persionIdnum, boolean hava) {
		super();
		this.loginName = loginName;
		this.persionName = persionName;
		this.persionSex = persionSex;
		this.persionDepart = persionDepart;
		this.persionIdnum = persionIdnum;
		this.hava = hava;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	//姓名
	private String persionName;
	
	//性别
	private String persionSex;
	
	//部门
	private String persionDepart;
	
	//身份证号
	private String persionIdnum;
	
	//是否已经存在
	private boolean hava;

	public String getPersionName() {
		return persionName;
	}

	public void setPersionName(String persionName) {
		this.persionName = persionName;
	}

	public String getPersionSex() {
		return persionSex;
	}

	public void setPersionSex(String persionSex) {
		this.persionSex = persionSex;
	}

	public String getPersionDepart() {
		return persionDepart;
	}

	public void setPersionDepart(String persionDepart) {
		this.persionDepart = persionDepart;
	}

	public String getPersionIdnum() {
		return persionIdnum;
	}

	public void setPersionIdnum(String persionIdnum) {
		this.persionIdnum = persionIdnum;
	}

	public boolean isHava() {
		return hava;
	}

	public void setHava(boolean hava) {
		this.hava = hava;
	}

	public PermisPageInfo(String persionName, String persionSex, String persionDepart, String persionIdnum,
			boolean hava) {
		super();
		this.persionName = persionName;
		this.persionSex = persionSex;
		this.persionDepart = persionDepart;
		this.persionIdnum = persionIdnum;
		this.hava = hava;
	}

	public PermisPageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PermisPageInfo [loginName=" + loginName + ", role=" + role + ", persionName=" + persionName
				+ ", persionSex=" + persionSex + ", persionDepart=" + persionDepart + ", persionIdnum=" + persionIdnum
				+ ", hava=" + hava + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hava ? 1231 : 1237);
		result = prime * result + ((loginName == null) ? 0 : loginName.hashCode());
		result = prime * result + ((persionDepart == null) ? 0 : persionDepart.hashCode());
		result = prime * result + ((persionIdnum == null) ? 0 : persionIdnum.hashCode());
		result = prime * result + ((persionName == null) ? 0 : persionName.hashCode());
		result = prime * result + ((persionSex == null) ? 0 : persionSex.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		PermisPageInfo other = (PermisPageInfo) obj;
		if (hava != other.hava)
			return false;
		if (loginName == null) {
			if (other.loginName != null)
				return false;
		} else if (!loginName.equals(other.loginName))
			return false;
		if (persionDepart == null) {
			if (other.persionDepart != null)
				return false;
		} else if (!persionDepart.equals(other.persionDepart))
			return false;
		if (persionIdnum == null) {
			if (other.persionIdnum != null)
				return false;
		} else if (!persionIdnum.equals(other.persionIdnum))
			return false;
		if (persionName == null) {
			if (other.persionName != null)
				return false;
		} else if (!persionName.equals(other.persionName))
			return false;
		if (persionSex == null) {
			if (other.persionSex != null)
				return false;
		} else if (!persionSex.equals(other.persionSex))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	
	
	
}
