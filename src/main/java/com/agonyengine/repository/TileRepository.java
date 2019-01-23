package com.agonyengine.repository;

import com.agonyengine.model.map.Tile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TileRepository extends JpaRepository<Tile, UUID> {
}
