package repository;

import domain.TestManagementSystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class TestManagementSystemRepository {
    private Collection<TestManagementSystem> items = new ArrayList<>();

    public void add(TestManagementSystem item) {
        items.add(item);
    }

    public TestManagementSystem findOpen(boolean open) {
        for (TestManagementSystem item : items) {
            if (item.isOpen()) {
                return item;
            }
        }
        return null;
    }

    public TestManagementSystem findClosed(boolean closed) {
        for (TestManagementSystem item : items) {
            if (item.isClosed()) {
                return item;
            }
        }
        return null;
    }


    public TestManagementSystem filterByAuthor(Predicate<TestManagementSystem> author) {
        for (TestManagementSystem item : items) {
            if (item.getAuthor().equals(author)) {
                return item;
            }
        }
        return null;
    }

    public TestManagementSystem filterByLabel(Predicate<TestManagementSystem> label) {
        for (TestManagementSystem item : items) {
            if (item.getLabel().equals(label)) {
                return item;
            }
        }
        return null;
    }

    public TestManagementSystem filterByAssignee(Predicate<TestManagementSystem> assignee) {
        for (TestManagementSystem item : items) {
            if (item.getAssignee().equals(assignee)) {
                return item;
            }
        }
        return null;
    }
}



