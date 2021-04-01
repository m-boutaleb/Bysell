package ch.supsi.webapp.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ItemCategory implements Serializable {
    VEHICLES("Vehicles"), REAL_ESTATES("Real Estates"), JOB("Job");
    private String category;
}
