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
             int decimal = hexadecimalADecimal(hexadecimal);
             
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
        
        
        
        
         public static int caracterHexadecimalADecimal(char caracter) {
        switch (caracter) {
            case 'a':
                return 10;
            case 'b':
                return 11;
            case 'c':
                return 12;
            case 'd':
                return 13;
            case 'e':
                return 14;
            case 'f':
                return 15;
            default:
                return Integer.parseInt(String.valueOf(caracter));
        }
    }

    public static int hexadecimalADecimal(String hexadecimal) {
        int decimal = 0;
        // Saber en cuál posición de la cadena (de izquierda a derecha) vamos
        int potencia = 0;
        // Recorrer la cadena de derecha a izquierda
        for (int x = hexadecimal.length() - 1; x >= 0; x--) {
            int valor = caracterHexadecimalADecimal(hexadecimal.charAt(x));
            long elevado = (long) Math.pow(16, potencia) * valor;
            decimal += elevado;
            // Avanzar en la potencia
            potencia++;
        }
        return decimal;
    }
        
        
        
    }

