/**
 * Version 1.1
 * Main entity @UserAccount
 **/

package test.hes.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="users")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 16)
    private String username;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 16)
    private String password;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 16)
    private String firstName;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 16)
    private String lastName;
    @Enumerated
    private Role role;
    @Enumerated
    private Status st;
    private String createdAt;

    public UserAccount(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
