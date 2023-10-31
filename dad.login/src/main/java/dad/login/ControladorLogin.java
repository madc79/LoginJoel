package dad.login;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControladorLogin {
    private ModeloLogin modelo;
    private VistaLogin vista;

    public ControladorLogin(ModeloLogin modelo, VistaLogin vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Manejo de eventos para el botón "Acceder"
        vista.getAccederButton().setOnAction(event -> {
            String username = vista.getUsuarioField().getText();
            String password = vista.getContrasenaField().getText();

            if (modelo.authenticateUser(username, password)) {
                mostrarMensaje("Acceso permitido\n\nLas credenciales de acceso son válidas");
                // Cerrar la ventana al presionar "Acceder"
                cerrarVentana();
            } else {
                mostrarMensaje("Acceso denegado\n\nCredenciales incorrectas");
                // Limpiar el campo de contraseña
                vista.getContrasenaField().clear();
            }
        });

        // Manejo de eventos para el botón "Cancelar"
        vista.getCancelarButton().setOnAction(event -> {
            // Cerrar la ventana al presionar "Cancelar"
            cerrarVentana();
        });
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) vista.getCancelarButton().getScene().getWindow();
        stage.close();
    }
}








