package youtube;

public abstract class Publicacao {
    protected int qtdGostei;
    protected int qtdNaoGostei;
    protected Usuario autor;
    /*
     * rever O atributo 'Autor' da classe abstrata Publicação.
     *  Atualmente está do tipo Usuario, o que só faz sentido na classe Comentario, 
     * para as classes Video e Enquete o atributo autor deveria ser do tipo Canal.
    */
}
