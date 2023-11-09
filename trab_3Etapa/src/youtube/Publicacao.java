package youtube;

public abstract class Publicacao {
    protected int qtdGostei;
    protected int qtdNaoGostei;
	protected boolean statusGostei = false;
	protected boolean statusNãoGostei = false;
	protected Comentario[] comentarios = new Comentario[50];
	protected int qtdComentarios;
    /*
     * Não possui mais o atributo Autor
    */

	public int getQtdComentarios() {
		return qtdComentarios;
	}
	public void setQtdComentarios(int qtdComentarios) {
		this.qtdComentarios = qtdComentarios;
	}
	public boolean getStatusGostei() {
		return statusGostei;
	}
	public void setStatusGostei(boolean status) {
		statusGostei = status;
	}
	public boolean getStatusNãoGostei() {
		return statusNãoGostei;
	}
	public void setStatusNãoGostei(boolean status) {
		statusNãoGostei = status;
	}
    public int getQtdGostei() {
		return qtdGostei;
	}
	public void setQtdGostei(int Gostei) {
		qtdGostei = Gostei;
	}
	public int getQtdNaoGostei() {
		return qtdNaoGostei;
	}
	public void setQtdNaoGostei(int NaoGostei) {
		qtdNaoGostei = NaoGostei;
	}
	public Comentario[] getComentarios() {
		return comentarios;
	}
	public void setComentarios(Comentario[] comentarios) {
		this.comentarios = comentarios;
	}
	public Comentario getComentario(int i){
		return comentarios[i];

	}
	public void setComentario(int i, Comentario c){
		comentarios[i]=c;
	}

}
