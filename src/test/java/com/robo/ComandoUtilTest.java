package com.robo;

import com.robo.util.ComandoUtil;
import org.junit.Assert;
import org.junit.Test;

public class ComandoUtilTest {

    @Test
    public void comandosValidos()  {
        Assert.assertTrue(ComandoUtil.isTodosComandosValidos("R"));
        Assert.assertTrue(ComandoUtil.isTodosComandosValidos("L"));
        Assert.assertTrue(ComandoUtil.isTodosComandosValidos("M"));
        Assert.assertTrue(ComandoUtil.isTodosComandosValidos("r"));
        Assert.assertTrue(ComandoUtil.isTodosComandosValidos("l"));
        Assert.assertTrue(ComandoUtil.isTodosComandosValidos("m"));
        Assert.assertTrue(ComandoUtil.isTodosComandosValidos("MML"));
        Assert.assertTrue(ComandoUtil.isTodosComandosValidos("MMRMMRMM"));
        Assert.assertTrue(ComandoUtil.isTodosComandosValidos("MMM"));
    }

    @Test
    public void comandosInvalidos()  {
        Assert.assertFalse(ComandoUtil.isTodosComandosValidos("A"));
        Assert.assertFalse(ComandoUtil.isTodosComandosValidos("RLA"));
        Assert.assertFalse(ComandoUtil.isTodosComandosValidos("RLMAR"));
        Assert.assertFalse(ComandoUtil.isTodosComandosValidos("X"));
        Assert.assertFalse(ComandoUtil.isTodosComandosValidos("rlv"));
        Assert.assertFalse(ComandoUtil.isTodosComandosValidos("R1"));

    }

}
