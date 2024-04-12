package com.robo.service;

import com.robo.exception.CustomGenericException;
import com.robo.interfaces.IRoboService;
import com.robo.model.OrientationEnum;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.robo.model.OrientationEnum.*;
import static com.robo.util.ComandoUtil.isTodosComandosValidos;
import static java.lang.String.valueOf;

@Service
public class RoboService implements IRoboService {

    public static final String RIGHT_COMMAND = "R";
    public static final String LEFT_COMMAND = "L";
    public static final String MOVE_COMMAND = "M";
    public static final int MAX_COORDENADA_Y = 4;
    public static final int MAX_COORDENADA_X = 4;
    public static final int MIN_COORDENADA_X = 0;
    public static final int MIN_COORDENADA_Y = 0;
    public static final int COORDENADA_X_INICIAL = 0;
    public static final int COORDENADA_Y_INICIAL = 0;

    @Override
    public String posicaoFinalAposComandos(String comandos) {
        if (!isTodosComandosValidos(comandos)) {
            throw new CustomGenericException("", HttpStatus.BAD_REQUEST);
        }

        return executaComando(COORDENADA_X_INICIAL, COORDENADA_Y_INICIAL, NORTH, comandos.toUpperCase());
    }

    private String executaComando(int coordenadaX, int coordenadaY, OrientationEnum orientacao, String comandos) {
        System.out.println("(" + coordenadaX + ", " + coordenadaY+ ", " + orientacao.getSigla() + ") " + comandos);
        if (isCoordenadaNaoValida(coordenadaX, coordenadaY)) {
            throw new CustomGenericException("coordenadaX: " +coordenadaX + "coordenadaY: " + coordenadaY
                    + "orientacao: " + orientacao.getSigla(), HttpStatus.BAD_REQUEST);
        }

        if (isCriterioDeParada(comandos)) {
            return "(" + coordenadaX + ", " + coordenadaY + ", " + orientacao.getSigla() + ")";
        }

        char comandoAtual = comandos.charAt(0);
        if (RIGHT_COMMAND.equals(valueOf(comandoAtual))) {
            orientacao = orientacao.getRightOrientationBy(orientacao.getSigla());
        }

        if (LEFT_COMMAND.equals(valueOf(comandoAtual))) {
            orientacao = orientacao.getLeftOrientationBy(orientacao.getSigla());
        }

        if (MOVE_COMMAND.equals(valueOf(comandoAtual))) {
            if (NORTH.equals(orientacao)) {
                coordenadaY = coordenadaY + 1;
            } else if (SOUTH.equals(orientacao)) {
                coordenadaY = coordenadaY - 1;
            } else if (EAST.equals(orientacao)) {
                coordenadaX = coordenadaX + 1;
            } else if (WEST.equals(orientacao)) {
                coordenadaX = coordenadaX - 1;
            }
        }

        return executaComando(coordenadaX, coordenadaY, orientacao, comandos.substring(1));
    }

    private static boolean isCriterioDeParada(String comandos) {
        return comandos.length() == 0;
    }

    private static boolean isCoordenadaNaoValida(int coordenadaX, int coordenadaY) {
        return coordenadaY > MAX_COORDENADA_Y
                || coordenadaY < MIN_COORDENADA_Y
                || coordenadaX < MIN_COORDENADA_X
                || coordenadaX > MAX_COORDENADA_X;
    }

}
