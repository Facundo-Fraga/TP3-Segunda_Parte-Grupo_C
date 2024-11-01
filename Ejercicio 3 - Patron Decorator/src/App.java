import modelo.*;

/**
 * Clase App que contiene el método principal para ejecutar la aplicación.
 * En esta clase se establece el precio base de una pizza, se agregan 
 * ingredientes a la pizza utilizando decoradores y se calcula el 
 * precio total.
 */
public class App {
    
    /**
     * Método principal que ejecuta la aplicación.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     * @throws Exception Si ocurre un error durante la ejecución.
     */
    public static void main(String[] args) throws Exception {
        // Establezco el precio base de la pizza
        Pizza pizza = new PizzaBasica(5.0); 
        
        // Agrego ingredientes
        pizza = new DecoradorQuesoExtra(pizza, 2); 
        pizza = new DecoradorChampinones(pizza, 3); 
        pizza = new DecoradorJamon(pizza, 2);
        
        // Calculo precio total
        System.out.println("Precio total de la pizza: " + pizza.calcularPrecio());
    }
}
