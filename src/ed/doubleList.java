/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed;

/**
 *
 * @author JESUS PARGA VELA
 */
public class doubleList <T>{
    private nodeDouble first;
    private nodeDouble last;

    public doubleList() {
        this.first = null;
        this.last = null;
    }

    public nodeDouble getFirst() {
        return first;
    }

    public void setFirst(nodeDouble first) {
        this.first = first;
    }

    public nodeDouble getLast() {
        return last;
    }

    public void setLast(nodeDouble last) {
        this.last = last;
    }

    public void insertFirst(T n) {
        nodeDouble nodo = new nodeDouble(n);
        if (isEmpty()) {// está vacía
            first = nodo;//apuntador hacia el  node
            last = nodo;//apuntador hacia el  node
        } else {
            nodo.setNext(first);
            first.setPrevious(nodo);
            first = nodo;
        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void insertLast(T n) {
        nodeDouble nodo = new nodeDouble(n);
        if (isEmpty()) {// está vacía
            first = nodo;//apuntador hacia el  node
            last = nodo;//apuntador hacia el  node
        } else {
            nodeDouble aux = findLast();
            aux.setNext(nodo);
            nodo.setPrevious(aux);
        }
    }

    private nodeDouble findLast() {
        nodeDouble aux = first;
        while (aux.getNext() != null) {
            aux = aux.getNext();
        }
        return aux;
    }

    public void eraseFirst() {
        if (isEmpty()) {
            System.out.print("La lista está vacía");
        } else {
            nodeDouble aux = first;
            aux.getNext().setPrevious(null);
            first = first.getNext();
        }
    }

    public void eraseLast() {
        if (isEmpty()) {
            System.out.print("La lista está vacía");
        } else {
            nodeDouble aux = first;
            while (aux.getNext().getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(null);
        }
    }
    
    public void eraseNode(T data){
        if (isEmpty()) {
            System.out.print("La lista está vacía");
        } else {
            nodeDouble aux = first;
            while(!aux.getData().equals(data)){
                aux= aux.getNext();
            }
            if(aux == first){
                eraseFirst();
            }else{
                if(aux.getNext()== null){
                    aux.getPrevious().setNext(null);
                }else{
                    nodeDouble pre = aux.getPrevious();
                    nodeDouble post = aux.getNext();
                    pre.setNext(post);
                    post.setPrevious(pre);
                }
            }
            aux.setNext(aux.getNext());
        }
    }


public void showListFL() {
        if (!isEmpty()) {
            nodeDouble aux = first;
            while (aux != null) {
                System.out.println(aux.getData());
                aux = aux.getNext();
            }
        } else {
            System.out.print("La lista está vacía");
        }
    }

public void showListLF() {
        if (!isEmpty()) {
            nodeDouble aux = findLast();
            while (aux != null) {
                System.out.println(aux.getData());
                aux = aux.getPrevious();
            }
        } else {
            System.out.print("La lista está vacía");
        }
    }
}
