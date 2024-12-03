package paquete1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Grafo grafo = new Grafo(20); 

        grafo.agregarConexion(0, 1, 65);    // León - Irapuato (Carretera Federal 45D)
        grafo.agregarConexion(0, 2, 55);    // León - Celaya (Carretera Federal 45D)
        grafo.agregarConexion(1, 3, 40);    // Irapuato - Salamanca (Carretera Federal 45)
        grafo.agregarConexion(2, 4, 70);    // Celaya - San Luis de la Paz (Carretera Federal 57)
        grafo.agregarConexion(3, 4, 50);    // Salamanca - San Luis de la Paz (Carretera Federal 43)
        grafo.agregarConexion(0, 5, 50);    // León - Guanajuato (Carretera Federal 110)
        grafo.agregarConexion(5, 6, 20);    // Guanajuato - Silao (Carretera Federal 45)
        grafo.agregarConexion(6, 1, 40);    // Silao - Irapuato (Carretera Federal 45D)
        grafo.agregarConexion(0, 7, 25);    // León - San Francisco del Rincón (Carretera Estatal 47)
        grafo.agregarConexion(7, 8, 5);     // San Francisco del Rincón - Purísima del Rincón (Carretera Estatal 47)
        grafo.agregarConexion(7, 6, 45);    // San Francisco del Rincón - Silao (Carretera Estatal 110)
        grafo.agregarConexion(0, 9, 70);    // León - Manuel Doblado (Carretera Estatal 45)
        grafo.agregarConexion(1, 3, 25);    // Irapuato - Salamanca (Carretera Federal 45)
        grafo.agregarConexion(3, 2, 40);    // Salamanca - Celaya (Carretera Federal 45)
        grafo.agregarConexion(10, 11, 35);  // San Miguel de Allende - Dolores Hidalgo (Carretera Estatal 110)
        grafo.agregarConexion(11, 5, 60);   // Dolores Hidalgo - Guanajuato (Carretera Estatal 110)
        grafo.agregarConexion(2, 12, 10);   // Celaya - Apaseo el Grande (Carretera Federal 45)
        grafo.agregarConexion(10, 13, 65);  // San Miguel de Allende - Querétaro (Carretera Federal 57D)
        grafo.agregarConexion(1, 14, 30);   // Irapuato - Abasolo (Carretera Estatal 77)
        grafo.agregarConexion(0, 15, 55);   // León - Lagos de Moreno (Jalisco) (Carretera Federal 80)
        grafo.agregarConexion(3, 16, 25);   // Salamanca - Valle de Santiago (Carretera Estatal 43)
        grafo.agregarConexion(3, 17, 15);   // Salamanca - Villagrán (Carretera Estatal 45)
        grafo.agregarConexion(17, 18, 20);  // Villagrán - Apaseo el Alto (Carretera Estatal 45)
        grafo.agregarConexion(4, 11, 45);   // San Luis de la Paz - Dolores Hidalgo (Carretera Estatal 110)
        grafo.agregarConexion(11, 19, 50);  // Dolores Hidalgo - San Felipe (Carretera Estatal 110)

        String[] nombresNodos = {
            "León", "Irapuato", "Celaya", "Salamanca", "San Luis de la Paz",
            "Guanajuato", "Silao", "San Francisco del Rincón", "Purísima del Rincón",
            "Manuel Doblado", "San Miguel de Allende", "Dolores Hidalgo", "Apaseo el Grande",
            "Querétaro", "Abasolo", "Lagos de Moreno", "Valle de Santiago", "Villagrán",
            "Apaseo el Alto", "San Felipe"
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
