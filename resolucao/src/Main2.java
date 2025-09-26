import modulos.*;
import repositories.*;
import services.ObraService;
import services.PessoaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PessoaRepository pessoaRepository = new PessoaRepositoryVetor();
        ObrasRepository obrasRepository = new ObraRepositoryVetor();
        //PessoaRepository pessoaRepository = new PessoaRepositoryLista();
        PessoaService pessoaService = new PessoaService(pessoaRepository);
        //ObrasRepository obrasRepository = new ObraRepositoryLista();
        ObraService obraService = new ObraService(obrasRepository);

        //Pessoa ator = new Ator();
        //Pessoa diretor = new Diretor();

        int opcao = 0;
        while (opcao != 15) {
            System.out.println("-- GERENCIAMENTO DE FILMES/SERIES --");
            System.out.println("=== Menu ===");
            System.out.println("1 - Cadastrar Filme ");
            System.out.println("2 - Cadastrar Serie ");
            System.out.println("3 - Cadastrar o ator principal ");
            System.out.println("4 - Cadastrar Diretor ");
            System.out.println("5 - Listar Obras");
            System.out.println("6 - Listar Pessoas");
            System.out.println("7 - Buscar Obras cadastradas");
            System.out.println("8 - Buscar Pessoas");
            System.out.println("9 - Atualizar Filme");
            System.out.println("10 - Atualizar Série");
            System.out.println("11 - Atualizar Ator");
            System.out.println("12 - Atualizar Diretor");
            System.out.println("13 - Remover uma Obra");
            System.out.println("14 - Remover Pessoa");
            System.out.println("15- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            //cadastra Filme
            if (opcao == 1) {
                System.out.print("Digite o ID: ");
                Long id = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Digite o Titulo: ");
                String titulo = scanner.nextLine();
                System.out.println("Qual o genero do Filme: ");
                String generosA = scanner.nextLine();
                String [] generoV = generosA.split(",");
                List<Genero> generos = new ArrayList<>();
                for (int i = 0; i < generoV.length; i++) {
                    generos.add(Genero.valueOf(generoV[i].toUpperCase()));
                    System.out.println("Qual a classificação: ");
                    String classificacao = scanner.nextLine();
                    System.out.println("Digite o ano de lancamento: ");
                    String ano = scanner.nextLine();
                    System.out.println("Digite o id do Diretor da obra: ");
                    Long idDiretor = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Digite o id do Ator: ");
                    Long idAtor = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Qual a duração do Filme: ");
                    String duracao = scanner.nextLine();

                    Pessoa diretor = pessoaService.buscar(idDiretor);
                    Pessoa ator = pessoaService.buscar(idAtor);
                    obraService.cadastrar(new Filmes(id, titulo, generos, classificacao, ano, diretor, ator, duracao));
                }

                //Cadastro de SÉRIE
            }  else if (opcao == 2) {
                System.out.print("Digite o ID: ");
                Long id = scanner.nextLong();
                scanner.nextLine();

                System.out.println("Digite o Titulo da serie:");
                String titulo = scanner.nextLine();

                System.out.println("Qual o genero da serie: ");
                String generosA = scanner.nextLine();

                String[] generoV = generosA.split(",");
                List<Genero> generos = new ArrayList<>();
                for (int i = 0; i < generoV.length; i++) {
                    generos.add(Genero.valueOf(generoV[i].trim().toUpperCase()));
                }

                System.out.println("Qual a classificação indicativa: ");
                String classificacao = scanner.nextLine();

                System.out.println("Digite o ano de lancamento");
                String ano = scanner.nextLine();

                System.out.println("Digite o ID Diretor da obra: ");
                Long idDiretor = scanner.nextLong();
                scanner.nextLine();

                System.out.println("Digite o ID Ator: ");
                Long idAtor = scanner.nextLong();
                scanner.nextLine();

                System.out.println("Digite quantos episodios tem a serie: ");
                String episodios = scanner.nextLine();

                System.out.println("Quantas temporadas tem a serie: ");
                String temporadas = scanner.nextLine();

                Pessoa diretor = pessoaService.buscar(idDiretor);
                Pessoa ator = pessoaService.buscar(idAtor);

                obraService.cadastrar(new Series(id, titulo, generos, classificacao, ano, diretor, ator, episodios, temporadas));





                //Cadastrar ator principal
            } else if (opcao == 3) {
                System.out.print("Digite o ID do ator: ");
                Long id = scanner.nextLong();
                scanner.nextLine();
                System.out.print("Digite o Nome: ");
                String nome = scanner.nextLine();

                pessoaService.cadastrar(new Ator(nome, id));


                //Cadastrar diretor
            } else if (opcao == 4) {
                System.out.println("Digite o ID do diretor: ");
                Long id = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Digite o Nome: ");
                String nome = scanner.nextLine();
                System.out.println("Quantas obras esse diretor ja fez: ");
                String obrasDirigidas = scanner.nextLine();

                pessoaService.cadastrar(new Diretor(nome, id, obrasDirigidas));


                //Listar Obras
            } else if (opcao == 5) {
                List<Obra> obras = obraService.listarObras();
                if (obras.isEmpty()) {
                    System.out.println("Nenhuma obra cadastrada");
                } else {
                    obras.forEach(o -> System.out.println("ID: " + o.getId() + "| Titulo: " + o.getTitulo() + "| Generos: " + o.getGeneros() +
                            "| Classificação: " + o.getClassificacao() + "| Ano: " + o.getAno() + "| Diretor: " + o.getDiretor() + "| Ator: " + o.getAtor()));
                }
                //Listar Pessoas
            } else if (opcao == 6) {
                List<Pessoa> pessoas = pessoaService.listarTodos();
                if (pessoas.isEmpty()) {
                    System.out.println("Nenhuma pessoa cadastrada.");
                } else {
                    pessoas.forEach(p -> System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome()));
                }


                //Obras cadastradas
            } else if (opcao == 7) {
                System.out.println("Digite o ID para buscar a Obra: ");
                Long id = scanner.nextLong();
                scanner.nextLine();
                try {
                    Obra obra1 = obraService.buscar(id);
                    System.out.println("OBRA ENCONTRADA! \n ID: " + obra1.getId() + "| Titulo: " + obra1.getTitulo() + "| Generos: " + obra1.getGeneros() +
                            "| Classificação: " + obra1.getClassificacao() + "| Ano: " + obra1.getAno() + "| Diretor: " + obra1.getDiretor() + "| Ator: " + obra1.getAtor());
                } catch (RuntimeException buscar) {
                    System.out.println(buscar.getMessage());
                }

                //buscar pessoa
            } else if (opcao == 8) {
                System.out.print("Digite o ID para buscar a Pessoa: ");
                Long id = scanner.nextLong();
                scanner.nextLine();
                try {
                    Pessoa pessoa1 = pessoaService.buscar(id);
                    System.out.println("Pessoa encontrada:\n" + pessoa1.getNome());
                } catch (RuntimeException buscar) {
                    System.out.println(buscar.getMessage());
                }


                //atualizar filme
            } else if (opcao == 9) {
                System.out.print("Digite o ID do Filme para atualizar: ");
                Long id = scanner.nextLong();
                scanner.nextLine();

                System.out.print("Digite a nova classificação indicativa: ");
                String novaClass = scanner.nextLine();


                System.out.print("Digite o novo título do Filme: ");
                String novoTitulo = scanner.nextLine();

                Filmes oAtualizada = new Filmes();
                oAtualizada.setClassificacao(novaClass);
                oAtualizada.setTitulo(novoTitulo);
                try {
                    obraService.atualizar(id, oAtualizada);
                    System.out.println("Filme atualizado com sucesso!");
                } catch (RuntimeException e) {
                    System.out.println("Erro: " + e.getMessage());
                }

                //atualizar SÉRIE
            } else if (opcao == 10){
                System.out.print("Digite o ID do serie para atualizar: ");
                Long id = scanner.nextLong();
                scanner.nextLine();
                System.out.print("Digite a nova classificação indicativa: ");
                String novaClass = scanner.nextLine();
                System.out.print("Digite o novo título do serie: ");
                String novoTitulo = scanner.nextLine();

                Series sAtualizada = new Series();
                sAtualizada.setClassificacao(novaClass);
                sAtualizada.setTitulo(novoTitulo);
                try {
                    obraService.atualizar(id, sAtualizada);
                    System.out.println("Serie atualizado com sucesso!");
                } catch (RuntimeException e) {
                    System.out.println("Erro: " + e.getMessage());
                }

                //atualizar  ATOR
            } else if (opcao == 11) {
                System.out.print("Digite o ID para atualizar: ");
                Long id = scanner.nextLong();
                scanner.nextLine();
                System.out.print("Digite o novo nome: ");
                String novoNome = scanner.nextLine();
                scanner.nextLine();

                Pessoa pAtualizada = new Ator();
                pAtualizada.setNome(novoNome);

                try {
                    System.out.println("Ator Atualizado com sucesso!");
                    pessoaService.atualizar(id, pAtualizada);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }

                //atualizar diretor
            }else if (opcao == 12) {
                System.out.print("Digite o ID para atualizar: ");
                Long id = scanner.nextLong();
                scanner.nextLine();
                System.out.print("Digite o novo nome: ");
                String novoNome = scanner.nextLine();
                scanner.nextLine();


                Pessoa pAtualizada = new Diretor();
                pAtualizada.setNome(novoNome);

                try {
                    System.out.println("Diretor Atualizado com sucesso!");
                    pessoaService.atualizar(id, pAtualizada);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
                //Remover Obra
            } else if (opcao == 13) {
                System.out.print("Digite o ID da obra para remover: ");
                Long id = scanner.nextLong();
                scanner.nextLine();

                try {
                    obraService.remover(id);
                    System.out.println("Obra removida com sucesso!");
                } catch (RuntimeException e) {
                    System.out.println("Erro: " + e.getMessage());
                }


                //remover pessoa
            } else if (opcao == 14) {
                System.out.print("Digite o ID da pessoa para remover: ");
                Long id = scanner.nextLong();
                scanner.nextLine();

                try {
                    pessoaService.remover(id);
                    System.out.println("Pessoa removida com sucesso!");
                } catch (RuntimeException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                //sair
            } else if (opcao ==15) {
                System.out.println("Saindo...");

            } else {
                System.out.println("Opção inválida!");
            }

            System.out.println();
        }

        scanner.close();
    }
}