package unam.model;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Implementación de la estrategia de envío regular.
 * 
 * <p>
 * Esta clase calcula el costo de envío y el tiempo estimado de entrega
 * para envíos regionales y nacionales. Utiliza tablas de costo para definir
 * precios según el peso y el tipo de distancia.
 * </p>
 * 
 * <p>
 * Si el peso del paquete está fuera del rango (0.1 kg - 25.0 kg) o la distancia
 * no es válida, el método de cálculo de costo lanzará una excepción.
 * </p>
 * 
 * @author Grupo C
 * @version 1.0
 */
public class RegularShipping implements ShippingStrategy {

    /** Tabla de costos para envíos regionales en función del peso. */
    private static final NavigableMap<Double, Double> REGIONAL_COST_TABLE = createRegionalCostTable();

    /** Tabla de costos para envíos nacionales en función del peso. */
    private static final NavigableMap<Double, Double> NATIONAL_COST_TABLE = createNationalCostTable();

    /** Map con los tiempos de entrega estimados para cada tipo de distancia. */
    private static final Map<ShippingDistance, String> DELIVERY_TIMES = Map.of(
            ShippingDistance.REGIONAL, "3 DAYS",
            ShippingDistance.NATIONAL, "6 DAYS");

    /**
     * Constructor sin parámetros
     */
    public RegularShipping() {
    }

    /**
     * Crea la tabla de costos para envíos regionales.
     * 
     * @return una {@link NavigableMap} que mapea el peso al costo de envío para
     *         envíos regionales
     */
    private static NavigableMap<Double, Double> createRegionalCostTable() {
        NavigableMap<Double, Double> map = new TreeMap<>();
        map.put(1.0, 10900.0);
        map.put(5.0, 12800.0);
        map.put(10.0, 17200.0);
        map.put(15.0, 21300.0);
        map.put(20.0, 25000.0);
        map.put(25.0, 30100.0);
        return map;
    }

    /**
     * Crea la tabla de costos para envíos nacionales.
     * 
     * @return una {@link NavigableMap} que mapea el peso al costo de envío para
     *         envíos nacionales
     */
    private static NavigableMap<Double, Double> createNationalCostTable() {
        NavigableMap<Double, Double> map = new TreeMap<>();
        map.put(1.0, 14600.0);
        map.put(5.0, 17700.0);
        map.put(10.0, 25100.0);
        map.put(15.0, 31400.0);
        map.put(20.0, 36500.0);
        map.put(25.0, 44800.0);
        return map;
    }

    /**
     * Calcula el costo de envío según el peso y la distancia.
     * 
     * @param distance la distancia de envío, especificada por
     *                 {@link ShippingDistance}
     * @param weightKg el peso del paquete en kilogramos (debe estar entre 0.1 y
     *                 25.0 kg)
     * @return el costo de envío como un valor en doble precisión
     * @throws IllegalArgumentException si el peso está fuera de rango o si la
     *                                  distancia es inválida
     */
    @Override
    public double calcShippingCost(ShippingDistance distance, double weightKg) {
        if (weightKg <= 0 || weightKg > 25) {
            throw new IllegalArgumentException("Out-of-range weight: 0.1 kg - 25.0 kg");
        }

        NavigableMap<Double, Double> costTable = switch (distance) {
            case REGIONAL -> REGIONAL_COST_TABLE;
            case NATIONAL -> NATIONAL_COST_TABLE;
            default -> throw new IllegalArgumentException("Invalid distance");
        };

        return costTable.ceilingEntry(weightKg).getValue();
    }

    /**
     * Calcula el tiempo estimado de entrega basado en la distancia de envío.
     * 
     * @param distance la distancia de envío, especificada por
     *                 {@link ShippingDistance}
     * @return el tiempo estimado de entrega como una cadena de texto; si la
     *         distancia no es válida, devuelve "Invalid distance"
     */
    @Override
    public String calcDeliveryTime(ShippingDistance distance) {
        return DELIVERY_TIMES.getOrDefault(distance, "Invalid distance");
    }
}
