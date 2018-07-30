/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: AliasRegistry.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/29
 */

package lee.springframework.core;


/**
 * @description: 管理的别名的公共接口。
 * @author: liyong18
 * @createdate: 2018-07-29 09:03
 * @lastdate:
 */
public interface AliasRegistry {

  /**
   * Given a name, register an alias for it.
   * 给定一个名称，为它注册一个别名
   *
   * @param name  the canonical name
   * @param alias the alias to be registered
   * @throws IllegalStateException if the alias is already in use
   *                               and may not be overridden
   */
  void registerAlias(String name, String alias);

  /**
   * Remove the specified alias from this registry.
   * 删除指定的域名
   *
   * @param alias the alias to remove
   * @throws IllegalStateException if no such alias was found
   */
  void removeAlias(String alias);

  /**
   * Determine whether this given name is defines as an alias
   * 给定的名称是否为一个别名
   * (as opposed to the name of an actually registered component).
   *
   * @param name the name to check
   * @return whether the given name is an alias
   */
  boolean isAlias(String name);

  /**
   * Return the aliases for the given name, if defined.
   * 根据指定的名称获取对应的别名
   *
   * @param name the name to check for aliases
   * @return the aliases, or an empty array if none
   */
  String[] getAliases(String name);


}
