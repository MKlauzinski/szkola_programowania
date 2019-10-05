package pl.coderslab.model;

public class UserGroup {

    private int id;
    private String name;

    //podobnie jak w User, bezparametrowy konstrutor do pobierania grupy z bazy
    public UserGroup() {}

    //konstruktor do tworzenia nowej grupy z palca
    public UserGroup(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
