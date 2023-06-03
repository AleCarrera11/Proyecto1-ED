/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import javax.swing.JOptionPane;

     /**
    * Esta clase maneja todo lo relacionado al grafo, su creacion, el agregar relaciones, vertices, y crear la matriz de adyacencia
    * @author alejandra
    */
public class Grafo {
    private List <User> vertices;
    private int[][] matriz;
    private int nVertices;
    private int maxVertices;
    private String[] relation;
    private int nRelation;
    
     
    /**
    * Constructor del grafo
    * @param max Represeta el numero de vertices maximo
    * @param user Representa una lista de usuarios 
    * @param relation Representa las relaciones entre los usuarios, traidas del txt
    */
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
        
     /**
    * Obtener el atributo nRelation del grafo
    * @return retorna el numero de relaciones 
    */
    public int getnRelation() {
        return nRelation;
    }
    
     /**
    * Metodo que permite modificar el atributo nRelation del grafo
    * @param nRelation Representa el numero arcos (relaciones) que hay en el grafo
    */
    public void setnRelation(int nRelation) {
        this.nRelation = nRelation;
    }
    
    /**
    * Obtener el atributo vertices del grafo
    * @return retorna Lista de Usuarios
    */
    public List<User> getVertices(){
        return vertices;
    }
    
    /**
    * Obtener el atributo matriz del grafo
    * @return retorna la matriz de adyacencia
    */
    public int[][] getMatriz(){
        return matriz;
    }
    
    /**
    * Obtener el atributo nVertices del grafo
    * @return retorna el numero de vertices que hay en el grafo
    */
    public int getnVertices(){
        return nVertices;
    }
    
    /**
    * Obtener el atributo maxVertices del grafo
    * @return retorna el maximo de vertices que puede tener el grafo
    */
    public int getMaxVertices() {
        return maxVertices;
    }
    
    /**
    * Obtener el atributo relation del grafo
    * @return retorna las relaciones del txt
    */
    public String[] getRelation() {
        return relation;
    }
    
    /**
    * Metodo que permite modificar el atributo vertices del grafo
    * @param vertices Representa una lista de Usuarios
    */
    public void setVertices(List<User> vertices) {
        this.vertices = vertices;
    }
    
     /**
    * Metodo que permite modificar el atributo matriz del grafo
    * @param matriz Representa la matriz de Adyacencia
    */
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    /**
    * Metodo que permite modificar el atributo nVertices del grafo
    * @param nVertices Representa el numero de vertices que hay en el grafo
    */
    public void setnVertices(int nVertices) {
        this.nVertices = nVertices;
    }
    
    /**
    * Metodo que permite modificar el atributo maxVertices del grafo
    * @param maxVertices Representa el numero max de vertices que contiene en el grafo
    */
    public void setMaxVertices(int maxVertices) {
        this.maxVertices = maxVertices;
    }
    /**
    * Metodo que permite modificar el atributo relation del grafo
    * @param relation Representa las relaciones leidas del txt
    */
    public void setRelation(String[] relation) {
        this.relation = relation;
    }
    
    /**
    *Anadir una Relación 
    * Metodo que pertmite agregar las relaciones entre cada usuario
    * @param r Represeta un string que contriene los vertices y el tiempo de la relacion que se quiere agregar
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
    * Metodo que pertmite leer u agregar las relaciones que viene del txt
    */
    public void readRelation(){
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
        for(int i = 0; i < (relation.length - 1); i++){
            if(vertices.getElement(i).getId().equals(word)){
                return i;
            }
        }
        return -1;
    }
    
