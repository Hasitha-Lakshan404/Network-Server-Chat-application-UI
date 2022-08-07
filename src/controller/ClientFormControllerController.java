package controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : Hasitha Lakshan
 * Project :chatApplication
 * Date :8/3/2022
 * Time :8:50 AM
 */

public class ClientFormControllerController {

    public JFXTextArea txtAreaClient;
    public JFXTextField txtMsgClient;

    final int PORT=5000;

    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String message ="";

    public void initialize(){
        new Thread(() -> {
            try {
                socket=new Socket("localhost",PORT);
                dataOutputStream=new DataOutputStream(socket.getOutputStream());
                dataInputStream=new DataInputStream(socket.getInputStream());

                message=dataInputStream.readUTF();
                System.out.println(message);
                txtAreaClient.appendText("\nserver: "+message);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void sendOnAction(ActionEvent actionEvent) throws IOException {
        txtAreaClient.appendText("\nyou: "+txtMsgClient.getText().trim());
        dataOutputStream.writeUTF(txtMsgClient.getText().trim());//trim is used to remove spaces the given word
        dataOutputStream.flush();

    }
}
