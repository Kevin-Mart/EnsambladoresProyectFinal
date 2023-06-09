 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import javax.swing.JTable;

/**
 *
 * @author luisa
 */
public class Codifica extends pnlSimbolos {
    JTable tablaSim =new JTable();
    public Codifica(JTable TabSim){
        tablaSim=TabSim;
    }
    public Codifica(){}
    public String codigo(String ins){
        String cod="";
        return cod;
    }
   
    public String codSaltos(String ins){
        
        String cod="";
        if(ins.equals("JGE")){
            cod="74";
        }else{
            if(ins.equals("JNA")){
                cod="70";
            }else{
                if(ins.equals("JG")){
                    cod="7F";
                }else{
                    if(ins.equals("JNS")){
                        cod="7B";
                    }else{
                        if(ins.equals("JS")){
                                cod="77";
                        }else{
                            if(ins.equals("JNA")){
                                cod="73";
                            }  
                        }  
                    }  
                }
            }
        }  
        return cod;
    }
    public String codIMUL(String text){
        String ins=text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[]=ins.split(separadores);
        String op1=auxIns[1];
        String cod=codIP1(op1);
        return cod;
    }

   	    public String codIP1(String text){
        text=text.toUpperCase();
        String codifica="";
        if(text.equals("AX")||text.equals("AL")){
            codifica="EDD1  / EFD1 ";
        }else{
            if(text.equals("BX")||text.equals("BL")){
                codifica="EDD7  /  EFD7";
            }else{
                if(text.equals("CX")||text.equals("CL")){
                    codifica="EDD3  / EFD3 ";
                }else{
                   if(text.equals("DX")||text.equals("DL")){
                        codifica="EDD5  / EFD5 ";
                    }else{
                       if(text.equals("SP")||text.equals("AH")){
                        codifica="EDD9  / EFD9 ";
                        }else{
                           if(text.equals("BP")||text.equals("BH")){
                               codifica="EDDF  / EFDF ";
                            }else{
                               if(text.equals("SI")||text.equals("CH")){
                                 codifica="EDDD  / EFDD ";
                                }else{
                                 if(text.equals("DI")||text.equals("DH")){
                                    codifica="EDDF  / EFDF ";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
        return codifica;
    }
    
    public String codDEC(String text){
        String ins=text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[]=ins.split(separadores);
        String op1=auxIns[1];
        String cod=codOPD1(op1);
        
        return cod;
    }
    public String codDIV(String text){
        String ins=text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[]=ins.split(separadores);
        String op1=auxIns[1];
        String cod=codDIVP1(op1);
        return cod;
    }

   public String codDIVP1(String text){
        text=text.toUpperCase();
        String codifica="";
       if(text.equals("AX")){
            codifica="F7F0";
        }else{
            if(text.equals("BX")){
                codifica="F7F3";// 
            }else{
                if(text.equals("CX")){
                    codifica="F7F1";
                }else{
                   if(text.equals("DX")){
                        codifica="F7F2";
                    }else{
                       if(text.equals("SP")){
                        codifica="F7F4";
                        }else{
                           if(text.equals("BP")){
                               codifica="F7F5";
                            }else{
                               if(text.equals("SI")){
                                 codifica="F7F6";
                                }else{
                                    if(text.equals("DI")){
                                    codifica="F7F7";
                                    }else{
                                       if(text.equals("AL")){
                                        codifica="F6F0";
                                        }else{
                                            if(text.equals("CL")){
                                            codifica="F6F1";
                                            }else{
                                                if(text.equals("DL")){
                                                codifica="F6F";
                                                }else{
                                                    if(text.equals("BL")){
                                                    codifica="F6F3";
                                                    }else{
                                                        if(text.equals("AH")){
                                                        codifica="F6F4";
                                                        }else{
                                                            if(text.equals("CH")){
                                                            codifica="F6F5";
                                                            }else{
                                                                if(text.equals("DH")){
                                                                codifica="F6F6";
                                                                }else{
                                                                    if(text.equals("BH")){
                                                                    codifica="F6F7";
                                                                    }
                                                                }  
                                                            }  
                                                        }  
                                                    }  
                                                }  
                                            }  
                                        }  
                                    }    
                                }
                            }
                        }
                    }
                }
            }
        }
        return codifica;
    }
    
    public String codIDIV(String text){
        String ins=text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[]=ins.split(separadores);
        String op1=auxIns[1];
        String cod=codIDIVP1(op1);
        return cod;
    }

   	    public String codIDIVP1(String text){
        text=text.toUpperCase();
        String codifica="";
       if(text.equals("AX")){
            codifica="F7F8";
        }else{
            if(text.equals("BX")){
                codifica="F7FB";// 
            }else{
                if(text.equals("CX")){
                    codifica="F7F9";
                }else{
                   if(text.equals("DX")){
                        codifica="F7FA";
                    }else{
                       if(text.equals("SP")){
                        codifica="F7FC";
                        }else{
                           if(text.equals("BP")){
                               codifica="F7FD";
                            }else{
                               if(text.equals("SI")){
                                 codifica="F7FE";
                                }else{
                                    if(text.equals("DI")){
                                    codifica="F7FF";
                                    }else{
                                       if(text.equals("AL")){
                                        codifica="F6F8";
                                        }else{
                                            if(text.equals("CL")){
                                            codifica="F6F9";
                                            }else{
                                                if(text.equals("DL")){
                                                codifica="F6FA";
                                                }else{
                                                    if(text.equals("BL")){
                                                    codifica="F6FB";
                                                    }else{
                                                        if(text.equals("AH")){
                                                        codifica="F6FC";
                                                        }else{
                                                            if(text.equals("CH")){
                                                            codifica="F6FD";
                                                            }else{
                                                                if(text.equals("DH")){
                                                                codifica="F6FE";
                                                                }else{
                                                                    if(text.equals("BH")){
                                                                    codifica="F6FF";
                                                                    }
                                                                }  
                                                            }  
                                                        }  
                                                    }  
                                                }  
                                            }  
                                        }  
                                    }    
                                }
                            }
                        }
                    }
                }
            }
        }
        return codifica;
    }
    public String codNEG(String text){
        String ins=text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[]=ins.split(separadores);
        String op1=auxIns[1];
        String cod=codNEGP1(op1);
        return cod;
    }

   	    public String codNEGP1(String text){
        text=text.toUpperCase();
        String codifica="";
        if(text.equals("AX")){
            codifica="F7D8";
        }else{
            if(text.equals("BX")){
                codifica="F7DB";// 
            }else{
                if(text.equals("CX")){
                    codifica="F7D9";
                }else{
                   if(text.equals("DX")){
                        codifica="F7DA";
                    }else{
                       if(text.equals("SP")){
                        codifica="F7DC";
                        }else{
                           if(text.equals("BP")){
                               codifica="F7DD";
                            }else{
                               if(text.equals("SI")){
                                 codifica="F7DE";
                                }else{
                                    if(text.equals("DI")){
                                    codifica="F7DF";
                                    }else{
                                       if(text.equals("AL")){
                                        codifica="F6D8";
                                        }else{
                                            if(text.equals("CL")){
                                            codifica="F6D9";
                                            }else{
                                                if(text.equals("DL")){
                                                codifica="F6DA";
                                                }else{
                                                    if(text.equals("BL")){
                                                    codifica="F6DB";
                                                    }else{
                                                        if(text.equals("AH")){
                                                        codifica="F6DC";
                                                        }else{
                                                            if(text.equals("CH")){
                                                            codifica="F6DD";
                                                            }else{
                                                                if(text.equals("DH")){
                                                                codifica="F6DE";
                                                                }else{
                                                                    if(text.equals("BH")){
                                                                    codifica="F6DF";
                                                                    }
                                                                }  
                                                            }  
                                                        }  
                                                    }  
                                                }  
                                            }  
                                        }  
                                    }    
                                }
                            }
                        }
                    }
                }
            }
        }
        return codifica;
    }
    public String codNOT(String text){
        String ins=text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[]=ins.split(separadores);
        String op1=auxIns[1];
        String cod=codNEGP1(op1);
        return cod;
    }

   	    public String codNOTP1(String text){
        text=text.toUpperCase();
        String codifica="";
        if(text.equals("AX")){
            codifica="F7D0";
        }else{
            if(text.equals("BX")){
                codifica="F7D3";// 
            }else{
                if(text.equals("CX")){
                    codifica="F7D1";
                }else{
                   if(text.equals("DX")){
                        codifica="F7D2";
                    }else{
                       if(text.equals("SP")){
                        codifica="F7D4";
                        }else{
                           if(text.equals("BP")){
                               codifica="F7D5";
                            }else{
                               if(text.equals("SI")){
                                 codifica="F7D6";
                                }else{
                                    if(text.equals("DI")){
                                    codifica="F7D7";
                                    }else{
                                       if(text.equals("AL")){
                                        codifica="F6D0";
                                        }else{
                                            if(text.equals("CL")){
                                            codifica="F6D1";
                                            }else{
                                                if(text.equals("DL")){
                                                codifica="F6D2";
                                                }else{
                                                    if(text.equals("BL")){
                                                    codifica="F6D3";
                                                    }else{
                                                        if(text.equals("AH")){
                                                        codifica="F6D4";
                                                        }else{
                                                            if(text.equals("CH")){
                                                            codifica="F6D5";
                                                            }else{
                                                                if(text.equals("DH")){
                                                                codifica="F6D6";
                                                                }else{
                                                                    if(text.equals("BH")){
                                                                    codifica="F6D7";
                                                                    }
                                                                }  
                                                            }  
                                                        }  
                                                    }  
                                                }  
                                            }  
                                        }  
                                    }    
                                }
                            }
                        }
                    }
                }
            }
        }
        return codifica;
    }
            
    public String codLEA(String text){
        
        String ins=text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[]=ins.split(separadores);
        String op1=auxIns[1];
        String op2=auxIns[2];
        String cod1=codOPL1(op1);
        if(op2.endsWith("h")){
               String cod2= hex(op2); 
               cod1=cod1+cod2;
            }else{
                boolean numeric=isNumeric(op2);
                if(numeric==true){
                    String cod2=dec(op2);
                    cod1=cod1+cod2;
                }else{
                   if(op2.endsWith("B")||op2.endsWith("b")){
                               String cod2= bin(op2);
                               cod1=cod1+cod2;
                   }else{
                       String val=buscaVar(op2);
                   
                        boolean num=isNumeric(val);
                        if(num==true){
                            String cod2=dec(val);
                            cod2=cod2.toUpperCase();
                            cod1=cod1+cod2;
                        }else{
                            if(val.endsWith("h")||val.endsWith("H")){
                                String cod2= hex(val); 
                                cod1=cod1+cod2;
                            }else{
                                if(val.endsWith("B")||val.endsWith("b")){
                                    String cod2= bin(val);
                                    cod1=cod1+cod2;
                                }
                            }
                        }
                   }                    
                }
            }
        
        return cod1;
    }
    public String codROR(String text){
        String ins=text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[]=ins.split(separadores);
        String ins1=auxIns[0];
        String op1=auxIns[1];
        String op2=auxIns[2];
        String cod1="";
        String auxH="";
        ValidaDataS tamVar=new ValidaDataS();
        if(op1.equals("AX")||op1.equals("BX")||op1.equals("CX")||op1.equals("DX")||op1.equals("SP")||op1.equals("BP")||op1.equals("SI")||op1.equals("DI")){
            cod1=codOPR1(op1);
            if(op2.endsWith("h")){
               String cod2= hex(op2); 
               cod1=cod1+cod2;
            }else{
                boolean numeric=isNumeric(op2);
                if(numeric==true){
                    String cod2=dec(op2);
                    cod1=cod1+cod2;
                }else{
                   if(op2.endsWith("B")||op2.endsWith("b")){
                               String cod2= bin(op2);
                               cod1=cod1+cod2;
                   }else{
                       String val=buscaVar(op2);
                   
                        boolean num=isNumeric(val);
                        if(num==true){
                            String cod2=dec(val);
                            cod2=cod2.toUpperCase();
                            cod1=cod1+cod2;
                        }else{
                            if(val.endsWith("h")||val.endsWith("H")){
                                String cod2= hex(val); 
                                cod1=cod1+cod2;
                            }else{
                                if(val.endsWith("B")||val.endsWith("b")){
                                    String cod2= bin(val);
                                    cod1=cod1+cod2;
                                }
                            }
                        }
                   }                    
                }
            }
        }else{
            if(op1.equals("AL")||op1.equals("BL")||op1.equals("CL")||op1.equals("DL")||op1.equals("AH")||op1.equals("BH")||op1.equals("CH")||op1.equals("DH")){
                cod1=codOPR0(op1);
                if(op2.endsWith("h")){
                    String cod2= hex(op2); 
                    cod1=cod1+cod2;
                }else{
                    boolean numeric=isNumeric(op2);
                    if(numeric==true){
                        String cod2=dec(op2);
                        cod1=cod1+cod2;
                    }else{
                       if(op2.endsWith("B")||op2.endsWith("b")){
                                   String cod2= bin(op2);
                                   cod1=cod1+cod2;
                       }else{
                           String val=buscaVar(op2);

                            boolean num=isNumeric(val);
                            if(num==true){
                                String cod2=dec(val);
                                cod2=cod2.toUpperCase();
                                cod1=cod1+cod2;
                            }else{
                                if(val.endsWith("h")||val.endsWith("H")){
                                    String cod2= hex(val); 
                                    cod1=cod1+cod2;
                                }else{
                                    if(val.endsWith("B")||val.endsWith("b")){
                                        String cod2= bin(val);
                                        cod1=cod1+cod2;
                                    }
                                }
                            }
                       }                    
                    }
                }
            }
        
        }
        return cod1;
    }
    
    public String codAND(String text){
        String ins=text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[]=ins.split(separadores);
        String ins1=auxIns[0];
        String op1=auxIns[1];
        String op2=auxIns[2];
        String cod="";
        String auxH="";
        ValidaDataS tamVar=new ValidaDataS();
        if(op1.equals("AX")||op1.equals("BX")||op1.equals("CX")||op1.equals("DX")||op1.equals("SP")||op1.equals("BP")||op1.equals("SI")||op1.equals("DI")){
            if(op2.equals("AX")||op2.equals("BX")||op2.equals("CX")||op2.equals("DX")||op2.equals("SP")||op2.equals("BP")||op2.equals("SI")||op2.equals("DI")){
                cod= ANDRegReg(op1,op2);
            }/*Reg, Reg*/else{
                if(op2.endsWith("h")||op2.endsWith("H")||op2.endsWith("b")||op2.endsWith("B")||isNumeric(op2)==true){
                    String cod1= ANDRegInm8(op1);
                    String cod2="";
                    if(op2.endsWith("h")){
                        cod2= hex(op2); 
                    }else{
                        boolean numeric=isNumeric(op2);
                        if(numeric==true){
                            cod2=dec(op2);
                        }else{
                            if(op2.endsWith("B")||op2.endsWith("b")){
                                cod2= bin(op2);
                            }
                        }
                    
                    cod=cod1+cod2;
                }
            }/*op2 inmediatp*/
            
        }/*destino es registro 8 bits*/
        }else{
            if(op1.equals("AL")||op1.equals("BL")||op1.equals("CL")||op1.equals("DL")||op1.equals("AH")||op1.equals("BH")||op1.equals("CH")||op1.equals("DH")){
                if(op2.equals("AL")||op2.equals("BL")||op2.equals("CL")||op2.equals("DL")||op2.equals("AH")||op2.equals("BH")||op2.equals("CH")||op2.equals("DH")){
                    cod= ANDRegReg8(op1,op2);
                }/*Reg, Reg*/else{
                    if(op2.endsWith("h")||op2.endsWith("H")||op2.endsWith("b")||op2.endsWith("B")||isNumeric(op2)==true){
                    String cod1= ANDRegInm8(op1);
                    String cod2="";
                    if(op2.endsWith("h")){
                        cod2= hex(op2); 
                    }else{
                        boolean numeric=isNumeric(op2);
                        if(numeric==true){
                            cod2=dec(op2);
                        }else{
                            if(op2.endsWith("B")||op2.endsWith("b")){
                                cod2= bin(op2);
                            }
                        }
                    
                    cod=cod1+cod2;
                }
            }/*op2 inmediatp*/
                }//else rr           
            }/*8 bits*/
        }
        return cod;
    }
    public String codTEST(String text){
        String ins=text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[]=ins.split(separadores);
        String ins1=auxIns[0];
        String op1=auxIns[1];
        String op2=auxIns[2];
        String cod="";
        String auxH="";
        ValidaDataS tamVar=new ValidaDataS();
        if(op1.equals("AX")||op1.equals("BX")||op1.equals("CX")||op1.equals("DX")||op1.equals("SP")||op1.equals("BP")||op1.equals("SI")||op1.equals("DI")){
            if(op2.equals("AX")||op2.equals("BX")||op2.equals("CX")||op2.equals("DX")||op2.equals("SP")||op2.equals("BP")||op2.equals("SI")||op2.equals("DI")){
                cod= TESTRegReg(op1,op2);
            }/*Reg, Reg*/else{
                if(op2.endsWith("h")||op2.endsWith("H")||op2.endsWith("b")||op2.endsWith("B")||isNumeric(op2)==true){
                    String cod1= ANDRegInm8(op1);
                    String cod2="";
                    if(op2.endsWith("h")){
                        cod2= hex(op2); 
                    }else{
                        boolean numeric=isNumeric(op2);
                        if(numeric==true){
                            cod2=dec(op2);
                        }else{
                            if(op2.endsWith("B")||op2.endsWith("b")){
                                cod2= bin(op2);
                            }
                        }
                    
                    cod=cod1+cod2;
                }
            }/*op2 inmediatp*/
            
        }/*destino es registro 8 bits*/
        }else{
            if(op1.equals("AL")||op1.equals("BL")||op1.equals("CL")||op1.equals("DL")||op1.equals("AH")||op1.equals("BH")||op1.equals("CH")||op1.equals("DH")){
                if(op2.equals("AL")||op2.equals("BL")||op2.equals("CL")||op2.equals("DL")||op2.equals("AH")||op2.equals("BH")||op2.equals("CH")||op2.equals("DH")){
                    cod= TESTRegReg8(op1,op2);
                }/*Reg, Reg*/else{
                    if(op2.endsWith("h")||op2.endsWith("H")||op2.endsWith("b")||op2.endsWith("B")||isNumeric(op2)==true){
                    String cod1= ANDRegInm8(op1);
                    String cod2="";
                    if(op2.endsWith("h")){
                        cod2= hex(op2); 
                    }else{
                        boolean numeric=isNumeric(op2);
                        if(numeric==true){
                            cod2=dec(op2);
                        }else{
                            if(op2.endsWith("B")||op2.endsWith("b")){
                                cod2= bin(op2);
                            }
                        }
                    
                    cod=cod1+cod2;
                }
            }/*op2 inmediatp*/
                }//else rr           
            }/*8 bits*/
        }
        return cod;
    }
    public String direccion(int num){
        String direccion="";
        direccion=Integer.toHexString(num);
        direccion=direccion.toUpperCase();
        while(direccion.length()<4){
            direccion="0"+direccion;
        }
        return direccion;
    }
        
    public String codOPR1(String text){
        String codifica="";
        if(text.equals("AX")){
            codifica="C0F8";
        }else{
            if(text.equals("BX")){
                codifica="C0FB";
            }else{
                if(text.equals("CX")){
                    codifica="C0F9";
                }else{
                   if(text.equals("DX")){
                        codifica="C0FA";
                    }else{
                       if(text.equals("SP")){
                        codifica="C0FC";
                        }else{
                           if(text.equals("BP")){
                               codifica="C0FD";
                            }else{
                               if(text.equals("SI")){
                                 codifica="C0FE";
                                }else{
                                 if(text.equals("DI")){
                                    codifica="C0FF";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
        return codifica;
    }
    
    public String codOPR0(String text){
        String codifica="";
        if(text.equals("AL")){
            codifica="D2C8";
        }else{
            if(text.equals("BL")){
                codifica="D2CB";
            }else{
                if(text.equals("CL")){
                    codifica="D2C9";
                }else{
                   if(text.equals("DL")){
                        codifica="D2CA";
                    }else{
                       if(text.equals("AH")){
                        codifica="D2CC";
                        }else{
                           if(text.equals("CH")){
                               codifica="D2CD";
                            }else{
                               if(text.equals("DH")){
                                 codifica="D2CE";
                                }else{
                                 if(text.equals("BH")){
                                    codifica="D2CF";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
        return codifica;
    
            
    }
    
    public String codOPD1(String text){
        text=text.toUpperCase();
        String codifica="";
        if(text.equals("AX")){
            codifica="0048";
        }else{
            if(text.equals("BX")){
                codifica="004B";// 
            }else{
                if(text.equals("CX")){
                    codifica="0049";
                }else{
                   if(text.equals("DX")){
                        codifica="004A";
                    }else{
                       if(text.equals("SP")){
                        codifica="004C";
                        }else{
                           if(text.equals("BP")){
                               codifica="004D";
                            }else{
                               if(text.equals("SI")){
                                 codifica="004E";
                                }else{
                                    if(text.equals("DI")){
                                    codifica="004F";
                                    }else{
                                       if(text.equals("AL")){
                                        codifica="FEC8";
                                        }else{
                                            if(text.equals("CL")){
                                            codifica="FEC9";
                                            }else{
                                                if(text.equals("DL")){
                                                codifica="FECA";
                                                }else{
                                                    if(text.equals("BL")){
                                                    codifica="FECB";
                                                    }else{
                                                        if(text.equals("AH")){
                                                        codifica="FECC";
                                                        }else{
                                                            if(text.equals("CH")){
                                                            codifica="FECD";
                                                            }else{
                                                                if(text.equals("DH")){
                                                                codifica="FECE";
                                                                }else{
                                                                    if(text.equals("BH")){
                                                                    codifica="FECF";
                                                                    }
                                                                }  
                                                            }  
                                                        }  
                                                    }  
                                                }  
                                            }  
                                        }  
                                    }    
                                }
                            }
                        }
                    }
                }
            }
        }
        return codifica;
    }
    
    
    public String codOPL1(String text){
        text=text.toUpperCase();
        String codifica="";
        if(text.equals("AX")||text.equals("AL")){
            codifica="8DC0";
        }else{
            if(text.equals("BX")||text.equals("BL")){
                codifica="8DDB";
            }else{
                if(text.equals("CX")||text.equals("CL")){
                    codifica="8DC9";
                }else{
                   if(text.equals("DX")||text.equals("DL")){
                        codifica="8DD2";
                    }else{
                       if(text.equals("SP")||text.equals("AH")){
                        codifica="8DE4";
                        }else{
                           if(text.equals("BP")||text.equals("BH")){
                               codifica="8DED";
                            }else{
                               if(text.equals("SI")||text.equals("CH")){
                                 codifica="8DF6";
                                }else{
                                 if(text.equals("DI")||text.equals("DH")){
                                    codifica="8DFF";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
        return codifica;
    }
    
    public String ANDRegInm(String op1){
        String cod="";
        
        
        if(op1.equals("AX")){
            cod="FFFF81D0";
        }else{
            if(op1.equals("BX")){
                cod="FFFF81D3";
            }else{
                if(op1.equals("CX")){
                    cod="FFFF81D1";
                }else{
                   if(op1.equals("DX")){
                        cod="FFFF81D2";
                    }else{
                       if(op1.equals("SP")){
                            cod="FFFF81D4";
                        }else{
                           if(op1.equals("BP")){
                               cod="FFFF81D5";
                            }else{
                               if(op1.equals("SI")){
                                 cod="FFFF81D6";
                                }else{
                                 if(op1.equals("DI")){
                                    cod="FFFF81D7";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
        
    public String ANDRegReg(String op1,String op2 ){
        String cod="";
        String cod2="";
        if(op1.equals("AX")){
            cod2= RROp2A(op2);
            cod="23"+cod2;
        }else{
            if(op1.equals("BX")){
                cod2= RROp2B(op2);
                cod="23"+cod2;
            }else{
                if(op1.equals("CX")){
                    cod2= RROp2C(op2);
                    cod="23"+cod2;
                }else{
                   if(op1.equals("DX")){
                        cod2= RROp2D(op2);
                        cod="23"+cod2;
                    }else{
                       if(op1.equals("SP")){
                        cod2= RROp2SP(op2);
                        cod="23"+cod2;
                        }else{
                           if(op1.equals("BP")){
                               cod2= RROp2BP(op2);
                               cod="23"+cod2;
                            }else{
                               if(op1.equals("SI")){
                                 cod2= RROp2SI(op2);
                                 cod="23"+cod2;
                                }else{
                                 if(op1.equals("DI")){
                                    cod2= RROp2DI(op2);
                                    cod="23"+cod2;
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String TESTRegReg(String op1,String op2 ){
        String cod="";
        String cod2="";
        if(op1.equals("AX")){
            cod2= RROp2A(op2);
            cod="85"+cod2;
        }else{
            if(op1.equals("BX")){
                cod2= RROp2B(op2);
                cod="85"+cod2;
            }else{
                if(op1.equals("CX")){
                    cod2= RROp2C(op2);
                    cod="85"+cod2;
                }else{
                   if(op1.equals("DX")){
                        cod2= RROp2D(op2);
                        cod="85"+cod2;
                    }else{
                       if(op1.equals("SP")){
                        cod2= RROp2SP(op2);
                        cod="85"+cod2;
                        }else{
                           if(op1.equals("BP")){
                               cod2= RROp2BP(op2);
                               cod="85"+cod2;
                            }else{
                               if(op1.equals("SI")){
                                 cod2= RROp2SI(op2);
                                 cod="85"+cod2;
                                }else{
                                 if(op1.equals("DI")){
                                    cod2= RROp2DI(op2);
                                    cod="85"+cod2;
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
     public String TESTRegReg8(String op1,String op2 ){
        String cod="";
        String cod2="";
        if(op1.equals("AL")){
            cod2= RROp2A8(op2);
            cod="84"+cod2;
        }else{
            if(op1.equals("BL")){
                cod2= RROp2B8(op2);
                cod="84"+cod2;
            }else{
                if(op1.equals("CL")){
                    cod2= RROp2C8(op2);
                    cod="84"+cod2;
                }else{
                   if(op1.equals("DL")){
                        cod2= RROp2D8(op2);
                        cod="84"+cod2;
                    }else{
                       if(op1.equals("AH")){
                        cod2= RROp2AH(op2);
                        cod="84"+cod2;
                        }else{
                           if(op1.equals("BH")){
                               cod2= RROp2BH(op2);
                               cod="84"+cod2;
                            }else{
                               if(op1.equals("CH")){
                                 cod2= RROp2CH(op2);
                                 cod="84"+cod2;
                                }else{
                                 if(op1.equals("DH")){
                                    cod2= RROp2DH(op2);
                                    cod="84"+cod2;
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String RROp2A(String op1){
        String cod="";
        if(op1.equals("AX")){
            cod="C0";
        }else{
            if(op1.equals("BX")){
                cod="C3";
            }else{
                if(op1.equals("CX")){
                    cod="C1";
                }else{
                   if(op1.equals("DX")){
                        cod="C2";
                    }else{
                       if(op1.equals("SP")){
                        cod="C4";
                        }else{
                           if(op1.equals("BP")){
                               cod="C5";
                            }else{
                               if(op1.equals("SI")){
                                 cod="C6";
                                }else{
                                 if(op1.equals("DI")){
                                    cod="C7";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    
    }
    public String RROp2B(String op1){
        String cod="";
        if(op1.equals("AX")){
            cod="D8";
        }else{
            if(op1.equals("BX")){
                cod="DB";
            }else{
                if(op1.equals("CX")){
                    cod="D9";
                }else{
                   if(op1.equals("DX")){
                        cod="DA";
                    }else{
                       if(op1.equals("SP")){
                        cod="DC";
                        }else{
                           if(op1.equals("BP")){
                               cod="DD";
                            }else{
                               if(op1.equals("SI")){
                                 cod="DE";
                                }else{
                                 if(op1.equals("DI")){
                                    cod="DF";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    
    }
    public String RROp2C(String op1){
        String cod="";
        if(op1.equals("AX")){
            cod="C8";
        }else{
            if(op1.equals("BX")){
                cod="CB";
            }else{
                if(op1.equals("CX")){
                    cod="C9";
                }else{
                   if(op1.equals("DX")){
                        cod="CA";
                    }else{
                       if(op1.equals("SP")){
                        cod="CC";
                        }else{
                           if(op1.equals("BP")){
                               cod="CD";
                            }else{
                               if(op1.equals("SI")){
                                 cod="CE";
                                }else{
                                 if(op1.equals("DI")){
                                    cod="CF";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String RROp2D(String op1){
        String cod="";
        if(op1.equals("AX")){
            cod="D0";
        }else{
            if(op1.equals("BX")){
                cod="D3";
            }else{
                if(op1.equals("CX")){
                    cod="D1";
                }else{
                   if(op1.equals("DX")){
                        cod="D2";
                    }else{
                       if(op1.equals("SP")){
                        cod="D4";
                        }else{
                           if(op1.equals("BP")){
                               cod="D5";
                            }else{
                               if(op1.equals("SI")){
                                 cod="D6";
                                }else{
                                 if(op1.equals("DI")){
                                    cod="D7";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String RROp2SP(String op1){
        String cod="";
        if(op1.equals("AX")){
            cod="E0";
        }else{
            if(op1.equals("BX")){
                cod="E3";
            }else{
                if(op1.equals("CX")){
                    cod="E1";
                }else{
                   if(op1.equals("DX")){
                        cod="E2";
                    }else{
                       if(op1.equals("SP")){
                        cod="E4";
                        }else{
                           if(op1.equals("BP")){
                               cod="E5";
                            }else{
                               if(op1.equals("SI")){
                                 cod="E6";
                                }else{
                                 if(op1.equals("DI")){
                                    cod="E7";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String RROp2BP(String op1){
        String cod="";
        if(op1.equals("AX")){
            cod="E8";
        }else{
            if(op1.equals("BX")){
                cod="EB";
            }else{
                if(op1.equals("CX")){
                    cod="E9";
                }else{
                   if(op1.equals("DX")){
                        cod="EA";
                    }else{
                       if(op1.equals("SP")){
                        cod="EC";
                        }else{
                           if(op1.equals("BP")){
                               cod="ED";
                            }else{
                               if(op1.equals("SI")){
                                 cod="EE";
                                }else{
                                 if(op1.equals("DI")){
                                    cod="EF";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String RROp2SI(String op1){
        String cod="";
        if(op1.equals("AX")){
            cod="F0";
        }else{
            if(op1.equals("BX")){
                cod="F3";
            }else{
                if(op1.equals("CX")){
                    cod="F1";
                }else{
                   if(op1.equals("DX")){
                        cod="F2";
                    }else{
                       if(op1.equals("SP")){
                        cod="F4";
                        }else{
                           if(op1.equals("BP")){
                               cod="F5";
                            }else{
                               if(op1.equals("SI")){
                                 cod="F6";
                                }else{
                                 if(op1.equals("DI")){
                                    cod="F7";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String RROp2DI(String op1){
        String cod="";
        if(op1.equals("AX")){
            cod="F8";
        }else{
            if(op1.equals("BX")){
                cod="FB";
            }else{
                if(op1.equals("CX")){
                    cod="F9";
                }else{
                   if(op1.equals("DX")){
                        cod="FA";
                    }else{
                       if(op1.equals("SP")){
                        cod="FC";
                        }else{
                           if(op1.equals("BP")){
                               cod="FD";
                            }else{
                               if(op1.equals("SI")){
                                 cod="FE";
                                }else{
                                 if(op1.equals("DI")){
                                    cod="FF";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    
    public String ANDRegInm8(String op1){
        String cod="";
        
        
        if(op1.equals("AL")){
            cod="FFFF80D0";
        }else{
            if(op1.equals("BL")){
                cod="FFFF80D3";
            }else{
                if(op1.equals("CL")){
                    cod="FFFF80D1";
                }else{
                   if(op1.equals("DL")){
                        cod="FFFF80D2";
                    }else{
                       if(op1.equals("AH")){
                            cod="FFFF81D4";
                        }else{
                           if(op1.equals("BH")){
                               cod="FFFF81D5";
                            }else{
                               if(op1.equals("CH")){
                                 cod="FFFF81D6";
                                }else{
                                 if(op1.equals("DH")){
                                    cod="FFFF81D7";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String ANDRegReg8(String op1,String op2 ){
        String cod="";
        String cod2="";
        if(op1.equals("AL")){
            cod2= RROp2A8(op2);
            cod="23"+cod2;
        }else{
            if(op1.equals("BL")){
                cod2= RROp2B8(op2);
                cod="3A"+cod2;
            }else{
                if(op1.equals("CL")){
                    cod2= RROp2C8(op2);
                    cod="3A"+cod2;
                }else{
                   if(op1.equals("DL")){
                        cod2= RROp2D8(op2);
                        cod="3A"+cod2;
                    }else{
                       if(op1.equals("AH")){
                        cod2= RROp2AH(op2);
                        cod="3A"+cod2;
                        }else{
                           if(op1.equals("BH")){
                               cod2= RROp2BH(op2);
                               cod="3A"+cod2;
                            }else{
                               if(op1.equals("CH")){
                                 cod2= RROp2CH(op2);
                                 cod="3A"+cod2;
                                }else{
                                 if(op1.equals("DH")){
                                    cod2= RROp2DH(op2);
                                    cod="3A"+cod2;
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    
    public String RROp2A8(String op1){
        String cod="";
        if(op1.equals("AL")){
            cod="C0";
        }else{
            if(op1.equals("BL")){
                cod="C3";
            }else{
                if(op1.equals("CL")){
                    cod="C1";
                }else{
                   if(op1.equals("DL")){
                        cod="C2";
                    }else{
                       if(op1.equals("AH")){
                        cod="C4";
                        }else{
                           if(op1.equals("BH")){
                               cod="C5";
                            }else{
                               if(op1.equals("CH")){
                                 cod="C6";
                                }else{
                                 if(op1.equals("DH")){
                                    cod="C7";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    
    }
    public String RROp2B8(String op1){
        String cod="";
        if(op1.equals("AL")){
            cod="D8";
        }else{
            if(op1.equals("BL")){
                cod="DB";
            }else{
                if(op1.equals("CL")){
                    cod="D9";
                }else{
                   if(op1.equals("DL")){
                        cod="DA";
                    }else{
                       if(op1.equals("AH")){
                        cod="DC";
                        }else{
                           if(op1.equals("BH")){
                               cod="DD";
                            }else{
                               if(op1.equals("CH")){
                                 cod="DE";
                                }else{
                                 if(op1.equals("DH")){
                                    cod="DF";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    
    }
    public String RROp2C8(String op1){
        String cod="";
        if(op1.equals("AL")){
            cod="C8";
        }else{
            if(op1.equals("BL")){
                cod="CB";
            }else{
                if(op1.equals("CL")){
                    cod="C9";
                }else{
                   if(op1.equals("DL")){
                        cod="CA";
                    }else{
                       if(op1.equals("AH")){
                        cod="CC";
                        }else{
                           if(op1.equals("BH")){
                               cod="CD";
                            }else{
                               if(op1.equals("CH")){
                                 cod="CE";
                                }else{
                                 if(op1.equals("DH")){
                                    cod="CF";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String RROp2D8(String op1){
        String cod="";
        if(op1.equals("AL")){
            cod="D0";
        }else{
            if(op1.equals("BL")){
                cod="D3";
            }else{
                if(op1.equals("CL")){
                    cod="D1";
                }else{
                   if(op1.equals("DL")){
                        cod="D2";
                    }else{
                       if(op1.equals("AH")){
                        cod="D4";
                        }else{
                           if(op1.equals("BH")){
                               cod="D5";
                            }else{
                               if(op1.equals("CH")){
                                 cod="D6";
                                }else{
                                 if(op1.equals("DH")){
                                    cod="D7";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String RROp2AH(String op1){
        String cod="";
        if(op1.equals("AL")){
            cod="E0";
        }else{
            if(op1.equals("BL")){
                cod="E3";
            }else{
                if(op1.equals("CL")){
                    cod="E1";
                }else{
                   if(op1.equals("DL")){
                        cod="E2";
                    }else{
                       if(op1.equals("AH")){
                        cod="E4";
                        }else{
                           if(op1.equals("BH")){
                               cod="E5";
                            }else{
                               if(op1.equals("CH")){
                                 cod="E6";
                                }else{
                                 if(op1.equals("DH")){
                                    cod="E7";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String RROp2BH(String op1){
        String cod="";
        if(op1.equals("AL")){
            cod="E8";
        }else{
            if(op1.equals("BL")){
                cod="EB";
            }else{
                if(op1.equals("CL")){
                    cod="E9";
                }else{
                   if(op1.equals("DL")){
                        cod="EA";
                    }else{
                       if(op1.equals("AH")){
                        cod="EC";
                        }else{
                           if(op1.equals("BH")){
                               cod="ED";
                            }else{
                               if(op1.equals("CH")){
                                 cod="EE";
                                }else{
                                 if(op1.equals("DH")){
                                    cod="EF";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String RROp2CH(String op1){
        String cod="";
        if(op1.equals("AL")){
            cod="F0";
        }else{
            if(op1.equals("BL")){
                cod="F3";
            }else{
                if(op1.equals("CL")){
                    cod="F1";
                }else{
                   if(op1.equals("DL")){
                        cod="F2";
                    }else{
                       if(op1.equals("AH")){
                        cod="F4";
                        }else{
                           if(op1.equals("BH")){
                               cod="F5";
                            }else{
                               if(op1.equals("CH")){
                                 cod="F6";
                                }else{
                                 if(op1.equals("DH")){
                                    cod="F7";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String RROp2DH(String op1){
        String cod="";
        if(op1.equals("AL")){
            cod="F8";
        }else{
            if(op1.equals("BL")){
                cod="FB";
            }else{
                if(op1.equals("CL")){
                    cod="F9";
                }else{
                   if(op1.equals("DL")){
                        cod="FA";
                    }else{
                       if(op1.equals("AH")){
                        cod="FC";
                        }else{
                           if(op1.equals("BH")){
                               cod="FD";
                            }else{
                               if(op1.equals("CH")){
                                 cod="FE";
                                }else{
                                 if(op1.equals("DH")){
                                    cod="FF";
                                  }  
                               }
                           }
                       }
                   }
                }
            }
        }
     
        return cod;
    }
    public String validaTam(String auxH){
        int tam=auxH.length();
        String dir="";
        if(tam==1||tam==3){
            dir="0"+auxH;
        }else{
            if(tam==2 || tam==4){
                dir=auxH;
            }
        }
        return dir;
    }
    
    public String hex(String hex){
        hex= hex.toUpperCase();
        char aux;
        String auxH="";
        for(int i=0;i<hex.length();i++){
            aux=hex.charAt(i);
            if(aux!='H'){
                auxH=auxH+aux;
            }
        }
        String cod2=validaTam(auxH);
        return cod2;
    }
    public String dec(String hex){
        int num=Integer.parseInt(hex);
        String auxH= direccion(num);
        String cod=validaTam(auxH);
        return cod;
    }
    public String bin(String bin){
        bin= bin.toUpperCase();
        char aux;
        
        String auxH="";
        for(int i=0;i<bin.length();i++){
            aux=bin.charAt(i);
            if(aux!='B'){
                auxH=auxH+aux;
            }
        }
        
        String hex=binarioToHexa(auxH);
        String cod2= validaTam(hex);
        cod2=cod2.toUpperCase();
        return cod2;
    }
    public String binarioToHexa(String binario) {
      
      Integer numero = 0;
      try{
         numero = Integer.valueOf(binario, 2);
      }catch (NumberFormatException e) {
      }
      return Integer.toHexString(numero);
   }
    private static boolean isNumeric(String cadena){
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }
    
    public int buscaPos(String etiq){
        String diraux="";
        String dir="";
        int pos=0;
        char aux;
        int filas = tablaSim.getRowCount();
        
        for (int i = 0; i < filas; i++) {
            String valor = (String) tablaSim.getValueAt(i, 0);
            if(etiq.equals(valor)){
                diraux=(String) tablaSim.getValueAt(i,3);
                pos=i;
                break;
            }
        }
        return pos;
    }
    public String buscaVar(String var){
        int pos=buscaPos(var);
        String val=(String) tablaSim.getValueAt(pos,2);
        return val;
    }
}
