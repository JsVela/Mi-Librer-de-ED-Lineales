/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed;

/**
 *
 * @author JESUS PARGA VELA
 * @param <T>
 */
public class node <T> {
    T data;
    node next;
    /*
    Constructor
    */
    public node(T data){
        this.data = data;
        this.next = null;
    }
    
     //Métodos
    
    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return this.data;
    }
    public void setNext(node n){
        this.next = n;
    }
    public node getNext(){
        return this.next;
    }
}
