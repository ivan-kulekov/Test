package com.clouway.collections.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class PageBeanDemo {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<Integer>();
    PageBean pageBean = new PageBean(list, 2);
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    list.add(9);
    list.add(10);
//    list.add(11);

    System.out.println("First page is: " + pageBean.firstPage());

    System.out.println("Next page: " + pageBean.next());

    System.out.println(pageBean.hasPrevious());

    System.out.println(pageBean.hasNext());

    System.out.println("Previous page: " + pageBean.previous());

    System.out.println("Last page: " + pageBean.lastPage());

    System.out.println(pageBean.getCurrentPageNumber());
  }
}
