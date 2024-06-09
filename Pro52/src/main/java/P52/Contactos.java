package P52;

public class Contactos {
	private int Id; 
	private String Nombre;
	private String Apellidos;
	private String Dni;
	private String Telefono;
	private String Ecorreo;
	private String fechaCumple;
	private String Direccion;
	private String Poblacion;
	private int Provincia;
	private String CodigoPostal;
	private String Categoria;
	private int Deuda;
	
	public Contactos(int id, String nombre, String apellidos, String dni, String telefono, String ecorreo,
			String fechaCumple, String direccion, String poblacion, int provincia, String codigoPostal,
			String categoria, int deuda) {
		// TODO Auto-generated constructor stub
		this.Id = id;
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.Dni = dni;
		this.Telefono = telefono;
		this.Ecorreo = ecorreo;
		this.fechaCumple = fechaCumple;
		this.Direccion = direccion;
		this.Poblacion = poblacion;
		this.Provincia = provincia;
		this.CodigoPostal = codigoPostal;
		this.Categoria = categoria;
		this.Deuda = deuda;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getEcorreo() {
		return Ecorreo;
	}

	public void setEcorreo(String ecorreo) {
		Ecorreo = ecorreo;
	}

	public String getFechaCumple() {
		return fechaCumple;
	}

	public void setFechaCumple(String fechaCumple) {
		this.fechaCumple = fechaCumple;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getPoblacion() {
		return Poblacion;
	}

	public void setPoblacion(String poblacion) {
		Poblacion = poblacion;
	}

	public int getProvincia() {
		return Provincia;
	}

	public void setProvincia(int provincia) {
		Provincia = provincia;
	}

	public String getCodigoPostal() {
		return CodigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		CodigoPostal = codigoPostal;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public int getDeuda() {
		return Deuda;
	}

	public void setDeuda(int deuda) {
		Deuda = deuda;
	}
}
