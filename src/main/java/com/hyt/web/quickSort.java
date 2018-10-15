package com.hyt.web;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuliang on 2017/9/26.
 */
public class quickSort {
   /* public static void main(String[] args) {
        List<Integer> list =new ArrayList<Integer>();
        list.add(6);
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(9);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(10);
        list.add(8);
        quickSort quickSort = new quickSort();
        quickSort.quick_sort(0,list.size()-1,list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }*/


    public  void  quick_sort(int left, int right,List<Integer> list){
        int i,j,baseValue,n = list.size();
        if (left>right)return ;
        baseValue=list.get(left);
        i=left;
        j=right;
        while (i!=j){
            while(list.get(j)>=baseValue && i<j)j--;
            while(list.get(i)<=baseValue && i<j)i++;
            if(i<j){
                int temp = list.get(i);
                list.set(i,list.get(j));
                list.set(j,temp);
            }
        }
        list.set(left,list.get(i));
        list.set(i,baseValue);
        quick_sort(left,i-1,list);
        quick_sort(i+1,right,list);
    }

}
