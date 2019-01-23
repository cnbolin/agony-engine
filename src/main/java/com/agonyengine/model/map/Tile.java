package com.agonyengine.model.map;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Tile {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    // TODO rename this to something before committing... category, shape, pattern, mask...?
    private byte[] biomes = new byte[9];

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public byte[] getBiomes() {
        return biomes;
    }

    public void setBiomes(byte[] biomes) {
        this.biomes = biomes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tile)) return false;
        Tile tile = (Tile) o;
        return Objects.equals(getId(), tile.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
