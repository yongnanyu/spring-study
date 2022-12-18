package com.yyn.sharing.knowledge.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserEnum implements NameEnum<String>, ValueEnum<String>{
	ME("yyn", "1");

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
