package cl.automatizacion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ServicioCalculadoraIT {

    @Test
    public void debeCalcularTotalCorrectamente() {

        ServicioCalculadora servicio = new ServicioCalculadora();

        int resultado = servicio.calcularTotal(1000, 3);

        assertEquals(3000, resultado);
    }

    @Test
    public void debeDividirTotalEntrePersonas() {

        ServicioCalculadora servicio = new ServicioCalculadora();

        int resultado = servicio.calcularDivision(3000, 3);

        assertEquals(1000, resultado);
    }
}