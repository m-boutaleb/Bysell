package ch.supsi.webapp.web.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String title;
    private String description;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Author author;

    @Enumerated(EnumType.STRING)
    private ItemCategory category;
    @Enumerated(EnumType.STRING)
    private ItemType type;

    public Item(final Date date, final String title, final String description, final Author author, final ItemCategory category, final ItemType type) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.author = author;
        this.category = category;
        this.type = type;
    }
}