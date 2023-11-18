package youtube;


public class Comentario extends Publicacao {
    private String texto;
    private Usuario autor;
    private boolean inComentario;
    private boolean inVideo;
    private Comentario comentarioPai;
    private Video videoPai;
    private Enquete enquetePai;

 
    public Comentario(String texto, Usuario a, boolean isResposta,boolean inVideo, Comentario cp, Video vp, Enquete ep){
        this.texto = texto;
        autor = a;
        qtdGostei = 0;
        qtdNaoGostei = 0;
        this.inComentario = isResposta;
        this.inVideo = inVideo;
        comentarioPai = cp;
        videoPai = vp;
        enquetePai = ep;
        
    }
    

    public boolean inComentario() {
        return inComentario;
    }

       public boolean inVideo() {
        return inVideo;
    }

    public Comentario getComentarioPai() {
        return comentarioPai;
    }

    public Video getVideoPai() {
        return videoPai;
    }

    public Enquete getEnquetePai() {
        return enquetePai;
    }

    public String getTexto(){
        return texto;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public String comentarioToString(){
        return autor.getNomeUsuario()+": "+texto;
    }

    
}
