package taskmanager.model;

import java.io.Serializable;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String descricao;
    private boolean concluida;

    public Task(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.concluida = false;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarComoConcluida() {
        this.concluida = true;
    }
}
