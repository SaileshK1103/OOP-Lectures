package task_2;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList <T>{
    private final List<T> list = new ArrayList<>();

    public synchronized void add(T element){
        list.add(element);
    }

    public synchronized boolean remove(T element){
        return list.remove(element);
    }

    public synchronized int size(){
        return list.size();
    }

    public synchronized  void print(){
        System.out.println(list);
    }
}
