package Proyecto;



/**
 *
 * @author 
 */
public class ValidaConstante {
    
    public ValidaConstante(){
    
    }
    
    public int identifica(String cons){
        int flg=0;
        if(cons.endsWith("h")||cons.endsWith("H")){
            flg=validaHex(cons);
        }else{
            if(cons.endsWith("b")|| cons.endsWith("B")){
                flg=validaBinario(cons);
            }
        }
        return flg;
    }
    
    public int validaHex(String cons){
        boolean auxNumeroHex=false;
        if(cons.charAt(0) == '0'){
            for (int j = 0; j < cons.length(); j++) {
                    if (cons.charAt(j) == '1' || cons.charAt(j) == '2' || cons.charAt(j) == '3' || cons.charAt(j) == '4' || cons.charAt(j) == '5' || cons.charAt(j) == '6' || cons.charAt(j) == '7' || cons.charAt(j) == '8' || cons.charAt(j) == '9' || cons.charAt(j) == '0' || cons.charAt(j) == 'A' || cons.charAt(j) == 'B' || cons.charAt(j) == 'C' || cons.charAt(j) == 'D' || cons.charAt(j) == 'E' || cons.charAt(j) == 'F' || cons.charAt(j) == 'H' || cons.charAt(j)=='h' || cons.charAt(j) == 'a' || cons.charAt(j) == 'b' || cons.charAt(j) == 'c' || cons.charAt(j) == 'd' || cons.charAt(j) == 'e' || cons.charAt(j) == 'f') {
                    	auxNumeroHex = true;
                    } else {
                    	auxNumeroHex = false;
                        break;
                    }
                }
        }
        if(auxNumeroHex==true){
            return 1;
        }else{
            return 0;
        }
    }
    
    public int validaBinario(String cons){
        boolean auxNumeroB=false;
        if (cons.charAt(0) == '0' || cons.charAt(0) == '1' ) {
                for (int j = 0; j < cons.length(); j++) {
                    if (cons.charAt(j) == '0'|| cons.charAt(j) == '1' || cons.charAt(j) == 'B' ||cons.charAt(j) == 'b' ) {
                        auxNumeroB = true;
                    } else {
                        auxNumeroB = false;
                        break;
                    }
                }
        }
        
        if(auxNumeroB==true){
            return 1;
        }else{
            return 0;
        }
    }
    
}
