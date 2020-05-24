/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoarquitectura;

/**
 *
 * @author itali
 */



import java.util.Scanner;

public class InstruccionesAritmeticas {
    
    public static String operacionAdd3(String operando1,String operando2, String operando3)
    {
    String resultado;
    int valor1=ConversionHexadecimal.ConvertirHexADecimal(operando1);
    int valor2=ConversionHexadecimal.ConvertirHexADecimal(operando2);
    int valor3=ConversionHexadecimal.ConvertirHexADecimal(operando3);
    int OperandoSum= (valor1 + valor2)+ valor3;
    resultado=ConversionHexadecimal.ConvertirDecAHexadecial(OperandoSum);
    return resultado;

    }
    
    public static String operacionAdd2(String operando1,String operando2)
    {
    String resultado;
    int valor1=ConversionHexadecimal.ConvertirHexADecimal(operando1);
    int valor2=ConversionHexadecimal.ConvertirHexADecimal(operando2);
    int OperandoSum= valor1 + valor2;
    resultado=ConversionHexadecimal.ConvertirDecAHexadecial(OperandoSum);
    return resultado;

    }
    
    public static String operacionSub2(String operando1,String operando2)
    {
    String resultado;
    int valor1=ConversionHexadecimal.ConvertirHexADecimal(operando1);
    int valor2=ConversionHexadecimal.ConvertirHexADecimal(operando2);   
    int OperandoSub=valor1 - valor2;
    resultado=ConversionHexadecimal.ConvertirDecAHexadecial(OperandoSub);
    return resultado;
    }
    
    public static String operacionSub3(String operando1,String operando2,String operando3)
    {
    String resultado;
    int valor1=ConversionHexadecimal.ConvertirHexADecimal(operando1);
    int valor2=ConversionHexadecimal.ConvertirHexADecimal(operando2);
    int valor3=ConversionHexadecimal.ConvertirHexADecimal(operando3);
    
    int OperandoSub= (valor1 - valor2)- valor3;
    resultado=ConversionHexadecimal.ConvertirDecAHexadecial(OperandoSub);
    return resultado;
    }
    
    public static String operacionMul3(String operando1,String operando2,String operando3)
    {
    String resultado;
    int valor1=ConversionHexadecimal.ConvertirHexADecimal(operando1);
    int valor2=ConversionHexadecimal.ConvertirHexADecimal(operando2);
    int valor3=ConversionHexadecimal.ConvertirHexADecimal(operando3);
    
    int OperandoSub= (valor1 * valor2) * valor3;
    resultado=ConversionHexadecimal.ConvertirDecAHexadecial(OperandoSub);
    return resultado;
    }
    
    public static String operacionMul2(String operando1,String operando2)
    {
    String resultado;
    int valor1=ConversionHexadecimal.ConvertirHexADecimal(operando1);
    int valor2=ConversionHexadecimal.ConvertirHexADecimal(operando2);
    int OperandoMul=valor2 * valor1;
    resultado=ConversionHexadecimal.ConvertirDecAHexadecial(OperandoMul);
    return resultado;
    }
    
    
}
