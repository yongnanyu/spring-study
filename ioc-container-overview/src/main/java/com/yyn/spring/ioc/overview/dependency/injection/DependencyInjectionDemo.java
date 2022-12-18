package com.yyn.spring.ioc.overview.dependency.injection;

import com.yyn.spring.ioc.overview.annotation.Super;
import com.yyn.spring.ioc.overview.domain.User;
import com.yyn.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**\
 * 依赖查找示例
 */
public class DependencyInjectionDemo {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
		UserRepository userRepository = factory.getBean("userRepository", UserRepository.class);
		System.out.println(userRepository.getUsers());
	}

}
