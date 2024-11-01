package modelo;

/**
 * Clase DecoradorQuesoExtra que extiende de DecoradorPizza,
 * añadiendo funcionalidad para manejar queso extra en la pizza.
 */
public class DecoradorQuesoExtra extends DecoradorPizza {

    /**
     * Cantidad de queso extra en la pizza.
     */
    private int cantQuesoExtra;

    /**
     * Constructor para crear una instancia de DecoradorQuesoExtra.
     *
     * @param pizza La instancia de pizza base a la que se le agrega queso extra.
     * @param cantQuesoExtra La cantidad de queso extra que se desea agregar.
     */
    public DecoradorQuesoExtra(Pizza pizza, int cantQuesoExtra) {
        super(pizza);
        this.cantQuesoExtra = cantQuesoExtra;
    }

    /**
     * Calcula el precio total de la pizza con queso extra.
     * Se asume que cada unidad de queso extra cuesta 1.5 unidades monetarias.
     *
     * @return El precio total de la pizza con el costo del queso extra.
     */
    @Override
    public double calcularPrecio() {
        // Suponemos que una unidad de queso extra cuesta 1.5
        return super.calcularPrecio() + (cantQuesoExtra * 1.5); 
    }
}
