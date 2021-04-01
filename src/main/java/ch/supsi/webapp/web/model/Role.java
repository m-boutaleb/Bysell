package ch.supsi.webapp.web.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="ROLE_T") // Changed the name of the table because the role table already exists in mysql tables
public class Role implements Serializable {
    @Id
    private String roleName;
}
