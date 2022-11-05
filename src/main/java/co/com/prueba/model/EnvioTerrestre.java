package co.com.prueba.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EnvioTerrestre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "TipoProducto")
	private String tipoProducto;
	@Column(name = "Cantidad Producto")
	private int cantidadProducto;
	@Column(name = "FechaRegistro")
	private Date fechaRegistro;
	@Column(name = "FechaEntrega")
	private Date fechaEntrega;
	@Column(name = "BodegaEntrega")
	private String bodegaEntrega;
	@Column(name = "PrecioEnvio")
	private double precioEnvio;
	@Column(name = "PlacaVehiculo")
	private String placaVehiculo;
	@Column(name = "NumeroGuia")
	private String numeroGuia;
	@Column(name = "PrecioTotal")
	private double precioTotal;
	@Column(name = "Descuento")
	private double descuento;
	@Column(name = "PrecioDescuento")
	private double precioDescuento;
	@ManyToOne
	private Cliente idCliente;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getBodegaEntrega() {
		return bodegaEntrega;
	}
	public void setBodegaEntrega(String bodegaEntrega) {
		this.bodegaEntrega = bodegaEntrega;
	}
	public double getPrecioEnvio() {
		return precioEnvio;
	}
	public void setPrecioEnvio(double precioEnvio) {
		this.precioEnvio = precioEnvio;
	}
	public String getPlacaVehiculo() {
		return placaVehiculo;
	}
	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
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
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
}
