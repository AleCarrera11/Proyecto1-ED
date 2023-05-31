/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author soyis
 */
public class txtPrueba {
    private Map<String, Integer> vertexMap;
    private int[][] adjacencyMatrix;
    private int numVertices;

    public txtPruebah() {
        this.numVertices = numVertices;
        this.vertexMap = new HashMap<>();
        this.adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void readTxt(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            int currentVertex = 0;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                for (String token : tokens) {
                    if (!vertexMap.containsKey(token)) {
                        vertexMap.put(token, currentVertex);
                        currentVertex++;
                    }
                }
                int from = vertexMap.get(tokens[0]);
                int to = vertexMap.get(tokens[1]);
                adjacencyMatrix[from][to] = 1;
                adjacencyMatrix[to][from] = 1;
            }
        } catch (IOException e) {
        }
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//Esto creará un grafo con cuatro nodos (A, B, C y D) y tres relaciones. Para utilizar este código, debes crear una instancia de la clase `TxtToGraph`, indicando el número de nodos que tendrá el grafo. Luego, llama al método `readTxt()` con la ruta del archivo de texto como argumento. Finalmente, puedes imprimir el grafo llamando al método `printGraph()`.
//
//Ten en cuenta que este código asume que las relaciones son no dirigidas. Si tu archivo contiene relaciones dirigidas, deberás modificar el código para crear un grafo dirigido en su lugar.
