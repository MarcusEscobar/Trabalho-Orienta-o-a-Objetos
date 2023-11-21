package youtube;


public class Comentario extends Publicacao {
    private String texto;
    private Usuario autor;
    private boolean noComentario;
    private boolean noVideo;
    private Comentario comentarioPai;
    private Video videoPai;
    private Enquete enquetePai;

 
    public Comentario(String texto, Usuario a, boolean isResposta,boolean inVideo, Comentario cp, Video vp, Enquete ep){
        this.texto = texto;
        autor = a;
        qtdGostei = 0;
        qtdNaoGostei = 0;
        this.noComentario = isResposta;
        this.noVideo = inVideo;
        comentarioPai = cp;
        videoPai = vp;
        enquetePai = ep;
        
    }

    public boolean noComentario() {
        return noComentario;
    }

    public boolean noVideo() {
        return noVideo;
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


    public String toString(){
        return autor.getNomeUsuario()+": "+texto;
    }

    
}
