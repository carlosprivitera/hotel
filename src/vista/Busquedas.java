package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sql.Buscar;

public class Busquedas extends JDialog {
    private String nombreTabla = "";
    private String[] nombreColumnas = null;
    private JLabel jLabel1 = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextField jTextField1 = new JTextField();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JTextArea jTextArea1 = new JTextArea();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JList jList1 = new JList();

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
        this.setTitle("Búsquedas en la Base de Datos ");
        jLabel1.setText("jLabel1");
        jLabel1.setBounds(new Rectangle(10, 5, 450, 35));
        jLabel1.setBackground(new Color(255, 156, 49));
        jLabel1.setOpaque(true);
        jLabel1.setAlignmentX((float) 0.5);
        jScrollPane1.setBounds(new Rectangle(5, 80, 175, 285));
        jTextField1.setBounds(new Rectangle(190, 45, 265, 30));
        jTextField1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jTextField1_actionPerformed(e);
                }
            });
        jScrollPane2.setBounds(new Rectangle(185, 135, 270, 230));
        jTextArea1.setFont(new Font("Courier New", 1, 14));
        jButton1.setText("Buscar");
        jButton1.setBounds(new Rectangle(10, 45, 170, 30));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jButton2.setText("Editar");
        jButton2.setBounds(new Rectangle(190, 85, 125, 35));
        jButton3.setText("Borrar");
        jButton3.setBounds(new Rectangle(330, 85, 125, 35));
        jList1.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    jList1_valueChanged(e);
                }
            });
        jScrollPane2.getViewport().add(jTextArea1, null);
        this.getContentPane().add(jButton3, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jScrollPane2, null);
        this.getContentPane().add(jTextField1, null);
        jScrollPane1.getViewport().add(jList1, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jLabel1, null);
        this.jList1.setModel(miModelo);
    }

    public void setNombreTabla(String buscarEnTabla, String[] tablaColumnas) {
        this.jLabel1.setText("Buscar en la tabla: " + buscarEnTabla.toUpperCase());
        if(nombreTabla.equals(buscarEnTabla)!=true){
            miModelo.removeAllElements();
            this.jTextArea1.setText("");
        }    
        this.nombreTabla = buscarEnTabla;
        this.nombreColumnas = tablaColumnas;
    }

    private void jTextField1_actionPerformed(ActionEvent e) {
    }
    private Buscar buscar = new Buscar();
    private DefaultListModel miModelo = new DefaultListModel();  
    private ArrayList<String[]> registrosDB = new ArrayList<String[]>();
    private void jButton1_actionPerformed(ActionEvent e) {
        registrosDB = buscar.buscarReg(nombreTabla);
        int nReg = registrosDB.size();
        if(nReg>0) {
            miModelo.removeAllElements();
          for(int c=0; c<nReg;c++) {
            miModelo.addElement(registrosDB.get(c)[0]);
          }
          this.jList1.setSelectedIndex(0);
          int nCol = this.nombreColumnas.length; 
          this.jTextArea1.setText("");  
          for(int b=1; b<nCol; b++) {
            this.jTextArea1.setText(this.jTextArea1.getText() + this.nombreColumnas[b] + ": " + registrosDB.get(0)[b] + "\n");                    
          }          
        }  
    }

    private void jList1_valueChanged(ListSelectionEvent e) {
        
        if(this.jList1.isSelectionEmpty()==true) return;
        
        int seleccionado = this.jList1.getSelectedIndex();
        int nCol = this.nombreColumnas.length; 
        this.jTextArea1.setText("");  
        for(int b=1; b<nCol; b++) {
          this.jTextArea1.setText(this.jTextArea1.getText() + this.nombreColumnas[b] + ": " + registrosDB.get(seleccionado)[b] + "\n");                    
        }                  
    }
}
