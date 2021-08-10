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
            .id()
            .groupName("Nature")
            .build();

    @BeforeEach
    void setUpOneGroup() {
        Storage.addGroup(group);
    }

    @Test
    @DisplayName("Group creation")
    public void createTest() {

        assertEquals(group, repository.create(group));
    }

    @Test
    @DisplayName("Find by ID")
    public void findByID() {
         assertNotNull(Storage.findGroupByID(1).get());
    }

    @Test
    @DisplayName("Remove by ID")
    public  void removeById() {
        assertNotNull(Storage.findGroupByID(1));
    }

    @Test
    @DisplayName("Get by name and throw exception")
    public void getByNameAndThrowException() {
        assertThrows(NoSuchElementException.class, ()-> repository.getByName("Invalid Group Name"));
    }
}
