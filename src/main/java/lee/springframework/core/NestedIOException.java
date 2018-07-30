/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: NestedIOException.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/28
 */

package lee.springframework.core;


import java.io.IOException;


/**
 * {@link IOException}的子类，持有根本原因，和NestedChecked/RuntimeException一样往出暴露根本原因。
 */
@SuppressWarnings("serial")
public class NestedIOException extends IOException {

  static {
    // Eagerly load the NestedExceptionUtils class to avoid classloader deadlock
    // issues on OSGi when calling getMessage(). Reported by Don Brown; SPR-5607.
    NestedExceptionUtils.class.getName();
  }


  /**
   * 根据指定的详细信息构建{@code NestedIOException}
   *
   * @param msg the detail message
   */
  public NestedIOException(String msg) {
    super(msg);
  }

  /**
   * Construct a {@code NestedIOException} with the specified detail message
   * and nested exception.
   *
   * @param msg   the detail message
   * @param cause the nested exception
   */
  public NestedIOException(String msg, Throwable cause) {
    super(msg, cause);
  }


  /**
   * Return the detail message, including the message from the nested exception
   * if there is one.
   */
  @Override
  public String getMessage() {
    return NestedExceptionUtils.buildMessage(super.getMessage(), getCause());
  }

}