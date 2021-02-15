import java.util.*;
public class Usuario {
    public static void main(String[] args){
        
        System.out.println("      Alumno:Hernández Rodríguez Armando Giovanni       \n              POO. GRUPO:1CM5\n            Escenario de Prueba\n");
        Fecha f1 = new Fecha(2, 3, 2021);
        Fecha f2 = new Fecha(7, 3, 2021);
        Fecha f3 = new Fecha(10, 3, 2021);
        Fecha f4 = new Fecha(12, 3, 2021);
        Fecha f5 = new Fecha(15, 4, 2021);
        Fecha f6 = new Fecha(20, 4, 2021);
        Fecha f7 = new Fecha(9, 5, 2021);
        Fecha f8 = new Fecha(20, 6, 2021);
        Fecha f9 = new Fecha(27, 6, 2021);
        Fecha f10 = new Fecha(12, 3, 2022);
        
        ArrayList<Cuenta> cuentas = new ArrayList();
        Cliente C1 = new Cliente("Giovanni",cuentas, "GH5678" );
        
        CtaAhorros CA1 = new CtaAhorros(f1, 20000, 0.1);
        CtaAhorros CA2 = new CtaAhorros(f2, 1000, 0.2);
        CtaCheques CH1 = new CtaCheques(f3, 15000, 2000);
        CtaCredito CR1 = new CtaCredito(f4, 50000, 0.25);
        
        C1.agregarCuenta(CA1);
        C1.agregarCuenta(CA2);
        C1.agregarCuenta(CH1);
        C1.agregarCuenta(CR1);
    
        ArrayList<Fecha> fecha = new ArrayList();
        fecha.add(f5);
        fecha.add(f6);
        fecha.add(f7);
        fecha.add(f8);
        fecha.add(f9);
        fecha.add(f10);
       
        C1.reportarEdosCtas(fecha);
  
    }
}
