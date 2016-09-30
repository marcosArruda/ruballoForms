package br.com.ruballo;

/**
 * Created by marcosarruda on 9/30/16.
 */
public class Service {
    private Integer id;
    private Integer officeId;
    private String name;
    private String status;

    public Service(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Service(Integer id, Integer officeId, String name){
        this.id = id;
        this.officeId = officeId;
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Service(){
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
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
