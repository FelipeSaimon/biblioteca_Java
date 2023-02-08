package view;

import controller.clienteController;
import controller.livroController;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import model.livro;
import net.proteanit.sql.DbUtils;
import util.ConnectionFactory;
import util.tableModelLivros;

public class livrosView extends javax.swing.JInternalFrame {

    tableModelLivros livrosModel;
    livroController livroControl;
    ConnectionFactory connect;

    /**
     * Creates new form livrosView
     */
    public livrosView() {
        initComponents();
        initDataController();
        initComponentsModel();
        //decorateTableCliente();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel EditarLivro = new JLabel();
        addLivro = new JLabel();
        deleteLivro = new JLabel();
        JPanel jPanel3 = new JPanel();
        PanelClientes = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        tableLivros = new JTable();
        JPanel formLivros = new JPanel();
        JLabel jLabel3 = new JLabel();
        getPesqTitulo = new JTextField();
        JSeparator jSeparator1 = new JSeparator();
        jLabel4 = new JLabel();
        getTitulo = new JTextField();
        JLabel jLabel5 = new JLabel();
        getAutor = new JTextField();
        JLabel jLabel6 = new JLabel();
        getEditora = new JTextField();
        JLabel jLabel7 = new JLabel();
        getPaginas = new JTextField();
        JLabel jLabel8 = new JLabel();
        getAnoPublicacao = new JTextField();
        JLabel jLabel10 = new JLabel();
        idLivroField = new JTextField();
        consultar = new JButton();
        JButton closed = new JButton();
        cbDisponivel = new JComboBox<>();
        JLabel jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(true);
        setPreferredSize(new Dimension(634, 471));

        jPanel1.setBackground(new Color(0, 102, 102));

        jLabel1.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Livros");

        EditarLivro.setIcon(new ImageIcon(getClass().getResource("/Search_1.png"))); // NOI18N
        EditarLivro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        EditarLivro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                EditarLivroMouseClicked(evt);
            }
        });

        addLivro.setIcon(new ImageIcon(getClass().getResource("/add user1.png"))); // NOI18N
        addLivro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addLivro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addLivroMouseClicked(evt);
            }
        });

        deleteLivro.setIcon(new ImageIcon(getClass().getResource("/delete-user-icon-1.png"))); // NOI18N
        deleteLivro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteLivro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                deleteLivroMouseClicked(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(EditarLivro)
                .addGap(45, 45, 45)
                .addComponent(addLivro)
                .addGap(45, 45, 45)
                .addComponent(deleteLivro)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(deleteLivro)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(EditarLivro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addLivro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new Color(204, 204, 204));

        PanelClientes.setBackground(new Color(255, 255, 255));
        PanelClientes.setBorder(BorderFactory.createEtchedBorder());

        tableLivros.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Titulo", "Autor", "Paginas", "Editora", " Ano Publicação", "Excluir"
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
        tableLivros.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tableLivros);
        tableLivros.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        GroupLayout PanelClientesLayout = new GroupLayout(PanelClientes);
        PanelClientes.setLayout(PanelClientesLayout);
        PanelClientesLayout.setHorizontalGroup(PanelClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING)
        );
        PanelClientesLayout.setVerticalGroup(PanelClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
        );

        formLivros.setBackground(new Color(255, 255, 255));
        formLivros.setBorder(BorderFactory.createEtchedBorder());

        jLabel3.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Buscando pelo livro:");

        getPesqTitulo.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                getPesqTituloKeyReleased(evt);
            }
        });

        jSeparator1.setForeground(new Color(102, 102, 102));

        jLabel4.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Titulo:");

        jLabel5.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Autor:");

        jLabel6.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Editora:");

        jLabel7.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Numero de paginas:");

        jLabel8.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Ano de publicação:");

        jLabel10.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("idLivro:");

        consultar.setText("Consultar");
        consultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });

        closed.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        closed.setText("Sair");
        closed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                closedActionPerformed(evt);
            }
        });

        cbDisponivel.setModel(new DefaultComboBoxModel<>(new String[] { "Sim", "Não", " " }));

        jLabel2.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Disponivel:");

        GroupLayout formLivrosLayout = new GroupLayout(formLivros);
        formLivros.setLayout(formLivrosLayout);
        formLivrosLayout.setHorizontalGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, GroupLayout.Alignment.TRAILING)
            .addGroup(formLivrosLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(formLivrosLayout.createSequentialGroup()
                        .addGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(formLivrosLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(getAnoPublicacao, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
                            .addGroup(formLivrosLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idLivroField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(consultar, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getEditora, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
                    .addGroup(formLivrosLayout.createSequentialGroup()
                        .addGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(formLivrosLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(getAutor))
                            .addGroup(formLivrosLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(getTitulo, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbDisponivel, 0, 1, Short.MAX_VALUE)
                            .addComponent(getPaginas, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(formLivrosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(getPesqTitulo, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(closed)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        formLivrosLayout.setVerticalGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(formLivrosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(getPesqTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(closed))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(idLivroField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(getTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDisponivel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(getAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(getPaginas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(formLivrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(getAnoPublicacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(getEditora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(formLivros, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelClientes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(formLivros, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelClientes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addLivroMouseClicked(MouseEvent evt) {//GEN-FIRST:event_addLivroMouseClicked
        // TODO add your handling code here:
        try {
            livro livro = new livro();

            livro.setTitulo(getTitulo.getText());
            livro.setPaginas(Integer.parseInt(getPaginas.getText()));
            livro.setAutor(getAutor.getText());
            livro.setEditora(getEditora.getText());

            String ano = getAnoPublicacao.getText();
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.parseInt(ano));
            Date anoPublicacao = (Date) calendar.getTime();
            livro.setAnoPublicacao(anoPublicacao);

            livroControl.save(livro);
            JOptionPane.showMessageDialog(rootPane, "livro salvo com sucesso");
            getTitulo.setText(null);
            getEditora.setText(null);
            getPaginas.setText(null);
            getAutor.setText(null);
            getAnoPublicacao.setText(null);

            loadLivros();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao adicionar um livro");
        }
    }//GEN-LAST:event_addLivroMouseClicked

    private void PesquisaLivros() {
        String sql = "SELECT * FROM livro WHERE titulo like ?";
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;

        try {
            connect = ConnectionFactory.getConnection();
            statement = connect.prepareStatement(sql);

            // a porcentagem indica continuação da string
            statement.setString(1, getPesqTitulo.getText() + "%");
            resultado = statement.executeQuery();

            tableLivros.setModel(DbUtils.resultSetToTableModel(resultado));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    // consulta dados por id
    private void consultar() {
        String sql = "SELECT * FROM livro WHERE idLivro = ?";

        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;

        try {
            connect = ConnectionFactory.getConnection();
            statement = connect.prepareStatement(sql);
            statement.setString(1, idLivroField.getText());
            resultado = statement.executeQuery();
            if (resultado.next()) {
                getTitulo.setText(resultado.getString(3));
                getEditora.setText(resultado.getString(7));
                getPaginas.setText(resultado.getString(5));
                getAutor.setText(resultado.getString(4));
                getAnoPublicacao.setText(resultado.getString(6));
            } else {
                JOptionPane.showMessageDialog(rootPane, "livro nao cadastrado");
            }

//            tableClientes.setModel(DbUtils.resultSetToTableModel(resultado));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    public void updateBook() {
        String sql = "UPDATE livros SET titulo = ? , autor = ?, paginas = ?, anoPublicacao= ?, editora = ?, disponivel = ? WHERE idLivro = ?";

        Connection connect = null;
        PreparedStatement statement = null;

        try {
            connect = ConnectionFactory.getConnection();
            statement = connect.prepareStatement(sql);

            statement.setString(1, getTitulo.getText());
            statement.setString(2, getAutor.getText());
            statement.setString(3, getPaginas.getText());
            statement.setString(4, getAnoPublicacao.getText());
            statement.setString(5, getEditora.getText());
            statement.setString(6, cbDisponivel.getSelectedItem().toString());
            statement.setString(7, idLivroField.getText());

            int add = statement.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(rootPane, "livro salvo com sucesso");
                getTitulo.setText(null);
                getEditora.setText(null);
                getPaginas.setText(null);
                getAutor.setText(null);
                getAnoPublicacao.setText(null);
            }

            connect.close();
            loadLivros();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,e);
        }

    }


    private void getPesqTituloKeyReleased(KeyEvent evt) {//GEN-FIRST:event_getPesqTituloKeyReleased
        // TODO add your handling code here:
        PesquisaLivros();
    }//GEN-LAST:event_getPesqTituloKeyReleased

    private void consultarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_consultarActionPerformed

    private void closedActionPerformed(ActionEvent evt) {//GEN-FIRST:event_closedActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closedActionPerformed

    private void deleteLivroMouseClicked(MouseEvent evt) {//GEN-FIRST:event_deleteLivroMouseClicked
        // TODO add your handling code here:
        livroControl.remove(Integer.parseInt(idLivroField.getText()));
    }//GEN-LAST:event_deleteLivroMouseClicked

    private void EditarLivroMouseClicked(MouseEvent evt) {//GEN-FIRST:event_EditarLivroMouseClicked
        // TODO add your handling code here:
//        livroControl.update();
        updateBook();
    }//GEN-LAST:event_EditarLivroMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    JPanel PanelClientes;
    JLabel addLivro;
    JComboBox<String> cbDisponivel;
    JButton consultar;
    JLabel deleteLivro;
    JTextField getAnoPublicacao;
    JTextField getAutor;
    JTextField getEditora;
    JTextField getPaginas;
    JTextField getPesqTitulo;
    JTextField getTitulo;
    JTextField idLivroField;
    JLabel jLabel4;
    JTable tableLivros;
    // End of variables declaration//GEN-END:variables

    public void decorateTablecliente() {
        //Ao setar a fonte passa-se pelo menos 3 parametros ao metodo font()
        //Nome da fonte
        //Espessura (Normal, negrito, etc)
        //Tamanho da fonte
        tableLivros.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        //Setando a cor verde do projeto
        tableLivros.getTableHeader().setBackground(new Color(0, 102, 102));
        tableLivros.getTableHeader().setForeground(new Color(255, 255, 255));

        //Esse metodo permite a ordena��o da tabela pela coluna selecionada
        tableLivros.getAutoCreateRowSorter();

        //Dentro da tableClientes, pega o model dela, pegando a sua coluna 2 (nesse caso)
        //
//        tableClientes.getColumnModel().getColumn(3).setCellRenderer(new ButtonColumnCellRender("editar"));
//        tableClientes.getColumnModel().getColumn(6).setCellRenderer(new ButtonColumnCellRender("excluir"));
    }

    public void initDataController() {
        livroControl = new livroController();
//        livroControll = new livroController();
//        projectController = new ProjectController();
    }

    //Gerencia a parte visual do jList
    public void initComponentsModel() {
        livrosModel = new tableModelLivros();
        tableLivros.setModel(livrosModel);

//        Verificaçao para o que será apresentado na tela criada quando for criada
//        if (!clientesModel.isEmpty()) {
//            loadclientes();
//        }
    }

    private void loadLivros() {
        List<model.livro> livros = livroControl.getAll();

        livrosModel.setlivros(livros);
    }
}
