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
public class nodeTree {

    //Atributos
    int data;
    nodeTree left;
    nodeTree right;

    //Constructor
    public nodeTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public nodeTree getLeft() {
        return left;
    }

    public nodeTree getRight() {
        return right;
    }
    
    public void setData ( int data ) {
        this.data = data;
    }

    public void setLeft ( nodeTree left ) {
        this.left = left;
    }

    public void setRight ( nodeTree right ) {
        this.right = right;
    }
}