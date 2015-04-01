/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controle.ControleBancoDados;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.BancoDados;

/**
 *
 * @author Grupo
 */
public class JFPrincipal extends javax.swing.JFrame {

    protected ControleBancoDados cCliente
            = new ControleBancoDados();

    protected ArrayList<BancoDados> obterTodos() {
        return cCliente.obterTodos();
    }

    //protected ArrayList<BancoDados> obterTodosP() {
    //    return cCliente.obterTodosP();
    //}

    protected TableModel getDadosTabela() {
//        int contador = 0;
        ArrayList<BancoDados> lista = obterTodos();
        String[] titulos
                = {"CPF", "Tipo", "Nome", "Endereco", "Telefone"};
    
        Object[][] valores = new Object[lista.size()][5];
        for (int i = 0; i < lista.size(); i++) {
            valores[i][0] = lista.get(i).getCpf();
            valores[i][1] = lista.get(i).getTipo();
            valores[i][2] = lista.get(i).getNome();
            valores[i][3] = lista.get(i).getEnder_Quant();
            valores[i][4] = lista.get(i).getTelef_Valor();
//            if ("C".equals(lista.get(i).getTipo())) {
//                contador++;
//            }
        }

/*        Object[][] valores = new Object[contador][5];
        int contador2 = 0;
        for (BancoDados lista1 : lista) {
            if ("C".equals(lista1.getTipo())) {
                valores[contador2][0] = lista1.getCpf();
                valores[contador2][1] = lista1.getTipo();
                valores[contador2][2] = lista1.getNome();
                valores[contador2][3] = lista1.getEnder_Quant();
                valores[contador2][4] = lista1.getTelef_Valor();
            }
        }
  */
        return new DefaultTableModel(valores, titulos);
    }

    protected TableModel getDadosTabelaCPF() {
        ArrayList<BancoDados> lista = obterTodos();
        String[] titulos = {"CPF"};
        Object[][] valores = new Object[lista.size()][1];
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getTipo() == "C") {
                valores[i][0] = lista.get(i).getCpf();
            }
        }
        return new DefaultTableModel(valores, titulos);
    }

    protected TableModel getDadosTabelaProduto() {
//        int contador = 0;
        ArrayList<BancoDados> lista = obterTodos();
        String[] titulos
                = {"CPF", "Tipo", "Nome", "Quant", "Valor"};
        Object[][] valores = new Object[lista.size()][5];
        for (int i = 0; i < lista.size(); i++) {
//            if (lista.get(i).getTipo() == "P") 
            {
                valores[i][0] = lista.get(i).getCpf();
                valores[i][1] = lista.get(i).getTipo();
                valores[i][2] = lista.get(i).getNome();
                valores[i][3] = lista.get(i).getEnder_Quant();
                valores[i][4] = lista.get(i).getTelef_Valor();
//                contador++;
            }
        }
        return new DefaultTableModel(valores, titulos);
    }

    private void atualizarTabela() {
        jTableCliente.setModel(getDadosTabela());
    }

//    private void atualizarTabelaProduto() {
//        jTableProduto.setModel(getDadosTabelaProduto());
//    }
    protected void persistir(BancoDados c, String cpf, String tipo) {
        JDDados dados = new JDDados(this, true);
        dados.setDados(c, cpf, tipo);
        dados.setVisible(true);
        // Modal -> Fica parado aqui até a janela "sumir"
        if (dados.sucesso) {
            cCliente.persistir(dados.getDados());
        }
    }

    /*    protected void persistirProduto(Produto p, String cod) {
     JDDadosProduto dados = new JDDadosProduto(this, true);
     dados.setDados(p, cod);
     dados.setVisible(true);
     // Modal -> Fica parado aqui até a janela "sumir"
     if (dados.sucesso) {
     pProduto.persistirProduto(dados.getDados());
     }
     }
     */
    protected void remover(String cpf) {
        cCliente.remover(cpf);
    }

//    protected void removerProduto(String cpf) {
//        pProduto.removerProduto(cpf);
//    }
    protected BancoDados obter(String cpf) {
        return cCliente.obter(cpf);
    }

    protected String obterTipo(String cpf) {
        return cCliente.obter(cpf).getTipo();
    }
