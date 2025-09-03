import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.*;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        
        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(8080), 0);
        server.createContext("/hello", new HelloHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080");
    }

    
    static class HelloHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            // Message to send to front end
            String response = "Hello World from Basic Java!";
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
             os.close();
        }
    }
}
