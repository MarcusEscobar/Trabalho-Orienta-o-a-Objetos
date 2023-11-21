package youtube;


public abstract class Publicacao {
	protected int qtdGostei;
    protected int qtdNaoGostei;
	protected boolean statusGostei = false;
	protected boolean statusNãoGostei = false;
	protected Comentario[] comentarios = new Comentario[50];
	protected int qtdComentarios;
    protected Canal autor;


	public int getQtdComentarios() {
		return qtdComentarios;
	}
	public void setQtdComentarios(int qtdComentarios) {
		this.qtdComentarios = qtdComentarios;
	}
	public boolean getStatusGostei() {
		return statusGostei;
	}
	public boolean getStatusNãoGostei() {
		return statusNãoGostei;
	}
	public void setQtdGostei(int Gostei) {
		qtdGostei = Gostei;
	}

	public void setQtdNaoGostei(int NaoGostei) {
		qtdNaoGostei = NaoGostei;
	}

	public void setComentarios(Comentario[] comentarios) {
		this.comentarios = comentarios;
	}
	public Comentario getComentario(int i){
		return comentarios[i];

	}
	public void adicionarGostei(){
		if(!statusGostei && !statusNãoGostei){
			statusGostei = true;
			statusNãoGostei = false;
			qtdGostei++;
		}else if(statusNãoGostei && !statusGostei){
			statusGostei = true;
			statusNãoGostei = false;
			qtdGostei++;
			qtdNaoGostei--;
		}
	}
	public void adicionarNaoGostei(){
		if(!statusGostei && !statusNãoGostei){
			statusGostei = false;
			statusNãoGostei = true;
			qtdNaoGostei++;
		}else if(!statusNãoGostei && statusGostei){
			statusGostei = false;
			statusNãoGostei = true;
			qtdGostei--;
			qtdNaoGostei++;
		}
	}

	public Canal getAutor() {
		return autor;
	}
	public String stringComentarios(){
		String stringComentarios = new String("");
		if(qtdComentarios == 0){stringComentarios+="Não possui comentários";}
		for(int i = 1; i <= qtdComentarios;i++){
			String s = String.valueOf(i);
			stringComentarios += new String("  "+s+" - "+comentarios[i-1].toString()+"\n");
		}
		return stringComentarios;
		}

	public String gosteiNaoGostei(){
		String text = "Quantidade Gostei: "+qtdGostei+"\n";
		text += "Quantidade Não Gostei: "+qtdNaoGostei+"\n";
		return text;
	}

	public boolean adicionarComentario(Comentario comentario){
		if(qtdComentarios < 50){
			comentarios[qtdComentarios] = comentario;
			qtdComentarios++;
			return true;
		}else{
			return false;
		}
	}

}
