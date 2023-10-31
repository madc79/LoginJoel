package dad.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class VistaLogin extends Application {
    private TextField usuarioField;
    private PasswordField contrasenaField;
    private Button accederButton;
    private Button cancelarButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Inicio de Sesión");

        Label usuarioLabel = new Label("Usuario:");
        usuarioField = new TextField();
        usuarioField.setPromptText("Nombre de usuario");
        Label contrasenaLabel = new Label("Contraseña:");
        contrasenaField = new PasswordField();
        contrasenaField.setPromptText("Contraseña de usuario");
        CheckBox usarLDAPCheckBox = new CheckBox("Usar LDAP");
        accederButton = new Button("Acceder");
        cancelarButton = new Button("Cancelar");

        accederButton.setDefaultButton(true);

        accederButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"); // Cambiar el color de fondo del botón

        accederButton.setOnAction(event -> {
            String usuario = usuarioField.getText();
            String contrasena = contrasenaField.getText();
            boolean usarLDAP = usarLDAPCheckBox.isSelected();
            // Verificar las credenciales y el estado del checkbox y realizar acciones correspondientes
        });

        cancelarButton.setOnAction(event -> {
            usuarioField.clear();
            contrasenaField.clear();
        });

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setAlignment(Pos.CENTER);

        HBox checkBoxHBox = new HBox();
        checkBoxHBox.getChildren().add(usarLDAPCheckBox);
        checkBoxHBox.setAlignment(Pos.CENTER);

        HBox buttonHBox = new HBox();
        buttonHBox.getChildren().addAll(accederButton, cancelarButton);
        buttonHBox.setSpacing(10);
        buttonHBox.setAlignment(Pos.CENTER);

        grid.add(usuarioLabel, 0, 0);
        grid.add(usuarioField, 1, 0);
        grid.add(contrasenaLabel, 0, 1);
        grid.add(contrasenaField, 1, 1);
        grid.add(checkBoxHBox, 0, 2, 2, 1);
        grid.add(buttonHBox, 0, 3, 2, 1);

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public TextField getUsuarioField() {
        return usuarioField;
    }

    public PasswordField getContrasenaField() {
        return contrasenaField;
    }

    public Button getAccederButton() {
        return accederButton;
    }

    public Button getCancelarButton() {
        return cancelarButton;
    }
}







