package HomeWork1.client;

import HomeWork1.server.ServerController;

public class ClientController {
    private boolean connected;
    private String clientName;
    private ClientView clientView;
    private ServerController server;

    public ClientController(ClientView clientView, ServerController server) {
        this.clientView = clientView;
        this.server = server;
        clientView.setClientController(this);
    }

    public void setClientView(ClientView clientView) {
        this.clientView = clientView;
    }
    public void setServer(ServerController server) {
        this.server = server;
    }

    public void disconnectFromServer() {
        server.disconnectUserFromServer(this);
    }
    public boolean connectToServer(String name) {
        this.clientName = name;
        if (server.connectUserToServer(this)) {
            showInfo("Подключение выполнено");
            connected = true;
            String log = server.getLog();
            if (log != null) {
                showInfo(log);
            } else {
                System.out.println("log is empty");
            }
            return true;
        } else {
            showInfo("Подключение не выполнено");
            return false;
        }
    }

    public void message(String text) {
        if (connected) {
            if (!text.equals("")) {
                server.message(clientName + ": " + text);
            }
        } else {
            server.message("Сервер не подключен");
        }
    }

    public void showInfo(String text) {
        clientView.showMessage(text);
    }

    public String getClientName() {
        return clientName;
    }
}
