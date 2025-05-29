/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Utilidad para encriptar y verificar contraseñas usando BCrypt. Es estática
 * para ser usada en cualquier parte del sistema.
 *
 * @author SDavidLedesma
 */
public class EncriptadorUtil {

    /**
     * Encripta una contraseña en texto plano usando BCrypt.
     *
     * @param password Contraseña en texto plano.
     * @return Contraseña encriptada con BCrypt.
     */
    public static String encriptar(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    /**
     * Verifica si la contraseña proporcionada coincide con el hash.
     *
     * @param passwordPlain Contraseña en texto plano.
     * @param passwordHasheada Hash de contraseña en la base de datos.
     * @return true si la contraseña es válida, false en caso contrario.
     */
    public static boolean verificar(String passwordPlain, String passwordHasheada) {
        return BCrypt.checkpw(passwordPlain, passwordHasheada);
    }
}
