package algoritmo_estrella;

import java.util.LinkedList;

/**
 *
 * @author Suriel
 */
/* Clase Estrella, la cual ejecutará el algoritmo de búsqueda estrella.
 * En ella tenemos como atributo a la matriz, el nodo de entrada y salida.
 * Una lista de cerrados y una de abiertos.*/
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
        int i,j;// Variables i,j para el movimiento de los nodos adyacentes.
        int costoA=10;// Costo de movimientos arriba-abajo.
        int costoD=14;// Costo de movimientos en diagonal.
        // Variables r,c para llevar el control de la posición actual en la matriz.
        int r=entrada.getX();
        int c=entrada.getY();
        // Agregamos el nodo de entrada a la lista de cerrados.
        cerrados.add(entrada);
        // Imprimimos la matriz de entrada.
        System.out.println("Matriz de entrada");
        imprimirMatriz();
        // Ciclo que se ejecuta hasta que se rompe con break. Esto se da
        // cuando se llega al nodo de salida.
        while(true){
            // Nos movemos hacia la esquina superior izquierda.
            i=r-1;
            j=c-1;
            // Comparamos que las variables i,j no se salgan fuera del rango de la matriz.
            if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
                // Comprobamos si el nodo adyacente de la posición i,j se encuentra en la lista de abiertos
                // y de cerrados, y si es distinto de una pared.
                if(!abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    matriz[i][j].setP(matriz[r][c]);// Asignamos el nodo padre al nodo adyacente que se está analizando.
                    matriz[i][j].setG(costoD);// Asignamos G al nodo adyacente.
                    // Calculamos y asignamos la distancia manjattan al nodo adyacente.
                    matriz[i][j].setH(distanciaManhattan(matriz[i][j], salida));
                    // Asignamos F al nodo adyacente.
                    matriz[i][j].setF(matriz[i][j].getG()+matriz[i][j].getH());
                    // Añadimos el nodo adyacente i,j a la lista de abiertos.
                    abiertos.add(matriz[i][j]);
                    // Si el nodo adyacente i,j es igual al nodo de salida, rompemos el ciclo con break.
                    if(matriz[i][j] == salida)
                        break;
                // Comprobamos si el nodo i,j se encuentra en la lista de abiertos pero no en la de cerrados,
                // de igual forma comprobamos que no sea un muro.
                }else if(abiertos.contains(matriz[i][j]) && !cerrados.contains(matriz[i][j]) && matriz[i][j].getTipo()!='#'){
                    // Si es así, se procederá a evaluar si el valor en G del vecino es mejor.
                    int aux=matriz[i][j].getG()+costoD;
                    // Evaluamos si el valor G del vecino es mejor.
                    if(aux<matriz[i][j].getG()){
                        // Si es así, actualizamos el valor G del vecino y actualizamos el padre.
                        matriz[i][j].setG(aux);
                        matriz[i][j].setP(matriz[r][c]);
                    }
                }
            }
            // Nos movemos hacia arriba.
            i=r-1;
            j=c;
            if((i>-1 && i<matriz.length) && (j>-1 && j<matriz[0].length)){
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
            Nodo menor=buscarFmenor();// Se busca el nodo con valor menor en F.
            cerrados.add(menor);// Se asigna el menor a la lista de cerrados.
            abiertos.remove(menor);// Se eliminar el menor de la lista de abiertos.
            // Se obtiene la posición del último nodo ingresado en la lista de cerrados.
            r=cerrados.getLast().getX();
            c=cerrados.getLast().getY();
            // Imprimimos la lista de cerrados y abiertos y la posición actual.
            imprimirListas(r,c);
            // Imprimimos la matriz en cada iteración.
            System.out.println("Matriz después de recorrer los nodos adyacentes");
            imprimirMatriz();
        }
        Nodo menor=buscarFmenor();
        cerrados.add(menor);
        abiertos.remove(menor);
        r=cerrados.getLast().getX();
        c=cerrados.getLast().getY();
        imprimirListas(r,c);
        System.out.println("Matriz después de recorrer los nodos adyacentes");
        imprimirMatriz();        
        return backTracking();// Ejecutamos y retornamos la ruta obtenida por el backtracking.
    }
    
    // Función para obtener la distancia Manhattan.
    public int distanciaManhattan(Nodo n1, Nodo n2){
        return (Math.abs(n1.getX()-n2.getX())+Math.abs(n1.getY()-n2.getY()))*10;
    }
    
    // Función para buscar el nodo con el valor menor en F.
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
        // Añadimos a la lista el último nodo de la lista de cerrados.
        ruta.add(cerrados.getLast());
        // Ejecutamos un ciclo que recorrerá la lista de cerrados de fin a inicio.
        for (int i = cerrados.size()-1; i > 0; i--) {
            // Verificamos si el ultimo nodo de la ruta es igual al nodo de la
            // lista de cerrados en la posición i.
            if(cerrados.get(i)==ruta.getLast()){
                // Añadimos a la ruta, el nodo padre de la lista de cerrados en la posición i.
                ruta.add(cerrados.get(i).getP());
            }
        }
        // Retornamos la ruta obtenida.
        return ruta;
    }
    
    // Función para imprimir las listas de cerrados y abiertos, así como la posición actual.
    public void imprimirListas(int r, int c){
        System.out.println("------------------------");
        System.out.println("Posición actual: ("+r+","+c+")");
        System.out.println("Abiertos\tP");
        for (int i = 0; i < abiertos.size(); i++) {
            Nodo n=abiertos.get(i);
            if(n.getP()!=null)
                System.out.println("("+n.getX()+","+n.getY()+")"+"\t\t("+n.getP().getX()+","+n.getP().getY()+")");
            else
                System.out.println("("+n.getX()+","+n.getY()+")");
        }
        System.out.println("Cerrados\tP");
        for (int i = 0; i < cerrados.size(); i++) {
            Nodo n=cerrados.get(i);
            if(n.getP()!=null)
                System.out.println("("+n.getX()+","+n.getY()+")"+"\t\t("+n.getP().getX()+","+n.getP().getY()+")");
            else
                System.out.println("("+n.getX()+","+n.getY()+")");
        }
    }
    
    // Función que da formato para la impresión de la matriz.
    public void imprimirMatriz(){
        for (int i = 0; i < matriz.length; i++) {
            int tam=matriz[i].length;
            for (int j = 0; j < tam; j++) {
                Nodo n=matriz[i][j];
                String aux="("+n.getX()+","+n.getY()+")";
                aux=String.format("%5s", aux);
                System.out.print(" "+aux+" ");
                if(j<tam-1)
                    System.out.print("|");
            }
            System.out.println("");
            for (int j = 0; j < tam; j++) {
                Nodo n=matriz[i][j];
                System.out.print("   "+n.getTipo()+"  ");
                if(j<tam-1)
                    System.out.print(" |");
            }
            System.out.println("");
            for (int j = 0; j < tam; j++) {
                Nodo n=matriz[i][j];
                String aux=n.getG()+"";
                aux=String.format("%2s", aux);
                System.out.print("  "+aux+"   ");
                if(j<tam-1)
                    System.out.print("|");
            }
            System.out.println("");
            for (int j = 0; j < tam; j++) {
                Nodo n=matriz[i][j];
                String aux=n.getH()+"";
                aux=String.format("%2s", aux);
                System.out.print("  "+aux+"   ");
                if(j<tam-1)
                    System.out.print("|");
            }
            System.out.println("");
            for (int j = 0; j < tam; j++) {
                Nodo n=matriz[i][j];
                String aux=n.getF()+"";
                aux=String.format("%2s", aux);
                System.out.print("  "+aux+"   ");
                if(j<tam-1)
                    System.out.print("|");
            }
            System.out.println("");
            if(i<matriz.length-1){
                for (int j = 0; j < tam; j++) {
                    System.out.print("--------");
                }
            }
            System.out.println();
        }
    }
    
}
