import java.util.Scanner;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Flota {
	final static int CANT_CAMIONES = 2;

	final static String ESCAPE = new String("\033[");
	final static int ESPACIO = 35;

	public static void clear() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void cargarCamiones(String patente[], int kilRec[], BigDecimal litrosCons[], Scanner sc) {
		for (int i = 0; i < patente.length; i++) {
			clear();
			System.out.printf("Ingrese patente del camion %d: ", (i + 1));
			patente[i] = sc.nextLine(); // nextLine porque las patentes de hoy en dia contienen espacios
			System.out.printf("Ingrese kilometros recorridos del camion %s: ", patente[i]);
			kilRec[i] = sc.nextInt();
			System.out.printf("Ingrese litros consumidos del camion %s: ", patente[i]);
			litrosCons[i] = sc.nextBigDecimal();
			sc.nextLine(); // como esto es un loop, se requiere usar un nextline al final para sacar el \n
							// del scan anterior.
		}
	}

	public static int totalKilometros(int kilRec[]) {
		int resultado = 0;
		for (int i = 0; i < kilRec.length; i++) {
			resultado += kilRec[i];
		}
		return resultado;
	}

	public static BigDecimal totalLitros(BigDecimal litrosCons[]) {
		BigDecimal resultado = new BigDecimal(0.00);
		for (int i = 0; i < litrosCons.length; i++) {
			resultado = resultado.add(litrosCons[i]);
		}
		return resultado;
	}

	public static BigDecimal promedioKilometros(int kilRec[]) {
		int suma = 0;
		BigDecimal resultado = new BigDecimal(0.00);
		for (int i = 0; i < kilRec.length; i++) {
			suma += kilRec[i];
		}
		resultado = resultado.add(BigDecimal.valueOf(suma).divide(BigDecimal.valueOf(kilRec.length))); // suma (capa 1)
																										// valor de
		// suma(capa 2) dividido
		// valor de length(capa 3)
		return resultado;
	}

	public static int camionMaximo(int kilRec[]) {
		int maximo = 0;
		for (int i = 0; i < kilRec.length; i++) {
			if (kilRec[maximo] < kilRec[i]) {
				maximo = i;
			}
		}
		return maximo;
	}

	public static int camionMinimo(int kilRec[]) {
		int minimo = 0;
		for (int i = 0; i < kilRec.length; i++) {
			if (kilRec[minimo] > kilRec[i]) {
				minimo = i;
			}
		}
		return minimo;
	}

	public static BigDecimal consumoCadaCienKm(int kilRec, BigDecimal litrosCons) {
		BigDecimal resultado = new BigDecimal(0.00);
		if (litrosCons.intValue() == 0) {
			return resultado;
		}
		MathContext contexto = new MathContext(2, RoundingMode.HALF_UP);
		resultado = resultado.add(
				litrosCons.divide(BigDecimal.valueOf(kilRec), contexto).multiply(BigDecimal.valueOf(100)));// se
		// tienen
		// que
		// convertir los valores
		return resultado;
	}

	public static BigDecimal[] consumoFlota(int kilRec[], BigDecimal litrosCons[]) {
		BigDecimal resultado[] = new BigDecimal[kilRec.length];
		for (int i = 0; i < kilRec.length; i++) {
			resultado[i] = new BigDecimal(0.00);
			resultado[i] = consumoCadaCienKm(kilRec[i], litrosCons[i]);
		}
		return resultado;
	}

	public static String getClasificacionStr(BigDecimal consumoLt) {
		int valor = consumoLt.intValue();
		if (valor < 8) {
			return "EFICIENTE";
		} else if (valor <= 12) {
			return "NORMAL";
		}
		return "EXCESIVO";
	}

	public static void inicioInforme(String mensaje, int espacio) {
		espacio += 7; // 7 por la cantidad de = en la string mas el espacio.
		System.out.printf("====== %s%dG%s%s%dG =====%n", ESCAPE, espacio, mensaje, ESCAPE,
				(espacio * 2) + mensaje.length() - 7);
	}

	public static void imprimirConsumo(BigDecimal consumoPromedioCamion[], String patente[]) {
		for (int i = 0; i < consumoPromedioCamion.length; i++) {
			System.out.printf("|%s : %s%dG%s%n", patente[i], ESCAPE, ESPACIO,
					getClasificacionStr(consumoPromedioCamion[i]));

		}
	}

	public static void getCantidadEficiencia(int eficiencia[], BigDecimal consumoPromedioCamion[]) {
		for (int i = 0; i < consumoPromedioCamion.length; i++) {
			int consumo = consumoPromedioCamion[i].intValue();
			if (consumo < 8) {
				eficiencia[0]++;
			} else if (consumo <= 12) {
				eficiencia[1]++;
			} else {
				eficiencia[2]++;
			}
		}

	}

	public static void imprimirTodo(int kilRec[], String patente[], BigDecimal litrosCons[]) {
		int totalKm = totalKilometros(kilRec);
		int idxPatenteMax = camionMaximo(kilRec);
		int idxPatenteMin = camionMinimo(kilRec);
		BigDecimal totalLt = totalLitros(litrosCons);
		BigDecimal promedioKm = promedioKilometros(kilRec);
		BigDecimal consumoPromedioFlota = consumoCadaCienKm(totalKm, totalLt);
		BigDecimal consumoPromedioCamion[] = consumoFlota(kilRec, litrosCons);
		inicioInforme("INFORME DE FLOTA", 8);
		System.out.printf("|Total de km recorridos: %s%dG%dkm%n", ESCAPE, ESPACIO, totalKm);
		System.out.printf("|Total de litros consumidos: %s%dG%.2fL%n", ESCAPE, ESPACIO, totalLt);
		System.out.printf("|Promedio de km por camion: %s%dG%.2fkm%n", ESCAPE, ESPACIO, promedioKm);
		System.out.printf("|Camion con recorrido mas largo: %s%dG%s%n", ESCAPE, ESPACIO, patente[idxPatenteMax]);
		System.out.printf("|Camion con recorrido mas corto: %s%dG%s%n", ESCAPE, ESPACIO, patente[idxPatenteMin]);
		System.out.printf("|Consumo promedio de la flota: %s%dG%.2fL/100km%n", ESCAPE, ESPACIO, consumoPromedioFlota);
		inicioInforme("CONSUMO DE LA FLOTA", 8);
		int eficiencia[] = new int[3];
		getCantidadEficiencia(eficiencia, consumoPromedioCamion);
		imprimirConsumo(consumoPromedioCamion, patente);
		inicioInforme("CAMIONES POR CATEGORIA", 6);
		System.out.printf("|EFICIENTE : %s%dG%d%n", ESCAPE, ESPACIO, eficiencia[0]);
		System.out.printf("|NORMAL : %s%dG%d%n", ESCAPE, ESPACIO, eficiencia[1]);
		System.out.printf("|EXCESIVO : %s%dG%d%n", ESCAPE, ESPACIO, eficiencia[2]);
	}

	public static void main(String args[]) {
		int kilRec[] = new int[CANT_CAMIONES];
		BigDecimal litrosCons[] = new BigDecimal[CANT_CAMIONES];
		String patente[] = new String[CANT_CAMIONES];
		Scanner scanner = new Scanner(System.in);
		cargarCamiones(patente, kilRec, litrosCons, scanner);
		imprimirTodo(kilRec, patente, litrosCons);
	}
}
