package fr.roytreo.hikabrain.core.arena.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import fr.roytreo.hikabrain.core.arena.Arena;

public class ArenaStartEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	private final Arena arena;
	
	public ArenaStartEvent(Arena arena) {
		this.arena = arena;
	}
	
	public Arena getArena() {
		return this.arena;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

}
