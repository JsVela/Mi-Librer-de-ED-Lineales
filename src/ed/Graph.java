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
public class Graph <T> {
     protected GraphNode g;

    public Graph( ) {
        g = null;
    }

    public GraphNode  GetG ( ) {
        return g;
    }

    public boolean IsEmpty ( ) {
        return g == null;
    }
    public void JoinWt ( GraphNode  p, GraphNode  q, Object wt ) {  //la inserción se hace al final
        //  p y q   son referencias a los nodos cabeza
        //  wt es el peso del arco
        GraphNode  r2 = null, r = p.GetPoint ( );
        // busca en la lista de adyacencia un arco de p a q
        while ( r != null && r.GetPoint ( ) != q ) {
            r2 = r;
            r = r.GetNext ( );
        }
        if ( r == null ) {      // no existe el arco
            r = new GraphNode( );
            r.SetPoint ( q );
            r.SetNext ( null );
        }
        r.SetInfo ( wt );         // se actualiza el peso
        if ( r2 == null )         // no existe ningún arco
            p.SetPoint ( r );
        else
            r2.SetNext ( r );
    }

    public void RemvWt ( GraphNode  p, GraphNode  q, Object x ) {
        GraphNode  r2 = null, r = p.GetPoint ( );
        // busca en la lista de adyacencia un arco de p a q
        while ( r != null && r.GetPoint ( ) != q )  {
            r2 = r;
            r   = r.GetNext ( );
        }
        if ( r != null ) {      // existe el arco entre p y q
            x = r.GetInfo ( );      // toma el peso del arco
            if ( r2 == null )
                p.SetPoint ( r.GetNext ( ) );         //  rompe el enlace con el arco
            else
                r2.SetNext ( r.GetNext ( ) );
        }
    }

    public boolean Adjacent ( GraphNode  p, GraphNode  q ) {
        GraphNode  r = p.GetPoint ( );
        while ( r != null && r.GetPoint ( ) != q )
            r = r.GetNext ( );
        return ( r == null ? false : true);
    }

    public GraphNode FindNode ( Object x ) {
        GraphNode  p = g;
        while ( p != null && p.GetInfo ( ) != x )
            p = p.GetNext ( );
        return p;
    }

    public void AddNode ( Object x ) {   // las inserciones se hacen al inicio
        GraphNode  p = new GraphNode( );
        p.SetInfo ( x );
        p.SetPoint ( null );
        p.SetNext ( g );
        g = p;
    }
}
