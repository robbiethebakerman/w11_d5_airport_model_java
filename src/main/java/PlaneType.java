public enum PlaneType {
    AIRSHIP(1000),
    JUMBO(100),
    BUDGET(50),
    SUPER_BUDGET(30),
    PARTY_PLANE(20),
    ISLAND_HOPPER(10),
    CHOPPER(5),
    JET_PACK(1);

    private final int capacity;

    PlaneType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}


