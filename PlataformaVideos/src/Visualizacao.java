
public final class Visualizacao {
	private Cadastro espectador;
	private Video midia;

	public Usuario getEspectador() {
		return espectador;
	}

	public Video getMidia() {
		return midia;
	}

	public void setMidia(Video midia) {
		this.midia = midia;
	}

	public void avaliar() {
		this.midia.setAvaliacao(5);
	}
	
	public void visualizar(Video midia, Cadastro espectador) {
		this.midia = midia;
		this.espectador = espectador;
		this.espectador.setTotAssistido(this.espectador.getTotAssistido() + 1);
		this.midia.setViews(this.midia.getViews() + 1);
	}

	public void avaliar(int nota) {
		if (nota > 5) {
			this.midia.setAvaliacao(5);
		} else if (nota < 0) {
			this.midia.setAvaliacao(0);
		} else {
			this.midia.setAvaliacao(nota);
		}
	}

	public void avaliar(float porcent) {
		int tot = 0;
		if (porcent <= 20) {
			tot = 2;
		} else if (porcent <= 50) {
			tot = 3;
		} else if (porcent <= 90) {
			tot = 4;
		} else {
			tot = 5;
		}
		this.midia.setAvaliacao(tot);

	}

	@Override
	public String toString() {
		return "Visualizacao [espectador=" + espectador + ", midia=" + midia + "]";
	}

}
