/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Isabella Pereira, Adrian Lovera, Alejandra Carrera
 */
public class Pila {
    public class Stack {
    private int[] elements;
    private int top;

    public Stack(int size) {
        this.elements = new int[size];
        this.top = -1;
    }

    // agrega un elemento al tope de la pila
    public void push(int value) {
        if (top == elements.length - 1) {
            System.out.println("Stack overflow");
        } else {
            top++;
            elements[top] = value;
        }
    }

    //remueve y devuelve el elemento del tope de la pila
    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            int value = elements[top];
            top--;
            return value;
        }
    }

    //devuelve el elemento del tope de la pila sin removerlo
    public int peek() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            return elements[top];
        }
    }

    //devuelve true si la pila está vacía, false en caso contrario
    public boolean isEmpty() {
        return top == -1;
    }
}
}
