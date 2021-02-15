import java.util.*;
import javax.swing.JOptionPane;

public class UsoRacional {
   
    public static void sumar(){
        Racional R1 = new Racional(0,0);
        
        ArrayList<Racional> grupo1 = askManyRacionales( "Suma de racionales" , " + " );
        
	System.out.println("El arreglo de numeros a sumar :");
        for(Racional var: grupo1)
            var.imprimir();
        
         for(int i=0; i<grupo1.size(); i++){
           R1.sum(grupo1.get(i));
         }
         
        System.out.println("El resultado es:");
        R1.imprimir();
        System.out.println("Racional reducido:");
        R1.reducir();
        R1.imprimir();
        System.out.println("\n---Operacion finalizada exitosamente---\n");
    }
     
    public static void restar(){
        Racional R1 = new Racional(0,0);
      
        ArrayList<Racional> grupo1 = askManyRacionales( "Resta de racionales" , " - " );
	R1 = grupo1.get(0);
        
        System.out.println("El arreglo de numeros a restar :");
        for(Racional var: grupo1)
            var.imprimir();
        
	for( int i=1; i<grupo1.size(); i++){
		R1 = Racional.res( R1, grupo1.get(i) );
	}
        
        System.out.println("El resultado es:");
        R1.imprimir();
        System.out.println("\n---Operacion finalizada exitosamente---\n");
    }
     
    public static void multiplicar(){
        Racional R1 = new Racional(1,1);
        
        ArrayList<Racional> grupo1 = askManyRacionales( "Multiplicación de racionales" , " × " );
        
        System.out.println("El arreglo de racionales a multiplicar :");
        for(Racional var: grupo1)
            var.imprimir();
        
         for(int i=0; i<grupo1.size(); i++){
           R1.mult( grupo1.get(i) );
         }
         
        System.out.println("El resultado es:");
        R1.imprimir();
        System.out.println("Racional reducido:");
        R1.reducir();
        R1.imprimir();
        System.out.println("\n---Operacion finalizada exitosamente---\n");
    }
     
    public static void dividir(){
        Racional R1 = new Racional(1,1);

        ArrayList<Racional> grupo1 = askManyRacionales( "División de racionales" , " ÷ " );
	R1 = grupo1.get(0);
        
        System.out.println("El arreglo de numeros a dividir :");
        for(Racional var: grupo1)
            var.imprimir();
        
	for( int i=1; i<grupo1.size(); i++){
		R1 = Racional.div( R1, grupo1.get(i) );
	}         
        System.out.println("El resultado es:");
        R1.imprimir();
        System.out.println("Racional reducido:");
        R1.reducir();
        R1.imprimir();
        System.out.println("\n---Operacion finalizada exitosamente---\n");

    }
        
     public static void aleatorio(){
	     Racional R1 = new Racional();
	     Racional R2 = new Racional();
	     Racional R3 = null;
	     Racional R4 = null;
	     boolean b1, b2;

            int operacion = (int)(Math.random()*4+1);
	
	     R1.aleatorio();
	     R2.aleatorio();

	     String msg="", simbol="";
	     switch( operacion ){
		case 1: msg="Suma"; 		simbol=" + ";	R4 = Racional.sum(R1,R2);	break;
		case 2: msg="Resta"; 		simbol=" - ";	R4 = Racional.res(R1,R2);	break;
		case 3: msg="Multiplicación";	simbol=" × ";	R4 = Racional.mult(R1,R2);	break;
		case 4: msg="División"; 	simbol=" ÷ ";	R4 = Racional.div(R1,R2);	break;
	     }
	     msg += " de Racionales:\n" + R1.toString() + simbol + R2.toString() + "\n";
	     R3 = askRacional( msg + "Introduzca su respuesta:" );
	     
	     b1 = R3.equals(R4);
	     b2 = R3.equals( Racional.s_reducir(R4) );
	     
	     if(b1==true){JOptionPane.showMessageDialog(null, "Bien contestado, la fraccion se puede reducir"); }
	     else if(b2==true){JOptionPane.showMessageDialog(null, "¡Excelente!");}
	     else{ JOptionPane.showMessageDialog(null, msg + " ≠ " + R3.toString() + "\nIncorrecto, vuelve a intentar\nLa respuest era: " + Racional.s_reducir( R4 ).toString() + "\nO reducido: " + R4.toString() );}
    }
    
    public static void main(String[] args){
        int opc =0; 

        JOptionPane.showMessageDialog(null, "¡Bienvenido al programa Calculadora de números Racionales!\nAlumnos:\n\tCortés Piña Oziel\n\tArmando Giovanni Hernández Rodríguez");

        do{
	    String[] opciones = { "Sumar", "Restar", "Multiplicar", "Dividir", "Test aleatorio", "Salir" };
            opc = JOptionPane.showOptionDialog(null, "Digitar la opción que desea realizar:", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0] ) + 1;
            switch(opc){
                case 1: UsoRacional.sumar();break;
                case 2: UsoRacional.restar();break;
                case 3: UsoRacional.multiplicar();break;
                case 4: UsoRacional.dividir();break;
                case 5: UsoRacional.aleatorio();break;
                case 6: JOptionPane.showMessageDialog(null, "Saliendo..."); System.exit(0); break;
                default : JOptionPane.showMessageDialog(null, "Opción no válida intente otra vez :( \n", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }while(opc != 3);
    }  

    public static Racional askRacional( String msg ){
	int num = Integer.parseInt( JOptionPane.showInputDialog( msg + "\n[ ?,   ]\nNumerador:")   );
	return new Racional(
		num,
		Integer.parseInt( JOptionPane.showInputDialog( msg + "\n[ " + num + ", ? ]\nDenominador:") )
	);
    }

    public static ArrayList<Racional> askManyRacionales( String msg, String symbol ){
	ArrayList<Racional> racionales = new ArrayList();
	int op = 0;
	String nums = "";
	Racional racional;
	while ( op == 0 ){
	    String[] opciones = { "Añadir", "Terminé" };
            op = JOptionPane.showOptionDialog(null, msg + "\n" + nums, null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0] );
	    if( op == 1 ) break;
	    if( op == 1 && racionales.size() < 2 ){
		    JOptionPane.showMessageDialog(null, "Debe introducir al menos dos números" );
		    op = 0;
	    }
	    racional = askRacional( "Añadir nuevo numero" );
	    nums += racional.toString() + symbol;
	    racionales.add( racional );
	}
	return racionales;
    }
} 
