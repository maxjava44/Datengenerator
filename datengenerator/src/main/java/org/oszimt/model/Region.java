package org.oszimt.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Region {
  private String name;
  private ArrayList<Land> laender;

  public Region(String ordnerPfad) {
      File regionsOrder = new File(ordnerPfad);
      HashMap<String,ArrayList<File>> laenderFiles = new HashMap<>();
      for(File file : regionsOrder.listFiles()) {
        String landName = file.getName().split("_")[0];
        laenderFiles.put(landName,laenderFiles.getOrDefault(landName,new ArrayList<>()));
        laenderFiles.get(landName).add(file);
      }
      laenderFiles.keySet().forEach(System.out::println);
  }
  
}