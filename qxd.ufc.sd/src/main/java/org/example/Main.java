package org.example;

import com.google.gson.Gson;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SocketException {
        Gson gson = new Gson();

        List<String> msg = new ArrayList<String>();
        msg.add("title:bleach");
        msg.add("author:tite kubo");
        msg.add("isbn:123");

        String json = gson.toJson(msg);

        System.out.println(json);
        /*String option = "";
        Scanner in = new Scanner(System.in);

        while(true) {
            Client client = new Client();
            System.out.println("(1) -> Add Novo Livro\n" +
                    "(2) -> Remover Livro\n" +
                    "(3) -> Buscar Livro\n" +
                    "(4) -> Listar todos os livros\n" +
                    "(5) -> Sair");

            System.out.print("Opção: ");
            option = in.nextLine();

            if (option.equals("1")) {
                String title = "";
                String author = "";
                String isbn = "";

                System.out.print("Titulo: ");
                title = in.nextLine();

                System.out.print("Nome do Author: ");
                author = in.nextLine();

                System.out.print("ISBN: ");
                isbn = in.nextLine();

                Livro l = new Livro(title, author, isbn);

                Gson gson = new Gson();

                String arg = gson.toJson(l);

                Message msg = new Message();
                msg.setRequestId(1);
                msg.setMessageTyppe(1);
                msg.setMethodId("add");
                msg.setObjectreference("server");
                msg.setArguments(arg.getBytes());

                arg = gson.toJson(msg);

                client.sendRequest(arg);

                arg = client.getResponse();

                System.out.println(arg);
                try {
                    client.close();
                } catch (SocketException e) {
                    System.out.println("Socket: " + e.getMessage());
                }
            } else if(option.equals("2")) {
                System.out.print("Titulo do livro a ser removido: ");
                String title = in.nextLine();

                Gson gson = new Gson();

                Message msg = new Message();
                msg.setRequestId(1);
                msg.setMessageTyppe(1);
                msg.setMethodId("rem");
                msg.setObjectreference("server");
                msg.setArguments(title.getBytes());

                client.sendRequest(gson.toJson(msg));
                String res = client.getResponse();

                if(res.equals("400"))
                    System.out.println("Resposta >> [400]: Falha na operação. Objeto não encotrado");
                else
                    System.out.println("Resposta >> [200]: Operação concluída com sucesso.");

                client.close();

            } else if(option.equals("3")) {
                System.out.print("Titulo do livro a ser buscado: ");
                String title = in.nextLine();

                Gson gson = new Gson();

                Message msg = new Message();
                msg.setRequestId(1);
                msg.setMessageTyppe(1);
                msg.setMethodId("findbytitle");
                msg.setObjectreference("server");
                msg.setArguments(title.getBytes());

                client.sendRequest(gson.toJson(msg));
                String res = client.getResponse();
                Livro l = gson.fromJson(res, Livro.class);

                if(l.getIsbn().equals("null"))
                    System.out.println("Resposta >> [400]: Falha na operação. Objeto não encotrado");
                else
                    System.out.println("Resposta >> [200]: Livro -> " + l.toString());

                client.close();

            } else if(option.equals("4")) {

                Gson gson = new Gson();

                String arg = "";

                Message msg = new Message();
                msg.setRequestId(1);
                msg.setMessageTyppe(1);
                msg.setMethodId("listall");
                msg.setObjectreference("server");
                msg.setArguments(arg.getBytes());

                //Enviando requisiçãi ao servidor
                arg = gson.toJson(msg);
                client.sendRequest(arg);

                //Recebendo respota do servidor
                arg = client.getResponse();

                //Definindo tipo para ArrayList<Livor> para o Gson poder deserializar
                Type livrariaType = new TypeToken<ArrayList<Livro>>(){}.getType();
                ArrayList<Livro> la = gson.fromJson(arg, livrariaType);

                for (Livro aux : la) {
                    System.out.println(aux.toString());
                }

                try {
                    client.close();
                } catch (SocketException e) {
                    System.out.println("Socket: " + e.getMessage());
                }

            } else if(option.equals("5")) {
                break;
            }else {
                System.out.println("Erro: Invalid Operation \n");
            }
        }*/
    }
}













