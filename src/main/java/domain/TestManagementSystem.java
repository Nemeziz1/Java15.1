package domain;

import java.util.HashSet;
import java.util.Set;

public class TestManagementSystem {
    private int id;
    private Set<String> author = new HashSet<>();
    private boolean open;
    private boolean closed;
    private Set<String> label = new HashSet<>();
    private Set<String> assignee = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<String> getAuthor() {
        return author;
    }

    public void setAuthor(Set<String> author) {
        this.author = author;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Set<String> getLabel() {
        return label;
    }

    public void setLabel(Set<String> label) {
        this.label = label;
    }

    public Set<String> getAssignee() {
        return assignee;
    }

    public void setAssignee(Set<String> assignee) {
        this.assignee = assignee;
    }
}
