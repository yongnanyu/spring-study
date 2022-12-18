package com.yyn.sharing.knowledge.enums;

public class EnumUtils {

	public static <T extends ValueEnum<V>, V> T getEnumByValue(T[] enums, V value) {
		for(T valueEnum : enums) {
			if (valueEnum.getValue().equals(value)) {
				return valueEnum;
			}
		}
		return null;
	}

	public static <T extends ValueEnum<V> & NameEnum<P>, V, P> P getNameByValue(T[] enums, V value) {
		if (value == null) {
			return null;
		}

		for (T valueEnum : enums) {
		    if (valueEnum.getValue().equals(value)) {
				return valueEnum.getName();
		    }
		}
		return null;
	}

	public static <T> NameEnum<T> getEnumByName(NameEnum<T>[] enums, T name) {
		for(NameEnum<T> nameEnum : enums) {
			if (nameEnum.getName().equals(name)) {
				return nameEnum;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		String value = EnumUtils.getNameByValue(UserEnum.values(),"1");
		System.out.println(value);

		UserEnum enumeration = EnumUtils.getEnumByValue(UserEnum.values(), "1");
		System.out.println(enumeration);
	}
}
