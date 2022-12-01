package qxd.ufc.com.ClientUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {
    public static void main(String[] args) {
        DatagramSocket aSocket = null;
        String msg = "Hello Server";

        try {
            aSocket = new DatagramSocket();
            InetAddress inert = InetAddress.getByName("localhost");

            byte[] buff = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(buff, buff.length, inert, 6789);
            aSocket.send(packet);

            packet = new DatagramPacket(buff, buff.length);
            aSocket.receive(packet);

            String reply = new String(packet.getData(),0, packet.getLength());

            System.out.println("Reply: " +  reply);
        } catch (SocketException e){
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e){
            System.out.println("IO: " + e.getMessage());
        } finally {
            if(aSocket != null) {
                aSocket.close();
            }
        }
    }
}
