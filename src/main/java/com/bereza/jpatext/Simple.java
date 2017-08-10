package com.bereza.jpatext;

/**
 * @author Igor Bereza
 */
public class Simple {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Simple{" +
              "id=" + id +
              ", name='" + name + '\'' +
              '}';
    }
}
