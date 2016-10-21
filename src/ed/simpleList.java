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
public class simpleList<T> {

    private node first;
    private node last;

    public simpleList() {
        this.first = null;
        this.last = null;
    }

    public node getFirst() {
        return first;
    }

    public void setFirst(node first) {
        this.first = first;
    }

    public node getLast() {
        return last;
    }

    public void setLast(node last) {
        this.last = last;
    }

    public void insertFirst(T n) {
        node nodo = new node(n);
        if (isEmpty()) {// está vacía
            first = nodo;//apuntador hacia el  node
            last = nodo;//apuntador hacia el  node
        } else {
            nodo.setNext(first);
            first = nodo;
        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void insertLast(T n) {
        node nodo = new node(n);
        if (isEmpty()) {// está vacía
            first = nodo;//apuntador hacia el  node
            last = nodo;//apuntador hacia el  node
        } else {
            node aux = findLast();
            aux.setNext(nodo);
        }
    }

    private node findLast() {
        node aux1 = first;
        while (aux1.getNext() != null) {
            aux1 = aux1.getNext();
        }
        return aux1;
    }

    public void eraseFirst() {
        if (isEmpty()) {
            System.out.print("La lista está vacía");
        } else {
            first = first.getNext();
        }
    }

    public void eraseLast() {
        if (isEmpty()) {
            System.out.print("La lista está vacía");
        } else {
            node aux = first;
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
            node aux1 = first;
            node aux2 = first;
            while(!aux2.getData().equals(data)){
                aux1= aux2;
                aux2= aux2.getNext();
            }
            aux1.setNext(aux2.getNext());
        }
    }


public void showList() {
        if (!isEmpty()) {
            node aux = first;
            while (aux != null) {
                System.out.println(aux.getData());
                aux = aux.getNext();
            }
        } else {
            System.out.print("La lista está vacía");
        }
    }
}
