package br.com.fiap.to;

import java.util.Date;

public class EmpresaTO {

	private Long idEmpresa;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private Date dataFundacao;
	private Date dataRegistro;
	
	
	public EmpresaTO(Long idEmpresa, String cnpj, String razaoSocial, String nomeFantasia, Date dataFundacao, Date dataRegistro) {
		this.idEmpresa = idEmpresa;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.dataFundacao = dataFundacao;
		this.dataRegistro = dataRegistro;
	}
	
	public EmpresaTO() {
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public Date getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
}
