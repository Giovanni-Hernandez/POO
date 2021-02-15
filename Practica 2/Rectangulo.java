// Rectangulo hereda de Figura e implementa la interfaz Comparable<T>, debido a que es una clase abstracta
// se debe implementar su método compareTo
public class Rectangulo extends Figura{
    // La clase hija no puede tener un acceso más restingido, por esa razón los atributos son públicos
    public Punto A;
    public Punto B;
    
    public Rectangulo(){
        // Invocamos al constructor de la superclase o clase padre Figura
        super("Rectangulo");
        // Continuamos con la construcción del objeto de la clase Rectángulo
        A = new Punto("P1", 1, 1);
        B = new Punto("P2", 2, 2);
    }
    
    public Rectangulo(String name){
        super(name);
        A = new Punto("P1", 1, 1);
        B = new Punto("P2", 2, 2);
    }
    
    public Rectangulo(String name, Punto P1, Punto P2){
        super(name);
        A = new Punto(P1.getName(), P1.getX(), P1.getY());
        B = new Punto(P2.getName(), P2.getX(), P2.getY());
    }
    
    public Rectangulo(Rectangulo R){
        super(R.name);
        A = R.A;
        B = R.B;
    }
    
    @Override
    public String toString(){
        return this.name + "[" + A.getName() + "(" + A.getX() + "," + A.getY() + ")" + "," + B.getName() + "(" + B.getX() + "," + B.getY() + ")" + "]";
    }
    
    public double alto(){
        double alto;
        alto = Math.abs((double)(A.getY()-B.getY()));
        return alto;
    }
    
    public double ancho(){
        double ancho;
        ancho = Math.abs((double)(A.getX()-B.getX()));
        return ancho;
    }
    
    @Override
    public String getName(){
        return this.name;
    }
    
    public void setArea(){
        // También se puede usar super.area
        this.area = this.alto() * this.ancho();
    }
    
    public void setPerimetro(){
        this.perimetro = 2 * (this.alto() + this.ancho());
    }
    
    public Rectangulo union(Rectangulo R){
       if(!A.esIzq(B)){
           if(!R.A.esIzq(R.B)){
               A.setX(Math.max(A.getX(), R.A.getX()));
               A.setY(Math.max(A.getY(), R.A.getY()));
               B.setX(Math.min(B.getX(), R.B.getX()));
               B.setY(Math.min(B.getY(), R.B.getY()));
           }else{
               A.setX(Math.max(A.getX(), R.B.getX()));
               A.setY(Math.max(A.getY(), R.B.getY()));
               B.setX(Math.min(B.getX(), R.A.getX()));
               B.setY(Math.min(B.getY(), R.A.getY()));
           }
       }
       else if(!B.esIzq(A)){
           if(!R.B.esIzq(R.A)){
               B.setX(Math.max(B.getX(), R.B.getX()));
               B.setY(Math.max(B.getY(), R.B.getY()));
               A.setX(Math.min(A.getX(), R.A.getX()));
               A.setY(Math.min(A.getY(), R.A.getY()));
           }else{
               B.setX(Math.max(B.getX(), R.A.getX()));
               B.setY(Math.max(B.getY(), R.A.getY()));
               A.setX(Math.min(A.getX(), R.B.getX()));
               A.setY(Math.min(A.getY(), R.B.getY()));
           }
       }return this;   
    }
    
    public Rectangulo union(Rectangulo R1, Rectangulo R2){
       name = "U";
       if(!R1.A.esIzq(R1.B)){
           if(!R2.A.esIzq(R2.B)){
               A.setX(Math.max(R1.A.getX(), R2.A.getX()));
               A.setY(Math.max(R1.A.getY(), R2.A.getY()));
               B.setX(Math.min(R1.B.getX(), R2.B.getX()));
               B.setY(Math.min(R1.B.getY(), R2.B.getY()));
           }else{
               A.setX(Math.max(R1.A.getX(), R2.B.getX()));
               A.setY(Math.max(R1.A.getY(), R2.B.getY()));
               B.setX(Math.min(R1.B.getX(), R2.A.getX()));
               B.setY(Math.min(R1.B.getY(), R2.A.getY()));
           }
       }
       else if(!R1.B.esIzq(R1.A)){
           if(!R2.B.esIzq(R2.A)){
               B.setX(Math.max(R1.B.getX(), R2.B.getX()));
               B.setY(Math.max(R1.B.getY(), R2.B.getY()));
               A.setX(Math.min(R1.A.getX(), R2.A.getX()));
               A.setY(Math.min(R1.A.getY(), R2.A.getY()));
           }else{
               B.setX(Math.max(R1.B.getX(), R2.A.getX()));
               B.setY(Math.max(R1.B.getY(), R2.A.getY()));
               A.setX(Math.min(R1.A.getX(), R2.B.getX()));
               A.setY(Math.min(R1.A.getY(), R2.B.getY()));
           }
       }return this;   
    }
    
