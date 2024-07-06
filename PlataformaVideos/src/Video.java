
public class Video implements AcoesVideo {
	private String titulo;
	private String autor;
	private float avaliacao;
	private int views;
	private boolean reproduzindo;
	private int id;

	public Video(String titulo, String autor, int id) {
		this.titulo = titulo;
		this.autor = autor;
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(float avaliacao) {
		float novaAval;

		novaAval = (this.avaliacao + avaliacao) / this.views;
		this.avaliacao = novaAval;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String isReproduzindo() {
		if (this.reproduzindo) {
			return "Sim";
		} else {
			return "Não";
		}
	}

	public void setReproduzindo(boolean reproduzindo) {
		this.reproduzindo = reproduzindo;
	}

	@Override
	public void play() {
		this.reproduzindo = true;
		System.out.println("> Vídeo reproduzindo");
	}

	@Override
	public void pause() {
		this.reproduzindo = false;
		System.out.println("> Vídeo pausado");
	}

	@Override
	public void share() {
		String link = this.titulo.replaceAll("\\s+", "").toLowerCase();
		System.out.println("Link para compartilhamento do vídeo: https://www.plataformavideos.com.br/" + link);
	}

	public void info() {
		System.out.println("[ Título: " + this.titulo + " | autor: " + this.autor + " | avaliacão: " + this.avaliacao
				+ " | views: " + this.views + " | Reproduzindo: " + isReproduzindo() + " | ID: " + this.id + " ]");
	}

}
