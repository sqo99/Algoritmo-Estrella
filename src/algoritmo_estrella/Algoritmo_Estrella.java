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
        // que serán un muro(), así como la entrada(I) y salida(S)
        // del laberinto.
        matriz[2][0].setTipo('I');        
        matriz[2][4].setTipo('S');        
        matriz[1][2].setTipo('#');        
        matriz[2][2].setTipo('#');        
        matriz[3][2].setTipo('#');
        // Imprimimos la matriz de entrada.
        System.out.println("Matriz de entrada\nPosición|Tipo|G|H|F");
        imprimirMatriz(matriz);
        System.out.println("");
        Estrella estrella=new Estrella(matriz,matriz[2][0],matriz[2][4]);
        estrella.busquedaEstrella();
    }
    
    public static void imprimirMatriz(Nodo matriz[][]){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Nodo n=matriz[i][j];
                System.out.print("("+n.getX()+","+n.getY()+")"+"|"+n.getTipo()+"|"+n.getG()+"|"+n.getH()+"|"+n.getF()+"\t");
            }
            System.out.println();
        }
    }    
    
}
