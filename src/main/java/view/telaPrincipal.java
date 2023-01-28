/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.clienteController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import model.cliente;
import util.ButtonColumnCellRender;
import util.TableModelCliente;

/**
 *
 * @author Saimon
 */
public final class telaPrincipal extends javax.swing.JFrame {
    TableModelCliente clientesModel;
    clienteController clienteControl;
    /**
     * Creates new form telaPrincipal
     */
    public telaPrincipal() {
        initComponents();
        initDataController();
        initComponentsModel();
        decorateTablecliente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelClientes = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        tableClientes = new JTable();
        JPanel jPanel1 = new JPanel();
        JLabel systemTitle = new JLabel();
        JLabel jLabel2 = new JLabel();
        JPanel jPanel2 = new JPanel();
        registerClient = new JLabel();
        registerLivro = new JLabel();
        JLabel jLabel1 = new JLabel();
        visualizaClientes = new JLabel();
        PanelPrincipal = new JPanel();
        PanelVazio = new JPanel();
        jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();

        PanelClientes.setBackground(new Color(255, 255, 255));
        PanelClientes.setBorder(BorderFactory.createEtchedBorder());

        tableClientes.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome do cliente", "Email", "Telefone", "Editar", "Excluir"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, String.class, Boolean.class, Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableClientes);

        GroupLayout PanelClientesLayout = new GroupLayout(PanelClientes);
        PanelClientes.setLayout(PanelClientesLayout);
        PanelClientesLayout.setHorizontalGroup(PanelClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, PanelClientesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE))
        );
        PanelClientesLayout.setVerticalGroup(PanelClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, PanelClientesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(0, 102, 102));

        systemTitle.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        systemTitle.setForeground(new Color(255, 255, 255));
        systemTitle.setText("Controle de atendimento");

        jLabel2.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("Sistema de gerenciamento da biblioteca");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(systemTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(395, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(systemTitle)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel2.setBorder(BorderFactory.createEtchedBorder());

        registerClient.setIcon(new ImageIcon(getClass().getResource("/add user1.png"))); // NOI18N
        registerClient.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                registerClientMouseClicked(evt);
            }
        });

        registerLivro.setIcon(new ImageIcon(getClass().getResource("/add-book1.png"))); // NOI18N
        registerLivro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                registerLivroMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/borrowBook.png"))); // NOI18N
        jLabel1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        visualizaClientes.setIcon(new ImageIcon(getClass().getResource("/visualizar-min.png"))); // NOI18N
        visualizaClientes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                visualizaClientesMouseClicked(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(registerClient)
                    .addComponent(registerLivro)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(visualizaClientes)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(registerClient))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(visualizaClientes)))
                .addGap(20, 20, 20)
                .addComponent(registerLivro)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        PanelPrincipal.setBackground(new Color(255, 255, 255));
        PanelPrincipal.setBorder(BorderFactory.createEtchedBorder());

        PanelVazio.setBackground(new Color(255, 255, 255));
        PanelVazio.setLayout(new BorderLayout());

        jLabel3.setBackground(new Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setIcon(new ImageIcon(getClass().getResource("/fundo vazio.png"))); // NOI18N
        jLabel3.setToolTipText("");
        PanelVazio.add(jLabel3, BorderLayout.CENTER);

        jLabel4.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new Color(0, 102, 102));
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("BEM VINDO");
        PanelVazio.add(jLabel4, BorderLayout.PAGE_END);

        GroupLayout PanelPrincipalLayout = new GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(PanelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(PanelVazio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelPrincipalLayout.setVerticalGroup(PanelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(PanelVazio, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPrincipal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelPrincipal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerClientMouseClicked(MouseEvent evt) {//GEN-FIRST:event_registerClientMouseClicked
        // TODO add your handling code here:
        cadastroCliente cliente = new cadastroCliente(this, rootPaneCheckingEnabled);
        cliente.setVisible(true);
    }//GEN-LAST:event_registerClientMouseClicked

    private void registerLivroMouseClicked(MouseEvent evt) {//GEN-FIRST:event_registerLivroMouseClicked
        // TODO add your handling code here:
        cadastroLivro livro = new cadastroLivro(this, rootPaneCheckingEnabled);
        livro.setVisible(true);
    }//GEN-LAST:event_registerLivroMouseClicked

    private void jLabel1MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        emprestimoView emprestimo = new emprestimoView(this, rootPaneCheckingEnabled);
        emprestimo.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void visualizaClientesMouseClicked(MouseEvent evt) {//GEN-FIRST:event_visualizaClientesMouseClicked
        // TODO add your handling code here:
//        List<cliente> cliente = clienteControl.getAll();
//
//        
//        for (int i = 0; i < cliente.size(); i++) {
//            clientesModel = (TableModelCliente) (List<cliente>) cliente.get(i);
//        }
//        showtableClientes(!cliente.isEmpty());
        loadclientes();
    }//GEN-LAST:event_visualizaClientesMouseClicked

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
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    JPanel PanelClientes;
    JPanel PanelPrincipal;
    JPanel PanelVazio;
    JLabel jLabel3;
    JLabel registerClient;
    JLabel registerLivro;
    JTable tableClientes;
    JLabel visualizaClientes;
    // End of variables declaration//GEN-END:variables

        public void decorateTablecliente(){
        //Ao setar a fonte passa-se pelo menos 3 parametros ao metodo font()
        //Nome da fonte
        //Espessura (Normal, negrito, etc)
        //Tamanho da fonte
        tableClientes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        //Setando a cor verde do projeto
        tableClientes.getTableHeader().setBackground(new Color(0,153,102));
        tableClientes.getTableHeader().setForeground(new Color(255,255,255));
        
        
        //Esse metodo permite a ordena��o da tabela pela coluna selecionada
        tableClientes.getAutoCreateRowSorter();
        
        //Dentro da tableClientes, pega o model dela, pegando a sua coluna 2 (nesse caso)
        //
        
        tableClientes.getColumnModel().getColumn(3).setCellRenderer(new ButtonColumnCellRender("editar"));
        tableClientes.getColumnModel().getColumn(4).setCellRenderer(new ButtonColumnCellRender("excluir"));
        
    }
    
    public void initDataController(){
        clienteControl = new clienteController();
//        projectController = new ProjectController();
    }
    
    //Gerencia a parte visual do jList
    public void initComponentsModel(){
//        projectsModel = new DefaultListModel();
//        loadProjects();

        clientesModel = new TableModelCliente();
        tableClientes.setModel(clientesModel);
        
        //Verificaçao para o que será apresentado na tela criada quando for criada
        if(!clientesModel.isEmpty()){
            loadclientes();
        }
    }
    
    public void loadclientes(){
        List<cliente> clientes = clienteControl.getAll();
        clientesModel.setclientes(clientes);
        //verifica caso a clientes esteja vazia
        showTableClientes(!clientes.isEmpty());
    }
    
    //CONFIGURAÇÃO DE EXIBIÇÃO DA TABELA DE CLIENTE OU A VAZIA
    
    private void showTableClientes(boolean hasTasks){
        if(hasTasks){
            if(PanelVazio.isVisible()){
                PanelVazio.setVisible(false);
                PanelPrincipal.remove(PanelVazio);
            }
            PanelPrincipal.add(PanelClientes);
            PanelClientes.setVisible(true);
            PanelClientes.setSize(PanelPrincipal.getWidth(), PanelPrincipal.getHeight());
        }else{
            if(PanelClientes.isVisible()){
                PanelClientes.setVisible(false);
                PanelPrincipal.remove(PanelClientes);
            }
            PanelPrincipal.add(PanelVazio);
            PanelVazio.setVisible(true);
            PanelVazio.setSize(PanelPrincipal.getWidth(), PanelPrincipal.getHeight());
        }
    }
    
//    private void showtableClientes(boolean hasclientes){
//        if(hasclientes){
//            if(PanelPrincipal.isVisible()){
//                PanelPrincipal.setVisible(false);
//                PanelClientes.remove(PanelPrincipal);
//            }
//            PanelClientes.add(PanelClientes);
//            PanelClientes.setVisible(true);
//            PanelClientes.setSize(PanelClientes.getWidth(), PanelClientes.getHeight());
//        }else{
//            if(PanelClientes.isVisible()){
//                PanelClientes.setVisible(false);
//                PanelClientes.remove(PanelClientes);
//            }
//            PanelClientes.add(PanelPrincipal);
//            PanelPrincipal.setVisible(true);
//            PanelPrincipal.setSize(PanelClientes.getWidth(), PanelClientes.getHeight());
//        }
//    }
    

}
