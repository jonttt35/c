import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {

        String message = "No more oreos";
        System.out.println("creating a socket for communication");
        ServerSocket mySocket = new ServerSocket(3256);
        Socket newSocket = mySocket.accept();
        System.out.println("communication starter");

        data inData = new data();
        DataReader myDataReader = new DataReader(newSocket, inData);
        ProgramLogicDoor myDoer = new ProgramLogicDoor(inData);

        Thread dataReadingThread = new Thread(myDataReader);
        dataReadingThread.start();

        Thread ProgramLogicDoor = new Thread(myDoer);

        ProgramLogicDoor.start();
    }

}
