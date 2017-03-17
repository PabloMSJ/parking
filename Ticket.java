package parking;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ticket {
	
	private final double PRECIOINICIAL = 0.50;
	private double precioTotal;
   private int minutos;
   
	public Ticket(Calendar fechaEntrada){
      Calendar fechaActual = Calendar.getInstance();
      long milis1 = fechaEntrada.getTimeInMillis();
      long milis2 = fechaActual.getTimeInMillis(); 
      //this.minutos = (int)(milis2 - milis1)/(60 * 1000);
      System.out.print("Minutos? ");
      this.minutos = Integer.parseInt(App.sc.nextLine());
      this.precioTotal = PRECIOINICIAL + calcularPrecio();
   }
   private double calcularPrecio(){
      double precio = 0.0;
      if(this.minutos < 60){
         precio = this.minutos * 0.03;
         precio = Math.round(precio*100)/100;
      }else{
         precio = 60 * 0.03;
         precio = precio + ((this.minutos - 60) * 0.02);
         precio = Math.round(precio*100)/100;
      }
            return precio;
   }
   public double getPrecio(){
      return this.precioTotal;
   }
}