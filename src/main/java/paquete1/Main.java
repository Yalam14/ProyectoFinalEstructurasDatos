package paquete1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Grafo grafo = new Grafo(5); // 5 localidades principales

        // Agregar conexiones entre localidades basadas en carreteras y distancias
        grafo.agregarConexion(0, 1, 65);    // León - Irapuato
        grafo.agregarConexion(0, 2, 55);    // León - Celaya
        grafo.agregarConexion(1, 3, 40);    // Irapuato - Salamanca
        grafo.agregarConexion(2, 4, 70);    // Celaya - San Luis de la Paz
        grafo.agregarConexion(3, 4, 50);    // Salamanca - San Luis de la Paz

        String[] nombresNodos = {
                "León", "Irapuato", "Celaya", "Salamanca", "San Luis de la Paz"
        };

        Scanner scanner = new Scanner(System.in);
        MST mstCalculador = new MST();
        ShortestPath spCalculador = new ShortestPath();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar Grafo (Gráfica)");
            System.out.println("2. Mostrar Árbol de Expansión Mínima (Gráfica)");
            System.out.println("3. Mostrar Ruta más Corta (Texto)");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    // Mostrar el grafo gráficamente
                    VisualizacionGrafo.mostrarGrafo(grafo.conexiones, nombresNodos, "Grafo Completo");
                    break;

                case 2:
                    // Mostrar el MST gráficamente
                    List<Conexion> mst = mstCalculador.kruskalMST(grafo);
                    VisualizacionGrafo.mostrarGrafo(mst, nombresNodos, "Árbol de Expansión Mínima");
                    break;

                case 3:
                    // Calcular la ruta más corta
                    System.out.println("Introduce origen y destino (índices):");
                    System.out.println("0: León, 1: Irapuato, 2: Celaya, 3: Salamanca, 4: San Luis de la Paz");
                    int origen = scanner.nextInt();
                    int destino = scanner.nextInt();
                    int[][] matrizAdyacencia = new int[grafo.vertices][grafo.vertices];
                    for (Conexion conexion : grafo.conexiones) {
                        matrizAdyacencia[conexion.origen][conexion.destino] = conexion.peso;
                        matrizAdyacencia[conexion.destino][conexion.origen] = conexion.peso;
                    }
                    spCalculador.dijkstra(matrizAdyacencia, origen, destino);
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
