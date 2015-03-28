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

    protected ControleCliente cCliente = 
              new ControleCliente();
    
    protected ControleProduto pProduto = 
              new ControleProduto();

    protected ArrayList<Cliente> obterTodos(){
        return cCliente.obterTodos(); 
    }
    
    protected ArrayList<Produto> obterTodosProdutos(){
        return pProduto.obterTodosProduto(); 
    }

    protected TableModel getDadosTabela(){
        ArrayList<Cliente> lista = obterTodos();
        String [] titulos = 
               {"CPF","Nome","Endereco","Telefone"};
        Object[][] valores = new Object[lista.size()][4];
        for(int i = 0; i < lista.size(); i++){
            valores[i][0] = lista.get(i).getCpf();
            valores[i][1] = lista.get(i).getNome();
            valores[i][2] = lista.get(i).getEndereco();
            valores[i][3] = lista.get(i).getTelefone();
        }
        return new DefaultTableModel(valores,titulos);
    }

    protected TableModel getDadosTabelaCPF(){
        ArrayList<Cliente> lista = obterTodos();
        String [] titulos = {"COD"};
        Object[] [] valores = new Object[lista.size()][1];
        for(int i = 0; i < lista.size(); i++){
            valores[i][0]= lista.get(i).getCpf();
        }
        return new DefaultTableModel(valores,titulos);
    }

    protected TableModel getDadosTabelaProduto  (){
        ArrayList<Produto> lista = obterTodosProdutos();
        String [] titulos = 
               {"COD","Nome","Quantidade","Valor"};
        Object[][] valores = new Object[lista.size()][4];
        for(int i = 0; i < lista.size(); i++){
            valores[i][0] = lista.get(i).getCOD();
            valores[i][1] = lista.get(i).getNome();
            valores[i][2] = lista.get(i).getQuantidade();
            valores[i][3] = lista.get(i).getValor();
        }
        return new DefaultTableModel(valores,titulos);
    }

    private void atualizarTabela(){
        jTableCliente.setModel(getDadosTabela());
    }
    
    private void atualizarTabelaProduto(){
        jTableProduto.setModel(getDadosTabelaProduto());
    }
    
    protected void persistir(Cliente c){
        JDDadosCliente dados = new JDDadosCliente(this, true);
        dados.setDados(c);
        dados.setVisible(true);
        // Modal -> Fica parado aqui até a janela "sumir"
        if(dados.sucesso)
            cCliente.persistir(dados.getDados());
    }
    
    protected void persistirProduto(Produto p, String cod){
        JDDadosProduto dados = new JDDadosProduto(this, true);
        dados.setDados(p, cod);
        dados.setVisible(true);
        // Modal -> Fica parado aqui até a janela "sumir"
        if(dados.sucesso)
            pProduto.persistirProduto(dados.getDados());
    }

    protected void remover(String cpf){
        cCliente.remover(cpf);
    }
    
    protected void removerProduto(String cpf){
        pProduto.removerProduto(cpf);
    }

    protected Cliente obter(String cpf){
        return cCliente.obter(cpf);
    }
    
    protected Produto obterProduto(String cpf){
        return pProduto.obterProduto(cpf);
    }

    protected void preActions(){
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

        jTableCliente.setModel(getDadosTabela());
        jScrollPane1.setViewportView(jTableCliente);

        jTableProduto.setModel(getDadosTabelaProduto());
        jScrollPane2.setViewportView(jTableProduto);

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
        mnuArmazenarCliente.setEnabled(false);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAtualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAtualizarClienteActionPerformed
        atualizarTabela();
    }//GEN-LAST:event_mnuAtualizarClienteActionPerformed

    private void mnuIncluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIncluirClienteActionPerformed
        persistir(null);
        atualizarTabela();
    }//GEN-LAST:event_mnuIncluirClienteActionPerformed

    private void mnuAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlterarClienteActionPerformed
        String cpf = JOptionPane.showInputDialog("CPF","");
        persistir(obter(cpf));
        atualizarTabela();
    }//GEN-LAST:event_mnuAlterarClienteActionPerformed

    private void mnuExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExcluirClienteActionPerformed
        String cpf = JOptionPane.showInputDialog("CPF","");
        remover(cpf);
        atualizarTabela();
    }//GEN-LAST:event_mnuExcluirClienteActionPerformed

    private void mnuArmazenarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArmazenarClienteActionPerformed
           
        atualizarTabela();
        try {
            ControleCliente.armazenarDados();
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuArmazenarClienteActionPerformed

    private void mnuRecuperarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRecuperarClienteActionPerformed
        
        try {
            ControleCliente.carregarDados();
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
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
        String cod = JOptionPane.showInputDialog("COD","");
        
//        JFCodigoCliente codigo = new JFCodigoCliente(this, true);
//        codigo.setVisible(true);
        // Modal -> Fica parado aqui até a janela "sumir"
        persistirProduto(null, ""+cod);
        atualizarTabelaProduto();
    }//GEN-LAST:event_mnuIncluirProdutoActionPerformed

    private void mnuAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAlterarProdutoActionPerformed
        // TODO add your handling code here:
        String cod = JOptionPane.showInputDialog("COD","");
        persistirProduto(obterProduto(cod), cod);
        atualizarTabelaProduto();
    }//GEN-LAST:event_mnuAlterarProdutoActionPerformed

    private void mnuExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExcluirProdutoActionPerformed
        // TODO add your handling code here:
        String cod = JOptionPane.showInputDialog("COD","");
        removerProduto(cod);
        atualizarTabelaProduto();
    }//GEN-LAST:event_mnuExcluirProdutoActionPerformed

    private void mnuAtualizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAtualizarProdutoActionPerformed
        // TODO add your handling code here:
        atualizarTabelaProduto();
    }//GEN-LAST:event_mnuAtualizarProdutoActionPerformed

    private void mnuArmazenarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArmazenarProdutosActionPerformed
        // TODO add your handling code here:
        atualizarTabela();
        try {
            ControleProduto.armazenarDadosProduto();
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        atualizarTabela();
    }//GEN-LAST:event_mnuArmazenarProdutosActionPerformed

    private void mnuRecuperarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRecuperarProdutosActionPerformed
        // TODO add your handling code here:
        try {
            ControleProduto.carregarDadosProduto();
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        atualizarTabela();
    }//GEN-LAST:event_mnuRecuperarProdutosActionPerformed

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
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
