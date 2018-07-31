/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: BeanExpressionResolver.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/31
 */

package lee.springframework.beans.factory.cofnig;

import lee.springframework.beans.BeansException;

/**
 * @description:
 * @author: liyong18
 * @createdate: 2018-07-31 20:40
 * @lastdate:
 */
public interface BeanExpressionResolver {

  /**
   * Evaluate the given value as an expression, if applicable;
   * return the value as-is otherwise.
   * @param value the value to check
   * @param evalContext the evaluation context
   * @return the resolved value (potentially the given value as-is)
   * @throws BeansException if evaluation failed
   */
  Object evaluate(String value, BeanExpressionContext evalContext) throws BeansException;


}
