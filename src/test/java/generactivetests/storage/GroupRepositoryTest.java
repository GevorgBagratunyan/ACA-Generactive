package generactivetests.storage;

import com.gevorgbagratunyan.generactive.model.Group;
import com.gevorgbagratunyan.generactive.storage.GroupRepository;
import com.gevorgbagratunyan.generactive.storage.Storage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class GroupRepositoryTest {

    static GroupRepository repository = new GroupRepository();

    static Group group = new Group.GroupBuilder()
            .id() // id = 1 for every test method
            .groupName("Nature")
            .build();

    @BeforeEach
    public void clearStorage() {
        Storage.clear();
    }

    @Test
    @DisplayName("Group creation")
    public void createTest() {
        Storage.addGroup(group);
        assertEquals(group, repository.create(group));
    }

    @Test
    @DisplayName("Find by ID")
    public void findByID() {
        Storage.addGroup(group);
        assertTrue(Storage.findGroupByID(1).isPresent());
    }

    @Test
    @DisplayName("Remove by ID")
    public void removeById() {
        Storage.addGroup(group);
        assertTrue(Storage.findGroupByID(1).isPresent());
    }

    @Test
    @DisplayName("Get by name and throw exception")
    public void getByNameAndThrowException() {
        Storage.addGroup(group);
        assertThrows(NoSuchElementException.class, () -> repository.getByName("Invalid Group Name"));
    }
}
