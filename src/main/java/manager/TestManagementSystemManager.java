package manager;

import domain.Assignee;
import domain.Author;
import domain.Label;
import domain.TestManagementSystem;
import repository.TestManagementSystemRepository;

import java.util.*;
import java.util.function.Predicate;

public class TestManagementSystemManager {

    private TestManagementSystemRepository repository;

    public TestManagementSystemManager(TestManagementSystemRepository repository) {
        this.repository = repository;
    }

    public void add(TestManagementSystem item) {
        repository.add(item);
    }

    public List<TestManagementSystem> filterBy(Predicate<TestManagementSystem> predicate, Comparator<TestManagementSystem> comparator) {
        List<TestManagementSystem> tmp = new ArrayList<>();
        for (TestManagementSystem item : repository.findAll()) {
            if (predicate.test(item)) {
                tmp.add(item);
            }
        }
        tmp.sort(comparator);
        return tmp;
    }

    public List<TestManagementSystem> filterByAuthor(Author author, Comparator<TestManagementSystem> comparator) {
        Predicate<TestManagementSystem> predicateAuthor = testManagementSystem -> testManagementSystem.getAuthor().equals(author);
        return filterBy(predicateAuthor, comparator);
    }

    public List<TestManagementSystem> filterByLabel(Label label, Comparator<TestManagementSystem> comparator) {
        Predicate<TestManagementSystem> predicateLabel = testManagementSystem -> testManagementSystem.getLabel().equals(label);
        return filterBy(predicateLabel, comparator);
    }

    public List<TestManagementSystem> filterByAssignee(Assignee assignee, Comparator<TestManagementSystem> comparator) {
        Predicate<TestManagementSystem> predicateAssignee = testManagementSystem -> testManagementSystem.getAssignee().equals(assignee);
        return filterBy(predicateAssignee, comparator);
    }

    public List<TestManagementSystem> findOpen() {
        List<TestManagementSystem> tmp = new ArrayList<>();
        for (TestManagementSystem item : repository.findAll()) {
            if (item.isOpen()) {
                tmp.add(item);
            }
        }
        return tmp;
    }

    public List<TestManagementSystem> findClosed() {
        List<TestManagementSystem> tmp = new ArrayList<>();
        for (TestManagementSystem item : repository.findAll()) {
            if (item.isClosed()) {
                tmp.add(item);
            }
        }
        return tmp;
    }
}
