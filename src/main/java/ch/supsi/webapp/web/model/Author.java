package ch.supsi.webapp.web.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author implements Serializable {
    @Id
    private String username;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Role role;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Item> items;

    public Author(final String username, final Role role){
        this.username=username;
        this.role=role;
    }
}
