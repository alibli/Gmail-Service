package server;


import utility.Member;
import utility.Message;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerHandler {
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    static ArrayList<Member> list_users = new ArrayList<>();


    ServerHandler(Socket socket, ObjectInputStream inputStream, ObjectOutputStream outputStream) {
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }


    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }


    void handle(Message message) throws IOException, ClassNotFoundException {
        switch (message.getMessageType()) {

          /*  case login:
                 break;
*/
            case CreateAccount:
                System.out.println("hello");
                Member member;  /////////////////
                member = (Member) inputStream.readObject();
                  System.out.println(member);

                  System.out.println("hello1");
                list_users.add(member);

                FileOutputStream newUserFile = new FileOutputStream("src/store/Members/"+member.getUsername()+".txt");
                ObjectOutputStream obj = new ObjectOutputStream(newUserFile);
                obj.writeObject(member);
                obj.close();
                newUserFile.close();
                break;
        }
    }



}
