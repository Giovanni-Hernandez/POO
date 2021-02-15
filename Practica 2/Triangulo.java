public class Triangulo extends Figura{
    // La clase hija no puede tener un acceso más restingido, por esa razón los atributos son públicos
    public Punto A;
    public Punto B;
    public Punto C;
    
    public Triangulo(){
        super("Triangulo");
        A = new Punto(1, 1);
        B = new Punto(2, 1);
        C = new Punto(2, 2);
    }
    
    public Triangulo(String n) {
        super(n);
        A = new Punto(1, 1);
        B = new Punto(2, 1);
        C = new Punto(2, 2);
    }
    
    public Triangulo(String n, Punto P1, Punto P2, Punto P3) {
        super(n);
        A = new Punto(P1.getName(), P1.getX(), P1.getY());
        B = new Punto(P2.getName(), P2.getX(), P2.getY());
        C = new Punto(P3.getName(), P3.getX(), P3.getY());
    }
    
    @Override
    public String toString(){
        return name + "[" + A.getName() + "(" + A.getX() + "," + A.getY() + ")" + "," + B.getName() + "(" + B.getX() 
                + "," + B.getY() + ")" + "," + C.getName() + "(" + C.getX()+ "," + C.getY() + ")" + "]";
    }
    
    public double distanciaAB(){
        Punto D = new Punto();
        return redondear(D.distancia(A, B), 3);
    }
    
    public double distanciaBC(){
        Punto D = new Punto();
        return redondear(D.distancia(B, C), 3);
    }
    
    public double distanciaCA(){
        Punto D = new Punto();
        return redondear(D.distancia(C, A), 3); 
    }
    
    public double semiperimetro(){
        return redondear((this.distanciaAB() + this.distanciaBC() + this.distanciaCA())/2, 3);
    }
    
    public void setPerimetro(){
        this.perimetro = redondear(this.distanciaAB() + this.distanciaBC() + this.distanciaCA(), 3);
    }
    
    public void setArea(){
        this.area = redondear(Math.sqrt(this.semiperimetro()*(this.semiperimetro()-this.distanciaAB())*(this.semiperimetro()-this.distanciaBC())*(this.semiperimetro()-this.distanciaCA())), 3);
    }
    
     public double redondear(double numd, int decimales ){
        double partInt, resultado;
        resultado = numd;
        partInt = Math.floor(resultado);
        resultado = (resultado-partInt)*Math.pow(10, decimales);
        resultado = Math.round(resultado);
        resultado = (resultado/Math.pow(10, decimales))+partInt;
        return resultado;
    } 
     
     public boolean estaAdentro(Punto P){
         Triangulo T1 = new Triangulo("T1", A, B, P);
         Triangulo T2 = new Triangulo("T2", A, C, P);
         Triangulo T3 = new Triangulo("T3", C, B, P);
         T1.setArea();
         T2.setArea();
         T3.setArea();
         return ((this.area - redondear(T1.getArea()+T2.getArea()+T3.getArea(), 3) <= 0.1) && (this.area - redondear(T1.getArea()+T2.getArea()+T3.getArea(), 3) >= -0.1)) ;
     }
     
     public Triangulo moverTriangulo(Punto P1, Punto P2, Punto P3){
         A.setName(P1.getName());
         A.setX(P1.getX());
         A.setY(P1.getY());
         B.setName(P2.getName());
         B.setX(P2.getX());
         B.setY(P2.getY());
         C.setName(P3.getName());
         C.setX(P3.getX());
         C.setY(P3.getY());
         return this;
     }
    
     public void cuadranteTri(){
       if(A.cuadrantes() == B.cuadrantes() && A.cuadrantes()== C.cuadrantes() && B.cuadrantes()== C.cuadrantes()) {A.cuadrante();}
       else {System.out.println("Puntos en cuadrantes diferentes ");
           System.out.print(A.getName()+" "); A.cuadrante(); 
           System.out.print(B.getName()+" "); B.cuadrante(); 
           System.out.print(C.getName()+" ");C.cuadrante();}
    }
      // Si la interseccion no se cumple devuelve null, si se ha instanciado se devuelve un triangulo con puntos en 0
     public Triangulo interseccion(Triangulo T){
         if(T.estaAdentro(A) && T.estaAdentro(B) && T.estaAdentro(C)){return this;}
         else if( this.estaAdentro(T.A) && this.estaAdentro(T.B) && this.estaAdentro(T.C)){
            A = T.A;
            B = T.B;
            C = T.C;
            return this;}
         else {return null;}     
     }
     
     // Si la interseccion no se cumple devuelve null, si se ha instanciado se devuelve un triangulo con puntos en 0
     public Triangulo interseccion(Triangulo T1, Triangulo T2){
         name = "I";
         if(T2.estaAdentro(T1.A) && T2.estaAdentro(T1.B) && T2.estaAdentro(T1.C)){
             A = T1.A;
             B = T1.B;
             C = T1.C;
             return this;
         }else if(T1.estaAdentro(T2.A) && T1.estaAdentro(T2.B) && T1.estaAdentro(T2.C)){
            A = T2.A;
            B = T2.B;
            C = T2.C;
            return this;}
         else  {return null;}
     }

}
