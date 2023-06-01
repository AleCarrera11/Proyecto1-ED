/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author usuario
 */
public class Pila <T> {
    private Nodo peek;
    private Nodo base;
    private int len;

    public Pila() {
        this.peek = this.base = null;
        this.len = 0;
    }
    
    public boolean isEmpty(){
        return peek == null;
    }
    
    public void empty(){
        this.peek = this.base = null;
        this.len = 0;
    }

    public void push (T data) {
        Nodo nodo = new Nodo(data);
        if(this.isEmpty()){
            peek = base = nodo;
        }else{
            nodo.setNext(peek);
            peek = nodo;
            
        }
        len ++;
    }
    
    public void pop() {
        if (this.isEmpty()){
            System.out.println("La pila esta vacia");
        }else if(len==1){
            this.empty();
        }else{
            peek = peek.getNext();
            len --;
        }
    }
    
    public int getLen() {
        return len;
    }

    public Nodo getPeek() {
        return peek;
    }

    public boolean vacia() {
        return getPeek() == null;
    }

    public void setPeek(Nodo nodo) {
        this.peek = nodo;
    }


    public void setLength(int len) {
        this.len = len;
    } 
   
}
