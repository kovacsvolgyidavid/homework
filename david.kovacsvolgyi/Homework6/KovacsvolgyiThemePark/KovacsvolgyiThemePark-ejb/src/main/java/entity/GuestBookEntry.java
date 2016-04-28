package entity;

import embededid.EntryId;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    private String entry;

    public GuestBookEntry() {
        //for mapping reasons
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

}
