/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Adrian
 */
public class User {
    private int id;
    private String username;
    private Nodo<User> friends;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
        this.friends = null;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Nodo<User> getFriends() {
        return friends;
    }

    public void addFriend(User friend) {
        Nodo<User> nodo = new Nodo<>(friend);
        if (this.friends == null){
            this.friends = nodo;
        } else {
            Nodo<User> aux = this.friends;
            while (aux.getNext() != null){
                aux = aux.getNext();
            }
            aux.setNext(nodo);
        }
    }
}
