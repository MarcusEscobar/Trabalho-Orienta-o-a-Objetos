package view;


import java.util.*;


import youtube.*;
import dados.*;

public abstract class Menu {
    private static Dados dados;
    private static Scanner entrada;


    public static void clear(){
        System.out.println("\033c");
    }

    public static void iniciar(Dados d, Scanner e){
        dados = d;
        entrada = e;
        clear();
        System.out.println("Bem-Vindo ao Youtube. Faça seu cadastro\n");
        System.out.println("Insira um nome");
        String nome = entrada.nextLine();
        System.out.println(" ");
        System.out.println("Insira uma senha");
        String senha = entrada.nextLine();
        System.out.println(" ");
        Usuario user = new Usuario(senha, nome);
        dados.setUsuario(user);
        clear();
        homePage();
    }
    
    public static void homePage(){
        System.out.println("Olá "+dados.getUsuario().getNomeUsuario()+", o que deseja?\n");
        String opçoes = new String("Escolha uma opção:\n\n");
        opçoes += "  0 - Sair\n";
        opçoes += "  1 - Listar canais\n";
        opçoes += "  2 - Canais Inscritos\n";
        opçoes += "  3 - Buscar canal pelo nome\n";
        opçoes += "  4 - Criar canal\n";
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        System.out.println(" ");//Pular uma linha
        switch (valor) {
            case 0:
                clear();
                System.out.println("Obrigado por usar o Youtube!!");
                break;
            case 1:
                clear();
                listarCanais();
                break;
            case 2:
                clear();
                listarInscricoes();
                break;
            case 3:
                clear();
                buscarCanalPeloNome();
                break;
            case 4:
                clear();
                criarCanal();
                break;
            
            default:
                clear();
                System.out.println("Opção inválida\n");
                homePage();//Recursividade, simulando loop de repetição
                break;
        }
    }

//CANAL
    public static void criarCanal(){
        entrada.nextLine();
        System.out.println("Criando um canal\n");
        System.out.println("Digite um nome");
        String nome = entrada.nextLine();
        Canal newCanal = new Canal(nome, dados.getUsuario());
        if(dados.inserirCanal(newCanal)){
            clear();
            System.out.println("Canal criado com sucesso\n");
            menuDeCanal(newCanal);
        }else{
            clear();
            System.out.println("Falha na criação do canal\n");
            homePage();
        }

    }

    public static void listarCanais(){
        String opçoes = new String("Escolha uma opção:\n\n");
        opçoes += "  0 - voltar\n\n";
            opçoes +="Canais disponíveis:\n\n";
            for(int i = 1; i<= dados.getQtdCanais(); i++){
                String s = String.valueOf(i);//Transformo j em string
                opçoes += new String("  "+s+" - "+dados.getCanal(i-1).getNomeCanal()+"\n");
            }
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        if(valor == 0){
            clear();
            homePage();
        }else if(valor >= 1 && valor <= dados.getQtdCanais()){
            clear();
            menuDeCanal(dados.getCanal(valor-1));

        }else{
            System.out.println("Opção inválida");
            clear();
            listarCanais();
        }
    }
    
    public static void editarCanal(Canal canal){
        entrada.nextLine();
        System.out.println("Insira o novo nome do canal:");
        String novoNome = entrada.nextLine();
        canal.setNomeCanal(novoNome);
        clear();
        System.out.println("Nome alterado com sucesso. \n");
        menuDeCanal(canal);
    }

