package edu.neumont.lytle.dentistoffice.models;

public class PhoneNumber {
	private int areaCode;
	private int prefix;
	private int line;
	
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public int getPrefix() {
		return prefix;
	}
	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		if(this.getAreaCode() < 100) {
			sb.append("0");
			if(this.getAreaCode() < 10) {
				sb.append("0");
			}
		}
		sb.append(this.getAreaCode()).append("-");
		if(this.getPrefix() < 100) {
			sb.append("0");
			if(this.getPrefix() < 10) {
				sb.append("0");
			}
		}
		
		sb.append(this.getPrefix()).append("-");
		
		if(this.getLine() < 1000) {
			sb.append("0");
			if(this.getLine() < 100) {
				sb.append("0");
				if(this.getLine() < 10) {
					sb.append("0");
				}
			}
		}
		
		sb.append(this.getLine());
		
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		PhoneNumber other = (PhoneNumber) obj;
		return (this.getAreaCode() == other.getAreaCode()) && (this.getPrefix() == other.getPrefix()) && (this.getLine() == other.getLine());
		
	}
}