    /**
    * Nombre Usuario
    * Metodo que permite obtener el Nombre de un usuario, Ubicado en una posicion en especifico
    * @param index Represeta la posicion del usuario del cual se desa obtener el nombre
    * @return retorna el nombre del usuario 
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
    
     /**
    * Recorrido Anchura
    * Metodo que permite obtener la cantidad de islas que hay por recorrido en anchura de un grafo
    * @return retorna la cantidad de islas que se forman 
    */
     public int Bfs() {
        boolean[] visitado = new boolean[nVertices];
        int contadorIslas = 0;
        for (int i = 1; i < (nVertices ); ++i) {
            if (!visitado[i]) {
                // Si el vértice no ha sido visitado
                contadorIslas++;
                // Visitar la isla utilizando el recorrido por anchura
                Queue <Integer> cola = new Queue();
                
                visitado[i] = true;
                cola.enqueue(i);
                while (!cola.isEmpty()) {
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
     
     
     
     public List<String> buscarPuentes() {
        boolean[] visitado = new boolean[nVertices];
        int contadorIslas = 0;
        int[] tiempoDescubrimiento = new int[nVertices];
        int[] tiempoBajo = new int[nVertices];
        int tiempoActual = 0;
        List<String> puentes = new List<>();
        for (int i = 1; i < nVertices; ++i) {
            if (!visitado[i]) {
                // Si el vértice no ha sido visitado
                contadorIslas++;
                // Visitar la isla utilizando el recorrido por anchura
                Queue<Integer> cola = new Queue<>();
                visitado[i] = true;
                tiempoDescubrimiento[i] = tiempoActual++;
                cola.enqueue(i);
                while (!cola.isEmpty()) {
                    int v = cola.despachar();
                    for (int j = 0; j < nVertices; ++j) {
                        if (matriz[v][j] != 0) {
                            if (!visitado[j]) {
                                visitado[j] = true;
                                tiempoDescubrimiento[j] = tiempoActual++;
                                tiempoBajo[j] = tiempoDescubrimiento[j];
                                cola.enqueue(j);
                            } else if (tiempoDescubrimiento[j] < tiempoDescubrimiento[v] && visitado[j]) {
                                tiempoBajo[v] = min(tiempoBajo[v], tiempoDescubrimiento[j]);
                            } else if (j != v && tiempoDescubrimiento[j] > tiempoDescubrimiento[v]) {
                                tiempoBajo[v] = min(tiempoBajo[v], tiempoBajo[j]);
                                if (tiempoBajo[j] > tiempoDescubrimiento[v]) {
                                    String puente = (v) + "-" + (j);
                                    puentes.insertLast(puente);
                                }
                            }
                        }
                    }
                }
            }
        }
        return puentes;
    }
    
     public int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /**
    * Imprime las islas que se recorrieron por anchura
    * Metodo que permite obtener la informacion de cada nodo en las islas que hay, por recorrido en anchura de un grafo
    * @return retorna el Id y el usuario de cada nodo de las islas que se forman  
    */
    public String printBfs(){
        boolean[] visitado = new boolean[nVertices];
        String printBfs = "";
        int contadorIslas = 0;
        for (int i = 1; i < nVertices; ++i) {
            if (!visitado[i]) {
                
                contadorIslas++;
                printBfs += "Isla "+ contadorIslas + "\n";
                
                Queue <Integer> cola = new Queue();
                visitado[i] = true;
                cola.enqueue(i);
                while (!cola.isEmpty()) {
                    printBfs += vertices.getElement(((Integer)(cola.getHead().getData()))).getId()+ "," +vertices.getElement(((Integer)(cola.getHead().getData()))).getUser() + "\n";
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
            return printBfs;
        }
    
    public String printPuentes(){
        boolean[] visitado = new boolean[nVertices];
        String printBfs = "";
        int contadorIslas = 0;
        for (int i = 1; i < nVertices; ++i) {
            if (!visitado[i]) {
                int tiempoActual = 0;
                contadorIslas++;
                Queue<Integer> cola = new Queue<>();
                visitado[i] = true;
                int[] tiempoDescubrimiento = new int[nVertices];
                int[] tiempoBajo = new int[nVertices];
                tiempoDescubrimiento[i] = tiempoActual++;
                cola.enqueue(i);
                boolean hayPuentes = false;
                String puentes = "";
                while (!cola.isEmpty()) {
                    int v = cola.despachar();
                    for (int j = 0; j < nVertices; ++j) {
                        if (matriz[v][j] != 0) {
                            if (!visitado[j]) {
                                visitado[j] = true;
                                tiempoDescubrimiento[j] = tiempoActual++;
                                tiempoBajo[j] = tiempoDescubrimiento[j];
                                cola.enqueue(j);
                            } else if (tiempoDescubrimiento[j] < tiempoDescubrimiento[v] && visitado[j]) {
                                tiempoBajo[v] = min(tiempoBajo[v], tiempoDescubrimiento[j]);
                            } else if (j != v && tiempoDescubrimiento[j] > tiempoDescubrimiento[v]) {
                                tiempoBajo[v] = min(tiempoBajo[v], tiempoBajo[j]);
                                if (tiempoBajo[j] > tiempoDescubrimiento[v]) {
                                    if (puentes.isEmpty()) {
                                        puentes += "Puentes en la Isla " + contadorIslas + ":\n";
                                    }
                                    puentes += v + "-" + j + "\n";
                                    hayPuentes = true;
                                }
                            }
                        }
                    }
                }
                if (hayPuentes) {
                    printBfs += puentes;
                }
            }
        }
        return printBfs;
    }
 
    /**
    * Metodo que permite obtener un arreglo de la cantidad de islas que hay por recorrido en profundidad de un grafo
    * @return retorna la lista de islas que hay, el lenght de esta lista es la cantidad de islas que se forman
    */
    public List<List<Integer>> Dfs () {
    int n = matriz.length;
    boolean[] visited = new boolean[n];
    List<List<Integer>> islands = new List();

    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            List<Integer> island = new List<>();
            dfs(visited, i, island);
            islands.insertLast(island);
        }
    }
    return islands;
    }
    

     /**
    * Recorrido Profundidad
    * Metodo que permite recorrer por profundidad el grafo
     * @param visited Representa una lista con los usuarios que se han visitado en el grafo
     * @param v Represeta el indice del vertice orige, de donde se iniciara el recorrido
     * @param island es una lista con los indices de los usuarios
    */
    public void dfs(boolean[] visited, int v, List<Integer> island) {
        visited[v] = true;
        island.insertLast(v);

        for (int w = 0; w < matriz.length; w++) {
            if (matriz[v][w] > 1 && !visited[w]) {
                dfs( visited, w, island);
            }
        }
    }
    
    /**
    * Imprime las islas que se recorrieron por profundidad
    * Metodo que permite obtener la informacion de cada nodo en las islas que hay, por recorrido por profundidad de un grafo
    * @return retorna el Id y el usuario de cada nodo de las islas que se forman  
    */
    public String printDfs(){
        String printDfs = "";
        List<List<Integer>> islands = Dfs();
        for (int i = 0 ; i < islands.getLength(); i++) {
            List<Integer> island = new List();
            island = islands.getElement(i);
            printDfs += "Isla " + (i+1) + "\n";
            Nodo aux = island.getHead();
            for (int j = 0; j < island.getLength(); j++) {
                printDfs += vertices.getElement(((Integer)(aux.getData()))).getId()+ "," +vertices.getElement(((Integer)(aux.getData()))).getUser() + "\n";
                aux = aux.getNext();
            }
//            printDfs += vertices.getElement(((Integer)(island.getHead().getData()))).getId()+ "," +vertices.getElement(((Integer)(island.getHead().getData()))).getUser() + "\n";
        }
        return printDfs;
    }
}
    