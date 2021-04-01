package ch.supsi.webapp.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ItemType {
    REQUEST("Request"), OFFER("Offer");
    private String type;
}
