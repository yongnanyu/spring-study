package com.yyn.spring.ioc.overview.dependency.lookup;

import com.yyn.spring.ioc.overview.annotation.Super;
import com.yyn.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**\
 * 依赖查找示例
 */
public class DependencyLookupDemo {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
//		lookupRealTime(factory);
//		lookupInLazy(factory);
		lookupByType(factory);
		// 查找集合对象
		lookupByCollectionType(factory);
		// 通过注解查找
		lookupByAnnotationType(factory);
	}

	private static void lookupByAnnotationType(BeanFactory factory) {
		if (factory instanceof ListableBeanFactory listableBeanFactory) {
			Map<String, Object> userMap = listableBeanFactory.getBeansWithAnnotation(Super.class);
			userMap.forEach((k, v) -> {
				if (v instanceof User user) {
					System.out.println("c查找到的所有@super的User集合对象" + user);
				}
			});

		}
	}

	private static void lookupByCollectionType(BeanFactory factory) {
		if (factory instanceof ListableBeanFactory listableBeanFactory) {
			Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
			System.out.println("c查找到的所有User集合对象" + userMap);
		}
	}

	private static void lookupByType(BeanFactory factory) {
		User user = factory.getBean(User.class);
		System.out.println("实时查找" + user.toString());
	}

	private static void lookupInLazy(BeanFactory factory) {
		ObjectFactory<User> objectFactory = (ObjectFactory<User>) factory.getBean("objectFactory");
		User user = objectFactory.getObject();
		System.out.println("延时查找" + user.toString());
	}

	private static void lookupRealTime(BeanFactory factory) {
		User user = (User) factory.getBean("user");
		System.out.println("实时查找" + user.toString());
	}
}
