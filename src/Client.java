import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {

        System.out.println("connecting to my server");

        Socket newSocket = new Socket(
                "10.37.153.179",3256);
       OutputStream out = newSocket.getOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(out);
        objOut.writeObject("Trejo hi");
        objOut.writeObject("hi 2");
        objOut.writeObject("hi 3");

        data inData = new data();
        DataReader myDataReader = new DataReader(newSocket, inData);
        ProgramLogicDoor myDoer = new ProgramLogicDoor(inData);

        Thread dataReadingThread = new Thread(myDataReader);
        dataReadingThread.start();

        Thread ProgramLogicDoor = new Thread(myDoer);

        ProgramLogicDoor.start();
    }

}
