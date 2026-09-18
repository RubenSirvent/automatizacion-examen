package cl.automatizacion;

public class ServicioCalculadora {

    private final Calculadora calculadora;

    public ServicioCalculadora() {
        this.calculadora = new Calculadora();
    }

    public int calcularTotal(int precio, int cantidad) {

        return calculadora.multiplicar(precio, cantidad);
    }

    public int calcularDivision(int total, int personas) {

        return calculadora.dividir(total, personas);
    }
}