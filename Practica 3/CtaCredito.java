public class CtaCredito extends Cuenta{
    private double tasa;
    private double deficit;
    private int id;
    
    public CtaCredito(Fecha apertura,double saldo, double tasa){
        super("Cuenta de Crédito", saldo, apertura);
        this.tasa = tasa;
    }
    
    @Override
     public void consultar(Fecha f1){
        double monto = 0.0;
        if (f.cambioMes(f1)){// Si pasa 1 mes se aplica la tasa de interes
            f = f1;
             if(saldo>0){
            //if(saldo-(saldo *(1-tasa)) >= 0){ // La tasa se aplica sobre el saldo existente
                 monto = saldo * tasa;
                saldo = saldo - monto;
            }else{ // La tasa se aplica al deficit 
                monto = deficit * tasa;
               deficit = deficit + monto;
            }System.out.println("Movimiento: Consulta. \nFecha: "+f+" Monto interes = "+monto+" -Actualizado- Saldo = "+saldo+" Deficit = "+deficit+"\n"); 
        }else{
            System.out.println("Movimiento: Consulta. \nFecha: "+f1+" Monto interes = "+monto+" Saldo = "+saldo+" Deficit = "+deficit+"\n");
        }
     }
     
    @Override
    public void depositar(double monto, Fecha f1){
        double m1;
        m1 = monto;
        if(deficit > 0){
            // Hace falta dinero en deficit
            if((monto - deficit)>0){ // El monto es mayor que el deficit
                monto = monto - deficit;
                deficit = 0.0;
                if(monto > 0){ // Aun queda monto para depositar en saldo
                    saldo = saldo + monto;
                }
            }else{// El monto es menor  o igual que el defict
               deficit = deficit - monto;
            }
                
        }else{ // No hay deficit, se deposita en saldo
            saldo = saldo + monto;
         } 
       System.out.println("Movimiento: Depósito. \nFecha: "+f1+" Monto = "+m1+" -Actualizado- Saldo  = "+saldo+"  Deficit = "+deficit+"\n");
       f = f1;
    }
    
    
    @Override
    public void retirar(double monto, Fecha f1){
       double m1;
       m1 =  monto;
       if((monto-saldo+deficit) < 20000.0){ // El tope del deficit
        if((saldo >= monto)){ // Si se tiene mas o igual saldo que el monto a retirar, el deficit no crece
            saldo -= monto;
            //System.out.println("Movimiento: Retiro. \nFecha: "+f1+" Monto = "+m1+ " -Actualizado- Saldo = "+saldo+"  Deficit = "+deficit+"\n");
        }else{ // Hay menos saldo que el monto a retirar, el deficit crece
            monto = monto - saldo;
            saldo = 0.0;
            deficit = deficit + monto;
            //System.out.println("Movimiento: Retiro. \nFecha: "+f1+" Monto = "+m1+ " -Actualizado- Saldo = "+saldo+"  Deficit = "+deficit+"\n");
        }System.out.println("Movimiento: Retiro. \nFecha: "+f1+" Monto = "+m1+ " -Actualizado- Saldo = "+saldo+"  Deficit = "+deficit+"\n");
       }else{
            System.out.println("Movimiento: Retiro. \nFecha: "+f1+" Monto = "+monto+" ¡Transaccion cancelada. Se llegaría al máximo deficit! Saldo = "+saldo+" Deficit = "+deficit+"\n");
        } f = f1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTasa() {
        return tasa;
    }
    
    
}
