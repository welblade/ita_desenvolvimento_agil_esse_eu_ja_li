package cap.wesantos.jali.core.exception;

public class LivroJaMarcadoComoLidoException extends RuntimeException {
    public LivroJaMarcadoComoLidoException() {
        super("Livro já marcado como lido.");
    }
}
