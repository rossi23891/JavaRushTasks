package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    Queue<Entry<String>> nodes = new LinkedList<>();
    int size = -1;
    int totalPriority = 0;

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
            int min = nodes.size();
            Entry<String> current=nodes.peek();
            for (Entry<String> node : nodes) {
                if(node.getPriority()<=min){
                    min = node.getPriority();
                    current=node;
                }
            }
            if(!current.isAvailableToAddChildren()){
                nodes.remove(current);
                continue;
            }
            Entry<String> newNode = new Entry<>(s);
            newNode.setPriority(++totalPriority);
            if(current.availableToAddLeftChildren){
             current.setLeftChild(newNode);
             newNode.setParent(current);
             ((LinkedList<Entry<String>>) nodes).add(newNode);
             return true;
            }else {
                current.setRightChild(newNode);
                newNode.setParent(current);
                ((LinkedList<Entry<String>>) nodes).add(newNode);
                return true;
            }
        }
        return false;
    }

    public String getParent(String s){
        String parentName;
        Queue<Entry<String>>nodes=new LinkedList<>();
        ((LinkedList<Entry<String>>) nodes).add(root);
        if(root.elementName.equals(s)){
            return null;
        }else{
            parentName=traverseToFindParent(nodes,s);
        }
        return parentName;
    }

    public String traverseToFindParent(Queue<Entry<String>>nodes,String s) {
        while (!nodes.isEmpty()){
            Entry<String>node =nodes.remove();
            if(node.elementName.equals(s)){
                return node.getParent().elementName;
            }
            if(node.leftChild!=null){
                nodes.add(node.leftChild);
            }
            if(node.rightChild!=null){
                nodes.add(node.rightChild);
            }
        }
        return null;
    }
    public Entry<String> traverseToFindNode(String s) {
        Queue<Entry<String>>currentTree = new LinkedList<>();
        ((LinkedList<Entry<String>>) currentTree).add(root);
        while (!currentTree.isEmpty()){
            Entry<String>node =currentTree.remove();
            if(node.elementName.equals(s)){
                return node;
            }
            if(node.leftChild!=null){
                currentTree.add(node.leftChild);
            }
            if(node.rightChild!=null){
                currentTree.add(node.rightChild);
            }
        }
        return null;
    }
  /*  public void deleteRemovedNodeChildren(Queue<Entry<String>>nodes) {
        while (!nodes.isEmpty()){
            Entry<String>node =nodes.remove();
            if(node.leftChild==null &&node.rightChild==null){
                node.setParent(null);
            }
            if(node.leftChild!=null){
                nodes.add(node.leftChild);
            }
            if(node.rightChild!=null){
                nodes.add(node.rightChild);
            }
        }
    }*/

    public void traversePreOrderToFindSize(Queue<Entry<String>>nodes) {
        while (!nodes.isEmpty()){
            Entry<String>node =nodes.remove();
            size++;
            if(node.leftChild!=null){
                nodes.add(node.leftChild);
            }
            if(node.rightChild!=null){
                nodes.add(node.rightChild);
            }
        }
    }

    @Override
    public boolean remove(Object o) {
        if(!(o instanceof String)){
            throw new UnsupportedOperationException();
        }
        Entry<String> nodeToBeDeleted = traverseToFindNode((String)o);
        Entry<String> parentOfDeletedNode = nodeToBeDeleted.getParent();
        if(nodeToBeDeleted.equals(parentOfDeletedNode.leftChild)){
            parentOfDeletedNode.setLeftChild(null);
            nodeToBeDeleted.setParent(null);
            parentOfDeletedNode.availableToAddLeftChildren=true;
        }else{
            parentOfDeletedNode.setRightChild(null);
            nodeToBeDeleted.setParent(null);
            parentOfDeletedNode.availableToAddRightChildren=true;
        }

        return true;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        Queue<Entry<String>>nodes=new LinkedList<>();
        ((LinkedList<Entry<String>>) nodes).add(root);
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
        int priority;

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

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }
    }
}
