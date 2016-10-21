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
// ponemos <T> para que reciba cualquier parámetro(que sea genérica)
public class queue<T> {

    //Atributos
    private node first;
    private node last;
    private int size;

    //Constructor
    public queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    // Constructor sobrecargado
    public queue(T data) {
        insertLast(data);
    }

    //Métodos
    public void insertLast(T data) {
        node nodo = new node(data);
        if (isEmpty()) {
            this.first = nodo;
            this.last = nodo;
        } else {
            node aux = first;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(nodo);
            last = nodo;
        }
        ++this.size;
    }

    public void deleteFirst() {
        if (!isEmpty()) {
            first = first.getNext();
            --this.size;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void setEmpty() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public Object getFirst() {
        return first.getData();
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
