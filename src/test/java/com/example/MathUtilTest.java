package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathUtilTest {
    @Test
    void testMdcP1BImpar() {
        int a = 6, b = 3;
        int esperado = 3;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP1BPar() {
        int a = 6, b = 2;
        int esperado = 2;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP3Negativo() {
        int a = -6, b = 0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }
    @Test
    void testMdcP3Positivo() {
        int a = 6, b = 0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP5() {
        int a = 2, b = 6;
        int esperado = MathUtil.mdc(b, a);
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP7() {
        int a = 2, b = 6;
        int esperado = MathUtil.mdc(-b, a);
        int obtido = MathUtil.mdc(-a, -b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP8() {
        int a = 6;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, a);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP12A() {
        int p = 11, a = 22;
        int esperado = 11;
        int obtido = MathUtil.mdc(p, a);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP12B() {
        int p = 11, a = 1;
        int esperado = 1;
        int obtido = MathUtil.mdc(p, a);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP12C() {
        int p = 11, a = 2;
        int esperado = 1;
        int obtido = MathUtil.mdc(p, a);

        assertEquals(esperado, obtido);
    }
    
}
