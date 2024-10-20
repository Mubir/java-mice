package mubir.myimmutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientImmute {
    public static void main(String[] args) {

        EmployeeImmutable emp01 = new EmployeeImmutable(
                "Rick", 786, "Portal",
                new ArrayList<>(
                        Arrays.asList(
                                "9d95a74102881d12276cb52f3e8f192bdbde933f",
                                "ee274f3e0bc215cbf0fd537dd9e2d01ca1650c1e"
                        )
                ));

        emp01.getCommitHash().forEach(System.out::println);

        List<String> commits = new ArrayList<>(
                Arrays.asList(
                        "d9d27220613662c66edc9a5e7b09eab3d26a3541",
                        "98410bd04563910eafd2e6ed0f3cb271a77377f6"
                )
        );

        EmployeeImmutable emp02 = new EmployeeImmutable("Stark", 666, "Ceo", commits);
        System.out.println("After poisoning");
        emp02.getCommitHash().forEach(System.out::println);
        // change reference commits
        System.out.println(" Poisoned Apple ");
        commits.add(0, "I will rig object");
        emp02.getCommitHash().forEach(System.out::println);

        if (emp02.getCommitHash().get(0).equals("d9d27220613662c66edc9a5e7b09eab3d26a3541")) {
            System.out.println("I am Immutable");
        } else {
            System.out.println("Ohh God Help me");
        }
    }
}
