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
    private List <User> vertices;
    private int[][] matriz;
    private int nVertices;
    private int maxVertices;
    private String[] relation;
    private int nRelation;

    public Grafo( int max, List<User> user, String[] relation) {
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
    
    /**
    *Anadir un Relación 
    * Metodo que pertmite agregar las relaciones entre cada usuario
    * @param r Represeta un string que contriene los vertices y el tiempo de la relacione que se quiere agregar
    */
    public void addRelation (String r){
        String[] temp = r.split(", ");
        int a = getIndex(temp[0]);
        int b = getIndex(temp[1]);
        if (a != -1 && b != -1){
            matriz[a][b] = Integer.parseInt(temp[2]);
            matriz[b][a] = Integer.parseInt(temp[2]);
            nRelation++;
        }else{
            JOptionPane.showMessageDialog(null,"No fueron encontrados los usuarios");  
        }
    }
    
    /**
    *Leer un Relacion
    * Metodo que pertmite Leer u agregar las relaciones que viene del txt
    */
    public void readRelation(){
        System.out.println(relation.length);
        for (int i = 0; i < (relation.length  ); i++) {
            addRelation(relation[i]);
        }
    }
    
    /**
    * Indice Usuario
    * Metodo que permite obtener el indice en el que se encuentra un usuario
    * @param word Represeta el ID del usuario del cual se desea obtener indice
    * @return retorna el index del usuario 
    */
    public int getIndex(String word){
        System.out.println(word);
        for(int i = 0; i < (relation.length - 1); i++){
            if(vertices.getElement(i).getId().equals(word)){
                return i;
            }
        }
        return -1;
    }
    
    
    /**
    * Nombre Usuario
    * Metodo que permite obtener el Nombre de un usuario, Ubicado en una posicion en espicifico
    * @param index Represeta la posicion del almacen del cual se desa obtener el nombre
    * @return retorna el nombre del almacen 
    */
    public String getNameUser(int index){
        String a = "";
        for(int i = 0; i < vertices.getLength(); i++){
            if(index == i){
                a += vertices.getElement(i).getId();
            }
        }
        return a ;
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
    
     public int Bfs() {
        boolean[] visitado = new boolean[nVertices];
//        List<User> user = getVertices();
        int contadorIslas = 0;
        for (int i = 1; i < nVertices; ++i) {
            if (!visitado[i]) {
                // Si el vértice no ha sido visitado
                contadorIslas++;
                System.out.println("Isla "+ contadorIslas);
                // Visitar la isla utilizando el recorrido por anchura
                Queue <Integer> cola = new Queue();
                visitado[i] = true;
                cola.enqueue(i);
                while (!cola.isEmpty()) {
                    System.out.println(cola.getHead().getData());
                    int v = cola.despachar();
                    for (int j = 0; j < nVertices; ++j) {
                        if (matriz[v][j] != 0 && !visitado[j]) {
                            visitado[j] = true;
                            cola.enqueue(j);
                        }
                    }
                }
            }
        }
        return contadorIslas;
    }

    public boolean[] createListVisited(){
        boolean[] visited = new boolean[nVertices];
        for (int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        return visited;
    }
    
    public List<User> dfs(int start, boolean[] visited, List<User> ListUser){
        int contadorIslas = 0;
        if(vertices.isEmpty()){
            JOptionPane.showMessageDialog(null,"No hay informacion almacenada"); 
        }else if (start < vertices.getLength() && start > -1){
        visited[start] = true;
        ListUser.insertLast(vertices.getElement(start));
        for (int i = 0; i < matriz[start].length; i++) {
            if (matriz[start][i] != 0 && (!visited[i])) {
                dfs(i, visited, ListUser);
                contadorIslas++;
                    }
            }
        return ListUser;
        }else{
            JOptionPane.showMessageDialog(null,"Error en el idex!"); 
        }
        return null;
    }
    
     
    public int contarIslasDfs() {
        boolean[] visitado = new boolean[nVertices];
        int contadorIslas = 0;
        for (int i = 0; i < nVertices; ++i) {
            if (!visitado[i]) {
                // Si el vértice no ha sido visitado, es una nueva isla
                contadorIslas++;
                // Visitar la isla utilizando el recorrido por profundidad
                Pila pila = new Pila();
                visitado[i] = true;
                pila.push(i);
                while (!pila.isEmpty()) {
                    pila.pop();
                    for (int j = 0; j < nVertices; ++j) {
                        if (matriz[i][j] != 0 && !visitado[j]) {
                            visitado[j] = true;
                            pila.push(j);
                        }
                    }
                }
            }
        }
        return contadorIslas;
    }
}
    