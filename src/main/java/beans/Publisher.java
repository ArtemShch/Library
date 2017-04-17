package beans;

/**
 * Created by artem on 17.04.17.
 */
public class Publisher {
    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
