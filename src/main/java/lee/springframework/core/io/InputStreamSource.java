/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: InputStreamSource.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/27
 */

package lee.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;


/**
 * @description: 提供输入流的资源对象的简单接口
 * <p>大多数情况下被{@link Resource} 继承</p>
 * @author: liyong18
 * @createdate: 2018-07-27 15:16
 * @lastdate:
 */
public interface InputStreamSource {




  /**
   * 返回资源对象的输入流。
   * <p>希望每次调用返回一个新的流</p>
   *
   * @return 资源对应的输入流
   * @throws IOException
   */
  InputStream getInputStream() throws IOException;
}
