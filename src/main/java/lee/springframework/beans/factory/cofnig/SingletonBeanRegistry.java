/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: SingletonBeanRegistry.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/31
 */

package lee.springframework.beans.factory.cofnig;

/**
 * Interface that defines a registry for shared bean instances.
 * 定义单例bean注册器的接口
 * Can be implemented by {@link org.springframework.beans.factory.BeanFactory}
 * implementations in order to expose their singleton management facility
 * in a uniform manner.
 * 可以被BeanFactory实现，以暴露单例统一管理方式
 * <p>The {@link ConfigurableBeanFactory} interface extends this interface.
 *
 * @author Juergen Hoeller
 * @see ConfigurableBeanFactory
 * @see org.springframework.beans.factory.support.DefaultSingletonBeanRegistry
 * @see org.springframework.beans.factory.support.AbstractBeanFactory
 * @since 2.0
 */
public interface SingletonBeanRegistry {

  /**
   * Register the given existing object as singleton in the bean registry,
   * under the given bean name.
   * 用注册器注册指定的姓名和对应的单例
   * <p>The given instance is supposed to be fully initialized;
   * 实例已经被实例化结束
   * the registry will not perform any initialization callbacks (in particular, it won't
   * call InitializingBean's {@code afterPropertiesSet} method).
   * 注册器不会执行任何初始化的回调函数
   * The given instance will not receive any destruction callbacks
   * (like DisposableBean's {@code destroy} method) either.
   * 指定的实例不会接受任何销毁的方法
   * <p>When running within a full BeanFactory: <b>Register a bean definition
   * instead of an existing instance if your bean is supposed to receive
   * initialization and/or destruction callbacks.</b>
   * 当运行整个BeanFactory：如果需要初始化和销毁的回调函数，注册{@link BeanDefinition}
   * 而不要注册实例
   * <p>Typically invoked during registry configuration,
   * 典型的使用是注册配置，也可以运行时注册单例
   * but can also be used for runtime registration of singletons.
   * As a consequence, a registry implementation should synchronize singleton access;
   * 如果注册BeanFactory懒加载器需要同步单例
   * it will have to do
   * this anyway if it supports a BeanFactory's lazy initialization of singletons.
   *
   * @param beanName        the name of the bean
   * @param singletonObject the existing singleton object
   * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet
   * @see org.springframework.beans.factory.DisposableBean#destroy
   * @see org.springframework.beans.factory.support.BeanDefinitionRegistry#registerBeanDefinition
   */
  void registerSingleton(String beanName, Object singletonObject);

  /**
   * Return the (raw) singleton object registered under the given name.
   *
   * <p>Only checks already instantiated singletons; does not return an Object
   * for singleton bean definitions which have not been instantiated yet.
   * 只是返回实例化的bean，不会返回没有实例化的
   * <p>The main purpose of this method is to access manually registered singletons
   * (see {@link #registerSingleton}). Can also be used to access a singleton
   * defined by a bean definition that already been created, in a raw fashion.
   * <p><b>NOTE:</b> This lookup method is not aware of FactoryBean prefixes or aliases.
   * You need to resolve the canonical bean name first before obtaining the singleton instance.
   *
   * @param beanName the name of the bean to look for
   * @return the registered singleton object, or {@code null} if none found
   * @see ConfigurableListableBeanFactory#getBeanDefinition
   */
  Object getSingleton(String beanName);

  /**
   * Check if this registry contains a singleton instance with the given name.
   * <p>Only checks already instantiated singletons; does not return {@code true}
   * for singleton bean definitions which have not been instantiated yet.
   * <p>The main purpose of this method is to check manually registered singletons
   * (see {@link #registerSingleton}). Can also be used to check whether a
   * singleton defined by a bean definition has already been created.
   * <p>To check whether a bean instantiation contains a bean definition with a given name,
   * use ListableBeanFactory's {@code containsBeanDefinition}. Calling both
   * {@code containsBeanDefinition} and {@code containsSingleton} answers
   * whether a specific bean instantiation contains a local bean instance with the given name.
   * <p>Use BeanFactory's {@code containsBean} for general checks whether the
   * instantiation knows about a bean with a given name (whether manually registered singleton
   * instance or created by bean definition), also checking ancestor factories.
   * <p><b>NOTE:</b> This lookup method is not aware of FactoryBean prefixes or aliases.
   * You need to resolve the canonical bean name first before checking the singleton status.
   *
   * @param beanName the name of the bean to look for
   * @return if this bean instantiation contains a singleton instance with the given name
   * @see #registerSingleton
   * @see org.springframework.beans.factory.ListableBeanFactory#containsBeanDefinition
   * @see org.springframework.beans.factory.BeanFactory#containsBean
   */
  boolean containsSingleton(String beanName);

  /**
   * Return the names of singleton beans registered in this registry.
   * <p>Only checks already instantiated singletons; does not return names
   * for singleton bean definitions which have not been instantiated yet.
   * <p>The main purpose of this method is to check manually registered singletons
   * (see {@link #registerSingleton}). Can also be used to check which singletons
   * defined by a bean definition have already been created.
   *
   * @return the list of names as a String array (never {@code null})
   * @see #registerSingleton
   * @see org.springframework.beans.factory.support.BeanDefinitionRegistry#getBeanDefinitionNames
   * @see org.springframework.beans.factory.ListableBeanFactory#getBeanDefinitionNames
   */
  String[] getSingletonNames();

  /**
   * Return the number of singleton beans registered in this registry.
   * <p>Only checks already instantiated singletons; does not count
   * singleton bean definitions which have not been instantiated yet.
   * <p>The main purpose of this method is to check manually registered singletons
   * (see {@link #registerSingleton}). Can also be used to count the number of
   * singletons defined by a bean definition that have already been created.
   *
   * @return the number of singleton beans
   * @see #registerSingleton
   * @see org.springframework.beans.factory.support.BeanDefinitionRegistry#getBeanDefinitionCount
   * @see org.springframework.beans.factory.ListableBeanFactory#getBeanDefinitionCount
   */
  int getSingletonCount();

  /**
   * Return the singleton mutex used by this registry (for external collaborators).
   *
   * @return the mutex object (never {@code null})
   * @since 4.2
   */
  Object getSingletonMutex();


}
