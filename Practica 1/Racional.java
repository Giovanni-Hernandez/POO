

public class Racional {
 //Atributos con modificador de acceso privado  
   private int num;       
   private int den;
   
 //Constructores
    public Racional( ) {
         num = 1;
         den = 1;
    }
  
    public Racional(int n, int d) {
    num = n;
        if(d==0)
            den = 1;  
        else 
            den = d;
    }  
  
 // Métodos
    public void establecer(int num, int den) {
        this.num = num;  
        if(den==0)
            this.den = den = 1; 
         else 
            this.den = den;  
    } 
   
    public void imprimir( ) {
         System.out.println("[ " + num + ", " + den + " ]"); //System pertenece al paquete java.lang
    }

    public String toString( ) {
         return "[ " + num + ", " + den + " ]"; 
    }

    public static int mcd(int n1, int n2){
           if(n2==0)
               return n1;
           if(n1==n2)
            return n1;
           if(n1>n2)
              return mcd(n2,n1%n2);
           else
              return mcd(n1, n2%n1);
    }
    
    public static int mcm(int n1, int n2){
        int n = n1*n2/mcd(n1, n2);
        return n;
    }
 
    public Racional reducir(Racional R){
        int mcd = mcd(num, den);
        num /= mcd;
        den /= mcd;
        return this;
    }

     public Racional reducir(){
        int mcd = mcd(num, den);
        num /= mcd;
        den /= mcd;
        return this;
    }       

      public static Racional s_reducir( Racional R ){
        int mcd = mcd( R.num, R.den);
        R.num /= mcd;
        R.den /= mcd;
        return R;
    }     

     public Racional sum(Racional X){
        X.num = (mcm(X.den, den)/X.den)*X.num;
        num = (mcm(X.den, den)/den)*num;
        num = num + X.num ;      
        den = mcm(X.den, den);
	return this;
    } 

    public static Racional sum(Racional X, Racional Y){
        X.num = (mcm(X.den, Y.den)/X.den)*X.num;
        Y.num = (mcm(X.den, Y.den)/Y.den)*Y.num;
        int num = X.num + Y.num;      
        int den = mcm(X.den, Y.den);
	 return new Racional(num,den);
    } 
    
     public Racional res(Racional X){
        X.num = (mcm(X.den, den)/X.den)*X.num;
        num = (mcm(X.den, den)/den)*num;
        num = num - X.num ;      
        den = mcm(X.den, den);
	 return this;
    } 

    public static Racional res(Racional X, Racional Y){
        X.num = (mcm(X.den, Y.den)/X.den)*X.num;
        Y.num = (mcm(X.den, Y.den)/Y.den)*Y.num;
        int num = X.num - Y.num;      
        int den = mcm(X.den, Y.den);
	 return new Racional(num,den);
    } 
    
    
    public Racional mult(Racional X){
        num = num * X.num;      
        den  = den * X.den;
	 return this;
    } 

    public static Racional mult(Racional X, Racional Y){
        int num = X.num * Y.num;      
        int den  = X.den * Y.den;
	 return new Racional(num,den);
    } 
    
    public Racional div(Racional X){
        num = num * X.den;      
        den = den * X.num;
	 return this;
	 
    } 

    public static Racional div(Racional X, Racional Y){
        int num = X.num * Y.den;      
        int den = X.den * Y.num;
	 return new Racional(num,den);
    } 
	

    public boolean mayorQue(Racional R){
	return num*R.den > den*R.num; 
	//return (double)(num/den)>(double)(R.num/R.den);	
    }
        
    public Racional aleatorio(){
        this.num = (int)(Math.random()*9+1);
        this.den = (int)(Math.random()*9+1);
        return this;
    }

    public boolean equals( Racional R ){
	return (this.num == R.num && this.den == R.den );
    }
        	     
}
