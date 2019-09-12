package vista;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {
    private JToolBar jToolBar1 = new JToolBar();
    private JButton jButton1 = new JButton();
    private JMenuBar jMenuBar1 = new JMenuBar();
    private JMenu jMenu1 = new JMenu();
    private JMenu jMenu2 = new JMenu();
    private JMenu jMenu3 = new JMenu();
    private JMenu jMenu4 = new JMenu();
    private JMenu jMenu5 = new JMenu();
    private JMenu jMenu6 = new JMenu();
    private JMenuItem jMenuItem1 = new JMenuItem();
    private JMenuItem jMenuItem2 = new JMenuItem();
    private JMenuItem jMenuItem3 = new JMenuItem();
    private JMenuItem jMenuItem4 = new JMenuItem();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();

    public VentanaPrincipal() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(578, 364));
        this.setJMenuBar(jMenuBar1);
        this.setResizable(false);
        jToolBar1.setBounds(new Rectangle(5, 5, 565, 35));
        jButton1.setText("Conectar a MySQL");
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jMenu1.setText("Archivo");
        jMenu2.setText("Personas");
        jMenu3.setText("Trabajadores");
        jMenu4.setText("Habitaciones");
        jMenu5.setText("Reservas");
        jMenu6.setText("Pagos");
        jMenuItem1.setText("Alta");
        jMenuItem2.setText("Baja");
        jMenuItem3.setText("Editar");
        jMenuItem4.setText("Buscar");
        jLabel1.setText("jLabel1");
        jLabel2.setText("jLabel2");
        jLabel3.setText("Sistema de gestión de hoteles");
        jLabel3.setBounds(new Rectangle(5, 65, 560, 110));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setFont(new Font("Tahoma", 1, 18));
        jToolBar1.add(jButton1, null);
        jToolBar1.add(jLabel1, null);
        jToolBar1.add(jLabel2, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jToolBar1, null);
        jMenuBar1.add(jMenu1);
        jMenu2.add(jMenuItem1);
        jMenu2.add(jMenuItem2);
        jMenu2.add(jMenuItem3);
        jMenu2.add(jMenuItem4);
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu3);
        jMenuBar1.add(jMenu4);
        jMenuBar1.add(jMenu5);
        jMenuBar1.add(jMenu6);
    }
    private static VentanaPrincipal vp = new VentanaPrincipal();
    public static void main(String[] args) {
        vp.setDefaultCloseOperation(vp.EXIT_ON_CLOSE);
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }
    private ConectarMySQL conectarMySQL = new ConectarMySQL();
    private void jButton1_actionPerformed(ActionEvent e) {
        conectarMySQL.setLocationRelativeTo(null);
        conectarMySQL.setModal(true);
        conectarMySQL.setDefaultCloseOperation(conectarMySQL.HIDE_ON_CLOSE);
        conectarMySQL.setVisible(true);
    }
}
