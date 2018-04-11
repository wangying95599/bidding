package org.quetzaco.experts.enums;

public enum RecordFlag {
	CREATE("01"), DELETE("00");
	
	private String value;
	
	private RecordFlag(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
