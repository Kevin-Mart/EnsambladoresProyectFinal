/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * 
 */
public class pnlSimbolos extends javax.swing.JPanel {

    /**
     * Creates new form pnl2
     */

DefaultTableModel mc;
    String headCod[]={"Cp","Instrucción","Estado","Codificación"};
    String datosCod[][]={};
    
    DefaultTableModel mst;
    String headSim[]={"Simbolo","Tipo","Valor","CP"};
    String datosSim[][]={};
    int alto;
    final int filas = 20;
    Dimension dimension;
    JScrollBar barra;
    int contadorP=0;
    int contadorSS=768;
    int contadorCS=768;
    Main m;
    public pnlSimbolos(String nomArch, String rArch, Main m)throws FileNotFoundException {
        initComponents();
        this.m = m;
        mc= new DefaultTableModel(datosCod,headCod);
        tabCod.setModel(mc);
        TableColumnModel columnModel = tabCod.getColumnModel();
       
        tabCod.setModel(mc);
        
        mst= new DefaultTableModel(datosSim,headSim);
        tabSim.setModel(mst);
               
        validaDataS(nomArch,rArch);
        validaCodeS(nomArch,rArch);
        validaStackS(nomArch,rArch);
        
        
        
    }
    /**
     * Creates new form TabSim
     */
    public pnlSimbolos() {
        initComponents();
    }
    
