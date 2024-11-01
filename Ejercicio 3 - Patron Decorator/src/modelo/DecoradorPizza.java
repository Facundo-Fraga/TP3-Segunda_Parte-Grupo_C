package modelo;

/**
 * Clase abstracta DecoradorPizza que implementa la interfaz Pizza.
 * Sirve como clase base para los decoradores de pizza, permitiendo
 * agregar ingredientes adicionales a la pizza original.
 */
abstract class DecoradorPizza implements Pizza {

    /**
     * Instancia de pizza a la que se le agregan ingredientes adicionales.
     */
    protected Pizza pizza;

    /**
     * Constructor que inicializa el decorador con una pizza base.
     *
     * @param pizza La pizza a la que se le aplicará el decorador.
     */
    public DecoradorPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    /**
     * Calcula el precio de la pizza, delegando la llamada a la pizza base.
     * Este método puede ser sobrescrito por las clases hijas para agregar
     * costos adicionales.
     *
     * @return El precio de la pizza decorada.
     */
    @Override
    public double calcularPrecio() {
        return pizza.calcularPrecio();
    }
}
