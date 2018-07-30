/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: LWritableResource.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/27
 */

package lee.springframework.core.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @description:
 * @author: liyong18
 * @createdate: 2018-07-27 16:20
 * @lastdate:
 */
public interface LWritableResource extends Resource {



  /**
   * 资源是否可用修改
   *
   * @return
   */
  boolean isWritable();


  /**
   * 返回资源的输出流，允许修改资源的内容
   *
   * @return
   * @throws IOException
   */
  OutputStream getOutputStream() throws IOException;
}
