/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: HierarchicalBeanFactory.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/31
 */

package lee.springframework.beans.factory;

/**
 * Sub-interface implemented by bean factories that can be part
 * of a hierarchy.
 *  被BeanFactory 实现的子接口，层次的一部分
 * <p>The corresponding {@code setParentBeanFactory} method for bean
 * factories that allow setting the parent in a configurable
 * fashion can be found in the ConfigurableBeanFactory interface.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @since 07.07.2003
 * @see org.springframework.beans.factory.config.ConfigurableBeanFactory#setParentBeanFactory
 */
public interface HierarchicalBeanFactory extends BeanFactory {

  /**
   * Return the parent bean instantiation, or {@code null} if there is none.
   */
  BeanFactory getParentBeanFactory();

  /**
   * Return whether the local bean instantiation contains a bean of the given name,
   * ignoring beans defined in ancestor contexts.
   * <p>This is an alternative to {@code containsBean}, ignoring a bean
   * of the given name from an ancestor bean instantiation.
   * @param name the name of the bean to query
   * @return whether a bean with the given name is defined in the local instantiation
   * @see BeanFactory#containsBean
   */
  boolean containsLocalBean(String name);

}
