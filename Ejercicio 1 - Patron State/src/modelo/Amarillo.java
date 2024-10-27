package modelo;

/**
 * Estado amarillo del semáforo, donde los autos deben avanzar con precaución.
 */
public class Amarillo implements EstadoSemaforo {
    private Semaforo semaforo;

    /**
     * Constructor de la clase Amarillo.
     *
     * @param semaforo El semáforo que contiene este estado.
     */
    public Amarillo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    /**
     * Muestra un mensaje indicando que los autos deben avanzar con precaución.
     */
    public void accion() {
        System.out.println("Los autos deben avanzar con precaución");
    }

    /**
     * Cambia el estado del semáforo al estado verde.
     */
    public void cambiarEstado() {
        Verde verde = new Verde(semaforo);
        semaforo.setEstadoSemaforo(verde);
    }
}