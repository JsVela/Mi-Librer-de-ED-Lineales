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
public class AVLTree {
private AVLnode r;
    public AVLTree (){
        r = null;
    }

    public void insert(Comparable x) {
        r = insertar(x, r);
    }

    // x es una instancia de una clase que implementa Comparable
    private AVLnode insertar (Comparable x, AVLnode p) {  
        if (p == null) {
            p = new AVLnode (x, null, null);    
        }
        else
            if (x.compareTo(p.dato) < 0) {
                p.izquierdo = insertar(x, p.izquierdo); 
                System.out.println(" altura: "+ (height(p.izquierdo) - height(p.derecho)));
                if (height(p.izquierdo) - height(p.derecho) == 2) {
                    if (x.compareTo(p.izquierdo.dato) < 0) {
                        p = rotacionHijoIzquierdo(p);
                    }
                    else {
                        p = rotacionDobleHijoIzquierdo(p);
                    }
                }
                else
                    p.height = height(p.derecho) - height(p.izquierdo);
            }
            else
                if (x.compareTo(p.dato) > 0) {
                    p.derecho = insertar(x, p.derecho);
                    System.out.println(" altura: "+ (height(p.derecho) - height(p.izquierdo)));
                    if (height(p.derecho) - height(p.izquierdo) == 2) {
                        if (x.compareTo(p.derecho.dato) > 0) {
                            p = rotacionHijoDerecho(p); /* Caso 4 */
                        }
                        else {
                            p = rotacionDobleHijoDerecho(p); /* Caso 3 */
                        }
                    }
                    else 
                        p.height = height(p.derecho) - height(p.izquierdo);
                }
        return p;
    }


    public static int height(AVLnode p) {
        return p == null ? -1 : p.height;
    }

    private static int max(int izquierdaHeight, int derechaHeight) {
        return izquierdaHeight > derechaHeight ? izquierdaHeight : derechaHeight;
    }

    private static AVLnode rotacionHijoIzquierdo(AVLnode p) {
        System.out.println("Rotación Hijo Izquierdo");
        AVLnode aux2 = p.izquierdo;
        p.izquierdo = aux2.derecho;
        aux2.derecho = p;
        p.height = max(height(p.izquierdo), height(p.derecho)) + 1;
        aux2.height = max(height(aux2.izquierdo), p.height) + 1;
        return aux2;
    }

    private static AVLnode rotacionHijoDerecho(AVLnode p) {
        System.out.println("Rotacion Hijo Derecho");
        AVLnode aux2 = p.derecho;
        p.derecho = aux2.izquierdo;
        aux2.izquierdo = p;
        p.height = max(height(p.izquierdo), height(p.derecho)) + 1;
        aux2.height = max(height(aux2.derecho), p.height) - 1;     //cambio de +1 a -1
        return aux2;
    }

    private static AVLnode rotacionDobleHijoIzquierdo(AVLnode aux) {
        System.out.println("Rotacion Doble Hijo Izquierdo");
        aux.izquierdo = rotacionHijoDerecho(aux.izquierdo);
        return rotacionHijoIzquierdo(aux);
    }

    private static AVLnode rotacionDobleHijoDerecho(AVLnode aux) {
        System.out.println("Rotacion Doble Hijo Derecho");
        aux.derecho = rotacionHijoIzquierdo(aux.derecho);
        return rotacionHijoDerecho(aux);
    }
    
    // imprimir árbol en inorden
    
    public void imprimir() {
        imprimir(r);
    }

    private void imprimir(AVLnode nodo) {
        if (nodo != null) {
            imprimir(nodo.derecho);
            System.out.println("[" + nodo.dato + "]");
            imprimir(nodo.izquierdo);
        }
    }

    public void imprimirPorAltura() {
        imprimirPorltura(r);
    }

    /* Imprime cada nodo linea por linea. Recorriendo el arbol desde
     * el Nodo más a la derecha hasta el nodo más a la izquierda,
     * y dejando una indentación de varios espacios en blanco segun su
     * altura en el árbol
     */
    
