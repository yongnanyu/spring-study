package com.yyn.spring.ioc.overview.repository;

import com.yyn.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;

import java.util.Collection;

/**
 * 用户仓库
 */
public class UserRepository {

	private Collection<User> users;

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	private BeanFactory beanFactory;

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
}
