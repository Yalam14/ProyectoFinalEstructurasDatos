/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1;

public class Conexion implements Comparable<Conexion> {
    int origen, destino, peso;

    public Conexion(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public int compareTo(Conexion otra) {
        return Integer.compare(this.peso, otra.peso); // Ordenar por distancia
    }
}
