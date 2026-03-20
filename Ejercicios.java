import java.util.Scanner;

public class Ejercicios {

    public static void main(String[] args) {

        int opcion;
        Scanner entrada = new Scanner(System.in);
        char repetir;
        boolean ejecutar = true;

        do {

            System.out.println("Bienvenido a mi programa");
            System.out.println("Por favor elija la opcion deseada");
            System.out.println("1.- Descuento por edad");
            System.out.println("2.- Convertir numero a binario");
            System.out.println("3.- Conversion de temperaturas");
            System.out.println("4.- Contador de positivos y negativos");
            System.out.println("5.- Tiendita de productos");
            System.out.println("6.- Areas y perimetros de figuras");
            System.out.println("7.- Tabla de multiplos rara");
            System.out.println("8.- Factorial con recursividad");
            System.out.println("9.- Dibujito de cuadrito");
            System.out.println("10.- Figura hueca");
            System.out.println("11.- Patrones con asteriscos");
            System.out.println("12.- Diamante bonito");
            System.out.println("13.- Calculadora basica");
            System.out.println("14.- Salir");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Ingrese su edad");
                    int edad = entrada.nextInt();

                    if (edad < 13) {
                        System.out.println("Tiene un descuento de 20%");
                    } else {
                        System.out.println("No tiene descuento");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese un numero positivo que desee convertir a binario");

                    int numbinario = entrada.nextInt();
                    String guardarbinario = "";

                    if (numbinario > 0) {

                        while (numbinario > 0) {

                            if (numbinario % 2 == 0) {
                                guardarbinario = "0" + guardarbinario;
                            } else {
                                guardarbinario = "1" + guardarbinario;
                            }

                            numbinario = numbinario / 2;
                        }

                    } else if (numbinario == 0) {
                        guardarbinario = "0";
                    } else {
                        guardarbinario = "No se puede convertir ese numero";
                    }

                    System.out.println("Numero convertido a binario: " + guardarbinario);
                    break;

                case 3:
                    System.out.println("Ingrese la temperatura en Celsius");

                    float celsius = entrada.nextFloat();
                    float fahrenheit = (celsius * 9 / 5) + 32;
                    float kelvin = celsius + 273.15f;

                    System.out.println("Fahrenheit: " + fahrenheit);
                    System.out.println("Kelvin: " + kelvin);
                    break;

                case 4:
                    System.out.println("Ingrese la cantidad de numeros");

                    int canum = entrada.nextInt();
                    int positivo = 0;
                    int negativo = 0;

                    for (int i = 1; i <= canum; i++) {

                        System.out.println("Ingrese un numero");
                        int num = entrada.nextInt();

                        if (num >= 0) {
                            positivo++;
                        } else {
                            negativo++;
                        }
                    }

                    System.out.println("Positivos: " + positivo);
                    System.out.println("Negativos: " + negativo);
                    break;

                case 5:
                    System.out.println("Ingrese cuantos productos va a comprar");

                    int elementosproducto = entrada.nextInt();

                    if (elementosproducto > 0) {

                        float compra = 0;

                        for (int i = 1; i <= elementosproducto; i++) {

                            System.out.println("Nombre del producto");
                            String nombreproducto = entrada.next();

                            System.out.println("Precio");
                            float precio = entrada.nextFloat();

                            System.out.println("Cantidad");
                            int cantidad = entrada.nextInt();

                            compra = compra + (cantidad * precio);
                        }

                        System.out.println("Total de la compra: " + compra);

                    } else {
                        System.out.println("Cantidad invalida");
                    }
                    break;

                case 6:
                    System.out.println("1 Cuadrado");
                    System.out.println("2 Rectangulo");
                    System.out.println("3 Triangulo");
                    System.out.println("4 Circulo");
                    System.out.println("5 Pentagono");

                    int fig = entrada.nextInt();

                    switch (fig) {

                        case 1:
                            System.out.println("Ingrese el lado");
                            float lado = entrada.nextFloat();

                            System.out.println("Area: " + (lado * lado));
                            System.out.println("Perimetro: " + (lado * 4));
                            break;

                        case 2:
                            System.out.println("Ingrese base");
                            float base = entrada.nextFloat();

                            System.out.println("Ingrese altura");
                            float altura = entrada.nextFloat();

                            System.out.println("Area: " + (base * altura));
                            System.out.println("Perimetro: " + (2 * (base + altura)));
                            break;

                        case 3:
                            System.out.println("Ingrese base");
                            float basetrian = entrada.nextFloat();

                            System.out.println("Ingrese altura");
                            float alturatrian = entrada.nextFloat();

                            System.out.println("Area: " + (basetrian * alturatrian) / 2);
                            break;

                        case 4:
                            System.out.println("Ingrese el radio");
                            float radio = entrada.nextFloat();

                            System.out.println("Area: " + (3.1416f * radio * radio));
                            System.out.println("Perimetro: " + (2 * 3.1416f * radio));
                            break;

                        case 5:
                            System.out.println("Ingrese el lado");
                            float ladopen = entrada.nextFloat();

                            System.out.println("Ingrese el apotema");
                            float apo = entrada.nextFloat();

                            float perimetrop = ladopen * 5;

                            System.out.println("Area: " + (perimetrop * apo) / 2);
                            System.out.println("Perimetro: " + perimetrop);
                            break;
                    }
                    break;

                case 7:
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(i + " | " + (i * 10) + " | " + (i * 100) + " | " + (i * 1000));
                    }
                    break;

                case 8:
                    System.out.println("Ingrese un numero");

                    int n = entrada.nextInt();
                    int res = fact(n);

                    System.out.println("Factorial: " + res);
                    break;

                case 9:
                    System.out.println("Ingrese el tamaño");

                    int n1 = entrada.nextInt();

                    for (int i = 1; i <= n1; i++) {
                        for (int j = 1; j <= n1; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 10:
                    System.out.println("Ingrese el tamaño");

                    int t = entrada.nextInt();

                    for (int i = 1; i <= t; i++) {
                        for (int j = 1; j <= t; j++) {

                            if (i == 1 || i == t || j == 1 || j == t) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 11:
                    System.out.println("Ingrese el tamaño");

                    int p = entrada.nextInt();

                    for (int i = 1; i <= p; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 12:
                    System.out.println("Ingrese el tamaño");

                    int d = entrada.nextInt();

                    for (int i = 1; i <= d; i++) {

                        for (int j = 1; j <= d - i; j++) {
                            System.out.print(" ");
                        }

                        for (int j = 1; j <= (2 * i - 1); j++) {
                            System.out.print("*");
                        }

                        System.out.println();
                    }

                    for (int i = d - 1; i >= 1; i--) {

                        for (int j = 1; j <= d - i; j++) {
                            System.out.print(" ");
                        }

                        for (int j = 1; j <= (2 * i - 1); j++) {
                            System.out.print("*");
                        }

                        System.out.println();
                    }
                    break;

                case 13:
                    System.out.println("Ingrese numero 1");
                    float a = entrada.nextFloat();

                    System.out.println("Ingrese numero 2");
                    float b = entrada.nextFloat();

                    System.out.println("1 Suma  2 Resta  3 Multiplicacion  4 Division");
                    int op2 = entrada.nextInt();

                    if (op2 == 1) System.out.println(a + b);
                    if (op2 == 2) System.out.println(a - b);
                    if (op2 == 3) System.out.println(a * b);
                    if (op2 == 4) System.out.println(a / b);

                    break;

                case 14:
                    System.out.println("Saliendo del programa...");
                    ejecutar = false;
                    break;
            }

            if (ejecutar) {
                System.out.println("Presione v para volver al menu");
                repetir = entrada.next().charAt(0);

                if (repetir != 'v') ejecutar = false;
            }

        } while (ejecutar);
    }

    public static int fact(int n) {
        if (n == 0) return 1;
        return n * fact(n - 1);
    }
}
