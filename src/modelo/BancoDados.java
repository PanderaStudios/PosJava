package modelo;

import java.io.Serializable;

public class BancoDados implements Serializable{

    private String cpf;
    private String tipo;
    private String nome;
    private String ender_quant;
    private String telef_valor;

    public BancoDados(String cpf, String tipo, String nome, String ender_quant, String telef_valor) {
        this.cpf = cpf;
        this.tipo = tipo;
        this.nome = nome;
        this.ender_quant = ender_quant;
        this.telef_valor = telef_valor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnder_Quant() {
        return ender_quant;
    }

    public void setEnder_Quant(String ender_quant) {
        this.ender_quant = ender_quant;
    }

    public String getTelef_Valor() {
        return telef_valor;
    }

    public void setTelef_Valor(String telef_valor) {
        this.telef_valor = telef_valor;
    }
    
    
    
}
