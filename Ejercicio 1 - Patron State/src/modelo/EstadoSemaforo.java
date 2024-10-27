package modelo;

/**
 * Interfaz que define el comportamiento de los diferentes estados de un semáforo.
 */
public interface EstadoSemaforo {
    
    /**
     * Realiza la acción asociada al estado actual del semáforo.
     */
    public void accion();

    /**
     * Cambia el estado del semáforo al siguiente en la secuencia.
     */
    public void cambiarEstado();
}