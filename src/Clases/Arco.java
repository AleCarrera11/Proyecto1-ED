/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author adrianlovera
 */
public class Arco {

    private int distance;
    private String originVertexName;
    private String destinationVertexName;
    private int destinationVertexNumber;


    public Arco(int distance, String originVertexName, String destinationVertexName, int destinationVertexNumber) {
        //this.destino = destino;
        this.distance = distance;
        this.originVertexName = originVertexName;
        this.destinationVertexName = destinationVertexName;
        this.destinationVertexNumber = destinationVertexNumber;
    }


    public Arco(String originVertexName, String destinationVertexName, int distance) {

        this.distance = distance;
        this.originVertexName = originVertexName;
        this.destinationVertexName = destinationVertexName;
    }


    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getOriginVertexName() {
        return originVertexName;
    }

    public void setOriginVertexName(String originVertexName) {
        this.originVertexName = originVertexName;
    }

    public String getDestinationVertexName() {
        return destinationVertexName;
    }

    public void setDestinationVertexName(String destinationVertexName) {
        this.destinationVertexName = destinationVertexName;
    }

    public int getDestinationVertexNumber() {
        return destinationVertexNumber;
    }

    public void setDestinationVertexNumber(int destinationVertexNumber) {
        this.destinationVertexNumber = destinationVertexNumber;
    }


}