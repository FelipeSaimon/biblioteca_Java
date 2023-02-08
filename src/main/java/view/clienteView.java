package view;

import controller.clienteController;
//import model.clienteView;
import java.awt.Color;
import java.awt.Font;
import static java.awt.SystemColor.desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import util.TableModelCliente;
import util.ConnectionFactory;
import model.cliente;

/**
 *
 * @author Saimon
 */
public class clienteView extends javax.swing.JInternalFrame {

    TableModelCliente clientesModel;
    clienteController clienteControl;
    ConnectionFactory connect;

    /**
     * Creates new form cliente
     */
    public clienteView() {
        initComponents();
        initDataController();
        initComponentsModel();
        decorateTablecliente();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        addCliente = new JLabel();
        deleteCliente = new JLabel();
        JPanel jPanel3 = new JPanel();
        PanelClientes = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        tableClientes = new JTable();
        JPanel formClientes = new JPanel();
        JLabel jLabel3 = new JLabel();
        getPesqNome = new JTextField();
        JSeparator jSeparator1 = new JSeparator();
        jLabel4 = new JLabel();
        getNomeCliente = new JTextField();
        JLabel jLabel5 = new JLabel();
        getTelefoneCliente = new JTextField();
        JLabel jLabel6 = new JLabel();
        getEmailCliente = new JTextField();
        JLabel jLabel7 = new JLabel();
        getCPFCliente = new JTextField();
        JLabel jLabel8 = new JLabel();
        getEnderecoCliente = new JTextField();
        JLabel jLabel10 = new JLabel();
        idClienteField = new JTextField();
        consultar = new JButton();
        JButton closed = new JButton();

        setBackground(new Color(204, 204, 204));
        setBorder(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(true);
        setVisible(true);

        jPanel1.setBackground(new Color(0, 102, 102));

        jLabel1.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Clientes");

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/Search_1.png"))); // NOI18N
        jLabel2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        addCliente.setIcon(new ImageIcon(getClass().getResource("/add user1.png"))); // NOI18N
        addCliente.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addClienteMouseClicked(evt);
            }
        });

        deleteCliente.setIcon(new ImageIcon(getClass().getResource("/delete-user-icon-1.png"))); // NOI18N
        deleteCliente.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                deleteClienteMouseClicked(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addComponent(addCliente)
                .addGap(45, 45, 45)
                .addComponent(deleteCliente)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(deleteCliente)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new Color(204, 204, 204));

        PanelClientes.setBackground(new Color(255, 255, 255));
        PanelClientes.setBorder(BorderFactory.createEtchedBorder());

        tableClientes.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "CPF", "Telefone", "Email", "Endereço", "Excluir"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, String.class, String.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableClientes.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tableClientes);

        GroupLayout PanelClientesLayout = new GroupLayout(PanelClientes);
        PanelClientes.setLayout(PanelClientesLayout);
        PanelClientesLayout.setHorizontalGroup(PanelClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING)
        );
        PanelClientesLayout.setVerticalGroup(PanelClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        formClientes.setBackground(new Color(255, 255, 255));
        formClientes.setBorder(BorderFactory.createEtchedBorder());

        jLabel3.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Buscando pelo nome:");

        getPesqNome.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                getPesqNomeKeyReleased(evt);
            }
        });

        jSeparator1.setForeground(new Color(102, 102, 102));

        jLabel4.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Cliente:");

        jLabel5.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Telefone:");

        jLabel6.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("E-mail:");

        jLabel7.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("CPF:");

        jLabel8.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Endereço:");

        jLabel10.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("idCliente:");

        consultar.setText("Consultar");
        consultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });

        closed.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        closed.setText("Sair");
        closed.setActionCommand("");
        closed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closedActionPerformed(evt);
            }
        });

        GroupLayout formClientesLayout = new GroupLayout(formClientes);
        formClientes.setLayout(formClientesLayout);
        formClientesLayout.setHorizontalGroup(formClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(formClientesLayout.createSequentialGroup()
                .addGroup(formClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(formClientesLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(formClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(formClientesLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(getEnderecoCliente, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(getCPFCliente, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                            .addGroup(formClientesLayout.createSequentialGroup()
                                .addGroup(formClientesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel5))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(formClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(formClientesLayout.createSequentialGroup()
                                        .addComponent(getTelefoneCliente, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(getEmailCliente, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formClientesLayout.createSequentialGroup()
                                        .addComponent(idClienteField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(consultar, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(getNomeCliente, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(formClientesLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(formClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE)
                            .addGroup(formClientesLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(getPesqNome, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(closed)
                                .addGap(14, 14, 14)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        formClientesLayout.setVerticalGroup(formClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(formClientesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(formClientesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(getPesqNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(closed))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formClientesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(getNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(idClienteField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultar))
                .addGap(18, 18, 18)
                .addGroup(formClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(formClientesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(getTelefoneCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(getEmailCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(formClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(formClientesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(getCPFCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(getEnderecoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(formClientes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelClientes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(formClientes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelClientes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 634, 471);
    }// </editor-fold>//GEN-END:initComponents

    private void addClienteMouseClicked(MouseEvent evt) {//GEN-FIRST:event_addClienteMouseClicked
        // TODO add your handling code here:
        try {
            cliente cliente = new cliente();

            cliente.setNomeCliente(getNomeCliente.getText());
            cliente.setCpf(getCPFCliente.getText());
            cliente.setTelefone(getTelefoneCliente.getText());
            cliente.setEmail(getEmailCliente.getText());
            cliente.setEndereco(getEnderecoCliente.getText());

            clienteControl.save(cliente);
            JOptionPane.showMessageDialog(rootPane, "cliente salvo com sucesso");
            getNomeCliente.setText(null);
            getEmailCliente.setText(null);
            getCPFCliente.setText(null);
            getTelefoneCliente.setText(null);
            getEnderecoCliente.setText(null);

            loadclientes();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao adicionar um cliente");
        }
    }//GEN-LAST:event_addClienteMouseClicked

    private void PesquisaClientes() {
        String sql = "SELECT * FROM cliente WHERE nomeCliente like ?";
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;

        try {
            connect = ConnectionFactory.getConnection();
            statement = connect.prepareStatement(sql);

            // a porcentagem indica continuação da string
            statement.setString(1, getPesqNome.getText() + "%");
            resultado = statement.executeQuery();

            tableClientes.setModel(DbUtils.resultSetToTableModel(resultado));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    // consulta dados por id
    private void consultar() {
        String sql = "SELECT * FROM cliente WHERE idCliente = ?";

        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;

        try {
            connect = ConnectionFactory.getConnection();
            statement = connect.prepareStatement(sql);
            statement.setString(1, idClienteField.getText());
            resultado = statement.executeQuery();
            if (resultado.next()) {
                getNomeCliente.setText(resultado.getString(2));
                getCPFCliente.setText(resultado.getString(3));
                getEmailCliente.setText(resultado.getString(4));
                getTelefoneCliente.setText(resultado.getString(5));
                getEnderecoCliente.setText(resultado.getString(6));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Cliente nao cadastrado");
                getNomeCliente.setText(null);
                getEmailCliente.setText(null);
                getCPFCliente.setText(null);
                getTelefoneCliente.setText(null);
                getEnderecoCliente.setText(null);

            }

//            tableClientes.setModel(DbUtils.resultSetToTableModel(resultado));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    
    
    public void updateClient() {
        String sql = "UPDATE clientes SET nomeCliente = ? , email = ?, telefone = ?, endereco = ?, cpf = ? WHERE idCliente = ?";

        Connection connect = null;
        PreparedStatement statement = null;

        try {
            connect = ConnectionFactory.getConnection();
            statement = connect.prepareStatement(sql);

            statement.setString(1, getNomeCliente.getText());
            statement.setString(2, getTelefoneCliente.getText());
            statement.setString(3, getEmailCliente.getText());
            statement.setString(4, getEnderecoCliente.getText());
            statement.setString(5, getCPFCliente.getText());
            statement.setString(6, idClienteField.getText());

            int add = statement.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(rootPane, "livro salvo com sucesso");
                getNomeCliente.setText(null);
                getTelefoneCliente.setText(null);
                getEmailCliente.setText(null);
                getEnderecoCliente.setText(null);
                getCPFCliente.setText(null);
            }

            connect.close();
            loadclientes();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,e);
        }

    }

    private void getPesqNomeKeyReleased(KeyEvent evt) {//GEN-FIRST:event_getPesqNomeKeyReleased
        // TODO add your handling code here:
        PesquisaClientes();
    }//GEN-LAST:event_getPesqNomeKeyReleased

    private void consultarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_consultarActionPerformed

    private void closedActionPerformed(ActionEvent evt) {//GEN-FIRST:event_closedActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closedActionPerformed

    private void deleteClienteMouseClicked(MouseEvent evt) {//GEN-FIRST:event_deleteClienteMouseClicked
        // TODO add your handling code here:
                clienteControl.remove(Integer.parseInt( idClienteField.getText()));

    }//GEN-LAST:event_deleteClienteMouseClicked

    private void jLabel2MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        updateClient();
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    JPanel PanelClientes;
    JLabel addCliente;
    JButton consultar;
    JLabel deleteCliente;
    JTextField getCPFCliente;
    JTextField getEmailCliente;
    JTextField getEnderecoCliente;
    JTextField getNomeCliente;
    JTextField getPesqNome;
    JTextField getTelefoneCliente;
    JTextField idClienteField;
    JLabel jLabel4;
    JTable tableClientes;
    // End of variables declaration//GEN-END:variables
    public void decorateTablecliente() {
        //Ao setar a fonte passa-se pelo menos 3 parametros ao metodo font()
        //Nome da fonte
        //Espessura (Normal, negrito, etc)
        //Tamanho da fonte
        tableClientes.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        //Setando a cor verde do projeto
        tableClientes.getTableHeader().setBackground(new Color(0, 102, 102));
        tableClientes.getTableHeader().setForeground(new Color(255, 255, 255));

        //Esse metodo permite a ordena��o da tabela pela coluna selecionada
        tableClientes.getAutoCreateRowSorter();

        //Dentro da tableClientes, pega o model dela, pegando a sua coluna 2 (nesse caso)
        //
//        tableClientes.getColumnModel().getColumn(3).setCellRenderer(new ButtonColumnCellRender("editar"));
//        tableClientes.getColumnModel().getColumn(6).setCellRenderer(new ButtonColumnCellRender("excluir"));
    }

    public void initDataController() {
        clienteControl = new clienteController();
//        livroControll = new livroController();
//        projectController = new ProjectController();
    }

    //Gerencia a parte visual do jList
    public void initComponentsModel() {
        clientesModel = new TableModelCliente();
        tableClientes.setModel(clientesModel);

//        Verificaçao para o que será apresentado na tela criada quando for criada
//        if (!clientesModel.isEmpty()) {
//            loadclientes();
//        }
    }

    public void loadclientes() {
        List<model.cliente> clientes = clienteControl.getAll();

        clientesModel.setclientes(clientes);
//
//        model.cliente.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosed(WindowEvent e) {
//                loadclientes();
//            }
//        });
    }
}
