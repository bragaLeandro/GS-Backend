package br.com.fiap.to;

import java.util.Date;

public class CarroTO {

	private Long idEmpresa;
	private Long idCarro;
	private String marca;
	private String modelo;
	private Integer ano;
	private Date dataRegistro;
	
	public CarroTO() {
		
	}
	
	
	public CarroTO(Long idEmpresa, Long idCarro, String marca, String modelo, Integer ano, Date dataRegistro) {
		this.idEmpresa = idEmpresa;
		this.idCarro = idCarro;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.dataRegistro = dataRegistro;
	}


	public CarroTO(Long idEmpresa, Long idCarro, String marca, String modelo, Integer ano) {
		this.idEmpresa = idEmpresa;
		this.idCarro = idCarro;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	
	public Long getIdCarro() {
		return idCarro;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setIdCarro(Long idCarro) {
		this.idCarro = idCarro;
	}
}
