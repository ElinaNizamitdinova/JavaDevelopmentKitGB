package HomeWork1;

import HomeWork1.client.ClientController;
import HomeWork1.client.ClientGUI;
import HomeWork1.server.FileStorage;
import HomeWork1.server.ServerController;
import HomeWork1.server.ServerGUI;

public class Main { public static void main(String[] args) {
    ServerController serverController = new ServerController(new ServerGUI(), new FileStorage());

    new ClientController(new ClientGUI(), serverController);
    new ClientController(new ClientGUI(), serverController);
}
}
