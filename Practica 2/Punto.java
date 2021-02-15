
public class Punto {
   private String name;
   private int x;
   private int y;
   
   public Punto(){
    this(0, 0);
   }
   
   public Punto(int x, int y){
       this.x = x;
       this.y = y;
       name = "P";
   }
   
   public Punto(String name, int x, int y){
       this.x = x;
       this.y = y;
       this.name = name;
   }

    public int getX() {
        return x;
    }

    public String getName() {
        return name;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setY(int y) {
        this.y = y;
    }
   
    public double distancia(){
        return redondear(Math.hypot(this.x, this.y), 4);
    }
    
    public double distancia(Punto P1){
        return redondear(Math.sqrt(Math.pow(((double)P1.x - (double)this.x), 2.0) + Math.pow(((double)P1.y - (double)this.y), 2.0)), 4);  
    }
    
    public double distancia(Punto P1, Punto P2){
        return redondear(Math.sqrt(Math.pow(((double)P1.x - (double)P2.x), 2.0) + Math.pow(((double)P1.y - (double)P2.y), 2.0)), 4);
    }
   
   @Override
    public String toString(){
        return name + "(" + x + "," + y + ")";
    }
    
    public void cuadrante(){
        if(x >=0 ){
            if(y >= 0){ System.out.println("Cuadrante I");}
            else{System.out.println("Cuadrante IV");}
        }
        else if(x <= 0){
            if(y >= 0){ System.out.println("Cuadrante II");}
            else{System.out.println("Cuadrante III");}
        }
    }
    
    public int cuadrantes(){
        if(x >=0 ){
            if(y >= 0){ return 1;}
            else{return 4;}
        }
        else{
            if(y >= 0){ return 2;}
            else{return 3;}
        }    
    }
    
    // Punto mas alejado con respecto al Origen
    public Punto masAlejado(Punto P){
        Math.max(x, P.x);
        Math.max(y, P.y);
        return this;
    }
    
    public Punto menosAlejado(Punto P){
        Math.min(x, P.x);
        Math.min(y, P.y);
        return this;            
    }
    
     // Que punto es el inferior izquierdo de un rectangulo
    public boolean esIzq(Punto P){
        return x < P.x;
    }
    
      public Punto derecho(Punto P1, Punto P2){
        if(P1.x > P2.x){
           x = P1.x;
           y = P1.y;
           this.name = P1.name;
           return this;
       }
        else{
           x = P2.x;
           y = P2.y;
           this.name = P2.name;
           return this;
        }
    }
    
    public Punto izquierdo(Punto P1, Punto P2){
       if(P1.x < P2.x){
           x = P1.x;
           y = P1.y;
           this.name = P1.name;
           return this;
       }
        else{
           x = P2.x;
           y = P2.y;
           this.name = P2.name;
           return this;
        }
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
}
    
