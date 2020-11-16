package manager;

import domain.Assignee;
import domain.Author;
import domain.Label;
import domain.TestIssue;
import repository.TestIssueRepository;

import java.util.*;
import java.util.function.Predicate;

public class TestIssueManager {

    private TestIssueRepository repository;

    public TestIssueManager(TestIssueRepository repository) {
        this.repository = repository;
    }

    public void add(TestIssue item) {
        repository.add(item);
    }

    public List<TestIssue> filterBy(Predicate<TestIssue> predicate, Comparator<TestIssue> comparator) {
        List<TestIssue> tmp = new ArrayList<>();
        for (TestIssue item : repository.findAll()) {
            if (predicate.test(item)) {
                tmp.add(item);
            }
        }
        tmp.sort(comparator);
        return tmp;
    }

    public List<TestIssue> filterByAuthor(Author author, Comparator<TestIssue> comparator) {
        Predicate<TestIssue> predicateAuthor = testManagementSystem -> testManagementSystem.getAuthor().equals(author);
        return filterBy(predicateAuthor, comparator);
    }

    public List<TestIssue> filterByLabel(Label label, Comparator<TestIssue> comparator) {
        Predicate<TestIssue> predicateLabel = testManagementSystem -> testManagementSystem.getLabel().equals(label);
        return filterBy(predicateLabel, comparator);
    }

    public List<TestIssue> filterByAssignee(Assignee assignee, Comparator<TestIssue> comparator) {
        Predicate<TestIssue> predicateAssignee = testManagementSystem -> testManagementSystem.getAssignee().equals(assignee);
        return filterBy(predicateAssignee, comparator);
    }

    public List<TestIssue> findOpen() {
        List<TestIssue> tmp = new ArrayList<>();
        for (TestIssue item : repository.findAll()) {
            if (item.isOpen()) {
                tmp.add(item);
            }
        }
        return tmp;
    }

    public List<TestIssue> findClosed() {
        List<TestIssue> tmp = new ArrayList<>();
        for (TestIssue item : repository.findAll()) {
            if (item.isClosed()) {
                tmp.add(item);
            }
        }
        return tmp;
    }
}
