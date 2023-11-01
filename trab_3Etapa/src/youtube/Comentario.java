package youtube;

public class Comentario extends Publicacao {
    private String texto;

    public Comentario(String texto, Usuario a){
        this.texto = texto;
        autor = a;
        qtdGostei = 0;
        qtdNaoGostei = 0;

    }
}
