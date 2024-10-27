package modelo;

/**
 * Estado verde del semáforo, donde los autos deben avanzar.
 */
public class Verde implements EstadoSemaforo {
    private Semaforo semaforo;

    /**
     * Constructor de la clase Verde.
     *
     * @param semaforo El semáforo que contiene este estado.
     */
    public Verde(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    /**
     * Muestra un mensaje indicando que los autos deben avanzar.
     */
    public void accion() {
        System.out.println("Los autos deben avanzar");
    }

    /**
     * Cambia el estado del semáforo al estado rojo.
     */
    public void cambiarEstado() {
        Rojo rojo = new Rojo(semaforo);
        semaforo.setEstadoSemaforo(rojo);
    }
}
