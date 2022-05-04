package top.ppnt.jfinal.utils;

import java.net.URL;

import com.litongjava.utils.string.StringUtils;

public class PathKitUtils {
  /**
   * 返回静态目录的真实文件夹
   */
  private static String realResourcePath = null;

  public static String getResourcePath() {
    String retval = null;
    String key = PropKitUtils.get("undertow.resourcePath");
    if(StringUtils.isEmpty(key)) {
      return retval;
    }
    String[] split = key.split(":");
    
    if (split.length > 1) {
      if (split[0].equals("file")) {
        return split[1];
      } else {
        if (realResourcePath == null) {
          URL resource = PathKitUtils.class.getClassLoader().getResource(split[1]);
          realResourcePath = resource.getFile();
        }
        retval = realResourcePath;
      }
    }
    return retval;
  }
}