    public boolean estaAdentro(Punto P){
        return (Math.min(A.getX(), B.getX())<= P.getX()) && (Math.max(A.getX(), B.getX())>= P.getX()) && (P.getY()>= Math.min(A.getY(), B.getY())) && (P.getY()<= Math.max(A.getY(), B.getY()));
    }
    
     public boolean estaAdentro(Rectangulo R){
        return (this.estaAdentro(R.A) && this.estaAdentro(R.B));
    }

    public Rectangulo interseccion(Rectangulo R){
        if(A.esIzq(B)){
            if(R.A.esIzq(R.B)){
            A.setX(Math.max(A.getX(), R.A.getX()));
            A.setY(Math.max(A.getY(), R.A.getY()));
            B.setX(Math.min(B.getX(), R.B.getX()));
            B.setY(Math.min(B.getY(), R.B.getY()));
            }
            else{
            A.setX(Math.max(A.getX(), R.B.getX()));
            A.setY(Math.max(A.getY(), R.B.getY()));
            B.setX(Math.min(B.getX(), R.A.getX()));
            B.setY(Math.min(B.getY(), R.A.getY()));
            }
        }else{
            if(R.B.esIzq(R.A)){
            B.setX(Math.max(B.getX(), R.B.getX()));
            B.setY(Math.max(B.getY(), R.B.getY()));
            A.setX(Math.min(A.getX(), R.A.getX()));
            A.setY(Math.min(A.getY(), R.A.getY()));
            }
            else{
            B.setX(Math.max(B.getX(), R.A.getX()));
            B.setY(Math.max(B.getY(), R.A.getY()));
            A.setX(Math.min(A.getX(), R.B.getX()));
            A.setY(Math.min(A.getY(), R.B.getY()));
            }
        }return this;
    }
    public Rectangulo interseccion(Rectangulo R1, Rectangulo R2){
        name = "I";
        if(R1.A.esIzq(R1.B)){
            if(R2.A.esIzq(R2.B)){
            A.setX(Math.max(R1.A.getX(), R2.A.getX()));
            A.setY(Math.max(R1.A.getY(), R2.A.getY()));
            B.setX(Math.min(R1.B.getX(), R2.B.getX()));
            B.setY(Math.min(R1.B.getY(), R2.B.getY()));
                if(R1.estaAdentro(this) && R2.estaAdentro(this) ){return this;}
                else {return this.clear();}
            }            
            else{
            A.setX(Math.max(R1.A.getX(), R2.B.getX()));
            A.setY(Math.max(R1.A.getY(), R2.B.getY()));
            B.setX(Math.min(R1.B.getX(), R2.A.getX()));
            B.setY(Math.min(R1.B.getY(), R2.A.getY()));
                if(R1.estaAdentro(this) && R2.estaAdentro(this) ){return this;}
                else {return this.clear();}     
            }
        }else{
            if(R2.B.esIzq(R2.A)){
            B.setX(Math.max(R1.B.getX(), R2.B.getX()));
            B.setY(Math.max(R1.B.getY(), R2.B.getY()));
            A.setX(Math.min(R1.A.getX(), R2.A.getX()));
            A.setY(Math.min(R1.A.getY(), R2.A.getY()));
                if(R1.estaAdentro(this) && R2.estaAdentro(this) ){return this;}
                else {return this.clear();}
            }
            else{
            B.setX(Math.max(R1.B.getX(), R2.A.getX()));
            B.setY(Math.max(R1.B.getY(), R2.A.getY()));
            A.setX(Math.min(R1.A.getX(), R2.B.getX()));
            A.setY(Math.min(R1.A.getY(), R2.B.getY()));
                if(R1.estaAdentro(this) && R2.estaAdentro(this) ){return this;}
                else {return this.clear();}
            }
        }
    }
    
    public Rectangulo clear(){
        A.setX(0);
        A.setY(0);
        B.setX(0);
        B.setY(0);
        return this;
    }
    
    public Rectangulo moverRectangulo(Punto P1, Punto P2){
        A.setX(P1.getX());
        A.setY(P1.getY());
        B.setX(P2.getX());
        B.setY(P2.getY());
        A.setName(P1.getName());
        B.setName(P2.getName());
        return this;
    }
    
    public void cuadranteRect(){
       if(A.cuadrantes() == B.cuadrantes()) {A.cuadrante();}
       else {System.out.println("Puntos en cuadrantes diferentes ");
       System.out.print(A.getName()+" ");A.cuadrante(); 
       System.out.println(B.getName()+" ");B.cuadrante();}
    }
}
