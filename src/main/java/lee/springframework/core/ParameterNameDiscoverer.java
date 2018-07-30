/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: ParameterNameDiscoverer.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/30
 */

package lee.springframework.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Interface to discover parameter names for methods and constructors.
 *  方法和构造器参数名称发现者
 * <p>Parameter name discovery is not always possible, but various strategies are
 * available to try, such as looking for debug information that may have been
 * emitted at compile time, and looking for argname annotation values optionally
 * accompanying AspectJ annotated methods.
 *
 * @author Rod Johnson
 * @author Adrian Colyer
 * @since 2.0
 */
public interface ParameterNameDiscoverer {

  /**
   * Return parameter names for this method,
   * or {@code null} if they cannot be determined.
   *
   * @param method method to find parameter names for
   * @return an array of parameter names if the names can be resolved,
   * or {@code null} if they cannot
   */
  String[] getParameterNames(Method method);

  /**
   * Return parameter names for this constructor,
   * or {@code null} if they cannot be determined.
   *
   * @param ctor constructor to find parameter names for
   * @return an array of parameter names if the names can be resolved,
   * or {@code null} if they cannot
   */
  String[] getParameterNames(Constructor<?> ctor);

}
