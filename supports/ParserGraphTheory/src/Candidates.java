
public class Candidates {
	private String firstName;
	private String surName;
	private String Sitting;
	private String gender;
	private String partyId;
	private String partyName;
	private String currentStatus;

	public Candidates(String firstName, String surName, String sitting, String gender, String partyId, String partyName,
			String currentStatus) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		Sitting = sitting;
		this.gender = gender;
		this.partyId = partyId;
		this.partyName = partyName;
		this.currentStatus = currentStatus;
	}
	
	public Candidates() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getSitting() {
		return Sitting;
	}
	public void setSitting(String sitting) {
		Sitting = sitting;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	
}
