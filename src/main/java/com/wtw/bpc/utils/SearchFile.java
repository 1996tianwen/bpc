package com.wtw.bpc.utils;

import com.wtw.bpc.service.ChainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author:wtw
 * @date:2018/6/1
 */
public class SearchFile {
  private static final Logger logger = LoggerFactory.getLogger(SearchFile.class);
  public static void search(String path) throws Exception {
    File file = new File(path);
    List<File>list = Arrays.asList(file.listFiles());
    logger.info("list : { }" + list);
    list.stream().filter(f -> f.getName().endsWith(".xml"))
            .forEach(f -> {
              try {
                ChainService.loadCatalogFile(f.getName());
              } catch (Exception e) {
                e.printStackTrace();
              }
            });
  }
}
