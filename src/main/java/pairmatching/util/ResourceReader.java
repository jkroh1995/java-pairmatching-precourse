package pairmatching.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ResourceReader {

    public List<String> getBackendCrewList() {
        try {
            return Files.readAllLines(Paths.get("./src/main/resources/backend-crew.md"));
        } catch (IOException e) {
            return null;
        }
    }

    public List<String> getFrontendCrewList() {
        try {
            return Files.readAllLines(Paths.get("./src/main/resources/frontend-crew.md"));
        } catch (IOException e) {
            return null;
        }
    }
}
