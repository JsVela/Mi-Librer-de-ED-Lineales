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
public class AVLnode {
    public Comparable dato; // el dato del nodo
    public AVLnode izquierdo; // hijo izquierdo
    public AVLnode derecho; // hijo derecho
    public int height; // altura

    // Constructores
    public AVLnode(Comparable dato) {
        this(dato, null, null);
    }

    public AVLnode(Comparable dato, AVLnode izq, AVLnode der) {
        this.dato = dato;
        this.izquierdo = izq;
        this.derecho = der;
        height = 0; // altura predeterminada
    }
}
