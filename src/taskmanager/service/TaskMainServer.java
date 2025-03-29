package taskmanager.service;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TaskMainServer {
    public static void main(String[] args) {
        try {
            TaskManagerImpl servidor = new TaskManagerImpl();
            Registry registry = LocateRegistry.createRegistry(1099); // Cria o registro RMI
            Naming.rebind("rmi://localhost/TaskManager", servidor);
            System.out.println("Servidor RMI pronto.");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
