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

public class ShortestPath {

    public void dijkstra(int[][] grafo, int origen, int destino) {
        int n = grafo.length; // Número de nodos
        int[] dist = new int[n]; // Distancias mínimas desde el origen
        boolean[] visitado = new boolean[n]; // Nodos visitados
        int[] previo = new int[n]; // Para reconstruir el camino

        // Inicialización
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE; // "Infinito"
            previo[i] = -1; // Sin nodo previo
        }
        dist[origen] = 0; // Distancia al nodo origen es 0

        // Algoritmo principal
        for (int i = 0; i < n; i++) {
            int u = encontrarMinimo(dist, visitado, n); // Nodo con menor distancia no visitado
            if (u == -1) {
                break; // Si no hay nodo alcanzable, termina
            }
            visitado[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visitado[v] && grafo[u][v] != 0 && grafo[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE) {
                    if (dist[u] + grafo[u][v] < dist[v]) {
                        dist[v] = dist[u] + grafo[u][v]; // Actualiza la distancia mínima
                        previo[v] = u; // Guarda el nodo previo
                    }
                }
            }
        }

        // Mostrar el resultado
        imprimirCamino(destino, previo, dist);
    }

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

    private void reconstruirCamino(int destino, int[] previo) {
        if (destino == -1) {
            return; // Caso base: no hay más previos
        }
        reconstruirCamino(previo[destino], previo); // Llamada recursiva
        System.out.print(destino + " "); // Imprime el nodo actual
    }
}
