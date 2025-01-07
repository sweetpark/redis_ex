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

    public Member(){
        this.num = UUID.randomUUID().toString();
    }

}
