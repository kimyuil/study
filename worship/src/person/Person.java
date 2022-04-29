package person;

import mike.Mike;

public class Person {
    String name;

    Mike mike;

    public Person(String name){
        this.name=name;
    }

    public void setMike(Mike mike) {
        this.mike = mike;
    }
    public Mike getMike(){
        return this.mike;
    }
}
