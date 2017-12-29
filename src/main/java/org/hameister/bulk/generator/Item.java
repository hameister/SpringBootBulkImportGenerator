package org.hameister.bulk.generator;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by hameister on 27.12.17.
 */
@Entity
@Table(name = "Item")
public class Item  {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    String id;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    public Item() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item itemPersistable = (Item) o;

        if (id != null ? !id.equals(itemPersistable.id) : itemPersistable.id != null) return false;
        if (description != null ? !description.equals(itemPersistable.description) : itemPersistable.description != null) return false;
        return location != null ? location.equals(itemPersistable.location) : itemPersistable.location == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}