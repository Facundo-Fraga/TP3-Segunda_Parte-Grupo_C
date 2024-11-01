package unam.model;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Implementación de la estrategia de envío internacional.
 * 
 * <p>
 * Esta clase calcula el costo de envío y el tiempo estimado de entrega
 * para envíos internacionales, organizados según la distancia del destino.
 * Cada distancia internacional tiene una tabla de costos específica en función
 * del peso del paquete.
 * </p>
 * 
 * <p>
 * Si el peso del paquete está fuera del rango (0.1 kg - 20.0 kg) o la distancia
 * no es válida, el método de cálculo de costo lanzará una excepción.
 * </p>
 * 
 * <ul>
 * <li>Envíos a países fronterizos tienen tiempos de entrega de 10 días.</li>
 * <li>Envíos al resto de Sudamérica tienen tiempos de entrega de 12 días.</li>
 * <li>Envíos al resto de América, Europa y al resto del mundo tienen tiempos de
 * entrega de 25 días.</li>
 * </ul>
 * 
 * @author Grupo C
 * @version 1.0
 */
public class InternationalShipping implements ShippingStrategy {

    /** Tabla de costos para envíos a países fronterizos en función del peso. */
    private static final NavigableMap<Double, Double> BORDER_COST_TABLE = createBorderCostTable();

    /** Tabla de costos para envíos al resto de Sudamérica en función del peso. */
    private static final NavigableMap<Double, Double> RO_SOUTH_AMERICA_COST_TABLE = createRestOfSouthAmericaCostTable();

    /** Tabla de costos para envíos al resto de América en función del peso. */
    private static final NavigableMap<Double, Double> RO_AMERICA_COST_TABLE = createRestOfAmericaCostTable();

    /** Tabla de costos para envíos a Europa en función del peso. */
    private static final NavigableMap<Double, Double> EUROPE_COST_TABLE = createEuropeCostTable();

    /** Tabla de costos para envíos al resto del mundo en función del peso. */
    private static final NavigableMap<Double, Double> RO_WORLD_COST_TABLE = createRestOfWorldCostTable();

    /**
     * Map con los tiempos de entrega estimados para cada tipo de distancia en envío
     * internacional.
     */
    private static final Map<ShippingDistance, String> DELIVERY_TIMES = Map.of(
            ShippingDistance.BORDER_COUNTRY, "10 DAYS",
            ShippingDistance.REST_OF_SOUTH_AMERICA, "12 DAYS",
            ShippingDistance.REST_OF_AMERICA, "25 DAYS",
            ShippingDistance.EUROPE, "25 DAYS",
            ShippingDistance.REST_OF_WORLD, "25 DAYS");

    /**
     * Constructor sin parámetros
     */
    public InternationalShipping() {
    }

    /**
     * Crea la tabla de costos para envíos a países fronterizos.
     * 
     * @return una {@link NavigableMap} que mapea el peso al costo de envío para
     *         países fronterizos
     */
    private static NavigableMap<Double, Double> createBorderCostTable() {
        NavigableMap<Double, Double> map = new TreeMap<>();
        map.put(1.0, 52800.0);
        map.put(3.0, 97100.0);
        map.put(5.0, 139900.0);
        map.put(10.0, 227900.0);
        map.put(15.0, 327800.0);
        map.put(20.0, 404900.0);
        return map;
    }

    /**
     * Crea la tabla de costos para envíos al resto de Sudamérica.
     * 
     * @return una {@link NavigableMap} que mapea el peso al costo de envío para el
     *         resto de Sudamérica
     */
    private static NavigableMap<Double, Double> createRestOfSouthAmericaCostTable() {
        NavigableMap<Double, Double> map = new TreeMap<>();
        map.put(1.0, 80900.0);
        map.put(3.0, 139900.0);
        map.put(5.0, 170300.0);
        map.put(10.0, 308600.0);
        map.put(15.0, 427500.0);
        map.put(20.0, 470900.0);
        return map;
    }

    /**
     * Crea la tabla de costos para envíos al resto de América.
     * 
     * @return una {@link NavigableMap} que mapea el peso al costo de envío para el
     *         resto de América
     */
    private static NavigableMap<Double, Double> createRestOfAmericaCostTable() {
        NavigableMap<Double, Double> map = new TreeMap<>();
        map.put(1.0, 99100.0);
        map.put(3.0, 151100.0);
        map.put(5.0, 196700.0);
        map.put(10.0, 375200.0);
        map.put(15.0, 478700.0);
        map.put(20.0, 531400.0);
        return map;
    }

    /**
     * Crea la tabla de costos para envíos a Europa.
     * 
     * @return una {@link NavigableMap} que mapea el peso al costo de envío para
     *         Europa
     */
    private static NavigableMap<Double, Double> createEuropeCostTable() {
        NavigableMap<Double, Double> map = new TreeMap<>();
        map.put(1.0, 106200.0);
        map.put(3.0, 178600.0);
        map.put(5.0, 231600.0);
        map.put(10.0, 404900.0);
        map.put(15.0, 569800.0);
        map.put(20.0, 628800.0);
        return map;
    }

    /**
     * Crea la tabla de costos para envíos al resto del mundo.
     * 
     * @return una {@link NavigableMap} que mapea el peso al costo de envío para el
     *         resto del mundo
     */
    private static NavigableMap<Double, Double> createRestOfWorldCostTable() {
        NavigableMap<Double, Double> map = new TreeMap<>();
        map.put(1.0, 111700.0);
        map.put(3.0, 187800.0);
        map.put(5.0, 246400.0);
        map.put(10.0, 478700.0);
        map.put(15.0, 607600.0);
        map.put(20.0, 713900.0);
        return map;
    }

    /**
     * Calcula el costo de envío según el peso y la distancia para envíos
     * internacionales.
     * 
     * @param distance la distancia de envío, especificada por
     *                 {@link ShippingDistance}
     * @param weightKg el peso del paquete en kilogramos (debe estar entre 0.1 y
     *                 20.0 kg)
     * @return el costo de envío como un valor en doble precisión
     * @throws IllegalArgumentException si el peso está fuera de rango o si la
     *                                  distancia es inválida
     */
    @Override
    public double calcShippingCost(ShippingDistance distance, double weightKg) {
        if (weightKg <= 0 || weightKg > 20) {
            throw new IllegalArgumentException("Out-of-range weight: 0.1 kg - 20.0 kg");
        }

        NavigableMap<Double, Double> costTable = switch (distance) {
            case BORDER_COUNTRY -> BORDER_COST_TABLE;
            case REST_OF_SOUTH_AMERICA -> RO_SOUTH_AMERICA_COST_TABLE;
            case REST_OF_AMERICA -> RO_AMERICA_COST_TABLE;
            case EUROPE -> EUROPE_COST_TABLE;
            case REST_OF_WORLD -> RO_WORLD_COST_TABLE;
            default -> throw new IllegalArgumentException("Invalid distance");
        };

        return costTable.ceilingEntry(weightKg).getValue();
    }

    /**
     * Calcula el tiempo estimado de entrega basado en la distancia de envío
     * internacional.
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
