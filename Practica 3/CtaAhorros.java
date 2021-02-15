public class CtaAhorros extends Cuenta implements Impuestos {
    private double tasa;
    private int id;


    public CtaAhorros(Fecha apertura, double saldo, double tasa){
        super("Cuenta de Ahorros",saldo, apertura );
        this.tasa = tasa;
        this.id = 0;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setF(Fecha f) {
        this.f = f;
    }

    public Fecha getF() {
        return f;
    }

    public int getId() {
        return id;
    }

    public double getTasa() {
        return tasa;
    }

    @Override
    public void consultar(Fecha f1){
        double monto = 0.0;
        if (f.cambioMes(f1)){// if (f.getMes() > apertura.getMes())
            f = f1;
            monto = saldo * tasa;
            saldo = saldo * (tasa + 1);
            System.out.println("Movimiento: Consulta. \nFecha: "+f+" Monto interes = "+monto+" -Actualizado- Saldo = "+saldo+"\n");
        } else {
            System.out.println("Movimiento: Consulta. \nFecha: "+f1+" Monto interes = "+monto+" Saldo = "+saldo+"\n");
        }
    }

    @Override
    public void pagarISRmensual(Fecha f1) {
        double monto;
        if(saldo > 10000.0 && f1.cambioMes(apertura)){
            monto = saldo * ISRm;
            saldo = saldo * (1 - ISRm);
            System.out.println("Movimiento: Pago ISR mensual. \nFecha: "+f+ " Usted pagó = "+monto+ " Saldo disponible = "+ saldo+"\n" );
        }
        else 
            System.out.println("Aun no se tiene que pagar ISR mensual. Saldo = " + saldo+"\n");
    }

    @Override
    public void pagarISRanual(Fecha f1) {
       double monto;
       if(saldo > 50000.0 && f1.cambioMes(apertura)){
            monto = saldo * ISRa;
            saldo = saldo * (1 - ISRa);
            System.out.println("Movimiento: Pago ISR anual. \nFecha: "+f+" Usted pagó "+monto+" Saldo disponible = "+ saldo +"\n" );
        }
        else 
            System.out.println("Aun no se tiene que pagar ISR anual. Saldo = " + saldo+"\n");
    }


}
