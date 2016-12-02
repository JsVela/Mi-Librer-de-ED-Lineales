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
public class GraphVerticeArista extends Graph {
     public void MuestraVertices ( ) {
        GraphNode q = g;
        while ( q != null ) {
            System.out.println ( q.GetInfo ( ) );
            q = q.GetNext ( );
        }
    }

    public void MuestraAristas ( GraphNode q ) {
        q = q.GetPoint ( );
        while ( q != null ) {
            System.out.println ("     Con vértice " + q.GetPoint().GetInfo() + ": Peso = " + q.GetInfo ( ) );
            q = q.GetNext ( );
        }
    }

}