    private void imprimirPorltura(AVLnode nodo) {
        if (nodo != null) {
            imprimirPorltura(nodo.derecho);
            System.out.println(replicate(" ", height(r) - height(nodo)) + "[" + nodo.dato + "]");
            imprimirPorltura(nodo.izquierdo);
        }
    }

    /* Metodo estático auxiliar que dada una cadena a y un entero cnt
     * replica o concatena esa cadena a, cnt veces
     */
    private static String replicate(String a, int cnt) {
        String x = new String("");
        for (int i = 0; i < cnt; i++) {
            x = x + a;
        }
        return x;
    }

// Obtiene la altura del arbol AVL
    public int calcularAltura() {
        return calcularAltura(r);
    }

    private int calcularAltura(AVLnode actual) {
        if (actual == null) {
            return -1;
        } else {
            return 1 + Math.max(calcularAltura(actual.izquierdo), calcularAltura(actual.derecho));
        }
    }

    // Imprime el arbol por niveles. Comienza por la raiz.
    public void imprimirPorNiveles() {
        imprimirPorNiveles(r);
    }

    // imprime primero en anchura
    // utiliza una cola estática como auxiliar en el proceso
    public void BreadthFirst ( ) {
    queue q = new queue ();
    AVLnode tmp;
    q.insertLast ( r );
    while ( !q.isEmpty ( ) ) {
        tmp = (AVLnode) q.getFirst();
        q.deleteFirst();
        if ( tmp.izquierdo != null )
            q.insertLast(tmp.izquierdo );
        if ( tmp.derecho != null )
            q.insertLast(tmp.derecho );
        System.out.print ( tmp.dato + " " );
    }
    System.out.println("");
}

    // Imprime el arbol por niveles.
    private void imprimirPorNiveles(AVLnode nodo) {
        // Mediante la altura calcula el total de nodos posibles del Árbol 
        // Y crea una array cola con ese tamaño
        int max = 0;
        int nivel = calcularAltura();
        for (; nivel >= 0; nivel--) {
            max += Math.pow(2, nivel);
        }
        max++;   // Suma 1 para no utilizar la posicion 0 del array 
        AVLnode cola[] = new AVLnode[max];
        // Carga en la pos 1 el nodo raiz
        cola[1] = nodo;
        int x = 1;
        // Carga los demas elementos del arbol,
        // Carga null en izq y der si el nodo es null
        //i aumenta de a 2 por que carga en izq y der los hijos
        // x aumenta 1, que son los nodos raiz - padre
        for (int i = 2; i < max; i += 2, x++) {
            if (cola[x] == null) {
                cola[i] = null;
                cola[i + 1] = null;
            } else {
                cola[i] = cola[x].izquierdo;
                cola[i + 1] = cola[x].derecho;
            }
        }
        nivel = 0;
        int cont = 0;  // contador para cada nivel
        int cantidad = 1; // cantidad de nodos por nivel
        int ultimaPosicion = 1; // ultimaPosicion del nodo en la cola de cada nivel
        // Cuando i es = a 2^nivel hay cambio de nivel
        // 2 ^ 0 = 1 que es el nodo raiz

        for (int i = 1; i < max; i++) {
            if (i == Math.pow(2, nivel)) {
                // Nodo raiz tiene nivel 1, por eso (nivel + 1)
                System.out.print("Nivel " + (nivel) + ": ");
                nivel++;
            }
            if (cola[i] != null) {
                System.out.println("[" + cola[i].dato + "]");
                cont++;
            }
            if (ultimaPosicion == i && cantidad == Math.pow(2, --nivel)) {
                if (cantidad == 1) {
                    System.out.println(" Cantidad de nodos: " + cont + " (raiz)");
                } else {
                    System.out.println(" Cantidad de nodos: " + cont);
                }
                cont = 0;
                cantidad *= 2;
                ultimaPosicion += (int) Math.pow(2, ++nivel);
            }
        }
    }
}
