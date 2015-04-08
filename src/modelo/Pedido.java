package modelo;

import java.io.Serializable;

public class Pedido implements Serializable{

    private String codPed;
    private String codCli;
    private String codProdA;
    private String codProdB;

    public Pedido(String codPed, String codCli, String codProdA, String codProdB) {
        this.codPed = codPed;
        this.codCli = codCli;
        this.codProdA = codProdA;
        this.codProdB = codProdB;
    }

    public Pedido() {
    }

    public String getCodPed() {
        return codPed;
    }

    public void setCodPed(String codPed) {
        this.codPed = codPed;
    }

    public String getCodCli() {
        return codCli;
    }

    public void setCodCli(String codCli) {
        this.codCli = codCli;
    }

    public String getCodProdA() {
        return codProdA;
    }

    public void setCodProdA(String codProdA) {
        this.codProdA = codProdA;
    }

    public String getCodProdB() {
        return codProdB;
    }

    public void setCodProdB(String codProdB) {
        this.codProdB = codProdB;
    }
    
    
    
}
