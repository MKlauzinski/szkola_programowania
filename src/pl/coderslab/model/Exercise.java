package pl.coderslab.model;

public class Exercise {

    private int id;
    private String title;
    private String description;

    //konstruktor bezparametrowy do pobierania z bazy
    public Exercise() {}

    //konstruktor parametrowy dla tworzenia nowego zadania
    public Exercise(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
