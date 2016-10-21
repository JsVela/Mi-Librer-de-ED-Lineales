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
public class circularList<T> {

    //Atributos
    private node first;

    //Constructor nulo
    public circularList() {
        first = null;
    }

    private boolean isEmpty() {
        return first == null;
    }

    //Insertar al Inicio
    public void insertInicio(T d) {
        //Creamos nuestro nodo a insertar
        node nodo = new node(d);
        if (!isEmpty()) {//Si no está vacía la lista
            //Insertamos el nodo al inicio y recorremos los nodos
            nodo.setNext(first);
            findLast().setNext(nodo);
            first = nodo;
        } else { //Si la lista está vacía
            first = nodo;
            nodo.next = first;
        }
    }

    //Insertar al final
    public void insertFinal(T d) {
        //Creamos nuestro nodo a insertar
        node nodo = new node(d);
        if (!isEmpty()) {//Si no está vacía la lista
            // recorremos los nodos y el último lo enlazamos con el nuevo
            findLast().setNext(nodo);
            // el nuevo lo enlazamos con el primero
            nodo.setNext(first);
        } else { //Si la lista está vacía
            first = nodo;
            nodo.setNext(first);
        }
    }

    // Borrar nodo inicial
    public void borrarInicio() {
        // se respalda dirección al primer nodo
        node nodo = first;
        if (!isEmpty()) {//Si no está vacía la lista
            // recorremos los nodos y el último lo enlazamos con el segundo
            findLast().setNext(first.getNext());
            first = first.getNext();
        }
    }

    // Borrar nodo final
    public void borrarFinal() {
        node aux = first;
        if (!isEmpty()) {//Si no está vacía la lista
            if (aux.getNext() == first) {
                first = null;
            } else {
                // recorremos los nodos hasta el penúltimo
                while (aux.getNext().getNext() != first) {
                    aux = aux.getNext();
                }
            }
            // el penúltimo se enlaza con el primero y se elimina el último
            aux.setNext(first);
        }
    }

    private node findLast() {
        node aux = first;
        while (aux.getNext() != first) {
            aux = aux.getNext();
        }
        return aux;
    }

// BorrarNodo (int n)
    public void borrarNodo(T d) {
        // busca nodo a borrar
        if (!isEmpty()) {
            node aux = findNode(d), b;
            if (aux.getNext() != first) {
                b = aux.getNext();  // b es nodo a borrar
                //borra el nodo b al romper el enlace
                aux.setNext(b.getNext());
            }
        }
    }

    // recorre lista hasta encontrar el nodo anterior
    private node findNode(T d) {
        node p = first, q = first;
        do {
            p = q;
            q = q.next;
        } while (q != first && q.getData() != d);
        return p;
    }

    // muestra la lista
    public void showList() {
        node aux = first;
        if (isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            do {
                System.out.println("[" + aux.getData() + "]->");
                aux = aux.getNext();
            } while (aux.getNext() != first);
        }
    }
}
