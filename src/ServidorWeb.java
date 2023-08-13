import java.io.*;
import java.net.*;
import java.util.*;

public final class ServidorWeb {
    public static void main(String[] args) throws Exception{
        // Establecer el # del puerto
        int puerto = 6789;

        // Estableciendo el socket de escucha
        ServerSocket concurrentServer = new ServerSocket(puerto);

        // Procesando las solicitudes HTTP en un ciclo infinito
        while (true){
            // Escuchando las solicitudes de conexión TCP
            Socket clientSocket = concurrentServer.accept();

            // Construye un objeto para procesar el msj de solicitud HTTP
            SolicitudHttp solicitud = new SolicitudHttp(clientSocket);

            // Crea u nuevo hilo para procesar la solicitud
            Thread thread = new Thread(solicitud);

            thread.start();
        }
    }
}
