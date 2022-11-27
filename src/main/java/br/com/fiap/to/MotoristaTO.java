package br.com.fiap.to;
	
import java.util.Date;

public class MotoristaTO {

	private Long idMotorista;
	private String nome;
	private String sobrenome;
	private String cnh;
	private String cpf;
	private String rg;
	private Integer idade;
	private Date dataRegistro;
	
	public MotoristaTO() {
	}
	
	public MotoristaTO(Long idMotorista, String nome, String sobrenome, String cnh, String cpf, String rg,
			Integer idade, Date dataRegistro) {
		super();
		this.idMotorista = idMotorista;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cnh = cnh;
		this.cpf = cpf;
		this.rg = rg;
		this.idade = idade;
		this.dataRegistro = dataRegistro;
	}

	public MotoristaTO(Long idMotorista, String nome, String sobrenome, String cnh, String cpf, String rg,
			Integer idade) {
		this.idMotorista = idMotorista;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cnh = cnh;
		this.cpf = cpf;
		this.rg = rg;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public void setIdMotorista(Long idMotorista) {
		this.idMotorista = idMotorista;
	}
	
	public Long getIdMotorista() {
		return idMotorista;
	}
	
	public Date getDataRegistro() {
		return dataRegistro;
	}
	
	
}