    public static void excluirCanal(Canal canal){
        String opçoes = new String("Tem certeza que deseja excluir o canal?\n\n");
        opçoes += "  0 - Sim\n";
        opçoes += "  1 - Não\n";
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                clear();
                dados.deletarCanal(canal);
                dados.getUsuario().CancelarInscrição(canal);
                System.out.println("Canal excluido com sucesso\n");
                listarCanais();
                break;
            default:
                clear();
                if(valor == 1){System.out.println("Canal não foi excluido\n");}
                else{System.out.println("Opção inválida\n");}
                menuDeCanal(canal);
                break;
        }
    }
    
    public static void listarInscricoes(){
        String opçoes = new String("Escolha uma opção:\n\n");
        opçoes += "  0 - voltar\n\n";
        if(dados.getUsuario().getQtdInscricoes() == 0){
            opçoes+= "Você não está inscrito em nenhum canal!\n";
        }else{
            opçoes +="Canais disponíveis:\n\n";
            for(int i = 1; i<= dados.getUsuario().getQtdInscricoes(); i++){
                String s = String.valueOf(i);//Transformo j em string
                opçoes += new String("  "+s+" - "+dados.getUsuario().getInscricao(i-1).getNomeCanal()+"\n");
            }
        }
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        if(valor == 0){
            clear();
            homePage();
        }else if(valor >= 1 && valor <= dados.getUsuario().getQtdInscricoes() && dados.getUsuario().getQtdInscricoes() != 0){
            clear();
            menuDeCanal(dados.getUsuario().getInscricao(valor-1));

        }else{
            System.out.println("Opção inválida");
            clear();
            listarInscricoes();
        }


    }

    public static void buscarCanalPeloNome(){
        System.out.println("buscando\n");
        System.out.println("digite o nome de um canal");
        entrada.nextLine();//Limpando Buffer de entrada
        String nome = entrada.nextLine();
        Canal canal = dados.buscarCanal(nome);
        if(canal == null){
            clear();
            System.out.println("Canal não encontrado\n");
            homePage();
        }else{
            clear();
            menuDeCanal(canal);
        }

    }

    public static void menuDeCanal(Canal canal){
        System.out.println(canal.toString());
        String opçoes = new String("Escolha uma opção:\n\n");
        opçoes += "  0 - voltar para pagina principal\n";
        if(dados.getUsuario().inscricoesToString().contains(canal.getNomeCanal())){
            //está inscrito
            opçoes += "  1 - Cancelar inscrição\n";
        }else{
            opçoes += "  1 - Inscrever-se\n";
        }
        opçoes += "  2 - Menu de vídeos\n";
        opçoes += "  3 - Menu enquetes\n";
        opçoes += "  4 - Editar canal\n";
        opçoes += "  5 - Excluir canal\n";
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                clear();
                homePage();
                break;
            case 1:
                if(dados.getUsuario().inscricoesToString().contains(canal.getNomeCanal())){
                //está inscrito
                    dados.getUsuario().CancelarInscrição(canal);
                    canal.setQtdInscritos(canal.getQtdInscritos()-1);
                    clear();
                     menuDeCanal(canal);
                }else{
                    dados.getUsuario().inscreverSe(canal);
                    canal.setQtdInscritos(canal.getQtdInscritos()+1);
                    clear();
                    menuDeCanal(canal);

                }
                break;
            case 2:
                clear();
                menuDeVideos(canal);
                break;
            case 3:
                clear();
                menuDeEnquetes(canal);
                break;
            case 4:
                //editar canal
                clear();
                editarCanal(canal);
                break;
            case 5:
                //editar canal
                clear();
                excluirCanal(canal);
                break;
            default:
                clear();
                System.out.println("opção inválida");
                menuDeCanal(canal);
                break;
        }
            
    }

