package co.com.prueba.common;

public class EnvioMaritimoDTO {

	private String tipoProducto;
	private int cantidadProducto;
	private String fechaRegistro;
	private String fechaEntrega;
	private String puertoEntrega;
	private double precioEnvio;
	private String numeroFlota;
	private String numeroGuia;
	private double precioTotal;
	private double descuento;
	private double precioDescuento;
	private int idClienteMaritimo;
	
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getPuertoEntrega() {
		return puertoEntrega;
	}
	public void setPuertoEntrega(String puertoEntrega) {
		this.puertoEntrega = puertoEntrega;
	}
	public double getPrecioEnvio() {
		return precioEnvio;
	}
	public void setPrecioEnvio(double precioEnvio) {
		this.precioEnvio = precioEnvio;
	}
	public String getNumeroFlota() {
		return numeroFlota;
	}
	public void setNumeroFlota(String numeroFlota) {
		this.numeroFlota = numeroFlota;
	}
	public String getNumeroGuia() {
		return numeroGuia;
	}
	public void setNumeroGuia(String numeroGuia) {
		this.numeroGuia = numeroGuia;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public double getPrecioDescuento() {
		return precioDescuento;
	}
	public void setPrecioDescuento(double precioDescuento) {
		this.precioDescuento = precioDescuento;
	}
	public int getIdClienteMaritimo() {
		return idClienteMaritimo;
	}
	public void setIdClienteMaritimo(int idClienteMaritimo) {
		this.idClienteMaritimo = idClienteMaritimo;
	}
}
