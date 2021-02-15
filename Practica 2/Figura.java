/* Se implementa la interfaz Comparable que nos permitirá hacer un ordenamiento natural.
   Debido a que el metodo compareTo de Comparable es abstracto se implementará en la clase padre Figura y que esta pueda
   heredar a las clases hijas Rectangulo y Triangulo*/
public class Figura  implements Comparable<Figura>{
    // protected: La clase padre o hijas pueden acceder o modificar los atributos
    protected String name;
    protected double area;
    protected double perimetro;
    
    public Figura(String n){
        name = n;
    }
    
    public String getName(){
        return name;
    }
    
    public double getArea(){
        return area;
    }
    
    public double getPerimetro(){
        return perimetro;
    }
    
    public void info(){
        System.out.println("Figura: " + this.getName());
        System.out.println("Area: " + this.getArea());
        System.out.println("Perimetro: "+ this.getPerimetro());
    }
    
     public boolean esMayorQue(Figura F2){
        return this.area > F2.area;
    }
    
    public boolean esMenorQue(Figura F2){
        return this.area < F2.area;
    }
    
     public boolean esIgualQue(Figura F2){
        return this.area == F2.area;
    }
    
     // Definición del método compareTo de la interfaz Comparable
    @Override
     public int compareTo(Figura F){
         if(this.esMenorQue(F)){
             return -1;
         }else if(this.esMayorQue(F)){
             return 1;
         }else{return 0;}
     }
}
