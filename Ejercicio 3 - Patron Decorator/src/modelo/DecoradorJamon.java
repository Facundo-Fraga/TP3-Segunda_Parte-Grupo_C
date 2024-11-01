package modelo;

/**
 * Clase DecoradorJamon que extiende de DecoradorPizza, 
 * agregando funcionalidad para manejar jamón adicional en la pizza.
 */
public class DecoradorJamon extends DecoradorPizza {

    /**
     * Cantidad de jamón adicional en la pizza.
     */
    private int cantJamon;

    /**
     * Constructor para crear una instancia de DecoradorJamon.
     *
     * @param pizza La instancia de pizza base a la que se le agrega jamón.
     * @param cantJamon La cantidad de jamón adicional que se desea agregar.
     */
    public DecoradorJamon(Pizza pizza, int cantJamon) {
        super(pizza);
        this.cantJamon = cantJamon;
    }

    /**
     * Calcula el precio total de la pizza con jamón adicional.
     * Se asume que cada unidad de jamón cuesta 2.5 unidades monetarias.
     *
     * @return El precio total de la pizza con el costo del jamón adicional.
     */
    @Override
    public double calcularPrecio() {
        // Suponemos que una unidad de jamon cuesta 2.5
        return super.calcularPrecio() + (cantJamon * 2.5);
    }

}
