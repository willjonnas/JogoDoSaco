import java.util.*;
public class Main {

    static List<Ouvintes> listaOuvintes;
    static int idProximoOuvinte;
    static Scanner in;
    static int[] apostas = new int[3];


    public static void main(String[] args) {
        /*A “Anabela de Malhadas” queria acertar o valor do peso do saco, mas confundiu-se! No "Jogo do Saco", programa da Rádio
     Brigantia, em Bragança, apresentado pelo locutor Sidónio Costa, era, diariamente, pedido aos ouvintes que acertassem o
     peso de um saco com alguma coisa dentro. Em cada programa era dada aos ouvintes uma margem de 150g (ex.: entre
     4,200kg e 4,350kg) para acertarem no peso do saco. Vídeo: https://www.youtube.com/watch?v=hIrRNFa8OiA
     Faça uma aplicação que permita aos ouvintes jogar no “Jogo do Saco”. Implemente as seguintes opções:
     1. Criar, editar e eliminar ouvintes.
     2. Ver dados de um ouvinte.
     3. Ver ranking de ouvintes (número de vezes que jogaram e número de vezes que acertaram).
     4. Jogar.
     Em cada jogo devem ser selecionados de forma aleatória quais os ouvintes que vão jogar e a sua ordem. Em cada jogo o
     vencedor será o que se aproximar mais do valor do peso do saco.
      */

        listaOuvintes = new ArrayList<>();
        Init();
        in = new Scanner(System.in);
        int op;

        do {
            System.out.println("");
            System.out.println("--------Jogo do Saco-----------");
            System.out.println("");
            System.out.println("1-Consultar dados do Ouvinte");
            System.out.println("2-Criar Ouvinte");
            System.out.println("3-Editar Ouvinte");
            System.out.println("4-Remover Ouvinte");
            System.out.println("5-Jogo Maquina");
            System.out.println("6-Jogo a Inserir Valores");
            System.out.println("7-Ranking");
            System.out.println("8-Ver todos Ouvintes");
            System.out.println("0-Sair");
            System.out.println("-------------------------------");
            System.out.println("");
            op = in.nextInt();

            switch (op) {
                case 0 -> {
                    return;
                }
                case 1 -> VerDadosOuvinte();
                case 2 -> CriarOuvinte();
                case 3 -> EditarOuvinte();
                case 4 -> RemoverOuvinte();
                case 5 -> Jogo();
                case 6 -> Jogo1();
                case 7 -> Ranking();
                case 8 -> VerTodos();


                default -> {
                    System.out.println("Opção inválida");
                }
            }
        } while (op != 0);
    }

    private static void Init() {
        listaOuvintes.add(new Ouvintes(1001, "Brenda Pinheiro", 31, "Aveiro"));//0
        listaOuvintes.add(new Ouvintes(1002, "Maria Lima", 31, "Aveiro"));//1
        listaOuvintes.add(new Ouvintes(1003, "Nuno Lopes", 33, "Lisboa"));//2
        listaOuvintes.add(new Ouvintes(1004, "Ricardo Ferreira", 22, "Braga"));//3
        listaOuvintes.add(new Ouvintes(1005, "Lucas Nunes", 19, "Rio Tinto"));//4
        listaOuvintes.add(new Ouvintes(1006, "Willam Lima", 30, "Vila Nova de Gaia"));//5
        idProximoOuvinte = 1007;
    }

    private static void VerDadosOuvinte() {
        System.out.println("Indique o ID do Ouvinte");
        int id = in.nextInt();

        for (int i = 0; i < listaOuvintes.size(); i++) {
            if (listaOuvintes.get(i).getId() == id) {
                System.out.println("-------------------------------");
                System.out.println("");
                System.out.println(listaOuvintes.get(i));
                System.out.println("");
                System.out.println("-------------------------------");
                System.out.println("Clique 0 para continuar");
                String pausa = in.next();
                return;
            }
        }
        System.out.println("-------------------------------");
        System.out.println("");
        System.out.println("Ouvinte não cadastrado");
        System.out.println("");
        System.out.println("-------------------------------");
        System.out.println("Clique 0 para continuar");
        String pausa = in.next();

    }


    private static void CriarOuvinte() {
        System.out.println("-------------------------------");
        System.out.println("");
        in = new Scanner(System.in);
        System.out.println("Qual o nome do Ouvinte?");
        String nome = in.nextLine();

        in = new Scanner(System.in);
        System.out.println("Qual a idade do Ouvinte?");
        int idade = in.nextInt();

        in = new Scanner(System.in);
        System.out.println("Qual a distrito do Ouvinte?");
        String distrito = in.nextLine();

        listaOuvintes.add(new Ouvintes(idProximoOuvinte, nome, idade, distrito));
        idProximoOuvinte++;
        System.out.println("Ouvinte criado com sucesso!");
        System.out.println();
        System.out.println("");
        System.out.println("-------------------------------");
        System.out.println("Clique 0 para continuar");
        String pausa = in.next();

    }

