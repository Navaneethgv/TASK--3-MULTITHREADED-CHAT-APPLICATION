import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server extends Frame implements Runnable,ActionListener

{
    TextField textField;
    TextArea textarea;
    Button send;

    ServerSocket serverSocket;
    Socket socket;

    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    Thread chat;

    server(){
        textField =new TextField();
        textarea=new TextArea();
        send=new Button("Send");

        send.addActionListener(this);

        try{
            serverSocket=new ServerSocket(1000);
            socket =serverSocket.accept();

            dataInputStream =new DataInputStream(socket.getInputStream());
            dataOutputStream=new DataOutputStream(socket.getOutputStream());
        }
        catch(IOException e){

        }

        add(textField);
        add(textarea);
        add(send);

        chat=new Thread(this);
        chat.setDaemon(true);
        chat.start();

        setSize(500,500);
        setTitle("Server");
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String msg=textField.getText();
        textarea.append("Server:"+msg+"\n");
        textField.setText("");

        try{
            dataOutputStream.writeUTF(msg);
            dataOutputStream.flush();
        }catch( IOException exp){

        }
    }

    public static void main(String[] args) {
        new server();
    }

    public void run(){
        while(true){
            try{
                String msg=dataInputStream.readUTF();
                textarea.append("Client:"+msg+"\n");
            }catch (Exception e){

            }
        }
    }
}

