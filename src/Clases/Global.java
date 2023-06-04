/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Estructuras.Grafo;
import Estructuras.List;
import Estructuras.User;

/**
 * Esta clase maneja algunos atributos que son necesarios acceder múltiples veces a lo largo del proyecto
 * @author alejandra, isabela, adrian
 */

public class Global {
    private static Grafo grafo;
    private static int path = 0;
    private static List<User> user = new List();
    private static String[] relation = new String[0];
    
    /**
     *  @return Grafo
     */
    public static Grafo getGrafo() {
        return grafo;
    }
    
    /**
     *  @param grafo
     */
    public static void setGrafo(Grafo grafo) {
        Global.grafo = grafo;
    }
    
    /**
     *  @return path que representa que información se desplegará en la ventana 2
     */
    public static int getPath() {
        return path;
    }
    
    /**
     *  @param path
     */
    public static void setPath(int path) {
        Global.path = path;
    }
    
    /**
     *  @return user que es la lista de usuarios en el grafo
     */
    public static List<User> getUser() {
        return user;
    }

    public static void setUser(List<User> user) {
        Global.user = user;
    }
    
    /**
     *  @return relation que es el array de las rutas del grafo
     */
    public static String[] getRelation() {
        return relation;
    }

    public static void setRelation(String[] relation) {
        Global.relation = relation;
    }
    
}
