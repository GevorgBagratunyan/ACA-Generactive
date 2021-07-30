package storage;

import model.Group;

import java.util.List;
import java.util.Optional;

public class GroupRepository implements CRUD<Group> {

    @Override
    public Group create(Group group) {
        return Storage.addGroup(group);
    }

    @Override
    public Optional<Group> read(int id) {
        return Storage.findGroupByID(id);
    }

    //This will be implemented soon, after realizing REST requests
    @Override
    public Group update(int ID) {
        return null;
    }

    @Override
    public Group delete(int id) {
        return Storage.removeGroupByID(id);
    }

    public Optional<Group> getByName(String name) {
        return Storage.findGroupByName(name);
    }

    public List<Group> getSubgroupsByParent(Group parent) {
        return Storage.findSubGroupsByParent(parent);
    }

    public void printAll() {
        Storage.printAllGroups();
    }
}
