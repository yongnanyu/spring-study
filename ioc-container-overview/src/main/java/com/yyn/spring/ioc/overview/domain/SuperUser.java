package com.yyn.spring.ioc.overview.domain;

import com.yyn.spring.ioc.overview.annotation.Super;
import io.swagger.annotations.ApiModelProperty;

/**
 * 超级用户
 */
@Super
public class SuperUser extends User{
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SuperUser{" +
				"address='" + address + '\'' +
				"} " + super.toString();
	}
}
