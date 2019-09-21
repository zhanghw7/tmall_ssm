package com.how2java.tmall.util;

import javax.print.DocFlavor;

public class Page {
   private int start=0;
   private int count =5;
   private int total;
   private String param;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public boolean isHasPrevious(){
       if(start>=5)
           return true;
       else
           return false;

   }
   public int getTotalPage(){
        int totalPage;
       if(0==total%count)
           totalPage=total/count;
       else
           totalPage=total/count+1;
       if(totalPage==0)
           totalPage=1;
           return totalPage;
   }
   public int getLast(){
        int last;
        if(0==total%count)
            last = total-count;
        else
        last = total-total%count;
        return  last;

   }
   public boolean isHasNext(){
        if(start>=getLast())
            return false;
        else
            return true;
   }

    @Override
    public String toString() {
        return "Page{" +
                "start=" + start +
                ", count=" + count +
                ", total=" + total +
                ", param='" + param + '\'' +
                '}';
    }

}
