import java.util.Scanner;

public class Viaje{
    public static void main(String args[]){
	final double PREC_GASOIL_LT = 1250.0;
	final double CAP_TANQUE = 400.0;
	int kilInicial,kilFinal;
	double litrosGasoil;
	int kilRecorridos;
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
		
    }
}
