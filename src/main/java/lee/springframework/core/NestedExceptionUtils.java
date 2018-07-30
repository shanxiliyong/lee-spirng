/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: NestedExceptionUtils.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/28
 */

package lee.springframework.core;



/**
 * 持有嵌入异常的异常类的辅助类。由于不同的异常类型之间不能共享同一个基类
 */
public abstract class NestedExceptionUtils {


  /**
   * 基于基础信息和异常原因构建信息
   * @param message
   * @param cause
   * @return
   */
  public static String buildMessage(String message, Throwable cause) {
    if (cause != null) {
      StringBuilder sb = new StringBuilder();
      if (message != null) {
        sb.append(message).append("; ");
      }
      sb.append("nested exception is ").append(cause);
      return sb.toString();
    }
    else {
      return message;
    }
  }

}
