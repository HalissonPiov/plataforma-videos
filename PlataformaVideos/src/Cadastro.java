import java.util.Scanner;

public class Cadastro extends Usuario {

	Scanner scanner = new Scanner(System.in);

	private String email;
	private String senha;
	private boolean autorizacao;

	public boolean isAutorizacao() {
		return autorizacao;
	}

	public final void cadastrarNovoUsuario() {
		System.out.println(
				"|--- Insira os dados abaixo para realizar o seu cadastro na plataforma (a senha deve ter no mínimo 8 dígitos) ---|");

		System.out.print("E-mail: ");
		this.email = scanner.nextLine().trim();

		while (!this.email.contains("@") || !this.email.contains(".com") || this.email.contains(" ")) {
			System.out.println("--> Aviso: certifique-se de inserir um formato de e-mail válido");
			System.out.print("E-mail: ");
			this.email = scanner.nextLine().trim();
		}

		System.out.print("Senha: ");
		this.senha = scanner.nextLine();

		while (this.senha.length() < 8) {
			System.out.println("--> Aviso: insira uma senha de pelo menos 8 dígitos");
			System.out.print("Senha: ");
			this.senha = scanner.nextLine();
		}

		System.out.print("Insira a senha novamente: ");
		String senhaRepet = scanner.nextLine();

		while (!this.senha.equals(senhaRepet)) {
			System.out.println("--> Aviso: As senhas não coincidem. Insira novamente e confirme");
			System.out.print("Senha: ");
			this.senha = scanner.nextLine();
			System.out.print("Insira a senha novamente: ");
			String senhaRepet2 = scanner.nextLine();
			if (!this.senha.equals(senhaRepet2)) {
				System.out.println(
						"--> Aviso: as senhas não coincidiram novamente. Por favor, repita o processo de cadastro");
				break;
			} else {
				break;
			}
		}

		System.out.println("\n|-- Insira agora as seguintes informações adicionais --|");
		System.out.print("Nome completo: ");
		setNome(scanner.nextLine());

		System.out.print("Idade: ");
		setIdade(scanner.nextInt());

		scanner.nextLine();

		System.out.print("Sexo: ");
		setSexo(scanner.nextLine());

		System.out.println(
				"|-- Cadastro realizado com sucesso! Por favor, agora realize o login para acessar a plataforma --|");

	}

	public void realizarLogin() {
		System.out.println("|-- Insira os dados abaixo para realizar o login na plataforma --|");
		System.out.print("E-mail: ");
		String emailLogin = scanner.nextLine().trim();
		System.out.print("Senha: ");
		String senhaLogin = scanner.nextLine();
		if (!emailLogin.equals(this.email) || !senhaLogin.equals(this.senha)) {
			System.out.println("--> Aviso: conta não encontrada na base de dados");
			System.out.println(
					"Verifique se inseriu corretamente ou faça seu cadastro se não possui uma conta na plataforma");
		} else {

			int posicao = this.email.indexOf("@");

			if (posicao != -1) {
				this.nomeUsuario = this.email.substring(0, posicao);
			}

			System.out
					.println("|-- Login realizado com sucesso. Aproveite a plataforma, " + this.nomeUsuario + "! --|");
			this.autorizacao = true;
		}

	}

}
