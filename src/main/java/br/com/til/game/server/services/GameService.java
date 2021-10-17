package br.com.til.game.server.services;

import br.com.til.models.Die;
import br.com.til.models.GameServiceGrpc.GameServiceImplBase;
import br.com.til.models.GameState;
import br.com.til.models.Player;
import io.grpc.stub.StreamObserver;

public class GameService extends GameServiceImplBase {

	@Override
	public StreamObserver<Die> roll(StreamObserver<GameState> responseObserver) {
		
		Player client = Player.newBuilder().setName("client").setPosition(0).build();
		
		Player server = Player.newBuilder().setName("server").setPosition(0).build();
		
		return new DieStreamingRequest(client, server, responseObserver);
	}

	
}
