package modelo;

/**
 * Clase PizzaBasica que implementa la interfaz Pizza.
 * Representa una pizza básica con un precio base fijo.
 */
public class PizzaBasica implements Pizza {

    /**
     * Precio base de la pizza.
     */
    private double precioBase;

    /**
     * Constructor para crear una instancia de PizzaBasica.
     *
     * @param precioBase El precio base de la pizza.
     */
    public PizzaBasica(double precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * Calcula y devuelve el precio de la pizza básica.
     *
     * @return El precio base de la pizza en unidades monetarias.
     */
    @Override
    public double calcularPrecio() {
        return precioBase;
    }
}
