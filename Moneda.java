package parking;

public class Moneda {
	
	private double valor;
	private int contador = 10;
			   
	public Moneda(double valor){
      this.valor = valor;
   }
   public int getCantidad(){
      return contador;
   }
   public void masMoneda(){
      contador++;
   }
   public void menosMoneda(){
      contador--;
   }
   public double getValor(){
      return this.valor;
   }
   public double valorTotal(){
      double valorTotal = valor * contador;
      return valorTotal;
   }   
}
