import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Poo";
        String user = "root";
        String password = "";

        String sql = "INSERT INTO estudiantes (cedula, nombre, b1, b2) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement cadenaPreparada = connection.prepareStatement(sql);

            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese la cédula: ");
            String cedula = scanner.nextLine();

            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la nota de b1: ");
            Double b1 = scanner.nextDouble();

            System.out.print("Ingrese la nota de b2: ");
            Double b2 = scanner.nextDouble();

            Estudiante estudiante = new Estudiante(cedula, nombre, b1, b2);

            cadenaPreparada.setString(1, estudiante.getCedula());
            cadenaPreparada.setString(2, estudiante.getNombre());
            cadenaPreparada.setDouble(3, estudiante.getB1());
            cadenaPreparada.setDouble(4, estudiante.getB2());

            cadenaPreparada.executeUpdate();
            System.out.println("Datos insertados");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
