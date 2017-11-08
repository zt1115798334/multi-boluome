package iflyer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * Created by liuxin on 17/1/20.
 */
@Document(collection = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 9201034849892179274L;

    @Id
    @Indexed(unique = true)
    private String id;
    @Field("name")
    private String name;
    @Field("age")
    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
