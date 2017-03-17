package parking;

public class Plaza {
	
	public Cliente cliente = new Cliente(0);
   private boolean ocupado;
   private int tipo;
			   
	public Plaza(){
      this.cliente = new Cliente(0);
      this.ocupado = false;
      this.tipo = (int) (Math.random()*2);
   }
   public void setCliente(int nCliente){
      System.out.println("\tHa entrado el cliente n."+nCliente);
      this.cliente.setNcliente(nCliente);
      this.cliente.setFechaEntrada();
      this.ocupado = true;
   }
   public void setLibre(){
      System.out.println("\tCreando ticket ");
      cobrarTicket();    
      System.out.println("\tHa salido el cliente ");
      this.ocupado = false;
   }
   public void cobrarTicket(){
      this.cliente.getTicket();
      double precio = this.getCliente().ticket.getPrecio();
      System.out.println("\tEl precio es "+precio+" euros");
      pagarTicket(precio);
   }
   public void pagarTicket(double precio){
      double precioIntroducido = 0.0;
      int monedaInsertada;
      double teQueda;
      do{
      System.out.println("\tInsertar moneda: ");
      for(int i = 0;i < App.monedas.length;i++){
      System.out.println(i+": "+App.monedas[i].getValor()+" euros");
      }
      monedaInsertada = Integer.parseInt(App.sc.nextLine());
      while(monedaInsertada < 0 || monedaInsertada > App.monedas.length){
         System.out.println("Dato no valido");
         System.out.println("\tInsertar moneda: ");
         for(int i = 0;i < App.monedas.length;i++){
            System.out.println(i+": "+App.monedas[i].getValor()+" euros");
         }
         monedaInsertada = Integer.parseInt(App.sc.nextLine());         
      }
      App.monedas[monedaInsertada].masMoneda();
      precioIntroducido = precioIntroducido + App.monedas[monedaInsertada].getValor();
      teQueda = precio - precioIntroducido;
         if(teQueda == 0.0){
            break;
         }else if(precioIntroducido < precio){
            System.out.println("Te falta "+(teQueda));
         }else{
            System.out.println("Te sobra "+(-teQueda));
            darCambio((-teQueda));
            break;
         }
      }while(precioIntroducido != precio);
   }
   public void darCambio(double d){
      for(int i = App.monedas.length-1;i >= 0;i--){
         while(App.monedas[i].getValor() <= d){
            System.out.println("1 moneda de "+App.monedas[i].getValor());
            App.monedas[i].menosMoneda();
            d = d - App.monedas[i].getValor();
         }
      }
   }
   public boolean siOcupada(){
      return ocupado;     
   }
   public String comprobarPlaza(){
      if(ocupado == false){
      return "libre";
      }else{
      return "ocupada por n."+cliente.getNcliente();
      }
   }
   public int getnCliente(){
      return cliente.getNcliente();
   }
   public Cliente getCliente(){
      return cliente;
   }
   public String getTipo(){
      if(this.tipo == 0){
      return "COCHE";
      } else if(this.tipo == 1){
      return "MOTO";
      }
      return "";
   }      
}
