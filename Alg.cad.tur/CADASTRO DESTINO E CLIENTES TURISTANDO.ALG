algoritmo "Cadastro Cliente Destino"

const
   MAX = 3
var
   opcao, opcao2 : inteiro
   nomes, destinos, cpfs : vetor[1..MAX] de caractere
   telefones: vetor[1..MAX] de caractere
   indice, i : inteiro
   nomePesquisa : caractere
   achou : logico
   pause : caractere
inicio
   indice <- 0
   escrevaL(" Agencia Turistando ")
   //timer(1000)

   repita
      limpaTela()
      //timer(500)
      escrevaL("-----Cadastro De Clientes e Destino -----")
      escrevaL("1 - Adicionar")
      escrevaL("2 - consultar")
      escrevaL("3 - sair")


      //timer(0)
      leia(opcao)

      escolha opcao
      caso 1
         indice <- indice+1
         limpaTela()
         escreva ("Nome: ")
         leia(nomes[indice])
         escreva ("Destino:  ")
         leia(destinos[indice])
         escreva ("CPF: ")
         leia(cpfs[indice])
         escreva ("Telefone:")
         leia(telefones[indice])

      caso 2
         escrevaL("-----Consultar Dados -----")
         escrevaL("Consultar Destino - pressione 1")
         escrevaL("Consultar CPF - pressione 2")

         leia(opcao2)

         escolha opcao2
         caso 1
            escrevaL("-----CONSULTA POR Destino-----")
            escreva ("Digite o Destino : ")
            leia(nomePesquisa)

            achou <- FALSO

            para i de 1 ate MAX faca
               se (nomePesquisa = destinos[i]) entao
                  achou <- VERDADEIRO
                  escrevaL("Cadastro encontrado")
                  escrevaL("Nome : ", nomes[i])
                  escrevaL("CPF  : ", cpfs[i])
               fimSe
            fimPara

            se (não achou) entao
               escrevaL("Cadastro não encontrado")
            fimSe

            escrevaL()
            escreva ("Pressione ENTER para continuar")
            leia(pause)

         caso 2
            escrevaL("-----CONSULTA POR CPF-----")
            escreva ("Digite o cpf : ")
            leia(nomePesquisa)

            achou <- FALSO

            para i de 1 ate MAX faca
               se (nomePesquisa = cpfs[i]) entao
                  achou <- VERDADEIRO
                  escrevaL("Cadastro encontrado")
                  escrevaL("Nome : ", nomes[i])
                  escrevaL("CPF  : ", cpfs[i])
                  escrevaL("Destino : ", destinos[i])
                  escrevaL("Telefone  : ", telefones[i])
               fimSe
            fimPara

            se (não achou) entao
               escrevaL("Cadastro não encontrado")
            fimSe

            escrevaL()
            escreva ("Pressione ENTER para continuar")
            leia(pause)

         fimEscolha

      fimEscolha

  caso 3
         escreva ("Cadrastro Fechado! TENHA UMA BOA NOITE!")
ATE (OPCAO=3)

fimAlgoritmo