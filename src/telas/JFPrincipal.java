/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controle.ControleCliente;
import controle.ControleProduto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Cliente;
import modelo.Produto;

/**
 *
 * @author aluno
 */
public class JFPrincipal extends javax.swing.JFrame {

    protected ControleCliente cCliente
            = new ControleCliente();

    protected ControleProduto cProduto
            = new ControleProduto();

    protected ArrayList<Cliente> obterTodos() {
        return cCliente.obterTodos();
    }

    protected ArrayList<Produto> obterTodosProdutos() {
        return cProduto.obterTodos();
    }

    protected TableModel getDadosTabela() {
        ArrayList<Cliente> lista = obterTodos();
        String[] titulos
                = {"CPF", "Nome", "Endereco", "Telefone"};
        Object[][] valores = new Object[lista.size()][4];
        for (int i = 0; i < lista.size(); i++) {
            valores[i][0] = lista.get(i).getCpf();
            valores[i][1] = lista.get(i).getNome();
            valores[i][2] = lista.get(i).getEndereco();
            valores[i][3] = lista.get(i).getTelefone();
        }
        return new DefaultTableModel(valores, titulos);
    }

    protected TableModel getDadosTabelaProduto() {
        ArrayList<Produto> lista1 = obterTodosProdutos();
        String[] titulos
                = {"COD", "Nome", "Quantidade", "Valor"};
        Object[][] valores = new Object[lista1.size()][4];
        for (int i = 0; i < lista1.size(); i++) {
            valores[i][0] = lista1.get(i).getCpf();
            valores[i][1] = lista1.get(i).getNome();
            valores[i][2] = lista1.get(i).getQuantidade();
            valores[i][3] = lista1.get(i).getValor();
        }
        return new DefaultTableModel(valores, titulos);
    }

    private void atualizarTabela() {
        jTableCliente.setModel(getDadosTabela());
        jTableProduto.setModel(getDadosTabelaProduto());
    }

//    private void atualizarTabelaProduto() {
//        jTableProduto.setModel(getDadosTabelaProduto());
//    }
    protected void persistir(Cliente c, String cpf) {
        JDDadosCliente dados = new JDDadosCliente(this, true);
        dados.setDados(c, cpf);
        dados.setVisible(true);
        // Modal -> Fica parado aqui até a janela "sumir"
        if (dados.sucesso) {
            cCliente.persistir(dados.getDados());
        }
    }

    protected void persistirProduto(Produto p, String cod) {
        JDDadosProduto dados1 = new JDDadosProduto(this, true);
        dados1.setDados(p, cod);
        dados1.setVisible(true);
        // Modal -> Fica parado aqui até a janela "sumir"
        if (dados1.sucesso) {
            cProduto.persistir(dados1.getDados());
        }
    }

    protected void remover(String cpf) {
        cCliente.remover(cpf);
    }

    protected void removerProduto(String cpf) {
        cProduto.remover(cpf);
    }

    protected Cliente obter(String cpf) {
        return cCliente.obter(cpf);
    }

    protected Produto obterProduto(String cpf) {
        return cProduto.obter(cpf);
    }

    protected void preActions() {
    }

