package org.quetzaco.experts.enums;

public enum ProjectStatus {
	UNSET("0"), SET("SET"), EXTRACTSET("EXTRACTSET"), CONFIRM("CONFIRM"), CONFIRMED("CONFIRMED");
	
	private String value;
	
	private ProjectStatus(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
