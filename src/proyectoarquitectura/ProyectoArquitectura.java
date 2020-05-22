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

/*
Nota1: la case ConversionHexadeximal hace dos cosas convertir un decimal a hexadecimal o convertir un hexadecimal a decimal
nota2:la clase Instruciones logica procesa los datos para hacer las 4 operqaciones logicas pedidas


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
        int numeroRegistroUsar1;
        int numeroRegistroUsar2;
        int numeroRegistroUsar3;
        int numeroRegistroUsar4;
        //son las varaibles que almacenas el digito convertido a decimal y viceversa
        int DecimalConvertirCarga;
        //int HexaConvertirAlmacenamiento;

        //este arreglo simula los registro .cada registro tiene 32 bit maximo  
        String[] registros = new String[15];
        //esta arrays simula la memoria,cada espacio de array simula una palabra 
        String[] memoryDump = new String[10];
        //este simula la lectura de la instrucion,aunque por el momento creo que es redundante  
        String[] instrucionMemoria = new String[5];

        Scanner teclado = new Scanner(System.in);
        /* prueba de operacion and borrar despues 
        int valor=15 & 8;
        System.out.print("primer intento "+ConversionHexadecimal.ConvertirDecAHexadecial(valor) );
        
        System.out.print("          segundo intento "+InstrucionesLogicas.operacionAnd(ConversionHexadecimal.ConvertirDecAHexadecial(15), ConversionHexadecimal.ConvertirDecAHexadecial(8)));*/
        //el bucle es solamente para continuar y no salirme de la ejecucion ,para salir solo es necesario escribir salir cuando el codigo lo pida 
        do {

            System.out.print("Ingrese la instrucion de desea ejecutar \n ");
            System.out.print("opciones:\nmov\nldr\nstr\nneg\nlogica\nreg\nmemoria\nAritmetica\n");
            instrucionMemoria[0] = teclado.nextLine();

            switch (instrucionMemoria[0]) {
                //en esta parte crearemos la istrucion a hacer y cargaremos el valor decimal a hxadecimal en el registro que se indique
                //opcion de codigo ldr formato:ldr rd, [rb] o ldr rd, [rb, #Offset5] o ldr rd, =Inm32
                case "ldr":
                    try {
                    System.out.print("que opcion de ldr desea usar\n1)ldr rd, =Inm32\n2)ldr rd, [rb]\n3)ldr rd, [rb, #Offset5] ");
                    condicionSalir = teclado.nextLine();
                    //inicio de la opcion ldr
                    if (Integer.parseInt(condicionSalir) == 1) {
                        System.out.print("Ingrese el numero de registro que dese usar ");
                        instrucionMemoria[1] = teclado.nextLine();
                        numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                        System.out.print("Ingrese el numero que desea cargar");
                        instrucionMemoria[2] = teclado.nextLine();
                        DecimalConvertirCarga = Integer.parseInt(instrucionMemoria[2]);

                        System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + "," + instrucionMemoria[2] + "\n");
                        registros[numeroRegistroUsar] = ConversionHexadecimal.ConvertirDecAHexadecial(DecimalConvertirCarga);

                    }
                    if (Integer.parseInt(condicionSalir) == 2) {
                        System.out.print("Ingrese el numero de registro al que desea hacer la carga ");
                        instrucionMemoria[1] = teclado.nextLine();
                        numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                        System.out.print("Ingrese el numero de registro que contiene la direcion");
                        instrucionMemoria[2] = teclado.nextLine();
                        numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);

                        System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + ",[registro" + instrucionMemoria[2] + "]\n");

                        registros[numeroRegistroUsar] = memoryDump[ConversionHexadecimal.ConvertirHexADecimal(registros[numeroRegistroUsar1])];

                    }
                    if (Integer.parseInt(condicionSalir) == 3) {
                        System.out.print("Ingrese el numero de registro al que desea hacer la carga ");
                        instrucionMemoria[1] = teclado.nextLine();
                        numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                        System.out.print("Ingrese el numero de registro que contiene la direcion");
                        instrucionMemoria[2] = teclado.nextLine();
                        numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);
                        System.out.print("Ingrese el el valor de offset");
                        instrucionMemoria[3] = teclado.nextLine();
                        DecimalConvertirCarga = Integer.parseInt(instrucionMemoria[3]);
                        if (DecimalConvertirCarga < 32) {
                            System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + ",[registro" + instrucionMemoria[2] + "," + instrucionMemoria[3] + "]\n");

                            registros[numeroRegistroUsar] = memoryDump[ConversionHexadecimal.ConvercionesConOperaciones(registros[numeroRegistroUsar1], DecimalConvertirCarga)];
                        }
                    }
                    //fin selecion de las opciones de ldr 
                } catch (Exception e) {
                    System.out.print("error " + e.getMessage() + "\n");
                }

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
                        System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + "," + instrucionMemoria[2] + "\n");
                        registros[numeroRegistroUsar] = ConversionHexadecimal.ConvertirDecAHexadecial(DecimalConvertirCarga);
                    } else {
                        System.out.print("el numero es demasiado grande para la opcion mov,utilice ldr \n");
                    }
                } catch (Exception e) {
                    System.out.print("error " + e.getMessage() + "\n");
                }

                break;
                //opcion de codigo str  formato:str rd, [rb];str rd, [rb, #Offset5];str rd, [rb, ro]
                case "str":
                    try {
                    System.out.print("Ingrese la info del registro que se quiere almacenar ");
                    instrucionMemoria[1] = teclado.nextLine();
                    numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                    System.out.print("Ingrese el registro que tiene la direcion ");
                    instrucionMemoria[2] = teclado.nextLine();
                    numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);
                    System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + ",[registro" + instrucionMemoria[2] + "]\n");
                    memoryDump[numeroRegistroUsar1] = registros[numeroRegistroUsar];
                } catch (Exception e) {
                    System.out.print("error " + e.getMessage() + "\n");
                }
                break;
                
                case "Aritmetica":
                    try {
                    System.out.print(" Que operacion aritmetica quiere realizar add / sub / mul\n ");
                    instrucionMemoria[0] = teclado.nextLine();
                    switch (instrucionMemoria[0]) {
                        
                        case "add" :
                             try {
                               System.out.print(" Realizar operacion ADD con\nA: 2 Operandos\nB: 3 Operandos\n");
                                instrucionMemoria[0] = teclado.nextLine();
                                switch (instrucionMemoria[0]) {
                                
                                case "A" :
                                    System.out.print("Ingrese el numero de registro al que se va carga y tiene el valor a usar ");
                                    instrucionMemoria[1] = teclado.nextLine();
                                    numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                                    System.out.print("Ingrese el numero de registro que contiene el otro valor");
                                    instrucionMemoria[2] = teclado.nextLine();
                                    numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);
                                    System.out.print("Ingrese el numero de registro donde desee guardar ");
                                    instrucionMemoria[3] = teclado.nextLine();
                                    numeroRegistroUsar2 = Integer.parseInt(instrucionMemoria[3]);

                                    System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + "registro" + instrucionMemoria[2] + "\n");
                                    registros[numeroRegistroUsar2]= InstruccionesAritmeticas.operacionAdd2(registros[numeroRegistroUsar], registros[numeroRegistroUsar1]);
                                break;
                                case "B" :
                                    System.out.print("Ingrese el numero de registro al que se va carga y tiene el valor a usar ");
                                    instrucionMemoria[1] = teclado.nextLine();
                                    numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                                    System.out.print("Ingrese el numero de registro que contiene el otro valor");
                                    instrucionMemoria[2] = teclado.nextLine();
                                    numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);
                                    System.out.print("Ingrese el numero de registro que contiene el otro valor");
                                    instrucionMemoria[3] = teclado.nextLine();
                                    numeroRegistroUsar3 = Integer.parseInt(instrucionMemoria[3]);
                                    System.out.print("Ingrese el numero de registro donde desee guardar ");
                                    instrucionMemoria[4] = teclado.nextLine();
                                    numeroRegistroUsar4 = Integer.parseInt(instrucionMemoria[4]);

                                    System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + ",registro" + instrucionMemoria[2] + "registro" + instrucionMemoria[3] +  "\n");
                                    registros[numeroRegistroUsar4]= InstruccionesAritmeticas.operacionAdd3(registros[numeroRegistroUsar], registros[numeroRegistroUsar1],registros[numeroRegistroUsar3]);
                                break;
                                }
                             }
                                catch (Exception e) {
                                }    
                             break;
                        case "sub":
                            try {
                               System.out.print(" Realizar operacion SUB con\nA: 2 Operandos\nB: 3 Operandos\n");
                                instrucionMemoria[0] = teclado.nextLine();
                                switch (instrucionMemoria[0]) {
                                
                                case "A" :
                                    System.out.print("Ingrese el numero de registro al que se va carga y tiene el valor a usar ");
                                    instrucionMemoria[1] = teclado.nextLine();
                                    numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                                    System.out.print("Ingrese el numero de registro que contiene el otro valor");
                                    instrucionMemoria[2] = teclado.nextLine();
                                    numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);
                                    System.out.print("Ingrese el numero de registro donde desee guardar ");
                                    instrucionMemoria[3] = teclado.nextLine();
                                    numeroRegistroUsar2 = Integer.parseInt(instrucionMemoria[3]);

                                    System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + ",registro" + instrucionMemoria[2] + "\n");
                                    registros[numeroRegistroUsar2]= InstruccionesAritmeticas.operacionSub2(registros[numeroRegistroUsar], registros[numeroRegistroUsar1]);
                                break;
                                case "B" :
                                    System.out.print("Ingrese el numero de registro al que se va carga y tiene el valor a usar ");
                                    instrucionMemoria[1] = teclado.nextLine();
                                    numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                                    System.out.print("Ingrese el numero de registro que contiene el otro valor");
                                    instrucionMemoria[2] = teclado.nextLine();
                                    numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);
                                    System.out.print("Ingrese el numero de registro que contiene el otro valor");
                                    instrucionMemoria[3] = teclado.nextLine();
                                    numeroRegistroUsar3 = Integer.parseInt(instrucionMemoria[3]);
                                    System.out.print("Ingrese el numero de registro donde desee guardar ");
                                    instrucionMemoria[4] = teclado.nextLine();
                                    numeroRegistroUsar4 = Integer.parseInt(instrucionMemoria[4]);

                                    System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + ",registro" + instrucionMemoria[2] + "registro" + instrucionMemoria[3] + "\n");
                                    registros[numeroRegistroUsar4]= InstruccionesAritmeticas.operacionSub3(registros[numeroRegistroUsar], registros[numeroRegistroUsar1],registros[numeroRegistroUsar3]);
                                break;
                                }
                             }
                                catch (Exception e) {
                                }   
                            break;
                        case "mul":
                            try {
                               System.out.print(" Realizar operacion SUB con\nA: 2 Operandos\nB: 3 Operandos\n");
                                instrucionMemoria[0] = teclado.nextLine();
                                switch (instrucionMemoria[0]) {
                                
                                case "A" :
                                    System.out.print("Ingrese el numero de registro al que se va carga y tiene el valor a usar ");
                                    instrucionMemoria[1] = teclado.nextLine();
                                    numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                                    System.out.print("Ingrese el numero de registro que contiene el otro valor");
                                    instrucionMemoria[2] = teclado.nextLine();
                                    numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);
                                    System.out.print("Ingrese el numero de registro donde desee guardar ");
                                    instrucionMemoria[3] = teclado.nextLine();
                                    numeroRegistroUsar2 = Integer.parseInt(instrucionMemoria[3]);

                                    System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + ",registro" + instrucionMemoria[2] + "\n");
                                    registros[numeroRegistroUsar2]= InstruccionesAritmeticas.operacionMul2(registros[numeroRegistroUsar], registros[numeroRegistroUsar1]);
                                break;
                                case "B" :
                                    System.out.print("Ingrese el numero de registro al que se va carga y tiene el valor a usar ");
                                    instrucionMemoria[1] = teclado.nextLine();
                                    numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                                    System.out.print("Ingrese el numero de registro que contiene el otro valor");
                                    instrucionMemoria[2] = teclado.nextLine();
                                    numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);
                                    System.out.print("Ingrese el numero de registro que contiene el otro valor");
                                    instrucionMemoria[3] = teclado.nextLine();
                                    numeroRegistroUsar3 = Integer.parseInt(instrucionMemoria[3]);
                                    System.out.print("Ingrese el numero de registro donde desee guardar ");
                                    instrucionMemoria[4] = teclado.nextLine();
                                    numeroRegistroUsar4 = Integer.parseInt(instrucionMemoria[4]);

                                    System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + ",registro" + instrucionMemoria[2] + "registro" + instrucionMemoria[3] + "\n");
                                    registros[numeroRegistroUsar4]= InstruccionesAritmeticas.operacionMul3(registros[numeroRegistroUsar], registros[numeroRegistroUsar1],registros[numeroRegistroUsar3]);
                                break;
                                }
                             }
                                catch (Exception e) {
                                }    
                            
                   
                    }
                } catch (Exception e) {
                }
                break;
                //opcion logicas de arm
                case "logica":
                    try {
                    System.out.print("que operacion logica desea hacer\nand\nor\not\nxor");
                    instrucionMemoria[0] = teclado.nextLine();
                    switch (instrucionMemoria[0]) {
                        //Basicamente las 4 opciones hacen los mismo  .tratamos de simular esto:«and rd, rs», rd   rd AND rs y en las cuatro opciones llamamos a la clase instrucionesLogica 
                        case "and":
                            System.out.print("Ingrese el numero de registro al que se va carga y tiene el valor a usar ");
                            instrucionMemoria[1] = teclado.nextLine();
                            numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                            System.out.print("Ingrese el numero de registro que contiene el otro valor");
                            instrucionMemoria[2] = teclado.nextLine();
                            numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);

                            System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + ",registro" + instrucionMemoria[2] + "\n");
                            registros[numeroRegistroUsar]=InstrucionesLogicas.operacionAnd(registros[numeroRegistroUsar], registros[numeroRegistroUsar1]);
                            break;
                        case "or":
                            System.out.print("Ingrese el numero de registro al que se va carga y tiene el valor a usar ");
                            instrucionMemoria[1] = teclado.nextLine();
                            numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                            System.out.print("Ingrese el numero de registro que contiene el otro valor");
                            instrucionMemoria[2] = teclado.nextLine();
                            numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);

                            System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + ",registro" + instrucionMemoria[2] + "\n");
                            registros[numeroRegistroUsar]=InstrucionesLogicas.operacionOr(registros[numeroRegistroUsar], registros[numeroRegistroUsar1]);
                            
                            break;
                        case "not":
                            System.out.print("Ingrese el numero de registro al que se va carga  ");
                            instrucionMemoria[1] = teclado.nextLine();
                            numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                            System.out.print("Ingrese el numero de registro que contiene el otro valor a cambiar");
                            instrucionMemoria[2] = teclado.nextLine();
                            numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);

                            System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + ",registro" + instrucionMemoria[2] + "\n");
                            registros[numeroRegistroUsar]=InstrucionesLogicas.operacionNot( registros[numeroRegistroUsar1]);
                            
                            break;
                        case "xor":
                            System.out.print("Ingrese el numero de registro al que se va carga y tiene el valor a usar ");
                            instrucionMemoria[1] = teclado.nextLine();
                            numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                            System.out.print("Ingrese el numero de registro que contiene el otro valor");
                            instrucionMemoria[2] = teclado.nextLine();
                            numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);

                            System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + ",registro" + instrucionMemoria[2] + "\n");
                            registros[numeroRegistroUsar]=InstrucionesLogicas.operacionXor(registros[numeroRegistroUsar], registros[numeroRegistroUsar1]);
                            
                            break;
                    }
                } catch (Exception e) {
                }
                break;
                //hacer el numero negativo formato: neg rd, rs
                case "neg":
                    try {
                    System.out.print("Ingrese el numero de registro que dese usar ");
                    instrucionMemoria[1] = teclado.nextLine();
                    numeroRegistroUsar = Integer.parseInt(instrucionMemoria[1]);
                    System.out.print("Ingrese el numero del registro que desea hacer negativo");
                    instrucionMemoria[2] = teclado.nextLine();
                    numeroRegistroUsar1 = Integer.parseInt(instrucionMemoria[2]);
                    System.out.print("Instruciona ejecutar :" + instrucionMemoria[0] + " registro" + instrucionMemoria[1] + ",registro" + instrucionMemoria[2] + "\n");
                    registros[numeroRegistroUsar] = ConversionHexadecimal.ConvercionesConOperaciones(registros[numeroRegistroUsar1]);
                } catch (Exception e) {
                    System.out.print("error " + e.getMessage() + "\n");
                }
                break;
                //el case registro mostrara los valores que tienen los 16 registro en hexadecmal
                case "reg":
                    for (int x = 0; x < registros.length; x++) {
                        System.out.print("Registro" + x + " valor--> " + registros[x] + "\n");
                    }
                    break;
                //muestra la memoria y sus valores almacenados
                case "memoria":
                    for (int x = 0; x < memoryDump.length; x++) {
                        System.out.print("0x2007000" + x + "--> " + memoryDump[x] + "\n");
                    }
                    break;
                default:
                    System.out.print("<--------opcion invalida-------> \n");
                    break;
            }

            System.out.print("Desea continuar apachure enter o escriba salir ");
            condicionSalir = teclado.nextLine();
            System.out.print("ok continuaremos \n \n \n \n \n \n \n \n");
        } while (!condicionSalir.equals("salir"));
        //tranformacion de numero a binario en string
        //String binario = Long.toBinaryString(8);
        System.out.print("imprimir operacion and:   "
                + "");
        System.out.print(1111 & 1000);

    }

}
