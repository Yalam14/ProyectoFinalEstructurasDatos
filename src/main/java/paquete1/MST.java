/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MST {

    public List<Conexion> kruskalMST(Grafo grafo) {
        List<Conexion> mst = new ArrayList<>();

        // Ordenar las conexiones por peso (distancia más corta primero)
        Collections.sort(grafo.conexiones);

        // Inicializar los "padres" de cada vértice (para el algoritmo de conjuntos disjuntos)
        int[] padre = new int[grafo.vertices];
        for (int i = 0; i < grafo.vertices; i++) {
            padre[i] = i;
        }

        // Iterar sobre todas las conexiones ordenadas
        for (Conexion conexion : grafo.conexiones) {
            int padreOrigen = encontrarPadre(conexion.origen, padre);
            int padreDestino = encontrarPadre(conexion.destino, padre);

            // Si los nodos no están en el mismo conjunto, agregar al MST
            if (padreOrigen != padreDestino) {
                mst.add(conexion);
                unir(padreOrigen, padreDestino, padre); // Unir los conjuntos
            }
        }

        // Retornar el Árbol de Expansión Mínima
        return mst;
    }

    private int encontrarPadre(int vertice, int[] padre) {
        if (padre[vertice] != vertice) {
            padre[vertice] = encontrarPadre(padre[vertice], padre);
        }
        return padre[vertice];
    }

    private void unir(int origen, int destino, int[] padre) {
        int padreOrigen = encontrarPadre(origen, padre);
        int padreDestino = encontrarPadre(destino, padre);
        padre[padreOrigen] = padreDestino;
    }
}
