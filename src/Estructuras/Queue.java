/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author usuario
 * @param <T>
 */
public class Queue <T> {
    private Nodo head,end;
    private int length;
    
    /**
    * Constructor de la Cola
    */
    public Queue(){
        this.head = null;
        this.end = null;
        this.length = 0;
    }
    
    /**
    * Obtener el atributo head de la cola
    * @return retorna el nodo que se encuentra en la cabeza de la cola
    */
    public Nodo getHead() {
        return head;
    }
    /**
    * Metodo que permite modificar el atributo head del Producto
    * @param head Representa en nuevo nodo que ira al principio de la cola
    */
    public void setHead(Nodo head) {
        this.head = head;
    }

    /**
    * Obtener el atributo end de la cola
    * @return retorna el nodo que se encuentra al final de la cola
    */
    public Nodo getEnd() {
        return end;
    }

    /**
    * Metodo que permite modificar el atributo end del Producto
    * @param end Representa en nuevo nodo que ira al final de la cola
    */
    public void setEnd(Nodo end) {
        this.end = end;
    }

    /**
    * Obtener el atributo length de la cola
    * @return retorna la cantidad de elementos que tiene la cola
    */
    public int getLength() {
        return length;
    }

    /**
    * Metodo que permite modificar el atributo length del Producto
    * @param length Representa la nueva cantidad de elementos que hay en la cola
    */
    public void setLength(int length) {
        this.length = length;
    }
    
    /**
    * Metodo que retorna Verdadero si la cola esta vacia
    * @return
    */
    public boolean isEmpty(){
        return getHead() == null;
    }
    
    
    /**
    * Metodo que permite encolar la cola (agregar al final)
    * @param data Representa la informacion que se le quiere agregar al nodo
    */
    public void enqueue(T data){
        Nodo nodo = new Nodo(data);
        if(isEmpty()) {
            setHead(nodo);
            setEnd(nodo);
        } else {
            getEnd().setNext(nodo);
            setEnd(nodo);
        }
        length++;
    }
    
    /**
    * Metodo que permite desencolar la cola (eliminar al inicio)
    */
    public void dequeue(){
        if(!isEmpty()) {
            if (length == 1){
                setHead(null);
                setEnd(null);
            } else {
                Nodo temp = getHead();
                setHead(temp.getNext());
                temp.setNext(null);
            }
            length--;
        }
    }
    
     /**
    * Metodo que permite saber que elemento se encuentra al inicio de la cola
    * @return 
    * @retun T la informacion del nodo al inicio de la cola
    */
    public T consult() { /////Noso porque lo tengo que castear
        return (T) getHead().getData();
    }
    
     /**
    * Metodo que permite saber que elemento se encuentra al inicio de la cola y eliminarolo
     * @return 
    */
    public T despachar() {
        T temp = consult();
        dequeue();
        return temp;
    }
}
