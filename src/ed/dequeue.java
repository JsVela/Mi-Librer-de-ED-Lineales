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
public class dequeue <T> {
    //Atributos
    nodeDouble first;
    nodeDouble last;
    int size;
    
    //Constructor
    public dequeue(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    //Métodos
    private boolean isEmpty() {
        return first == null;
    }

    public void insertFront(T n){
        nodeDouble nodo = new nodeDouble(n);
        if(isEmpty()){//Está vacía
            first = nodo;
            last = nodo;
        }else{//tiene al menos uno
            nodo.setNext(first);
            first.setPrevious(nodo);
            first = nodo;
        }
    }
    public void insertBack(T n){
        nodeDouble nodo = new nodeDouble(n);
        if(isEmpty()){//Está vacía
            first = nodo;
            last = nodo;
        }else{//tiene al menos uno
            last.setNext(nodo);
            nodo.setPrevious(last);
            last = nodo;
        }
    }
    public void eraseFront(){
        if(isEmpty()){//Está vacía
            System.out.println("La dequeue está vacía");
        }else{//tiene al menos uno
            if(this.size == 1){
                first = last = null;
                --size;
            }else{
                first.getNext().setPrevious(null);
                first = first.getNext();
            }
        }
    }
    public void eraseBack(){
       if(isEmpty()){//Está vacía
            System.out.println("La dequeue está vacía");
        }else{//tiene al menos uno
             --size;
            if(this.size == 1){
                first = last = null;
            }else{
                last.getPrevious().setNext(null);
                last = last.getPrevious();   
            }
        } 
    }
    public nodeDouble front(){
        return this.first;
    }
    
    public nodeDouble back(){
        return this.last;
    }
    
    public void emptyDequeue(){
        first = last = null;
        this.size = 0;
    }
    
    public int sizeDequeue(){
        return this.size;
    }
}
