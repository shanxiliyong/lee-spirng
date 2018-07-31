/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: ConversionService.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/31
 */

package lee.springframework.core.convert;

/**
 * A service interface for type conversion.
 * 类型转换的接口
 * This is the entry point into the convert system.
 * 转换系统的入口
 * Call {@link #convert(Object, Class)} to perform a thread-safe type conversion using this system.
 * 调用{@link #convert(Object, Class)}执行线程安全的系统类型转换
 *
 * @author Keith Donald
 * @author Phillip Webb
 * @since 3.0
 */
public interface ConversionService {

  /**
   * Return {@code true} if objects of {@code sourceType} can be converted to the {@code targetType}.
   *
   * <p>If this method returns {@code true}, it means {@link #convert(Object, Class)} is capable
   * of converting an instance of {@code sourceType} to {@code targetType}.
   * <p>Special note on collections, arrays, and maps types:
   * For conversion between collection, array, and map types, this method will return {@code true}
   * even though a convert invocation may still generate a {@link ConversionException} if the
   * underlying elements are not convertible.
   * 集合之间转换，这个方法返回{@code true},及时转换抛出异常
   * Callers are expected to handle this exceptional case when working with collections and maps.
   * 调用者希望操作这个异常当集合之间转换
   *
   * @param sourceType the source type to convert from (may be {@code null} if source is {@code null})
   * @param targetType the target type to convert to (required)
   * @return {@code true} if a conversion can be performed, {@code false} if not
   * @throws IllegalArgumentException if {@code targetType} is {@code null}
   */
  boolean canConvert(Class<?> sourceType, Class<?> targetType);

  /**
   * Return {@code true} if objects of {@code sourceType} can be converted to the {@code targetType}.
   * The TypeDescriptors provide additional context about the source and target locations
   * where conversion would occur, often object fields or property locations.
   * <p>If this method returns {@code true}, it means {@link #convert(Object, TypeDescriptor, TypeDescriptor)}
   * is capable of converting an instance of {@code sourceType} to {@code targetType}.
   * <p>Special note on collections, arrays, and maps types:
   * For conversion between collection, array, and map types, this method will return {@code true}
   * even though a convert invocation may still generate a {@link ConversionException} if the
   * underlying elements are not convertible. Callers are expected to handle this exceptional case
   * when working with collections and maps.
   *
   * @param sourceType context about the source type to convert from
   *                   (may be {@code null} if source is {@code null})
   * @param targetType context about the target type to convert to (required)
   * @return {@code true} if a conversion can be performed between the source and target types,
   * {@code false} if not
   * @throws IllegalArgumentException if {@code targetType} is {@code null}
   */
  boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType);

  /**
   * Convert the given {@code source} to the specified {@code targetType}.
   *
   * @param source     the source object to convert (may be {@code null})
   * @param targetType the target type to convert to (required)
   * @return the converted object, an instance of targetType
   * @throws ConversionException      if a conversion exception occurred
   * @throws IllegalArgumentException if targetType is {@code null}
   */
  <T> T convert(Object source, Class<T> targetType);

  /**
   * Convert the given {@code source} to the specified {@code targetType}.
   * The TypeDescriptors provide additional context about the source and target locations
   * where conversion will occur, often object fields or property locations.
   *
   * @param source     the source object to convert (may be {@code null})
   * @param sourceType context about the source type to convert from
   *                   (may be {@code null} if source is {@code null})
   * @param targetType context about the target type to convert to (required)
   * @return the converted object, an instance of {@link TypeDescriptor#getObjectType() targetType}
   * @throws ConversionException      if a conversion exception occurred
   * @throws IllegalArgumentException if targetType is {@code null},
   *                                  or {@code sourceType} is {@code null} but source is not {@code null}
   */
  Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType);


}
