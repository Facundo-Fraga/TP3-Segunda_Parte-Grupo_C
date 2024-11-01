package unam.model;

/**
 * Estrategia de envío que define los métodos para calcular el costo y el tiempo
 * de entrega.
 * 
 * <p>
 * Este enfoque permite definir diferentes estrategias de envío, tales como
 * Envío Regular,
 * Envío Expreso o Envío Internacional, que pueden implementar esta interfaz y
 * definir sus
 * propios cálculos de costo y tiempo de entrega en función de la distancia y el
 * peso del paquete.
 * </p>
 * 
 * @author Grupo C
 * @version 1.0
 */
public interface ShippingStrategy {

    /**
     * Calcula el costo de envío basado en la distancia y el peso del paquete.
     * 
     * @param distance la distancia de envío, expresada en un objeto
     *                 {@link ShippingDistance}
     * @param weightKg el peso del paquete en kilogramos
     * @return el costo del envío como un valor en doble precisión
     */
    double calcShippingCost(ShippingDistance distance, double weightKg);

    /**
     * Calcula el tiempo estimado de entrega basado en la distancia de envío.
     * 
     * @param distance la distancia de envío, expresada en un objeto
     *                 {@link ShippingDistance}
     * @return el tiempo estimado de entrega como una cadena de texto
     */
    String calcDeliveryTime(ShippingDistance distance);
}
