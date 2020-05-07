/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoarquitectura;

import java.util.Scanner;

/**
 *
 * @author kjmol
 */
public class ProyectoArquitectura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //este string sirve para que al final de ciclo do si se cambia condicionsalir a salir se salga del ciclo y termine en codigo
        String condicionSalir = "continuar";
        //numeroRegistroUsar es el indice que se utiliza para selecionar un registro en arreglo registro
        int numeroRegistroUsar;
        int numeroRegistro1;
        int DecimalConvertirCarga;

        //este arreglo simula los registro .cada registro tiene 32 bit maximo  
        String[] registros = new String[15];
        //esta arrays simula la memoria cada posicion en memoria es un bite  
        int[] memoriaPrincipal = new int[20];
        //este simula la lectura de la instrucion,aunque por el momento creo que es redundante  
        String[] instrucionMemoria = new String[5];

        Scanner teclado = new Scanner(System.in);

        //el bucle es solamente para continuar y no salirme de la ejecucion ,para salir solo es necesario escribir salir cuando el codigo lo pida 
        do {

            System.out.print("Ingrese la instrucion de desea ejecutar \n ");
            System.out.print("opciones:\nmov\nldr\nstr\nadd\nsub\nmult\nnegativo\nregistros ");
            instrucionMemoria[0] = teclado.nextLine();

            switch (instrucionMemoria[0]) {
                //en esta parte crearemos la istrucion a hacer y cargaremos el valor decimal a hxadecimal en el registro que se indique
                //opcion de codigo ldr
                case "ldr":
                    //TODO
                    break;
                //hace la carga de un numero al registro selecionado no mayor a 255
                case "mov":
                    try {
                    System.out.print("Ingrese el numero de registro que dese usar ");
                    instrucionMemoria[1] = teclado.nextLine();
                    numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                    System.out.print("Ingrese el numero que desea cargar");
                    instrucionMemoria[2] = teclado.nextLine();
                    DecimalConvertirCarga = Integer.parseInt(instrucionMemoria[2]);
                    if (DecimalConvertirCarga < 255) {
                        System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + " " + instrucionMemoria[2] + "\n");
                        registros[numeroRegistroUsar] = ConversionHexadecimal.ConvertirDecAHexadecial(DecimalConvertirCarga);
                    } else {
                        System.out.print("el numero es demasiado grande para la opcion mov,utilice ldr \n");
                    }
                } catch (Exception e) {
                        System.out.print("error "+e.getMessage()+"\n");
                }

                break;
                //opcion de codigo str
                case "str":
                    //TODO
                    break;
                //opcion de codigo add
                case "add":
                    System.out.print("Ingrese el numero de registro que desea usar para cargar \n");
                    instrucionMemoria[1] = teclado.nextLine();
                    System.out.print("Ingrese el numero de registro que dese usar para sumar\n ");
                    instrucionMemoria[2] = teclado.nextLine();
                    numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                    numeroRegistro1 = Integer.parseInt(instrucionMemoria[2]);
                    System.out.print("Ingrese el numero que desea sumar\n");
                    instrucionMemoria[3] = teclado.nextLine();
                    int DecimalSumar = Integer.parseInt(instrucionMemoria[3]);
                    if (DecimalSumar < 7) {
                        String HexadecimalConvertir = registros[numeroRegistro1];
                        int HexaTransformadoDecimal = ConversionHexadecimal.ConvertirHexADecimal(HexadecimalConvertir);

                        //System.out.print("Instruciona ejecutar :"+instrucionMemoria[0]+" registro "+instrucionMemoria[1]+" "+instrucionMemoria[2]+"\n" );
                        registros[numeroRegistroUsar] = ConversionHexadecimal.ConvertirDecAHexadecial(HexaTransformadoDecimal + DecimalSumar);
                    } else {
                        System.out.print("el numero es demasiado grande para la opcion add,solo se puede sumar hasta el numero 7 \n");
                    }

                    break;
                //opcion de codigo sub
                case "sub":
                    //TODO
                    break;
                //opcion de codigo mult
                case "mult":
                    //TODO
                    break;
                //opcion logicas de arm
                case "Logica":
                    //TODO
                    break;
                //hacer el numero negativo
                case "negativo":
                    System.out.print("Ingrese el numero de registro que dese usar ");
                    instrucionMemoria[1] = teclado.nextLine();
                    numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                    System.out.print("Ingrese el numero que desea hacer negativo     ");
                    instrucionMemoria[2] = teclado.nextLine();
                    DecimalConvertirCarga = Integer.parseInt(instrucionMemoria[2]);
                    System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " reg" + instrucionMemoria[1] + " " + instrucionMemoria[2] + "\n");
                    System.out.print(-DecimalConvertirCarga);
                    registros[numeroRegistroUsar] = ConversionHexadecimal.ConvertirDecAHexadecial(-DecimalConvertirCarga);
                    break;
                //el case registro mostrara los valores que tienen los 16 registro en hexadecmal
                case "registros":
                    for (int x = 0; x < registros.length; x++) {
                        System.out.print("Registro" + x + " valor--> " + registros[x] + "\n");
                    }
                    break;
                default:
                    System.out.print("<--------opcion invalida-------> \n");
                    break;
            }

            System.out.print("Desea continuar ,escriba salir si desea salir o escriba cualquier cosa y continua:");
            condicionSalir = teclado.nextLine();
            System.out.print("ok continuaremos \n \n \n \n \n \n \n \n");
        } while (!condicionSalir.equals("salir"));

    }

}
