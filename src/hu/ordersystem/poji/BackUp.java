package hu.ordersystem.poji;

public class BackUp {
	private int id;
	private String backupDate;
	private String backupName;
	private String backupPath;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBackupDate() {
		return backupDate;
	}
	public void setBackupDate(String backupDate) {
		this.backupDate = backupDate;
	}
	public String getBackupName() {
		return backupName;
	}
	public void setBackupName(String backupName) {
		this.backupName = backupName;
	}
	public String getBackupPath() {
		return backupPath;
	}
	public void setBackupPath(String backupPath) {
		this.backupPath = backupPath;
	}
	public BackUp(int id, String backupDate, String backupName, String backupPath) {
		super();
		this.id = id;
		this.backupDate = backupDate;
		this.backupName = backupName;
		this.backupPath = backupPath;
	}
	public BackUp() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BackUp [id=" + id + ", backupDate=" + backupDate + ", backupName=" + backupName + ", backupPath="
				+ backupPath + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backupDate == null) ? 0 : backupDate.hashCode());
		result = prime * result + ((backupName == null) ? 0 : backupName.hashCode());
		result = prime * result + ((backupPath == null) ? 0 : backupPath.hashCode());
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
		BackUp other = (BackUp) obj;
		if (backupDate == null) {
			if (other.backupDate != null)
				return false;
		} else if (!backupDate.equals(other.backupDate))
			return false;
		if (backupName == null) {
			if (other.backupName != null)
				return false;
		} else if (!backupName.equals(other.backupName))
			return false;
		if (backupPath == null) {
			if (other.backupPath != null)
				return false;
		} else if (!backupPath.equals(other.backupPath))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
