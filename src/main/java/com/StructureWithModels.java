package com;

import com.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StructureWithModels {

//  private static final Logger LOG = LogManager.getLogger(StructureWithModels.class);
  private static boolean isHeaderExist = false;

  public static void main(String[] args) {

    List<Bean> beans = new ArrayList<>();

    String[] rows = Constants.anotherConfigString.split("\\n");

    for (int i = 0; i < rows.length; i++) {

//      if(!isHeaderExist && rows[i].contains("RncFunction")) {
//        Header bean = new Header(rows[i]);
//
//        if(!bean.isValid()) {
//          continue;
//        }
//
//        beans.add(bean);
//        isHeaderExist = true;
//      }

      if(!rows[i].contains("=") && !rows[i].contains("{") && !rows[i].contains("}")) {
        KeyValue bean= new KeyValue(rows[i]);

        if(!bean.isValid()) {
          continue;
        }

        beans.add(bean);
      }

//      if(rows[i].contains("{") && rows[i].contains("}")) {
//        String count = rows[i].split("\\{|}")[1];
//        Structure bean = new Structure(Arrays.asList(Arrays.copyOfRange(rows, i, i + Integer.parseInt(count)+1)));
//
//        if(!bean.isValid()) {
//          continue;
//        }
//
//        beans.add(bean);
//      }

//      if(rows[i].contains("[") && rows[i].contains("]") && !rows[i].contains("i[")) {
//        String count = rows[i].split("\\[|]")[1];
//        ArrayObjects bean = new ArrayObjects(Arrays.asList(Arrays.copyOfRange(rows, i, i + Integer.parseInt(count)+1)));
//
//        if(!bean.isValid()) {
//          continue;
//        }
//
//        beans.add(bean);
//      }

//      if(rows[i].contains("[") && rows[i].contains("]") && rows[i].contains("i[")) {
//        String count = rows[i].split("\\[|]")[1];
//        ArrayIntegers bean = new ArrayIntegers(rows[i], Integer.valueOf(count));
//
//        if(!bean.isValid()) {
//          continue;
//        }
//
//        beans.add(bean);
//      }

    }

    for (Bean bean : beans) {
      System.out.println(bean.getName());
      System.out.println(bean.getItems());
      System.out.println();
    }
  }

}
