package algoritmo_estrella;

/**
 *
 * @author Suriel
 */
/* Clase Nodo, cada nodo tiene un tipo: muro(#), espacio libre(o), entrada(I), salida(S).
 * Un atributo tipo entero para G(distancia hacia el punto de inicio), H(distancia Manhattan).
 * y F(G+H)
 * Sus coordenadas x, y.
 * Y su nodo padre P.*/
public class Nodo {
    private char tipo;
    private int x;
    private int y;
    private int F;
    private int G;
    private int H;
    private Nodo P;

    public Nodo(char tipo) {
        this.tipo = tipo;
    } 

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getF() {
        return F;
    }

    public void setF(int F) {
        this.F = F;
    }

    public int getG() {
        return G;
    }

    public void setG(int G) {
        this.G = G;
    }

    public int getH() {
        return H;
    }

    public void setH(int H) {
        this.H = H;
    }

    public Nodo getP() {
        return P;
    }

    public void setP(Nodo p) {
        this.P = p;
    }
    
}
