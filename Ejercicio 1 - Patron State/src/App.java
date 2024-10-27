import modelo.Rojo;
import modelo.Semaforo;

public class App {
    public static void main(String[] args) throws Exception {
        // Inicializa el semáforo en el estado Rojo
        Semaforo semaforo = new Semaforo();
        Rojo rojo = new Rojo(semaforo);
        semaforo.setEstadoSemaforo(rojo);
        // Ejecuta la acción y cambia de estado varias veces
        for (int i = 0; i < 5; i++) {
            semaforo.accion();       // Ejecuta la acción actual del semáforo
            semaforo.cambiarEstado(); // Cambia al siguiente estado
        }
    }
}
