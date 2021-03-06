/*
this class will have the getters and setters. for us to use them later to save the information 
 */
package Herencia;

import Procedimientos.Conexion_busqueda;
import java.io.File;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author Kevin
 */
public class Vehiculos {

    String Placa_vehiculo;
    int Codigo_marca;
    int Codigo_estilo;
    int Codigo_modelo;
    String Transmision_vehiculo;
    String Año;
    double Precio;
    File Foto;
    String Estado;
    String url;

    public Vehiculos(String Placa_vehiculo, int Codigo_marca, int Codigo_estilo, int Codigo_modelo, String Transmision_vehiculo, String Año, double Precio, File Foto, String Estado, String url) {
        this.Placa_vehiculo = Placa_vehiculo;
        this.Codigo_marca = Codigo_marca;
        this.Codigo_estilo = Codigo_estilo;
        this.Codigo_modelo = Codigo_modelo;
        this.Transmision_vehiculo = Transmision_vehiculo;
        this.Año = Año;
        this.Precio = Precio;
        this.Foto = Foto;
        this.Estado = Estado;
        this.url = url;
    }

    public Vehiculos() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlaca_vehiculo() {
        return Placa_vehiculo;
    }

    public int getCodigo_marca() {
        return Codigo_marca;
    }

    public int getCodigo_estilo() {
        return Codigo_estilo;
    }

    public int getCodigo_modelo() {
        return Codigo_modelo;
    }

    public String getTransmision_vehiculo() {
        return Transmision_vehiculo;
    }

    public String getAño() {
        return Año;
    }

    public double getPrecio() {
        return Precio;
    }

    public File getFoto() {
        return Foto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setPlaca_vehiculo(String Placa_vehiculo) {
        this.Placa_vehiculo = Placa_vehiculo;
    }

    public void setCodigo_marca(int Codigo_marca) {
        this.Codigo_marca = Codigo_marca;
    }

    public void setCodigo_estilo(int Codigo_estilo) {
        this.Codigo_estilo = Codigo_estilo;
    }

    public void setCodigo_modelo(int Codigo_modelo) {
        this.Codigo_modelo = Codigo_modelo;
    }

    public void setTransmision_vehiculo(String Transmision_vehiculo) {
        this.Transmision_vehiculo = Transmision_vehiculo;
    }

    public void setAño(String Año) {
        this.Año = Año;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setFoto(File Foto) {
        this.Foto = Foto;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    ImageIcon imagen = new ImageIcon();

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return "Número de Placa: " + this.Placa_vehiculo;

    }

    public LinkedList<Vehiculos> buscar(boolean[] filtros) {
        Conexion_busqueda c = new Conexion_busqueda();
        c.conectar();
        String sql = "SELECT placa, id_marca, id_modelo, id_estilo, transmision, ano, precio, foto "
                + "FROM vehiculo WHERE estado = 'Disponible'";
        String consulta = "";
        if (filtros[0]) {
            consulta += " AND ano >= '" + Año + "'";
        }
        if (filtros[1]) {
            consulta += " AND id_estilo = '" + Codigo_estilo + "'";
        }
        if (filtros[2]) {
            consulta += " AND id_marca = '" + Codigo_marca + "'";
        }
        if (filtros[3]) {
            consulta += " AND id_modelo = '" + Codigo_modelo + "'";
        }
        if (filtros[4]) {
            consulta += " AND precio <= '" + Precio + "'";
        }
        if (filtros[5]) {
            consulta += " AND transmision = '" + Transmision_vehiculo + "'";
        }
        if (!"".equals(consulta)) {
            sql += consulta;
        }
        LinkedList<Vehiculos> lista = c.buscarVehiculos(sql);
        return lista;
    }

}
