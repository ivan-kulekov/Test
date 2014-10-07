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
    list.add("8");
    list.add("9");
    list.add("10");
//    list.add("11");

    System.out.println(pageBean.next(list));

    System.out.println(pageBean.next(list));

    System.out.println(pageBean.hasPrevious());

    System.out.println("Previous page: " + pageBean.previous(list));

    System.out.println(pageBean.hasNext(list));

    System.out.println("Last page: " + pageBean.lastPage(list));

    System.out.println("First page: " + pageBean.firstPage(list));

    System.out.println(pageBean.getCurrentPageNumber());
  }
}
