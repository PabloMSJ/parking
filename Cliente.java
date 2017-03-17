package parking;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cliente {
	
	private int nCliente;
   public Ticket ticket;
   private Calendar fechaEntrada;
			   
	public Cliente(int n){
      this.nCliente = n;
   }
   public void setNcliente(int n){
      this.nCliente = n;
   }
   public void setFechaEntrada(){
      Calendar f = Calendar.getInstance();
      this.fechaEntrada = f;
   } 
   public Calendar getFechaEntrada(){
      return this.fechaEntrada;   
   }     
   public void getTicket(){
      this.ticket = new Ticket(fechaEntrada);
   }
   public int getNcliente(){
      return nCliente;
   }
}
