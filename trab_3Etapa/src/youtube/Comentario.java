package youtube;

public class Comentario extends Publicacao {
    private String texto;

    public Comentario(String texto, Usuario a){
        this.texto = texto;
        autor = a;
        qtdGostei = 0;
        qtdNaoGostei = 0;
    }

    public String getTexto(){
        return texto;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }
}
