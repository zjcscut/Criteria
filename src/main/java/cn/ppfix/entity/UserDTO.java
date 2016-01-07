package cn.ppfix.entity;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/24-10:52
 */
public class UserDTO implements java.io.Serializable{

    private Integer id;
    private String name;

    public UserDTO() {
    }

    public UserDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
