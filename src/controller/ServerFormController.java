package controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : Hasitha Lakshan
 * Project :chatApplication
 * Date :8/3/2022
 * Time :8:49 AM
 */

public class ServerFormController {
    public JFXTextArea txtArea;
    public JFXTextField txtMsg;

    final int PORT=5000;

    ServerSocket serverSocket;
    Socket accept;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String message ="";

    public void initialize(){
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                System.out.println("Server Started");
                accept=serverSocket.accept();
                System.out.println("Client Connected");



                dataOutputStream=new DataOutputStream(accept.getOutputStream());
                dataInputStream=new DataInputStream(accept.getInputStream());


                message=dataInputStream.readUTF();
                System.out.println(message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void sendOnAction(ActionEvent actionEvent) {
    }
}
