package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Busquedas extends JDialog {
    private String buscarEnTabla = "";
    private JLabel jLabel1 = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextField jTextField1 = new JTextField();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JTextArea jTextArea1 = new JTextArea();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();

    public Busquedas() {
        this(null, "", false);
    }

    public Busquedas(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(474, 406));
        this.getContentPane().setLayout( null );
        jLabel1.setText("jLabel1");
        jLabel1.setBounds(new Rectangle(10, 5, 450, 35));
        jLabel1.setBackground(new Color(255, 156, 49));
        jLabel1.setOpaque(true);
        jLabel1.setAlignmentX((float) 0.5);
        jScrollPane1.setBounds(new Rectangle(5, 80, 175, 285));
        jTextField1.setBounds(new Rectangle(15, 45, 440, 30));
        jScrollPane2.setBounds(new Rectangle(185, 90, 270, 220));
        jTextArea1.setFont(new Font("Courier New", 1, 14));
        jButton1.setText("Borrar");
        jButton1.setBounds(new Rectangle(190, 325, 125, 35));
        jButton2.setText("Editar");
        jButton2.setBounds(new Rectangle(325, 325, 125, 35));
        jScrollPane2.getViewport().add(jTextArea1, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jScrollPane2, null);
        this.getContentPane().add(jTextField1, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jLabel1, null);
    }

    public void setBuscarEnTabla(String buscarEnTabla) {
        this.jLabel1.setText("Buscar en la tabla: " + buscarEnTabla.toUpperCase());
        this.buscarEnTabla = buscarEnTabla;
    }
}
