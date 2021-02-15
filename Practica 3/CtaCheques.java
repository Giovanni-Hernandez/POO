public class CtaCheques extends Cuenta{
    private double sobregiro;
    private static double AUX;
    private int id;
    
    public CtaCheques(Fecha apertura,double saldo, double sobregiro){
        super("Cuenta de Cheques", saldo, apertura);
        this.sobregiro = sobregiro;
        AUX = sobregiro;
    }
   
    @Override
    public void depositar(double monto, Fecha f1){
        double m1;
        m1 = monto;
        if((sobregiro - AUX)<0){
            // Hace falta dinero en sobregiro
            if((monto - AUX)>0){ // El monto es mayor que el sobregiro
                monto = monto +(sobregiro - AUX);
                sobregiro = sobregiro +(AUX - sobregiro);
                if(monto>0){ // Aun queda monto para depositar en saldo
                    saldo = saldo + monto;
                }
            }else{// El monto es menor  o igual que el sobregiro
               sobregiro = sobregiro + monto;
            }         
        }else{ // El sobregiro no ha disminuido, se deposita en saldo
            saldo = saldo + monto;
         } 
       System.out.println("Movimiento: Depósito. \nFecha: "+f1+" Monto = "+m1+" -Actualizado- Saldo  = "+saldo+"  Sobregiro = "+sobregiro+"\n");
       f = f1;
    }
    
    @Override
    public void retirar(double monto, Fecha f1){
       double m1;
       m1 =  monto;
       if(f1.numDias(f1, apertura) < 365){
        if(saldo >= monto){
            saldo -= monto;
            System.out.println("Movimiento: Retiro. \nFecha: "+f1+" Monto = "+m1+ " -Actualizado- Saldo = "+saldo+"  Sobregiro = "+sobregiro+"\n");
        }else{
            if((saldo + sobregiro) - monto >=0){
                monto = monto - saldo;
                saldo = 0.0;
                sobregiro = sobregiro - monto;
                System.out.println("Movimiento: Retiro. \nFecha: "+f1+" Monto = "+m1+" -Actualizado- Saldo = "+saldo+"  Sobregiro = "+sobregiro+"\n");
            }else{
                System.out.println("Movimiento: Retiro. \nFecha: "+f1+" Monto = "+m1+" ¡No se cuenta con el suficiente saldo y sobregiro para realizar el retiro! Saldo = "+saldo+" Sobregiro = "+sobregiro+"\n");
            }
         } 
       }else{
            System.out.println("Movimiento: Retiro. \nFecha: "+f1+" ¡Cuenta de cheques caducada. Transacción inválida!\n");
        }
    }
    
    @Override
    public void consultar(Fecha f1){
        System.out.println("Movimiento: Consulta. \nFecha: "+f1+ " Saldo = "+saldo+" Sobregiro = "+sobregiro+"\n");
        this.f = f1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
