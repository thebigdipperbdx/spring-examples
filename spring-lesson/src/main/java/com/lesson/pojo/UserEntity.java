package com.lesson.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * Created by thebigdipper on 2018-01-12 22:59:31.
 */
@Entity
@Table(name = "user", schema = "spring-lesson", catalog = "")
public class UserEntity {
    private int id;
    private String nickname;
    private String password;
    private String firstName;
    private String lastName;
    private Collection<BlogEntity> blogsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nickname", nullable = false, length = 45)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<BlogEntity> getBlogsById() {
        return blogsById;
    }

    public void setBlogsById(Collection<BlogEntity> blogsById) {
        this.blogsById = blogsById;
    }

    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity that=(UserEntity) o;
        return getId()==that.getId() &&
                Objects.equals(getNickname(), that.getNickname()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getBlogsById(), that.getBlogsById());
    }

    @Override
    public int hashCode(){

        return Objects.hash(getId(), getNickname(), getPassword(), getFirstName(), getLastName(), getBlogsById());
    }
}
