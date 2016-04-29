package dto;

import entity.GuestBookEntry;
import java.util.Date;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
public class GuestBookEntryDTO {
    private ThemeParkDTO themePark;
    private GuestDTO guest;
    private Date date;
    private String entry;

    public GuestBookEntryDTO(GuestBookEntry guestBook) {
        themePark=new ThemeParkDTO(guestBook.getThemePark());
        guest=new GuestDTO(guestBook.getGuest());
        date=guestBook.getEntryId().getDate();
        entry=guestBook.getEntry();
    }

    public GuestBookEntryDTO() {
    }

    public ThemeParkDTO getThemePark() {
        return themePark;
    }

    public void setThemePark(ThemeParkDTO themePark) {
        this.themePark = themePark;
    }

    public GuestDTO getGuest() {
        return guest;
    }

    public void setGuest(GuestDTO guest) {
        this.guest = guest;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
    
    
}
