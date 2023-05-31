/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Grafo {
    private List <user> vertices;
    private int[][] matriz;
    private int nVertices;
    private int maxVertices;
    private String[] relation;
    private int nRelation;

    public Grafo( int max, List<user> user, String[] relation) {
        this.vertices = user;
        this.nVertices = user.getLength();
        this.maxVertices = max;
        this.relation = relation;
        this.nRelation = 0;
        this.matriz = new int[max][max];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                this.matriz [i][j] = 0;
            }
            
        }
    }

    public int getnRelation() {
        return nRelation;
    }

    public void setnRelation(int nRelation) {
        this.nRelation = nRelation;
    }
    
    public List<user> getVertices(){
        return vertices;
    }
        
    public int[][] getMatriz(){
        return matriz;
    }
    
    public int getnVertices(){
        return nVertices;
    }
    
    public int getMaxVertices() {
        return maxVertices;
    }
    
    public String[] getRelation() {
        return relation;
    }
    
    public void setVertices(List<user> vertices) {
        this.vertices = vertices;
    }
    
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    public void setnVertices(int nVertices) {
        this.nVertices = nVertices;
    }
    
    public void setMaxVertices(int maxVertices) {
        this.maxVertices = maxVertices;
    }
    
    public void setRelation(String[] relation) {
        this.relation = relation;
    }
    
    /**
    *Anadir un Relacion 
    * Metodo que pertmite agregar las rutas entre cada almacen
    * @param r Represeta un string que contriene los vertices y el peso de la ruta que se quiere agregar
    */
    public void addRelation(String r){
        String[] temp = r.split(",");
        int a = Integer. parseInt(temp[0]);
        int b = Integer. parseInt(temp[1]);
        if (a != -1 && b != -1){
            matriz[a][b] = Integer.valueOf(temp[temp.length - 1]);
            nRelation++;
        }else{
            JOptionPane.showMessageDialog(null,"No fueron encontrada la relación");  
        }
    }
    
    /**
    *Leer una relación 
    * Metodo que pertmite Leer u agregar las rutas que viene del txt
    */
    public void readRelation(){
        for(int i=1; i< relation.length; i++){
            addRelation(relation[i]);           
        }
    }
    
    /**
    * Imprimri Matriz
    * Metodo que permite Imprimir la matriz de adyacencia
    */
    public void printMatrix(){
        for (int i = 0; i < nVertices; i++){
            for (int j = 0; j < nVertices; j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }
    
}
