package com.clouway.collections.task1;

import java.util.List;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class PageBean {
  //List list = new ArrayList();
  private int pageSize = 3;
  private int index = pageSize;
  private int start;
  private int counter = 0;
  private int difference;
  private int pageCounter = 0;

  public void next(List list) {
    String lastElement = (String) list.get(list.size() - 1);
    int lastElement1 = Integer.parseInt(lastElement);
    int x = index;
    if (index > lastElement1) {
      difference = index - lastElement1;
      index = lastElement1;
    }
    List list1;
    list1 = list.subList(start, index);
    System.out.println("next " + list1);
    if (index == lastElement1) {
      index += difference;
    }
    start += pageSize;
    index += pageSize;
    counter++;
    pageCounter++;
    System.out.println(x);
  }

  public void previous(List list) {
    List list1;
//    System.out.println(start);
//    System.out.println(index);
    if (counter > 0) {
      start -= pageSize;
      index -= pageSize;
    }

    start -= pageSize;
    index -= pageSize;
    list1 = list.subList(start, index);
    System.out.println("previous " + list1);
    counter = 0;
    pageCounter--;

  }

  public void hasNext(List list) {
    index -= pageSize;
    if (index < list.size()) {
      System.out.println("has next");
    } else {
      System.out.println("hasn't next");
    }
    index += pageSize;
  }

  public void hasPrevious(List list) {
//    System.out.println(start);

    if (start < pageSize) {
      System.out.println("hasn't previous");
    } else {
      System.out.println("has previous");
    }
  }

  public void firstPage(List list) {
    index = pageSize;
    start = 0;
    System.out.println("first page " + list.subList(start, index));
    pageCounter = 1;
  }

  public void lastPage(List list) {
    int x = index;
    int y = start;
    System.out.println(difference);
//    System.out.println(list.size());
//    System.out.println(start);
//    System.out.println(index);
//    System.out.println();
    index = list.size();
    if(difference>0) {
      start = list.size() - pageSize + difference;
    }else{
      start = list.size() - 1;
    }
//    System.out.println(start);
//    System.out.println(index);
    System.out.println("last page " + list.subList(start, index));
    if (list.size() % pageSize > 0) {
      pageCounter = (list.size() / pageSize) + (list.size() % pageSize);
    }
    index = x;
    start = y;
  }

  public void getCurrentPageNumber(List list) {
    System.out.println("You are on page: " + pageCounter);
  }

}
