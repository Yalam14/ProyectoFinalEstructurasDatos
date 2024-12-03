/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    int vertices;
    List<Conexion> conexiones;

    public Grafo(int vertices) {
        this.vertices = vertices;
        conexiones = new ArrayList<>();
    }

    public void agregarConexion(int origen, int destino, int peso) {
        conexiones.add(new Conexion(origen, destino, peso));
    }

    public void mostrarGrafo() {
        System.out.println("Representación del Grafo:");
        for (Conexion conexion : conexiones) {
            System.out.println("Origen: " + conexion.origen + 
                               ", Destino: " + conexion.destino + 
                               ", Peso: " + conexion.peso + " km");
        }
    }
}