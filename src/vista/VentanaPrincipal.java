package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import sql.ConexionDB;

public class VentanaPrincipal extends JFrame {
    private ImageIcon icoSalir = new ImageIcon(getClass().getResource("/recursos/salir32.png"));
    private Image icoImgSalir = icoSalir.getImage();
    private ImageIcon icoHotel = new ImageIcon(getClass().getResource("/recursos/gestionHotel.png"));
    private Image icoImgHotel = icoHotel.getImage();
    
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
    private JMenuItem jMenuItem4 = new JMenuItem();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JMenuItem jMenuItem5 = new JMenuItem();
    private JMenuItem jMenuItem8 = new JMenuItem();
    private JMenuItem jMenuItem9 = new JMenuItem();
    private JMenuItem jMenuItem12 = new JMenuItem();
    private JMenuItem jMenuItem13 = new JMenuItem();
    private JMenuItem jMenuItem2 = new JMenuItem();
    private JMenuItem jMenuItem3 = new JMenuItem();

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
        this.setIconImage(icoImgHotel);
        jToolBar1.setBounds(new Rectangle(10, 5, 560, 40));
        jToolBar1.setLayout(null);
        jToolBar1.setFloatable(false);
        jButton1.setText("Conectar a MySQL");
        jButton1.setBounds(new Rectangle(10, 5, 160, 30));
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
        jMenuItem1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jMenuItem1_actionPerformed(e);
                }
            });
        jMenuItem4.setText("Buscar");
        jMenuItem4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jMenuItem4_actionPerformed(e);
                }
            });
        jLabel1.setText("jLabel1");
        jLabel1.setBounds(new Rectangle(180, 0, 210, 35));
        jLabel2.setText("jLabel2");
        jLabel2.setBounds(new Rectangle(435, 0, 115, 35));
        jLabel3.setText("Sistema de gestión de hoteles");
        jLabel3.setBounds(new Rectangle(5, 65, 560, 110));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setFont(new Font("Tahoma", 1, 18));
        jMenuItem5.setText("Alta");
        jMenuItem5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jMenuItem5_actionPerformed(e);
                }
            });
        jMenuItem8.setText("Buscar");
        jMenuItem8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jMenuItem8_actionPerformed(e);
                }
            });
        jMenuItem9.setText("Alta");
        jMenuItem9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jMenuItem9_actionPerformed(e);
                }
            });
        jMenuItem12.setText("Buscar");
        jMenuItem12.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jMenuItem12_actionPerformed(e);
                }
            });
        jMenuItem13.setText("Salir");
        jMenuItem13.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, java.awt.Event.CTRL_MASK, false));
        jMenuItem13.setIcon(icoSalir);
        jMenuItem13.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jMenuItem13_actionPerformed(e);
                }
            });
        jMenuItem2.setText("Hacer reserva");
        jMenuItem2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jMenuItem2_actionPerformed(e);
                }
            });
        jMenuItem3.setText("Buscar");
        jToolBar1.add(jButton1, BorderLayout.CENTER);
        jToolBar1.add(jLabel1, BorderLayout.CENTER);
        jToolBar1.add(jLabel2, BorderLayout.EAST);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jToolBar1, null);
        jMenu1.add(jMenuItem13);
        jMenuBar1.add(jMenu1);
        jMenu2.add(jMenuItem1);
        jMenu2.add(jMenuItem4);
        jMenuBar1.add(jMenu2);
        jMenu3.add(jMenuItem5);
        jMenu3.add(jMenuItem8);
        jMenuBar1.add(jMenu3);
        jMenu4.add(jMenuItem9);
        jMenu4.add(jMenuItem12);
        jMenuBar1.add(jMenu4);
        jMenu5.add(jMenuItem2);
        jMenu5.add(jMenuItem3);
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
        polimorfismoMostrarDialogos(conectarMySQL);
        try {
            this.jLabel1.setText("Conectado a: " + ConexionDB.getCnx().getCatalog() + " ");
        } catch (SQLException f) {
            jLabel1.setText("No conectado: " + f.getMessage() + " ");
        } catch (Exception f){
            jLabel1.setText("No conectado: " + f.getMessage() + " ");
        }
    }
    private PersonaAlta personaAlta = new PersonaAlta();
    private void jMenuItem1_actionPerformed(ActionEvent e) {
        polimorfismoMostrarDialogos(personaAlta);
    }

    private void polimorfismoMostrarDialogos(JDialog miDialogo) {
        miDialogo.setLocationRelativeTo(null);
        miDialogo.setModal(true);
        miDialogo.setResizable(false);
        miDialogo.setDefaultCloseOperation(conectarMySQL.HIDE_ON_CLOSE);
        miDialogo.setVisible(true);
    }
    private TrabajadorAlta trabajadorAlta = new TrabajadorAlta();
    private void jMenuItem5_actionPerformed(ActionEvent e) {
        polimorfismoMostrarDialogos(trabajadorAlta);
    }
    private HabitacionAlta habitacionAlta = new HabitacionAlta();
    private void jMenuItem9_actionPerformed(ActionEvent e) {
        polimorfismoMostrarDialogos(habitacionAlta);
    }
    private Busquedas busquedas = new Busquedas();
    private void jMenuItem4_actionPerformed(ActionEvent e) {
        busquedas.setNombreTabla(personaAlta.getPersonas().getNombreTabla(),
                                 personaAlta.getPersonas().getCampos());
        polimorfismoMostrarDialogos(busquedas);        
    }

    private void jMenuItem8_actionPerformed(ActionEvent e) {
        busquedas.setNombreTabla(trabajadorAlta.getTrabajadores().getNombreTabla(),
                                 trabajadorAlta.getTrabajadores().getCampos());
        polimorfismoMostrarDialogos(busquedas);  
    }

    private void jMenuItem12_actionPerformed(ActionEvent e) {
        busquedas.setNombreTabla(habitacionAlta.getHabitacion().getNombreTabla(),
                                 habitacionAlta.getHabitacion().getCampos());
        polimorfismoMostrarDialogos(busquedas);          
    }

    private void jMenuItem13_actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    private HacerReservas hacerReservas = new HacerReservas();
    private void jMenuItem2_actionPerformed(ActionEvent e) {
        polimorfismoMostrarDialogos(hacerReservas);
        
    }
}
