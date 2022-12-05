package com.ClientUDP;

import com.Entitys.Message;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

public class Proxy {
    private Client client;
    private int count;

    public Proxy() {
        this.client = new Client();
        this.count = 0;
    }

    // Metodos do Proxy baseados no serviço
//    public void addLivro (String title, String authorName, String isbn) {
//        List<String> arg = new ArrayList<String>();
//        arg.add("title:" + title);
//        arg.add("author:" + authorName);
//        arg.add("isbn:" + authorName);
//
//        byte[] reply = doOperation("server", "add", arg);
//    }
//
//    public void removeLivro(Livro l) {
//
//    }
//
//    public Livro findLivroByTitulo(String titulo) {
//
//    }
//
//    public Livro findLivroByIsbn(String isbn) {
//
//    }
//
//    public ArrayList<Livro> listLivros();

    // Métodos de Serialização e desserialização
    public byte[] doOperation(String objReference, String methodId, List<String> arguments) {
        String request = packMessage(0, count++, objReference, methodId, arguments);

        //Envio da requisição
        this.client.sendRequest(request);

        //Recebimento da resposta
        Message response = unpackMessage(this.client.getResponse());

        return response.getArguments();
    }


    private String packMessage(int msgType, int requestId, String objReference, String methodId, List<String> arguments) {
        Gson gson = new Gson();

        Message msg = new Message();
        msg.setMessageTyppe(msgType);
        msg.setRequestId(requestId);
        msg.setObjectreference(objReference);
        msg.setMethodId(methodId);
        msg.setArguments(gson
                .toJson(arguments)
                .getBytes());

        String packet = gson.toJson(msg);

        return packet;
    }

    private Message unpackMessage(String res) {
        Gson gson = new Gson();
        Message msg = gson.fromJson(res, Message.class);

        return msg;
    }

    public void finaliza() {
        try {
            this.client.close();
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

}
