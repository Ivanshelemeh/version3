    package org.itstep.msk.app.entity;


    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.crypto.password.PasswordEncoder;

    import javax.persistence.*;
    import javax.validation.constraints.*;
    import java.io.Serializable;
    import java.util.Objects;
    import java.util.Set;

    @Entity
    @Table( name = "customer")
    public class Customer  implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true,nullable = false)
        private Integer id;

        @Column( name = "name", nullable = false)
        @NotBlank
        @Size(min = 2, max = 20 ,
                message = "A form with name should be between 2 to 10")
        private String name;


        @Column(name = "email",
                nullable = false)
      //  @Email(regexp = "^(.+)@(.+)$", message = "Incorrect email")
        @Size(max = 20)
        private String email;

        public Customer() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Customer)) return false;
            Customer customer = (Customer) o;
            return id.equals(customer.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Column(name = "phone")
        @Pattern(regexp = "^((\\+7|7|8)+([0-9]{10})$)",message = "Invalid phone number")
        @Size(max = 20,message = "the digits should be not more than 10")
        private String phoneNumber;

        @Column(name = "password",nullable = false)
        @NotNull
        private String password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        @ManyToMany
        @JoinTable(name = "custom_roles",joinColumns = @JoinColumn(name = "customer_id"),inverseJoinColumns =
                    @JoinColumn(name ="roles_id" ))
        private Set<Role> role;


        public Set<Role> getRole() {
            return this.role;
        }

        public void setRole(final Set<Role> role) {
            this.role = role;
        }



        public Integer getId() {
            return id;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Customer(String password,String name) {
            this.name = name;
          //  this.email = email;
            this.password = password;
        }
    }
