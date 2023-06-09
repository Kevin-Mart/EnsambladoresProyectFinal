/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.Color;

/**
 *
 * @author 
 */
public class pnlSeparar extends javax.swing.JPanel {
    Main m;
    /**
     * Creates new form pnl1
     * @param m
     */
    public pnlSeparar(Main m) {
        initComponents();
        this.m=m;
    }
    String archivo;
    String elementos="";
    String lexemas="";
    boolean error=false;
    int imprimir=15;
    int tamE;
    int tamL;
    int paginasE;
    int paginaE;
    int paginasL;
    int paginaL;
    //Analizador lexico
    int a_i = 0;
    int a_a = 0;
    char[] linea;
    int filesize;
    boolean fin_archivo; 
    int Ren = 1;
    int Col = 1;
    int COMIENZO = 0;
    int ESTADO = 0;
    int c;

    String lexema;
    String el_token;
    int RenAnt = 1;
    int ContCol = 1;

    String pr[] = new String[40];
    
    public void palabrasReservadas() {
        pr[0] = "CLC";
        pr[1] = "CMPSW";
        pr[2] = "INTO";
        pr[3] = "STI";
        pr[4] = "AAM";
        pr[5] = "CLI";
        pr[6] = "DEC";
        pr[7] = "DIV";
        pr[8] = "MUL";
        pr[9] = "IDIV";
        pr[10] = "LDS";
        pr[11] = "MOV";
        pr[12] = "SAR";
        pr[13] = "ROR";
        pr[14] = "JNS";
        pr[15] = "JS";
        pr[16] = "JGE";
        pr[17] = "JNA";
        pr[18] = "LOOPNE";
        pr[19] = "JAE";
        pr[20] = "clc";
        pr[21] = "cmpsw";
        pr[22] = "into";
        pr[23] = "sti";
        pr[24] = "aam";
        pr[25] = "cli";
        pr[26] = "dec";
        pr[27] = "div";
        pr[28] = "mul";
        pr[29] = "idiv";
        pr[30] = "lds";
        pr[31] = "mov";
        pr[32] = "sar";
        pr[33] = "ror";
        pr[34] = "jns";
        pr[35] = "js";
        pr[36] = "jge";
        pr[37] = "jna";
        pr[38] = "loopne";
        pr[39] = "jae";
    }

    public void separarElementos() {
        a_i = 0;
        a_a = 0;
        Ren = 1;
        Col = 1;
        COMIENZO = 0;
        ESTADO = 0;
        RenAnt = 1;
        ContCol = 1;
        elementos="";
        lexemas="";
        fin_archivo = false;
        error = false;
        filesize = m.tamA;
        while (!(fin_archivo)) {
            RenAnt = Ren;
            Col = ContCol;
            el_token = Token();
            if (!el_token.equals("NoSirve")) {
                lexemas+=lexema+"\n\r";
                elementos+=el_token+"\n\r";
            }
        }
        if (error==false) {
            System.out.println("Lexemas:\n\n"+lexemas);
            System.out.println("elementos:\n\n"+elementos);
            construirElementos();
            construirLexemas();
        }
    }

