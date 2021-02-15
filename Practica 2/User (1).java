// PRACTICA 2 : GEOMETRIA
import java.util.*;

public class User {
   public static void main(String[] args){
       System.out.println("PRACTICA 2: GEOMETRIA. Hernández Rodríguez Armando Giovanni");
    
        // Instanciando 16 puntos
        Punto X1 = new Punto("X1", -3, -2);
        Punto X2 = new Punto("X2", -7, -5);
        Punto X3 = new Punto("X3", -4, -3);
        Punto X4 = new Punto("X4", -6, -7);
        Punto X5 = new Punto("X5", 10, 7);
        Punto X6 = new Punto("X6", 5, 3);
        Punto X7 = new Punto("X7", 3, 2);
        Punto X8 = new Punto("X8", 7, 4);
        Punto X9 = new Punto("X9", -9, 2);
        Punto X10 = new Punto("X10", -3, 8);
        Punto X11 = new Punto("X11", -7, 4);
        Punto X12 = new Punto("X12", -4, 6);
        Punto X13 = new Punto("X13", 4, -8);
        Punto X14 = new Punto("X14", 8, -4);
        Punto X15 = new Punto("X15", 5, -3);
        Punto X16 = new Punto("X16", 2, -6);
        
        System.out.println("-----------Punto---------");
        // Para la clase Punto se tienen 3 constructores
        System.out.println("\n-----Constructores Punto-----");
        Punto X17 = new Punto();
        Punto X18 = new Punto(2, 3);
        System.out.println(X16);
        System.out.println(X17);
        System.out.println(X18);
        
        System.out.println("\n-----Método distancia(sobrecargado)-----");
        // Distancia al origen
        System.out.println("Distancia de "+X1+ " al Origen  d = " +X1.distancia());
        // Distancia entre puntos
        System.out.println("Distancia de " + X1 + " a "+ X2+ "  d = "+ X2.distancia(X1));
        System.out.println("Distancia de " + X10 + " a "+ X12+ "  d = "+ X9.distancia(X10, X12));
        
        // Con los puntos establecidos se crean objetos de tipo Rectángulo asignando dos puntos por cada uno
        Rectangulo R1 = new Rectangulo("R1", X1, X2);
        Rectangulo R2 = new Rectangulo("R2", X3, X4);
        Rectangulo R3 = new Rectangulo("R3", X5, X6);
        Rectangulo R4 = new Rectangulo("R4", X7, X8);
        Rectangulo R5 = new Rectangulo("R5", X9, X10);
        Rectangulo R6 = new Rectangulo("R6", X11, X12);
        Rectangulo R7 = new Rectangulo("R7", X13, X14);
        Rectangulo R8 = new Rectangulo("R8", X15, X16);
        
        System.out.println("\n-----------Rectángulo----------");
        // Para la Clase Rectángulo se tienen 4 constructores
        System.out.println("\n-----Constructores Rectángulo-----");
        System.out.println(R2);
        Rectangulo R9 = new Rectangulo(R1);
        System.out.println(R9);
        Rectangulo R10 = new Rectangulo();
        System.out.println(R10);
        Rectangulo R11 = new Rectangulo("R11");
        System.out.println(R11);
        
        
        // Creamos un ArrayList de Rectangulos y los mostramos ordenados de menor a mayor de acuerdo con el area de cada uno
        
        ArrayList<Rectangulo> rectangulos = new ArrayList();
        rectangulos.add(R1);
        rectangulos.add(R2);
        rectangulos.add(R3);
        rectangulos.add(R4);
        rectangulos.add(R5);
        rectangulos.add(R6);
        rectangulos.add(R7);
        rectangulos.add(R8);
       
        System.out.println("\n-----Rectangulos sin ordenar-----");  
        for(Rectangulo R: rectangulos){
            R.setArea(); // Se establece el area de cada rectangulo
            R.setPerimetro(); // Se establece el perimetro de cada rectangulo
            System.out.print(R + "  Area = "+R.getArea()+ "  Perimetro =  "+R.getPerimetro()+"\n");
        }
        
        // Se hace uso de Collection.sort(Lista de elementos)
        Collections.sort(rectangulos);
        
        /* Ademas de establecer un ordenamiento de menor a mayor de acuerdo al área del rectángulo
           en el ArrayList, se devuelve el área, perímetro y cuadrante del rectángulo */
        System.out.println("\n-----Rectangulos ordenados de menor a mayor (de acuerdo al area)------");                                              
        for(Rectangulo R: rectangulos){
            System.out.print(R + "  Area = "+R.getArea()+ "  Perimetro =  "+R.getPerimetro()+"\n");
            R.cuadranteRect();
            System.out.println();
       }
        
        
       // El método union (que esta sobrecargado) devuelve un rectángulo que es la unión de dos rectángulos establecidos
       System.out.println("\n -----Método unión-----");
       Rectangulo U = new Rectangulo();
       U.union(R1, R2); System.out.println("Unión "+R1+" "+R2+" es "+U);
       U.union(R3, R4); System.out.println("Unión "+R3+" "+R4+" es "+U);
       U.union(R5, R6); System.out.println("Unión "+R5+" "+R6+" es "+U);
       U.union(R7, R8); System.out.println("Unión "+R7+" "+R8+" es "+U);
       
       // El método intersección (que esta sobrecargado) devuelve un rectángulo que se encuentra entre dos rectángulos establecidos
       System.out.println("\n -----Método intersección-----");
       Rectangulo I = new Rectangulo();
       I.interseccion(R1, R2); System.out.println("Interseccion "+R1+" "+R2+" es "+I);
       I.interseccion(R3, R4); System.out.println("Interseccion "+R3+" "+R4+" es "+I);
       I.interseccion(R5, R6); System.out.println("Interseccion "+R5+" "+R6+" es "+I);
       I.interseccion(R7, R8); System.out.println("Interseccion "+R7+" "+R8+" es "+I);
       //Cuando no hay interseccion devuelve un Rectangulo con puntos P1(0,0), P2(0,0)
       I.interseccion(R5, R3); System.out.println("No hay Interseccion en "+R5+" "+R3+" entonces "+I);
       
       
       // El metodo estaAdentro devuelve un true o false si un punto está adentro de un Rectángulo (incluyendo su contorno)
       System.out.println("\n -----Metodo estaAdentro-----");
       Punto Q1 = new Punto("Q1", 4, 6);
      
       if(R3.estaAdentro(Q1)){
           System.out.println("El punto "+Q1+" esta dentro de "+R3);
       }
       else System.out.println("El punto "+Q1+" NO esta dentro de "+R3);
        
       if(U.union(R3, R4).estaAdentro(Q1)){
           System.out.println("El punto "+Q1+" esta dentro de la union de R3 y R4  "+U);
       }
       else System.out.println("El punto "+Q1+" NO esta dentro de "+U);
       
      /* El metodo compareTo devuelve un 1 si el objeto que invoca el metodo es mayor al objeto que 
       esta como argumento, si no se cumple devuelve un -1 si el objeto que incovca el método es menor al objeto 
       que pasa como argumento, en caso contrario retorna un 0 que quiere decir que los dos objetos son iguales.
       Para este caso el método compareTo se basa en el área de los rectángulos.*/
       System.out.println("\n-----Metodo compareTo-----");
       int a = R3.compareTo(R4);
       if(a>0){
           System.out.println(R3 + " Area "+ R3.getArea()+ "  >  " + R4 + " Area "+ R4.getArea());
           System.out.println(R3.getName()+ " Es mayor");
       }else if(a<0){
           System.out.println(R3 + " Area "+ R3.getArea()+ "  <  " + R4 + " Area "+ R4.getArea());
           System.out.println(R3.getName()+ " Es menor");
       }else{
           System.out.println(R3 + " Area "+ R3.getArea()+ "  =  " + R4 + " Area "+ R4.getArea());
           System.out.println(R3.getName()+ " Es igual");
       }
       
        //Este método devuelve un Rectangulo que se mueve a dos puntos establecidos
       System.out.println("\n -----Metodo moverRect-----");
       System.out.println(R2 + " se mueve a " + X7 + X10);
       R2.moverRectangulo(X7, X10);
       System.out.println("Resultado: " + R2);
       // Movemos el rectangulo a su estado anterior
       R2.moverRectangulo(X3, X4);
       
       
       System.out.println("\n----------Triángulo---------");
        Punto J1 = new Punto("J1", 2, 2);
        Punto J2 = new Punto("J2", 12, 2);
        Punto J3 = new Punto("J3", 4, 8);
        Punto J4 = new Punto("J4", 4, 4);
        Punto J5 = new Punto("J5", 4, 6);
        Punto J6 = new Punto("J6", 8, 4);
        Punto J7 = new Punto("J7", 4, -2);
        Punto J8 = new Punto("J8", 2, -6);
        Punto J9 = new Punto("J9", 12, -8);
        Punto J10 = new Punto("J10", 2, -4);
        Punto J11 = new Punto("J11", 6, -4);
        Punto J12 = new Punto("J12", 8, -6);
        Punto J13 = new Punto("J13", -1, 1);
        Punto J14 = new Punto("J14", -8, 1);
        Punto J15 = new Punto("J15", -5, 3);
        Punto J16 = new Punto("J16", -2, -1);
        Punto J17 = new Punto("J17", -2, -3);
        Punto J18 = new Punto("J18", -5, -3);
        
        Triangulo T1 = new Triangulo ("T1", J1, J2, J3);
        Triangulo T2 =  new Triangulo("T2", J4, J5, J6);
        Triangulo T3 = new Triangulo("T3", J7, J8, J9);
        Triangulo T4 = new Triangulo("T4", J10, J11, J12);
        Triangulo T5 = new Triangulo("T5", J13, J14, J15);
        Triangulo T6 = new Triangulo("T6", J16, J17, J18);
        
        // Para la Clase Triángulo se tienen 3 constructores
        System.out.println("\n-----Constructores Triángulo-----");
        System.out.println(T4);
        Triangulo T7 = new Triangulo();
        System.out.println(T7);
        Triangulo T8 = new Triangulo("Triangulo 8");
        System.out.println(T8);
        
        ArrayList <Triangulo> triangulos = new ArrayList();
        triangulos.add(T1);
        triangulos.add(T2);
        triangulos.add(T3);
        triangulos.add(T4);
        triangulos.add(T5);
        triangulos.add(T6);
        
        System.out.println("\n-----Triangulos sin ordenar-----");  
        for(Triangulo T: triangulos){
            T.setArea(); // Se establece el area de cada rectangulo
            T.setPerimetro(); // Se establece el perimetro de cada rectangulo
            System.out.print(T + "  Area = "+T.getArea()+ "  Perimetro =  "+T.getPerimetro()+"\n");
        }
        // Se hace uso de Collection.sort(Lista de elementos)
        Collections.sort(triangulos);
        
        /* Ademas de establecer un ordenamiento de menor a mayor de acuerdo al área del triángulo
           en el ArrayList, se devuelve el área, perímetro y cuadrante del mismo */
        System.out.println("\n-----Triangulos ordenados de menor a mayor (de acuerdo al area)------");                                              
        for(Triangulo T: triangulos){
            System.out.print(T + "  Area = "+T.getArea()+ "  Perimetro =  "+T.getPerimetro()+"\n");
            T.cuadranteTri();
            System.out.println();
       }
       
        /* El método intersección (que esta sobrecargado) devuelve un triángulo que se encuentra entre dos triangulos establecidos
        NOTA: Solo se implemento el caso cuando un triangulo esta dentro de otro */
       System.out.println("\n -----Método intersección-----");
       Triangulo I1 = new Triangulo();
       System.out.println("Intersección "+T1+" "+T2+" es ");System.out.println(I1.interseccion(T1, T2)); // Si esta dentro de la intersección
       System.out.println("\nNo hay Intersección en "+T1+" "+T2+" entonces se devuelve ");System.out.println(I1.interseccion(T2, T3)); // No esta dentro de la interseccion y por tanto retorna null
       
       // El metodo estaAdentro devuelve un true o false si un punto está adentro de un Triángulo (incluyendo su contorno)
       System.out.println("\n -----Metodo estaAdentro-----");
      
       if(T3.estaAdentro(J10)){
           System.out.println("El punto "+J10+" esta dentro de "+T3);
       }
       else System.out.println("El punto "+J10+" NO esta dentro de "+T3);
        
       if(T2.estaAdentro(J4)){
           System.out.println("El punto "+J4+" esta dentro de "+T2);
       }
       else System.out.println("El punto "+J4+" NO esta dentro de "+T2);
       
       /* El metodo compareTo devuelve un 1 si el objeto que invoca el metodo es mayor al objeto que 
       esta como argumento, si no se cumple devuelve un -1 si el objeto que incovca el método es menor al objeto 
       que pasa como argumento, en caso contrario retorna un 0 que quiere decir que los dos objetos son iguales.
       Para este caso el método compareTo se basa en el área de los triángulos.*/
       System.out.println("\n-----Metodo compareTo-----");
       int b = T1.compareTo(T2);
       if(b>0){
           System.out.println(T1 + " Area "+ T1.getArea()+ "  >  " + T2 + " Area "+ T2.getArea());
           System.out.println(T1.getName()+ " Es mayor");
       }else if(b<0){
           System.out.println(T1 + " Area "+ T1.getArea()+ "  <  " + T2 + " Area "+ T2.getArea());
           System.out.println(T1.getName()+ " Es menor");
       }else{
           System.out.println(T1 + " Area "+ T1.getArea()+ "  =  " + T2 + " Area "+ T2.getArea());
           System.out.println(T1.getName()+ " Es igual");
       }
       
       //Este método devuelve un Triangulo que se mueve a tres puntos establecidos
       System.out.println("\n -----Metodo moverTriangulo-----");
       System.out.println(T2 + " se mueve a " + J7 + J1 + J12);
       T2.moverTriangulo(J7, J1, J12);
       System.out.println("Resultado: " + T2);
       // Movemos el triangulo a su estado anterior
       T2.moverTriangulo(J4, J5, J6);
       
       System.out.println("\n----- Metodo CompareTo: Triangulo - Rectangulo-----");
        ArrayList <Figura> figuras = new ArrayList();
        figuras.add(R1);
        figuras.add(R2);
        figuras.add(R3);
        figuras.add(R4);
        figuras.add(R5);
        figuras.add(R6);
        figuras.add(R7);
        figuras.add(R8);
        figuras.add(T1);
        figuras.add(T2);
        figuras.add(T3);
        figuras.add(T4);
        figuras.add(T5);
        figuras.add(T6);
         
        // Se hace uso de Collection.sort(Lista de elementos)
        Collections.sort(figuras);
     
        System.out.println("Figuras ordenadas de menor a mayor (de acuerdo al area)");                                              
        for(Figura F: figuras){
            System.out.print(F + "  Area = "+F.getArea()+ "  Perimetro =  "+F.getPerimetro()+"\n");
            System.out.println();
       }    
        
    } 
}
