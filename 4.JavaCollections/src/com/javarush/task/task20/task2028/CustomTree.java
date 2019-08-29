package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    Deque<Entry<String>> nodes = new LinkedList<>();
    int size = -1;

    public void initialize(){
        ((LinkedList<Entry<String>>) nodes).add(root);
    }

    public CustomTree() {
        root = new Entry<>("root");
        initialize();
    }

    @Override
    public boolean add(String s) {
        while(!nodes.isEmpty()){
            Entry<String> current = nodes.peek();
            if(!current.isAvailableToAddChildren()){
                nodes.remove(current);
                continue;
            }
            Entry<String> newNode = new Entry<>(s);
            if(current.availableToAddLeftChildren){
             current.setLeftChild(newNode);
             newNode.setParent(current);
             ((LinkedList<Entry<String>>) nodes).addLast(newNode);
             return true;
            }else {
                current.setRightChild(newNode);
                newNode.setParent(current);
                ((LinkedList<Entry<String>>) nodes).addLast(newNode);
                return true;
            }
        }
        return false;
    }

    public String getParent(String s){
        String parentName;
        Deque<Entry<String>>nodes=new LinkedList<>();
        ((LinkedList<Entry<String>>) nodes).addLast(root);
        if(root.elementName.equals(s)){
            return null;
        }else{
            parentName=traversePreOrderToFindParent(nodes,s);
        }
        return parentName;
    }

    public String traversePreOrderToFindParent(Deque<Entry<String>>nodes,String s) {
        while (!nodes.isEmpty()){
            Entry<String>node =nodes.removeFirst();
            if(node.elementName.equals(s)){
                return node.getParent().elementName;
            }
            if(node.leftChild!=null){
                nodes.addLast(node.leftChild);
            }
            if(node.rightChild!=null){
                nodes.addLast(node.rightChild);
            }
        }
        return null;
    }
    public void traversePreOrderToFindSize(Deque<Entry<String>>nodes) {
        while (!nodes.isEmpty()){
            Entry<String>node =nodes.removeFirst();
            size++;
            if(node.leftChild!=null){
                nodes.addLast(node.leftChild);
            }
            if(node.rightChild!=null){
                nodes.addLast(node.rightChild);
            }
        }
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        Deque<Entry<String>>nodes=new LinkedList<>();
        ((LinkedList<Entry<String>>) nodes).addLast(root);
        traversePreOrderToFindSize(nodes);
        return size;
    }


    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public void setParent(Entry<T> parent) {
            this.parent = parent;
        }

        public Entry<T> getParent() {
            return parent;
        }

        public boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren|availableToAddRightChildren;
        }

        public void setLeftChild(Entry<T> leftChild) {
            this.leftChild = leftChild;
            this.availableToAddLeftChildren=false;
        }

        public void setRightChild(Entry<T> rightChild) {
            this.rightChild = rightChild;
            this.availableToAddRightChildren = false;
        }
    }
}
