package P52;

public class Categorias {
	private String Categoria;
	private String Descripcion;

	public Categorias(String categoria, String descripcion) {
		// TODO Auto-generated constructor stub
		this.Categoria=categoria;
		this.Descripcion=descripcion;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
}
