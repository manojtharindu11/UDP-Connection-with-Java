package basic;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8080);

        byte[] buffer = new byte[256];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet); // wait for client to send a packet

        String received = new String(packet.getData(), 0, packet.getLength());

        System.out.println("Received: " + received);

        String response = "Hello from the server!";

        byte[] responseData = response.getBytes();

        DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, packet.getAddress(), packet.getPort());

        socket.send(responsePacket);

        socket.close();
    }
}
