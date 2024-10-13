import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String message = "Hello Server!";

        byte[] buffer = message.getBytes();

        DatagramPacket packet = new DatagramPacket(buffer,buffer.length,InetAddress.getByName("localhost"),8080);

        socket.send(packet); //Sent packet to the server

        byte[] responseBuffer = new byte[256];
        DatagramPacket responsePacket = new DatagramPacket(responseBuffer,responseBuffer.length);

        socket.receive(responsePacket); //Wait from the response from the server

        String response = new String(responsePacket.getData(),0,responsePacket.getLength());

        System.out.println("Server response : " + response);

        socket.close();
    }
}
