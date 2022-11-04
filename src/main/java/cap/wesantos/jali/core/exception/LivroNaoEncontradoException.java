package cap.wesantos.jali.core.exception;

public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(String message) {
        super(message);
    }
    public LivroNaoEncontradoException() {
        super("Livro não encontrado.");
    }
}