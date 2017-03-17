package parking;

public class Planta {
	
	private int capacidad;
	public Plaza[] plazas;
   private boolean lleno;
			   
	public Planta(int nPlazas){
      this.capacidad = nPlazas;
      this.plazas = new Plaza[nPlazas];
      for(int i = 0;i < nPlazas;i++){
         plazas[i] = new Plaza();
      }
   }
   public void comprobarPlanta(){
      for(int i = 0;i < capacidad;i++){
         int nPlaza = i + 1;
         System.out.println("\tPlaza n."+nPlaza+" esta "+plazas[i].comprobarPlaza());
      }
   }
   public boolean siLlena(){
      boolean llena = true;
      for(int i = 0;i < capacidad;i++){
         if(plazas[i].siOcupada() == false){
            llena = false;
         }
      }
      return llena;   
   }
   public void asignarPlazaLibre(int nCliente){
      for(int i = 0;i < capacidad;i++){
            if(plazas[i].siOcupada() == false){
            plazas[i].setCliente(nCliente);
            break;
         }
      }
   }
   public void clientesActuales(int nPlanta){
      for(int i = 0;i < capacidad;i++){
            int nPlaza = i + 1;
            if(plazas[i].siOcupada()){
               System.out.println("\tCliente n."+plazas[i].getnCliente()+" esta en la plaza "+(nPlanta+1)+"."+nPlaza+" desde: "+plazas[i].getCliente().getFechaEntrada().getTime());
         }
      }
   }
   public void buscarCliente(int nCliente){
      for(int i = 0;i < capacidad;i++){
         if( plazas[i].getnCliente() == nCliente){
            if(plazas[i].siOcupada()){
               System.out.println("\tEncontrado!");
               plazas[i].setLibre();
            }else{
               System.out.println("\tEl cliente ya no esta en el parking");

            }
         }
      }
   }
}
