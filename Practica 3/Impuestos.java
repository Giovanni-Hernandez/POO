public interface Impuestos {
    double ISRm = 0.1;
    double ISRa = 0.15;
    
    public void pagarISRmensual(Fecha f);
    public void pagarISRanual(Fecha f);
}
