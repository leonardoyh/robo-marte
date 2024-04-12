package com.robo.util;

public class ComandoUtil {

    public static final String COMANDOS_VALIDOS_REGEX = "^[LRMlrm]+$";

    public static boolean isTodosComandosValidos(String comandos) {
        return comandos.matches(COMANDOS_VALIDOS_REGEX);
    }

}
