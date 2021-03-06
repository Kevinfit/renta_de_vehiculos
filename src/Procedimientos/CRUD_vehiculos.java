/*
this will all the methods to do all the actions that the projet
 */
package Procedimientos;

import Herencia.Estilo;
import Herencia.Marca;
import Herencia.Modelo;
import Herencia.Oficina;
import Herencia.Vehiculos;
import static Interfaces.Eliminar_vehiculo.Tabla_eliminar;
import static Interfaces.Eliminar_vehiculo.label_eliminar;
import static Interfaces.Insertar_oficina.Codigo_oficina;
import static Interfaces.Insertar_oficina.Nombre_oficina;
import static Interfaces.Insertar_vehiculo.Año;
import static Interfaces.Insertar_vehiculo.Estado;
import static Interfaces.Insertar_vehiculo.Estilo_vehiculo;
import static Interfaces.Insertar_vehiculo.Imagen;
import static Interfaces.Insertar_vehiculo.Marca_vehiculos;
import static Interfaces.Insertar_vehiculo.Modelo_vehiculo;
import static Interfaces.Insertar_vehiculo.Placa_vehiculo;
import static Interfaces.Insertar_vehiculo.Precio;
import static Interfaces.Insertar_vehiculo.Transmision;
import static Interfaces.Insertar_vehiculo.Vehiculos_registrados;
import static Interfaces.Insertar_vehiculo.label_imagen;
import static Interfaces.Modificar_vehiculo.Año_modi;
import static Interfaces.Modificar_vehiculo.Estado_modi;
import static Interfaces.Modificar_vehiculo.Estilo_modi;
import static Interfaces.Modificar_vehiculo.Foto_modi;
import static Interfaces.Modificar_vehiculo.Label_estilo;
import static Interfaces.Modificar_vehiculo.Label_marca;
import static Interfaces.Modificar_vehiculo.Label_modelo;
import static Interfaces.Modificar_vehiculo.Marca_modi;
import static Interfaces.Modificar_vehiculo.Modelo_modi;
import static Interfaces.Modificar_vehiculo.Placa_modi;
import static Interfaces.Modificar_vehiculo.Placas_vehi;
import static Interfaces.Modificar_vehiculo.Precio_modi;
import static Interfaces.Modificar_vehiculo.Transmision_modi;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Kevin
 */
public class CRUD_vehiculos {

    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;
    private DefaultComboBoxModel<Marca> marca;
    private DefaultComboBoxModel<Marca> marcamodi;
    private DefaultComboBoxModel<Marca> marcacambiar;
    private DefaultComboBoxModel<Modelo> modelo;
    private DefaultComboBoxModel<Modelo> modelomodi;
    private DefaultComboBoxModel<Modelo> modelocambiar;
    private DefaultComboBoxModel<Estilo> estilo;
    private DefaultComboBoxModel<Estilo> estilomodi;
    private DefaultComboBoxModel<Estilo> estilocambiar;
    Instancias instancias = new Instancias();
    private DefaultListModel placas;
    FileInputStream Imagen_modi;

    public void Conexion_Base_datos() {
        if (connection != null) {
            return;
        }

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/renta_de_vehiculos", "postgres", "postgres123");
            if (connection != null) {

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Problem when connecting to the database");
        }
    }

    public ArrayList<Marca> obtenerMarca() {
        ArrayList<Marca> listamarca = new ArrayList();

        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM marcas");

            while (rs.next()) {
                String id = rs.getString("id_marca");
                String nombre = rs.getString("nombre");
                Marca marca = new Marca(Integer.parseInt(id), nombre);

                listamarca.add(marca);

            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }

        return listamarca;
    }

    public void llenarMarca() {
        marca = new DefaultComboBoxModel<Marca>();
        ArrayList<Marca> listamarca = new ArrayList();
        listamarca = obtenerMarca();

        for (Marca marca2 : listamarca) {
            marca.addElement(marca2);
        }
        Marca_vehiculos.setModel(marca);

    }

