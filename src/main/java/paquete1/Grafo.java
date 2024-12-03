/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un grafo no dirigido ponderado utilizando una lista de
 * aristas. Cada arista (conexión) tiene un nodo de origen, un nodo de destino y
 * un peso asociado (distancia en km).
 */
public class Grafo {

    int vertices; // Número total de vértices (nodos) en el grafo
    List<Conexion> conexiones; // Lista de conexiones (aristas) que forman el grafo

    /**
     * Constructor para inicializar el grafo con un número específico de
     * vértices.
     *
     * @param vertices Número total de nodos (localidades) en el grafo.
     */
    public Grafo(int vertices) {
        this.vertices = vertices;
        this.conexiones = new ArrayList<>(); // Inicializa la lista de conexiones como vacía
    }

    /**
     * Método para agregar una conexión (arista) al grafo.
     *
     * @param origen Índice del nodo de origen.
     * @param destino Índice del nodo de destino.
     * @param peso Peso (distancia) asociado a la conexión, en kilómetros.
     */
    public void agregarConexion(int origen, int destino, int peso) {
        conexiones.add(new Conexion(origen, destino, peso));
    }

    /**
     * Método para mostrar todas las conexiones del grafo en la consola. Las
     * conexiones se imprimen en forma de tabla que incluye los nodos de origen,
     * destino y el peso de cada conexión.
     */
    public void mostrarGrafo() {
        System.out.println("Representación del Grafo:");
        for (Conexion conexion : conexiones) {
            System.out.println("Origen: " + conexion.origen
                    + ", Destino: " + conexion.destino
                    + ", Peso: " + conexion.peso + " km");
        }
    }

}
