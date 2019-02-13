package edu.neumont.lytle.dentistoffice.models;

public class PhoneNumber {
	private int areaCode;
	private int prefix;
	private int line;
	
	public PhoneNumber() {
		
	}
	
	public PhoneNumber(int areaCode, int prefix, int line) {
		this.setAreaCode(areaCode);
		this.setPrefix(prefix);
		this.setLine(line);
	}
	
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		if(areaCode <= 0) {
			throw new IllegalArgumentException("\"areaCode\" cannot be less than 1");
		}
		this.areaCode = areaCode;
	}
	public int getPrefix() {
		return prefix;
	}
	public void setPrefix(int prefix) {
		if(prefix <= 0) {
			throw new IllegalArgumentException("\"prefix\" cannot be less than 1");
		}
		this.prefix = prefix;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		if(areaCode <= 0) {
			throw new IllegalArgumentException("\"line\" cannot be less than 1");
		}
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
