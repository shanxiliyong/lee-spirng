/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: Resource.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/27
 */

package lee.springframework.core.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * @description: 抽象了真正资源的描述符，比如文件或者类路径下的资源
 * <p>如果资源存在就有一个输入流</p>
 * @author: liyong18
 * @createdate: 2018-07-27 15:41
 * @lastdate:
 */
public interface Resource extends InputStreamSource {


  /**
   * 检查资源是否存在
   *
   * @return
   */
  boolean exists();


  /**
   * 通过方法{@link #getInputStream()}是否可用读取资源的内容
   *
   * @return
   */
  boolean isReadable();


  /**
   * 这个资源是否为打开的流
   * <p>如果{@code true},输入流不能多次读<p/>
   *
   * @return
   */
  boolean isOpen();


  /**
   * 返回资源的URL
   *
   * @return
   * @throws IOException 如果资源不能解析为URL
   */
  URL getURL() throws IOException;


  /**
   * 返回资源的RUI
   *
   * @return
   * @throws IOException 如果资源不能解析成URI
   */
  URI getURI() throws IOException;


  /**
   * 返回资源对应的文件
   *
   * @return
   * @throws IOException
   */
  File getFile() throws IOException;


  /**
   * 返回资源的内容长度
   *
   * @return
   * @throws IOException
   */
  long contentLength() throws IOException;


  /**
   * 资源的最后修改时间
   *
   * @return
   * @throws IOException
   */
  long lastModified() throws IOException;


  /**
   * 创建相对于当前资源的资源
   *
   * @param relativePath 相对于当前资源的路径
   * @return
   * @throws IOException
   */
  Resource createRelative(String relativePath) throws IOException;


  /**
   * 当前资源的名称
   *
   * @return
   */
  String getFilename();


  /**
   * 当前资源的描述
   *
   * @return
   */
  String getDescription();
}
