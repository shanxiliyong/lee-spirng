/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: NamedBeanHolder.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/30
 */

package lee.springframework.beans.factory.cofnig;

import lee.springframework.beans.factory.NamedBean;
import lee.springframework.util.Assert;

/**
 * @description: bean名称和实例的持有者
 * @author: liyong18
 * @createdate: 2018-07-30 18:19
 * @lastdate:
 */
public class NamedBeanHolder<T> implements NamedBean {

  private final String beanName;

  private final T beanInstance;


  /**
   * Create a new holder for the given bean name plus instance.
   *
   * @param beanName     the name of the bean
   * @param beanInstance the corresponding bean instance
   */
  public NamedBeanHolder(String beanName, T beanInstance) {
    Assert.notNull(beanName, "Bean name must not be null");
    this.beanName = beanName;
    this.beanInstance = beanInstance;
  }


  /**
   * Return the name of the bean (never {@code null}).
   */
  @Override
  public String getBeanName() {
    return this.beanName;
  }

  /**
   * Return the corresponding bean instance (can be {@code null}).
   */
  public T getBeanInstance() {
    return this.beanInstance;
  }


}
