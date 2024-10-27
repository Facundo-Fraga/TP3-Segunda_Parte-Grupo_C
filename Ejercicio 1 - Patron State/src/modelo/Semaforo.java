package modelo;

/**
 * Clase que representa un semáforo que cambia entre diferentes estados.
 */
public class Semaforo {
    private EstadoSemaforo estadoSemaforo;

    /**
     * Constructor de la clase Semaforo.
     */
    public Semaforo() { 
    }

    /**
     * Cambia el estado del semáforo al siguiente en la secuencia.
     */
    public void cambiarEstado() {
        estadoSemaforo.cambiarEstado();
    }

    /**
     * Establece un nuevo estado para el semáforo.
     *
     * @param estadoSemaforo El nuevo estado del semáforo.
     */
    public void setEstadoSemaforo(EstadoSemaforo estadoSemaforo) {
        this.estadoSemaforo = estadoSemaforo;
    }

    /**
     * Ejecuta la acción correspondiente al estado actual del semáforo.
     */
    public void accion() {
        estadoSemaforo.accion();
    }
}