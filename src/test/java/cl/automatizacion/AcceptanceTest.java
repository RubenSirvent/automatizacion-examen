package cl.automatizacion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AcceptanceTest {

    @Test
    public void usuarioDebeObtenerElTotalCorrecto() {

        ServicioCalculadora servicio = new ServicioCalculadora();

        int resultado = servicio.calcularTotal(10000, 2);

        assertEquals(20000, resultado);
    }
}