package algoritmo_estrella;

import java.util.LinkedList;

/**
 *
 * @author Suriel
 */
public class Algoritmo_Estrella {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Nodo matriz[][] = new Nodo[5][5];//Creamos una matriz tipo Nodo para representar el laberinto.
        //Asignamos los nodos a la matriz como espacios libres(o) primeramente y
        // le asignamos su posición x,y.
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=new Nodo('o');
                matriz[i][j].setX(i);
                matriz[i][j].setY(j);
            }
        }
        // Ahora solo cambiamos el tipo a los nodos de la matriz
        // que serán un muro(#), así como la entrada(I) y salida(S)
        // del laberinto.
        matriz[2][0].setTipo('I');        
        matriz[2][4].setTipo('S');        
        matriz[1][2].setTipo('#');        
        matriz[2][2].setTipo('#');        
        matriz[3][2].setTipo('#');
        // Creamos una instancia de la clase Estrella, la cual ejecutará
        // el algoritmo de búsqueda.
        // A dicha instancia la creamos con la matriz creada anteriormente
        // y el nodo de entrada y nodo de salida.
        Estrella estrella=new Estrella(matriz,matriz[2][0],matriz[2][4]);
        // Obtenemos el tiempo en que inicia el algoritmo.
        long inicio = System.currentTimeMillis();
        // Ejecución del algoritmo y obtención de la ruta en forma de lista.
        LinkedList<Nodo> ruta=estrella.busquedaEstrella();
        // Obtenemos el tiempo después de la ejecución del algoritmo.
        long fin = System.currentTimeMillis();
        // Impresión de la ruta obtenida.
        System.out.println("Ruta obtenida");
        System.out.print("("+ruta.getFirst().getX()+","+ruta.getFirst().getY()+")");
        for (int i = 1; i < ruta.size(); i++) {
            Nodo n=ruta.get(i);
            System.out.print("-("+n.getX()+","+n.getY()+")");
        }
        // Impresión del tiempo de ejecución del algoritmo.
        System.out.printf("\n\nTiempo de ejecución: %f\n",(double) ((fin - inicio)/1000));
    }
    
}