import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Exercise_33_2Server {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        {
            try {
                //Creates the server socket at port 1
                serverSocket = new ServerSocket(1);
                System.out.println("server running");
                while (true){
                    //Creates a socket that listen to when someone connects to port one on this IP.
                    Socket socket = serverSocket.accept();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    System.out.println("Client connected to server");
                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    //Gets the BMI object from the client
                    BMI object = (BMI) objectInputStream.readObject();
                    System.out.println("OBJECT RECEIVED");
                    if(object.getHeight()==0)
                    {break;}
                    object.calculateBMI();
                    System.out.println("BMI calculated to " + object.getBMI());
                    objectOutputStream.writeObject(object);
                    objectOutputStream.flush();
                    System.out.println("Object sent back");
                    //objectInputStream.close();
                }
                //objectOutputStream.close();

            } catch (IOException e) {
                System.out.println("shit Crashed");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
