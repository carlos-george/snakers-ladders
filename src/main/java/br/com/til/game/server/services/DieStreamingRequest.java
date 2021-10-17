package br.com.til.game.server.services;

import br.com.til.models.Die;
import br.com.til.models.GameState;
import br.com.til.models.Player;
import io.grpc.netty.shaded.io.netty.util.internal.ThreadLocalRandom;
import io.grpc.stub.StreamObserver;

public class DieStreamingRequest implements StreamObserver<Die> {
	
	private Player client;
	
	private Player server;
	
	private StreamObserver<GameState> gameStateStreamObserver;
	
	public DieStreamingRequest(Player client, Player server, StreamObserver<GameState> gameStateStreamObserver) {
		super();
		this.client = client;
		this.server = server;
		this.gameStateStreamObserver = gameStateStreamObserver;
	}

	@Override
	public void onNext(Die dieRequest) {
		this.client = this.newPlayerPosition(this.client, dieRequest.getValue());
		
		if(this.client.getPosition() != 100) {
			this.server = this.newPlayerPosition(this.server, ThreadLocalRandom.current().nextInt(1,7));
			
		}
		
		this.gameStateStreamObserver.onNext(this.getGameState());
	}

	@Override
	public void onError(Throwable t) {
		
	}

	@Override
	public void onCompleted() {
		this.gameStateStreamObserver.onCompleted();
	}
	
	private GameState getGameState() {
		return GameState.newBuilder()
				.addPlayer(client)
				.addPlayer(server)
				.build();
	}
	
	private Player newPlayerPosition(Player player, int dieValue) {
		
		int position = player.getPosition() + dieValue;
		
		position = SnakesAndLaddersBoard.getPosition(position);
		
		if(position <= 100) {
			
			player = player.toBuilder().setPosition(position).build();
		}
		
		return player;
	}

}
