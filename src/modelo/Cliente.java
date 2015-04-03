/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.BancoDados;

/**
 *
 * @author pande_000
 */
public class Cliente extends BancoDados {

    public Cliente(String cpf, String tipo, String nome, String ender_quant, String telef_valor) {
        super(cpf, tipo, nome, ender_quant, telef_valor);
    }
    
}
