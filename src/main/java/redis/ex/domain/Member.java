package redis.ex.domain;


import java.util.UUID;

public class Member {
    private String num;
    private String name;
    private String phone;

    public String getNum(){
        return this.num;
    }

    public String getName(){
        return this.name;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public Member(String name, String phone){
        this.num = UUID.randomUUID().toString();
        this.name = name;
        this.phone = phone;
    }

}
