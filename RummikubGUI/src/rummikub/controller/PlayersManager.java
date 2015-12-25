package rummikub.controller;


import generated.Players;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rummikub.controller.exception.DuplicateNameException;
import rummikub.controller.exception.EmptyNameException;
import rummikub.model.Player;

public class PlayersManager {

    List<Player> players = new ArrayList<Player>();
    

    public Player addPlayer(String name, boolean isHuman) throws DuplicateNameException, EmptyNameException {
	if (name == null || name.isEmpty()){
	    throw new EmptyNameException();
	}
        Player.PlayerType playerType = isHuman? Player.PlayerType.HUMAN : Player.PlayerType.COMPUTER; 
	Player newPlayer = new Player(playerType, name);
	if (players.contains(newPlayer)) {
	    throw new DuplicateNameException();
	} else {
	    players.add(newPlayer);
	}
	return newPlayer;
    }

    public Collection<Player> getPlayers(){
	return players;
    }
}
