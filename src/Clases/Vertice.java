/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Estructuras.List;

/**
 *
 * @author adrianlovera
 */
public class Vertice {
    String nombre;
    int numVertice;
    List<Object> lad;
    
    
    public Vertice(String x) {
        nombre = x;
        numVertice = -1;
        lad = new List();
    }
    
    // Devuelve verdadero si dos vertices se llaman igual
    public boolean equals(Object d) {
        Vertice dos = (Vertice) d;
        return nombre.equals(dos.nombre);
    }
    
    // Indica el número que identificará este vértice
    public void asigVert(int n) {
        numVertice = n;
    }
    
    // Devuelve el nombre del vértice
    public String nomVertice() {
        return nombre;
    }
    
    // Imprime el nombre y número de vértice
    public String toString() {
        return nombre + " (" + numVertice + ")";
    }
}