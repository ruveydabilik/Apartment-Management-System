import java.util.Date;


class Resident {

	private int ResidentID;
	private String name;
	private String middleName;
	private String surname;
	private Date entryDate;
	private Date exitDate;

	Resident() {

	}
	
	Resident(String name, String middleName,String surname, Date entryDate, Date exitDate) {
		this.name = name;
		this.middleName = middleName;
		this.surname=surname;
		this.entryDate= entryDate;
		this.exitDate=exitDate;
	}


	Resident(int ResidentID, String name, String middleName, String surname, Date entryDate, Date exitDate) {
		this.ResidentID = ResidentID;
		this.name = name;
		this.middleName = middleName;
		this.surname=surname;
		this.entryDate= entryDate;
		this.exitDate=exitDate;
	}

	public int getResidentID() {
		return ResidentID;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}
	//public int getResidentID() { return ResidentID; }
	
	//public void setResidentID(int ResidentID) { this.ResidentID = ResidentID; }
	
	//public String getName() { return name; }
	
	//public void setName(String name) { this.name = name; }
	
	//public String getGroupName() { return groupName; }
	
	//public void setGroupName(String groupName) { this.groupName = groupName; }
	
	//public Date getModifiedDate() { return modifiedDate; }
	
	//public void setModifiedDate(Date modifiedDate) { this.modifiedDate = modifiedDate; }
	
	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "ResidentId": return ResidentID;
		case "Name": return name;
		case "MiddleName": return middleName;
		case "Surname": return surname;
		case "EntryDate": return entryDate;
		case "ExitDate": return exitDate;
		default: return null;
		}
	}

	@Override
	public String toString() {
		return "Resident{" +
				"ResidentID=" + ResidentID +
				", name='" + name + '\'' +
				", middleName='" + middleName + '\'' +
				", surname='" + surname + '\'' +
				", entryDate=" + entryDate +
				", exitDate=" + exitDate +
				'}';
	}
}