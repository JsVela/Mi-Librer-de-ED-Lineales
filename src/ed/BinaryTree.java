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
    public void setRaiz(nodeTree root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }
    
    public void insertNode(int data, nodeTree root) {
        nodeTree nodo = new nodeTree(data);
        insertNode(nodo,root);
    }

    public void insertNode(nodeTree nodo, nodeTree root) {
        if (isEmpty()) {//Está vacío
            root = nodo;
            this.heigth++;
        } else//Si no está vacío
            if (root.data <= nodo.data) {
                //Si el nodo es mayor que raíz
                if (root.right == null) {
                    root.right = nodo;
                } else {//Si tiene un elemento a la izq
                  //Buscará por la izquierda hasta encontrar un espacio  
                    insertNode(nodo, root.right);
                  }
            } else//Si no es mayor que raiz
                if (root.left == null) {//Caso base
                  root.left = nodo;
                } else {//Si tiene un elemento a la derecha, busacará por la derecha hasta encontrar un espacio
                    insertNode(nodo, root.left);
                  }
        this.elements++;
    }

    public void eraseNode(int data, nodeTree root) {
        nodeTree p, q;
        for (p = null, q = getRaiz();
                q != null && data != q.data;
                p = q, q = data < q.data ? q.left : q.right);
        if (q == null) {
            System.out.println("no hay nodo para borrar");;
        }
        if (q.left != null && q.right != null) {// nodo con dos hijos
            q.data = eraseNodoMenorDer(q);
        }
        if (q.left == null && q.right == null) {// nodo hoja
            if (p != null) {
                if (p.left == q) {
                    p.left = null;
                } else {
                    p.right = null;
                }
            } else {
                setRaiz(null);
            }
        } else if (q.left == null) {// solo tiene hijo derecho
            if (q == getRaiz()) {
                setRaiz(q.right);
            } else if (p.left == q) {
                p.left = q.right;
            } else {
                p.right = q.right;
            }
        } else// solo tiene hijo izquierdo
        if (q == getRaiz()) {
            setRaiz(q.left);
        } else if (p.left == q) {
            p.left = q.left;
        } else {
            p.right = q.left;
        }
        --this.elements;
    }

    public int eraseNodoMenorDer(nodeTree q) {
        int o;
        nodeTree aux = q, b = q;
        q = q.right;
        while (q.left != null) {
            aux = q;
            q = q.left;
        }
        if (aux == b) {
            aux.right = q.right;
        } else {
            aux.left = q.right;
        }
        o = q.data;
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
        System.out.print(p.data + " ");
        preOrden(p.left);
        preOrden(p.right);
    }

    public void inOrden() {
        inOrden(getRaiz());
    }

    protected void inOrden(nodeTree p) {
        if (p == null) {
            return;
        }
        inOrden(p.left);
        System.out.print(p.data + " ");
        inOrden(p.right);
    }

    public void postOrden() {
        postOrden(getRaiz());
    }

    protected void postOrden(nodeTree p) {
        if (p == null) {
            return;
        }
        postOrden(p.left);
        postOrden(p.right);
        System.out.print(p.data + " ");
    }
}
