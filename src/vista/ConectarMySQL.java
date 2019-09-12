package vista;

import app.*;
import java.awt.Dimension;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ConectarMySQL extends JDialog {
    private JLabel jLabel1 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JTextField jTextField2 = new JTextField();
    private JButton jButton1 = new JButton();
    private JTextArea jTextArea1 = new JTextArea();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JPasswordField jPasswordField1 = new JPasswordField();
    private JButton jButton2 = new JButton();

    public ConectarMySQL() {
        super();
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        this.setSize(new Dimension(447, 379));
        this.setTitle("Conectar con el servidor MySQL");
        jLabel1.setText("IP del servidor:");
        jLabel1.setBounds(new Rectangle(0, 10, 100, 25));
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField1.setBounds(new Rectangle(105, 10, 310, 25));
        jTextField1.setText("127.0.0.1");
        jLabel2.setText("Usuario:");
        jLabel2.setBounds(new Rectangle(0, 40, 100, 25));
        jLabel2.setHorizontalTextPosition(SwingConstants.LEADING);
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setText("Password:");
        jLabel3.setBounds(new Rectangle(0, 70, 100, 25));
        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField2.setBounds(new Rectangle(105, 40, 310, 25));
        jTextField2.setText("usuario");
        jButton1.setText("Conectar");
        jButton1.setBounds(new Rectangle(105, 105, 150, 45));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jTextArea1.setLineWrap(true);
        jScrollPane1.setBounds(new Rectangle(5, 155, 415, 180));
        jPasswordField1.setBounds(new Rectangle(105, 70, 310, 25));
        jPasswordField1.setText("12345678");
        jButton2.setText("Desconectar");
        jButton2.setBounds(new Rectangle(265, 105, 150, 45));
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2_actionPerformed(e);
                }
            });
        jScrollPane1.getViewport().add(jTextArea1, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jPasswordField1, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jTextField2, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jTextField1, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jButton1, null);
    }

    private void jButton1_actionPerformed(ActionEvent e) {
        //miConexion mc;
        //mc = new miConexion();
        //this.jTextArea1.setText(mc.miConexion());
        char[] passTemp1 = jPasswordField1.getPassword();
        String passTemp2 = String.copyValueOf(passTemp1);
        ConexionDB.hacerConexion(jTextField1.getText(), jTextField2.getText(), passTemp2);
        jTextArea1.setText(ConexionDB.ultimoError());
    }

    private void jButton2_actionPerformed(ActionEvent e) {
        jTextArea1.setText(ConexionDB.desconectar());
    }
}
