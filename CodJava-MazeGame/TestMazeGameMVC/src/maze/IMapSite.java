package maze;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import maze.listeners.EntryListener2;

/**
 *
 * @author dorin
 */
public interface IMapSite {
    //implicit static final
    Set<EntryListener2> listeners = new HashSet<>();

    default
    void addEntryListener(final EntryListener2 el) {
        System.out.println("added EL:" + el);
        listeners.add(el);
    }

    default
    void removeEntryListener(final EntryListener2 el) {
        listeners.remove(el);
    }

    default
    void notifyEntryListeners() {
        for (EntryListener2 el : listeners) {
            el.entered(this);
            System.out.println("Anunt pe " + el + " ca s-a intrat in:" + this);
        }
    }

    public abstract Color getColor();

    public abstract void enter();
}
