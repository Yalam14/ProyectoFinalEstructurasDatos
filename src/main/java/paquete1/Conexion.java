package paquete1;

/**
 * Clase que representa una conexión (arista) en un grafo.
 * Cada conexión tiene un nodo de origen, un nodo de destino y un peso asociado.
 * El peso generalmente representa la distancia entre los dos nodos.
 * 
 * Esta clase es utilizada en el contexto de algoritmos como Kruskal, donde
 * las conexiones deben ser comparadas para determinar las más económicas.
 */
public class Conexion implements Comparable<Conexion> {

    // Variables que definen la conexión
    int origen;   // Nodo de origen de la conexión
    int destino;  // Nodo de destino de la conexión
    int peso;     // Peso de la conexión (e.g., distancia en kilómetros)

    /**
     * Constructor de la clase Conexion.
     * Crea una conexión entre dos nodos con un peso asociado.
     *
     * @param origen  Índice del nodo de origen.
     * @param destino Índice del nodo de destino.
     * @param peso    Peso asociado a la conexión.
     */
    public Conexion(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * Método para comparar esta conexión con otra basada en el peso.
     * Esto es útil para algoritmos que requieren ordenar conexiones,
     * como el algoritmo de Kruskal.
     *
     * @param otra La conexión a comparar.
     * @return Un número negativo, cero o positivo si el peso de esta conexión
     *         es menor, igual o mayor que el peso de la conexión proporcionada.
     */
    @Override
    public int compareTo(Conexion otra) {
        return Integer.compare(this.peso, otra.peso);
    }
}