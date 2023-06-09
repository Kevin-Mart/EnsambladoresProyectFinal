/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

/**
 *
 */
public class ValidaCodS {

    public ValidaCodS() {
    }

    public int validaDAA(String text) {
        String ins = text.trim();
        String auxIns[] = ins.split(" ");
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 1) {
            if (pal.charAt(0) == 'D' || pal.charAt(0) == 'd') {
                if (pal.charAt(1) == 'A' || pal.charAt(1) == 'a') {
                    if (pal.charAt(2) == 'A' || pal.charAt(2) == 'a') {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        } else {
            return -2;
        }
        return 0;
    }

    public int validaPUSHF(String text) {
        String ins = text.trim();
        String auxIns[] = ins.split(" ");
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 1) {
            if (pal.charAt(0) == 'P' || pal.charAt(0) == 'p') {
                if (pal.charAt(1) == 'U' || pal.charAt(1) == 'u') {
                    if (pal.charAt(2) == 'S' || pal.charAt(2) == 's') {
                        if (pal.charAt(2) == 'H' || pal.charAt(2) == 'h') {
                            if (pal.charAt(2) == 'F' || pal.charAt(2) == 'f') {
                                return 1;
                            } else {
                                return -1;
                            }
                        }
                    }
                }
            }
        } else {
            return -2;
        }
        return 0;
    }

    public int validaCLC(String text) {
        String ins = text.trim();
        String auxIns[] = ins.split(" ");
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 1) {
            if (pal.charAt(0) == 'C' || pal.charAt(0) == 'c') {
                if (pal.charAt(1) == 'L' || pal.charAt(1) == 'l') {
                    if (pal.charAt(2) == 'C' || pal.charAt(2) == 'c') {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        } else {
            return -2;
        }
        return 0;
    }

    public int validaCLD(String text) {
        String ins = text.trim();
        String auxIns[] = ins.split(" ");
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 1) {
            if (pal.charAt(0) == 'C' || pal.charAt(0) == 'c') {
                if (pal.charAt(1) == 'L' || pal.charAt(1) == 'l') {
                    if (pal.charAt(2) == 'D' || pal.charAt(2) == 'd') {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        } else {
            return -2;
        }
        return 0;
    }

    public int validaDEC(String text) {
        String ins = text.trim();
        String auxIns[] = ins.split(" ");
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 1) {
            if (pal.charAt(0) == 'D' || pal.charAt(0) == 'd') {
                if (pal.charAt(1) == 'E' || pal.charAt(1) == 'e') {
                    if (pal.charAt(2) == 'C' || pal.charAt(2) == 'c') {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        } else {
            return -2;
        }
        return 0;
    }

    public int validaRET(String text) {
        String ins = text.trim();
        String auxIns[] = ins.split(" ");
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 1) {
            if (pal.charAt(0) == 'R' || pal.charAt(0) == 'c') {
                if (pal.charAt(1) == 'E' || pal.charAt(1) == 'm') {
                    if (pal.charAt(2) == 'T' || pal.charAt(2) == 'p') {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        } else {
            return -2;
        }
        return 0;
    }

    public int validaDAS(String text) {
        String ins = text.trim();
        String auxIns[] = ins.split(" ");
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 1) {
            if (pal.charAt(0) == 'D' || pal.charAt(0) == 'd') {
                if (pal.charAt(1) == 'A' || pal.charAt(1) == 'a') {
                    if (pal.charAt(2) == 'S' || pal.charAt(2) == 's') {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        } else {
            return -2;
        }
        return 0;
    }

    public int validaIMUL(String text) {
        String ins = text.trim();
        String auxIns[] = ins.split(" ");
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 1) {
            if (pal.charAt(0) == 'I' || pal.charAt(0) == 'i') {
                if (pal.charAt(1) == 'M' || pal.charAt(1) == 'm') {
                    if (pal.charAt(2) == 'U' || pal.charAt(2) == 'u') {
                        if (pal.charAt(3) == 'L' || pal.charAt(3) == 'l') {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }

            }
        } else {
            return -2;
        }
        return 0;
    }

    public int validaPOP(String text) {
        String ins = text.trim();
        String auxIns[] = ins.split(" ");
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 1) {
            if (pal.charAt(0) == 'P' || pal.charAt(0) == 'p') {
                if (pal.charAt(1) == 'O' || pal.charAt(1) == 'o') {
                    if (pal.charAt(2) == 'P' || pal.charAt(2) == 'p') {
                        return 1;
                    } else {
                        return -1;
                    }

                }
            }
        } else {
            return -2;
        }
        return 0;
    }

    public int validaXCHG(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);

        if (auxIns.length == 3) {
            String pal = auxIns[0];
            String op1 = auxIns[1];
            String op2 = auxIns[2];
            if (op1.equals("XCHG") || op2.equals("xchg")) {
                return -1;//orden incorrecto
            } else {
                if (pal.charAt(0) == 'X' || pal.charAt(0) == 'x') {
                    if (pal.charAt(1) == 'C' || pal.charAt(1) == 'c') {
                        if (pal.charAt(2) == 'H' || pal.charAt(2) == 'h') {
                            if (pal.charAt(2) == 'G' || pal.charAt(2) == 'g') {
                                ValidaTam tamano = new ValidaTam();
                                int flgTam = tamano.valida(text);
                                if (flgTam == 1) {
                                    return 1;
                                } else {
                                    if (flgTam == -2) {
                                        return -5;
                                    } else {
                                        if (flgTam == -3) {
                                            return -6;
                                        } else {
                                            return -4;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (auxIns.length < 3) {
                return -2;//faltan operandos
            } else {
                return -3;//Operandos extras
            }
        }
        return 0;
    }

    public int validaIDIV(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);

        if (auxIns.length == 2) {
            String pal = auxIns[0];
            String op1 = auxIns[1];

            if (op1.equals("IDIV")) {
                return -1;//orden incorrecto
            } else {
                if (pal.charAt(0) == 'I' || pal.charAt(0) == 'i') {
                    if (pal.charAt(1) == 'D' || pal.charAt(1) == 'd') {
                        if (pal.charAt(2) == 'I' || pal.charAt(2) == 'i') {
                            if (pal.charAt(3) == 'V' || pal.charAt(3) == 'v') {
                                ValidaTam tamano = new ValidaTam();

                                return 1;
                            }
                        }
                    }
                }
            }
        } else {
            if (auxIns.length < 2) {
                return -2;//faltan operandos
            } else {
                return -3;//Operandos extras
            }
        }
        return 0;

    }

    public int validaCMP(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);

        if (auxIns.length == 2) {
            String pal = auxIns[0];
            String op1 = auxIns[1];

            if (op1.equals("CMP")) {
                return -1;//orden incorrecto
            } else {
                if (pal.charAt(0) == 'C' || pal.charAt(0) == 'c') {
                    if (pal.charAt(1) == 'M' || pal.charAt(1) == 'm') {
                        if (pal.charAt(2) == 'P' || pal.charAt(2) == 'p') {
                            ValidaTam tamano = new ValidaTam();

                            return 1;
                        }
                    }
                }

            }
        } else {
            if (auxIns.length < 2) {
                return -2;//faltan operandos
            } else {
                return -3;//Operandos extras
            }
        }
        return 0;

    }

    public int validaLES(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);

        if (auxIns.length == 2) {
            String pal = auxIns[0];
            String op1 = auxIns[1];

            if (op1.equals("DEC")) {
                return -1;//orden incorrecto
            } else {
                if (pal.charAt(0) == 'L' || pal.charAt(0) == 'l') {
                    if (pal.charAt(1) == 'E' || pal.charAt(1) == 'e') {
                        if (pal.charAt(2) == 'S' || pal.charAt(2) == 's') {
                            ValidaTam tamano = new ValidaTam();
                            return 1;
                        }
                    }
                }
            }
        } else {
            if (auxIns.length < 2) {
                return -2;//faltan operandos
            } else {
                return -3;//Operandos extras
            }
        }
        return 0;

    }

    public int validaRCL(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);

        if (auxIns.length == 2) {
            String pal = auxIns[0];
            String op1 = auxIns[1];

            if (op1.equals("MUL")) {
                return -1;//orden incorrecto
            } else {
                if (pal.charAt(0) == 'R' || pal.charAt(0) == 'r') {
                    if (pal.charAt(1) == 'C' || pal.charAt(1) == 'c') {
                        if (pal.charAt(2) == 'L' || pal.charAt(2) == 'l') {
                            ValidaTam tamano = new ValidaTam();
                            return 1;
                        }
                    }
                }
            }
        } else {
            if (auxIns.length < 2) {
                return -2;//faltan operandos
            } else {
                return -3;//Operandos extras
            }
        }
        return 0;

    }

    public int validaJB(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);

        if (auxIns.length == 2) {
            String pal = auxIns[0];
            String op1 = auxIns[1];

            if (op1.equals("JB")) {
                return -1;//orden incorrecto
            } else {
                if (pal.charAt(0) == 'J' || pal.charAt(0) == 'j') {
                    if (pal.charAt(1) == 'B' || pal.charAt(1) == 'b') {
                            ValidaTam tamano = new ValidaTam();
                            return 1;                   
                    }
                }
            }
        } else {
            if (auxIns.length < 2) {
                return -2;//faltan operandos
            } else {
                return -3;//Operandos extras
            }
        }
        return 0;

    }

    public int validaNOT(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);

        if (auxIns.length == 2) {
            String pal = auxIns[0];
            String op1 = auxIns[1];

            if (op1.equals("NEG")) {
                return -1;//orden incorrecto
            } else {
                if (pal.charAt(0) == 'N' || pal.charAt(0) == 'n') {
                    if (pal.charAt(1) == 'O' || pal.charAt(1) == 'o') {
                        if (pal.charAt(2) == 'T' || pal.charAt(2) == 't') {
                            ValidaTam tamano = new ValidaTam();
                            return 1;
                        }
                    }
                }
            }
        } else {
            if (auxIns.length < 2) {
                return -2;//faltan operandos
            } else {
                return -3;//Operandos extras
            }
        }
        return 0;

    }

    public int validaAND(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);

        if (auxIns.length == 3) {
            String pal = auxIns[0];
            String op1 = auxIns[1];
            String op2 = auxIns[2];
            if (op1.equals("AND") || op2.equals("and")) {
                return -1;//orden incorrecto
            } else {
                if (pal.charAt(0) == 'A' || pal.charAt(0) == 'a') {
                    if (pal.charAt(1) == 'N' || pal.charAt(1) == 'n') {
                        if (pal.charAt(2) == 'D' || pal.charAt(2) == 'd') {
                            ValidaTam tamano = new ValidaTam();
                            int flgTam = tamano.valida(text);
                            if (flgTam == 1) {
                                return 1;
                            } else {
                                if (flgTam == -2) {
                                    return -5;
                                } else {
                                    if (flgTam == -3) {
                                        return -6;
                                    } else {
                                        return -4;
                                    }

                                }

                            }
                        }
                    }
                }
            }
        } else {
            if (auxIns.length < 3) {
                return -2;//faltan operandos
            } else {
                return -3;//Operandos extras
            }
        }
        return 0;
    }

    public int validaROR(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);

        if (auxIns.length == 3) {
            String pal = auxIns[0];
            String op1 = auxIns[1];
            String op2 = auxIns[2];
            if (op1.equals("ROR") || op2.equals("ror")) {
                return -1;//orden incorrecto
            } else {
                if (pal.charAt(0) == 'R' || pal.charAt(0) == 'r') {
                    if (pal.charAt(1) == 'O' || pal.charAt(1) == 'o') {
                        if (pal.charAt(2) == 'R' || pal.charAt(2) == 'r') {
                            ValidaTam tamano = new ValidaTam();
                            int flgTam = tamano.valida(text);
                            if (flgTam == 1) {
                                return 1;
                            } else {
                                if (flgTam == -2) {
                                    return -5;
                                } else {
                                    if (flgTam == -3) {
                                        return -6;
                                    } else {
                                        return -4;
                                    }

                                }

                            }
                        }
                    }
                }
            }
        } else {
            if (auxIns.length < 3) {
                return -2;//faltan operandos
            } else {
                return -3;//Operandos extras
            }
        }
        return 0;
    }

    public int validaTEST(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);

        if (auxIns.length == 3) {
            String pal = auxIns[0];
            String op1 = auxIns[1];
            String op2 = auxIns[2];
            if (op1.equals("TEST") || op2.equals("test")) {
                return -1;//orden incorrecto
            } else {
                if (pal.charAt(0) == 'T' || pal.charAt(0) == 't') {
                    if (pal.charAt(1) == 'E' || pal.charAt(1) == 'e') {
                        if (pal.charAt(2) == 'S' || pal.charAt(2) == 'e') {
                            if (pal.charAt(3) == 'T' || pal.charAt(3) == 't') {
                                ValidaTam tamano = new ValidaTam();
                                int flgTam = tamano.valida(text);
                                if (flgTam == 1) {
                                    return 1;
                                } else {
                                    if (flgTam == -2) {
                                        return -5;
                                    } else {
                                        if (flgTam == -3) {
                                            return -6;
                                        } else {
                                            return -4;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (auxIns.length < 3) {
                return -2;//faltan operandos
            } else {
                return -3;//Operandos extras
            }
        }
        return 0;
    }

    public int validaJE(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 2) {
            if (pal.charAt(0) == 'J' || pal.charAt(0) == 'j') {
                if (pal.charAt(1) == 'E' || pal.charAt(1) == 'e') {
                    return 1;
                } else {
                    return -1;
                }
            }
        } else {
            if (auxIns.length < 3) {
                return -2;
            } else {
                return -3;
            }
        }
        return 0;
    }

    public int validaJG(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 2) {
            if (pal.charAt(0) == 'J' || pal.charAt(0) == 'j') {
                if (pal.charAt(1) == 'G' || pal.charAt(1) == 'g') {
                    return 1;
                } else {
                    return -1;
                }
            }
        } else {
            if (auxIns.length < 3) {
                return -2;
            } else {
                return -3;
            }
        }
        return 0;
    }

    public int validaJNO(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 2) {
            if (pal.charAt(0) == 'J' || pal.charAt(0) == 'j') {
                if (pal.charAt(1) == 'N' || pal.charAt(1) == 'n') {
                    if (pal.charAt(2) == 'O' || pal.charAt(1) == 'o') {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        } else {
            if (auxIns.length < 3) {
                return -2;
            } else {
                return -3;
            }
        }
        return 0;
    }

    public int validaJNP(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 2) {
            if (pal.charAt(0) == 'J' || pal.charAt(0) == 'j') {
                if (pal.charAt(1) == 'N' || pal.charAt(1) == 'n') {
                    if (pal.charAt(2) == 'P' || pal.charAt(1) == 'p') {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        } else {
            if (auxIns.length < 3) {
                return -2;
            } else {
                return -3;
            }
        }
        return 0;
    }

    public int validaJA(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 2) {
            if (pal.charAt(0) == 'J' || pal.charAt(0) == 'j') {
                if (pal.charAt(1) == 'A' || pal.charAt(1) == 'a') {
                    return 1;
                } else {
                    return -1;
                }
            }
        } else {
            if (auxIns.length < 3) {
                return -2;
            } else {
                return -3;
            }
        }
        return 0;
    }

    public int validaJNC(String text) {
        String ins = text.trim();
        String separadores = "[\\ \\,]";
        String auxIns[] = ins.split(separadores);
        String pal = auxIns[0];
        char aux;
        if (auxIns.length == 2) {
            if (pal.charAt(0) == 'J' || pal.charAt(0) == 'j') {
                if (pal.charAt(1) == 'N' || pal.charAt(1) == 'n') {
                    if (pal.charAt(2) == 'C' || pal.charAt(1) == 'c') {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        } else {
            if (auxIns.length < 3) {
                return -2;
            } else {
                return -3;
            }
        }
        return 0;
    }

    public int validaSaltos(String text) {
        int flg = 0;
        if (text.contains("JE") || text.contains("je")) {
            flg = validaJE(text);
        }
        if (text.contains("JNO") || text.contains("jno")) {
            flg = validaJNO(text);
        }
        if (text.contains("JG") || text.contains("jg")) {
            flg = validaJG(text);
        }
        if (text.contains("JNP") || text.contains("jnp")) {
            flg = validaJNP(text);
        }
        if (text.contains("JA") || text.contains("ja")) {
            flg = validaJA(text);
        }
        if (text.contains("JNC") || text.contains("jnc")) {
            flg = validaJNC(text);
        }
        return flg;
    }

}
