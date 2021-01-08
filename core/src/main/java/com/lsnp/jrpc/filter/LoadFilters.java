package com.lsnp.jrpc.filter;


import java.util.ArrayList;
import java.util.List;

public final class LoadFilters {

  private List<Filter> filterList = new ArrayList<Filter>();

  private LoadFilters() {
  }

  public static LoadFilters create() {

    return new LoadFilters();
  }

  public List<Filter> getFilters() {
    this.filterList.add(new ExampleFilter());
    this.filterList.add(new ExampleFilter2());
    return filterList;
  }

}
