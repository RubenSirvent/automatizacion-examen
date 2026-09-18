package cl.automatizacion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraTest {

    @Test
    public void debeSumarDosNumeros() {

        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.sumar(10, 3);

        assertEquals(13, resultado);
    }

    @Test
    public void debeMultiplicarDosNumeros() {

        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.multiplicar(7, 5);

        assertEquals(35, resultado);
    }

    @Test
    public void debeDividirDosNumeros() {

        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.dividir(16, 4);

        assertEquals(4, resultado);
    }

    @Test(expected = IllegalArgumentException.class)
    public void noDebeDividirPorCero() {

        Calculadora calculadora = new Calculadora();

        calculadora.dividir(10, 0);
    }
}