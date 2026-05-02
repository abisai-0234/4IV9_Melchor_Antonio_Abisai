import java.util.Scanner;
public class Figuras{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
    System.out.println("--- MENU ---");
    System.out.println("1. Triangulo");
    System.out.println("2. Cuadrado");
    System.out.println("3. Circulo");
    System.out.println("4. Rectangulo");
    System.out.println("5. Pentagono");
    System.out.println("6. Salir");
    System.out.print("Elige una opcion: ");

    opcion = sc.nextInt();

    switch (opcion){
    case 1: //Triangulo
        System.out.print("Base: ");
        float base = sc.nextFloat();
        System.out.print("Altura: ");
        float Altura = sc.nextFloat();
        System.out.print("Lado 1: ");
        float Lado1 = sc.nextFloat();
        System.out.print("Lado 2: ");
        float Lado2 = sc.nextFloat();
        System.out.print("Lado 3: ");
        float Lado3 = sc.nextFloat();

        float AreaT = (base * Altura)/2;
        float PerT = Lado1 + Lado2 + Lado3;

        System.out.println("Area: " + AreaT);
        System.out.println(" Perimetro: " + PerT);
        break;


        case 2: //Cuadrado

        System.out.println("Lado: ");
        float Lado = sc.nextFloat();

        float ACuadrado = Lado * Lado;
        float Pcuadrado = 4 * Lado;

        System.out.println("Area: " + ACuadrado);
        System.out.println("Perimetro: " + Pcuadrado);

        case 3: //Circulo
        System.out.println("Radio: ");
        float radio = sc.nextFloat();
                    
        float Acir = (float)(Math.PI * radio * radio);
        float Pcir = (float)(2 * Math.PI * radio);

        System.out.println("Area: " + Acir);
        System.out.println("Perimetro: " + Pcir);
        break;

        case 4:// Rec
         System.out.println("Base: ");
        float BaseRec = sc.nextFloat();
        System.out.println("Altura: ");
        float AlturaRec = sc.nextFloat();

        float areaRec = BaseRec * AlturaRec;
        float PerRec = 2 * (BaseRec + AlturaRec);

        System.out.println("Area: " + areaRec);
        System.out.println("Perimetro: " + PerRec);
        break;

        case 5: //Penta
        System.out.println("Lado: ");
        float LadoPenta = sc.nextFloat();
        System.out.println("Apotema: ");
        float apotema = sc.nextFloat();

        float PerPenta = 5 * LadoPenta;
        float areaPenta = (PerPenta * apotema)/2;

        System.out.println("Area: " + areaPenta);
        System.out.println("Perimetro: " + PerPenta);
        break;

         case 6:
        System.out.println("Ayooos");
        break;

        default:
        System.out.println("Opcion invalida");

                

            }

        }while(opcion != 6);
    }
}