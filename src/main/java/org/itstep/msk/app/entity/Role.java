package org.itstep.msk.app.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table( name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;


   @ManyToMany(mappedBy = "role" ,cascade =  CascadeType.ALL , fetch =  FetchType.LAZY)
    private Set<Customer> custom ;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", custom=" + custom +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Role))
            return false;
        final Role role = (Role) o;
        return Objects.equals(this.id, role.id) &&
                Objects.equals(this.name, role.name) &&
                Objects.equals(this.custom, role.custom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.custom);
    }

    public Role() {
    }

    public Integer getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<Customer> getCustom() {
        return this.custom;
    }

    public void setCustom(final Set<Customer> custom) {
        this.custom = custom;
    }
}
