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
public class ValidaStack {
     ValidaStack() {
    }
    public int validaDws(String text){
        String ins=text.trim();
        String auxIns[]=ins.split(" ");
        int tam=0;
        for(int i=0;i<auxIns.length;i++){
            String cadena=auxIns[i];
            if((cadena != null) && (!cadena.equals(""))){
                tam=tam+1;
            }
        }
        
        if(tam==3){
            String insDW=auxIns[0];
            String auxDUP=auxIns[0];
            String cons=auxIns[2];
            ValidaConstante constante = new ValidaConstante();
            if(auxDUP.equals("dw")|| cons.equals("dw")){
              return -1;
            }else{
                if(auxDUP.contains("dup")){
                    int flagDup = validaDup(auxDUP);
                    if(flagDup==1){
                       if(cons.endsWith("H")|| cons.endsWith("h")||cons.endsWith("b")||cons.endsWith("B")){
                          int flgCon=constante.identifica(cons);
                          if(flgCon==1){
                              return 1;
                          }
                        }else{
                            boolean flag=isNumeric(cons);
                            if(flag==true){
                                return 1;
                            }else{
                                return -3;
                            }
                        } 
                    }//if flg dup
                    if(flagDup==-1){
                        return -4;
                    }
                }
            }
        }
        return -2; //error de sintaxis, faltan/sobran parametros
        
    }
    
    public int validaDup(String pal){
        if(pal.charAt(0)=='D' || pal.charAt(0)=='d'){
            if(pal.charAt(1)=='U' || pal.charAt(1)=='u'){
                if(pal.charAt(2)=='P' || pal.charAt(2)=='p'){
                    if(pal.charAt(3)=='(' ){
                        if(pal.charAt(pal.length()-1)==')'){
                            return 1;
                        }else{
                            return -1;
                        }                   
                    
                    }else{
                        if(pal.charAt(3)!='('&&pal.charAt(4)=='('){
                            return -3;
                        }
                        return -1;
                    }
                }
            }
        }
        return 0;
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

