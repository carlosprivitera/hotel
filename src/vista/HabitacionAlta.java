package vista;

import app.Habitacion;
import app.Personas;

import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HabitacionAlta extends JDialog {
    private JButton jButton1 = new JButton();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JTextField jTextField4 = new JTextField();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextArea jTextArea1 = new JTextArea();
    private JComboBox jComboBox1 = new JComboBox();
    private DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(); 

    public HabitacionAlta() {
        this(null, "", false);
    }

    public HabitacionAlta(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(431, 373));
        this.getContentPane().setLayout( null );
        this.setTitle("Alta de habitaciones");
        jButton1.setText("Dar de alta");
        jButton1.setBounds(new Rectangle(80, 170, 300, 50));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jLabel1.setText("Número");
        jLabel1.setBounds(new Rectangle(5, 25, 110, 20));
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setText("Precio");
        jLabel2.setBounds(new Rectangle(5, 60, 110, 20));
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setText("Tipo");
        jLabel3.setBounds(new Rectangle(5, 100, 110, 20));
        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel4.setText("Descripción");
        jLabel4.setBounds(new Rectangle(5, 135, 110, 25));
        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField1.setBounds(new Rectangle(120, 25, 260, 25));
        jTextField2.setBounds(new Rectangle(120, 60, 260, 25));
        jTextField4.setBounds(new Rectangle(120, 135, 260, 25));
        jScrollPane1.setBounds(new Rectangle(5, 230, 395, 100));
        jTextArea1.setLineWrap(true);
        jComboBox1.setBounds(new Rectangle(120, 100, 260, 25));
        jScrollPane1.getViewport().add(jTextArea1, null);
        this.getContentPane().add(jComboBox1, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jTextField4, null);
        this.getContentPane().add(jTextField2, null);
        this.getContentPane().add(jTextField1, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jButton1, null);
        defaultComboBoxModel.addElement("Normal");
        defaultComboBoxModel.addElement("Grande");
        defaultComboBoxModel.addElement("VIP");
        jComboBox1.setModel(defaultComboBoxModel);
    }
    private Habitacion habitacion = new Habitacion();
    private void jButton1_actionPerformed(ActionEvent e) {
        String error="";
        String numero = jTextField1.getText();
        if(numero.trim().length()>1) {
          String[] datos = { this.jTextField1.getText(),
                             this.jTextField2.getText(),
                             this.jComboBox1.getSelectedItem().toString(),
                             this.jTextField4.getText(),
                          };
         error = habitacion.alta(datos); 
        }else{
            JOptionPane.showMessageDialog(this, "Falta el número de habitación.", "Un dato no es correcto.", JOptionPane.INFORMATION_MESSAGE);
            error="El número de habitación debe tener más dígitos.";
        }
        if(error.equals("1") == true) {
            this.jTextArea1.setText("Registro guardado correctamente. ");
        }else{
            this.jTextArea1.setText(error);
        }
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }
}
