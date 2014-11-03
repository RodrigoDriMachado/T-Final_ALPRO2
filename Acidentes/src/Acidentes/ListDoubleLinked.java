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

        private class Node<T> {

        public T element;
        public Node<T> next;
        public Node<T> prev;

        public Node(T e) {
            element = e;
            next = null;
            prev = null;
        }
    }
    private Node<E> header;
    private Node<E> trailer;
    private int count;

    public ListDoubleLinked() {
        header = new Node<E>(null);
        trailer = new Node<E>(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    @Override
    public void add(E element) {
        Node<E> novoNodo = new Node(element);
        novoNodo.next = trailer;
        novoNodo.prev = trailer.prev;
        trailer.prev.next = novoNodo;
        trailer.prev = novoNodo;
        count++;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> novoNodo = new Node<>(element);
        if (index == count) {
            novoNodo.next = trailer;
            novoNodo.prev = trailer.prev;
            trailer.prev.next = novoNodo;
            trailer.prev = novoNodo;
            count++;
        } else {
            Node<E> aux = null;
            if (index < count / 2) {
                aux = header.next;
                for (int i = 0; i < index; i++) {
                    aux = aux.next;
                }
            } else {
                aux = trailer.prev;
                for (int i = count - 1; i > index; i--) {
                    aux = aux.prev;
                }
            }
            novoNodo.next = aux;
            novoNodo.prev = aux.prev;
            aux.prev.next = novoNodo;
            aux.prev = novoNodo;
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> aux = null;
        if (index < count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        return aux.element;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> aux = null;
        if (index < count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        E elem = aux.element;
        aux.element = element;
        return elem;

    }

    @Override
    public boolean remove(E element) {
        Node<E> aux=header.next;
        for(int i=0; i<count;i++){
            if(aux.element.equals(element)){
                aux.prev.next=aux.next;
                aux.next.prev=aux.prev;
                count--;
                return true;
            }
            else{
                aux=aux.next;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> aux = null;
        if (index < count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        aux.next.prev = aux.prev;
        aux.prev.next = aux.next;
        count--;
        return aux.element;
    }

    @Override
    public boolean isEmpty() {
      return (header.next==trailer);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(E element) {
         Node<E> aux=header.next;
        for(int i=0; i<count;i++){
            if(aux.element.equals(element)){
                return true;
            }
            else{
                aux=aux.next;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        Node<E> aux = header.next;
        while (aux != null) {
            if (aux.element.equals(element)) {
                return (index);
            }
            aux = aux.next;
            index++;
        }
        return -1;
        
    }

    @Override
    public void clear() {
        header.next=trailer;
        trailer.prev= header;
        count=0;
    }

}
