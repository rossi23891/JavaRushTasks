package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.Iterator;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    public Iterator<T> iterator(){
        return new RoundIterator();
    }

    public class RoundIterator implements Iterator<T> {
        Iterator<T> iterator = Solution.super.iterator();
        int cursor = 0;
        @Override
        public boolean hasNext() {
            if (!isEmpty()){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            cursor++;
            try{
                return iterator.next();
            }
            catch (Exception e){
                cursor = 0;
                iterator = Solution.super.iterator();
                return iterator.next();
            }
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }
}
