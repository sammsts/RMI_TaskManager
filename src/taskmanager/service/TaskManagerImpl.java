package taskmanager.service;

import taskmanager.model.Task;
import taskmanager.model.TaskManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TaskManagerImpl extends UnicastRemoteObject implements TaskManager {
    private List<Task> tarefas;
    private int idCounter;

    public TaskManagerImpl() throws RemoteException {
        tarefas = new ArrayList<>();
        idCounter = 1;
    }

    @Override
    public void adicionarTask(String descricao) throws RemoteException {
        Task novaTask = new Task(idCounter++, descricao);
        tarefas.add(novaTask);
    }

    @Override
    public List<String> listarTasks() throws RemoteException {
        List<String> taskList = new ArrayList<>();
        for (Task task : tarefas) {
            taskList.add("ID: " + task.getId() + " - " + task.getDescricao() + " - Concluída: " + task.isConcluida());
        }
        return taskList;
    }

    @Override
    public boolean marcarComoConcluida(int id) throws RemoteException {
        for (Task task : tarefas) {
            if (task.getId() == id && !task.isConcluida()) {
                task.marcarComoConcluida();
                return true;
            }
        }
        return false;
    }
}
