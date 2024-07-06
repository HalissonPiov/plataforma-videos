
public class Usuario extends Pessoa {

	private int totAssistido;
	protected String nomeUsuario;

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public int getTotAssistido() {
		return totAssistido;
	}

	public void setTotAssistido(int totAssistido) {
		this.totAssistido = totAssistido;
	}

	public void viuMaisUm() {
		this.totAssistido++;
	}

	@Override
	public String toString() {
		return "\nInformações de Usuário [ " + super.toString() + " - nome de usuário: " + getNomeUsuario()
				+ " - total de vídeos assistidos: " + totAssistido + " ]\n";
	}

}
