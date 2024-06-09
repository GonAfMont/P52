package P52;

import java.sql.*;

public class OpCRUD {

    // Métodos para Provincias
    public void insertarProvincia(Provincias provincia) {
        String sql = "INSERT INTO dbo.provincias (Provincia, NombreProvincia) VALUES (?, ?)";
        
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, provincia.getProvincia());
            pstmt.setString(2, provincia.getNombreProvincia());
            pstmt.executeUpdate();

            // Obtener el ID generado automáticamente si es necesario
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    provincia.setProvincia(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("No se pudo obtener el ID de la provincia insertada.");
                }
            }
            System.out.println("Provincia insertada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void leerProvincias() {
        String sql = "SELECT * FROM dbo.provincias";
        
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Provincia: " + rs.getInt("Provincia"));
                System.out.println("NombreProvincia: " + rs.getString("NombreProvincia"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProvincia(Provincias provincia) {
        String sql = "UPDATE dbo.provincias SET NombreProvincia = ? WHERE Provincia = ?";
        
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, provincia.getNombreProvincia());
            pstmt.setInt(2, provincia.getProvincia());
            pstmt.executeUpdate();
            System.out.println("Provincia actualizada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrarProvincia(int id) {
        String sql = "DELETE FROM dbo.provincias WHERE Provincia = ?";
        
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Provincia borrada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos para Categorias
    public void insertarCategoria(Categorias categoria) {
        String sql = "INSERT INTO dbo.categorias (Categoria, Descripcion) VALUES (?, ?)";
        
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, categoria.getCategoria());
            pstmt.setString(2, categoria.getDescripcion());
            pstmt.executeUpdate();
            System.out.println("Categoría insertada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void leerCategorias() {
        String sql = "SELECT * FROM dbo.categorias";
        
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Categoria: " + rs.getString("Categoria"));
                System.out.println("Descripcion: " + rs.getString("Descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCategoria(Categorias categoria) {
        String sql = "UPDATE dbo.categorias SET Descripcion = ? WHERE Categoria = ?";
        
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, categoria.getDescripcion());
            pstmt.setString(2, categoria.getCategoria());
            pstmt.executeUpdate();
            System.out.println("Categoría actualizada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrarCategoria(String categoria) {
        String sql = "DELETE FROM dbo.categorias WHERE Categoria = ?";
        
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, categoria);
            pstmt.executeUpdate();
            System.out.println("Categoría borrada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos para Contactos (ya existentes)
    public void insertarContacto(Contactos contacto) {
        String sql = "INSERT INTO dbo.contactos (Nombre, Apellidos, DNI, Telefono, Ecorreo, Fechacumple, Direccion, Poblacion, Provincia, CodigoPostal, Categoria, Deuda) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getApellidos());
            pstmt.setString(3, contacto.getDni());
            pstmt.setString(4, contacto.getTelefono());
            pstmt.setString(5, contacto.getEcorreo());
            pstmt.setDate(6, java.sql.Date.valueOf(contacto.getFechaCumple()));
            pstmt.setString(7, contacto.getDireccion());
            pstmt.setString(8, contacto.getPoblacion());
            pstmt.setInt(9, contacto.getProvincia());
            pstmt.setString(10, contacto.getCodigoPostal());
            pstmt.setString(11, contacto.getCategoria());
            pstmt.setInt(12, contacto.getDeuda());
            pstmt.executeUpdate();

            // Obtener el ID generado automáticamente
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    contacto.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("No se pudo obtener el ID del contacto insertado.");
                }
            }
            System.out.println("Contacto insertado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void leerContactos() {
        String sql = "SELECT * FROM dbo.contactos";
        
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Id_contacto: " + rs.getInt("Id_contacto"));
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Apellidos: " + rs.getString("Apellidos"));
                // Imprimir otros campos según sea necesario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarContacto(Contactos contacto) {
        String sql = "UPDATE dbo.contactos SET Telefono = ?, Ecorreo = ? WHERE Id_contacto = ?";
        
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, contacto.getTelefono());
            pstmt.setString(2, contacto.getEcorreo());
            pstmt.setInt(3, contacto.getId());
            pstmt.executeUpdate();
            System.out.println("Contacto actualizado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void borrarContacto(int id) {
        String sql = "DELETE FROM dbo.contactos WHERE Id_contacto = ?";
        
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Contacto borrado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