//    protected Produto obterProduto(String cpf) {
//        return pProduto.obterProduto(cpf);
//    }

    protected void preActions() {
//     cpf = ""; // recebera codigo digitado

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btmSair = new javax.swing.JButton();
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
        mnuArmazenarCliente = new javax.swing.JMenuItem();
        mnuRecuperarCliente = new javax.swing.JMenuItem();
        mnuArmazenarProdutos = new javax.swing.JMenuItem();
        mnuRecuperarProdutos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pandera Studios Cliente");

        jTableCliente.setModel(getDadosTabela());
        jScrollPane1.setViewportView(jTableCliente);

        jTableProduto.setModel(getDadosTabelaProduto());
        jScrollPane2.setViewportView(jTableProduto);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CLIENTES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("PRODUTOS");

        btmSair.setText("SAIR");
        btmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmSairActionPerformed(evt);
            }
        });

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

        jMenu2.setText("Outros");

        mnuArmazenarCliente.setText("Armazenar Dados Clientes");
        mnuArmazenarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArmazenarClienteActionPerformed(evt);
            }
        });
        jMenu2.add(mnuArmazenarCliente);

        mnuRecuperarCliente.setText("Recuperar Dados Clientes");
        mnuRecuperarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRecuperarClienteActionPerformed(evt);
            }
        });
        jMenu2.add(mnuRecuperarCliente);

        mnuArmazenarProdutos.setText("Armazenar Dados Produtos");
        mnuArmazenarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArmazenarProdutosActionPerformed(evt);
            }
        });
        jMenu2.add(mnuArmazenarProdutos);

        mnuRecuperarProdutos.setText("Recuperar Dados Produtos");
        mnuRecuperarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRecuperarProdutosActionPerformed(evt);
            }
        });
        jMenu2.add(mnuRecuperarProdutos);
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
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btmSair)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btmSair)
                .addContainerGap(23, Short.MAX_VALUE))
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
                persistir(null, cpf, "C");
                atualizarTabela();
            }
        }
    }//GEN-LAST:event_mnuIncluirClienteActionPerformed

    private void mnuAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlterarClienteActionPerformed
        String cpf = entraCPF(false); // recebera codigo digitado
        if (cpf != null) {
            if (!cpf.isEmpty()) {
                if ("C".equals(obterTipo(cpf))) {
                    persistir(obter(cpf), cpf, "C");
                    atualizarTabela();
                }
            }
        }
    }//GEN-LAST:event_mnuAlterarClienteActionPerformed

    private void mnuExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExcluirClienteActionPerformed
        String cpf = entraCPF(false); // recebera codigo digitado
        if (cpf != null) {
            if (!cpf.isEmpty()) {
                if ("C".equals(obterTipo(cpf))) {
                    remover(cpf);
                    atualizarTabela();
                }
            }
        }
    }//GEN-LAST:event_mnuExcluirClienteActionPerformed

    private void mnuArmazenarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArmazenarClienteActionPerformed

        atualizarTabela();
        try {
            ControleBancoDados.armazenarDados();
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuArmazenarClienteActionPerformed

    private void mnuRecuperarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRecuperarClienteActionPerformed

        try {
            ControleBancoDados.carregarDados();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        atualizarTabela(); // estava faltando isso para recuperar a tabela.
    }//GEN-LAST:event_mnuRecuperarClienteActionPerformed

    private void mnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSairActionPerformed
        // TODO add your handling code here:

        jTableCliente.removeAll();
        jTableProduto.removeAll();
        System.exit(0);

    }//GEN-LAST:event_mnuSairActionPerformed

    private void mnuIncluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIncluirProdutoActionPerformed
        // TODO add your handling code here:

        String cpf = entraCPF(false); // recebera codigo digitado
        if (cpf != null) {
            if (!cpf.isEmpty()) {
                persistir(null, cpf, "P");
                atualizarTabela();
            }
        }
    }//GEN-LAST:event_mnuIncluirProdutoActionPerformed

    private void mnuAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlterarProdutoActionPerformed
        // TODO add your handling code here:
        String cpf = entraCPF(false); // recebera codigo digitado
        if (cpf != null) {
            if (!cpf.isEmpty()) {
                if ("P".equals(obterTipo(cpf))) {
                    persistir(obter(cpf), cpf, "P");
                    atualizarTabela();
                }
            }
        }
    }//GEN-LAST:event_mnuAlterarProdutoActionPerformed

    //        

    private void mnuExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExcluirProdutoActionPerformed
        // TODO add your handling code here:
        String cpf = entraCPF(false); // recebera codigo digitado
        if (cpf != null) {
            if (!cpf.isEmpty()) {
                if ("P".equals(obterTipo(cpf))) {
                    remover(cpf);
                    atualizarTabela();
                }
            }
        }
    }//GEN-LAST:event_mnuExcluirProdutoActionPerformed

    private void mnuAtualizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAtualizarProdutoActionPerformed
        // TODO add your handling code here:
        atualizarTabela();
    }//GEN-LAST:event_mnuAtualizarProdutoActionPerformed

    private void mnuArmazenarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArmazenarProdutosActionPerformed
        // TODO add your handling code here:

        atualizarTabela();
        try {
            ControleBancoDados.armazenarDados();
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuArmazenarProdutosActionPerformed

    private void mnuRecuperarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRecuperarProdutosActionPerformed
        // TODO add your handling code here:
        try {
            ControleBancoDados.carregarDados();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        atualizarTabela();
    }//GEN-LAST:event_mnuRecuperarProdutosActionPerformed

    private void btmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmSairActionPerformed
        // TODO add your handling code here:
        jTableCliente.removeAll();
        jTableProduto.removeAll();
        System.exit(0);

    }//GEN-LAST:event_btmSairActionPerformed

    private String entraCPF(boolean isIncluir) {
        // TODO add your handling code here:
        String cpf = "";
        boolean isCadastro = false;
        
        ArrayList<BancoDados> cpfCod = (obterTodos());

        // loop enquanto teclar vazio ou not fim 
        while (cpf.isEmpty() || true) {
            // janela de input do CPF
            cpf = JOptionPane.showInputDialog(this, "CPF");
            if (cpf == null) {
                return null;
            } else if (cpf.isEmpty()) {
                // SE DER <ENTER> JOGA MENSAGEM DE ERRO e VOLTA AO LOOP.
                JOptionPane.showMessageDialog(null, "Por Favor, Digite Algo!", "Msg do Servidor",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                
                for (BancoDados cpfCod1 : cpfCod) {
                    if (cpf.equals(cpfCod1.getCpf())) {
                        if (isIncluir) {
                            // ENQUANTO NAO ENCONTRA JOGA MENSAGEM DE ERRO e VOLTA AO LOOP.
                            JOptionPane.showMessageDialog(null, "Cliente Ja Cadastrado!!!", "Msg do Servidor",
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
                    // ENQUANTO NAO ENCONTRA JOGA MENSAGEM DE ERRO e VOLTA AO LOOP.
                    JOptionPane.showMessageDialog(null, "Cliente nao encontrado!!!", "Msg do Servidor",
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
       
        //</editor-fold>

        /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipal().setVisible(true);
            }
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JMenuItem mnuAlterarCliente;
    private javax.swing.JMenuItem mnuAlterarProduto;
    private javax.swing.JMenuItem mnuArmazenarCliente;
    private javax.swing.JMenuItem mnuArmazenarProdutos;
    private javax.swing.JMenuItem mnuAtualizarCliente;
    private javax.swing.JMenuItem mnuAtualizarProduto;
    private javax.swing.JMenuItem mnuExcluirCliente;
    private javax.swing.JMenuItem mnuExcluirProduto;
    private javax.swing.JMenuItem mnuIncluirCliente;
    private javax.swing.JMenuItem mnuIncluirProduto;
    private javax.swing.JMenuItem mnuRecuperarCliente;
    private javax.swing.JMenuItem mnuRecuperarProdutos;
    private javax.swing.JMenuItem mnuSair;
    // End of variables declaration//GEN-END:variables
}