//VIDEO
    public static void criarVideo(Canal canal){
        entrada.nextLine();
        System.out.println("Criando um vídeo\n");
        System.out.println("Digite um titulo");
        String titulo = entrada.nextLine();
        System.out.println(" ");
        System.out.println("Digite uma descrição");
        String descricao = entrada.nextLine();
        Video newVideo = new Video(titulo, descricao, canal, 0);
        if(canal.adicionarVideo(newVideo)){
            clear();
            System.out.println("Video criado com sucesso\n");
            menuDeVideos(canal);
        }else{
            clear();
            System.out.println("Ocorreu um erro na criação\n");
            menuDeVideos(canal);
        }

    }    

     public static void listarVideos(Canal canal){
        String opçoes = new String("Escolha um opção\n\n");
        opçoes +="  0 - voltar ao canal\n\n";
        opçoes+="Videos de "+canal.getNomeCanal()+"\n\n";       
        for(int i = 1; i<= canal.getQtdVideos(); i++){
            String s = String.valueOf(i);//Transformo j em string
            opçoes += new String("  "+s+" - "+canal.getVideo(i-1).getTitulo()+"\n");
        }System.out.println(opçoes);
        int valor = entrada.nextInt();
        if(valor == 0){
            clear();
            menuDeCanal(canal);
        }else if(valor >= 1 && valor <= canal.getQtdVideos()){
            clear();
            canal.getVideo(valor-1).addViws();
            acessarVideo(canal.getVideo(valor-1));

        }else{
            clear();
            System.out.println("Opção inválida");
            listarVideos(canal);
        }
    }

    public static void acessarVideo(Video video){
        System.out.println(video.toString());
        String opcoes = new String("Escolha uma opção\n\n");
        opcoes += "  0 - Voltar canal\n";
        opcoes += "  1 - Voltar página principal\n";
        if(!video.getStatusGostei() && !video.getStatusNãoGostei()){
            opcoes += "  2 - Gostei\n"; //GOSTEI = TRUE // NAO GOSTEI = FALSE
            opcoes += "  3 - Não gostei\n";//GOSTEI = FALSE // NAO GOSTEI = TRUE
        }else if(video.getStatusGostei() == true && video.getStatusNãoGostei() == false){
            opcoes += "  3 - Não gostei\n";
        }else{
            opcoes += "  2 - Gostei\n";}
        opcoes += "  4 - Comentar\n";
        opcoes += "  5 - Listar comentários\n";
        if(video.getIsPausado()){
             opcoes += "  6 - Reproduzir\n";
        }else{
            opcoes += "  6 - Pausar video\n";
        }
        switch (video.getVelocidade()){
            case 2:
                opcoes += "  7 - Reduzir velocidade\n";
                break;
        
            default:
                opcoes += "  7 - Aumentar velocidade\n";
                break;
        }
        opcoes += "  8 - Editar video\n";
        opcoes += "  9 - Excluir video \n";
        System.out.println(opcoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                clear();
                menuDeCanal(video.getAutor());
                break;

            case 1:
                clear();
                homePage();
                break;
            case 2:
                video.adicionarGostei();
                clear();
                acessarVideo(video);
                break;
            case 3:
                video.adicionarNaoGostei();
                clear();
                acessarVideo(video);
                break;
            case 4:
                clear();
                criarComentario(video);
                break;
            case 5:
                clear();
                listarCometarios(video);
                break;
            case 6:
                if(video.getIsPausado()){
                    video.setIsPausado(false);
                    clear();
                    acessarVideo(video);
                }else{
                    video.setIsPausado(true);
                    clear();
                    acessarVideo(video);}
                break;
            case 7:
                if(video.getVelocidade() == 1){
                    video.setVelocidade(2);
                    clear();
                    acessarVideo(video);
                }else{
                    video.setVelocidade(1);
                    clear();
                    acessarVideo(video);}
                break;
            case 8:
                clear();
                editarVideo(video);
                break;
            case 9:
                clear();
                excluirVideo(video);
                break;
            default:
                clear();
                System.out.println("Opção inválida");
                acessarVideo(video);
                break;
        }
    }

    public static void editarVideo(Video video){
        entrada.nextLine();//limpa entrada
        System.out.println("Digite um novo titulo");
        String newTitulo = entrada.nextLine();
        System.out.println(" ");
        System.out.println("Digite uma nova descrição");
        String newDescricao = entrada.nextLine();
        video.setTitulo(newTitulo);
        video.setDescricaoVideo(newDescricao);
        clear();
        System.out.println("Video editado com sucesso\n");
        acessarVideo(video);
    }

    public static void excluirVideo(Video video){
        Canal autor = video.getAutor();
        System.out.println("Deseja mesmo excluir esse video");
        String opcoes =new String("Escolha uma opção\n\n");
        opcoes+="0 - sim\n";
        opcoes+="1 - não\n";
        System.out.println(opcoes);

        int delete = entrada.nextInt();
        switch (delete) {
            case 0:
                video.getAutor().deleteVideo(video);
                clear();
                System.out.println("Video excluido com sucesso");
                menuDeCanal(autor);          
                break;
            default:
                clear();
                if(delete == 1){System.out.println("Video não foi excluido");}
                else{System.out.println("Opção inválida");}
                acessarVideo(video);
                break;
        }
    }

    public static void buscarPeloTitulo(Canal canal){ 
        System.out.println("buscando\n");
        System.out.println("digite o titulo de um vídeo");
        entrada.nextLine();//Limpando Buffer de entrada
        String titulo = entrada.nextLine();
        Video video = canal.buscarVideo(titulo);
         if(video==null){
             clear();
             System.out.println("Video não encontrado");
             menuDeVideos(canal);
         }else{
             clear();
             video.addViws();
             acessarVideo(video);
         }

         
    }

    public static void menuDeVideos(Canal canal){
        String opçoes = new String("Escolha um opção\n\n");
        opçoes += "  0 - voltar ao canal\n";//menu4
        opçoes += "  1 - Criar video\n";
        opçoes += "  2 - Listar todos os vídeos\n";//Menu5video
        opçoes += "  3 - Buscar video pelo título\n";
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                clear();
                menuDeCanal(canal);
                break;
            case 1:
                clear();
                criarVideo(canal);
                break;
            case 2:
                clear();
                listarVideos(canal);
                break;
            case 3:
                clear();
                buscarPeloTitulo(canal);
                break;
            default:
                clear();
                System.out.println("opção inválida");
                menuDeVideos(canal);
                break;
        }

    }
   
