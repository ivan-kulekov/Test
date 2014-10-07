package com.clouway.collections.task1;

import java.util.List;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class PageBean {
  private int pageSize = 2;
  private int index = pageSize;
  private int start;
  private int counter = 0;
  private int difference;
  private int pageCounter = 0;
  private int memory;

  public List next(List list) {
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
    counter++;
    pageCounter++;
    return list1;
  }

  public List previous(List list) {
    if (counter > 0) {
      start -= pageSize;
      index -= pageSize;
    }
    start -= pageSize;
    index -= pageSize;
    counter = 0;
    pageCounter--;
    return list.subList(start, index);

  }

  public String hasNext(List list) {
    String result;
    if (index <= list.size() + 1 && memory < list.size()) {
      result = "has next";
    } else {
      result = "hasn't next";
    }
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
    int index = pageSize;
    int start = 0;
    pageCounter = 1;
    return list.subList(start, index);
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
    return list.subList(start1, index1);
  }

  public int getCurrentPageNumber() {
    return pageCounter;
  }

  private int lastElement(List list) {
    String lastElement = (String) list.get(list.size() - 1);
    return Integer.parseInt(lastElement);
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
