/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1;

/**
 *
 * @author cotiz
 */
import java.util.*;

/**
 * Clase para calcular la ruta más corta en un grafo utilizando el algoritmo de
 * Dijkstra. Dijkstra es un algoritmo de búsqueda de caminos mínimos desde un
 * nodo fuente hacia todos los demás nodos del grafo, considerando un grafo
 * ponderado con pesos no negativos.
 */
import java.util.*;

public class ShortestPath {

    /**
     * Implementa el algoritmo de Dijkstra para encontrar la distancia más corta
     * entre un nodo origen y un nodo destino en un grafo representado como una
     * matriz de adyacencia.
     *
     * @param grafo Matriz de adyacencia que representa el grafo. Cada celda
     * `grafo[i][j]` indica el peso de la arista entre los nodos `i` y `j`.
     * @param origen Índice del nodo de origen.
     * @param destino Índice del nodo de destino.
     */
    public void dijkstra(int[][] grafo, int origen, int destino) {
        int n = grafo.length; // Número de nodos en el grafo
        int[] dist = new int[n]; // Arreglo para guardar las distancias mínimas desde el origen
        boolean[] visitado = new boolean[n]; // Arreglo para marcar los nodos visitados
        int[] previo = new int[n]; // Arreglo para reconstruir el camino más corto

        // Inicialización
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE; // Inicializar distancias como "infinito"
            previo[i] = -1; // Inicializar nodos previos como no definidos
        }
        dist[origen] = 0; // La distancia del origen a sí mismo es 0

        // Algoritmo principal
        for (int i = 0; i < n; i++) {
            // Encontrar el nodo no visitado con la distancia mínima
            int u = encontrarMinimo(dist, visitado, n);
            if (u == -1) {
                break; // Si no hay más nodos alcanzables, termina
            }
            visitado[u] = true; // Marcar el nodo como visitado

            // Actualizar las distancias de los nodos vecinos
            for (int v = 0; v < n; v++) {
                if (!visitado[v] && grafo[u][v] != 0 && grafo[u][v] != Integer.MAX_VALUE) {
                    if (dist[u] + grafo[u][v] < dist[v]) {
                        dist[v] = dist[u] + grafo[u][v]; // Actualizar la distancia mínima
                        previo[v] = u; // Guardar el nodo previo para reconstruir el camino
                    }
                }
            }
        }

        // Mostrar el resultado del camino más corto
        imprimirCamino(destino, previo, dist);
    }

    /**
     * Encuentra el índice del nodo no visitado con la distancia mínima actual.
     *
     * @param dist Arreglo con las distancias mínimas actuales.
     * @param visitado Arreglo que indica si un nodo ya ha sido visitado.
     * @param n Número total de nodos.
     * @return Índice del nodo con la distancia mínima, o -1 si no hay nodos
     * disponibles.
     */
    private int encontrarMinimo(int[] dist, boolean[] visitado, int n) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < n; v++) {
            if (!visitado[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    /**
     * Imprime la distancia más corta desde el nodo origen al nodo destino y el
     * camino que se tomó para llegar.
     *
     * @param destino Índice del nodo destino.
     * @param previo Arreglo para reconstruir el camino.
     * @param dist Arreglo con las distancias mínimas desde el origen.
     */
    private void imprimirCamino(int destino, int[] previo, int[] dist) {
        if (dist[destino] == Integer.MAX_VALUE) {
            System.out.println("No hay camino desde el origen hasta el destino.");
            return;
        }

        System.out.println("Distancia más corta: " + dist[destino] + " km");
        System.out.print("Camino: ");
        reconstruirCamino(destino, previo);
        System.out.println();
    }

    /**
     * Reconstruye el camino más corto desde el nodo origen al destino. Se
     * utiliza recursión para construir el camino en el orden correcto.
     *
     * @param destino Índice del nodo destino.
     * @param previo Arreglo con los nodos previos para reconstruir el camino.
     */
    private void reconstruirCamino(int destino, int[] previo) {
        if (destino == -1) {
            return; // Caso base: no hay más previos
        }
        reconstruirCamino(previo[destino], previo); // Llamada recursiva
        System.out.print(destino + " "); // Imprime el nodo actual
    }
}
