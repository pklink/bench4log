package net.einself.bench.slf4j.domain;

public class Dog {

    private Long id;
    private String breed;
    private String name;

    public Dog(Long id, String breed, String name) {
        this.id = id;
        this.breed = breed;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
