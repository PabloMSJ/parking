package parking;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
   //Constantes
   public static final int PLANTAS = 2; //Numero de plantas
   public static final int PLAZASPLANTA = 10; //Plazas que tiene cada planta
   public static final String NOMBREPARKING = "Parking Galileo"; //Nombre del parking
   public static Scanner sc = new Scanner(System.in); //Objeto escaner, utilizable en todas las clases
   public static Parking pGalileo = new Parking(NOMBREPARKING, PLANTAS, PLAZASPLANTA); //Creacion del parking
   public static int contClientes = 0; //Contador de clientes
   public static Moneda[] monedas = { //Creacion de los tipos de monedas
      new Moneda(0.05),
      new Moneda(0.10),
      new Moneda(0.20),
      new Moneda(0.50),
      new Moneda(1.00),
      new Moneda(2.00),
      new Moneda(5.00),
      new Moneda(10.00),
      new Moneda(20.00)
   };
   
	public static void menuCliente(){
		do{
			System.out.println("-------------------------------");
			System.out.println(pGalileo.getNombre()+" - "+comprobarParking(pGalileo)+"       |");
			System.out.println("-------------------------------");
			System.out.println("1 - Entrar                    |");
			System.out.println("2 - Salir                     |");
			System.out.print("Teclear opcion: ");
			int opcion = Integer.parseInt(sc.nextLine());
         System.out.println("-------------------------------");
			if(opcion != 1 && opcion != 2 && opcion != 123){
				System.out.println("Opcion no valida");
			}else if(opcion == 123){
				break;
			}else{
				switch(opcion){
				case 1: //Entra un nuevo cliente
               entrarCliente();
               confirmar();
 					break;
				case 2: //Sale un cliente
               salirCliente();
               confirmar();
					break;
				}
			}
		}while(true);
	}

	public static void menuMantenimiento(){
		do{
			System.out.println("------------------------------------");
			System.out.println("MENU DE MANTENIMIENTO               |");
			System.out.println("------------------------------------");
			System.out.println("1 - Ver monedas                     |");
			System.out.println("2 - Introducir monedas              |");
			System.out.println("3 - Sacar monedas                   |");
			System.out.println("4 - Ingresos del dia                |");
			System.out.println("5 - Salir a la pantalla de clientes |");
			System.out.println("6 - Clientes actuales               |");
			System.out.println("7 - Plazas                          |");
			System.out.println("8 - Salir del programa              |");
			System.out.print("Teclear opcion: ");
			int opcion = Integer.parseInt(sc.nextLine());
         System.out.println("------------------------------------");
			if(opcion < 1 || opcion > 8){ //Error
				System.out.println("Opcion no valida");
			}else if(opcion == 8){ //Salir
            System.out.println("Cerrando aplicacion");
				break;
			}else{ //Menu
				switch(opcion){
				case 1: //Ver monedas
               verMonedas();
               confirmar();
					break;
				case 2: //Introducir monedas
               introducirMonedas();
					break;
				case 3: //Sacar monedas
               sacarMonedas();
					break;
				case 4: //Ingresos totales
               ingresosTotales();
               confirmar();
					break;
				case 5: //Menu de clientes
               menuCliente();
					break;
            case 6: //Clientes actuales
               pGalileo.verClientesActuales();
               confirmar();
					break;
				case 7: //Comprobar todas las plazas del parking
               pGalileo.comprobarParking();
               confirmar();
					break;
				}
			}
		}while(true);
	}
   public static void entrarCliente(){
      int nCliente = contClientes + 1;
      pGalileo.asignarPlazaLibre(nCliente);
      contClientes++;
   }
   public static void salirCliente(){
      System.out.print("\tCliente n: ");
      int nCliente = Integer.parseInt(sc.nextLine());
      while(nCliente < 0 || nCliente > contClientes){
         System.out.println("El cliente no existe");
         System.out.print("\tCliente n: ");
         nCliente = Integer.parseInt(sc.nextLine());         
      }
      pGalileo.buscarCliente(nCliente);
   }    
   public static String comprobarParking(Parking p){
      if(p.siLleno() == true){
      return "LLENO";
      }else{
      return "LIBRE";
      }
   }
   public static void verMonedas(){
      for(int i = 0;i < monedas.length;i++){
      System.out.println(monedas[i].getValor()+" euros: "+monedas[i].getCantidad());
      }
   }
   public static void introducirMonedas(){
      int monedaInsertada;
      do{
         System.out.println("\tInsertar moneda: (-1 = salir)");
         for(int i = 0;i < monedas.length;i++){
         System.out.println(i+": "+App.monedas[i].getValor()+" euros: "+monedas[i].getCantidad());
         }
         String sMonedaInsertada = sc.nextLine();
         if(sMonedaInsertada.equals("")){
         System.out.println("Dato no valido");
         }else{
         monedaInsertada = Integer.parseInt(sMonedaInsertada);
         if(monedaInsertada == -1){
            break;
         }else if(monedaInsertada < 0 || monedaInsertada > App.monedas.length){
            System.out.println("Dato no valido");
         }else{
            monedas[monedaInsertada].masMoneda();
         }
         }
      }while(true);

   }
   public static void sacarMonedas(){
      int monedaInsertada;
      do{
         System.out.println("\tSacar moneda: (-1 = salir)");
         for(int i = 0;i < monedas.length;i++){
         System.out.println(i+": "+App.monedas[i].getValor()+" euros: "+monedas[i].getCantidad());
         }
         String sMonedaInsertada = sc.nextLine();
         if(sMonedaInsertada.equals("")){
         System.out.println("Dato no valido");
         }else{
         monedaInsertada = Integer.parseInt(sMonedaInsertada);
         if(monedaInsertada == -1){
            break;
         }else if(monedaInsertada <= 0 || monedaInsertada > App.monedas.length){
            System.out.println("Dato no valido");
         }else{
            if(monedas[monedaInsertada].getCantidad() == 0){
            System.out.println("No hay monedas de ese tipo");
            }else{
            monedas[monedaInsertada].menosMoneda();
            }
         }
         }
      }while(true);

   }
   public static void confirmar(){
      System.out.println("Aceptar");
      sc.nextLine();
   }
   public static void ingresosTotales(){
      double ingresos = 0.00;
      for(int i = 0;i < monedas.length;i++){
      ingresos = ingresos + monedas[i].valorTotal();
      }
      System.out.println("Los ingresos totales son: "+ingresos+" euros");
   }
	public static void main(String[] args){
      menuMantenimiento();
   }
}
