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
public class BinaryTree {

    //Atributos
    nodeTree root;
    int heigth;
    int elements;

    //Constructor
    public BinaryTree() {
        this.root = null;
        this.heigth = -1;
        this.elements = 0;
    }

    //Métodos
    public void setRaiz ( nodeTree root ) {
        this.root = root;
    }
    public boolean isEmpty() {
        return this.root == null;
    }

    public void insertNode(int data, nodeTree root) {
        nodeTree nodo = new nodeTree(data);
        if (isEmpty()) {//Está vacío
            this.root = nodo;
            this.heigth++;
        } else//Si no está vacío
        //Si el nodo es mayor que raíz
        {
            if (this.root.data <= nodo.data) {
                if (root.left == null) {
                    root.left = nodo;
                } else {//Si tiene un elemento a la izq
                    //Buscará por la izquierda hasta encontrar un espacio  
                    insertNode(data, root.left);
                }
            } else//Si no es mayor que raiz
            {
                if (root.right == null) {//Caso base
                    root.right = nodo;
                } else {//Si tiene un elemento a la derecha, busacará por la derecha hasta encontrar un espacio
                    insertNode(data, root.right);
                }
            }
        }
        this.elements++;
    }

    public void eraseNode(int data, nodeTree root) {
        nodeTree p, q;
        for (p = null, q = getRaiz();
             q != null && data != q.getData();
             p = q, q = data < q.getData()?q.getLeft():q.getRight());
        if (q == null) {
            System.out.println("no hay nodo para borrar");;
        }
        if (q.getLeft() != null && q.getRight() != null) {// nodo con dos hijos
            q.setData(eraseNodoMenorDer(q));
        }
        if (q.getLeft() == null && q.getRight() == null) {// nodo hoja
            if (p != null) {
                if (p.getLeft() == q) {
                    p.setLeft(null);
                } else {
                    p.setRight(null);
                }
            } else {
                setRaiz(null);
            }
        } else {
            if (q.getLeft() == null) {// solo tiene hijo derecho
                if (q == getRaiz()) {
                    setRaiz(q.getRight());
                } else {
                    if (p.getLeft() == q) {
                        p.setLeft(q.getRight());
                    } else {
                        p.setRight(q.getRight());
                    }
                }
            } else {// solo tiene hijo izquierdo
                if (q == getRaiz()) {
                    setRaiz(q.getLeft());
                } else {
                    if (p.getLeft() == q) {
                        p.setLeft(q.getLeft());
                    } else {
                        p.setRight(q.getLeft());
                    }
                }
            }
        }
        --this.elements;
    }
    
    public int eraseNodoMenorDer ( nodeTree q ) {
        int o;
        nodeTree aux = q, b = q;
        q = q.getRight ( );
        while ( q.getLeft ( ) != null ) {
            aux = q;
            q = q.getLeft ( );
        }
        if ( aux == b )
            aux.setRight ( q.getRight ( ) );
        else
            aux.setLeft ( q.getRight ( ) );
        o = q.getData ( );
        return o;
    }


    public nodeTree getRaiz() {
        return this.root;
    }

    public int getHeigth() {
        return this.heigth;
    }

    public int getElements() {
        return this.elements;
    }

    public void preOrden() {
        preOrden(getRaiz());
    }

    protected void preOrden(nodeTree p) {
        if (p == null) {
            return;
        }
        System.out.print(p.getData() + " ");
        preOrden(p.getLeft());
        preOrden(p.getRight());
    }

    public void inOrden() {
        inOrden(getRaiz());
    }

    protected void inOrden(nodeTree p) {
        if (p == null) {
            return;
        }
        inOrden(p.getLeft());
        System.out.print(p.getData() + " ");
        inOrden(p.getRight());
    }

    public void postOrden() {
        postOrden(getRaiz());
    }

    protected void postOrden(nodeTree p) {
        if (p == null) {
            return;
        }
        postOrden(p.getLeft());
        postOrden(p.getRight());
        System.out.print(p.getData() + " ");
    }
}
