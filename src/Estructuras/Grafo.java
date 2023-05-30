/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author usuario
 */
public class Grafo {
    private List <User> vertices;
    private int[][] matriz;
    private int nVertices;
    private int maxVertices;
    private String[] relation;
    private int nRelation;

    public Grafo( int max, List<User> User, String[] relation) {
        this.vertices = User;
        this.nVertices = User.getLength();
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
    
    public List<User> getVertices(){
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
    
    public void setVertices(List<User> vertices) {
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
    
    
}
