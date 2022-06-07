package com.theheclers.sburrestdemo;



import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class  Coffee {
    @Id
    private String id;
    private  String name;

    public Coffee(String id, String name){
        this.id = id;
        this.name = name;
    }


    public  Coffee(String name){
        this(UUID.randomUUID().toString(), name);
    }

    public Coffee() {

    }

    public  void setid(String id){
        this.id = id;
    }

    public  String getId() {
        return  id;
    }

    public String getName(){
        return  name;
    }

    public  void setName(String name){
        this.name = name;
    }
}