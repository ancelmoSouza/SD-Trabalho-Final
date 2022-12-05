package com.ServerUDP;

import com.Entitys.Livraria;
import com.Entitys.Livro;
import com.Entitys.Message;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        Livraria la = new Livraria();
        DatagramSocket aSocket = null;

        try {
            aSocket = new DatagramSocket(6789);

            while (true) {
                byte[] buffer = new byte[1000];
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                String req = new String(request.getData(), 0, request.getLength() );

                //Obtendo o JSON e chamando o método do serviço
                Gson gson = new Gson();
                System.out.println("Req: " + req);
                Message msg = gson.fromJson(req, Message.class);

                if(msg.getMethodId().equals("add")) {
                    String arg_ = new String(msg.getArguments(), 0, msg.getArguments().length);
                    Livro l = gson.fromJson(arg_, Livro.class);
                    la.addLivro(l);

                    req = "[200]: Operação realizada com sucesso";
                    buffer = req.getBytes();

                    DatagramPacket reply = new DatagramPacket(buffer, buffer.length, request.getAddress(), request.getPort());
                    aSocket.send(reply);
                } else  if(msg.getMethodId().equals("listall")) {
                    ArrayList<Livro> list = la.listLivros();

                    req = gson.toJson(list);
                    buffer = req.getBytes();

                    DatagramPacket reply = new DatagramPacket(buffer, buffer.length, request.getAddress(), request.getPort());
                    aSocket.send(reply);
                } else  if(msg.getMethodId().equals("rem")) {
                    String arg_ = new String(msg.getArguments(), 0, msg.getArguments().length);
                    Livro l = la.findLivroByTitulo(arg_);

                    if(l != null) {
                        la.removeLivro(l);

                        req = "200";
                        buffer = req.getBytes();

                        DatagramPacket reply = new DatagramPacket(buffer, buffer.length, request.getAddress(), request.getPort());
                        aSocket.send(reply);
                    } else {
                        req = "400";
                        buffer = req.getBytes();

                        DatagramPacket reply = new DatagramPacket(buffer, buffer.length, request.getAddress(), request.getPort());
                        aSocket.send(reply);
                    }
                } else  if(msg.getMethodId().equals("findbytitle")) {
                    String arg_ = new String(msg.getArguments(), 0, msg.getArguments().length);
                    Livro l = la.findLivroByTitulo(arg_);

                    if(l != null){
                        buffer = gson.toJson(l).getBytes();
                        DatagramPacket reply = new DatagramPacket(buffer, buffer.length, request.getAddress(), request.getPort());
                        aSocket.send(reply);
                    } else {
                        l = new Livro();
                        l.setIsbn("null");
                        l.setTitulo("null");
                        l.setNomeAutor("null");

                        req = gson.toJson(l);
                        buffer = req.getBytes();

                        DatagramPacket reply = new DatagramPacket(buffer, buffer.length, request.getAddress(), request.getPort());
                        aSocket.send(reply);
                    }

                } else {
                    System.out.println("Erro: Método inválido.");
                }

            }
        } catch (SocketException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if(aSocket != null) {
                aSocket.close();
            }
        }
    }
}
