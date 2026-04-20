/*
Vamos a rear 14 programas dnetro de un menu gigante
para poner a prueba sus conocimientos 
de algortimia
1.- Desarrollar un programa para calcular el bono de un descuento por edad
2.- Convertir numeros decimales a binarios
3.- Convertir temperaturas entre los 3 principales grados C -> F y K 
4.- Realizar un programa para contar numero de positivos y negavitosde una serie de numeros
5.- Desarrollar una tienda para agregar productos y precios
6.- Desarrollar un programa para calcular el area y perimetro de 5 diferentes figuras
7.- Desarrollar una tabla ahoria a ver de que se me ocurre
8.- Desarrollar un programa para calcular el factorial 
9.- Vamos hacer dibujitos wiiiii   triangulo equilatero     rombo
10.- Desarrollar una figura hueca
11.- 
12.- Realizar un diamante
13.- Desarrollar una calculadora basica + - * / para n numeros
*/

import java.util.Scanner;

class EstructuraDatos{

    public static void main(String[] args){
        //aqui van las variables
        int opcion;
        char letrapararepetir;
        float compra=0;

        //aqui van los objetos
        Scanner entrada = new Scanner(System.in);

        //aqui va el menu

        do{
        System.out.println("Bienvenido a este programa para verificar que tanto saben programar a partir de algoritmos basicos.");
        System.out.println("Por favor elija la opción deseada:");
        System.out.println("1.- ");
        System.out.println("2.- ");
        System.out.println("3.- ");
        System.out.println("4.- ");
        System.out.println("5.- ");
        System.out.println("6.- ");
        System.out.println("7.- ");
        System.out.println("8.- ");
        System.out.println("9.- ");
        System.out.println("10.- ");
        System.out.println("11.- ");
        System.out.println("12.- ");
        System.out.println("13.- ");
        System.out.println("14.- Salir ");
        
        //entrada de dato
        opcion = entrada.nextInt();

        //ahora tengo que evaluar la entrada
        switch (opcion) {
            case 1:
                
                break;
            case 2:  
            //convertir un numero decimal a binario
            System.out.println("Ingrese un numero positivo entero que se desee convertir a binario");
            int numbinario;
            String guardarbinario ="";
            numbinario = entrada.nextInt();

            if(numbinario > 0){
                //realizamos el mod 2
                while(numbinario > 0){
                    if(numbinario%2 == 0){
                        guardarbinario = "0" + guardarbinario;

                    }else{
                        guardarbinario = "1" + guardarbinario;

                    }
                    numbinario = (int)numbinario/2;
                }

            }else if(numbinario == 0){
                
                guardarbinario = "0";
            }else{
               //aqui no se puede llegale
               guardarbinario = "No se puede convertir ese numero, solo acepta positivos";
            }
            System.out.println("El numero convertido a binario es: " + guardarbinario);
                
                break;
            case 3:
                
                break;
            
            case 4:
                
                break;
            
            case 5:
                System.out.println("Bienvenido a esta hermosa tiendita linda y kawaii");
                System.out.println("Por favor ingrese cuantos elementos va a comprar");
                int elementosproducto = 0;
                elementosproducto = entrada.nextInt();
                if( elementosproducto > 0){
                    for(int i = 1; i<= elementosproducto; i++){
                        System.out.println("Ingresa el nombre del producto");
                        String nombreproducto="";
                        nombreproducto = entrada.next();
                        System.out.println("Ingrese el precio");
                        float precio=0;
                        precio = entrada.nextFloat();
                        float resultado;
                        System.out.println("Ingrese la cantidad de producto");
                        int cantidad=0;
                        precio = entrada.nextInt();
                        resultado = precio * cantidad;
                        
                        compra = resultado + compra;


                    }
                    System.out.println("El total de la compra es: " + compra);

                }else{
                    System.out.println("ingrese solo cantidades positivas");
                }
                
                break;
            case 6:
                break;
            
            case 7:
                //quiero dejarles una tabla de multiplicar
                //deberan de darle formato y titulos a cada columna
                for(int n = 1; n <= 10; n++){
                    System.out.println(
                        "| " + n + "  | " + (n*10 + " " + (n*100) +" " + (n*1000)));
                }

            case 8:
                break;
            case 9:
                //vamos a realizar un cuadrado magico
                System.out.println("Vamos a realizar el dibujo de un cuadrado magico");
                System.out.println("Ingrese el tamaño del cuadrado");
                int n1= entrada.nextInt();

                if(n1 >= 1 && n1 <=20){
                    //se imprime
                    for(int i = 1; i <= n1; i++){
                        //recorro las columnas
                        //System.out.print(" 1 ");
                        for(int j = 1; j <= n1; j++){
                            System.out.print(" * ");

                        }
                        System.out.println("");
                    }

                }else{
                    System.out.println("Por favor solo ingrese valores entre el 1 y el 20");
                }
                break;
        
            default:
                break;
        }
        System.out.println("Deseas repetir el programa escribe s o S para si");
        letrapararepetir = entrada.next().charAt(0);  
        }while(letrapararepetir != 's' || letrapararepetir == 'S');    

    }
}