package entity;


public class Users {
    private String id;
    private String name;
    private String password;
    private String money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Users(String id, String name, String password, String money){
        this.id=id;
        this.name = name;
        this.password = password;
        this.money = money;
    }
    public Users(){}
}
