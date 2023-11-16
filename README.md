# Trabalho-Orientacao-a-Objetos
consoles de Opção=>2,3,4,5,6,7,8 _Consoles de navegação entre opções_

consoles de Criação =>1,9,10,16,17 _Criação de novos objetos, como: Usuario, Canal, Videos, Enquetes e Comentários_

consoles de edição => 11,12,13,14,15 _Edição e Exclusão dos Objetos, para acessar esses consoles é necessario uma senha_

console 1:_É um console de criação, não possui opções de escolha apenas entrada de dados para criação de obj_ [FEITO]
    Bem-vindo ao Youtube!
    realize um cadastro:
    insira um nome: 
    -> {User.nome} _Entrada de dados_
    insira senha:
    -> {User.senha} _Entrada de dados_
    _Quando terminar chama console 2_

console 2: Olá {User.nome}, o que deseja? _"Home page"_ 
        2.0 - Sair _Fecha o app_ [FEITO]
        2.1 - Listar Canais _Printa uma lista de todos o canais no banco de dados_ // _Entra no console 3_ [FEITO]
        buscar canal pelo nome
        2.2 - Listar inscriçoes _Chama console 3, variante inscriçoes_ [FEITO]
        2.3 - Listar Historico [FEITO]
        2.4 - Editar usuario _console de edição 11_//_Pede senha Usuário_ 
        2.5 - Criar um canal _console de criação 10_
        2.6   gerenciar canal(Onipotente)


    
 console 3: Canais Disponiveis [FEITO]
        3.0 Voltar _Retorna ao console 2_[FEITO]
        3.1 Acessar Canal _Entra em um Canal_ // _console 4_[FEITO]
                

 console 4:Este é o canal {Canal.nome} _Dentro de um Canal_
        4.0 Voltar home page [FEITO]
        4.1 se inscrever/desinscrever _o usuário pode se inscrever em seu proprio canal?_[FEITO]
        4.2 listar Videos _Chama o console 5.1 passando o Array de videos_[FEITO]
        4.3 Listar Enquetes _Chama o console 5.2_[FEITO]
        _Talvez uma opção de acessar um video direto pelo nome, nesse caso pularia o console 5_
        4.4 Editar Canal _Pede uma senha para habilitar edição_//_Chama console 12_
        _Para descobrir se o canal é do usuário perguntamos a senha do canal, olhe console 10_

console 5.1: videos de {Canal.nome}[FEITO]
        5.0 voltar ao canal _Retorna console 4_[FEITO]
        5.1 Acessar Video _Entra console 6 com Obj = Video acessado_

console 5.2: Enquetes de {Canal.nome}[FEITO]
        5.0 voltar ao canal _Retorna console 4_[FEITO]
        5.1 Acessar Enquete _Entra console 8 com Obj = Enquete acessado_

console 6:_console para Video_
        6.0 voltar ao canal _Retorna console 4_[FEITO]
        6.1 voltar Home page _Pode ser uma boa ideia poder voltar diretamente pra Home_[FEITO]
        6.2 Like/deslike[FEITO]
        6.3 Fazer um comentario _Adiciona ao Array de comentarios_//_console de criação 9_
        6.4 'ler' comentarios _PRINTA o toString dos comentários_ => Novo console[FEITO]
                6.5 Acessar comentario _Chama  o console 7_
        6.6 pausar video/despausar[FEITO]
        6.7 aumentar velocidade[FEITO]
        6.8 avancar/retroceder[FEITO]
        6.9 editar video _Pede senha do canal para habilitar edição_//_Chama console 13_

console 7:_console para comentários_
        7.0 voltar _Retorna console do Obj em que este foi comentado_
        7.1 voltar Home page
        7.2 Like/deslike
        7.3 Responder _Adiciona ao Array de comentarios_ // _console de criação 9_
        7.4 Ler Respostas _PRINTA o toString dos comentários_
        7.5 Acessar resposta _Chama novamente o console 7, porem mudando o obj_
        7.6 editar comentário _Pede senha, se for igual a autor.senha habiliata edição_//_console 15_

console 8: _console de Enquete_
        8.0 voltar _Retorna console 4_
        8.1 voltar Home page
        8.2 Like/deslike
        8.3 votar _Escolhe uma opção_
        8.4 Fazer um comentario _Adiciona ao Array de comentarios_//_console de criação 9_
        8.5 Ler comentarios _PRINTA o toString dos comentários_ 
        8.6 Acessar comentario _Chama o console 7_
        8.7 editar enquete _Pede senha canal_// _console 14_


console 9:_Criação de comentario_
    Digite um comentário
    -> {Comentario.texto} _Entrada de dados_
    _Quando terminar chama console 7_

console 10:_Console de criação de canal_
    Digite um nome para seu Canal:
    -> {Canal.nome}
    _Poderiamos criar um atibuto senha para canal_ // _Ou usar Canal.proprietario.senha_
    _Com esse atributo o User tem acesso a edições no seu canal mas nao nos outros_
    Digite uma senha:
    -> {Canal.senha}
    _Quando terminar chama console 4_

console 11: _Console edição usuario_
        11.0 voltar Home _Retorna menu 2 "Home page"_
        11.1 mudar nome _Entrada de dados_
        11.2 mudar senha _Entrada de dados_

console 12: _Console de edição canal_// _Possui opções que habilitam entrada de dados para edição_
        12.0 voltar _Retorna console 4_
        12.1 Excluir canal _Remove o canal do banco de dados_
        12.2 Mudar nome _Entrada de dados_
        12.3 Mudar senha _Entrada de dados_
        12.4 postar video _Menu de criação_//_Console 16_
        12.5 Excluir video _Exclui apenas 1 video do Array de videos_
        12.6 Excluir todos os videos _Exclui o Array completo de videos_
        12.7 Criar enquete _menu de criação_// _Console 17_
        12.8 Exluir enquete _O msm de 11.4 porem para enquetes_
        12.9 Excluir todas as enquetes

console 13: _Edição de video_
        13.0 voltar _Retorna console 6_
        13.1 Excluir Video
        13.2 Mudar titulo _Entrada de dados_
        13.3 Mudar descrição _Entrada de dados_

console 14: _Edição enquete_
        14.0 voltar _Retorna console 6_
        14.1 Excluir Enquete
        14.2 Mudar Pergunta _Entrada de dados_
        14.3 Mudar opções _Entrada de dados_
        14.4 Zerar votos

console 15: _Edição comentário_
        15.0 voltar _Retorna console 7_
        15.1 mudar texto
        15.2 excluir comentário

console 16: _Console criação Video_
    Digite um titulo
    -> {Video.titulo}
    Digite uma descrição
    -> {Video.descrição}
    Digite uma duração
    -> {Video.duração}
    _Chama console 6_

console 17: _Criação de enquete_
    Digite uma pergunta:
    -> {Enquete.pergunta}
    Digite a Opação 1:
    -> {Enquete.opcoes[0]}
    Digite a Opação 2:
    -> {Enquete.opcoes[1]}
    Digite a Opação 3:
    -> {Enquete.opcoes[2]}
    Digite a Opação 4:
    -> {Enquete.opcoes[3]}
    _Quando terminar chama console 8_