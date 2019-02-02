package edu.neumont.lytle.dentistoffice.models;

public class InsuranceInfo {
	private String company;
	private String groupID;
	private String memberID;
	
	public InsuranceInfo() {}
	
	public InsuranceInfo(String company, String groupID, String memberID) {
		this.setCompany(company);
		this.setGroupID(groupID);
		this.setMemberID(memberID);
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		if(company == null || company.isEmpty()) {
			throw new IllegalArgumentException("\"company\" cannot be null");
		}
		this.company = company;
	}
	public String getGroupID() {
		return groupID;
	}
	public void setGroupID(String groupID) {
		if(groupID == null || groupID.isEmpty()) {
			throw new IllegalArgumentException("\"groupID\" cannot be null");
		}
		this.groupID = groupID;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		if(memberID == null || memberID.isEmpty()) {
			throw new IllegalArgumentException("\"memberID\" cannot be null");
		}
		this.memberID = memberID;
	}
	
	@Override
	public String toString() {
		return "Company: " + this.getCompany() + ", Group ID: " + this.getGroupID() + ", Member ID: " + this.getMemberID();
	}
	
	
}
