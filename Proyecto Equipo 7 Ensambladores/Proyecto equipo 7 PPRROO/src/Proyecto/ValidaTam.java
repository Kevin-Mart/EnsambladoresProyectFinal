/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;




/**
 *
 * 
 */
public class ValidaTam {
    public ValidaTam(){
    }
    public int valida(String text){
        String ins=text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[]=ins.split(separadores);
        String pal= auxIns[0];
        String op1=auxIns[1].toUpperCase();
        String op2=auxIns[2].toUpperCase();
        if(op1.contains("AL")||op1.contains("BL")||op1.contains("CL")||op1.contains("DL")||op1.contains("AH")||op1.contains("BH")||op1.contains("CH")||op1.contains("DH")){
           int tam=validaOB(op2); 
           if(tam==1){
               return 1;
           }else{
               if(tam==-2){
                   return -2;
               }else{
                   if(tam==-3){
                       return -3;
                   }else{
                       return -1;
                   }
                   
               }
               
           }
        }else{
            if(op1.contains("AX")||op1.contains("BX")||op1.contains("CX")||op1.contains("DX")||op1.contains("SP")||op1.contains("BP")||op1.contains("SI")||op1.contains("DI")){
               int tam=validaDB(op2);
                if(tam==1){
                    return 1;
                }else{
                    if(tam==-2){
                        return -2;
                    }else{
                        if(tam==-3){
                       return -3;
                   }else{
                       return -1;
                   }
                    }
                }
            }
        }
        return -1;
    }
    
    public int validaOB(String op2){
        if(op2.contains("AL")||op2.contains("BL")||op2.contains("CL")||op2.contains("DL")||op2.contains("AH")||op2.contains("BH")||op2.contains("CH")||op2.contains("DH")){
           return 1; 
        }else{
            if(op2.endsWith("h")||op2.endsWith("H")){
                char aux;
                String Op="";
                for(int i=0;i<op2.length()-1;i++){
                    aux=op2.charAt(i);
                    Op=Op+aux;
                }
                int val=hexToDec(Op);
                if(val<=255){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                if(op2.endsWith("b")||op2.endsWith("B")){
                    char aux;
                    String Op="";
                    for(int i=0;i<op2.length()-1;i++){
                        aux=op2.charAt(i);
                        Op=Op+aux;
                    }
                    int vald=binario(Op);
                    if(vald<=255&&vald>=0){
                        return 1;
                    }else{
                        return -1;
                    }
                }else{
                    if(op2.contains("AX")||op2.contains("BX")||op2.contains("CX")||op2.contains("DX")||op2.contains("SP")||op2.contains("BP")||op2.contains("SI")||op2.contains("DI")){
                        return -2;
                    }else{
                        boolean flag=isNumeric(op2);
                            if(flag==true){
                                int numEntero = Integer.parseInt(op2);
                                if(numEntero<=255){
                                    return 1;
                                }else{
                                    return -1;
                                }
                                
                                
                            }else{
                                return -3;
                        }
                    }
                }
            }
        }
        
    }
    
    public int validaDB(String op2){
        if(op2.contains("AX")||op2.contains("BX")||op2.contains("CX")||op2.contains("DX")||op2.contains("SP")||op2.contains("BP")||op2.contains("SI")||op2.contains("DI")){
           return 1; 
        }else{
            if(op2.endsWith("h")||op2.endsWith("H")){
                char aux;
                String Op="";
                for(int i=0;i<op2.length()-1;i++){
                    aux=op2.charAt(i);
                    Op=Op+aux;
                }
                int val=hexToDec(Op);
                if(val<=65535&&val>=0){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                if(op2.endsWith("b")||op2.endsWith("B")){
                    char aux;
                    String Op="";
                    for(int i=0;i<op2.length()-1;i++){
                        aux=op2.charAt(i);
                        Op=Op+aux;
                    }
                    int vald=binario(Op);
                    if(vald<=65535&&vald>=0){
                        return 1;
                    }else{
                        return -1;
                    }
                }else{
                    if(op2.contains("AL")||op2.contains("BL")||op2.contains("CL")||op2.contains("DL")||op2.contains("AH")||op2.contains("BH")||op2.contains("CH")||op2.contains("DH")){
                        return -2;
                    }else{
                        boolean flag=isNumeric(op2);
                            if(flag==true){
                                int numEntero = Integer.parseInt(op2);
                                if(numEntero<=65535){
                                    return 1;
                                }else{
                                    return -1;
                                }
                                
                            }else{
                                return -3;
                        }
                    }
                }
            }
        }
        
    }
    
    public static int hexToDec(String hex){  
	String digits = "0123456789ABCDEF";  
	hex = hex.toUpperCase();  
	int val = 0;  
	for (int i = 0; i < hex.length(); i++){
	    char c = hex.charAt(i);  
	    int d = digits.indexOf(c);  
	    val = 16*val + d;  
	}  
	return val;  
    }
    
    public static int binario(String numero) { 
		long decimal;
		int exponente; 
		boolean esBinario; 
		String aux = "01bB";
	    exponente = 0;
	    decimal = 0;
		
		for (int i=0; i<numero.length(); i++)  
        {  
            char c = numero.charAt(i);  
            int d = aux.indexOf(c);  
            //val = 16*val + d;   
            
           	decimal = decimal + (d) * (int) Math.pow(2, exponente);
           	exponente++;
            
            
            
            
        }  
        return (int) decimal;
		
		
		 
	}
    
    private static boolean isNumeric(String cadena){
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }
}
