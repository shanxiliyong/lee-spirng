/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: AnnotationConfigurationException.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/8/1
 */

package lee.springframework.core.annotation;

import lee.springframework.core.NestedRuntimeException;

/**
 * Thrown by {@link AnnotationUtils} and <em>synthesized annotations</em>
 * if an annotation is improperly configured.
 *
 * @author Sam Brannen
 * @since 4.2
 * @see AnnotationUtils
 * @see SynthesizedAnnotation
 */
@SuppressWarnings("serial")
public class AnnotationConfigurationException  extends NestedRuntimeException {

  /**
   * Construct a new {@code AnnotationConfigurationException} with the
   * supplied message.
   * @param message the detail message
   */
	public AnnotationConfigurationException(String message) {
    super(message);
  }

  /**
   * Construct a new {@code AnnotationConfigurationException} with the
   * supplied message and cause.
   * @param message the detail message
   * @param cause the root cause
   */
	public AnnotationConfigurationException(String message, Throwable cause) {
    super(message, cause);
  }


}