    public void llenarMarcaModi() {
        marcamodi = new DefaultComboBoxModel<Marca>();
        ArrayList<Marca> listamarca = new ArrayList();
        listamarca = obtenerMarca();

        for (Marca marca2 : listamarca) {
            marcamodi.addElement(marca2);
        }
        Marca_modi.setModel(marcamodi);

    }

    public ArrayList<Modelo> obtenerModelo() {
        ArrayList<Modelo> listamodelo = new ArrayList();

        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM modelo");

            while (rs.next()) {
                String id = rs.getString("id_modelo");
                String nombre = rs.getString("nombre");
                Modelo modelo = new Modelo(Integer.parseInt(id), nombre);

                listamodelo.add(modelo);

            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }

        return listamodelo;
    }

    public void llenarModelo() {
        modelo = new DefaultComboBoxModel<Modelo>();
        ArrayList<Modelo> listamodelo = new ArrayList();
        listamodelo = obtenerModelo();

        for (Modelo modelo2 : listamodelo) {
            modelo.addElement(modelo2);
        }
        Modelo_vehiculo.setModel(modelo);

    }

    public void llenarModeloModi() {
        modelomodi = new DefaultComboBoxModel<Modelo>();
        ArrayList<Modelo> listamodelo = new ArrayList();
        listamodelo = obtenerModelo();

        for (Modelo modelo2 : listamodelo) {
            modelomodi.addElement(modelo2);
        }
        Modelo_modi.setModel(modelomodi);

    }

    public ArrayList<Estilo> obtenerEstilo() {
        ArrayList<Estilo> listaestilo = new ArrayList();

        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM estilo");

            while (rs.next()) {
                String id = rs.getString("id_estilo");
                String nombre = rs.getString("nombre");
                Estilo estilo = new Estilo(Integer.parseInt(id), nombre);

                listaestilo.add(estilo);

            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }

        return listaestilo;
    }

    public void llenarEstilo() {
        estilo = new DefaultComboBoxModel<Estilo>();
        ArrayList<Estilo> listaestilo = new ArrayList();
        listaestilo = obtenerEstilo();

        for (Estilo estilo2 : listaestilo) {
            estilo.addElement(estilo2);
        }
        Estilo_vehiculo.setModel(estilo);

    }

    public void llenarEstiloModi() {
        estilomodi = new DefaultComboBoxModel<Estilo>();
        ArrayList<Estilo> listaestilo = new ArrayList();
        listaestilo = obtenerEstilo();

        for (Estilo estilo2 : listaestilo) {
            estilomodi.addElement(estilo2);
        }
        Estilo_modi.setModel(estilomodi);

    }

