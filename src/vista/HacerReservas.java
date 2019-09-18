package vista;

import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;


public class HacerReservas extends JDialog {
   // private JCalendar c = new JCalendar();
   // private JDateChooser cc= new JDateChooser();
    
    private String[] nSpinner = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};  
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JTextField jTextField3 = new JTextField();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JLabel jLabel4 = new JLabel();
    private JTextField jTextField4 = new JTextField();
    private JButton jButton4 = new JButton();
    private JSpinner jSpinner1 = new JSpinner();
    private JLabel jLabel5 = new JLabel();

    public HacerReservas() {
        this(null, "", false);
    }

    public HacerReservas(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(526, 374));
        this.getContentPane().setLayout( null );
        jLabel1.setText("Persona:");
        jLabel1.setBounds(new Rectangle(10, 45, 135, 20));
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setText("Trabajador:");
        jLabel2.setBounds(new Rectangle(5, 75, 140, 20));
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setText("Habitación:");
        jLabel3.setBounds(new Rectangle(5, 105, 140, 20));
        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField1.setBounds(new Rectangle(150, 40, 195, 25));
        jTextField2.setBounds(new Rectangle(150, 70, 195, 25));
        jTextField3.setBounds(new Rectangle(150, 100, 195, 25));
        jButton1.setText("Buscar");
        jButton1.setBounds(new Rectangle(355, 40, 95, 25));
        jButton2.setText("Buscar");
        jButton2.setBounds(new Rectangle(355, 70, 95, 25));
        jButton3.setText("Buscar");
        jButton3.setBounds(new Rectangle(355, 100, 95, 25));
        jLabel4.setText("Fecha de ingreso:");
        jLabel4.setBounds(new Rectangle(15, 165, 145, 30));
        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField4.setBounds(new Rectangle(165, 165, 180, 25));
        jButton4.setText("¿Fecha?");
        jButton4.setBounds(new Rectangle(355, 165, 85, 30));
        jButton4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton4_actionPerformed(e);
                }
            });
        jSpinner1.setBounds(new Rectangle(165, 200, 180, 25));
        jLabel5.setText("Cantidad de días:");
        jLabel5.setBounds(new Rectangle(15, 200, 145, 25));
        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jSpinner1, null);
        this.getContentPane().add(jButton4, null);
        this.getContentPane().add(jTextField4, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jButton3, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jTextField3, null);
        this.getContentPane().add(jTextField2, null);
        this.getContentPane().add(jTextField1, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
        this.jSpinner1.setModel(new SpinnerListModel(nSpinner));
        
        
    
    }

    private void jButton4_actionPerformed(ActionEvent e) {
        Date date = new Date();

    }
}
