import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cliente {
    private String nome;
    private String endereco;
    private String dataNascimento;

    public Cliente(String nome, String endereco, String dataNascimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

public class CadastroClientes {
    private List<Cliente> clientes;

    public CadastroClientes() {
        clientes = new ArrayList<>();
    }

    public void adicionarCliente(String nome, String endereco, String dataNascimento) {
        Cliente novoCliente = new Cliente(nome, endereco, dataNascimento);
        clientes.add(novoCliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    public void listarClientes() {
        System.out.println("Lista de clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
            System.out.println("------------------------");
        }
    }

    public void buscarCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Cliente encontrado:");
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Endereço: " + cliente.getEndereco());
                System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    public void editarCliente(String nome, String novoEndereco, String novaDataNascimento) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                cliente.setEndereco(novoEndereco);
                cliente.setDataNascimento(novaDataNascimento);
                System.out.println("Informações do cliente atualizadas com sucesso!");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    public static void main(String[] args) {
        CadastroClientes cadastro = new CadastroClientes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente");
            System.out.println("4 - Editar cliente");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Data de Nascimento: ");
                    String dataNascimento = scanner.nextLine();
                    cadastro.adicionarCliente(nome, endereco, dataNascimento);
                    break;
                case 2:
                    cadastro.listarClientes();
                    break;
                case 3:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeBusca = scanner.nextLine();
                    cadastro.buscarCliente(nomeBusca);
                    break;
                case 4:
                    System.out.print("Digite o nome do cliente que deseja editar: ");
                    String nomeEdicao = scanner.nextLine();
                    System.out.print("Novo endereço: ");
                    String novoEndereco = scanner.nextLine();
                    System.out.print("Nova data de Nascimento: ");
                    String novaDataNascimento = scanner.nextLine();
                    cadastro.editarCliente(nomeEdicao, novoEndereco, novaDataNascimento);
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
