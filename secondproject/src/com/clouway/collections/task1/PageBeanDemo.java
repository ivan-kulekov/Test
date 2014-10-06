package com.clouway.collections.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class PageBeanDemo {
  public static void main(String[] args) {
    PageBean pageBean = new PageBean();
    List<String> list = new ArrayList<String>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    list.add("6");
    list.add("7");
//    list.add("8");
//    list.add("9");
//    list.add("10");
//    list.add("11");

    pageBean.next(list);
    pageBean.next(list);
    pageBean.next(list);
    pageBean.lastPage(list);
//    pageBean.next(list);
//    pageBean.next(list);
//    pageBean.firstPage(list);
//    pageBean.hasNext(list);
//    pageBean.previous(list);
//    pageBean.previous(list);
//    pageBean.previous(list);
//    pageBean.hasPrevious(list);
//    pageBean.getCurrentPageNumber(list);
  }
}
