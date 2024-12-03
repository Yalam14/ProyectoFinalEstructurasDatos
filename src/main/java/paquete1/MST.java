/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MST {
    /**
     * Método para calcular el Árbol de Expansión Mínima (MST) de un grafo utilizando el algoritmo de Kruskal.
     * @param grafo El grafo del que se calculará el MST.
     * @return Una lista de conexiones que forman el MST.
     */
    public List<Conexion> kruskalMST(Grafo grafo) {
        List<Conexion> mst = new ArrayList<>();

        // Ordenar las conexiones por peso (distancia más corta primero)
        // Esto asegura que las conexiones de menor peso se consideren primero.
        Collections.sort(grafo.conexiones);

        // Inicializar los "padres" de cada vértice.
        // Esto es necesario para implementar conjuntos disjuntos (disjoint sets),
        // usados para detectar ciclos en el grafo.
        int[] padre = new int[grafo.vertices];
        for (int i = 0; i < grafo.vertices; i++) {
            padre[i] = i; // Cada vértice inicialmente es su propio padre.
        }

        // Iterar sobre todas las conexiones ordenadas.
        // Se agregan al MST solo aquellas conexiones que no formen ciclos.
        for (Conexion conexion : grafo.conexiones) {
            int padreOrigen = encontrarPadre(conexion.origen, padre);
            int padreDestino = encontrarPadre(conexion.destino, padre);

            // Si los nodos no están en el mismo conjunto, la conexión se agrega al MST.
            if (padreOrigen != padreDestino) {
                mst.add(conexion); // Agregar la conexión al MST.
                unir(padreOrigen, padreDestino, padre); // Unir los conjuntos.
            }
        }

        // Retornar la lista de conexiones que forman el MST.
        return mst;
    }

    /**
     * Método auxiliar para encontrar el representante (padre) de un vértice.
     * Esto implementa la compresión de caminos para optimizar futuras búsquedas.
     * @param vertice El vértice cuyo padre se desea encontrar.
     * @param padre El arreglo que almacena los padres de los vértices.
     * @return El representante (padre) del conjunto del vértice.
     */
    private int encontrarPadre(int vertice, int[] padre) {
        // Si el vértice no es su propio padre, buscar recursivamente su padre
        // y comprimir el camino para optimizar.
        if (padre[vertice] != vertice) {
            padre[vertice] = encontrarPadre(padre[vertice], padre);
        }
        return padre[vertice];
    }

    /**
     * Método auxiliar para unir dos conjuntos.
     * @param origen El vértice representante del primer conjunto.
     * @param destino El vértice representante del segundo conjunto.
     * @param padre El arreglo que almacena los padres de los vértices.
     */
    private void unir(int origen, int destino, int[] padre) {
        // Encontrar los representantes de ambos conjuntos y unirlos.
        int padreOrigen = encontrarPadre(origen, padre);
        int padreDestino = encontrarPadre(destino, padre);
        padre[padreOrigen] = padreDestino; // Unir los conjuntos asignando un mismo padre.
    }
}
