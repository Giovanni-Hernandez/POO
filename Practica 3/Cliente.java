import java.util.*;

public class Cliente {
    private String nombre;
    private ArrayList<Cuenta> cuentas;
    private int numCuentas;
    private String nomCuenta;
    
    public Cliente(String nombre, String nomCuenta){
        this.nombre = nombre;
        this.nomCuenta = nomCuenta;
    }

    public Cliente(String nombre, ArrayList<Cuenta> cuentas, String nomCuenta) {
        this.nombre = nombre;
        this.cuentas = cuentas;
        this.nomCuenta = nomCuenta;
    }
    
    public void agregarCuenta(Cuenta cta){
       cuentas.add(cta);
       numCuentas++;
    }
    
    public Cuenta obtenerCuenta(int index){
        return cuentas.get(index);
    }
    
    public void reportarEdosCtas(ArrayList<Fecha> fecha){ // Reporte Gral de las Cuentas de Cliente
        CtaAhorros CA;
        CtaCredito CR;
        CtaCheques CH;
        int cont1, cont2, cont3;
        cont1 = cont2 = cont3 = 1;
        
        System.out.println("Cliente : "+nombre+"\nNombre Cuenta: "+nomCuenta+"\nNúmero de cuentas: "+numCuentas+"\n");
        
        for(Cuenta C: cuentas){
            System.out.print("\n-------Tipo: "+C.getNombre()+". Fecha de Apertura: "+C.getApertura());
            // Reporte de la Cta de Ahorros
            if(C instanceof CtaAhorros){ // Nos aseguramos que la Cuenta sea del tipo CtaAhorros mediante instanceof
                CA = (CtaAhorros)C; // Se hace un casting a CtaAhorros
                CA.setId(cont1++);  // Ahora se pueden llamar a los métodos de la CtaAhorros
                System.out.println(". Id: "+CA.getId()+". Tasa "+CA.getTasa()+"-------");
                CA.consultar(C.getApertura());
                CA.consultar(fecha.get(0));
                CA.depositar(45000, fecha.get(1));
                CA.pagarISRmensual(fecha.get(2));
                CA.consultar(fecha.get(3));
                CA.pagarISRanual(fecha.get(4));
                CA.retirar(10000, fecha.get(4));  
            }
            // Reporte de la Cta de Crédito
            if(C instanceof CtaCredito){
                CR = (CtaCredito)C;
                CR.setId(cont2++);
                System.out.println(". Id: "+CR.getId()+". Tasa "+CR.getTasa()+"  Tope deficit máximo = 20000-------");
                CR.consultar(CR.getApertura());
                CR.consultar(fecha.get(0));
                CR.retirar(45000, fecha.get(1));
                CR.depositar(5000, fecha.get(2));
                CR.consultar(fecha.get(3));
                CR.depositar(8000, fecha.get(3));
                CR.retirar(25000, fecha.get(3));
                
            }
            // Reporte de la Cta de Cheques
            if(C instanceof CtaCheques){
                CH = (CtaCheques)C;
                CH.setId(cont3++);
                System.out.println(". Id: "+CH.getId()+"-----");
                CH.consultar(CH.getApertura());
                CH.retirar(16000, fecha.get(1));
                CH.depositar(7000, fecha.get(2));
                CH.retirar(10000, fecha.get(3));
                CH.retirar(6900, fecha.get(3));
                CH.retirar(1000, fecha.get(5));  
            }
        }
    }
}
