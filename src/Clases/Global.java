/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Estructuras.Grafo;
import Estructuras.List;
/**
 *
 * @author usuario
 */
public class Global {
    private static Grafo grafo;
    private static int path = 0;
    private static List<user> user = new List<user>();
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

    public static List<user> getUser() {
        return user;
    }

    public static void setUser(List<user> user) {
        Global.user = user;
    }

    public static String[] getRelation() {
        return relation;
    }

    public static void setRelation(String[] relation) {
        Global.relation = relation;
    }
    
}
