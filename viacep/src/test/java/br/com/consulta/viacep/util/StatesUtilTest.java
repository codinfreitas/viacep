package br.com.consulta.viacep.util;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StatesUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"ES", "GO", "AL", "PR", "AC"})
    public void compareTo_generalTest(String states){

        String result = StatesUtil.compareTo(states);

        Assert.assertNotNull(result);
    }
}