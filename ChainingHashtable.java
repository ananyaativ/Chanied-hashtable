package com.company;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.ListIterator;

public class ChainingHashtable {
    private LinkedList<StoredEmployee>[] hashtable;

    public ChainingHashtable(){
        hashtable=new LinkedList[10];
        for(int i=0;i<hashtable.length;i++){
            hashtable[i]=new LinkedList<StoredEmployee>();
        }
    }
    private int hashkey(String key){
        return key.length()% hashtable.length;
    }

    public void put(String key,Employee employee){
        int hashedkey=hashkey(key);
        hashtable[hashedkey].add(new StoredEmployee(key,employee));
    }
    public Employee get(String key){
        int hashedkey=hashkey(key);
        StoredEmployee employee=null;
        ListIterator<StoredEmployee> iterator=hashtable[hashedkey].listIterator();
        while (iterator.hasNext())
        {
            employee=iterator.next();
           if(employee.key.equals(key))
               return employee.employee;
        }
        return null;
    }

    public Employee remove(String key){
        int hashedkey=hashkey(key);
        StoredEmployee employee=null;
        int index=-1;
        ListIterator<StoredEmployee> iterator=hashtable[hashedkey].listIterator();
        while (iterator.hasNext())
        {
            employee=iterator.next();
            index++;
            if(employee.key.equals(key))
                break;
        }
        if(employee.key.equals(key)) {
            hashtable[hashedkey].remove(index);
            return employee.employee;
        }
        else
            return null;

    }

    public void print(){
        for(int i=0;i<hashtable.length;i++){
            if(hashtable[i]==null)
                System.out.println("empty");
            else
            {  System.out.print("position "+ i + ": ");
                ListIterator<StoredEmployee> iterator= hashtable[i].listIterator();
                while (iterator.hasNext()){
                    System.out.print(iterator.next().employee);
                    System.out.print("->");
                }
                System.out.println("null");
            }

        }
    }
}
