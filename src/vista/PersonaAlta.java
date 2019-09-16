package vista;

import app.Personas;

import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PersonaAlta extends JDialog {
    private JButton jButton1 = new JButton();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JTextField jTextField3 = new JTextField();
    private JTextField jTextField4 = new JTextField();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextArea jTextArea1 = new JTextArea();

    public PersonaAlta() {
        this(null, "", false);
    }

    public PersonaAlta(Frame parent, String title, boolean modal) {
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
        this.setTitle("Alta de personas");
        jButton1.setText("Dar de alta");
        jButton1.setBounds(new Rectangle(80, 170, 300, 50));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jLabel1.setText("DNI");
        jLabel1.setBounds(new Rectangle(5, 25, 110, 20));
        jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel2.setText("Nombre");
        jLabel2.setBounds(new Rectangle(5, 60, 110, 20));
        jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel3.setText("Apellido");
        jLabel3.setBounds(new Rectangle(5, 100, 110, 20));
        jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel4.setText("Dirección");
        jLabel4.setBounds(new Rectangle(5, 135, 110, 25));
        jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField1.setBounds(new Rectangle(120, 25, 260, 25));
        jTextField2.setBounds(new Rectangle(120, 60, 260, 25));
        jTextField3.setBounds(new Rectangle(120, 100, 260, 25));
        jTextField4.setBounds(new Rectangle(120, 135, 260, 25));
        jScrollPane1.setBounds(new Rectangle(5, 230, 395, 100));
        jTextArea1.setLineWrap(true);
        jScrollPane1.getViewport().add(jTextArea1, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jTextField4, null);
        this.getContentPane().add(jTextField3, null);
        this.getContentPane().add(jTextField2, null);
        this.getContentPane().add(jTextField1, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jButton1, null);
    }
    private Personas personas = new Personas();
    private void jButton1_actionPerformed(ActionEvent e) {
        String error="";
        String DNI = jTextField1.getText();
        if(DNI.trim().length()>7) {
          String[] datos = {this.jTextField1.getText(),
                          this.jTextField2.getText(),
                          this.jTextField3.getText(),
                          this.jTextField4.getText(),
                          };
         error = personas.alta(datos); 
        }else{
            JOptionPane.showMessageDialog(this, "Falta el DNI.", "Un dato no es correcto.", JOptionPane.INFORMATION_MESSAGE);
            error="El DNI debe tener más dígitos.";
        }
        if(error.equals("1") == true) {
            this.jTextArea1.setText("Registro guardado correctamente. ");
        }else{
            this.jTextArea1.setText(error);
        }
    }

    public Personas getPersonas() {
        return personas;
    }
}