    /**
     * Creates new form JFPrincipal
     */
    public JFPrincipal() {
        preActions();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();
        btmSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuIncluirCliente = new javax.swing.JMenuItem();
        mnuAlterarCliente = new javax.swing.JMenuItem();
        mnuExcluirCliente = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuAtualizarCliente = new javax.swing.JMenuItem();
        jMenuProdutos = new javax.swing.JMenu();
        mnuIncluirProduto = new javax.swing.JMenuItem();
        mnuAlterarProduto = new javax.swing.JMenuItem();
        mnuExcluirProduto = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuAtualizarProduto = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jRadioConectar = new javax.swing.JRadioButtonMenuItem();
        jRadioDesconectar = new javax.swing.JRadioButtonMenuItem();
        mnuArmazenar = new javax.swing.JMenuItem();
        mnuRecuperar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableCliente.setModel(getDadosTabela());
        jScrollPane1.setViewportView(jTableCliente);

        jTableProduto.setModel(getDadosTabelaProduto());
        jScrollPane2.setViewportView(jTableProduto);

        btmSair.setText("SAIR");
        btmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmSairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CLIENTES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("PRODUTOS");

        jMenu1.setText("Clientes");

        mnuIncluirCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        mnuIncluirCliente.setText("Incluir");
        mnuIncluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIncluirClienteActionPerformed(evt);
            }
        });
        jMenu1.add(mnuIncluirCliente);

        mnuAlterarCliente.setText("Alterar");
        mnuAlterarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAlterarClienteActionPerformed(evt);
            }
        });
        jMenu1.add(mnuAlterarCliente);

        mnuExcluirCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        mnuExcluirCliente.setText("Excluir");
        mnuExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExcluirClienteActionPerformed(evt);
            }
        });
        jMenu1.add(mnuExcluirCliente);
        jMenu1.add(jSeparator1);

        mnuAtualizarCliente.setText("Atualizar Tela");
        mnuAtualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAtualizarClienteActionPerformed(evt);
            }
        });
        jMenu1.add(mnuAtualizarCliente);

        jMenuBar1.add(jMenu1);

        jMenuProdutos.setText("Produtos");

        mnuIncluirProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        mnuIncluirProduto.setText("Incluir");
        mnuIncluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIncluirProdutoActionPerformed(evt);
            }
        });
        jMenuProdutos.add(mnuIncluirProduto);

        mnuAlterarProduto.setText("Alterar");
        mnuAlterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAlterarProdutoActionPerformed(evt);
            }
        });
        jMenuProdutos.add(mnuAlterarProduto);

        mnuExcluirProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        mnuExcluirProduto.setText("Excluir");
        mnuExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExcluirProdutoActionPerformed(evt);
            }
        });
        jMenuProdutos.add(mnuExcluirProduto);
        jMenuProdutos.add(jSeparator3);

        mnuAtualizarProduto.setText("Atualizar Tela");
        mnuAtualizarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAtualizarProdutoActionPerformed(evt);
            }
        });
        jMenuProdutos.add(mnuAtualizarProduto);

        jMenuBar1.add(jMenuProdutos);

        jMenu2.setText("Conectar");

        jRadioConectar.setSelected(true);
        jRadioConectar.setText("Conectar Servidor");
        jRadioConectar.setEnabled(false);
        jMenu2.add(jRadioConectar);

        jRadioDesconectar.setSelected(true);
        jRadioDesconectar.setText("Desconectar Servidor");
        jRadioDesconectar.setEnabled(false);
        jRadioDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioDesconectarActionPerformed(evt);
            }
        });
        jMenu2.add(jRadioDesconectar);

        mnuArmazenar.setText("Armazenar Dados");
        mnuArmazenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArmazenarActionPerformed(evt);
            }
        });
        jMenu2.add(mnuArmazenar);

        mnuRecuperar.setText("Recuperar Dados");
        mnuRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRecuperarActionPerformed(evt);
            }
        });
        jMenu2.add(mnuRecuperar);
        jMenu2.add(jSeparator2);

        mnuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnuSair.setText("Sair");
        mnuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSairActionPerformed(evt);
            }
        });
        jMenu2.add(mnuSair);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(162, 162, 162))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btmSair))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btmSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAtualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAtualizarClienteActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_mnuAtualizarClienteActionPerformed

    private void mnuIncluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIncluirClienteActionPerformed
        String cpf = entraCPF(true); // recebera codigo digitado
        if (cpf != null) {
            if (!cpf.isEmpty()) {
                persistir(null, cpf);
                atualizarTabela();
            }
        }
    }//GEN-LAST:event_mnuIncluirClienteActionPerformed

    private void mnuAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlterarClienteActionPerformed
        String cpf = entraCPF(false); // recebera codigo digitado
        if (cpf != null) {
            if (!cpf.isEmpty()) {
                persistir(obter(cpf), cpf);
                atualizarTabela();
            }
        }
    }//GEN-LAST:event_mnuAlterarClienteActionPerformed

    private void mnuExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExcluirClienteActionPerformed
        String cpf = entraCPF(false); // recebera codigo digitado
        if (cpf != null) {
            if (!cpf.isEmpty()) {
                remover(cpf);
                atualizarTabela();
            }
        }
    }//GEN-LAST:event_mnuExcluirClienteActionPerformed

    private void mnuArmazenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArmazenarActionPerformed

        try {
            ControleCliente.armazenar();
            ControleProduto.armazenar();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        atualizarTabela();
//        atualizarTabelaProduto();
    }//GEN-LAST:event_mnuArmazenarActionPerformed

    private void mnuRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRecuperarActionPerformed

        try {
            ControleCliente.carregar();
            ControleProduto.carregar();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        atualizarTabela();
//        atualizarTabelaProduto();
    }//GEN-LAST:event_mnuRecuperarActionPerformed

    private void mnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSairActionPerformed
        // TODO add your handling code here:
        sairPgm();
    }//GEN-LAST:event_mnuSairActionPerformed

    private void mnuIncluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIncluirProdutoActionPerformed
        // TODO add your handling code here:
        String cpf = entraCPF(false); // recebera codigo digitado
        if (cpf != null) {
            if (!cpf.isEmpty()) {
                // Modal -> Fica parado aqui até a janela "sumir"
                persistirProduto(null, "" + cpf);
//                atualizarTabelaProduto();
                atualizarTabela();
            }
        }
    }//GEN-LAST:event_mnuIncluirProdutoActionPerformed

    private void mnuAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlterarProdutoActionPerformed
        // TODO add your handling code here:
        String cpf = entraCPF(false); // recebera codigo digitado
        if (cpf != null) {
            if (!cpf.isEmpty()) {
                persistirProduto(obterProduto(cpf), cpf);
//                atualizarTabelaProduto();
                atualizarTabela();
            }
        }
    }//GEN-LAST:event_mnuAlterarProdutoActionPerformed

    private void mnuExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExcluirProdutoActionPerformed
        // TODO add your handling code here:
        String cpf = entraCPF(false); // recebera codigo digitado
        if (cpf != null) {
            if (!cpf.isEmpty()) {
                removerProduto(cpf);
//                atualizarTabelaProduto();
                atualizarTabela();
            }
        }
    }//GEN-LAST:event_mnuExcluirProdutoActionPerformed

    private void mnuAtualizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAtualizarProdutoActionPerformed
        // TODO add your handling code here:
//        atualizarTabelaProduto();
        atualizarTabela();
    }//GEN-LAST:event_mnuAtualizarProdutoActionPerformed

    private void btmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmSairActionPerformed
        // TODO add your handling code here:
        sairPgm();
    }//GEN-LAST:event_btmSairActionPerformed

    private void jRadioDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioDesconectarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioDesconectarActionPerformed

    private void sairPgm() {
        // TODO add your handling code here:
        int sair;
        sair = JOptionPane.showConfirmDialog(null,
                "Confirma Sair do Programa?", "Cliente",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (sair == 0) {
            jTableCliente.removeAll();
            jTableProduto.removeAll();
            System.exit(0);
        }
    }

    private String entraCPF(boolean isIncluir) {
        // TODO add your handling code here:
        String cpf = "";
        boolean isCadastro = false;

        ArrayList<Cliente> cpfCod = (obterTodos());

        // loop enquanto teclar vazio ou not fim
        while (cpf.isEmpty() || true) {
            // janela de input do CPF
            cpf = JOptionPane.showInputDialog(this, "CPF");
            if (cpf == null) {
                return null;
            } else if (cpf.isEmpty()) {
                // SE DER <ENTER> JOGA MENSAGEM DE ERRO e VOLTA AO LOOP.
                JOptionPane.showMessageDialog(null, "Por Favor, Digite Algo!",
                        "Msg do Servidor", JOptionPane.INFORMATION_MESSAGE);
            } else {

                for (Cliente cpfCod1 : cpfCod) {
                    if (cpf.equals(cpfCod1.getCpf())) {
                        if (isIncluir) {
                            // ENQUANTO NAO ENCONTRA JOGA MENSAGEM DE ERRO e
                            // VOLTA AO LOOP.
                            JOptionPane.showMessageDialog(null,
                                    "Cliente Ja Cadastrado!!!",
                                    "Msg do Servidor",
                                    JOptionPane.INFORMATION_MESSAGE);
                            isCadastro = true;
                            break;
                        } else {
                            return cpf;
                        }
                    }
                    isCadastro = false;
                }

                if (!isIncluir) {
                    // ENQUANTO NAO ENCONTRA JOGA MENSAGEM DE ERRO e VOLTA AO
                    // LOOP.
                    JOptionPane.showMessageDialog(null,
                            "Cliente nao encontrado!!!", "Msg do Servidor",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (!isCadastro) {
                        return cpf;
                    }
                }
            }

        }
        return cpf;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuProdutos;
    private javax.swing.JRadioButtonMenuItem jRadioConectar;
    private javax.swing.JRadioButtonMenuItem jRadioDesconectar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JMenuItem mnuAlterarCliente;
    private javax.swing.JMenuItem mnuAlterarProduto;
    private javax.swing.JMenuItem mnuArmazenar;
    private javax.swing.JMenuItem mnuAtualizarCliente;
    private javax.swing.JMenuItem mnuAtualizarProduto;
    private javax.swing.JMenuItem mnuExcluirCliente;
    private javax.swing.JMenuItem mnuExcluirProduto;
    private javax.swing.JMenuItem mnuIncluirCliente;
    private javax.swing.JMenuItem mnuIncluirProduto;
    private javax.swing.JMenuItem mnuRecuperar;
    private javax.swing.JMenuItem mnuSair;
    // End of variables declaration//GEN-END:variables
}
