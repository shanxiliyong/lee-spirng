/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: MultiValueMap.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/28
 */

package lee.springframework.util;

import java.util.List;
import java.util.Map;


/**
 * @description:  包含各种集合工具方法
 * @author: liyong18
 * @createdate: 2018-07-28 17:40
 * @lastdate:
 */
public interface MultiValueMap<K, V> extends Map<K, List<V>>{

  /**
   * Return the first value for the given key.
   * @param key the key
   * @return the first value for the specified key, or {@code null}
   */
  V getFirst(K key);

  /**
   * Add the given single value to the current list of values for the given key.
   * @param key the key
   * @param value the value to be added
   */
  void add(K key, V value);

  /**
   * Set the given single value under the given key.
   * @param key the key
   * @param value the value to set
   */
  void set(K key, V value);

  /**
   * Set the given values under.
   * @param values the values.
   */
  void setAll(Map<K, V> values);

  /**
   * Returns the first values contained in this {@code MultiValueMap}.
   * @return a single value representation of this map
   */
  Map<K, V> toSingleValueMap();


}