    public boolean es_letra(int x) {
        if ((x >= 65 && x <= 90) || (x>=97 && x<= 122) ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean es_digito(int x) {
        if ((x >= 48 && x <= 57)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean es_simbolo(int x){
        if( x==40 || x ==41 || x==43 || x == 44 || x == 46 || x == 58 || x == 59){
            return true;
        }else{
            return false;
        }
    }
    public String obten_lexema() {
        String lex = "";
        for (int i = a_i; i < a_a; i++) {
            lex = lex + archivo.charAt(i);
        }
       if(ESTADO==12 || ESTADO==26 ||ESTADO==35 || ESTADO==44){
            lex = ".";
        for (int i = a_i; i < a_a; i++) {
            lex = lex + archivo.charAt(i);
        }
        }
        
        return lex;
    }

    public int lee_car() {
        if (a_a <= filesize - 1) {
            if (archivo.charAt(a_a) == 10) {
                ContCol = 1;
                Ren++;
            } else {
                ContCol++;
            }
            return archivo.charAt(a_a++);  //DEVUELVE SOLO EL CARACTER E INCREMENTA EL APUNTADOR DE AVANCE
        } else {
            fin_archivo = true;
            return 225;
        }
    }

    public int diagrama() {
        Ren = RenAnt;
        ContCol = Col;
        a_a = a_i;
        switch (COMIENZO) {
            case 0:
                COMIENZO = 13;
                break;
            case 13:
                COMIENZO = 27;
                break;
            case 27:
                COMIENZO = 36;
                break;
            case 36:
                COMIENZO = 45;
                break;
            case 45:
                COMIENZO = 51;
                break;
            case 51:
                COMIENZO = 54;
                break;
            case 54:
                COMIENZO = 57;
                break;
            case 57:
                COMIENZO = 60;
                break;
            case 60:
                COMIENZO = 63;
                break;
            case 63:
                COMIENZO = 66;
                break;
            case 66:
                COMIENZO = 69;
                break;
            case 69:
                COMIENZO = 72;
                break;
            case 72:
                ruterror();
                break;
        }
        return COMIENZO;
    }

    public String Token() {
        ESTADO = 0;
        COMIENZO = 0;
        while (!error) {
            switch (ESTADO) {
                case 0:
                    c = lee_car();
                    if (c == 'D' || c== 'C'|| c== 'c') {
                        ESTADO = 1;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 1:
                    c = lee_car();
                    if (c == 'a' || c== 'o') {
                        ESTADO = 2;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 2:
                    c = lee_car();
                    if (c == 't'|| c== 'd') {
                        ESTADO = 3;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 3:
                    c = lee_car();
                    if (c == 'a'|| c== 'e') {
                        ESTADO = 4;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 4:
                    c = lee_car();
                    if (c == ' ') {
                        ESTADO = 5;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 5:
                    c = lee_car();
                    if (c == 'S'||c == 's') {
                        ESTADO = 6;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 6:
                    c = lee_car();
                    if (c == 'e') {
                        ESTADO = 7;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 7:
                    c = lee_car();
                    if (c == 'g') {
                        ESTADO = 8;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 8:
                    c = lee_car();
                    if (c == 'm') {
                        ESTADO = 9;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 9:
                    c = lee_car();
                    if (c == 'e') {
                        ESTADO = 10;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 10:
                    c = lee_car();
                    if (c == 'n') {
                        ESTADO = 11;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 11:
                    c = lee_car();
                    if (c == 't') {
                        ESTADO = 12;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 12:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("Pseudoinstruccion");
                case 13:
                    c = lee_car();
                    if (c == 'S'||c=='s') {
                        ESTADO = 14;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 14:
                    c = lee_car();
                    if (c == 't') {
                        ESTADO = 15;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 15:
                    c = lee_car();
                    if (c == 'a') {
                        ESTADO = 16;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 16:
                    c = lee_car();
                    if (c == 'c') {
                        ESTADO = 17;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 17:
                    c = lee_car();
                    if (c == 'k') {
                        ESTADO = 18;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 18:
                    c = lee_car();
                    if (c == ' ') {
                        ESTADO = 19;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 19:
                    c = lee_car();
                    if (c == 'S'||c=='s') {
                        ESTADO = 20;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 20:
                    c = lee_car();
                    if (c == 'e') {
                        ESTADO = 21;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 21:
                    c = lee_car();
                    if (c == 'g') {
                        ESTADO = 22;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 22:
                    c = lee_car();
                    if (c == 'm') {
                        ESTADO = 23;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 23:
                    c = lee_car();
                    if (c == 'e') {
                        ESTADO = 24;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 24:
                    c = lee_car();
                    if (c == 'n') {
                        ESTADO = 25;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 25:
                    c = lee_car();
                    if (c == 't') {
                        ESTADO = 26;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 26:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("Pseudoinstruccion");
                case 27:
                    c = lee_car();
                    if (c == 'b') {
                        ESTADO = 28;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 28:
                    c = lee_car();
                    if (c == 'y') {
                        ESTADO = 29;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 29:
                    c = lee_car();
                    if (c == 't') {
                        ESTADO = 30;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 30:
                    c = lee_car();
                    if (c == 'e') {
                        ESTADO = 31;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 31:
                    c = lee_car();
                    if (c == ' ') {
                        ESTADO = 32;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 32:
                    c = lee_car();
                    if (c == 'p') {
                        ESTADO = 33;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 33:
                    c = lee_car();
                    if (c == 't') {
                        ESTADO = 34;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 34:
                    c = lee_car();
                    if (c == 'r') {
                        ESTADO = 35;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 35:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("PseudoInstruccion");
                case 36:
                    c = lee_car();
                    if (c == 'w') {
                        ESTADO = 37;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 37:
                    c = lee_car();
                    if (c == 'o') {
                        ESTADO = 38;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 38:
                    c = lee_car();
                    if (c == 'r') {
                        ESTADO = 39;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 39:
                    c = lee_car();
                    if (c == 'd') {
                        ESTADO = 40;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 40:
                    c = lee_car();
                    if (c == ' ') {
                        ESTADO = 41;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 41:
                    c = lee_car();
                    if (c == 'p') {
                        ESTADO = 42;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 42:
                    c = lee_car();
                    if (c == 't') {
                        ESTADO = 43;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 43:
                    c = lee_car();
                    if (c == 'r') {
                        ESTADO = 44;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 44:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("PseudoInstruccion");
                case 45:
                    c = lee_car();
                    if (c == 'd') {
                        ESTADO = 46;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 46:
                    c = lee_car();
                    if (c == 'u') {
                        ESTADO = 47;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 47:
                    c = lee_car();
                    if (c == 'p') {
                        ESTADO = 48;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 48:
                    c = lee_car();
                    if (c == '(') {
                        ESTADO = 49;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 49:
                    c = lee_car();
                    if (es_digito(c) || es_letra(c)) {
                        ESTADO = 49;
                    } else if (c == ')') {
                        ESTADO = 50;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 50:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("PseudoInstruccion");
                case 51:
                    c = lee_car();                    
                    ESTADO = 52;
                    break;
                case 52:
                    c = lee_car();
                    if (es_digito(c) || es_letra(c)) {
                        ESTADO = 52;
                    } else if (c == ':') {
                        ESTADO = 53;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 53:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("Etiqueta");
                case 54:
                    c = lee_car();
                    if (c == '"') {
                        ESTADO = 55;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 55:
                    c = lee_car();
                    if (c != 9 && c != 10 && c != 13 && c !='"') {
                        ESTADO = 55;
                    } else if (c == '"') {
                        ESTADO = 56;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 56:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("Constante");
                case 57:
                    c = lee_car();
                    if (c == 39) {
                        ESTADO = 58;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 58:
                    c = lee_car();
                    if (es_digito(c) || es_letra(c)) {
                        ESTADO = 58;
                    } else if (c == 39) {
                        ESTADO = 59;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 59:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("Constante");
                case 60:
                    c = lee_car();
                    if (es_letra(c)) {
                        ESTADO = 61;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 61:
                    c = lee_car();
                    //es_letra(c) || es_digito(c)  esto va dentro del si
                    if (c != ' ' && c != 9 && c != 10 && c != 13 && c!=43 && c!=44 && c!= 58 && c!= 59) {
                        ESTADO = 61;
                    } else {
                        ESTADO = 62;
                    }
                    break;
                case 62:
                    a_a--;
                    ContCol--;
                    //se tiene que saber si es una palabra reservada
                    lexema = obten_lexema();
                    a_i = a_a;
                    if (es_pr(lexema)) {
                        return ("Instruccion");
                    } else {
                        return es_Instruccion_Especial(lexema);
                    }
                case 63:
                    c = lee_car();
                    if (c == ' ' || c == 9 || c == 10 || c == 13) {
                        ESTADO = 64;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 64:
                    c = lee_car();
                    if (c == ' ' || c == 9 || c == 10 || c == 13) {
                        ESTADO = 64;
                    } else {
                        ESTADO = 65;
                    }
                    break;
                case 65:
                    a_a--;
                    ContCol--;
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("NoSirve");
                case 66:
                    c=lee_car(); 
                    if (es_digito(c)) {
                        if (c==48) {
                            ESTADO = 79;
                        }else{
                            ESTADO = 67;
                        }
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 79:
                    c=lee_car(); 
                    if (es_digito(c)) {
                        ESTADO = 79;
                    }else{
                        ESTADO = 80;
                    }
                    break;
                case 80:
                    
                   if (c == 'h' || c == 'H' ) {
                        
                        lexema = obten_lexema();
                        a_i = a_a;
                        int longitud = 0 ;
                           if(lexema.length()%2==0){
                            char lexe[] = lexema.toCharArray();
                            
                              for(int i=0; i<=lexema.length();i++){                             
                                 if(lexe[i] == 'A' || lexe[i] == 'B' || lexe[i] == 'C' || lexe[i] == 'D' || lexe[i] == 'E' || lexe[i] == 'F' 
                                     || lexe[i] == '1' || lexe[i] == '2' || lexe[i] == '3' || lexe[i] == '4' || lexe[i] == '5' || lexe[i] == '6'
                                     || lexe[i] == '7' || lexe[i] == '8' || lexe[i] == '9' || lexe[i] == '0'){
                                      longitud++ ; 
                                      
                                        return ("Constante Hexadecimal");
                                        
                                      }else 
                                       return("Error Hexadecimal");
                                                                      
                                }
                             
                              }else{                           
                                   return ("Simbolo");    
                              }                                                                                          
                    }
                    else if(c == 'b' || c == 'B') {                        
                        lexema = obten_lexema();
                        a_i = a_a;
                        char lexe[] = lexema.toCharArray();
                    if(lexema.length()%2==0){
                        for(int i=1; i<=lexema.length()-1;i++){
                          if(lexe[i] == '0' || lexe[i] == '1' ){
                          return ("Constante numerica Binaria");                         
                          }
                        }                                                   
                    }else{                          
                            return ("Simbolo");    
                    }   
                    }else {
                       a_a--;
                      ContCol--;
                        lexema = obten_lexema();
                        a_i = a_a;
                        return ("Constante numerica Decimal");
                    }
                    
                case 67:
                    c=lee_car(); 
                    if (es_digito(c)) {
                        ESTADO = 67;
                    }else{
                        ESTADO = 68;
                    }
                    break;
                case 68:
                        if (es_letra(c)) {
                            ESTADO = 81;
                        }else{
                            a_a--;
                            ContCol--;
                            lexema = obten_lexema();
                            a_i = a_a;
                            return ("Constante numerica Decimal");
                        }
                        break;
                case 81:
                    c=lee_car();
                    if (es_digito(c)||es_letra(c)) {
                        ESTADO = 81;
                    }else{
                            a_a--;
                            ContCol--;
                            lexema = obten_lexema();
                            a_i = a_a;
                            return ("Simbolo");
                    }
                    break;
                case 69:
                    c = lee_car();
                    if (c == ';') {
                        ESTADO = 70;
                    } else {
                        ESTADO = diagrama();
                    }
                    break;
                case 70:
                    c=lee_car(); 
                    if (c == 10 || a_a == m.tamA) {
                        ESTADO = 71;
                    } else {
                        ESTADO = 70;
                    }
                    break;
                case 71:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("NoSirve");
                case 72:
                    c = lee_car();
                    switch (c) {
                        case 40:
                            ESTADO = 73;
                            break;
                        case 41:
                            ESTADO = 74;
                            break;
                        case 43:
                            ESTADO = 75;
                            break;
                        case 44:
                            ESTADO = 76;
                            break;
                        case 46:
                            ESTADO = 77;
                            break;
                        case 58:
                            ESTADO = 78;
                            break;
                    }
                case 73:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("NoSirve");
                case 74:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("NoSirve");
                case 75:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("NoSirve");
                case 76:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("NoSirve");
                case 77:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("NoSirve");
                case 78:
                    lexema = obten_lexema();
                    a_i = a_a;
                    return ("NoSirve");
            }
        }
        return ("\n\nError");
    }
    public String es_Instruccion_Especial(String simbolo){
        if (simbolo.equals("ends")||simbolo.equals("ENDS")) {
            return "PseudoInstruccion";
        }else if (simbolo.equals("db")||simbolo.equals("DB")) {
            return "PseudoInstruccion";
        }else if (simbolo.equals("dw")||simbolo.equals("DW")) {
            return "PseudoInstruccion";
        }else if (simbolo.equals("equ")||simbolo.equals("EQU")) {
            return "PseudoInstruccion";
        }else if (simbolo.equals("dub")||simbolo.equals("DUB")) {
            return "PseudoInstruccion";
        }else if (simbolo.equals("macro")||simbolo.equals("MACRO")) {
            return "PseudoInstruccion";
        }else if (simbolo.equals("endm")||simbolo.equals("ENDM")) {
            return "PseudoInstruccion";
        }else if (simbolo.equals("proc")||simbolo.equals("PROC")) {
            return "PseudoInstruccion";
        }else if (simbolo.equals("endp")||simbolo.equals("ENDP")) {
            return "PseudoInstruccion";    
        }else if (simbolo.equals("ax")||simbolo.equals("AX")) {
            return "Registro";
        }else if (simbolo.equals("ah")||simbolo.equals("AH")) {
            return "Registro";
        }else if (simbolo.equals("al")||simbolo.equals("AL")) {
            return "Registro";
        }else if (simbolo.equals("bx")||simbolo.equals("BX")) {
            return "Registro";
        }else if (simbolo.equals("bh")||simbolo.equals("BH")) {
            return "Registro";
        }else if (simbolo.equals("bl")||simbolo.equals("BL")) {
            return "Registro";
        }else if (simbolo.equals("cx")||simbolo.equals("CX")) {
            return "Registro";
        }else if (simbolo.equals("ch")||simbolo.equals("CH")) {
            return "Registro";
        }else if (simbolo.equals("cl")||simbolo.equals("cl")) {
            return "Registro";
        }else if (simbolo.equals("dx")||simbolo.equals("DX")) {
            return "Registro";
        }else if (simbolo.equals("dh")||simbolo.equals("DH")) {
            return "Registro";
        }else if (simbolo.equals("dl")||simbolo.equals("DL")) {
            return "Registro";
        }else if (simbolo.equals("si")||simbolo.equals("SI")) {
            return "Registro";
        }else if (simbolo.equals("DI")||simbolo.equals("DI")) {
            return "Registro";
        }else if (simbolo.equals("sp")||simbolo.equals("SP")) {
            return "Registro";
        }else if (simbolo.equals("bp")||simbolo.equals("BP")) {
            return "Registro";
        }else if (simbolo.equals("ss")||simbolo.equals("SS")) {
            return "Registro";
        }else if (simbolo.equals("cs")||simbolo.equals("CS")) {
            return "Registro";
        }else if (simbolo.equals("ds")||simbolo.equals("DS")) {
            return "Registro";
        }else  if (simbolo.equals("es")||simbolo.equals("ES")) {
            return "Registro";
        } else{
            return "Simbolo";
        }
    }
    public boolean es_pr(String x) {
        for (int i = 0; i <=23; i++) {
            if (x.equals(pr[i])) {
                return true;
            }
        }
        return false;
    }

    public void ruterror() {
        char b = (char) c;
        String mensaje = " ERROR Lexico:\nCARACTER LEIDO[ " + b + " ]\n(" + Ren + "," + Col + ")";
        //JOptionPane.showMessageDialog(null, mensaje);
        lexema=b+"";
        fin_archivo=true;
        error=true;
        //txtMensajes.setForeground(Color.red);
        //txtMensajes.setText(mensaje);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPagina = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLexema = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtElemento = new javax.swing.JTextArea();
        btnAtrasE = new javax.swing.JButton();
        btnSiguienteE = new javax.swing.JButton();
        lblPaginaE = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        txtLexema.setColumns(20);
        txtLexema.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        txtLexema.setRows(5);
        jScrollPane2.setViewportView(txtLexema);

        txtElemento.setColumns(20);
        txtElemento.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 14)); // NOI18N
        txtElemento.setRows(5);
        jScrollPane4.setViewportView(txtElemento);

        btnAtrasE.setBackground(new java.awt.Color(102, 255, 102));
        btnAtrasE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        btnAtrasE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasEActionPerformed(evt);
            }
        });

        btnSiguienteE.setBackground(new java.awt.Color(102, 255, 102));
        btnSiguienteE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/siguiente.png"))); // NOI18N
        btnSiguienteE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteEActionPerformed(evt);
            }
        });

        lblPaginaE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Simbolo");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Tipo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtrasE, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(lblPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSiguienteE, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212)))
                .addComponent(lblPaginaE, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1)
                .addGap(161, 161, 161)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(lblPaginaE, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSiguienteE, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtrasE, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasEActionPerformed
        if(paginaL>1){
            paginaL--;
            paginaE--;
            mostrarElementos();
            mostrarLexema();
            //lblPaginaE.setText("Pagina: "+paginaE+" de "+paginasE);
        }
    }//GEN-LAST:event_btnAtrasEActionPerformed

    private void btnSiguienteEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteEActionPerformed
        if(paginaL<paginasL){
            paginaL++;
            paginaE++;
            mostrarElementos();
            mostrarLexema();
            //lblPaginaE.setText("Pagina: "+paginaE+" de "+paginasE);
        }
    }//GEN-LAST:event_btnSiguienteEActionPerformed
    public void construirElementos(){
        int cont=1;
        paginasE=1;
        tamE=elementos.length();
        for (int i = 0; i < tamE; i++) {
            if (elementos.charAt(i) == '\n') {
                if (cont == imprimir) {
                    paginasE++;
                    cont=1;
                }else{
                    cont++;
                }
            }
        }
        paginaE=1;
        mostrarElementos();
        //mostrarLexema();
        
        //lblPaginaE.setText("Pagina: "+paginaE+" de "+paginasE);
        //System.out.println("Paginas: "+paginasA);
        //System.out.println("Pagina:"+paginaA);
    }
    void construirLexemas(){
        int cont=1;
        paginasL=1;
        tamL=lexemas.length();
        for (int i = 0; i < tamL; i++) {
            if (lexemas.charAt(i) == '\n') {
                if (cont == imprimir) {
                    paginasL++;
                    cont=1;
                }else{
                    cont++;
                }
            }
        }
        paginaL=1;
        //mostrarElementos();
        mostrarLexema();
        //lblPaginaE.setText(paginaE+"/"+paginasE);
        //System.out.println("Paginas: "+paginasA);
        //System.out.println("Pagina:"+paginaA);
    }
    public void mostrarElementos(){
        int cont=1;
        int renglonObjetivo=paginaE;
        int renglonBuscador=1;
        String pag="";
        int i=0;
        while(renglonBuscador<renglonObjetivo){
            if (elementos.charAt(i) == '\n') {
                if(cont==imprimir){
                    renglonBuscador++;
                    cont=1;
                }else{
                    cont++;
                }
            }
            i++;
        }
        while(renglonBuscador<=renglonObjetivo&&i<tamE){
            pag += elementos.charAt(i);
            if (elementos.charAt(i) == '\n') {
                if (cont==imprimir) {
                    renglonBuscador++;
                    cont=1;
                }else{
                    cont++;
                }
            }
            i++;
        }
        txtElemento.setText(pag);
    }
    public void mostrarLexema(){
        int cont=1;
        int renglonObjetivo=paginaL;
        int renglonBuscador=1;
        String pag="";
        int i=0;
        while(renglonBuscador<renglonObjetivo){
            if (lexemas.charAt(i) == '\n') {
                if(cont==imprimir){
                    renglonBuscador++;
                    cont=1;
                }else{
                    cont++;
                }
            }
            i++;
        }
        while(renglonBuscador<=renglonObjetivo&&i<tamL){
            pag += lexemas.charAt(i);
            if (lexemas.charAt(i) == '\n') {
                if (cont==imprimir) {
                    renglonBuscador++;
                    cont=1;
                }else{
                    cont++;
                }
            }
            i++;
        }
        txtLexema.setText(pag);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtrasE;
    private javax.swing.JButton btnSiguienteE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblPagina;
    public javax.swing.JLabel lblPaginaE;
    public javax.swing.JTextArea txtElemento;
    public javax.swing.JTextArea txtLexema;
    // End of variables declaration//GEN-END:variables
}
