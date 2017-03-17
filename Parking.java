package parking;

public class Parking {
	
	private String nombre;
	public Planta[] plantas;
   private int nPlantas;
			   
	public Parking(String nombre, int nPlantas, int plazasPorPlanta){
      this.nombre = nombre;
      this.nPlantas = nPlantas;
      this.plantas = new Planta[nPlantas];
      for(int i = 0;i < nPlantas;i++){
         plantas[i] = new Planta(plazasPorPlanta);
      }
   }
   public String getNombre(){
      return this.nombre;
   }
   public void comprobarParking(){
      for(int i = 0;i < nPlantas;i++){
         int nPlanta = i + 1;
         System.out.println("Planta n."+nPlanta);
         plantas[i].comprobarPlanta();
      }
   }
   public boolean siLleno(){
      boolean lleno = true;
      for(int i = 0;i < nPlantas;i++){
         if(plantas[i].siLlena() == false){
         lleno = false;
         }
      }
      return lleno;
   }
   public void asignarPlazaLibre(int nCliente){
      for(int i = 0;i < nPlantas;i++){
         if(plantas[i].siLlena() == false){
         plantas[i].asignarPlazaLibre(nCliente);
         break;
         }
      }
   }
   public void verClientesActuales(){
      for(int i = 0;i < nPlantas;i++){
         plantas[i].clientesActuales(i);
      }
   }
   public void buscarCliente(int nCliente){
      for(int i = 0;i < nPlantas;i++){
         plantas[i].buscarCliente(nCliente);
      }   
   }   
}
