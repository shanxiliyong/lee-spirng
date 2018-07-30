/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: NamedBean.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/30
 */

package lee.springframework.beans.factory;

/**
 * @description:
 * @author: liyong18
 * @createdate: 2018-07-30 18:19
 * @lastdate:
 */
public interface NamedBean {

  /**
   * Return the name of this bean in a Spring bean factory, if known.
   */
  String getBeanName();
}
