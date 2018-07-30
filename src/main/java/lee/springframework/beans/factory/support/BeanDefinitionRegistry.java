/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: BeanDefinitionRegistry.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/29
 */

package lee.springframework.beans.factory.support;

import lee.springframework.beans.factory.BeanDefinitionStoreException;
import lee.springframework.beans.factory.NoSuchBeanDefinitionException;
import lee.springframework.core.AliasRegistry;
import lee.springframework.beans.factory.cofnig.BeanDefinition;

/**
 * @description:
 * @author: liyong18
 * @createdate: 2018-07-29 10:52
 * @lastdate:
 */
public interface BeanDefinitionRegistry extends AliasRegistry {

  /**
   * Register a new bean definition with this registry.
   * Must support RootBeanDefinition and ChildBeanDefinition.
   * @param beanName the name of the bean instance to register
   * @param beanDefinition definition of the bean instance to register
   * @throws BeanDefinitionStoreException if the BeanDefinition is invalid
   * or if there is already a BeanDefinition for the specified bean name
   * (and we are not allowed to override it)
   * @see RootBeanDefinition
   * @see ChildBeanDefinition
   */
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
			throws BeanDefinitionStoreException;

  /**
   * Remove the BeanDefinition for the given name.
   * @param beanName the name of the bean instance to register
   * @throws NoSuchBeanDefinitionException if there is no such bean definition
   */
  void removeBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;

  /**
   * Return the BeanDefinition for the given bean name.
   * @param beanName name of the bean to find a definition for
   * @return the BeanDefinition for the given name (never {@code null})
   * @throws NoSuchBeanDefinitionException if there is no such bean definition
   */
  BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;

  /**
   * Check if this registry contains a bean definition with the given name.
   * @param beanName the name of the bean to look for
   * @return if this registry contains a bean definition with the given name
   */
  boolean containsBeanDefinition(String beanName);

  /**
   * Return the names of all beans defined in this registry.
   * @return the names of all beans defined in this registry,
   * or an empty array if none defined
   */
  String[] getBeanDefinitionNames();

  /**
   * Return the number of beans defined in the registry.
   * @return the number of beans defined in the registry
   */
  int getBeanDefinitionCount();

  /**
   * Determine whether the given bean name is already in use within this registry,
   * i.e. whether there is a local bean or alias registered under this name.
   * @param beanName the name to check
   * @return whether the given bean name is already in use
   */
  boolean isBeanNameInUse(String beanName);


}
