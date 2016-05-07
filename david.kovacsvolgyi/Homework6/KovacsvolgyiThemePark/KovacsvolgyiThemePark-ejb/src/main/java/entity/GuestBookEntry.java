package entity;

import embededid.EntryId;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Entity
@Table(name = "GUEST_BOOK")
public class GuestBookEntry implements Serializable {

    @EmbeddedId
    private EntryId entryId;
    @MapsId("guestId")
    @JoinColumn(name = "GUEST_ID", referencedColumnName = "id")
    @ManyToOne
    Guest guest;
    @MapsId("themeParkId")
    @JoinColumn(name = "THEME_PARK_ID", referencedColumnName = "id")
    @ManyToOne
    ThemePark themePark;
    private String entry;

    public GuestBookEntry() {
        //for mapping reasons
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public ThemePark getThemePark() {
        return themePark;
    }

    public void setThemePark(ThemePark themePark) {
        this.themePark = themePark;
    }

    public EntryId getEntryId() {
        return entryId;
    }

    public void setEntryId(EntryId entryId) {
        this.entryId = entryId;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.entryId);
        hash = 53 * hash + Objects.hashCode(this.guest);
        hash = 53 * hash + Objects.hashCode(this.themePark);
        hash = 53 * hash + Objects.hashCode(this.entry);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GuestBookEntry other = (GuestBookEntry) obj;
        if (!Objects.equals(this.entry, other.entry)) {
            return false;
        }
        if (!Objects.equals(this.entryId, other.entryId)) {
            return false;
        }
        if (!Objects.equals(this.guest, other.guest)) {
            return false;
        }
        if (!Objects.equals(this.themePark, other.themePark)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GuestBookEntry{" + "entryId=" + entryId + ", guest=" + guest + ", themePark=" + themePark + ", entry=" + entry + '}';
    }

}
