package com.yyn.sharing.knowledge.controller;

import com.yyn.spring.ioc.overview.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("1")
@RestController
@RequestMapping("/testy")
public class TestController {

	@ApiOperation("user")
	@GetMapping("/user")
	public void test(User user) {

	}
}
