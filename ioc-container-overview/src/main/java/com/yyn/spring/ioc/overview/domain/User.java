package com.yyn.spring.ioc.overview.domain;

import com.yyn.sharing.knowledge.annotation.ApiModelEnumProperty;
import com.yyn.sharing.knowledge.enums.TypeEnum;
import io.swagger.annotations.ApiModel;

@ApiModel
public class User {

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", id=" + id +
				'}';
	}

	private String name;

	@ApiModelEnumProperty(description = "类型", enumClass = TypeEnum.class)
	private TypeEnum typeEnum;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
