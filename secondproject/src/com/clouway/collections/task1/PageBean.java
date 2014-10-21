package com.clouway.collections.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class PageBean {
  private int pageSize;
  private int index;
  private int start;
  private int counterNext = 0;
  private int counterPrevious = 0;
  private int difference;
  private int pageCounter = 0;
  private List<Integer> list = new ArrayList<Integer>();

  public PageBean(List<Integer> list, int pageSize) {
    this.list = list;
    this.pageSize = pageSize;
    this.index = pageSize;
  }

  public List next() {

    if (counterPrevious > 0) {
      start += pageSize;
      index += pageSize;
    }

    if (index > list.size()) {
      difference = index - list.size();
      index = list.size();
    }
    if (!hasNext()) {
      throw new IllegalArgumentException("There is no next page!");
    }
    List list1;
    list1 = list.subList(start, index);
    index += difference;
    start += pageSize;
    index += pageSize;
    counterNext++;
    pageCounter++;
    return list1;
  }

  public List previous() {
    if (counterNext > 0) {
      start -= pageSize;
      index -= pageSize;
    }
    if (!hasPrevious()) {
      throw new IllegalArgumentException("There is no previous page!");
    }
    start -= pageSize;
    index -= pageSize;
    counterNext = 0;
    pageCounter--;
    counterPrevious++;
    return list.subList(start, index);

  }

  public Boolean hasNext() {
    Boolean result;

    if (pageCounter >= findLastPage()) {
      result = false;
    } else {
      result = true;
    }
    return result;
  }

  public Boolean hasPrevious() {
    Boolean result;
    if (pageCounter <= 1) {
      result = false;
    } else {
      result = true;
    }
    return result;
  }

  public List firstPage() {
    int index1 = pageSize;
    int start1 = 0;
    pageCounter = 1;
    index += pageSize;
    start += pageSize;
    return list.subList(start1, index1);
  }

  public List lastPage() {
    int index1;
    int start1;
    int diff = 0;
    index1 = list.size();
    if (list.size() % pageSize > 0) {
      start1 = list.size() - list.size() % pageSize;
      diff += pageSize - list.size() % pageSize;
    } else {
      start1 = list.size() - pageSize;
    }
    index = index1 + diff;
    start = start1;
    if (counterNext > 0) {
      index += pageSize;
      start += pageSize;
    }
    pageCounter = findLastPage();
    return list.subList(start1, index1);
  }

  public int getCurrentPageNumber() {
    return pageCounter;
  }


  private int findLastPage() {
    int lastPage = list.size() / pageSize;
    if (list.size() % pageSize > 0) {
      lastPage++;
    }
    return lastPage;
  }

}
//  public List next() {
//    if (counterPrevious > 0) {
//      start += pageSize;
//      index += pageSize;
//    }
//    if (index > lastElement(list)) {
//      difference = index - lastElement(list);
//      index = lastElement(list);
//    }
//    List list1;
//    list1 = list.subList(start, index);
//    if (index == lastElement(list)) {
//      index += difference;
//    }
//    start += pageSize;
//    index += pageSize;
//    counterNext++;
//    pageCounter++;
//    return list1;
//  }

//  public String hasNext() {
//    String result;
//    if (counterNext > 0) {
//      index -= pageSize;
//    }
//    if (index < list.size() && memory < list.size()) {
//      result = "has next";
//    } else {
//      result = "hasn't next";
//    }
//    index += pageSize;
//    return result;
//  }

//  private int lastElement(List list) {
//    return (Integer) list.get(list.size() - 1);
//  }

//  private int findLastPage() {
//    int value;
//    if (list.size() % pageSize < pageSize) {
//      value = 1;
//    } else {
//      value = list.size() % pageSize;
//    }
//    if (list.size() % pageSize > 0) {
//      pageCounter = (list.size() / pageSize) + value;
//    } else {
//      pageCounter = list.size() / pageSize;
//    }
//    return pageCounter;
//  }