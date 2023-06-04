/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 * Esta clase representa a los usuarios
 * @author alejandra, isabella, adrian
 */
public class User {
    private String id;
    private String user;

    /**
    * Constructor de usuario
     * @param id representa el id del usuario
     * @param user representa el nombre de usuario de la red social con el @
    */
    public User(String id, String user) {
        this.id = id;
        this.user = user;
    }

    /**
    * Obtener el atributo id del usuario
    * @return retorna el id del usuario
    */
    public String getId() {
        return id;
    }
    
    /**
    * Metodo que permite modificar el atributo id del usuario
    * @param id Representa el nuevo id del usuario
    */
    public void setId(String id) {
        this.id = id;
    }

     /**
    * Obtener el atributo nombre de usuario
     * @return user que es el nombre de usuario
    */
    public String getUser() {
        return user;
    }

    /**
    * Metodo que permite modificar el atributo user
    * @param user representa un nuevo nombre de usuario 
    */
    public void setUser(String user) {
        this.user = user;
    }

}
