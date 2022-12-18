package com.yyn.sharing.knowledge.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DefaultEnum implements NameValueEnum<String, String>{
	;

	private final String name;
	private final String value;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getValue() {
		return this.value;
	}
}
