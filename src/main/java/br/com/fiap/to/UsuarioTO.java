package br.com.fiap.to;

import java.util.Date;

public class UsuarioTO {

    private Long idUsuario;
    private String loginUsuario;
    private Character statusUsuario;
    private String tipoUsuario;
    private Date dataRegistro;
    private String senha;

    public UsuarioTO(Long idUsuario, String loginUsuario, Character statusUsuario, String tipoUsuario, Date dataRegistro, String senha) {
        this.idUsuario = idUsuario;
        this.loginUsuario = loginUsuario;
        this.statusUsuario = statusUsuario;
        this.tipoUsuario = tipoUsuario;
        this.dataRegistro = dataRegistro;
        this.senha = senha;
    }
    
    public UsuarioTO(Long idUsuario, String loginUsuario, Character statusUsuario, String tipoUsuario, String senha) {
        this.idUsuario = idUsuario;
        this.loginUsuario = loginUsuario;
        this.statusUsuario = statusUsuario;
        this.tipoUsuario = tipoUsuario;
        this.senha = senha;
    }
    
    public UsuarioTO() {
    	
    }

    public UsuarioTO(Long idUsuario2, String loginUsuario, Date dataRegistro2, Character statusUsuario, String tipoUsuario2,
			String senhaUsuario) {
        this.idUsuario = idUsuario2;
        this.loginUsuario = loginUsuario;
        this.statusUsuario = statusUsuario;
        this.dataRegistro = dataRegistro2;
        this.tipoUsuario = tipoUsuario2;
        this.senha = senhaUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public Character getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(Character statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
