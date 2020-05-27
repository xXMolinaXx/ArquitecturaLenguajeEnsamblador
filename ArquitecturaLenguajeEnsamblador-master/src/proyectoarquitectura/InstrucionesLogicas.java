/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoarquitectura;

/**
 *
 * @author kjmol
 */
public class InstrucionesLogicas {
   
    
    public static String operacionAnd(String operando1,String operando2)
    {
    String resultado;
    int valor1=ConversionHexadecimal.ConvertirHexADecimal(operando1);
    int valor2=ConversionHexadecimal.ConvertirHexADecimal(operando2);
    int OperandoAND=valor2 & valor1;
    resultado=ConversionHexadecimal.ConvertirDecAHexadecial(OperandoAND);
    return resultado;
    }
    public static String operacionOr(String operando1,String operando2)
    {
    String resultado;
    int valor1=ConversionHexadecimal.ConvertirHexADecimal(operando1);
    int valor2=ConversionHexadecimal.ConvertirHexADecimal(operando2);
    int OperandoAND=valor2 | valor1;
    resultado=ConversionHexadecimal.ConvertirDecAHexadecial(OperandoAND);
    return resultado;
    }
    public static String operacionNot(String operando1)
    {
    String resultado;
    int valor1=ConversionHexadecimal.ConvertirHexADecimal(operando1);
    int OperandoAND=~valor1 ;
    resultado=ConversionHexadecimal.ConvertirDecAHexadecial(OperandoAND);
    return resultado;
    }
    public static String operacionXor(String operando1,String operando2)
    {
    String resultado;
    int valor1=ConversionHexadecimal.ConvertirHexADecimal(operando1);
    int valor2=ConversionHexadecimal.ConvertirHexADecimal(operando2);
    int OperandoAND=valor2 ^ valor1;
    resultado=ConversionHexadecimal.ConvertirDecAHexadecial(OperandoAND);
    return resultado;
    }
}
