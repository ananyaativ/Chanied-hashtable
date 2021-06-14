package com.company;

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        Employee james=new Employee("james", "quinn",154);
        Employee mary=new Employee("mary", "ra",98);
        Employee jack=new Employee("jack", "hose",987);
        Employee hary=new Employee("hary","morg",76);

        ChainingHashtable ht=new ChainingHashtable();
        ht.put("quinn",james);
        ht.put("ra",mary);
        ht.put("hose",jack);
        ht.put("morg",hary);
        ht.print();
        System.out.println(ht.get("ra"));
        ht.remove("hose");
        ht.remove("quinn");
        ht.print();
        System.out.println(ht.get("ra"));




    }
	// write your code here
    }

