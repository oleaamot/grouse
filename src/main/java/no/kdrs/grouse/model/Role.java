package no.kdrs.grouse.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by tsodring 28/03/2018
 * <p>
 * Basic Role entity that define a role a user can have. There is a
 * manytomany relationship in a join table that
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @NotNull
    @Column(name = "role", nullable = false)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<GrouseUser> users;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<GrouseUser> getUsers() {
        return users;
    }

    public void setUsers(List<GrouseUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                '}';
    }
}
