import java.util.Scanner;

public class Viaje{
    public static void main(String args[]){
	final double PREC_GASOIL_LT = 1250.0;
	final double CAP_TANQUE = 400.0;
	int kilInicial,kilFinal;
	int kilRecorridos;
	double litrosGasoil;
	double consumoLt;
	double rendimiento;
	double costoCombustible;
	double costoKilometro;
	double capacidadPorcentaje;
	String patente;
	Scanner scanner = new Scanner(System.in);
	System.out.println("Ingrese la patente del camion: ");
	patente = scanner.nextLine();
	System.out.println("Ingrese el kilometraje antes del viaje: ");
	kilInicial = scanner.nextInt();
	System.out.println("Ingrese el kilometraje despues del viaje: ");
	kilFinal = scanner.nextInt();
	System.out.println("Ingrese los litros de gasoil cargados: ");
	litrosGasoil = scanner.nextDouble();
	kilRecorridos = kilFinal - kilInicial;
	consumoLt = (litrosGasoil / kilRecorridos) * 100;
	rendimiento = (kilRecorridos / litrosGasoil);
	costoCombustible = litrosGasoil * PREC_GASOIL_LT;
	costoKilometro = costoCombustible / kilRecorridos;
	capacidadPorcentaje = (litrosGasoil / CAP_TANQUE) * 100;
	System.out.printf("Km recorridos: %d | Consumo cada 100 km: %.2f | Km por litro: %.2f | Costo total: %.2f\n",kilRecorridos,consumoLt,rendimiento,costoCombustible);
	System.out.printf("La carga representa %.2f%% de la capacidad del tanque\n",capacidadPorcentaje);
    }
}
