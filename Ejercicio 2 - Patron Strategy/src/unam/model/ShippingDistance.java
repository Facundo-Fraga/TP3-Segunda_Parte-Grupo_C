package unam.model;

/**
 * Enumeración que representa las distintas distancias de envío posibles.
 * 
 * <p>
 * Define los diferentes rangos de envío que una estrategia de envío puede
 * manejar,
 * permitiendo clasificar las distancias en categorías como regional, nacional o
 * internacional.
 * </p>
 * 
 * <ul>
 * <li>{@link #REGIONAL} - Envíos dentro de la misma región o área local.</li>
 * <li>{@link #NATIONAL} - Envíos dentro del mismo país.</li>
 * <li>{@link #BORDER_COUNTRY} - Envíos a un país fronterizo.</li>
 * <li>{@link #REST_OF_SOUTH_AMERICA} - Envíos a otros países de
 * Sudamérica.</li>
 * <li>{@link #REST_OF_AMERICA} - Envíos a otros países de América.</li>
 * <li>{@link #EUROPE} - Envíos a países de Europa.</li>
 * <li>{@link #REST_OF_WORLD} - Envíos al resto del mundo fuera de América y
 * Europa.</li>
 * </ul>
 * 
 * @author Grupo C
 * @version 1.0
 */
public enum ShippingDistance {
    /** Envíos dentro de la misma región o área local. */
    REGIONAL,

    /** Envíos dentro del mismo país. */
    NATIONAL,

    /** Envíos a un país fronterizo. */
    BORDER_COUNTRY,

    /** Envíos a otros países de Sudamérica. */
    REST_OF_SOUTH_AMERICA,

    /** Envíos a otros países de América. */
    REST_OF_AMERICA,

    /** Envíos a países de Europa. */
    EUROPE,

    /** Envíos al resto del mundo fuera de América y Europa. */
    REST_OF_WORLD;
}
