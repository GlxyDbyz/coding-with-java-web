package org.dbyz.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 实现ApplicationContextAware接口,可让 Spring 将 ApplicationContext 注入进来 以静态变量保存Spring
 * ApplicationContext, 可在任何时候任何代码任何地方中取出 ApplicaitonContext 进行使用.
 */
public final class SpringContextHolder implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext;
	}

	/**
	 * 取得存储在静态变量中的ApplicationContext.
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型
	 * 
	 * @Title: getBean
	 * @param @param name
	 * @param @return
	 * @return: T
	 * @since V1.0
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型
	 * 
	 * @Title: getBean
	 * @param @param clazz
	 * @param @return
	 * @return: T
	 * @since V1.0
	 */
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return applicationContext.getBean(clazz);
	}

	/**
	 * 清除applicationContext静态变量.
	 * 
	 * @Title: cleanApplicationContext
	 * @param
	 * @return: void
	 * @since V1.0
	 */
	public static void cleanApplicationContext() {
		applicationContext = null;
	}

	/**
	 * 检查ApplicationContext是否注入
	 * 
	 * @Title: checkApplicationContext
	 * @param
	 * @return: void
	 * @since V1.0
	 */
	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException(
					"SpringContextHolder未注入applicationContext属性");
		}
	}
}
