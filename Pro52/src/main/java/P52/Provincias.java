package P52;

public class Provincias {
	private int Provincia;
	private String NombreProvincia;

	public Provincias(Integer provincia, String nombreProvincia) {
		// TODO Auto-generated constructor stub
		this.Provincia=provincia;
		this.NombreProvincia=nombreProvincia;
	}

	public int getProvincia() {
		return Provincia;
	}

	public void setProvincia(int provincia) {
		Provincia = provincia;
	}

	public String getNombreProvincia() {
		return NombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		NombreProvincia = nombreProvincia;
	}
}
