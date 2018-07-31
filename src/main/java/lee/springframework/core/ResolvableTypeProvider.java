/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: ResolvableTypeProvider.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/31
 */

package lee.springframework.core;

/**
 * Any object can implement this interface to provide its actual {@link ResolvableType}.
 *  任何对象可以实现此接口来提供{@link ResolvableType}
 * <p>Such information is very useful when figuring out if the instance matches a generic
 * signature as Java does not convey the signature at runtime.
 *   当查找对象是否匹配此接口。这种信息很有用
 * <p>Users of this interface should be careful in complex hierarchy scenarios, especially
 * when the generic type signature of the class changes in sub-classes. It is always
 * possible to return {@code null} to fallback on a default behaviour.
 *
 * @author Stephane Nicoll
 * @since 4.2
 */
public interface ResolvableTypeProvider  {

  /**
   * Return the {@link ResolvableType} describing this instance
   * (or {@code null} if some sort of default should be applied instead).
   */
  ResolvableType getResolvableType();


}
