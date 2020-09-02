package demo.viewmodel;

public class User {

 private    String name=" Chhote lal Pal";
    String designation="Software Enginner";
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }



User(){

}
    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
