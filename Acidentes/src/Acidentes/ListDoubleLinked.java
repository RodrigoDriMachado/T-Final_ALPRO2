/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Acidentes;

/**
 *
 * @author RODRIGO
 */
public class ListDoubleLinked<E> implements ListTAD<E> {
    
    private Node<E> head;
    private Node<E> tail;
    private int count;

    
    private class Node<T> {

        public T element;
        public Node<T> next;
        public Node<T> ant;

        public Node(T e) {
            element = e;
            next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }
        
    }
    
    @Override
    public void add(E element) {
        Node<E> novoNodo = new Node(element);
        if(isEmpty()){
            head.next = novoNodo;
            novoNodo.ant = head;
            novoNodo.next= tail;
            tail.ant = novoNodo;
        }
        else{
            novoNodo.ant = tail;
            tail.next = novoNodo;
            tail = novoNodo;
        }
        count++;
    }

    @Override
    public void add(int index, E element) {
        if(index<0||index>count){
            throw new IndexOutOfBoundsException();
        }
        Node<E> novoNodo = new Node(element);
        if (index == 0) {
            if (isEmpty()) {
                head.next = novoNodo;
                novoNodo.ant = head;
                novoNodo.next= tail;
                tail.ant = novoNodo;
                count++;
                return;
            }
        } else {
            Node<E> aux = head;
            //Node<E> ant = null;
            for (int i = 0; i < count; i++) {
                if (i == index) {
                    aux.ant.next = novoNodo;
                    novoNodo.ant = aux.ant;
                    aux.ant=novoNodo;
                    novoNodo.next = aux;
                    count++;
                    return;
                } else {
                    aux = aux.next;
                }
            }
        }
        tail.ant.next = novoNodo;
        novoNodo.ant = tail.ant;
        novoNodo.next = tail;
        tail.ant = novoNodo;
        count++;
        return;
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}