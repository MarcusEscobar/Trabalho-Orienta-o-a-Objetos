package view;

import java.util.*;


import youtube.*;
import dados.*;

public abstract class Menu {


    public static void clear(){
        System.out.println("\033c");
    }

    public static void loginUsuario(Dados dados, Scanner entrada){
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
        homePage(dados, entrada);
    }

    public static void homePage(Dados dados, Scanner entrada){
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
                listaCanais(dados, entrada);
                break;
            case 2:
                clear();
                listaInscricoes(dados, entrada);
                break;
            case 3:
                clear();
                buscarCanalPeloNome(dados, entrada);
                break;
            case 4:
                clear();
                criarCanal(dados, entrada);
                break;
            
            default:
                clear();
                System.out.println("Opção inválida\n");
                homePage(dados, entrada);//Recursividade, simulando loop de repetição
                break;
        }
    }

    public static void criarCanal(Dados dados, Scanner entrada){
        entrada.nextLine();
        System.out.println("Criando um canal\n");
        System.out.println("Digite um nome");
        String nome = entrada.nextLine();
        Canal newCanal = new Canal(nome, dados.getUsuario());
        if(dados.inserirCanal(newCanal)){
            System.out.println("Canal criado com sucesso");
        }else{
            System.out.println("Falha na criação do canal");
        }

    }

    public static void listaCanais(Dados dados, Scanner entrada){
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
            homePage(dados, entrada);
        }else if(valor >= 1 && valor <= dados.getQtdCanais()){
            clear();
            menuCanal(dados, entrada, dados.getCanal(valor-1));

        }else{
            System.out.println("Opção inválida");
            clear();
            listaCanais(dados, entrada);
        }
    }
    
    public static void listaInscricoes(Dados dados, Scanner entrada){
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
            homePage(dados, entrada);
        }else if(valor >= 1 && valor <= dados.getUsuario().getQtdInscricoes() && dados.getUsuario().getQtdInscricoes() != 0){
            clear();
            menuCanal(dados, entrada, dados.getUsuario().getInscricao(valor-1));

        }else{
            System.out.println("Opção inválida");
            clear();
            listaInscricoes(dados, entrada);
        }


    }

    public static void buscarCanalPeloNome(Dados dados, Scanner entrada){
        System.out.println("buscando\n");
        System.out.println("digite o nome de um canal");
        entrada.nextLine();//Limpando Buffer de entrada
        String nome = entrada.nextLine();
        Canal canal = dados.buscarCanal(nome);
        if(canal == null){
            clear();
            System.out.println("Canal não encontrado\n");
            homePage(dados, entrada);
        }else{
            clear();
            menuCanal(dados, entrada, canal);
        }

    }

    public static void menuCanal(Dados dados, Scanner entrada, Canal canal){
        System.out.println("Este é o canal: "+canal.getNomeCanal());
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
        opçoes += "  6 - Informações do canal\n";
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                clear();
                homePage(dados, entrada);
                break;
            case 1:
                if(dados.getUsuario().inscricoesToString().contains(canal.getNomeCanal())){
                //está inscrito
                    dados.getUsuario().CancelarInscrição(canal);
                    canal.setQtdInscritos(canal.getQtdInscritos()-1);
                    clear();
                     menuCanal(dados, entrada, canal);
                }else{
                    dados.getUsuario().inscreverSe(canal);
                    canal.setQtdInscritos(canal.getQtdInscritos()+1);
                    clear();
                    menuCanal(dados, entrada, canal);

                }
                break;
            case 2:
                clear();
               //menu5_Videos(canal, dados, entrada);
                menuDeVideos(canal, dados, entrada);
                break;
            case 3:
                clear();
                menuDeEnquetes(canal,dados,entrada);
                break;
            case 4:
                //editar canal
                clear();
                EditarCanal(canal, dados, entrada);
                break;
            case 6:
                clear();
                InfoDoCanal(canal, dados, entrada);
                break;
            default:
                clear();
                System.out.println("opção inválida");
                menuCanal(dados, entrada, canal);
                break;
        }
            
    }

    public static void EditarCanal(Canal canal, Dados dados, Scanner entrada){
        entrada.nextLine();
        System.out.println("Insira o novo nome do canal:\n");
        String novoNome = entrada.nextLine();
        System.out.println(" ");
        System.out.println("Nome alterado com sucesso.");
        canal.setNomeCanal(novoNome);
        clear();
        menuCanal(dados, entrada, canal);
    }

    public static void InfoDoCanal(Canal canal, Dados dados, Scanner entrada){
        System.out.println("Informações do canal "+canal.getNomeCanal()+":\n");
        System.out.println("Proprietario: "+canal.getProprietario().getNomeUsuario()+"\n");
        System.out.println("Quantidade de inscritos: "+canal.getQtdInscritos()+"\n");
        System.out.println("Quantidade de videos: "+canal.getQtdVideos()+"\n");
        System.out.println("Quantidade de enquetes: "+canal.getQtdEnquetes()+"\n");
        System.out.println("Total de visualizações no canal: "+canal.getTotalVisualizacoes()+"\n");

        String opçoes = new String("0 - Voltar ao canal\n\n");
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                menuCanal(dados, entrada, canal);
                break;
        
            default:
                menuCanal(dados, entrada, canal);
                break;
        }


    }

    public static void menuExcluirCanal(Canal canal, Dados dados, Scanner entrada){
        String opçoes = new String("Tem certeza que deseja excluir o canal?\n\n");
        opçoes += "0 - Sim\n";
        opçoes += "1 - Não\n";
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                clear();
                ExcluirCanal(canal, dados);
                listaCanais(dados, entrada);
                break;
            case 1:
                clear();
                menuCanal(dados, entrada, canal);
                break;
            default:
                clear();
                System.out.println("Opção inválida\n");
                menuCanal(dados, entrada, canal);
                break;
        }


    }

    public static void ExcluirCanal(Canal canal, Dados dados){


    }


    public static void menuDeVideos(Canal canal, Dados dados, Scanner entrada){
        String opçoes = new String("Escolha um opção\n\n");
        opçoes += "0 - voltar ao canal\n";//menu4
        opçoes += "1 - Criar video\n";
        opçoes += "2 - Listar todos os vídeos\n";//Menu5video
        opçoes += "3 - Buscar video pelo título\n";
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                clear();
                menuCanal(dados, entrada,canal);
                break;
            case 1:
                clear();
                criarVideo(dados, entrada, canal);
                break;
            case 2:
                clear();
                listarVideos(canal, dados, entrada);
                break;
            case 3:
                clear();
                buscarPeloTitulo(dados, canal, entrada);
                break;
            default:
                clear();
                System.out.println("opção inválida");
                menuDeVideos(canal, dados, entrada);
                break;
        }

    }


    
    public static void buscarPeloTitulo(Dados dados, Canal canal, Scanner entrada){ 
        System.out.println("buscando\n");
        System.out.println("digite o titulo de um vídeo");
        entrada.nextLine();//Limpando Buffer de entrada
        String titulo = entrada.nextLine();
        Video video = canal.buscarVideo(titulo);
         if(video==null){
             clear();
             System.out.println("Video não encontrado");
             menuDeVideos(canal, dados, entrada);
         }else{
             clear();
             video.addViws();
             acessarVideo(video, dados, entrada);
         }

         
    }

    public static void listarVideos(Canal canal, Dados dados, Scanner entrada){//Printa Videos Canal
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
            menuCanal(dados, entrada,canal);
        }else if(valor >= 1 && valor <= canal.getQtdVideos()){
            clear();
            canal.getVideo(valor-1).addViws();
            acessarVideo(canal.getVideo(valor-1), dados, entrada);

        }else{
            clear();
            System.out.println("Opção inválida");
            listarVideos(canal, dados, entrada);
        }
    }
   
    public static void criarVideo(Dados dados,Scanner entrada, Canal canal){
        entrada.nextLine();
        System.out.println("Criando um vídeo\n");
        System.out.println("Digite um titulo");
        String titulo = entrada.nextLine();
        System.out.println(" ");
        System.out.println("Digite uma descrição");
        String descricao = entrada.nextLine();
        Video newVideo = new Video(titulo, descricao, canal, 0);
        if(canal.criarNovoVideo(newVideo)){
            clear();
            System.out.println("Video criado com sucesso\n");
            menuDeVideos(canal, dados, entrada);
        }else{
            clear();
            System.out.println("Ocorreu um erro na criação\n");
            menuDeVideos(canal, dados, entrada);
        }

    }    
   
    public static void menuDeEnquetes(Canal canal, Dados dados, Scanner entrada){
        String opçoes = new String("Escolha um opção\n\n");
        opçoes += "0 - voltar ao canal\n";//menuCanal
        opçoes += "1 - Criar Enquete\n";
        opçoes += "2 - listar todas as Enquetes\n";//MenulistarEnquetes
        System.out.println(opçoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                clear();
                menuCanal(dados, entrada,canal);//voltar
                break;
            case 1:
                clear();
                criarEnquete(canal,dados,entrada);//criar
                break;
            case 2:
                clear();
                listarEnquetes(canal,dados,entrada);//listar
                break;
                
            default:
                clear();
                System.out.println("opção inválida");
                menuDeEnquetes(canal, dados, entrada);
                break;
        }   	
    }          
                
     public static void criarEnquete(Canal canal, Dados dados, Scanner entrada) {
    	 entrada.nextLine(); // limpando o buffer de entrada
    	 System.out.println("Qual é a sua pergunta?\n");
         String pergunta = entrada.nextLine();
         System.out.println("Digite a 1° resposta\n");
         String opçaoA = entrada.nextLine();
         System.out.println("Digite a 2° resposta\n");
         String opçaoB = entrada.nextLine();
         System.out.println("Digite a 3° resposta\n");
         String opçaoC = entrada.nextLine();
         System.out.println("Digite a 4° resposta\n");
         String opçaoD = entrada.nextLine();
         Enquete createdEnquete = new Enquete(pergunta,opçaoA ,opçaoB,opçaoC,opçaoD, canal);
        if( canal.adicionarEnquete(createdEnquete)) {
        	System.out.println("Enquete Criado com Sucesso");
        	menuDeEnquetes(canal, dados, entrada);
        }
         else {
			System.out.println("Não foi Possivel criar a Enquete");
			menuDeEnquetes(canal, dados, entrada);
		}
     }
         
    public static void listarEnquetes(Canal canal, Dados dados, Scanner entrada){
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
            menuCanal(dados, entrada,canal);
        }else if(valor >= 1 && valor <= canal.getQtdEnquetes()){
            clear();
            //Menu8Acessar/ler enquente

        }else{
            clear();
            System.out.println("Opção inválida");
            listarEnquetes(canal, dados, entrada);
        }

    }

    public static void acessarVideo(Video video, Dados dados, Scanner entrada){//Menu referente ao video selecionado
        System.out.println(video.videoToString());
        String opcoes = new String("Escolha uma opção\n\n");
        opcoes += "  0 - voltar canal\n";
        opcoes += "  1 - voltar página principal\n";
        if(!video.getStatusGostei() && !video.getStatusNãoGostei()){
            opcoes += "  2 - Gostei\n"; //GOSTEI = TRUE // NAO GOSTEI = FALSE
            opcoes += "  3 - Não gostei\n";//GOSTEI = FALSE // NAO GOSTEI = TRUE
        }else if(video.getStatusGostei() == true && video.getStatusNãoGostei() == false){
            opcoes += "  3 - Não gostei\n";
        }else{
            opcoes += "  2 - Gostei\n";}
        opcoes += "  4 - Ler comentários\n";
        if(video.getIsPausado()){
             opcoes += "  5 - Reproduzir\n";
        }else{
            opcoes += "  5 - pausar video\n";
        }
        switch (video.getVelocidade()){
            case 2:
                opcoes += "  6 - Reduzir velocidade\n";
                break;
        
            default:
                opcoes += "  6 - aumentar velocidade\n";
                break;
        }
         opcoes += "  7 - Editar video\n";
          opcoes += "  8 - Excluir video \n";
        System.out.println(opcoes);
        int valor = entrada.nextInt();
        switch (valor) {
            case 0:
                clear();
                menuCanal(dados, entrada, video.getAutor());
                break;

            case 1:
                clear();
                homePage(dados, entrada);
                break;
            case 2:
                video.adicionarGostei();
                clear();
                acessarVideo(video, dados, entrada);
                break;
            case 3:
                video.adicionarNaoGostei();
                clear();
                acessarVideo(video, dados, entrada);
                break;
            case 4:
                clear();
                lerComentarios(dados, entrada, video);
                break;
            case 5:
                if(video.getIsPausado()){
                    video.setIsPausado(false);
                    clear();
                    acessarVideo(video, dados, entrada);
                }else{
                    video.setIsPausado(true);
                    clear();
                    acessarVideo(video, dados, entrada);}
                break;
            case 6:
                if(video.getVelocidade() == 1){
                    video.setVelocidade(2);
                    clear();
                    acessarVideo(video, dados, entrada);
                }else{
                    video.setVelocidade(1);
                    clear();
                    acessarVideo(video, dados, entrada);}
                break;
            case 7:
                clear();
                editarVideo(dados, entrada, video);
                break;
            case 8:
                clear();
                excluirVideo(dados, entrada, video);
                break;
            default:
                clear();
                System.out.println("Opção inválida");
                acessarVideo(video, dados, entrada);
                break;
        }
    }
    
    public static void editarVideo(Dados dados, Scanner entrada, Video video){
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
        acessarVideo(video, dados, entrada);
    }
    
    public static void excluirVideo(Dados dados, Scanner entrada, Video video){
        entrada.nextLine();
        Canal autor = video.getAutor();
        System.out.println("Deseja mesmo excluir esse video");
        System.out.println("digite 's' para confirmar");
        String delete = entrada.nextLine();
        if(delete.compareToIgnoreCase("s")==0){
            video.getAutor().deleteVideo(video);
            clear();
            System.out.println("Video excluido com sucesso");
            menuCanal(dados, entrada, autor);
        }else{
            clear();
            System.out.println("Video não foi excluido");
            acessarVideo(video, dados, entrada);
        }
    }

    public static void lerComentarios(Dados dados, Scanner entrada, Video video){
        String opcao = new String("Escolha uma opção\n\n");
        opcao += "  0 - Retornar ao video\n\n";
        opcao +="Comentários de "+video.getTitulo()+" do canal "+video.getAutor().getNomeCanal()+"\n";
        for(int i = 1; i <= video.getQtdComentarios();i++){
            String s = String.valueOf(i);
            opcao += new String("  "+s+" - "+video.getComentario(i-1).comentarioToString()+"\n");
        }
        System.out.println(opcao);
        int valor = entrada.nextInt();
        if(valor == 0){
            clear();
            acessarVideo(video, dados, entrada);
        }else if(valor >=1 && valor <=video.getQtdComentarios()){
            clear();
            //menu7
        }else{
            clear();
            System.out.println("Opção inválida");
            lerComentarios(dados, entrada, video);
        }

    }
}