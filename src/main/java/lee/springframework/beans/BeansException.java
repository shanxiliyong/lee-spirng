/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: BeansException.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/29
 */

package lee.springframework.beans;

import lee.springframework.core.NestedRuntimeException;
import lee.springframework.util.ObjectUtils;


/**
 * @description: 在beans包以及子包中抛出的异常的抽象父类
 * <p>运行时异常，通常是致命的</p>
 * @author: liyong18
 * @createdate: 2018-07-29 11:03
 * @lastdate:
 */
public class BeansException extends NestedRuntimeException {

  /**
   * Create a new BeansException with the specified message.
   *
   * @param msg the detail message
   */
  public BeansException(String msg) {
    super(msg);
  }

  /**
   * Create a new BeansException with the specified message
   * and root cause.
   *
   * @param msg   the detail message
   * @param cause the root cause
   */
  public BeansException(String msg, Throwable cause) {
    super(msg, cause);
  }


  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof BeansException)) {
      return false;
    }
    BeansException otherBe = (BeansException) other;
    return (getMessage().equals(otherBe.getMessage()) &&
            ObjectUtils.nullSafeEquals(getCause(), otherBe.getCause()));
  }

  @Override
  public int hashCode() {
    return getMessage().hashCode();
  }


}
