/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: FatalBeanException.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/29
 */

package lee.springframework.beans;

/**
 * @description:在beans包以及子包中抛出的不可恢复的异常
 * @author: liyong18
 * @createdate: 2018-07-29 15:50
 * @lastdate:
 */
public class FatalBeanException extends BeansException {

  /**
   * Create a new FatalBeanException with the specified message.
   *
   * @param msg the detail message
   */
  public FatalBeanException(String msg) {
    super(msg);
  }

  /**
   * Create a new FatalBeanException with the specified message
   * and root cause.
   *
   * @param msg   the detail message
   * @param cause the root cause
   */
  public FatalBeanException(String msg, Throwable cause) {
    super(msg, cause);
  }


}
