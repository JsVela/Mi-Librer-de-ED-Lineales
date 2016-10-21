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
public class stack<T> {

    //Atributos
    private node top;
    private int size;

    //Constructor
    public stack() {
        this.top = null;
        this.size = 0;
    }

    //Métodos
    //Getters
    public node getTop() {
        return top;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        node nodo = new node(data);
        if (isEmpty()) {
            top = nodo;
        } else {//Está lleno
            nodo.setNext(top);
            top = nodo;
        }
        ++size;
    }

    public void pop() {
        if (!isEmpty()) {
            top = top.getNext();
            --size;

        } else {
            System.out.println("La pila está vacía");
        }
    }
    
    public Object pop2() {
        if (!isEmpty()) {
            Object info = top.getData();
            top = top.getNext();
            --size;
            return info;
        } else {
            System.out.println("La pila está vacía");
            return null;
        }
    }

    public void emptyStack() {
        top = null;
        size = 0;
    }

    public void showStack() {
        if (!isEmpty()) {
            node aux = top;
            do {
                System.out.println(aux.getData());
                System.out.println("|");
                System.out.println("V");
                aux = aux.getNext();
            } while (aux != null);
        }
        System.out.println("null");
    }
}
