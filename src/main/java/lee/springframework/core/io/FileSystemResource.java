/**
 * @copyright: Copyright (c) travel.jd.com All Rights Reserved
 * @file: FileSystemResource.java project: lee-spirng
 * @creator: liyong18
 * @date: 2018/7/27
 */

package lee.springframework.core.io;

import lee.springframework.util.Assert;
import lee.springframework.util.StringUtils;

import java.io.*;
import java.net.URI;

/**
 * @description:
 * @author: liyong18
 * @createdate: 2018-07-27 16:10
 * @lastdate:
 */
public class FileSystemResource extends AbstractResource implements LWritableResource {

  private final File file;

  private final String path;

  public FileSystemResource(File file) {
    Assert.notNull(file, "File must not be null");
    this.file = file;
    this.path = file.getPath();
  }
  public FileSystemResource(String path) {
    Assert.notNull(path, "Path must not be null");
    this.file = new File(path);
    this.path = path;
  }


  @Override
  public boolean isWritable() {
    return (this.file.canWrite() && !this.file.isDirectory());
  }

  @Override
  public OutputStream getOutputStream() throws IOException {
    return new FileOutputStream(this.file);
  }

  @Override
  public URI getURI() throws IOException {
    return this.file.toURI();
  }

  @Override
  public File getFile() throws IOException {
    return this.file ;
  }

  @Override
  public long contentLength() throws IOException {
    return this.file.length();
  }



  @Override
  public Resource createRelative(String relativePath) throws IOException {
    String pathToUse = StringUtils.applyRelativePath(this.path, relativePath);
    return new FileSystemResource(pathToUse);
  }

  @Override
  public String getFilename() {
    return this.file.getName();
  }

  @Override
  public String getDescription() {
    return "file [" + this.file.getAbsolutePath() + "]";
  }

  @Override
  public InputStream getInputStream() throws IOException {
    return new FileInputStream(this.file);
  }
}