    private static void EditarOuvinte() {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < listaOuvintes.size(); i++) {
            System.out.println(listaOuvintes.get(i));
        }
        System.out.println("-------------------------------");
        System.out.println("");
        System.out.println("Qual o ID do Ouvinte que quer editar?");
        int numID = in.nextInt();

        for (int i = 0; i < listaOuvintes.size(); i++) {
            if (numID == listaOuvintes.get(i).getId()) {
                System.out.println("");
                System.out.println("Que informacao quer editar? \n1:Nome \n2:Idade \n3:Localidade");
                System.out.println("");
                int opcao = in.nextInt();

                if (opcao == 1) {
                    System.out.println("Qual o novo nome?");
                    String nome = in.next();
                    listaOuvintes.get(i).setNome(nome);
                    System.out.println("");
                    System.out.println("Nome atualizado com sucesso!");
                } else if (opcao == 2) {
                    System.out.println("Qual a nova idade?");
                    int idade = in.nextInt();
                    listaOuvintes.get(i).setIdade(idade);
                    System.out.println("");
                    System.out.println("Idade atualizada com sucesso!");
                } else if (opcao == 3) {
                    System.out.println("Edite ao Distrito");
                    String distrito = in.next();
                    listaOuvintes.get(i).setDistrito(distrito);
                    System.out.println("");
                    System.out.println("Localidade atualizada com sucesso!");
                } else {
                    System.out.println("");
                    System.out.println("Opcao invalida");
                    return;
                }
                return;
            }
        }
        System.out.println("");
        System.out.println("ID não cadastrado");

    }

    private static void RemoverOuvinte() {

        do {
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("Qual o ID do Ouvinte para eliminar?");
            int id = in.nextInt();
            for (int i = 0; i < listaOuvintes.size(); i++) {


                if (listaOuvintes.get(i).getId() == id) {

                    System.out.println("");
                    System.out.println("");
                    System.out.println(listaOuvintes.get(i));
                    System.out.println("");
                    System.out.println("Pretende eliminar este ouvinte? \t1 - Sim\t 0 - Não");

                    int esc = in.nextInt();
                    if (esc == 1) {

                        listaOuvintes.remove(i);
                        System.out.println("");
                        System.out.println("Ouvinte removido com sucesso");
                        System.out.println("");
                        System.out.println("-------------------------------");
                        System.out.println("");
                        System.out.println("Clique 0 para continuar");
                        String pausa = in.next();
                        return;
                    } else {
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Ouvinte não removido");
                        System.out.println();
                        System.out.println("-------------------------------");
                        return;
                    }
                }

            }
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("Ouvinte não existe na BD");
            System.out.println();
            System.out.println("-------------------------------");
        } while (listaOuvintes.size() > 0);
    }

    private static void Jogo() {
        Random rnd = new Random();
        int nrJogadores = 4;


        // variaveis para encontrar limite inferior e superior, para gerar valor random do peso do saco.
        int pesoMinimo = 3500;
        int pesoMaximo = 5000;
        int limInferiorPesoSaco = 0;
        int limSuperiorPesoSaco = limInferiorPesoSaco + 150;
        int pesoSaco;

        // Gerar valor random do peso do saco
        limInferiorPesoSaco = rnd.nextInt(pesoMinimo, pesoMaximo);
        limSuperiorPesoSaco = limInferiorPesoSaco + 150;
        pesoSaco = rnd.nextInt(limInferiorPesoSaco, limSuperiorPesoSaco);

        Collections.shuffle(listaOuvintes);

        System.out.println("");
        System.out.println("Caros Ouvintes, o saco pesa entre " + limInferiorPesoSaco + "gr e " + limSuperiorPesoSaco + "gr.");
        System.out.println("Digite o valor do saco, em gramas. Por exemplo: 2550");
        System.out.println("");

        int[] apostas = new int[4];
        for (int i = 0; i < nrJogadores; i++) {

            System.out.println("Em " + (i + 1) + " º lugar o(a) " + listaOuvintes.get(i).getNome());
            System.out.println("");
        }
        for (int i = 0; i < nrJogadores; i++) {
            apostas[i] = rnd.nextInt(limInferiorPesoSaco, limSuperiorPesoSaco);
            listaOuvintes.get(i).setNumeroTentativas(listaOuvintes.get(i).getNumeroTentativas() + 1);

        }
        for (int i = 0; i < nrJogadores; i++) {
            System.out.println(listaOuvintes.get(i).getNome() + " apostou " + apostas[i] + "g");

        }
        // Verificar qual o valor mais aproximado ao valor do saco

        int distance = Math.abs(apostas[0] - pesoSaco);
        int index = 0;
        for (int i = 1; i < apostas.length; i++) {
            int cdistance = Math.abs(apostas[i] - pesoSaco);
            if (cdistance < distance) {
                index = i;
                distance = cdistance;
            }
        }
        int melhorAposta = apostas[index];
        System.out.println("-----------------------------------------");
        System.out.println("O peso do Saco e " + pesoSaco + "gr.");
        System.out.println("O peso mais aproximado do peso do Saco e " + melhorAposta + "gr. \nO(A) GRANDE VENCEDOR(A) e o(a)" + listaOuvintes.get(index).getNome() + ".");
        System.out.println("-----------------------------------------");


        listaOuvintes.get(index).setNumeroVitorias(listaOuvintes.get(index).getNumeroVitorias()+1); //número de acertos


    }

    private static void Ranking() {

        for (int i = 0; i < listaOuvintes.size(); i++) {
            for (int j = i + 1; j < listaOuvintes.size(); j++) {
                if (listaOuvintes.get(i).getNumeroVitorias() < listaOuvintes.get(j).getNumeroVitorias()) {

                    Collections.swap(listaOuvintes, i, j);
                }
            }
            System.out.println(listaOuvintes.get(i).toString() + "\nVitorias: " + listaOuvintes.get(i).getNumeroVitorias() + "\nTentativas: " + listaOuvintes.get(i).getNumeroTentativas());
            System.out.println("-------------------------");
            System.out.println();
        }

    }
    private static void VerTodos() {
        System.out.println("-------------------------------");
        for (int i = 0; i < listaOuvintes.size(); i++) {
            System.out.println(listaOuvintes.get(i));
        }
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("Clique 0 para continuar");
        String pausa = in.next();

    }
    private static void Jogo1(){
        Random rnd = new Random();
        int[] apostas = new int[4];
        int nrJogadores = 4;
        int pesoMinimo = 500;
        int pesoMaximo = 5000;
        int limInferiorPesoSaco = 0;
        int limSuperiorPesoSaco = limInferiorPesoSaco + 150;
        int pesoSaco;

        Collections.shuffle(listaOuvintes);

        for (int i = 0; i < nrJogadores; i++) {
            System.out.println("Em " + (i + 1) + " º lugar o(a) " + listaOuvintes.get(i).getNome());
        }

        // Gerar valor random do peso do saco
        limInferiorPesoSaco = rnd.nextInt(pesoMinimo, pesoMaximo);
        limSuperiorPesoSaco = limInferiorPesoSaco + 150;
        pesoSaco = rnd.nextInt(limInferiorPesoSaco, limSuperiorPesoSaco);


        System.out.println("");
        System.out.println("Caros Ouvintes, o saco pesa entre " + limInferiorPesoSaco + "gr e " + limSuperiorPesoSaco + "gr.");
        System.out.println("Digite o valor do saco, em gramas. Por exemplo: 2550");
        System.out.println("");

        for (int i = 0; i < nrJogadores; i++) {
            int aposta = 0;
            System.out.println(listaOuvintes.get(i).getNome() + ": Qual e a sua aposta?");
            if (in.hasNextInt()) {
                aposta = in.nextInt();
            }else{
                System.out.println("Valor errado. Introduza um numero inteiro.");
            }

            boolean apostaRepetida = false;
            if (aposta >= limInferiorPesoSaco && aposta <= limSuperiorPesoSaco) {
                for (int j = 0; j < nrJogadores; j++) {
                    if (aposta == apostas[j]) {
                        System.out.println("Esta aposta ja foi feita. Tente outra aposta");
                        apostaRepetida = true;
                        i--;
                        break;
                    }

                } if(!apostaRepetida){
                    apostas[i] = aposta;
                    listaOuvintes.get(i).setNumeroTentativas(listaOuvintes.get(i).getNumeroTentativas() + 1);
                }

            } else {
                System.out.println("O valor da aposta deve ser entre " + limInferiorPesoSaco + " e " + limSuperiorPesoSaco);
                i--;
            }
        }

        // Verificar qual o valor mais aproximado ao valor do saco
        int distance = Math.abs(apostas[0] - pesoSaco);
        int index = 0;
        for (int i = 1; i < apostas.length; i++) {
            int cdistance = Math.abs(apostas[i] - pesoSaco);
            if (cdistance < distance) {
                index = i;
                distance = cdistance;
            }
        }
        int melhorAposta = apostas[index];
        System.out.println("-----------------------------------------");
        System.out.println("O peso do Saco e " + pesoSaco + "gr.");
        System.out.println("O peso mais aproximado do peso do Saco e " + melhorAposta + "gr. \nO(A) GRANDE VENCEDOR(A) e o(a)" + listaOuvintes.get(index).getNome() + ".");
        System.out.println("-----------------------------------------");

        listaOuvintes.get(index).setNumeroVitorias(listaOuvintes.get(index).getNumeroVitorias()+1); //número de acertos

        System.out.println();
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("Clique 0 para continuar");
        String pausa = in.next();
    }

}