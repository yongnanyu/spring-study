package com.yyn.sharing.knowledge.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TypeEnum implements NameValueEnum<String, String>{
	ME("1", "me"),
	YOU("2", "you");

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

