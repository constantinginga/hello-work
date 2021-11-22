package work.hello.data;

public enum Status {
    Accepted(1),
    Rejected(2),
    Waiting(3);

    private final int id;
    Status(int id) { this.id = id; }
    public int getValue() { return id; }

}
