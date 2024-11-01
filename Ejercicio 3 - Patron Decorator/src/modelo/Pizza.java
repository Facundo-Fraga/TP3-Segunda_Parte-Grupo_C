package modelo;

/**
 * Interfaz Pizza que define el contrato para calcular el precio de una pizza.
 * Cualquier clase que implemente esta interfaz debe proporcionar una implementación
 * para el método calcularPrecio.
 */
public interface Pizza {

    /**
     * Calcula y devuelve el precio de la pizza.
     *
     * @return El precio de la pizza en unidades monetarias.
     */
    double calcularPrecio();
}
