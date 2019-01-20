package com.agonyengine.model.actor;

import com.agonyengine.util.FormattingUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Actor {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;

    @ManyToOne
    private Pronoun pronoun;

    @OneToOne(cascade = CascadeType.ALL)
    private Connection connection;

    @OneToOne(cascade = CascadeType.ALL)
    private CreatureInfo creatureInfo;

    @OneToOne(cascade = CascadeType.ALL)
    private ItemInfo itemInfo;

    @ManyToOne
    private GameMap gameMap;
    private Integer x;
    private Integer y;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private GameMap inventory;

    private UUID roomId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String[] getNameTokens() {
        return name.split(" ");
    }

    public String getPlainName() {
        return name;
    }

    public String getName() {
        if (connection != null) { // TODO for NPC support add: || npcData != null
            return name;
        }

        if (name.toLowerCase().startsWith("the ")) {
            return name;
        }

        return FormattingUtils.aoran(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pronoun getPronoun() {
        return pronoun;
    }

    public void setPronoun(Pronoun pronoun) {
        this.pronoun = pronoun;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public CreatureInfo getCreatureInfo() {
        return creatureInfo;
    }

    public void setCreatureInfo(CreatureInfo creatureInfo) {
        this.creatureInfo = creatureInfo;
    }

    public ItemInfo getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(ItemInfo itemInfo) {
        this.itemInfo = itemInfo;
    }

    @Deprecated
    public GameMap getGameMap() {
        return gameMap;
    }

    @Deprecated
    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    @Deprecated
    public Tile getTile() {
        return getGameMap().getTile(x, y);
    }

    @Deprecated
    public Integer getX() {
        return x;
    }

    @Deprecated
    public void setX(Integer x) {
        this.x = x;
    }

    @Deprecated
    public Integer getY() {
        return y;
    }

    @Deprecated
    public void setY(Integer y) {
        this.y = y;
    }

    public GameMap getInventory() {
        return inventory;
    }

    public void setInventory(GameMap inventory) {
        this.inventory = inventory;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return Objects.equals(getId(), actor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
