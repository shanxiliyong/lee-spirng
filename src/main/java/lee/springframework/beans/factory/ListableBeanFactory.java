/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: ListableBeanFactory.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/30
 */

package lee.springframework.beans.factory;

import lee.springframework.beans.BeansException;
import lee.springframework.core.ResolvableType;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * Extension of the {@link BeanFactory} interface to be implemented by bean factories
 * that can enumerate all their bean instances, rather than attempting bean lookup
 * by name one by one as requested by clients.
 * {@link BeanFactory}的扩展接口,被可以枚举bean实例的工厂实现，而不是通过客户端一个一个的调用by name方法
 * BeanFactory implementations that
 * preload all their bean definitions (such as XML-based factories) may implement
 * this interface.
 * 需要提前加载累的定义信息的工厂需要实现此接口
 * <p>If this is a {@link HierarchicalBeanFactory}, the return values will <i>not</i>
 * take any BeanFactory hierarchy into account, but will relate only to the beans
 * defined in the current instantiation. Use the {@link BeanFactoryUtils} helper class
 * to consider beans in ancestor factories too.
 * 如果是{@link HierarchicalBeanFactory}，方法返回的只是当前工厂的个数，不包括父工厂定义的个数
 *
 * <p>The methods in this interface will just respect bean definitions of this instantiation.
 * They will ignore any singleton beans that have been registered by other means like
 * {@link org.springframework.beans.factory.config.ConfigurableBeanFactory}'s
 * {@code registerSingleton} method, with the exception of
 * {@code getBeanNamesOfType} and {@code getBeansOfType} which will check
 * such manually registered singletons too. Of course, BeanFactory's {@code getBean}
 * does allow transparent access to such special beans as well. However, in typical
 * scenarios, all beans will be defined by external bean definitions anyway, so most
 * applications don't need to worry about this differentiation.
 *
 * <p><b>NOTE:</b> With the exception of {@code getBeanDefinitionCount}
 * and {@code containsBeanDefinition}, the methods in this interface
 * are not designed for frequent invocation. Implementations may be slow.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see HierarchicalBeanFactory
 * @see BeanFactoryUtils
 * @since 16 April 2001
 */
public interface ListableBeanFactory extends BeanFactory {

  /**
   * Check if this bean instantiation contains a bean definition with the given name.
   * <p>Does not consider any hierarchy this instantiation may participate in,
   * and ignores any singleton beans that have been registered by
   * other means than bean definitions.
   * 不考虑继承的bean和通过其他方式注册的bean
   * @param beanName the name of the bean to look for
   * @return if this bean instantiation contains a bean definition with the given name
   * @see #containsBean
   */
  boolean containsBeanDefinition(String beanName);

  /**
   * Return the number of beans defined in the instantiation.
   * <p>Does not consider any hierarchy this instantiation may participate in,
   * and ignores any singleton beans that have been registered by
   * other means than bean definitions.
   *
   * @return the number of beans defined in the instantiation
   */
  int getBeanDefinitionCount();

  /**
   * Return the names of all beans defined in this instantiation.
   * <p>Does not consider any hierarchy this instantiation may participate in,
   * and ignores any singleton beans that have been registered by
   * other means than bean definitions.
   *
   * @return the names of all beans defined in this instantiation,
   * or an empty array if none defined
   */
  String[] getBeanDefinitionNames();

  /**
   * Return the names of beans matching the given type (including subclasses),
   * judging from either bean definitions or the value of {@code getObjectType}
   * in the case of FactoryBeans.
   * 返回指定类型bean的名称，包括子类.
   *
   * <p><b>NOTE: This method introspects top-level beans only.</b> It does <i>not</i>
   * check nested beans which might match the specified type as well.
   * <p>Does consider objects created by FactoryBeans, which means that FactoryBeans
   * will get initialized. If the object created by the FactoryBean doesn't match,
   * the raw FactoryBean itself will be matched against the type.
   * <p>Does not consider any hierarchy this instantiation may participate in.
   * Use BeanFactoryUtils' {@code beanNamesForTypeIncludingAncestors}
   * to include beans in ancestor factories too.
   * <p>Note: Does <i>not</i> ignore singleton beans that have been registered
   * by other means than bean definitions.
   * <p>This version of {@code getBeanNamesForType} matches all kinds of beans,
   * be it singletons, prototypes, or FactoryBeans. In most implementations, the
   * result will be the same as for {@code getBeanNamesForType(type, true, true)}.
   * <p>Bean names returned by this method should always return bean names <i>in the
   * order of definition</i> in the backend configuration, as far as possible.
   *
   * @param type the class or interface to match, or {@code null} for all bean names
   * @return the names of beans (or objects created by FactoryBeans) matching
   * the given object type (including subclasses), or an empty array if none
   * @see #isTypeMatch(String, ResolvableType)
   * @see FactoryBean#getObjectType
   * @see BeanFactoryUtils#beanNamesForTypeIncludingAncestors(ListableBeanFactory, ResolvableType)
   * @since 4.2
   */
  String[] getBeanNamesForType(ResolvableType type);

