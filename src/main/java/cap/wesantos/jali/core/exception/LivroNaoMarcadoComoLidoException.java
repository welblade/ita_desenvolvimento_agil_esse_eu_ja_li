package cap.wesantos.jali.core.exception;

public class LivroNaoMarcadoComoLidoException extends RuntimeException{
    public LivroNaoMarcadoComoLidoException() {
        super("Este livro já não está mais entre os livros lido.");
    }
}
