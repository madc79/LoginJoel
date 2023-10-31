package dad.login;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ModeloLogin {
    private Map<String, String> usersMap;

    public ModeloLogin() {
        // Inicializar y cargar los usuarios y contraseñas desde el archivo CSV
        usersMap = loadUsersFromCSV("/users.csv");
    }

    public boolean authenticateUser(String username, String password) {
        String hashedPassword = DigestUtils.md5Hex(password);

        // Verificar si el usuario y la contraseña coinciden con los datos cargados desde el archivo CSV
        return usersMap.containsKey(username) && usersMap.get(username).equals(hashedPassword);
    }

    private Map<String, String> loadUsersFromCSV(String csvResource) {
        Map<String, String> usersMap = new HashMap<>();
        try {
            InputStream is = ModeloLogin.class.getResourceAsStream(csvResource);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    String username = parts[0];
                    String hashedPassword = parts[1];
                    usersMap.put(username, hashedPassword);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersMap;
    }
}