    public void insertarVehiculo() {
        Conexion_Base_datos();
        try {
            String placa = Placa_vehiculo.getText();
            Marca marca = (Marca) Marca_vehiculos.getSelectedItem();
            Modelo modelo = (Modelo) Modelo_vehiculo.getSelectedItem();
            Estilo estilo = (Estilo) Estilo_vehiculo.getSelectedItem();
            String transmision = Transmision.getSelectedItem().toString();
            String año = Año.getText();
            String precio = Precio.getText();
            String estado = Estado.getSelectedItem().toString();
            String url = Imagen.getAbsolutePath();
            Vehiculos vehiculo = new Vehiculos(placa, marca.getCodigo_marca(), estilo.getCodigo_estilo(), modelo.getCodigo_modelo(), transmision, año, Double.parseDouble(precio), Imagen, estado, url);
            FileInputStream foto = new FileInputStream(vehiculo.getFoto());

            String sql = "INSERT INTO vehiculo(placa, id_marca, id_modelo, id_estilo, transmision, ano, precio, foto, estado, url_foto_vehi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, vehiculo.getPlaca_vehiculo());
            ps.setInt(2, vehiculo.getCodigo_marca());
            ps.setInt(3, vehiculo.getCodigo_modelo());
            ps.setInt(4, vehiculo.getCodigo_estilo());
            ps.setString(5, vehiculo.getTransmision_vehiculo());
            ps.setString(6, vehiculo.getAño());
            ps.setDouble(7, vehiculo.getPrecio());
            ps.setBinaryStream(8, foto, (int) vehiculo.getFoto().length());
            ps.setString(9, vehiculo.getEstado());
            ps.setString(10, vehiculo.getUrl());
            int z = ps.executeUpdate();
            if (z == 1) {
                JOptionPane.showMessageDialog(null, "Se agregó el Vehiculo de manera exitosa");
                Placa_vehiculo.setText("");
                Año.setText("");
                Precio.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el Vehiculo!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el Vehiculo , ya existe esa Placa " + e);
        }
    }

    public void cargarTablaVehiculos() {
        ArrayList<String> placa = null;
        ArrayList<String> marca = null;
        ArrayList<String> modelo = null;
        ArrayList<String> estilo = null;
        ArrayList<String> trans = null;
        ArrayList<String> año = null;
        ArrayList<String> precio = null;
        ArrayList<String> estado = null;

        Conexion_Base_datos();
        try {
            placa = new <String>ArrayList();
            marca = new <String>ArrayList();
            modelo = new <String>ArrayList();
            estilo = new <String>ArrayList();
            trans = new <String>ArrayList();
            año = new <String>ArrayList();
            precio = new <String>ArrayList();
            estado = new <String>ArrayList();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT v.placa, m.nombre as marca, a.nombre as modelo, e.nombre as estilo , v.transmision, v.ano, v.precio, v.estado FROM vehiculo v, marcas m, modelo a, estilo e\n"
                    + "WHERE v.id_marca = m.id_marca AND a.id_modelo = v.id_modelo AND e.id_estilo = v.id_estilo ORDER BY placa ASC;");

            while (rs.next()) {
                placa.add(rs.getString("placa"));
                marca.add(rs.getString("marca"));
                modelo.add(rs.getString("modelo"));
                estilo.add(rs.getString("estilo"));
                trans.add(rs.getString("transmision"));
                año.add(rs.getString("ano"));
                precio.add(rs.getString("precio"));
                estado.add(rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }

        for (int i = 0; i < placa.size(); i++) {
            Vehiculos_registrados.setValueAt(placa.get(i), i, 0);
            Vehiculos_registrados.setValueAt(marca.get(i), i, 1);
            Vehiculos_registrados.setValueAt(modelo.get(i), i, 2);
            Vehiculos_registrados.setValueAt(estilo.get(i), i, 3);
            Vehiculos_registrados.setValueAt(trans.get(i), i, 4);
            Vehiculos_registrados.setValueAt(año.get(i), i, 5);
            Vehiculos_registrados.setValueAt(precio.get(i), i, 6);
            Vehiculos_registrados.setValueAt(estado.get(i), i, 7);

            if (placa.size() >= Vehiculos_registrados.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Vehiculos_registrados.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (Vehiculos_registrados.getRowCount() > placa.size()) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) Vehiculos_registrados.getModel();
                Vehiculos_registrados.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    public InputStream buscarFoto() {
        InputStream foto = null;
        TableModel tablaModelo;
        tablaModelo = (TableModel) Vehiculos_registrados.getModel();
        boolean avanzar = true;
        int registro = Vehiculos_registrados.getSelectedRow();
        int columna = Vehiculos_registrados.getSelectedColumn();

        if (registro == -1) {

            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }

        if (avanzar) {
            try {
                String strResultado = tablaModelo.getValueAt(Vehiculos_registrados.getSelectedRow(), 0).toString();

                Conexion_Base_datos();
                try {

                    s = connection.createStatement();
                    rs = s.executeQuery("SELECT foto FROM vehiculo WHERE placa = '" + strResultado + "'");

                    while (rs.next()) {
                        foto = rs.getBinaryStream("foto");
                    }
                } catch (Exception e) {
                    System.out.println("Error de conexión");
                }

            } catch (java.lang.NullPointerException e) {
            }

        }
        return foto;
    }

    public void enseñarFoto() {
        ImageIcon imagen = null;
        try {
            InputStream us = buscarFoto();
            BufferedImage bi = ImageIO.read(us);
            imagen = new ImageIcon(bi);

            label_imagen.setIcon(imagen);
        } catch (Exception e) {
        }

    }

    public void cargarTablaEliminar() {
        ArrayList<String> placa = null;
        ArrayList<String> marca = null;
        ArrayList<String> modelo = null;
        ArrayList<String> estilo = null;
        ArrayList<String> trans = null;
        ArrayList<String> año = null;
        ArrayList<String> precio = null;
        ArrayList<String> estado = null;

        Conexion_Base_datos();
        try {
            placa = new <String>ArrayList();
            marca = new <String>ArrayList();
            modelo = new <String>ArrayList();
            estilo = new <String>ArrayList();
            trans = new <String>ArrayList();
            año = new <String>ArrayList();
            precio = new <String>ArrayList();
            estado = new <String>ArrayList();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT v.placa, m.nombre as marca, a.nombre as modelo, e.nombre as estilo , v.transmision, v.ano, v.precio, v.estado FROM vehiculo v, marcas m, modelo a, estilo e\n"
                    + "WHERE v.id_marca = m.id_marca AND a.id_modelo = v.id_modelo AND e.id_estilo = v.id_estilo ORDER BY placa ASC;");

            while (rs.next()) {
                placa.add(rs.getString("placa"));
                marca.add(rs.getString("marca"));
                modelo.add(rs.getString("modelo"));
                estilo.add(rs.getString("estilo"));
                trans.add(rs.getString("transmision"));
                año.add(rs.getString("ano"));
                precio.add(rs.getString("precio"));
                estado.add(rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }

        for (int i = 0; i < placa.size(); i++) {
            Tabla_eliminar.setValueAt(placa.get(i), i, 0);
            Tabla_eliminar.setValueAt(marca.get(i), i, 1);
            Tabla_eliminar.setValueAt(modelo.get(i), i, 2);
            Tabla_eliminar.setValueAt(estilo.get(i), i, 3);
            Tabla_eliminar.setValueAt(trans.get(i), i, 4);
            Tabla_eliminar.setValueAt(año.get(i), i, 5);
            Tabla_eliminar.setValueAt(precio.get(i), i, 6);
            Tabla_eliminar.setValueAt(estado.get(i), i, 7);

            if (placa.size() >= Tabla_eliminar.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Tabla_eliminar.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (Tabla_eliminar.getRowCount() > placa.size()) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) Tabla_eliminar.getModel();
                Tabla_eliminar.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    public InputStream buscarFotoEliminar() {
        InputStream foto = null;
        TableModel tablaModelo;
        tablaModelo = (TableModel) Tabla_eliminar.getModel();
        boolean avanzar = true;
        int registro = Tabla_eliminar.getSelectedRow();
        int columna = Tabla_eliminar.getSelectedColumn();

        if (registro == -1) {

            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }

        if (avanzar) {
            try {
                String strResultado = tablaModelo.getValueAt(Tabla_eliminar.getSelectedRow(), 0).toString();

                Conexion_Base_datos();
                try {

                    s = connection.createStatement();
                    rs = s.executeQuery("SELECT foto FROM vehiculo WHERE placa = '" + strResultado + "'");

                    while (rs.next()) {
                        foto = rs.getBinaryStream("foto");
                    }
                } catch (Exception e) {
                    System.out.println("Error de conexión");
                }

            } catch (java.lang.NullPointerException e) {
            }

        }
        return foto;
    }

    public void enseñarFotoEliminar() {
        ImageIcon imagen = null;
        try {
            InputStream us = buscarFotoEliminar();
            BufferedImage bi = ImageIO.read(us);
            imagen = new ImageIcon(bi);

            label_eliminar.setIcon(imagen);
        } catch (Exception e) {
        }

    }

    public void Eliminar_vehiculo() {

        TableModel tablaModelo;
        tablaModelo = (TableModel) Tabla_eliminar.getModel();
        boolean avanzar = true;
        int registro = Tabla_eliminar.getSelectedRow();
        int columna = Tabla_eliminar.getSelectedColumn();

        if (registro == -1) {

            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }

        if (avanzar) {
            try {
                String strResultado = tablaModelo.getValueAt(Tabla_eliminar.getSelectedRow(), 0).toString();
                int opcion = JOptionPane.showConfirmDialog(null, "Desea Elmininar : " + strResultado);
                if (opcion == 0) {
                    Conexion_Base_datos();
                    try {

                        s = connection.createStatement();
                        int z = s.executeUpdate("DELETE FROM vehiculo WHERE placa = '" + strResultado + "'");
                        if (z == 1) {
                            JOptionPane.showMessageDialog(null, "Se eliminó el registro de manera exitosa");
                            cargarTablaEliminar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
                        }
                    } catch (Exception e) {
                        System.out.println("Error de conexión");
                    }
                }
            } catch (java.lang.NullPointerException e) {
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un registro");

        }

    }

    public ArrayList obtenerPlaca() {
        ArrayList listaoficina = new ArrayList();

        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT placa FROM vehiculo");

            while (rs.next()) {
                String id = rs.getString("placa");

                listaoficina.add(id);

            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }

        return listaoficina;
    }

    public void Llenarlista_modificar() {
        placas = new DefaultListModel();
        ArrayList listaoficina = new ArrayList();
        listaoficina = obtenerPlaca();

        for (int i = 0; i < listaoficina.size(); i++) {
            placas.addElement(listaoficina.get(i));
        }
        Placas_vehi.setModel(placas);

    }

    public void cargarDatosListaModificar() {
        String opci = Placas_vehi.getSelectedValue();
        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT v.placa, m.nombre as marca, a.nombre as modelo, e.nombre as estilo , v.transmision, v.ano, v.precio, v.estado FROM vehiculo v, marcas m, modelo a, estilo e\n"
                    + "WHERE v.id_marca = m.id_marca AND a.id_modelo = v.id_modelo AND e.id_estilo = v.id_estilo and v.placa = '" + opci + "' order by v.placa");

            while (rs.next()) {
                Placa_modi.setText(rs.getString("placa"));
                Transmision_modi.setSelectedItem(rs.getString("transmision"));
                Label_marca.setText("Marca: " + rs.getString("marca"));
                Label_modelo.setText("Modelo: " + rs.getString("modelo"));
                Label_estilo.setText("Estilo: " + rs.getString("estilo"));
                Año_modi.setText(rs.getString("ano"));
                Precio_modi.setText(rs.getString("precio"));
                Estado_modi.setSelectedItem(rs.getString("estado"));

            }
        } catch (Exception e) {

        }

    }

    public InputStream buscarFotoModi() {
        InputStream foto = null;
        try {
            String opci = Placas_vehi.getSelectedValue();

            Conexion_Base_datos();
            try {

                s = connection.createStatement();
                rs = s.executeQuery("SELECT foto FROM vehiculo WHERE placa = '" + opci + "'");

                while (rs.next()) {
                    foto = rs.getBinaryStream("foto");
                }
            } catch (Exception e) {
                System.out.println("Error de conexión");
            }

        } catch (java.lang.NullPointerException e) {
        }
        return foto;
    }

    public void enseñarFotoModi() {
        ImageIcon imagen = null;
        try {
            InputStream us = buscarFotoModi();
            BufferedImage bi = ImageIO.read(us);
            imagen = new ImageIcon(bi);

            Foto_modi.setIcon(imagen);

        } catch (Exception e) {
        }

    }

    public void modificarVehiculo() {
        String opci = Placas_vehi.getSelectedValue();
        if (Imagen == null) {
            Conexion_Base_datos();
            try {
                String placa = Placa_modi.getText();
                Marca marca = (Marca) Marca_modi.getSelectedItem();
                Modelo modelo = (Modelo) Modelo_modi.getSelectedItem();
                Estilo estilo = (Estilo) Estilo_modi.getSelectedItem();
                String transmision = Transmision_modi.getSelectedItem().toString();
                String año = Año_modi.getText();
                String precio = Precio_modi.getText();
                String estado = Estado_modi.getSelectedItem().toString();
                String url = Imagen.getAbsolutePath();
                Vehiculos vehiculo = new Vehiculos(placa, marca.getCodigo_marca(), estilo.getCodigo_estilo(), modelo.getCodigo_modelo(), transmision, año, Double.parseDouble(precio), Imagen, estado, url);
                

                String sql = "UPDATE vehiculo SET placa = ? , id_marca = ? , id_modelo = ? , id_estilo = ? , transmision = ?, ano = ?, precio = ?, estado = ?  WHERE placa = '" + opci + "'";
                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setString(1, vehiculo.getPlaca_vehiculo());
                ps.setInt(2, vehiculo.getCodigo_marca());
                ps.setInt(3, vehiculo.getCodigo_modelo());
                ps.setInt(4, vehiculo.getCodigo_estilo());
                ps.setString(5, vehiculo.getTransmision_vehiculo());
                ps.setString(6, vehiculo.getAño());
                ps.setDouble(7, vehiculo.getPrecio());
                ps.setString(8, vehiculo.getEstado());
                int z = ps.executeUpdate();
                if (z == 1) {
                    JOptionPane.showMessageDialog(null, "Se Modificó el Vehiculo de manera exitosa");
                    Llenarlista_modificar();
                    Placa_modi.setText("");
                    Año_modi.setText("");
                    Precio_modi.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar el Vehiculo!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al Modificar el Vehiculo , ya existe esa Placa " + e);
            }
        } else {
            Conexion_Base_datos();
            try {
                String placa = Placa_modi.getText();
                Marca marca = (Marca) Marca_modi.getSelectedItem();
                Modelo modelo = (Modelo) Modelo_modi.getSelectedItem();
                Estilo estilo = (Estilo) Estilo_modi.getSelectedItem();
                String transmision = Transmision_modi.getSelectedItem().toString();
                String año = Año_modi.getText();
                String precio = Precio_modi.getText();
                String estado = Estado_modi.getSelectedItem().toString();
                String url = Imagen.getAbsolutePath();
                Vehiculos vehiculo = new Vehiculos(placa, marca.getCodigo_marca(), estilo.getCodigo_estilo(), modelo.getCodigo_modelo(), transmision, año, Double.parseDouble(precio), Imagen, estado, url);
                FileInputStream foto = new FileInputStream(vehiculo.getFoto());

                String sql = "UPDATE vehiculo SET placa = ? , id_marca = ? , id_modelo = ? , id_estilo = ? , transmision = ?, ano = ?, precio = ?, foto = ?, estado = ?, url_foto_vehi = ? WHERE placa = '" + opci + "'";
                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setString(1, vehiculo.getPlaca_vehiculo());
                ps.setInt(2, vehiculo.getCodigo_marca());
                ps.setInt(3, vehiculo.getCodigo_modelo());
                ps.setInt(4, vehiculo.getCodigo_estilo());
                ps.setString(5, vehiculo.getTransmision_vehiculo());
                ps.setString(6, vehiculo.getAño());
                ps.setDouble(7, vehiculo.getPrecio());
                ps.setBinaryStream(8, foto, (int) vehiculo.getFoto().length());
                ps.setString(9, vehiculo.getEstado());
                ps.setString(10, vehiculo.getUrl());
                int z = ps.executeUpdate();
                if (z == 1) {
                    JOptionPane.showMessageDialog(null, "Se Modificó el Vehiculo de manera exitosa");
                    Llenarlista_modificar();
                    Placa_modi.setText("");
                    Año_modi.setText("");
                    Precio_modi.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar el Vehiculo!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al Modificar el Vehiculo , ya existe esa Placa " + e);
            }
        }
    }

}
