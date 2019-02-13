package edu.neumont.lytle.dentistoffice.models;

public class InsuranceInfo {
	private String company;
	private String groupID;
	private String memberID;
	
	/**
	 * Default Constructor
	 */
	public InsuranceInfo() {}
	
	/**
	 * constructor with all parameters
	 * @param String company
	 * @param String groupID
	 * @param String memberID
	 */
	public InsuranceInfo(String company, String groupID, String memberID) {
		this.setCompany(company);
		this.setGroupID(groupID);
		this.setMemberID(memberID);
	}
	
	/**
	 * gets the name of company
	 * @return String
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * sets the name of company
	 * @param String company
	 */
	public void setCompany(String company) {
		if(company == null || company.isEmpty()) {
			throw new IllegalArgumentException("\"company\" cannot be null");
		}
		this.company = company;
	}
	
	/**
	 * gets the group id of company
	 * @return String
	 */
	public String getGroupID() {
		return groupID;
	}
	
	/**
	 * sets the group id of company
	 * @param String groupID
	 */
	public void setGroupID(String groupID) {
		if(groupID == null || groupID.isEmpty()) {
			throw new IllegalArgumentException("\"groupID\" cannot be null");
		}
		this.groupID = groupID;
	}
	/**
	 * gets the member id
	 * @return String
	 */
	public String getMemberID() {
		return memberID;
	}
	
	/**
	 * sets the member id
	 * @param String memberID
	 */
	public void setMemberID(String memberID) {
		if(memberID == null || memberID.isEmpty()) {
			throw new IllegalArgumentException("\"memberID\" cannot be null");
		}
		this.memberID = memberID;
	}
	
	/**
	 * returns a string of the object
	 * @return String
	 */
	@Override
	public String toString() {
		return "Company: " + this.getCompany() + ", Group ID: " + this.getGroupID() + ", Member ID: " + this.getMemberID();
	}
	
	
}
