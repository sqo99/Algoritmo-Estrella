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
    
    // Implementación del algoritmo estrella. 
    public LinkedList<Nodo> busquedaEstrella(){
        int i,j;
        int costoA=10;
        int costoD=14;
        int r=entrada.getX();
        int c=entrada.getY();
        cerrados.add(matriz[r][c]);
        while(true){
            //abiertos.add(matriz[r][c]);
            // Nos movemos hacia la esquina superior izquierda.
            i=r-1;
            j=c-1;
            // Comparamos que las variables i,j no se salgan fuera del rango de la matriz.
            if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
                // Comprobamos si el nodo en la posición i,j ha sido visitado y si es distinto de una pared.
                if(!abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    matriz[i][j].setP(matriz[r][c]);
                    matriz[i][j].setG(costoD);
                    matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                    matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                    abiertos.add(matriz[i][j]);
                    if(matriz[i][j] == salida)
                        break;
                }else if(abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    int aux=matriz[i][j].getG()+costoD;
                    if(aux<matriz[i][j].getG()){
                        matriz[i][j].setG(aux);
                        matriz[i][j].setP(matriz[r][c]);
                    }
                }
            }
            // Nos movemos hacia arriba.
            i=r-1;
            j=c;
            if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
                // Comprobamos si el nodo en la posición i,j ha sido visitado y si es distinto de una pared.
                if(!abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    matriz[i][j].setP(matriz[r][c]);
                    matriz[i][j].setG(costoA);
                    matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                    matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                    abiertos.add(matriz[i][j]);
                    if(matriz[i][j] == salida)
                        break;
                }else if(abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    int aux=matriz[i][j].getG()+costoA;
                    if(aux<matriz[i][j].getG()){
                        matriz[i][j].setG(aux);
                        matriz[i][j].setP(matriz[r][c]);
                    }
                }
            }
            // Nos movemos hacia la esquina superior derecha.
            i=r-1;
            j=c+1;
            if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
                // Comprobamos si el nodo en la posición i,j ha sido visitado y si es distinto de una pared.
                if(!abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    matriz[i][j].setP(matriz[r][c]);
                    matriz[i][j].setG(costoD);
                    matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                    matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                    abiertos.add(matriz[i][j]);
                    if(matriz[i][j] == salida)
                        break;
                }else if(abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    int aux=matriz[i][j].getG()+costoD;
                    if(aux<matriz[i][j].getG()){
                        matriz[i][j].setG(aux);
                        matriz[i][j].setP(matriz[r][c]);
                    }
                }
            }
            // Ahora nos movemos hacia la derecha.
            i=r;
            j=c+1;
            if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
                // Comprobamos si el nodo en la posición i,j ha sido visitado y si es distinto de una pared.
                if(!abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    matriz[i][j].setP(matriz[r][c]);
                    matriz[i][j].setG(costoA);
                    matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                    matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                    abiertos.add(matriz[i][j]);
                    if(matriz[i][j] == salida)
                        break;
                }else if(abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    int aux=matriz[i][j].getG()+costoA;
                    if(aux<matriz[i][j].getG()){
                        matriz[i][j].setG(aux);
                        matriz[i][j].setP(matriz[r][c]);
                    }
                }
            }
            // Ahora nos movemos hacia la esquina inferior derecha.
            i=r+1;
            j=c+1;
            if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
                // Comprobamos si el nodo en la posición i,j ha sido visitado y si es distinto de una pared.
                if(!abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    matriz[i][j].setP(matriz[r][c]);
                    matriz[i][j].setG(costoD);
                    matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                    matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                    abiertos.add(matriz[i][j]);
                    if(matriz[i][j] == salida)
                        break;
                }else if(abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    int aux=matriz[i][j].getG()+costoD;
                    if(aux<matriz[i][j].getG()){
                        matriz[i][j].setG(aux);
                        matriz[i][j].setP(matriz[r][c]);
                    }
                }
            }
            // Ahora hacia abajo.
            i=r+1;
            j=c;
            if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
                // Comprobamos si el nodo en la posición i,j ha sido visitado y si es distinto de una pared.
                if(!abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    matriz[i][j].setP(matriz[r][c]);
                    matriz[i][j].setG(costoA);
                    matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                    matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                    abiertos.add(matriz[i][j]);
                    if(matriz[i][j] == salida)
                        break;
                }else if(abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    int aux=matriz[i][j].getG()+costoA;
                    if(aux<matriz[i][j].getG()){
                        matriz[i][j].setG(aux);
                        matriz[i][j].setP(matriz[r][c]);
                    }
                }
            }
            // Ahora nos movemos hacia la esquina inferior izquierda.
            i=r+1;
            j=c-1;
            if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
                // Comprobamos si el nodo en la posición i,j ha sido visitado y si es distinto de una pared.
                if(!abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    matriz[i][j].setP(matriz[r][c]);
                    matriz[i][j].setG(costoD);
                    matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                    matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                    abiertos.add(matriz[i][j]);
                    if(matriz[i][j] == salida)
                        break;
                }else if(abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    int aux=matriz[i][j].getG()+costoD;
                    if(aux<matriz[i][j].getG()){
                        matriz[i][j].setG(aux);
                        matriz[i][j].setP(matriz[r][c]);
                    }
                }
            }
            // Ahora nos movemos hacia la izquierda.
            i=r;
            j=c-1;
            if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
                // Comprobamos si el nodo en la posición i,j ha sido visitado y si es distinto de una pared.
                if(!abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    matriz[i][j].setP(matriz[r][c]);
                    matriz[i][j].setG(costoA);
                    matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                    matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                    abiertos.add(matriz[i][j]);
                    if(matriz[i][j] == salida)
                        break;
                }else if(abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    int aux=matriz[i][j].getG()+costoA;
                    if(aux<matriz[i][j].getG()){
                        matriz[i][j].setG(aux);
                        matriz[i][j].setP(matriz[r][c]);
                    }
                }
            }
            //abiertos.remove(matriz[r][c]);
            Nodo menor=buscarFmenor();
            cerrados.add(menor);
            abiertos.remove(menor);
            r=cerrados.getLast().getX();
            c=cerrados.getLast().getY();
            imprimirListas(r,c);
            imprimirMatriz();
            System.out.println("\n");
        }
        Nodo menor=buscarFmenor();
        cerrados.add(menor);
        abiertos.remove(menor);
        r=cerrados.getLast().getX();
        c=cerrados.getLast().getY();
        imprimirListas(r,c);
        imprimirMatriz();
        System.out.println("\n");
        return backTracking();
    }
    
    public int distanciaManhattan(Nodo n1, Nodo n2){
        return (Math.abs(n1.getX()-n2.getX())+Math.abs(n1.getY()-n2.getY()))*10;
    }
    
    public Nodo buscarFmenor(){
        Nodo menor=abiertos.getFirst();
        for (int i = 1; i < abiertos.size(); i++) {
            if(abiertos.get(i).getF() < menor.getF())
                menor=abiertos.get(i);
        }
        return menor;
    }
    
    // Implementación del backtracking para obtener la ruta.
    public LinkedList<Nodo> backTracking(){
        // Creamos una lista (ruta) donde guardaremos la ruta obtenida.
        LinkedList<Nodo> ruta=new LinkedList();
        // Añadimos a la lista el último nodo adyacente en w, del último nodo
        // en la lista v, ya que en esa posición siempre quedará el nodo de salida.
        ruta.add(cerrados.getLast());
        //ruta.add(cerrados.getLast().getP());
        // Ejecutamos un ciclo que recorrerá la lista v de fin a inicio.
        for (int i = cerrados.size()-1; i > 0; i--) {
            // Verificamos si la lista de adyacente w en cada nodo v(i),
            // contiene al último nodo ingresado a la ruta.            
            if(cerrados.get(i)==ruta.getLast()){
                // Añadimos a la ruta el nodo v(i).
                ruta.add(cerrados.get(i).getP());
            }
        }
        // Retornamos la ruta obtenida.
        return ruta;
    }
    
    public void imprimirListas(int r, int c){
        System.out.println("------------------------");
        System.out.println("Posición actual: ("+r+","+c+")");
        //System.out.println("Lista de abiertos");
        System.out.println("Abiertos\tP");
        for (int i = 0; i < abiertos.size(); i++) {
            Nodo n=abiertos.get(i);
            if(n.getP()!=null)
                System.out.println("("+n.getX()+","+n.getY()+")"+"\t\t("+n.getP().getX()+","+n.getP().getY()+")");
            else
                System.out.println("("+n.getX()+","+n.getY()+")");
        }
        //System.out.println("Lista de cerrados");
        System.out.println("Cerrados\tP");
        for (int i = 0; i < cerrados.size(); i++) {
            Nodo n=cerrados.get(i);
            if(n.getP()!=null)
                System.out.println("("+n.getX()+","+n.getY()+")"+"\t\t("+n.getP().getX()+","+n.getP().getY()+")");
            else
                System.out.println("("+n.getX()+","+n.getY()+")");
        }
    }
    
    public void imprimirMatriz(){
        System.out.println("Matriz después de recorrer los nodos adyacentes");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                Nodo n=matriz[i][j];
                System.out.print("("+n.getX()+","+n.getY()+")"+"|"+n.getTipo()+"|"+n.getG()+"|"+n.getH()+"|"+n.getF()+"\t");
            }
            System.out.println();
        }
    }
    
}
