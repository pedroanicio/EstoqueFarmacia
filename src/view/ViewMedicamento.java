/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.EstoqueDAO;
import dao.FornecedorDAO;
import dao.MedicamentoDAO;
import entity.Estoque;
import entity.Fornecedor;
import entity.Medicamento;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ViewMedicamento extends javax.swing.JFrame {

    /**
     * Creates new form ViewMedicamento
     */
    
    public void Listar(){
        try{
            MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
            List<Medicamento> medicamento = medicamentoDAO.listarMedicamentos();
            
            
            DefaultTableModel model = (DefaultTableModel)tabela.getModel();
            model.setNumRows(0);
            
            for(Medicamento m : medicamento){
                model.addRow(new Object[]{
                    m.getIdMedicamento(),
                    m.getNome(),
                    m.getDescricao(),
                    m.getValor(),
                    m.getQtde(),
                    m.getIdFornecedor(),
                    m.getIdEstoque()
                });
            }
        } catch (Exception e){
            e.getMessage();
        }
    }
    public ViewMedicamento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtValor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jtDesc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtQtde = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcFornecedor = new javax.swing.JComboBox();
        jcEstoque = new javax.swing.JComboBox();
        jbeditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jtID = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SimSun-ExtB", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Adicionar medicamento");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SimSun-ExtB", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Nome:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));
        jPanel1.add(jtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 72, 158, 30));

        jLabel3.setFont(new java.awt.Font("SimSun-ExtB", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Valor:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 60, -1));
        jPanel1.add(jtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 380, -1));
        jPanel1.add(jtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 380, 30));

        jLabel4.setFont(new java.awt.Font("SimSun-ExtB", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Descricao:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("SimSun-ExtB", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Quantidade:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));
        jPanel1.add(jtQtde, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 72, 110, 30));

        jLabel6.setFont(new java.awt.Font("SimSun-ExtB", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Fornecedor:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jcFornecedor.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jcFornecedorAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(jcFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 160, -1));

        jcEstoque.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jcEstoqueAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel1.add(jcEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 110, -1));

        jbeditar.setBackground(new java.awt.Color(255, 102, 102));
        jbeditar.setForeground(new java.awt.Color(255, 255, 255));
        jbeditar.setText("Editar");
        jbeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbeditarActionPerformed(evt);
            }
        });
        jPanel1.add(jbeditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 81, 40));

        jbExcluir.setBackground(new java.awt.Color(255, 102, 102));
        jbExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(jbExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 81, -1));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Descricao", "Valor", "Quantidade", "Fornecedor", "Estoque"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 594, 179));

        jLabel9.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        jLabel9.setText("ID:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        jtID.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        jtID.setText("autoIncrement");
        jPanel1.add(jtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("SimSun-ExtB", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Estoque:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, -1, -1));

        jLabel7.setFont(new java.awt.Font("SimSun-ExtB", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Medicamento - Fornecedor");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 111, 640, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jtNome.getText().isEmpty() |jtDesc.getText().isEmpty() | jtValor.getText().isEmpty() | jtQtde.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Insira todos os dados");
        }else{
            String nome = jtNome.getText();
            String descricao = jtDesc.getText();
            float valor = Float.parseFloat(jtValor.getText());
            int qtde = Integer.parseInt(jtQtde.getText());
            
            Medicamento medicamento = new Medicamento();
            Fornecedor forn = new Fornecedor();
            Estoque estoque = new Estoque();
            medicamento.setNome(nome);
            medicamento.setDescricao(descricao);
            medicamento.setValor(valor);
            medicamento.setQtde(qtde);
            
            // combo box
            forn = (Fornecedor)jcFornecedor.getSelectedItem();
            estoque = (Estoque)jcEstoque.getSelectedItem();
            
            medicamento.setIdFornecedor(forn);
            medicamento.setIdEstoque(estoque);
        
            MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
            medicamentoDAO.inserir(medicamento);
        
            jtNome.setText("");
            jtDesc.setText("");
            jtValor.setText("");
            jtQtde.setText("");
            jtID.setText("null");
            jcFornecedor.setSelectedIndex(0);
            jcEstoque.setSelectedIndex(0);
        }

        Listar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcFornecedorAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jcFornecedorAncestorAdded
        // TODO add your handling code here:
        
        FornecedorDAO dao = new FornecedorDAO();
        List<Fornecedor> lista = dao.listarFornecedores();
        
        jcFornecedor.removeAllItems();
        
        for(Fornecedor f : lista){
            jcFornecedor.addItem(f);
        }
    }//GEN-LAST:event_jcFornecedorAncestorAdded

    private void jcEstoqueAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jcEstoqueAncestorAdded
        // TODO add your handling code here:
        EstoqueDAO dao = new EstoqueDAO();
        List<Estoque> lista = dao.listarEstoques();
        
        jcEstoque.removeAllItems();
        
        for(Estoque e : lista){
            jcEstoque.addItem(e);
        }
    }//GEN-LAST:event_jcEstoqueAncestorAdded

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Listar();
    }//GEN-LAST:event_formWindowOpened

    private void jbeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbeditarActionPerformed

            
        String nome = jtNome.getText();
        String descricao = jtDesc.getText();
        float valor = Float.parseFloat(jtValor.getText());
        int qtde = Integer.parseInt(jtQtde.getText());
        int id = Integer.parseInt(jtID.getText());

        try{
            Medicamento medicamento = new Medicamento();
            Fornecedor forn = new Fornecedor();
            Estoque estoque = new Estoque();
            forn = (Fornecedor)jcFornecedor.getSelectedItem();
            estoque = (Estoque)jcEstoque.getSelectedItem();
            
            medicamento.setNome(nome);
            medicamento.setDescricao(descricao);
            medicamento.setValor(valor);
            medicamento.setQtde(qtde);
            medicamento.setIdFornecedor(forn);
            medicamento.setIdEstoque(estoque);
            medicamento.setIdMedicamento(id);

            MedicamentoDAO dao = new MedicamentoDAO();
            dao.editar(medicamento);
            
            
            JOptionPane.showMessageDialog(null, "Dados editados com sucesso.");
            
            Listar();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao editar os dados."+ e);
        }
        
        
    }//GEN-LAST:event_jbeditarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try {
            Medicamento medicamento = new Medicamento();
            
            medicamento.setIdMedicamento(Integer.parseInt(jtID.getText()));
                        
            MedicamentoDAO dao = new MedicamentoDAO();
            dao.excluir(medicamento);
            
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso.");
            Listar();
            
            
            jtNome.setText("");
            jtDesc.setText("");
            jtValor.setText("");
            jtQtde.setText("");
            jtID.setText("null");
            jcFornecedor.setSelectedIndex(0);
            jcEstoque.setSelectedIndex(0);
            jtID.setText("null");
            
            
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Erro ao excluir os dados.");
        }
        
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        jtID.setText(tabela.getValueAt(tabela.getSelectedRow(), 0).toString());
        jtNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
        jtDesc.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
        jtValor.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
        jtQtde.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());

    }//GEN-LAST:event_tabelaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        menuPrincipal obj = new menuPrincipal();
        obj.setLocationRelativeTo(obj);
        obj.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        viewMedFornecedor obj = new viewMedFornecedor();
        obj.setLocationRelativeTo(obj);
        obj.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 ViewMedicamento obj = new ViewMedicamento();
                obj.setLocationRelativeTo(obj);
                obj.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbeditar;
    private javax.swing.JComboBox jcEstoque;
    private javax.swing.JComboBox jcFornecedor;
    private javax.swing.JTextField jtDesc;
    private javax.swing.JLabel jtID;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtQtde;
    private javax.swing.JTextField jtValor;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
