package mubir.myimmutable;

import java.util.ArrayList;
import java.util.List;

/**
 * Rules of Immutable Class
 * 1. Declare the class as final,so it can`t be extended.
 * 2. Make all the fields private so that direct is not allowed.
 * 3. Don`t provide any setter methods.
 * 4. Make all mutable fields final so that field`s value can be assigned only once.
 * 5. Initialize all fields using a constructor method and perform deep copy.
 */
public final class EmployeeImmutable {
    private final String name;
    private final int Id;
    private final String team;
    private final List<String> commitHash;

    public EmployeeImmutable(String name, int id, String team, List<String> commitHash) {
        this.name = name;
        Id = id;
        this.team = team;
        this.commitHash = new ArrayList<>();
        this.commitHash.addAll(commitHash);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }

    public String getTeam() {
        return team;
    }

    public List<String> getCommitHash() {
        List<String> deepCopy = new ArrayList<>();
        deepCopy.addAll(commitHash);
        return deepCopy;
    }

}