//ENQUETE
    public static void criarEnquete(Canal canal) {
    	 entrada.nextLine(); // limpando o buffer de entrada
    	 System.out.println("Qual é a sua pergunta?\n");
         String pergunta = entrada.nextLine();
         System.out.println(" ");
         System.out.println("Serão quantas respostas possiveis?\n");
         int numRespostas = entrada.nextInt();
         System.out.println(" ");
         entrada.nextLine();
         String [] resposta = new String[numRespostas];
         int[] qtdVotosEmCada = new int[numRespostas];
         for (int i = 0; i < numRespostas; i++) {
        	 System.out.println("Digite uma resposta: \n");
        	 resposta[i] = entrada.nextLine();
             System.out.println(" ");
        	 qtdVotosEmCada[i] = 0; 	 
		}
         Enquete createdEnquete = new Enquete(pergunta, numRespostas, qtdVotosEmCada, resposta, canal);
        
        if( canal.adicionarEnquete(createdEnquete)) {
        	System.out.println("Enquete Criado com Sucesso");
        	menuDeEnquetes(canal);
        }
         else {
			System.out.println("Não foi Possivel criar a Enquete");
			menuDeEnquetes(canal);
		}
     }

    public static void listarEnquetes(Canal canal){
        String opçoes = new String("Escolha um opção\n\n");
        opçoes +="  0 - voltar ao canal\n\n";
        opçoes+="Enquetes de "+canal.getNomeCanal()+"\n\n";       
        for(int i = 1; i<= canal.getQtdEnquetes(); i++){
            String s = String.valueOf(i);//Transformo j em string
            opçoes += new String("  "+s+" - "+canal.getEnquete(i-1).getPergunta()+"\n");
        }System.out.println(opçoes);
        int valor = entrada.nextInt();
        if(valor == 0){
            clear();
            menuDeCanal(canal);
        }else if(valor >= 1 && valor <= canal.getQtdEnquetes()){
            clear();
            acessarEnquete(canal.getEnquete(valor-1));
        }else{
            clear();
            System.out.println("Opção inválida");
            listarEnquetes(canal);
        }

    } 

    public static void menuDeEnquetes(Canal canal){
        String opçoes = new String("Escolha um opção\n\n");
        opçoes += "  0 - voltar ao canal\n";//menuDeCanal
        opçoes += "  1 - Criar Enquete\n";
        opçoes += "  2 - listar todas as Enquetes\n";//MenulistarEnquetes
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                clear();
                menuDeCanal(canal);//voltar
                break;
            case 1:
                clear();
                criarEnquete(canal);//criar
                break;
            case 2:
                clear();
                listarEnquetes(canal);//listar
                break;
                
            default:
                clear();
                System.out.println("opção inválida");
                menuDeEnquetes(canal);
                break;
        }   	
    }          
          
    public static void acessarEnquete(Enquete enquete){
        //Enquete ToString
        System.out.println(enquete.toString());
        String opcoes = new String("Escolha uma opção \n\n");
        opcoes += "  0 - voltar canal\n";
        opcoes += "  1 - voltar página principal\n";
        if(!enquete.getStatusGostei() && !enquete.getStatusNãoGostei()){
            opcoes += "  2 - Gostei\n"; //GOSTEI = TRUE // NAO GOSTEI = FALSE
            opcoes += "  3 - Não gostei\n";//GOSTEI = FALSE // NAO GOSTEI = TRUE
        }else if(enquete.getStatusGostei() == true && enquete.getStatusNãoGostei() == false){
            opcoes += "  3 - Não gostei\n";
        }else{
            opcoes += "  2 - Gostei\n";}
        opcoes += "  4 - Comentar\n";
        opcoes += "  5 - Listar comentários\n";
        opcoes += "  6 - votar\n";
        opcoes += "  7 - Editar enquete\n";
        opcoes += "  8 - Excluir enquete\n";
        System.out.println(opcoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                clear();
                menuDeCanal(enquete.getAutor());
                break;
            case 1:
                clear();
                homePage();
                break;
            case 2:
                enquete.adicionarGostei();
                clear();
                acessarEnquete(enquete);
                break;
            case 3:
                enquete.adicionarNaoGostei();
                clear();
                acessarEnquete(enquete);
                break;
            case 4:
                clear();
                criarComentario(enquete);
                break;
            case 5:
                clear();
                listarCometarios(enquete);
                break;
            case 6:
                clear();
                menuVotação(enquete);
                break;
            case 7:
                clear();
                menuEditarEnquete(enquete);
                break;
            case 8:
                clear();
                excluirEnquete(enquete);
                break;
            
            default:
                clear();
                System.out.println("Opção inválida\n");
                acessarEnquete(enquete);
                break;
        }
    }

    public static void menuVotação(Enquete enquete){
        System.out.println(enquete.toString()+"\n");
        System.out.println("Escolha a opção que deseja votar\n");
        int valor = entrada.nextInt();
        if(valor <= enquete.getQtdOpcoes()){
            enquete.votar(valor-1);
            clear();
            System.out.println("Voto computado\n");
            acessarEnquete(enquete);
        }else{
            clear();
            System.out.println("Opção inválida");
            menuVotação(enquete);
        }

    }
    
    public static void menuEditarEnquete(Enquete enquete){
        entrada.nextLine();
        System.out.println("Digite uma nova pergunta");
        String pergunta = entrada.nextLine();
        System.out.println(" ");
        System.out.println("Serão quantas respostas possiveis?\n");
        int numRespostas = entrada.nextInt();
        System.out.println(" ");
        entrada.nextLine();
         String [] resposta = new String[numRespostas];
         int[] qtdVotosEmCada = new int[numRespostas];
         for (int i = 0; i < numRespostas; i++) {
        	 System.out.println("Digite uma resposta: \n");
        	 resposta[i] = entrada.nextLine();
             System.out.println(" ");
        	 qtdVotosEmCada[i] = 0; 	 
		}
        enquete.editarEnquete(pergunta, numRespostas, resposta, qtdVotosEmCada);
        clear();
        System.out.println("Enquete editada com sucesso\n");
        acessarEnquete(enquete);
    }
         
    public static void excluirEnquete(Enquete enquete){
        Canal autor = enquete.getAutor();
        System.out.println("Deseja mesmo excluir essa enquete");
        String opcoes =new String("Escolha uma opção\n\n");
        opcoes+="0 - sim\n";
        opcoes+="1 - não\n";
        System.out.println(opcoes);

        int delete = entrada.nextInt();
        switch (delete) {
            case 0:
                enquete.getAutor().deletarEnquete(enquete);
                clear();
                System.out.println("Enquete excluida com sucesso");
                menuDeCanal(autor);          
                break;
            default:
                clear();
                if(delete == 1){System.out.println("Enquete não foi excluida");}
                else{System.out.println("Opção inválida");}
                acessarEnquete(enquete);
                break;
        }
    }
    
