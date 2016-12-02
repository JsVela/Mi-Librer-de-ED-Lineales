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
public class GraphNode {
    protected Object info;
    protected GraphNode point, next;

    public GraphNode ( ) {
        info = null;
        point = next = null;
    }
    
    public GraphNode ( Object x ) {
        info = x;
        point = next = null;
    }
    public void SetPoint ( GraphNode p ) {
        point = p;
    }
    
    public void SetNext ( GraphNode p ) {
        next = p;
    }

    public void SetInfo ( Object x ) {
        info = x;
    }

    public GraphNode GetPoint ( ) {
        return point;
    }

    public GraphNode GetNext ( ) {
        return next;
    }

    public Object GetInfo ( ) {
        return info;
    }

    public String toString ( ) {
        return "" + info;
    }
}
