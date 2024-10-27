package modelo;

/**
 * Estado rojo del semáforo, donde los autos deben detenerse.
 */
public class Rojo implements EstadoSemaforo {
    private Semaforo semaforo;

    /**
     * Constructor de la clase Rojo.
     *
     * @param semaforo El semáforo que contiene este estado.
     */
    public Rojo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    /**
     * Muestra un mensaje indicando que los autos deben detenerse.
     */
    public void accion() {
        System.out.println("Los autos deben detenerse");
    }

    /**
     * Cambia el estado del semáforo al estado amarillo.
     */
    public void cambiarEstado() {
        Amarillo amarillo = new Amarillo(semaforo);
        semaforo.setEstadoSemaforo(amarillo);
    }
}