  /**
   * Return the names of beans matching the given type (including subclasses),
   * judging from either bean definitions or the value of {@code getObjectType}
   * in the case of FactoryBeans.
   * <p><b>NOTE: This method introspects top-level beans only.</b> It does <i>not</i>
   * check nested beans which might match the specified type as well.
   * <p>Does consider objects created by FactoryBeans, which means that FactoryBeans
   * will get initialized. If the object created by the FactoryBean doesn't match,
   * the raw FactoryBean itself will be matched against the type.
   * <p>Does not consider any hierarchy this instantiation may participate in.
   * Use BeanFactoryUtils' {@code beanNamesForTypeIncludingAncestors}
   * to include beans in ancestor factories too.
   * <p>Note: Does <i>not</i> ignore singleton beans that have been registered
   * by other means than bean definitions.
   * <p>This version of {@code getBeanNamesForType} matches all kinds of beans,
   * be it singletons, prototypes, or FactoryBeans. In most implementations, the
   * result will be the same as for {@code getBeanNamesForType(type, true, true)}.
   * <p>Bean names returned by this method should always return bean names <i>in the
   * order of definition</i> in the backend configuration, as far as possible.
   *
   * @param type the class or interface to match, or {@code null} for all bean names
   * @return the names of beans (or objects created by FactoryBeans) matching
   * the given object type (including subclasses), or an empty array if none
   * @see FactoryBean#getObjectType
   * @see BeanFactoryUtils#beanNamesForTypeIncludingAncestors(ListableBeanFactory, Class)
   */
  String[] getBeanNamesForType(Class<?> type);

  /**
   * Return the names of beans matching the given type (including subclasses),
   * judging from either bean definitions or the value of {@code getObjectType}
   * in the case of FactoryBeans.
   *
   * <p><b>NOTE: This method introspects top-level beans only.</b> It does <i>not</i>
   * check nested beans which might match the specified type as well.
   * <p>Does consider objects created by FactoryBeans if the "allowEagerInit" flag is set,
   * which means that FactoryBeans will get initialized. If the object created by the
   * FactoryBean doesn't match, the raw FactoryBean itself will be matched against the
   * type. If "allowEagerInit" is not set, only raw FactoryBeans will be checked
   * (which doesn't require initialization of each FactoryBean).
   * <p>Does not consider any hierarchy this instantiation may participate in.
   * Use BeanFactoryUtils' {@code beanNamesForTypeIncludingAncestors}
   * to include beans in ancestor factories too.
   * <p>Note: Does <i>not</i> ignore singleton beans that have been registered
   * by other means than bean definitions.
   * <p>Bean names returned by this method should always return bean names <i>in the
   * order of definition</i> in the backend configuration, as far as possible.
   *
   * @param type                 the class or interface to match, or {@code null} for all bean names
   * @param includeNonSingletons whether to include prototype or scoped beans too
   *                             or just singletons (also applies to FactoryBeans)
   * @param allowEagerInit       whether to initialize <i>lazy-init singletons</i> and
   *                             <i>objects created by FactoryBeans</i> (or by instantiation methods with a
   *                             "instantiation-bean" reference) for the type check. Note that FactoryBeans need to be
   *                             eagerly initialized to determine their type: So be aware that passing in "true"
   *                             for this flag will initialize FactoryBeans and "instantiation-bean" references.
   * @return the names of beans (or objects created by FactoryBeans) matching
   * the given object type (including subclasses), or an empty array if none
   * @see FactoryBean#getObjectType
   * @see BeanFactoryUtils#beanNamesForTypeIncludingAncestors(ListableBeanFactory, Class, boolean, boolean)
   */
  String[] getBeanNamesForType(Class<?> type, boolean includeNonSingletons, boolean allowEagerInit);