    public void validaDataS(String nomArch,String rArch){
        ValidaDataS code =new ValidaDataS();
        Codifica direc =new Codifica();
        ValidaDataS tam =new ValidaDataS();
        try {
            FileReader fr = new FileReader(rArch);
            BufferedReader br = new BufferedReader(fr);
            String text, line;
            int auxDS=0;
            int auxEnd=0;
            
            while ((text = br.readLine())!= null){
                if(text.contains(";")){
                    text=quitaCom(text);
                }/*comentarios*/
                line=text;
                if(text.equals("")){
                    String tabEst[]={"","",""};
                    mc.addRow(tabEst);
                }/*if vacio*/else{
                    if(text.contains(".data segment")||text.contains(".Data Segment")){
                        auxDS=auxDS+1;
                        if(auxDS==1){
                            
                            String ins=text;
                            String estado= "Correcto";
                            String CP=direc.direccion(contadorP);
                            Object tabEst[]={CP+"h",ins,estado};
                            mc.addRow(tabEst);
                            contadorP=768;
                            
                        }else{
                            String ins=text;
                            String estado= "Incorrecto / Instrucción duplicada";
                            String CP=direc.direccion(contadorP);
                            String tabEst[]={CP+"h",ins,estado};
                            mc.addRow(tabEst);
                        }/*else auxDS*/
                    }/*if DS*/else{
                        if(text.contains("db")|| text.contains("DB")&& auxEnd==0){
                            int flgdb=code.validaDB(text);
                            if(flgdb== 1){
                                if(verificaExist(text)== false){
                                    String ins=text;
                                    String estado="Correcto";
                                    if(text.contains("\"")||text.contains(" '")){
                                        int suma=tam.tamano(ins);
                                        String CP=direc.direccion(contadorP);
                                        Object tabEst[]={CP+"h",ins,estado};
                                        mc.addRow(tabEst);
                                        escribeTabS(text,CP);
                                        contadorP=contadorP+suma;
                                    }else{
                                        String CP=direc.direccion(contadorP);
                                        Object tabEst[]={CP+"h",ins,estado};
                                        mc.addRow(tabEst);
                                        escribeTabS(text,CP);
                                        contadorP=contadorP+1;
                                    }
                                }else{
                                    String ins=text;
                                    String estado="Incorrecto / Nombre de variable Duplicado";
                                    String CP=direc.direccion(contadorP);
                                    Object tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);
                                }//else verifica exist.
                            }/*if flg 1*/
                             if(flgdb== -1){
                                String ins=text;
                                String estado="Incorrecto / Orden incorrecto";
                                String CP=direc.direccion(contadorP);
                                Object tabEst[]={CP+"h",ins,estado};
                                mc.addRow(tabEst);

                            }/*if flg -1*/
                            if(flgdb== -2){
                                String ins=text;
                                String estado="Incorrecto / El nombre no puede iniciar con constante";
                                String CP=direc.direccion(contadorP);
                                Object tabEst[]={CP+"h",ins,estado};
                                mc.addRow(tabEst);
                            }/*if flg -2*/
                            if(flgdb== -3){
                                String ins=text;
                                String estado="Incorrecto / Definicion incorrecta";
                                String CP=direc.direccion(contadorP);
                                Object tabEst[]={CP+"h",ins,estado};
                                mc.addRow(tabEst);

                            }/*if flg -3*/
                            if(flgdb== -4){
                                String ins=text;
                                String estado="Incorrecto / Falta '(' ó ')'";
                                String CP=direc.direccion(contadorP);
                                Object tabEst[]={CP+"h",ins,estado};
                                mc.addRow(tabEst);

                            }/*if flg -4*/
                            if(flgdb== -5){
                                String ins=text;
                                String estado="Incorrecto / El valor inicial debe ser numerico";
                                String CP=direc.direccion(contadorP);
                                Object tabEst[]={CP+"h",ins,estado};
                                mc.addRow(tabEst);
                            }/*if flg 5*/
                            if(flgdb== -6){
                                String ins=text;
                                String estado="Incorrecto / Constante inválida";
                                String CP=direc.direccion(contadorP);
                                Object tabEst[]={CP+"h",ins,estado};
                                mc.addRow(tabEst);
                            }/*if flg -6*/
                            if(flgdb== -7){
                                String ins=text.trim();
                                String estado="Incorrecto / Faltan comillas";
                                String CP=direc.direccion(contadorP);
                                Object tabEst[]={CP+"h",ins,estado};
                                mc.addRow(tabEst);
                            }/*if flg -7*/
                        }/*if db*/else{
                            if(text.contains("dw") || text.contains("DW")&& auxEnd==0){
                                int flgdw=code.validaDW(text);
                                if(flgdw== 1){
                                    if(verificaExist(text)== false){
                                        String ins=text;
                                        String estado="Correcto";
                                        String CP=direc.direccion(contadorP);
                                        Object tabEst[]={CP+"h",ins,estado};
                                        mc.addRow(tabEst);
                                        escribeTabS(text,CP);
                                        contadorP=contadorP+1;

                                    }else{
                                        String ins=text;
                                        String estado="Incorrecto / Nombre de variable Duplicado";
                                        String CP=direc.direccion(contadorP);
                                        Object tabEst[]={CP+"h",ins,estado};
                                        mc.addRow(tabEst);
                                    }//else verifica exist.
                                }//if flg 1
                                if(flgdw== -1){
                                    String ins=text;
                                    String estado="Incorrecto / Orden incorrecto";
                                    String CP=direc.direccion(contadorP);
                                    Object tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);

                                }/*if flg -1*/
                                if(flgdw== -2){
                                    String ins=text;
                                    String estado="Incorrecto / El nombre no puede iniciar con constante";
                                    String CP=direc.direccion(contadorP);
                                    Object tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);
                                }/*if flg -2*/
                                if(flgdw== -3){
                                    String ins=text;
                                    String estado="Incorrecto / Definicion incorrecta";
                                    String CP=direc.direccion(contadorP);
                                    Object tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);

                                }/*if flg -3*/
                                if(flgdw== -4){
                                    String ins=text;
                                    String estado="Incorrecto / Falta '(' ó ')'";
                                    String CP=direc.direccion(contadorP);
                                    Object tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);

                                }/*if flg -4*/
                                if(flgdw== -5){
                                    String ins=text;
                                    String estado="Incorrecto / El valor inicial debe ser numerico";
                                    String CP=direc.direccion(contadorP);
                                    Object tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);
                                }/*if flg 5*/
                                if(flgdw== -6){
                                    String ins=text;
                                    String estado="Incorrecto / Constante inválida";
                                    String CP=direc.direccion(contadorP);
                                    Object tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);
                                }/*if flg -6*/
                            }/*if dw*/else{
                                if(text.contains("equ")){
                                    int flagEqu= code.validaEqu(text);
                                    if(flagEqu== 1){
                                        if(verificaExist(text)== false){
                                            String ins=text;
                                            String estado="Correcto";
                                            String CP=direc.direccion(contadorP);
                                            Object tabEst[]={CP+"h",ins,estado};
                                            mc.addRow(tabEst);
                                            escribeTabS(text,CP);
                                            contadorP=contadorP+1;

                                        }else{
                                            String ins=text;
                                            String estado="Incorrecto / Nombre de variable Duplicado";
                                            String CP=direc.direccion(contadorP);
                                            Object tabEst[]={CP+"h",ins,estado};
                                            mc.addRow(tabEst);
                                        }//else verifica exist.
                                    }/*flg 1*/
                                    if(flagEqu== -1){
                                        String ins=text;
                                        String estado="Incorrecto / Orden incorrecto";
                                        String CP=direc.direccion(contadorP);
                                        Object tabEst[]={CP+"h",ins,estado};
                                        mc.addRow(tabEst);

                                    }/*if flg -1*/
                                    if(flagEqu== -2){
                                        String ins=text;
                                        String estado="Incorrecto / No puede iniciar con constante";
                                        String CP=direc.direccion(contadorP);
                                        Object tabEst[]={CP+"h",ins,estado};
                                        mc.addRow(tabEst);

                                    }/*if flg -2*/
                                    if(flagEqu== -3){
                                        String ins=text;
                                        String estado="Incorrecto / debe ser una constante numerico";
                                        String CP=direc.direccion(contadorP);
                                        Object tabEst[]={CP+"h",ins,estado};
                                        mc.addRow(tabEst);
                                    }/*if flg -3*/
                                }/*if equ*/else{
                                    if(text.contains("ends")|| text.contains("ENDS")){
                                        if(auxDS==1|| auxEnd==0){
                                           auxEnd= auxEnd+1;
                                           String ins=text;
                                           String estado= "Correcto";
                                           String CP=direc.direccion(contadorP);
                                           Object tabEst[]={CP+"h",ins,estado};
                                           mc.addRow(tabEst);
                                           break;
                                        }else{
                                           String ins=text;
                                           String estado= "Incorrecto";
                                           String CP=direc.direccion(contadorP);
                                           Object tabEst[]={CP+"h",ins,estado};
                                           mc.addRow(tabEst);
                                           break;
                                        }
                                    }/*if ends*/else{
                                        if(auxDS>0 && auxEnd==0){
                                            if(text.equals("")){
                                                String tabEst[]={"","",""};
                                                mc.addRow(tabEst);
                                            }
                                            String ins=text;
                                            String estado="Incorrecto / No se reconoce la instrucción";
                                            String CP=direc.direccion(contadorP);
                                            Object tabEst[]={CP+"h",ins,estado};
                                            mc.addRow(tabEst);
                                        }/*if no valido*/
                                    }/*else ends*/
                                }/*else equ*/
                            }/*else dw*/
                        }/*else db*/
                    }/*else DS*/
                }/*else vacio*/
            }
        } catch (IOException e) {
            e.printStackTrace();
	}
    }
    
    public void validaStackS(String nomArchivo,String rutaArchivo){
        
       
        Codifica dir =new Codifica();
        try {
            FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);
            String text;
            int auxEnd=0;
            int auxStack=0;
           ValidaStack code =new ValidaStack();
            while ((text = br.readLine())!= null){
                if(text.contains(";")){
                    text=quitaCom(text);
                }/*comentarios*/
                if(text.equals("")){
                    String tabEst[]={"","",""};
                    mc.addRow(tabEst);
                }/*if vacio*/else{
                    if(text.contains(".stack segment")||text.contains(".Stack Segment")){
                        auxStack=auxStack+1;
                        if(auxStack ==1){
                            contadorSS=contadorP;
                            String ins=text;
                            String estado= "Correcto";
                            String CP=dir.direccion(contadorSS);
                            String tabEst[]={CP+"h",ins,estado};
                            mc.addRow(tabEst);
                        }/*if auxStack*/else{
                            String ins=text;
                            String estado="Incorrecto / Instruccion repetida";
                            String CP=dir.direccion(contadorSS);
                            String tabEst[]={CP+"h",ins,estado};
                            mc.addRow(tabEst);
                        }
                    }/*if stack*/else{
                        if(auxStack==1){
                            if(text.contains("dw") || text.contains("DW")){
                                int flagdws=code.validaDws(text);
                                if(flagdws== 1){
                                    String ins=text;
                                    String estado="Correcto";
                                    String CP=dir.direccion(0);
                                    String tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);
                                    contadorSS=contadorSS+1;
                                    
                                }/*if flg 1*/
                                if(flagdws== -1){
                                    String ins=text;
                                    String estado="Incorrecto / Orden incorrecto";
                                    String CP=dir.direccion(contadorSS);
                                    String tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);
                                }/*if flg -1*/
                                if(flagdws== -2){
                                    String ins=text;
                                    String estado="Incorrecto / Numero de parametros en definicion incorrecto";
                                    String CP=dir.direccion(256);
                                    String tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);
                                }/*if flg -2*/
                                if(flagdws== -3){
                                    String ins=text;
                                    String estado="Incorrecto /Constante inválida";
                                    String CP=dir.direccion(contadorSS);
                                    String tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);
                                }/*if flg -3*/
                                if(flagdws== -4){
                                    String ins=text;
                                    String estado="Incorrecto / Error sintáctico en DUP";
                                    String CP=dir.direccion(contadorSS);
                                    String tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);
                                }/*if flg -4*/
                            }/*if dw*/else{
                                if(text.contains("ends")||text.contains("ENDS")){
                                    if(auxStack==1|| auxEnd==0){
                                        auxEnd= auxEnd+1;
                                        String ins=text;
                                        String estado= "Correcto";
                                        String CP=dir.direccion(256);
                                        String tabEst[]={CP+"h",ins,estado};
                                        mc.addRow(tabEst);
                                        break;
                                    }/*if aux*/else{
                                        String ins=text;
                                        String estado= "Incorrecto";
                                        String CP=dir.direccion(contadorSS);
                                        String tabEst[]={CP+"h",ins,estado};
                                        mc.addRow(tabEst);
                                        break;
                                    }
                                }/*if ends*/else{
                                    if(auxStack>0 && auxEnd==0){
                                        String ins=text;
                                        String estado="Incorrecto / No es instruccion de pila";
                                        String CP=dir.direccion(contadorSS);
                                        String tabEst[]={CP+"h",ins,estado};
                                        mc.addRow(tabEst);
                                    }
                                }/*else ends*/
                            }/*else dw*/
                        }/*if auxStack*/
                    }/*else stack*/
                }/*else vacio*/
            }//while
        } catch (IOException e) {
            e.printStackTrace();
	}//catch
    }
    
    public void validaCodeS(String nomArch,String rArch){
        Codifica dir =new Codifica();
        Codifica codigo=new Codifica(tabSim);
        Codifica tam=new Codifica();
        
        try {
            FileReader fr = new FileReader(rArch);
            BufferedReader br = new BufferedReader(fr);
            String text;
            int auxEnd=0;
            int auxCs=0;
            ValidaCodS code = new ValidaCodS();
            while ((text = br.readLine())!= null){
                if(text.contains(";")){
                    text=quitaCom(text);
                }/*comentarios*/
                if(text.equals("")){
                    String tabEst[]={"","",""};
                    mc.addRow(tabEst);
                }/*if vacio*/else{
                    if(text.contains(".code segment")||text.contains(".Code Segment")){
                        auxCs=auxCs+1;
                        if(auxCs==1){
                            String ins=text;
                            String estado= "Correcto";
                            String CP=dir.direccion(contadorCS);
                            String tabEst[]={CP+"h",ins,estado};
                            mc.addRow(tabEst);
                        }else{
                            String ins=text;
                            String estado= "Incorrecto / Instrucción duplicada";
                            String CP=dir.direccion(contadorCS);
                            String tabEst[]={CP+"h",ins,estado};
                            mc.addRow(tabEst);
                        }/*if auxD*/
                    }/*if code*/else{
                        if(auxCs==1){
                            if(text.contains("DAA")|| text.contains("daa")){
                                int flgCLI=code.validaDAA(text);
                                if(flgCLI==1){
                                    String ins=text;
                                    String estado="Correcto";
                                    String CP=dir.direccion(contadorCS);
                                    String tabEst[]={CP+"h",ins,estado,"    27"};
                                    mc.addRow(tabEst);
                                    contadorCS=contadorCS+1;
                                }//if flg 1
                                if(flgCLI==-1){
                                    String ins=text;
                                    String estado="Incorrecto / Instruccion escrita incorrectamente";
                                    String CP=dir.direccion(contadorCS);
                                    String tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);
                                }//if flg -1
                                if(flgCLI==-2){
                                    String ins=text;
                                    String estado="Incorrecto / No debe llevar operandos";
                                    String CP=dir.direccion(contadorCS);
                                    String tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);
                                }
                            }else{
                        if(auxCs==1){
                            if(text.contains("DAS")|| text.contains("das")){
                                int flgCLC=code.validaDAS(text);
                                if(flgCLC==1){
                                    String ins=text;
                                    String estado="Correcto";
                                    String CP=dir.direccion(contadorCS);
                                    String tabEst[]={CP+"h",ins,estado,"    2F"};
                                    mc.addRow(tabEst);
                                    contadorCS=contadorCS+1;
                                }//if flg 1
                                if(flgCLC==-1){
                                    String ins=text;
                                    String estado="Incorrecto / Instruccion escrita incorrectamente";
                                    String CP=dir.direccion(contadorCS);
                                    String tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);
                                }//if flg -1
                                if(flgCLC==-2){
                                    String ins=text;
                                    String estado="Incorrecto / No debe llevar operandos";
                                    String CP=dir.direccion(contadorCS);
                                    String tabEst[]={CP+"h",ins,estado};
                                    mc.addRow(tabEst);
                                }
                            }
                            
                            
                            
                            
                            
                            /*if pushf*/else{
                                if(text.contains("PUSHF")|| text.contains("pushf")){
                                    int flgAAM=code.validaPUSHF(text);
                                    if(flgAAM==1){
                                        String ins=text;
                                        String estado="Correcto";
                                        String CP=dir.direccion(contadorCS);
                                        String tabEst[]={CP+"h",ins,estado,"    9C"};
                                        mc.addRow(tabEst);
                                        contadorCS=contadorCS+2;
                                    }//if flg 1
                                    if(flgAAM==-1){
                                        String ins=text;
                                        String estado="Incorrecto / Instruccion escrita incorrectamente";
                                        String CP=dir.direccion(contadorCS);
                                        String tabEst[]={CP+"h",ins,estado};
                                        mc.addRow(tabEst);
                                    }//if flg -1
                                    if(flgAAM==-2){
                                        String ins=text;
                                        String estado="Incorrecto / No debe llevar operandos";
                                        String CP=dir.direccion(contadorCS);
                                        String tabEst[]={CP+"h",ins,estado};
                                        mc.addRow(tabEst);
                                    }
                                }/*if aas*/else{
                                    if(text.contains("RET")|| text.contains("ret")){
                                        int flgRET=code.validaRET(text);
                                        if(flgRET==1){
                                            String ins=text;
                                            String estado="Correcto";
                                            String CP=dir.direccion(contadorCS);
                                            String tabEst[]={CP+"h",ins,estado,"   C3"};
                                            mc.addRow(tabEst);
                                            contadorCS=contadorCS+1;
                                        }//if flg 1
                                        if(flgRET==-1){
                                            String ins=text;
                                            String estado="Incorrecto / Instruccion escrita incorrectamente";
                                            String CP=dir.direccion(contadorCS);
                                            String tabEst[]={CP+"h",ins,estado};
                                            mc.addRow(tabEst);
                                        }//if flg -1
                                        if(flgRET==-2){
                                            String ins=text;
                                            String estado="Incorrecto / No debe llevar operandos";
                                            String CP=dir.direccion(contadorCS);
                                            String tabEst[]={CP+"h",ins,estado};
                                            mc.addRow(tabEst);
                                        }
                                    }/*if cmpsw*/else{
                                        if(text.contains("CLC")|| text.contains("clc")){
                                            int flgSTOSW=code.validaCLC(text);
                                            if(flgSTOSW==1){
                                                String ins=text;
                                                String estado="Correcto";
                                                String CP=dir.direccion(contadorCS);
                                                String tabEst[]={CP+"h",ins,estado,"    F8"};
                                                mc.addRow(tabEst);
                                                contadorCS=contadorCS+1;
                                            }//if flg 1
                                            if(flgSTOSW==-1){
                                                String ins=text;
                                                String estado="Incorrecto / Instruccion escrita incorrectamente";
                                                String CP=dir.direccion(contadorCS);
                                                String tabEst[]={CP+"h",ins,estado};
                                                mc.addRow(tabEst);
                                            }//if flg -1
                                            if(flgSTOSW==-2){
                                                String ins=text;
                                                String estado="Incorrecto / No debe llevar operandos";
                                                String CP=dir.direccion(contadorCS);
                                                String tabEst[]={CP+"h",ins,estado};
                                                mc.addRow(tabEst);
                                            }
                                        }/*if nop*/else{  
                                        if(text.contains("CLD")||text.contains("cld")){
                                           int flgDAS=code.validaCLD(text);
                                            if(flgDAS==1){
                                                String ins=text;
                                                String estado="Correcto";
                                                String CP=dir.direccion(contadorCS);
                                                String tabEst[]={CP+"h",ins,estado,"    FC"};
                                                mc.addRow(tabEst);
                                                //int sum = codDEC.length()/2;
                                                contadorCS=contadorCS+2;
                                            }//if flg 1
                                            if(flgDAS==-2){
                                                String ins=text;
                                                String estado="Incorrecto / Faltan operandos";
                                                String CP=dir.direccion(contadorCS);
                                                String tabEst[]={CP+"h",ins,estado};
                                                mc.addRow(tabEst);
                                            }//if flg 2
                                            if(flgDAS==-3){
                                                String ins=text;
                                                String estado="Incorrecto / No. de operandos";
                                                String CP=dir.direccion(contadorCS);
                                                String tabEst[]={CP+"h",ins,estado};
                                                mc.addRow(tabEst);
                                            }//if flg 2    
                                           }/*if imul*/ else{
                                                if(text.contains("DEC")|| text.contains("dec")){
                                            int flgLODSW=code.validaDEC(text);
                                            if(flgLODSW==1){
                                                String ins=text;
                                                String estado="Correcto";
                                                String CP=dir.direccion(contadorCS);
                                                String tabEst[]={CP+"h",ins,estado,"    4B"};
                                                mc.addRow(tabEst);
                                                contadorCS=contadorCS+2;
                                            }//if flg 1
                                            if(flgLODSW==-1){
                                                String ins=text;
                                                String estado="Incorrecto / Instruccion escrita incorrectamente";
                                                String CP=dir.direccion(contadorCS);
                                                String tabEst[]={CP+"h",ins,estado};
                                                mc.addRow(tabEst);
                                            }//if flg -1
                                            if(flgLODSW==-2){
                                                String ins=text;
                                                String estado="Incorrecto / No debe llevar operandos";
                                                String CP=dir.direccion(contadorCS);
                                                String tabEst[]={CP+"h",ins,estado};
                                                mc.addRow(tabEst);
                                            }
                                        }/*if nop*/else{
                                                if(text.contains("IDIV")||text.contains("idiv")){
                                                                int flgNEG=code.validaIDIV(text);
                                                                if(flgNEG==1){
                                                                    String ins=text;
                                                                    String estado="Correcto";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String codDEC=codigo.codNEG(ins);
                                                                    String tabEst[]={CP+"h",ins,estado," F7F8"+codDEC};
                                                                    mc.addRow(tabEst);
                                                                    //int sum = codDEC.length()/2;
                                                                    contadorCS=contadorCS+2;
                                                                }//if flg 1
                                                                if(flgNEG==-2){
                                                                    String ins=text;
                                                                    String estado="Incorrecto / Faltan operandos";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String tabEst[]={CP+"h",ins,estado};
                                                                    mc.addRow(tabEst);
                                                                }//if flg 2
                                                                if(flgNEG==-3){
                                                                    String ins=text;
                                                                    String estado="Incorrecto / No. de operandos";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String tabEst[]={CP+"h",ins,estado};
                                                                    mc.addRow(tabEst);
                                                                }//if flg 2                                                          

                                                           }/*if NEG*/ else{
                                                   if(text.contains("IMUL")||text.contains("imul")){
                                                   int flgNOT=code.validaIMUL(text);
                                                   if(flgNOT==1){
                                                       String ins=text;
                                                       String estado="Correcto";
                                                       String CP=dir.direccion(contadorCS);
                                                       String codR=codigo.codNOT(ins);
                                                       String tabEst[]={CP+"h",ins,estado,"0FAFC1"+codR};
                                                       mc.addRow(tabEst);
                                                       int sum = codR.length()/2;
                                                       contadorCS=contadorCS+sum;
                                                   }//if flg 1
                                                   if(flgNOT==-2){
                                                       String ins=text;
                                                       String estado="Incorrecto / Faltan operandos";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }//if flg 2
                                                   if(flgNOT==-3){
                                                       String ins=text;
                                                       String estado="Incorrecto / No. de operandos";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }
                                                   }/*if NOT*/ else{
                                                   if(text.contains("POP")||text.contains("pop")){
                                                   int flgAND=code.validaPOP(text);
                                                   if(flgAND==1){
                                                       String ins=text;
                                                       String estado="Correcto";
                                                       String CP=dir.direccion(contadorCS);
                                                       String codADC=codigo.codAND(ins);
                                                       String tabEst[]={CP+"h",ins,estado,"58"+codADC};
                                                       mc.addRow(tabEst);
                                                       int sum = codADC.length()/2;
                                                       contadorCS=contadorCS+sum;
                                                   }//if flg 1
                                                   if(flgAND==-2){
                                                       String ins=text;
                                                       String estado="Incorrecto / Faltan operandos";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }//if flg 2
                                                   if(flgAND==-3){
                                                       String ins=text;
                                                       String estado="Incorrecto / No. de operandos";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }//if flg 2
                                                   if(flgAND==-4){
                                                       String ins=text;
                                                       String estado="Incorrecto / Sobrepasa en tamaño";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }//if flg 4
                                                   if(flgAND==-5){
                                                       String ins=text;
                                                       String estado="Incorrecto / No coinciden los tamaños ";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }//if flg 5
                                                   if(flgAND==-6){
                                                       String ins=text.trim();
                                                       String separadores = "[\\ \\,]";
                                                       String auxIns[]=ins.split(separadores);
                                                       String op2=auxIns[2];
                                                       boolean exist=verificaExist(op2);
                                                       if(exist==true){
                                                           String inst=text;
                                                           String estado="Correcto ";
                                                           String CP=dir.direccion(contadorCS);
                                                           String codR=codigo.codROR(ins);
                                                           String tabEst[]={CP+"h",ins,estado,codR};
                                                           mc.addRow(tabEst);
                                                           int sum = codR.length()/2;
                                                           contadorCS=contadorCS+sum;
                                                       }/*if boolean opvar*/else{
                                                           String inst=text;
                                                           String estado="Incorrecto / Variable no definida ";
                                                           String CP=dir.direccion(contadorCS);
                                                           String tabEst[]={CP+"h",ins,estado};
                                                           mc.addRow(tabEst);
                                                       }            
                                                   }//if flg 6
                                               }/*if shl*/ else{   
                                                   if(text.contains("CMP ")||text.contains("cmp ")){
                                                   int flgTEST=code.validaCMP(text);
                                                   if(flgTEST==1){
                                                       String ins=text;
                                                       String estado="Correcto";
                                                       String CP=dir.direccion(contadorCS);
                                                       String codR=codigo.codTEST(ins);
                                                       String tabEst[]={CP+"h",ins,estado,"3BXXYY"+codR};
                                                       mc.addRow(tabEst);
                                                       int sum = codR.length()/2;
                                                       contadorCS=contadorCS+sum;
                                                   }//if flg 1
                                                   if(flgTEST==-2){
                                                       String ins=text;
                                                       String estado="Incorrecto / Faltan operandos";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }//if flg 2
                                                   if(flgTEST==-3){
                                                       String ins=text;
                                                       String estado="Incorrecto / No. de operandos";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }//if flg 2
                                                   if(flgTEST==-4){
                                                       String ins=text;
                                                       String estado="Incorrecto / Sobrepasa en tamaño";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }//if flg 4
                                                   if(flgTEST==-5){
                                                       String ins=text;
                                                       String estado="Incorrecto / No coinciden los tamaños ";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }//if flg 5
                                                   if(flgTEST==-6){
                                                       String ins=text.trim();
                                                       String separadores = "[\\ \\,]";
                                                       String auxIns[]=ins.split(separadores);
                                                       String op2=auxIns[2];
                                                       boolean exist=verificaExist(op2);
                                                       if(exist==true){
                                                           String inst=text;
                                                           String estado="Correcto ";
                                                           String CP=dir.direccion(contadorCS);
                                                           String codR=codigo.codROR(ins);
                                                           String tabEst[]={CP+"h",ins,estado,codR};
                                                           mc.addRow(tabEst);
                                                           int sum = codR.length()/2;
                                                           contadorCS=contadorCS+sum;
                                                       }/*if boolean opvar*/else{
                                                           String inst=text;
                                                           String estado="Incorrecto / Variable no definida ";
                                                           String CP=dir.direccion(contadorCS);
                                                           String tabEst[]={CP+"h",ins,estado};
                                                           mc.addRow(tabEst);
                                                       }            
                                                   }//if flg 6
                                               }/*if shl*/ else{
                                                   if(text.contains("LES")||text.contains("les")){
                                                   int flgROR=code.validaLES(text);
                                                   if(flgROR==1){
                                                       String ins=text;
                                                       String estado="Correcto";
                                                       String CP=dir.direccion(contadorCS);
                                                       String codR=codigo.codROR(ins);
                                                       String tabEst[]={CP+"h",ins,estado,"C4XX"+codR};
                                                       mc.addRow(tabEst);
                                                       int sum = codR.length()/2;
                                                       contadorCS=contadorCS+sum;
                                                   }//if flg 1
                                                   if(flgROR==-2){
                                                       String ins=text;
                                                       String estado="Incorrecto / Faltan operandos";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }//if flg 2
                                                   if(flgROR==-3){
                                                       String ins=text;
                                                       String estado="Incorrecto / No. de operandos";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }//if flg 2
                                                   if(flgROR==-4){
                                                       String ins=text;
                                                       String estado="Incorrecto / Sobrepasa en tamaño";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }//if flg 4
                                                   if(flgROR==-5){
                                                       String ins=text;
                                                       String estado="Incorrecto / No coinciden los tamaños ";
                                                       String CP=dir.direccion(contadorCS);
                                                       String tabEst[]={CP+"h",ins,estado};
                                                       mc.addRow(tabEst);
                                                   }//if flg 5
                                                   if(flgROR==-6){
                                                       String ins=text.trim();
                                                       String separadores = "[\\ \\,]";
                                                       String auxIns[]=ins.split(separadores);
                                                       String op2=auxIns[2];
                                                       boolean exist=verificaExist(op2);
                                                       if(exist==true){
                                                           String inst=text;
                                                           String estado="Correcto ";
                                                           String CP=dir.direccion(contadorCS);
                                                           String codR=codigo.codROR(ins);
                                                           String tabEst[]={CP+"h",ins,estado,codR};
                                                           mc.addRow(tabEst);
                                                           int sum = codR.length()/2;
                                                           contadorCS=contadorCS+sum;
                                                       }/*if boolean opvar*/else{
                                                           String inst=text;
                                                           String estado="Incorrecto / Variable no definida ";
                                                           String CP=dir.direccion(contadorCS);
                                                           String tabEst[]={CP+"h",ins,estado};
                                                           mc.addRow(tabEst);
                                                       }            
                                                   }//if flg 6
                                               }/*if shl*/ else{    
                                                       
                                                       
                                                   if(text.contains(":")){
                                                       int flgetiq=validaPts(text);
                                                       if(flgetiq==1){

                                                           String etiq=quitaPts(text);
                                                           boolean exist=verificaEtiq(etiq);
                                                           if(exist==false){
                                                               String ins=text;
                                                               String estado="Correcto / Etiqueta";
                                                               String CP=dir.direccion(contadorCS);
                                                               String tabEst[]={CP+"h",ins,estado};
                                                               mc.addRow(tabEst);
                                                               String tabSim[]={etiq,"Etiqueta","",CP+"h"};
                                                               mst.addRow(tabSim);
                                                           }else{
                                                               String ins=text;
                                                               String estado="Incorrecto / Nombre de Etiqueta duplicado";
                                                               String CP=dir.direccion(contadorCS);
                                                               String tabEst[]={CP+"h",ins,estado};
                                                               mc.addRow(tabEst);
                                                           }
                                                       }/*if flg etiq*/
                                                   }/*if etiq*/else{
                                                       if(text.contains("JNL")||text.contains("79XX")||text.contains("JS ")||text.contains("JNA")||text.contains("LOOPNE")||text.contains("JAE")||text.contains("jns")||text.contains("js")||text.contains("jge")||text.contains("jna")||text.contains("loopne")||text.contains("jae")){
                                                           int flgJump=code.validaSaltos(text);
                                                           if(flgJump==1){
                                                               String inS=text.trim();
                                                               String inst[]=inS.split(" ");
                                                               String sim=inst[1];
                                                               String jmp=inst[0].toUpperCase();
                                                               boolean flgEx=verificaEtiq(sim);
                                                               if(flgEx==true){
                                                                   String ins=text;
                                                                   String estado="Correcto";
                                                                   String CP=dir.direccion(contadorCS);
                                                                   int dirPos=buscaPos(sim);
                                                                   String dirEt=direcEt(dirPos);
                                                                   String cod=codigo.codSaltos(jmp);
                                                                   String tabEst[]={CP+"h",ins,estado,"7dxx"+cod+dirEt};
                                                                   mc.addRow(tabEst);
                                                                   contadorCS=contadorCS+2;
                                                               }else{
                                                                   String ins=text;
                                                                   String estado="Incorrecto / No existe etiq";
                                                                   String CP=dir.direccion(contadorCS);
                                                                   String tabEst[]={CP+"h",ins,estado};
                                                                   mc.addRow(tabEst);
                                                               }
                                                           }/*if flg 1*/
                                                           if(flgJump==-2){
                                                               String ins=text;
                                                               String estado="Incorrecto / Falta Etiqueta";
                                                               String CP=dir.direccion(contadorCS);
                                                               String tabEst[]={CP+"h",ins,estado};
                                                               mc.addRow(tabEst);
                                                           }//if flg 2
                                                           if(flgJump==-3){
                                                               String ins=text;
                                                               String estado="Incorrecto / demasiados operandos";
                                                               String CP=dir.direccion(contadorCS);
                                                               String tabEst[]={CP+"h",ins,estado};
                                                               mc.addRow(tabEst);
                                                           }//if flg 2
                                                       }/*if saltos*/else{
                                                           if(text.contains("RCL")||text.contains("rcl")){
                                                               int flgDIV=code.validaRCL(text);
                                                                if(flgDIV==1){
                                                                    String ins=text;
                                                                    String estado="Correcto";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String codDIV=codigo.codDIV(ins);
                                                                    String tabEst[]={CP+"h",ins,estado,"D0D2"+codDIV};
                                                                    mc.addRow(tabEst);
                                                                    //int sum = codDEC.length()/2;
                                                                    contadorCS=contadorCS+2;
                                                                }//if flg 1
                                                                if(flgDIV==-2){
                                                                    String ins=text;
                                                                    String estado="Incorrecto / Faltan operandos";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String tabEst[]={CP+"h",ins,estado};
                                                                    mc.addRow(tabEst);
                                                                }//if flg 2
                                                                if(flgDIV==-3){
                                                                    String ins=text;
                                                                    String estado="Incorrecto / No. de operandos";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String tabEst[]={CP+"h",ins,estado};
                                                                    mc.addRow(tabEst);
                                                                }//if flg 2                                                          

                                                                }
                                                           if(text.contains("XCHG")||text.contains("xchg")){
                                                               int flgDEC=code.validaXCHG(text);
                                                                if(flgDEC==1){
                                                                    String ins=text;
                                                                    String estado="Correcto";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String codDEC=codigo.codDEC(ins);
                                                                    String tabEst[]={CP+"h",ins,estado,"86XX"+codDEC};
                                                                    mc.addRow(tabEst);
                                                                    //int sum = codDEC.length()/2;
                                                                    contadorCS=contadorCS+2;
                                                                }//if flg 1
                                                                if(flgDEC==-2){
                                                                    String ins=text;
                                                                    String estado="Incorrecto / Faltan operandos";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String tabEst[]={CP+"h",ins,estado};
                                                                    mc.addRow(tabEst);
                                                                }//if flg 2
                                                                if(flgDEC==-3){
                                                                    String ins=text;
                                                                    String estado="Incorrecto / No. de operandos";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String tabEst[]={CP+"h",ins,estado};
                                                                    mc.addRow(tabEst);
                                                                }//if flg 2                                                          

                                                                }
                                                           else{
                                                           if(text.contains("JB")||text.contains("jb")){
                                                               int flgIDIV=code.validaJB(text);
                                                                if(flgIDIV==1){
                                                                    String ins=text;
                                                                    String estado="Correcto";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String codIDIV=codigo.codIDIV(ins);
                                                                    String tabEst[]={CP+"h",ins,estado,"72XX"+codIDIV};
                                                                    mc.addRow(tabEst);
                                                                    //int sum = codDEC.length()/2;
                                                                    contadorCS=contadorCS+2;
                                                                }//if flg 1
                                                                if(flgIDIV==-2){
                                                                    String ins=text;
                                                                    String estado="Incorrecto / Faltan operandos";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String tabEst[]={CP+"h",ins,estado};
                                                                    mc.addRow(tabEst);
                                                                }//if flg 2
                                                                if(flgIDIV==-3){
                                                                    String ins=text;
                                                                    String estado="Incorrecto / No. de operandos";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String tabEst[]={CP+"h",ins,estado};
                                                                    mc.addRow(tabEst);
                                                                }//if flg 2                                                          

                                                                }
                                                           
                                                           
                                                           
                                                           
                                                           
                                                           
                                                           
                                                           /*if idiv*/ else{
                                                               
                                                                if(text.contains("JE")||text.contains("je")){
                                                                int flgDEC=code.validaJE(text);
                                                                if(flgDEC==1){
                                                                    String ins=text;
                                                                    String estado="Correcto";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String codDEC=codigo.codDEC(ins);
                                                                    String tabEst[]={CP+"h",ins,estado,"74XX"};
                                                                    mc.addRow(tabEst);
                                                                    //int sum = codDEC.length()/2;
                                                                    contadorCS=contadorCS+2;
                                                                }//if flg 1
                                                                if(flgDEC==-2){
                                                                    String ins=text;
                                                                    String estado="Incorrecto / Faltan operandos";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String tabEst[]={CP+"h",ins,estado};
                                                                    mc.addRow(tabEst);
                                                                }//if flg 2
                                                                if(flgDEC==-3){
                                                                    String ins=text;
                                                                    String estado="Incorrecto / No. de operandos";
                                                                    String CP=dir.direccion(contadorCS);
                                                                    String tabEst[]={CP+"h",ins,estado};
                                                                    mc.addRow(tabEst);
                                                                }//if flg 2                                                          

                                                                
                                                                
                                                                
                                                           }/*if idiv*/
                                                                
                                                                else{
                                                               if(text.contains("JLE")||text.contains("JLE")){
                                                                  if(auxCs==1|| auxEnd==0){
                                                                       auxEnd= auxEnd+1;
                                                                       String ins=text;
                                                                       String estado= "Correcto";
                                                                       String CP=dir.direccion(contadorCS);
                                                                       String tabEst[]={CP+"h",ins,estado,"7EXX"};
                                                                       mc.addRow(tabEst);
                                                                       break;
                                                                       }/*if aux*/else{
                                                                       String ins=text;
                                                                       String estado= "Incorrecto";
                                                                       String CP=dir.direccion(contadorCS);
                                                                       String tabEst[]={CP+"h",ins,estado};
                                                                       mc.addRow(tabEst);
                                                                       break;
                                                                        }
                                                                        }/*if ends*/else{
                                                                            if(auxCs>0 && auxEnd==0){
                                                                               String ins=text;
                                                                               String estado="Incorrecto / No se reconoce la instruccion";
                                                                               String CP=dir.direccion(contadorCS);
                                                                               String tabEst[]={CP+"h",ins,estado};
                                                                               mc.addRow(tabEst);
                                                                            }
                                                                        }/*else ends*/
                                                                    } /*else dec*/
                                                                }/*else idiv*/
                                                            }/*else saltos*/
                                                        }/*else etiq*/
                                                   }
                                                        }
                                                        }
                                                    }/*if not*/
                                                    }/*if shl*/
                                                }/*else imul*/  
                                            }/*else lodws*/
                                        }/*else nop*/                                    
                                    }/*else ret*/                              
                                }/*else aaa*/
                            }/*else CLI*/
                        }/*if auxCS*/
                    }/*ele cod*/
                    }
                }/*else vacío*/
            }/*while*/
                 }
             }
        }catch (IOException e) {
            e.printStackTrace();
	}/*catch*/
    }/*validaCode*/
    
    public boolean  verificaExist(String text){
        boolean auxExiste=false;
        String ins=text.trim();
        String inst[]=ins.split(" ");
        String sim=inst[0];
        int filas = tabSim.getRowCount();
        for (int i = 0; i < filas; i++) {
            String valor = (String) tabSim.getValueAt(i, 0);
            if(sim.equals(valor)){
                auxExiste=true;
                break;
            }
        }
        return auxExiste;
    }
    public boolean  verificaEtiq(String text){
        boolean auxExiste=false;
        int filas = tabSim.getRowCount();
        for (int i = 0; i < filas; i++) {
            String valor = (String) tabSim.getValueAt(i, 0);
            if(text.equals(valor)){
                auxExiste=true;
                break;
            }
        }
        return auxExiste;
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
                if(aux1=='"'){
                
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
    public void escribeTabS(String text, String CP){
        if(text.contains("\"")){
        
            String ins=text.trim();
            String inst[]=ins.split(" ");
            String sim=inst[0];
            String tip="Var";
            String val=concatena(text);
            String tabSim[]={sim,tip,val,CP+"h"};
            mst.addRow(tabSim);
        }else{
            String ins=text.trim();
            String inst[]=ins.split(" ");
            String sim=inst[0];
            String tip="Var";
            String val=inst[2];
            String tabSim[]={sim,tip,val,CP+"h"};
            mst.addRow(tabSim);
        }
        
    }
    public int validaPts(String text){
        char aux1;
        aux1=text.charAt(text.length()-1);
        if(aux1==':'){
            return 1;
        }else{
            return 0;
        }
    }
    public String quitaPts(String text){
        String etiq="";
        
        char aux;
        for(int i=0;i<text.length()-1;i++){
            aux=text.charAt(i);
            if(aux!= ':'){
                etiq=etiq + aux;
            }
            
        }
        return etiq;
    }
   
    public int buscaPos(String etiq){
        String diraux="";
        String dir="";
        int pos=0;
        char aux;
        int filas = tabSim.getRowCount();
        for (int i = 0; i <= filas; i++) {
            String valor = (String) tabSim.getValueAt(i, 0);
            if(etiq.equals(valor)){
                diraux=(String) tabSim.getValueAt(i,3);
                pos=i;
                break;
            }
        }
        return pos;
    }
    
    public String direcEt(int pos){
        String diraux="";
        String dir="";
        char aux;
        diraux=(String) tabSim.getValueAt(pos,3);
        
        for(int i=0;i<diraux.length();i++){
            aux=diraux.charAt(i);
            if(aux!='h'){
                dir=dir+aux;
            }
        }
        dir=dir.toUpperCase();
        return dir;
    }
    
    public String quitaCom(String text){
        String ins="";
        char aux=text.charAt(0);
        if(text.charAt(0)==';'){
            ins="";
        }else{
            for(int i=0;i<text.length();i++){
                aux=text.charAt(i);
                if(aux!=';'){
                    ins=ins+aux;
                }else{
                    break;
                }
            }
        }
        return ins;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPaginaA = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabCod = new javax.swing.JTable();
        btnSiguiente = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabSim = new javax.swing.JTable();
        jBtnAntT = new javax.swing.JButton();
        jBtnSigT = new javax.swing.JButton();

        tabCod.setBackground(new java.awt.Color(51, 255, 255));
        tabCod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabCod);

        btnSiguiente.setBackground(new java.awt.Color(255, 255, 153));
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/siguiente.png"))); // NOI18N
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(255, 255, 153));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jScrollPane2.setForeground(new java.awt.Color(0, 255, 255));

        tabSim.setBackground(new java.awt.Color(255, 102, 0));
        tabSim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabSim);

        jBtnAntT.setBackground(new java.awt.Color(255, 255, 153));
        jBtnAntT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        jBtnAntT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAntTActionPerformed(evt);
            }
        });

        jBtnSigT.setBackground(new java.awt.Color(255, 255, 153));
        jBtnSigT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/siguiente.png"))); // NOI18N
        jBtnSigT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSigTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblPaginaA, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnAntT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnSigT))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAtras)
                                .addGap(18, 18, 18)
                                .addComponent(btnSiguiente)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSiguiente)
                            .addComponent(btnAtras))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPaginaA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnSigT)
                            .addComponent(jBtnAntT))
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(51, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        alto = tabCod.getRowHeight() * (filas - 1);
        barra = jScrollPane1.getVerticalScrollBar();
        barra.setValue( barra.getValue() + alto );
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        alto = tabCod.getRowHeight() * (filas-1);
        barra = jScrollPane1.getVerticalScrollBar();
        barra.setValue( barra.getValue() - alto );
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void jBtnSigTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSigTActionPerformed
        alto = tabSim.getRowHeight() * (filas - 1);
        barra = jScrollPane2.getVerticalScrollBar();
        barra.setValue( barra.getValue() + alto );
    }//GEN-LAST:event_jBtnSigTActionPerformed

    private void jBtnAntTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAntTActionPerformed
        alto = tabSim.getRowHeight() * (filas - 1);
        barra = jScrollPane2.getVerticalScrollBar();
        barra.setValue( barra.getValue() - alto );
    }//GEN-LAST:event_jBtnAntTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton jBtnAntT;
    private javax.swing.JButton jBtnSigT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPaginaA;
    public javax.swing.JTable tabCod;
    private javax.swing.JTable tabSim;
    // End of variables declaration//GEN-END:variables
}
