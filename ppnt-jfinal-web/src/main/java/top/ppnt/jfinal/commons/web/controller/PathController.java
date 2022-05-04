package top.ppnt.jfinal.commons.web.controller;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.kit.PathKit;

import top.ppnt.jfinal.utils.PathKitUtils;

@Path("path")
public class PathController extends Controller {
  public void index() {
    Map<String, String> map = new HashMap<>();
    map.put("rootClassPath", PathKit.getRootClassPath());
    map.put("webRootPath", PathKit.getWebRootPath());
    map.put("realResourcePath", PathKitUtils.getResourcePath());
    renderJson(map);
  }
}