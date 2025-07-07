import javax.swing.*;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public class Main {
        public static void main(String[] args) {
            ConversionMoneda conversor = new ConversionMoneda();
            Scanner lectura = new Scanner(System.in);
            int opcion = 0;
            double valor;
            double resultado;

            boolean condicion = true;


            while (condicion) {

                    System.out.println(
                            "\n**************************************************\n" +
                                    "Sea bienvenido/a al Conversor de Moneda =]\n" +
                                    "1) Dolar =>> Peso argentino\n" +
                                    "2) Peso argentino =>> Dolar\n" +
                                    "3) Dolar =>> Real brasileño\n" +
                                    "4) Real brasileño =>> Dolar\n" +
                                    "5) Dolar =>> Peso colombiano\n" +
                                    "6) Peso colombiano =>> Dolar\n" +
                                    "7) Salir\n" +
                                    "**************************************************\n"+
                                    "Elija una opcion valida:\n");

                try {
                    opcion = lectura.nextInt();

                    if(opcion > 7 || opcion < 1){
                        System.out.println("Elija un valor entre las opciones del menu");
                        continue;
                    }

                } catch (InputMismatchException e){
                    System.out.println("Ingrese un valor valido del menu.");
                    lectura.nextLine();
                    opcion = 0;
                    continue;

                }
                System.out.println("Ingrese el valor que desea convertir: ");

                valor = lectura.nextDouble();

                try {
                    switch (opcion) {

                        case 1:
                            Moneda moneda = conversor.convertirMoneda(" USD");
                            resultado = valor * moneda.conversion_rates().get("ARS");
                            System.out.println("El valor de " + valor + " USD es " + resultado);
                            break;
                        case 2:
                            Moneda moneda2 = conversor.convertirMoneda("ARS");
                            resultado = valor / moneda2.conversion_rates().get("USD");
                            System.out.println("El valor de " + valor + " ARS es " + resultado + " USD");
                            break;

                        case 3:
                            Moneda moneda3 = conversor.convertirMoneda("USD");
                            resultado = valor * moneda3.conversion_rates().get("BRL");
                            System.out.println("El valor de " + valor + " USD es " + resultado + " BRL");
                            break;

                        case 4:
                            Moneda moneda4 = conversor.convertirMoneda("BRL");
                            resultado = valor / moneda4.conversion_rates().get("USD");
                            System.out.printf("El valor de  %.2f  BRL es  %.2f  USD", valor, resultado);
                            break;
                        case 5:
                            Moneda moneda5 = conversor.convertirMoneda("USD");
                            resultado = valor * moneda5.conversion_rates().get("COP");
                            System.out.printf("El valor de %.2f USD es %.2f  COP", valor, resultado);
                            break;


                        case 6:
                            Moneda moneda6 = conversor.convertirMoneda("COP");
                            resultado = valor * moneda6.conversion_rates().get("USD");
                            System.out.printf("El valor de %.2f COP es %.2f USD", valor, resultado);
                            break;

                        case 7:
                            System.out.println("Programa finalizado");
                            condicion = false;
                            break;

                        default:
                            System.out.println("Opcion no valida");

                    }

                } catch (InputMismatchException e){
                    System.out.println("Se debe ingresar un numero, no es un valor valido");
                    lectura.nextLine();
                }
            }
            lectura.close();
        }
    }

