import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class client extends Frame implements Runnable,ActionListener

{
    TextField textField;
    TextArea textarea;
    Button send;

    Socket socket;

    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    Thread chat;

    client(){
        textField =new TextField();
        textarea=new TextArea();
        send=new Button("Send");

        send.addActionListener(this);

        try{

            socket =new Socket("LocalHost",1000);

            dataInputStream =new DataInputStream(socket.getInputStream());
            dataOutputStream=new DataOutputStream(socket.getOutputStream());
        }
        catch(Exception e){

        }

        add(textField);
        add(textarea);
        add(send);

        chat=new Thread(this);
        chat.setDaemon(true);
        chat.start();

        setSize(500,500);
        setTitle("Client");
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String msg=textField.getText();
        textarea.append("Client:"+msg+"\n");
        textField.setText("");

        try{
            dataOutputStream.writeUTF(msg);
            dataOutputStream.flush();
        }catch( IOException ex){

        }
    }

    public static void main(String[] args) {
        new client();
    }

    public void run(){
        while(true){
            try{
                String msg=dataInputStream.readUTF();
                textarea.append("Server:"+msg+"\n");
            }catch (Exception e){

            }
        }
    }
}

