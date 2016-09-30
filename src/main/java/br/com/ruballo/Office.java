package br.com.ruballo;

/**
 * Created by marcosarruda on 9/30/16.
 */
public class Office {
    private Integer id;
    private String name;

    public Office(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Office(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
