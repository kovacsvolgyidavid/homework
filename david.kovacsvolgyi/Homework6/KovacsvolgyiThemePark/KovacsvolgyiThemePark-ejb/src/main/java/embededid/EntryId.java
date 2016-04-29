package embededid;

import entity.Guest;
import entity.ThemePark;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Embeddable
public class EntryId implements Serializable {
    @Column(name="THEME_PARK_ID")
    private Long themeParkId;
    @Column(name="GUEST_ID")
    private Long guestId;
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="ENTRY_DATE")
    private Date date;

    public EntryId() {
        //for mappig reasons
    }

    public Long getThemePark() {
        return themeParkId;
    }

    public void setThemePark(Long themePark) {
        this.themeParkId = themePark;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.themeParkId);
        hash = 31 * hash + Objects.hashCode(this.guestId);
        hash = 31 * hash + Objects.hashCode(this.date);
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
        final EntryId other = (EntryId) obj;
        if (!Objects.equals(this.themeParkId, other.themeParkId)) {
            return false;
        }
        if (!Objects.equals(this.guestId, other.guestId)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    
}
