package data;

public enum JsonObject {
    CANDIDATE("candidate.json"),
    LOCATION("location.json"),
    VACANCY("vacancy.json");

    private String path;

    JsonObject(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
