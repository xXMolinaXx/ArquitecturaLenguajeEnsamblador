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

public  class ConversionHexadecimal  {
    
    
        public static String ConvertirDecAHexadecial(int decimal)
        {
            // Conversion de decimal a hexadecimal 
             String hexadecimal = Integer.toHexString(decimal);
             return hexadecimal;            
        }
        
        public static int ConvertirHexADecimal(String hexadecimal)
        {
            // Conversion de decimal a hexadecimal 
             int decimal = Integer.parseInt(hexadecimal, 16);
             return decimal;            
        }
        
        public static String ConvercionesConOperaciones(String hexadecimal)
        {
            // Conversion de decimal a hexadecimal 
             int decimal = Integer.parseInt(hexadecimal, 16);
             decimal=-1*decimal;
             ConvertirDecAHexadecial(decimal);
             hexadecimal = Integer.toHexString(decimal);
             return hexadecimal;           
        }
        
        public static int ConvercionesConOperaciones(String hexadecimal,int offset)
        {
            // Conversion de decimal a hexadecimal 
             int decimal = Integer.parseInt(hexadecimal, 16);
             decimal+=offset;
             return decimal;           
        }
    }

