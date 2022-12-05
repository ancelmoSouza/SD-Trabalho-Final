package com.ClientUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {

    private DatagramSocket aSocket = null;
    private InetAddress inert;
    private byte[] buff;

    public Client() {

        try {
            this.aSocket = new DatagramSocket();
            this.inert = InetAddress.getByName("localhost");
            this.buff = new byte[1000];
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    public void sendRequest(String req) {
        try {
            this.buff =  req.getBytes();
            DatagramPacket packet = new DatagramPacket(buff, buff.length, inert, 6789);
            this.aSocket.send(packet);
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    public String getResponse() {
        String res = "";
        byte[] buffer = new byte[1000];

        try {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            this.aSocket.receive(packet);

            res = new String(packet.getData(), 0, packet.getLength());
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }

        return res;
    }

    public void close() throws SocketException{
        this.aSocket.close();
    }
}
