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
public class nodeDouble <T> {
    T data;
    nodeDouble next;
    nodeDouble previous;
    /*
    Constructor
    */
    public nodeDouble(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }
    
     //Métodos
    
    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return this.data;
    }
    public void setNext(nodeDouble n){
        this.next = n;
    }
    public nodeDouble getNext(){
        return this.next;
    }

    public nodeDouble getPrevious() {
        return previous;
    }

    public void setPrevious(nodeDouble previous) {
        this.previous = previous;
    }
}
