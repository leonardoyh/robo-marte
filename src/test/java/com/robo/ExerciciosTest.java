package com.robo;

import com.robo.exception.CustomGenericException;
import com.robo.service.RoboService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExerciciosTest {

    @InjectMocks
    RoboService roboService;

    @Test
    public void movimentoComRotacaoParaDireita()  {
        Assert.assertEquals("(2, 0, S)", roboService.posicaoFinalAposComandos("MMRMMRMM"));
    }

    @Test
    public void movimentoParaEsquerda()  {
        Assert.assertEquals("(0, 2, W)", roboService.posicaoFinalAposComandos("MML"));
    }

    @Test
    public void repeticaoDaRequisicaoComMovimentoParaEsquerda()  {
        Assert.assertEquals("(0, 2, W)", roboService.posicaoFinalAposComandos("MML"));
    }

    @Test
    public void comandoInvalido()  {
        Assert.assertThrows(CustomGenericException.class, () -> roboService.posicaoFinalAposComandos("AAA"));
    }

    @Test
    public void posicaoInvalida()  {
        Assert.assertThrows(CustomGenericException.class, () -> roboService.posicaoFinalAposComandos("MMMMMMMMMMMMMMMMMMMMMMMM"));
    }
}