  /**
   * Return the bean instances that match the given object type (including
   * subclasses), judging from either bean definitions or the value of
   * {@code getObjectType} in the case of FactoryBeans.
   * <p><b>NOTE: This method introspects top-level beans only.</b> It does <i>not</i>
   * check nested beans which might match the specified type as well.
   * <p>Does consider objects created by FactoryBeans, which means that FactoryBeans
   * will get initialized. If the object created by the FactoryBean doesn't match,
   * the raw FactoryBean itself will be matched against the type.
   * <p>Does not consider any hierarchy this instantiation may participate in.
   * Use BeanFactoryUtils' {@code beansOfTypeIncludingAncestors}
   * to include beans in ancestor factories too.
   * <p>Note: Does <i>not</i> ignore singleton beans that have been registered
   * by other means than bean definitions.
   * <p>This version of getBeansOfType matches all kinds of beans, be it
   * singletons, prototypes, or FactoryBeans. In most implementations, the
   * result will be the same as for {@code getBeansOfType(type, true, true)}.
   * <p>The Map returned by this method should always return bean names and
   * corresponding bean instances <i>in the order of definition</i> in the
   * backend configuration, as far as possible.
   *
   * @param type the class or interface to match, or {@code null} for all concrete beans
   * @return a Map with the matching beans, containing the bean names as
   * keys and the corresponding bean instances as values
   * @throws BeansException if a bean could not be created
   * @see FactoryBean#getObjectType
   * @see BeanFactoryUtils#beansOfTypeIncludingAncestors(ListableBeanFactory, Class)
   * @since 1.1.2
   */
  <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

  /**
   * Return the bean instances that match the given object type (including
   * subclasses), judging from either bean definitions or the value of
   * {@code getObjectType} in the case of FactoryBeans.
   * <p><b>NOTE: This method introspects top-level beans only.</b> It does <i>not</i>
   * check nested beans which might match the specified type as well.
   * <p>Does consider objects created by FactoryBeans if the "allowEagerInit" flag is set,
   * which means that FactoryBeans will get initialized. If the object created by the
   * FactoryBean doesn't match, the raw FactoryBean itself will be matched against the
   * type. If "allowEagerInit" is not set, only raw FactoryBeans will be checked
   * (which doesn't require initialization of each FactoryBean).
   * <p>Does not consider any hierarchy this instantiation may participate in.
   * Use BeanFactoryUtils' {@code beansOfTypeIncludingAncestors}
   * to include beans in ancestor factories too.
   * <p>Note: Does <i>not</i> ignore singleton beans that have been registered
   * by other means than bean definitions.
   * <p>The Map returned by this method should always return bean names and
   * corresponding bean instances <i>in the order of definition</i> in the
   * backend configuration, as far as possible.
   *
   * @param type                 the class or interface to match, or {@code null} for all concrete beans
   * @param includeNonSingletons whether to include prototype or scoped beans too
   *                             or just singletons (also applies to FactoryBeans)
   * @param allowEagerInit       whether to initialize <i>lazy-init singletons</i> and
   *                             <i>objects created by FactoryBeans</i> (or by instantiation methods with a
   *                             "instantiation-bean" reference) for the type check. Note that FactoryBeans need to be
   *                             eagerly initialized to determine their type: So be aware that passing in "true"
   *                             for this flag will initialize FactoryBeans and "instantiation-bean" references.
   * @return a Map with the matching beans, containing the bean names as
   * keys and the corresponding bean instances as values
   * @throws BeansException if a bean could not be created
   * @see FactoryBean#getObjectType
   * @see BeanFactoryUtils#beansOfTypeIncludingAncestors(ListableBeanFactory, Class, boolean, boolean)
   */
  <T> Map<String, T> getBeansOfType(Class<T> type, boolean includeNonSingletons, boolean allowEagerInit)
          throws BeansException;

  /**
   * Find all names of beans whose {@code Class} has the supplied {@link Annotation}
   * type, without creating any bean instances yet.
   *
   * @param annotationType the type of annotation to look for
   * @return the names of all matching beans
   * @since 4.0
   */
  String[] getBeanNamesForAnnotation(Class<? extends Annotation> annotationType);

  /**
   * Find all beans whose {@code Class} has the supplied {@link Annotation} type,
   * returning a Map of bean names with corresponding bean instances.
   *
   * @param annotationType the type of annotation to look for
   * @return a Map with the matching beans, containing the bean names as
   * keys and the corresponding bean instances as values
   * @throws BeansException if a bean could not be created
   * @since 3.0
   */
  Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) throws BeansException;

  /**
   * Find an {@link Annotation} of {@code annotationType} on the specified
   * bean, traversing its interfaces and super classes if no annotation can be
   * found on the given class itself.
   *
   * @param beanName       the name of the bean to look for annotations on
   * @param annotationType the annotation class to look for
   * @return the annotation of the given type if found, or {@code null}
   * @throws NoSuchBeanDefinitionException if there is no bean with the given name
   * @since 3.0
   */
  <A extends Annotation> A findAnnotationOnBean(String beanName, Class<A> annotationType)
          throws NoSuchBeanDefinitionException;


}
