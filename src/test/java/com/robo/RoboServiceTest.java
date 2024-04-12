package com.robo;

import com.robo.exception.CustomGenericException;
import com.robo.service.RoboService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RoboServiceTest {

    @InjectMocks
    RoboService roboService;

    @Test
    public void retornePosicaoAposComandosValidos()  {
        Assert.assertEquals("(0, 1, N)", roboService.posicaoFinalAposComandos("M"));
        Assert.assertEquals("(0, 2, N)", roboService.posicaoFinalAposComandos("MM"));
        Assert.assertEquals("(1, 1, E)", roboService.posicaoFinalAposComandos("MRM"));
        Assert.assertEquals("(1, 1, N)", roboService.posicaoFinalAposComandos("MRml"));
        Assert.assertEquals("(1, 0, E)", roboService.posicaoFinalAposComandos("LLLM"));
        Assert.assertEquals("(4, 4, E)", roboService.posicaoFinalAposComandos("mmmmrmmmm"));
        Assert.assertEquals("(2, 1, N)", roboService.posicaoFinalAposComandos("rmmlm"));
        Assert.assertEquals("(0, 0, N)", roboService.posicaoFinalAposComandos("mmmmrmmmmrmmmmrmmmmr"));
        Assert.assertEquals("(1, 0, W)", roboService.posicaoFinalAposComandos("RMMLLM"));
    }

    @Test
    public void retornePosicaoAposComandosInvalidos()  {
        Assert.assertThrows(CustomGenericException.class, () -> roboService.posicaoFinalAposComandos("Mmmmmm"));
        Assert.assertThrows(CustomGenericException.class, () -> roboService.posicaoFinalAposComandos("rRrM"));
        Assert.assertThrows(CustomGenericException.class, () -> roboService.posicaoFinalAposComandos("lm"));
        Assert.assertThrows(CustomGenericException.class, () -> roboService.posicaoFinalAposComandos("llm"));
        Assert.assertThrows(CustomGenericException.class, () -> roboService.posicaoFinalAposComandos("Mmmmm"));
        Assert.assertThrows(CustomGenericException.class, () -> roboService.posicaoFinalAposComandos("Mmmmrmmmmm"));
        Assert.assertThrows(CustomGenericException.class, () -> roboService.posicaoFinalAposComandos("Mmmmlm"));
        Assert.assertThrows(CustomGenericException.class, () -> roboService.posicaoFinalAposComandos("Mmmmmm"));
    }

}
