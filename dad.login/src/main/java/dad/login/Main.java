package dad.login;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Crear las instancias del modelo, vista y controlador
        ModeloLogin modelo = new ModeloLogin();
        VistaLogin vista = new VistaLogin();
        ControladorLogin controlador = new ControladorLogin(modelo, vista);

        // Mostrar la ventana de inicio de sesión
        vista.start(primaryStage);

        // Definir un manejador para el evento de acceso permitido en el controlador
        controlador.setAccesoPermitidoHandler(() -> {
            System.out.println("Acceso permitido");
            // Realizar acciones adicionales cuando el acceso es válido
        });

        // Definir un manejador para el evento de acceso denegado en el controlador
        controlador.setAccesoDenegadoHandler(() -> {
            System.out.println("Acceso denegado");
            // Realizar acciones adicionales cuando el acceso es denegado
            // Por ejemplo, borrar el contenido del campo de contraseña
            vista.getContrasenaField().clear();
        });
    }
}



