/*
 * MapSite.java
 * Copyright (c) 2008, Drexel University.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Drexel University nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY DREXEL UNIVERSITY ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL DREXEL UNIVERSITY BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package maze;

import maze.listeners.EntryListener;
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sunny
 * @version 1.0
 * @since 1.0
 */
public abstract class MapSite {

    private final Set<EntryListener> listeners = new HashSet<>();

    /**
     * Implementare tipica a D.P.-ului Observer
     *
     * Descendentii (Room, Door, Wall) sunt Subject(Observable).
     *
     * "EntryListener" sunt observatori: obiecte interesate de producerea unui
     * eveniment(aici eveniment este executia lui "enter()") si care sunt
     * notificati in "notifyEntryListeners()"
     */
    public final synchronized void addEntryListener(final EntryListener el) {
        //System.out.println("added EL:"+el);
        listeners.add(el);
    }

    public final synchronized void removeEntryListener(final EntryListener el) {
        listeners.remove(el);
    }

    protected final synchronized void notifyEntryListeners() {
        for (EntryListener el : listeners) {
            el.entered(this);
            System.out.println("Anunt pe " + el + " ca s-a intrat in:" + this);
        }
    }

    public abstract Color getColor();

    public abstract void enter();
}
