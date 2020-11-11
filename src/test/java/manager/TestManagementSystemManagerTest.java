package manager;

import TMSComparator.TMSComparator;
import domain.Assignee;
import domain.Author;
import domain.Label;
import domain.TestManagementSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TestManagementSystemRepository;

import java.util.*;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class TestManagementSystemManagerTest {
    TestManagementSystemRepository repository = new TestManagementSystemRepository();
    TestManagementSystemManager manager = new TestManagementSystemManager(repository);
    TMSComparator comparator = new TMSComparator();
    TestManagementSystem one = new TestManagementSystem(1, new Author(1, "Coursar"), true, false, new Label(1, "bug"), new Assignee(1, "Nemeziz1"));
    TestManagementSystem two = new TestManagementSystem(2, new Author(2, "Nemeziz1"), false, true, new Label(2, "documentation"), new Assignee(2, "Coursar"));
    TestManagementSystem three = new TestManagementSystem(3, new Author(3, "solarrust"), true, false, new Label(3, "duplicate"), new Assignee(1, "Nemeziz1"));
    TestManagementSystem four = new TestManagementSystem(4, new Author(2, "Nemeziz1"), false, true, new Label(4, "question"), new Assignee(3, "solarrust"));

    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
    }

    @Test
    public void shouldFindOpen() {
        List<TestManagementSystem> actual = manager.findOpen();
        List<TestManagementSystem> expected = Arrays.asList(one, three);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindClosed() {
        List<TestManagementSystem> actual = manager.findClosed();
        List<TestManagementSystem> expected = Arrays.asList(two, four);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAuthor() {
        List<TestManagementSystem> actual = manager.filterByAuthor(new Author(2, "Nemeziz1"), comparator);
        List<TestManagementSystem> expected = Arrays.asList(two, four);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByLabel() {
        List<TestManagementSystem> actual = manager.filterByLabel(new Label(1, "bug"), comparator);
        List<TestManagementSystem> expected = Collections.singletonList(one);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFilterByAssignee() {
        List<TestManagementSystem> actual = manager.filterByAssignee(new Assignee(3, "solarrust"), comparator);
        List<TestManagementSystem> expected = Collections.singletonList(four);
        assertEquals(expected, actual);
    }

    @Test
    public void notFoundByAuthor() {
        List<TestManagementSystem> actual = manager.filterByAuthor(new Author(4, "NetologyTeacher"), comparator);
        List<TestManagementSystem> expected = Collections.emptyList();
        assertEquals(expected, actual);
    }

    @Test
    public void notFoundByLabel() {
        List<TestManagementSystem> actual = manager.filterByLabel(new Label(5, "enhancement"), comparator);
        List<TestManagementSystem> expected = Collections.emptyList();
        assertEquals(expected, actual);
    }

    @Test
    public void notFoundByAssignee() {
        List<TestManagementSystem> actual = manager.filterByAssignee(new Assignee(4, "NetologyTeacher"), comparator);
        List<TestManagementSystem> expected = Collections.emptyList();
        assertEquals(expected, actual);
    }
}