//COMENTÁRIO(
    public static void criarComentario(Video video){
        entrada.nextLine();
        System.out.println("Digite um comentário");
        String texto = entrada.nextLine();
        Comentario newComentario = new Comentario(texto, dados.getUsuario(), false, true, null, video,null);
        if(video.adicionarComentario(newComentario)){
            clear();
            System.out.println("Comentário criado com sucesso\n");
            acessarComentario(newComentario);
        }
    }
    public static void criarComentario(Enquete enquete){
        entrada.nextLine();
        System.out.println("Digite um comentário");
        String texto = entrada.nextLine();
        Comentario newComentario = new Comentario(texto, dados.getUsuario(), false,false, null, null, enquete);
        if(enquete.adicionarComentario(newComentario)){
            clear();
            System.out.println("Comentário criado com sucesso\n");
            acessarComentario(newComentario);
        }
    }
    public static void criarComentario(Comentario comentario){
        entrada.nextLine();
        System.out.println("Digite um comentário");
        String texto = entrada.nextLine();
        Comentario newComentario = new Comentario(texto, dados.getUsuario(), true,false, comentario, null, null);
        if(comentario.adicionarComentario(newComentario)){
            clear();
            System.out.println("Comentário criado com sucesso\n");
            acessarComentario(newComentario);
        }
    }
    
    public static void listarCometarios(Video video){
        String opcoes = new String("0 - voltar\n\n");
        opcoes+=video.stringComentarios();
        System.out.println(opcoes);
        int valor = entrada.nextInt();
        if(valor == 0){
            clear();
            acessarVideo(video);
        }else if(valor >= 1 && valor <= video.getQtdComentarios()){
            clear();
            acessarComentario(video.getComentario(valor-1));
        }else{
            clear();
            System.out.println("Opção inválida");
            listarCometarios(video);
        }
    }
    public static void listarCometarios(Enquete enquete){
        String opcoes = new String("0 - voltar \n\n");
        opcoes+=enquete.stringComentarios();
        System.out.println(opcoes);
        int valor = entrada.nextInt();
        if(valor == 0){
            clear();
            //Menu8
        }else if(valor >= 1 && valor <= enquete.getQtdComentarios()){
            clear();
            acessarComentario(enquete.getComentario(valor-1));
        }else{
            clear();
            System.out.println("Opção inválida");
            listarCometarios(enquete);
        }
    }
    public static void listarCometarios(Comentario comentario){
        String opcoes = new String("0 - voltar\n\n");
        opcoes+=comentario.stringComentarios();
        System.out.println(opcoes);
        int valor = entrada.nextInt();
        if(valor == 0){
            clear();
            acessarComentario(comentario);
        }else if(valor >= 1 && valor <= comentario.getQtdComentarios()){
            clear();
            acessarComentario(comentario.getComentario(valor-1));
        }else{
            clear();
            System.out.println("Opção inválida");
            listarCometarios(comentario);
        }
    }
    
    public static void acessarComentario(Comentario comentario){
        System.out.println(comentario.toString());
        System.out.println(comentario.gosteiNaoGostei());
        String opcoes = new String("Escolha uma opção\n");
        opcoes+="  0 - Voltar \n";
        if(!comentario.getStatusGostei() && !comentario.getStatusNãoGostei()){
            opcoes += "  1 - Gostei\n"; //GOSTEI = TRUE // NAO GOSTEI = FALSE
            opcoes += "  2 - Não gostei\n";//GOSTEI = FALSE // NAO GOSTEI = TRUE
        }else if(comentario.getStatusGostei() == true && comentario.getStatusNãoGostei() == false){
            opcoes += "  2 - Não gostei\n";
        }else{
            opcoes += "  1 - Gostei\n";}
        opcoes+="  3 - Comentar\n";
        opcoes+="  4 - Listar Comentarios\n";
        System.out.println(opcoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                if(comentario.noComentario()){
                    clear();
                    acessarComentario(comentario.getComentarioPai());
                }else if(comentario.noVideo()){
                    clear();
                    acessarVideo(comentario.getVideoPai());
                }else{
                    acessarEnquete(comentario.getEnquetePai());
                }
                break;
            case 1:
                comentario.adicionarGostei();
                clear();
                acessarComentario(comentario);
                break;
            case 2:
                comentario.adicionarNaoGostei();
                clear();
                acessarComentario(comentario);
                break;
            case 3:
                clear();
                criarComentario(comentario);
                break;
            case 4:
                clear();
                listarCometarios(comentario);
                break;
            default:
                clear();
                System.out.println("opção inválida\n");
                acessarComentario(comentario);
                break;
        }
        

    }
}