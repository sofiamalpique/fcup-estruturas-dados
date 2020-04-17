class Point {
    public static void main(String[] args) {

    }
    private int x=2, y=3; // Coordenadas do ponto

    // Construtor de um ponto
    Point(int x0, int y0) {
	x = x0;
	y = y0;
    }


    // Getters
    int getX() { return x; }
    int getY() { return y; }
   
    // Devolve uma representação em texto do conteúdo de um ponto
    public String toString() {
	return "(" + x + "," + y + ")";
    }

}