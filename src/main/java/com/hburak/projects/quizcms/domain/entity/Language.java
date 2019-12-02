package com.hburak.projects.quizcms.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name"}), @UniqueConstraint(columnNames = {"shortName"})})
public class Language extends BaseEntity implements Serializable {
    private String name;
    private String shortName;

    @ManyToMany
    @JoinTable(name = "platform_language",
            joinColumns = @JoinColumn(name = "language_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id"))
    private List<Platform> platforms = new ArrayList<>();

    public Language(Long id) {
        super.setId(id);
    }
}
