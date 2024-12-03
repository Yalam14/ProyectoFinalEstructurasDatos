/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete1;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import javax.swing.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class VisualizacionGrafo {

    public static void mostrarGrafo(SimpleWeightedGraph<String, DefaultWeightedEdge> grafo, String titulo) {
        mxGraph jgxGraph = new mxGraph();
        Object parent = jgxGraph.getDefaultParent();

        jgxGraph.getModel().beginUpdate();
        try {
            // Crear nodos con posiciones aleatorias
            java.util.Map<String, Object> nodoMap = new java.util.HashMap<>();
            int x = 50, y = 50;
            for (String vertice : grafo.vertexSet()) {
                nodoMap.put(vertice, jgxGraph.insertVertex(parent, null, vertice, x, y, 80, 30));
                x += 150;
                if (x > 700) {
                    x = 50;
                    y += 100;
                }
            }

            // Crear aristas
            for (DefaultWeightedEdge edge : grafo.edgeSet()) {
                String origen = grafo.getEdgeSource(edge);
                String destino = grafo.getEdgeTarget(edge);
                double peso = grafo.getEdgeWeight(edge);
                jgxGraph.insertEdge(parent, null, peso + " km", nodoMap.get(origen), nodoMap.get(destino));
            }
        } finally {
            jgxGraph.getModel().endUpdate();
        }

        // Mostrar grafo en la ventana
        mxGraphComponent graphComponent = new mxGraphComponent(jgxGraph);
        JFrame frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(graphComponent);
        frame.pack();
        frame.setVisible(true);
    }

    public static void mostrarGrafo(List<Conexion> conexiones, String[] nombresNodos, String titulo) {
        // Crear un grafo ponderado
        SimpleWeightedGraph<String, DefaultWeightedEdge> grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        // Agregar nodos al grafo
        for (String nodo : nombresNodos) {
            grafo.addVertex(nodo);
        }

        // Agregar aristas al grafo
        for (Conexion conexion : conexiones) {
            String origen = nombresNodos[conexion.origen];
            String destino = nombresNodos[conexion.destino];
            DefaultWeightedEdge edge = grafo.addEdge(origen, destino);
            if (edge != null) { // Evitar duplicados
                grafo.setEdgeWeight(edge, conexion.peso);
            }
        }

        // Llamar al método que acepta el grafo construido
        mostrarGrafo(grafo, titulo);
    }

}
