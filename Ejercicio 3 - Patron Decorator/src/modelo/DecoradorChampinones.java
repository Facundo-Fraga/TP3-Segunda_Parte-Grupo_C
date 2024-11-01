package modelo;

/**
 * Clase DecoradorChampinones que extiende de DecoradorPizza, 
 * añadiendo funcionalidad extra para manejar champiñones adicionales en la pizza.
 */
public class DecoradorChampinones extends DecoradorPizza {

    /** 
     * Cantidad de champiñones adicionales en la pizza. 
     */
    private int cantChampinones;

    /**
     * Constructor para crear una instancia de DecoradorChampinones.
     *
     * @param pizza La instancia de pizza base a la que se le agregan los champiñones.
     * @param cantChampinonesExtra La cantidad de champiñones adicionales que se desea agregar.
     */
    public DecoradorChampinones(Pizza pizza, int cantChampinonesExtra) {
        super(pizza);
        this.cantChampinones = cantChampinonesExtra;
    }

    /**
     * Calcula el precio total de la pizza con champiñones adicionales.
     * Se asume que cada champiñón cuesta 2 unidades monetarias.
     *
     * @return El precio total de la pizza con el costo de los champiñones adicionales.
     */
    @Override
    public double calcularPrecio() {
        // Suponemos que una unidad de champiñon cuesta 2
        return super.calcularPrecio() + (cantChampinones * 2); 
    }
}
