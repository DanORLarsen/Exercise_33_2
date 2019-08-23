import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Exercise_33_2Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",1);
            System.out.println("Connected");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            BMI bmi = new BMI(80,1.80);
            objectOutputStream.writeObject(bmi);
            System.out.println("object sent");
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            System.out.println("objectInputStream created");
            bmi = null;
            bmi = (BMI) objectInputStream.readObject();
            System.out.println("Object Received");
            System.out.println("Your BMI is: " + bmi.getBMI());


        } catch (IOException e) {
            System.out.println("Client Crashed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
