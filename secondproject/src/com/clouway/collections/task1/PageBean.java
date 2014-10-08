package com.clouway.collections.task1;

import java.util.List;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class PageBean {
  private int pageSize;
  private int index = pageSize = 2;
  private int start;
  private int counternext = 0;
  private int counterprevious = 0;
  private int difference;
  private int pageCounter = 0;
  private int memory;

  public List next(List list) {

    if (counterprevious > 0) {
      start += pageSize;
      index += pageSize;
    }
    if (index > lastElement(list)) {
      difference = index - lastElement(list);
      index = lastElement(list);
    }
    List list1;
    list1 = list.subList(start, index);
    if (index == lastElement(list)) {
      index += difference;
    }
    start += pageSize;
    index += pageSize;
    counternext++;
    pageCounter++;
    return list1;


  }

  public List previous(List list) {
    if (counternext > 0) {
      start -= pageSize;
      index -= pageSize;
    }
    start -= pageSize;
    index -= pageSize;
    counternext = 0;
    pageCounter--;
    counterprevious++;
    return list.subList(start, index);

  }

  public String hasNext(List list) {
    String result;
    if (counternext > 0) {
      index -= pageSize;
    }
    if (index < list.size() && memory < list.size()) {
      result = "has next";
    } else {
      result = "hasn't next";
    }
    index += pageSize;
    return result;
  }

  public String hasPrevious() {
    String result;
    if (start <= pageSize) {
      result = "hasn't previous";
    } else {
      result = "has previous";
    }
    return result;
  }

  public List firstPage(List list) {
    int index1 = pageSize;
    int start1 = 0;
    pageCounter = 1;
    index += pageSize;
    start += pageSize;
    return list.subList(start1, index1);
  }

  public List lastPage(List list) {
    int index1;
    int start1;
    index1 = list.size();
    memory = index;
    if (list.size() % pageSize > 0) {
      start1 = list.size() - list.size() % pageSize;
    } else {
      start1 = list.size() - pageSize;
    }
    pageCounter(list);
    index = index1;
    start = start1;
    if (counternext > 0) {
      index+=pageSize;
      start+=pageSize;
    }
    return list.subList(start1, index1);
  }

  public int getCurrentPageNumber() {
    return pageCounter;
  }

  private int lastElement(List list) {
    return (Integer) list.get(list.size() - 1);
  }

  private int pageCounter(List list) {
    int value;
    if (list.size() % pageSize < pageSize) {
      value = 1;
    } else {
      value = list.size() % pageSize;
    }
    if (list.size() % pageSize > 0) {
      pageCounter = (list.size() / pageSize) + value;
    } else {
      pageCounter = list.size() / pageSize;
    }
    return pageCounter;
  }

}
