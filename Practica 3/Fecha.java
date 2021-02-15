import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Fecha obtenerFecha(){
        return this;
    }
    
    public Fecha establecerFecha(int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        return this;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }
    
    @Override
    public String toString(){
        String CadDia = dia + "";
        String CadMes = mes + "";
        if(dia<10)
            CadDia = "0"+dia;
        if(mes<10)
            CadMes = "0"+mes;
        
        return CadDia+"-"+CadMes+"-"+anio;
            
    }
    
    public int numDias(Fecha f1, Fecha f2){
      try{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date fechaInicial= dateFormat.parse(f1.toString());
	Date fechaFinal= dateFormat.parse(f2.toString());
        
	return (int) (Math.abs((fechaFinal.getTime()-fechaInicial.getTime())/86400000));
      }catch(ParseException e) { 
            return 1;
      }  
    }
    
    public boolean cambioMes(Fecha f){
        return this.numDias(this, f) >=30;
    }
    
    public double numMes(Fecha f){
        return (double)Math.floor(this.numDias(this, f) / 30);
    }
}
