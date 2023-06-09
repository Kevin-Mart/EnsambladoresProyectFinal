/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;




/**
 *
 * @author luisa
 */
public class ValidaDataS {
    ValidaDataS() {
    }
    
    
    public int cuentaC(String vEj[]){
        
        int tamIn=vEj.length;
        String aux="";
        String cad;
        char aux1;
        int contC=0;
        
        for(int i=0;i<vEj.length;i++){
            cad=vEj[i];
            for(int j=0;j<cad.length();j++){
                aux1=cad.charAt(j);
                if(aux1=='"'){
                
                    contC=contC+1;
                    aux=aux+aux1;
                    tamIn=tamIn-1;
                }
                if(contC==1){
                    aux=aux+aux1;
                    
                    
                }
            }
        }
        int tamF=tamIn;
        return tamF;
        
    }
    
    public int cuentaComillas(String vEj[]){
        int tamIn=vEj.length;
        String aux="";
        String cad;
        char aux1;
        int contC=0;
        
        for(int i=0;i<vEj.length;i++){
            cad=vEj[i];
            for(int j=0;j<cad.length();j++){
                aux1=cad.charAt(j);
                if(aux1=='\"'|| aux1=='\''){
                    contC=contC+1;
                }
            }
        }
        if (contC<2){
            return -1;
        }else{
            return 1;
        }
        
    }
    
    public int validaDB(String text){
        String ins=text.trim();
        String auxIns[]=ins.split(" ");
        int cont=0;
        String aux="";
        char auxC,auxD;
        
        int tam=cuentaC(auxIns);
        ValidaConstante constante = new ValidaConstante();
        if(tam==3){
          String sim=auxIns[0];
          String cons=auxIns[2];
          char valIni=sim.charAt(0);
          if(sim.equals("db")|| cons.equals("db")){
              return -1;//orden incorrecto
          }else{
              if(valIni== '1' ||valIni== '2' ||valIni== '2' ||valIni== '3' ||valIni== '4' ||valIni== '5' ||valIni== '6' ||valIni== '7' ||valIni== '8' ||valIni== '9' || valIni== '0' ){
                  return -2;//no puede iniciar con constante
              }else{
                  if(cons.endsWith("H")|| cons.endsWith("h")||cons.endsWith("b")||cons.endsWith("B")){
                      int flgCon=constante.identifica(cons);
                    if(flgCon==1){
                        return 1;
                    }else{
                        return -6; //constante no válida
                    }
                  }else{
                      if(cons.startsWith("\"")||cons.startsWith("\'")){
                          int flgC=cuentaComillas(auxIns);
                          if(flgC==1){
                              return 1;
                          }else{
                              return -7;
                          }
                      }else{
                          return 1;
                      }
                      
                  }               
                  
              }
              
          }
        }else{
            if(auxIns.length==4){
                String pal=auxIns[3];
                String var=auxIns[0];
                String cons=auxIns[2];
                char valIni=var.charAt(0);
                if(pal.contains("dup")){
                    int flagDup=validaDup(pal);
                    if(flagDup== 1){
                        if(valIni== '1' ||valIni== '2' ||valIni== '2' ||valIni== '3' ||valIni== '4' ||valIni== '5' ||valIni== '6' ||valIni== '7' ||valIni== '8' ||valIni== '9' ){
                            return -2;
                        }else{
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
                                    return -5;
                                }
                            } 
                        }//cierra else
                    }
                    if(flagDup== -1){
                        return -4;
                    }else{
                        if(flagDup== -2){
                            return -3;
                        }
                    }
                    
                }else{
                    return -3;
                }
            }
        }
    
        return 0;
     }
    
    public int validaDW(String text){
        String ins=text.trim();
        String auxIns[]=ins.split(" ");
        int cont=0;
        String aux="";
        char auxC,auxD;
        ValidaConstante constante = new ValidaConstante();
        int tam=cuentaC(auxIns);
        
        if(tam==3){
          String etiq=auxIns[0];
          String cons=auxIns[2];
          
          char valIni=etiq.charAt(0);
          if(etiq.equals("dw")|| cons.equals("dw")){
              return -1;
          }else{
              if(valIni== '1' ||valIni== '2' ||valIni== '2' ||valIni== '3' ||valIni== '4' ||valIni== '5' ||valIni== '6' ||valIni== '7' ||valIni== '8' ||valIni== '9' ){
                  return -2;
              }else{
                  if(cons.endsWith("H")|| cons.endsWith("h")||cons.endsWith("b")||cons.endsWith("B")){
                      int flgCon=constante.identifica(cons);
                    if(flgCon==1){
                        return 1;
                    }else{
                        return -6; //constante no válida
                    }
                  }else{
                      return 1;
                  } 
                  
              }//fin else
              
          }
        }else{
            if(auxIns.length==4){
                String pal=auxIns[3];
                String var=auxIns[0];
                String cons=auxIns[2];
                char valIni=var.charAt(0);
                if(pal.contains("dup")){
                    int flagDup=validaDup(pal);
                    if(flagDup== 1){
                        if(valIni== '1' ||valIni== '2' ||valIni== '2' ||valIni== '3' ||valIni== '4' ||valIni== '5' ||valIni== '6' ||valIni== '7' ||valIni== '8' ||valIni== '9' ){
                            return -2;
                        }else{
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
                                    return -5;
                                }
                            }
                        }//cierra else
                    }
                    if(flagDup== -1){
                        return -4;
                    }
                    
                }else{
                    return -3;
                }
            }
        }
    
        return 0;
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
    
    public int validaEqu(String text){
        String ins=text.trim();
        String auxIns[]=ins.split(" ");
        ValidaConstante constante = new ValidaConstante();
        
        String etiq=auxIns[0];
        String cons=auxIns[2];
        String auxEq=auxIns[1];
        char valIni=etiq.charAt(0);
        if(etiq.equals("equ")|| cons.equals("equ")){
            return -1; //orden incorrecto
        }else{
            if(valIni== '1' ||valIni== '2' ||valIni== '2' ||valIni== '3' ||valIni== '4' ||valIni== '5' ||valIni== '6' ||valIni== '7' ||valIni== '8' ||valIni== '9' ){
                  return -2; //nombre de variable no puede iniciar con constante
            }else{
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
            }//cierra else
        }
        return 0;
    }
    
    public int tamano(String ins){
        int tam=0;
        String comillas=concatena(ins);
        if(comillas.contains("\"")){
            tam=comillas.length()-1;
        }else{
            tam=comillas.length()-3;
        }
        
        return tam;
    }
    public String concatena(String vEj){
        String ins=vEj.trim();
        String auxIns[]=ins.split(" ");
        
        String aux="";
        String cad;
        char aux1;
        int contC=0;
        
        for(int i=0;i<auxIns.length;i++){
            cad=auxIns[i];
            for(int j=0;j<cad.length();j++){
                aux1=cad.charAt(j);
                if(aux1=='"' || aux1=='\''){
                
                    contC=contC+1;
                    aux=aux+aux1;
                    
                }
                if(contC==1){
                    aux=aux+aux1;
                    
                    
                }
            }
        }
        
        return aux;
        
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
