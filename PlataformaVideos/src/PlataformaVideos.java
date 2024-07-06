import java.util.Scanner;

public class PlataformaVideos {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Video v[] = new Video[5];
		Cadastro c = new Cadastro();
		Visualizacao vis = new Visualizacao();

		v[0] = new Video("Como fazer pão", "Cozinha Todo Dia", 23);
		v[1] = new Video("Dicas de programação", "Canal do Código", 4);
		v[2] = new Video("Funcionalidades incríveis da IDE Eclipse", "Mundo da Programação", 3);
		v[3] = new Video("Os melhores sites de APIs e como as utilizar na sua aplicação", "Back-end sem Neura", 9);
		v[4] = new Video("Aula 4 de Python: Explorando as Principais Bibliotecas", "Cursos para Devs", 12);

		System.out.println("-- Bem-vindo à Plataforma de Vídeos! Cadastre-se para Obter o Acesso --");

		int opcao;

		do {
			System.out.println("\n| --  ---   ---   ---   ---   ---   ---   ---   ---   ---  -- |");
			System.out.println("| Opção 1: Criar conta / Opção 2: Fazer login / Opção 3: Sair |");
			System.out.println("| --  ---   ---   ---   ---   ---   ---   ---   ---   ---  -- |");
			opcao = scanner.nextInt();

			if (opcao == 1) {
				c.cadastrarNovoUsuario();
			} else if (opcao == 2) {
				c.realizarLogin();
				if (c.isAutorizacao()) {
					break;
				}
			}
		} while (opcao != 3);

		if (opcao == 3) {
			System.out.println("Plataforma fechada.");
		}

		if (opcao != 3 && c.isAutorizacao()) {

			boolean repetir = false;

			System.out.println("|=== Seja bem-vindo, " + c.getNomeUsuario()
					+ "! Explore para novos saberes ou se diverta para novas emoções ===|\n");

			do {

				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------");
				v[0].info();
				v[1].info();
				v[2].info();
				v[3].info();
				v[4].info();
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------------------------------------\n");

				int videoSelec = -1;
				boolean sair = false;
				boolean fecharPlat = false;

				do {
					System.out.println(
							"Opção 1: Escolher um vídeo / Opção 2: Informações sobre o usuário / Opção 3: Fechar a plataforma");

					int opcaoid = 0;
					int retorno = scanner.nextInt();

					switch (retorno) {
					case 1:
						System.out.print("Insira o ID do vídeo para selecioná-lo: ");
						opcaoid = scanner.nextInt();
						break;
					case 2:
						System.out.println(c.toString());
						break;
					case 3:
						System.out.println("Plataforma fechada.");
						fecharPlat = true; // Essa var = true e opção = 3 precisam sair de todo código abaixo
						repetir = false;
						break;
					default:
						System.out.println("--> Opção inválida. Tente novamente");
						break;
					}

					if (retorno == 1) {
						for (int i = 0; i < v.length; i++) {
							if (opcaoid == v[i].getId()) {
								v[i].info();
								videoSelec = i;
								sair = true;
								break;
							}
						}

						if (sair == false) {
							System.out.println("--> ID inválido. Verifique e tente novamente");
						}

					}

				} while (sair == false && fecharPlat == false);

				sair = false;

				if (sair == false && fecharPlat == false) {

					int escolha = 0;
					vis.visualizar(v[videoSelec], c);

					do {
						System.out.println("\n---- Menu de interação com o vídeo ----");
						System.out.println(
								"Opção 1: Reproduzir / Opção 2: Pausar / Opção 3: Compartilhar / Opção 4: Avaliar / Opção 5: Exibir as informações / Opção 6: Fechar o vídeo");
						escolha = scanner.nextInt();

						switch (escolha) {
						case 1:
							v[videoSelec].play();
							break;
						case 2:
							v[videoSelec].pause();
							break;
						case 3:
							v[videoSelec].share();
							break;
						case 4:
							System.out.println(
									"Opção 1: Avaliar positivamente / Opção 2: Avaliar com uma nota / Opção 3: Avaliar de acordo com o tempo visto de vídeo");
							int avaliar = scanner.nextInt();
							if (avaliar == 1) {
								vis.avaliar();
							} else if (avaliar == 2) {
								System.out.print("Digite a nota para o vídeo: ");
								int notaVid = scanner.nextInt();
								vis.avaliar(notaVid);
							} else if (avaliar == 3) {
								System.out.print(
										"Digite o percentual estimado, em valor decimal, de consumo de tempo do vídeo: ");
								float tempVideo = scanner.nextFloat();
								vis.avaliar(tempVideo);
							} else {
								System.out.println("--> Aviso: opção inválida");
							}
							break;
						case 5:
							v[videoSelec].info();
							break;
						case 6:
							System.out.println("> Vídeo fechado");
							repetir = true;
							break;
						default:
							System.out.println("--> Opção inválida. Tente novamente");
							break;
						}
					} while (escolha != 6);

				}

			} while (repetir == true);
		}

		else {

			scanner.close();
		}
	}

}