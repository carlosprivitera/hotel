package app;

import java.util.ArrayList;

import sql.Alta;

public class Habitacion extends Registro {   
    public Habitacion() {
        super();
        String[] campos = {"N�mero", "Precio","Tipo","Descripci�n"}; 
        this.setNombreTabla("Habitaci�n");
        this.setCampos(campos);
    }
    Alta altaMySQL  = new Alta();
    public String alta(String[] datos) {
        String error = altaMySQL.altaRegistro(this.getNombreTabla(), this.getCampos(), datos);
        if(error.equals("1")){
            altaMapeo(datos);
        }
        return error;
    }

    public void altaMapeo(String[] reg) {
        super.altaMapeo(reg);
    }

    public String[] getCampos() {
        return super.getCampos();
    }

    public String getNombreTabla() {
        return super.getNombreTabla();
    }
}
