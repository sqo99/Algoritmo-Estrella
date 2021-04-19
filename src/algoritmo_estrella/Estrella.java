package algoritmo_estrella;

import java.util.LinkedList;

/**
 *
 * @author Suriel
 */
/* Clase BFS, la cual ejecutará el algoritmo de búsqueda en anchura.
 * En ella tenemos como atributo a la matriz, el nodo de entrada y salida
 * y a la lista v donde cada nodo de dicha lista,
 * contiene a su vez una lista de adyacentes.*/
public class Estrella {
    private Nodo matriz[][];
    private Nodo entrada, salida;
    private LinkedList<Nodo> abiertos;
    private LinkedList<Nodo> cerrados;

    public Estrella(Nodo matriz[][], Nodo origen, Nodo destino) {
        this.matriz = matriz;
        this.entrada = origen;
        this.salida = destino;
        this.abiertos=new LinkedList();
        this.cerrados=new LinkedList();
    }

    public LinkedList<Nodo> getAbiertos() {
        return abiertos;
    }

    public LinkedList<Nodo> getCerrados() {
        return cerrados;
    }
    
    // Implementación del algoritmo estrella. 
    public void busquedaEstrella(){
        int i,j;
        int costoA=10;
        int costoD=14;
        int r=entrada.getX();
        int c=entrada.getY();
        abiertos.add(entrada);
        // Nos movemos hacia la esquina superior izquierda.
        i=r-1;
        j=c-1;
        // Comparamos que las variables i,j no se salgan fuera del rango de la matriz.
        if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
            // Comprobamos si el nodo en la posición i,j ha sido visitado y si es distinto de una pared.
            if(!abiertos.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                matriz[i][j].setP(matriz[r][c]);
                matriz[i][j].setG(costoD);
                matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                abiertos.add(matriz[i][j]);
            }
        }
        // Nos movemos hacia arriba.
        i=r-1;
        j=c;
        if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
            if(!abiertos.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                matriz[i][j].setP(matriz[r][c]);
                matriz[i][j].setG(costoA);
                matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                abiertos.add(matriz[i][j]);
            }
        }
        // Nos movemos hacia la esquina superior derecha.
        i=r-1;
        j=c+1;
        if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
            if(!abiertos.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                matriz[i][j].setP(matriz[r][c]);
                matriz[i][j].setG(costoD);
                matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                abiertos.add(matriz[i][j]);
            }
        }
        // Ahora nos movemos hacia la derecha.
        i=r;
        j=c+1;
        if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
            if(!abiertos.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                matriz[i][j].setP(matriz[r][c]);
                matriz[i][j].setG(costoA);
                matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                abiertos.add(matriz[i][j]);
            }
        }
        // Ahora nos movemos hacia la esquina inferior derecha.
        i=r+1;
        j=c+1;
        if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
            if(!abiertos.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                matriz[i][j].setP(matriz[r][c]);
                matriz[i][j].setG(costoD);
                matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                abiertos.add(matriz[i][j]);
            }
        }
        // Ahora hacia abajo.
        i=r+1;
        j=c;
        if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
            if(!abiertos.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                matriz[i][j].setP(matriz[r][c]);
                matriz[i][j].setG(costoA);
                matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                abiertos.add(matriz[i][j]);
            }
        }
        // Ahora nos movemos hacia la esquina inferior izquierda.
        i=r+1;
        j=c-1;
        if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
            if(!abiertos.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                matriz[i][j].setP(matriz[r][c]);
                matriz[i][j].setG(costoD);
                matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                abiertos.add(matriz[i][j]);
            }
        }
        // Ahora nos movemos hacia la izquierda.
        i=r;
        j=c-1;
        if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
            if(!abiertos.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                matriz[i][j].setP(matriz[r][c]);
                matriz[i][j].setG(costoA);
                matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                abiertos.add(matriz[i][j]);
            }
        }
    }
    
    public int distanciaManhattan(Nodo n1, Nodo n2){
        return (Math.abs(n1.getX()-n2.getX())+Math.abs(n1.getY()-n2.getY()))*10;
    }
    /*
    // Implementación del backtracking para obtener la ruta.
    public LinkedList<Nodo> backTracking(){
        // Creamos una lista (ruta) donde guardaremos la ruta obtenida.
        LinkedList<Nodo> ruta=new LinkedList();
        // Añadimos a la lista el último nodo adyacente en w, del último nodo
        // en la lista v, ya que en esa posición siempre quedará el nodo de salida.
        ruta.add(v.getLast().getW().getLast());
        // Ejecutamos un ciclo que recorrerá la lista v de fin a inicio.
        for (int i = v.size()-1; i > -1; i--) {
            // Verificamos si la lista de adyacente w en cada nodo v(i),
            // contiene al último nodo ingresado a la ruta.            
            if(v.get(i).getW().contains(ruta.getLast())){
                // Añadimos a la ruta el nodo v(i).
                ruta.add(v.get(i));
            }
        }
        // Retornamos la ruta obtenida.
        return ruta;
    }*/
    
}
