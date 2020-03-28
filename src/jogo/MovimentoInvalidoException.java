package jogo;
public class MovimentoInvalidoException extends Exception {
    private Integer x;
    private Integer y;

    public MovimentoInvalidoException(Integer x, Integer y) {
        super();
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString(){
        return "Campos negativos são inválidos. Movimento não executado!";
    }
}
