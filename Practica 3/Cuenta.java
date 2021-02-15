public class Cuenta {
    protected double saldo;
    protected String nombre;
    protected Fecha apertura;
    protected Fecha f;
    
    public Cuenta(String nombre, double saldo){
        this.nombre = nombre;
        this.saldo = saldo;
    }
    
    
    public Cuenta(String nombre, double saldo, Fecha apertura){
        this.nombre = nombre;
        this.saldo = saldo;
        this.apertura = apertura;
        this.f = apertura;
    }
    
    public void consultar(Fecha f){
        System.out.println("Movimiento: Consulta. \nFecha: "+f+ " Saldo = "+saldo+"\n");
        this.f = f;
    }
    
    public void consultar(){
        System.out.println("Movimiento: Consulta. \nFecha: "+f+ " Saldo = "+saldo+"\n");
    }

    
    public void depositar(double monto, Fecha f){
        saldo += monto;
        System.out.println("Movimiento: Déposito. \nFecha: "+f+" Monto = "+monto+" Saldo = "+saldo+"\n");
        this.f = f;
    }
    
    public void retirar(double monto, Fecha f){
        if(saldo >= monto){
            saldo -= monto;
            System.out.println("Movimiento: Retiro. \nFecha: "+f+" Monto = "+ monto+" Saldo disponible = "+saldo+"\n");
            this.f = f;
        }
        else
            System.out.println("Movimiento: Retiro. \nFecha: "+f+" Monto = "+monto+" ¡No se tiene el saldo suficiente! Saldo = "+saldo+"\n");
    }

    public Fecha getApertura() {
        return apertura;
    }

    public String getNombre() {
        return nombre;
    }

 
    
    
}
