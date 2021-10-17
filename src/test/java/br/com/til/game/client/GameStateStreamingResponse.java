package br.com.til.game.client;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.Uninterruptibles;

import br.com.til.models.Die;
import br.com.til.models.GameState;
import br.com.til.models.Player;
import io.grpc.stub.StreamObserver;

public class GameStateStreamingResponse implements StreamObserver<GameState> {
	
	private StreamObserver<Die> dieStreamObserver;
	
	private CountDownLatch latch;
	
	public GameStateStreamingResponse(CountDownLatch latch) {
		super();
		this.latch = latch;
	}

	@Override
	public void onNext(GameState gameState) {

		List<Player> playerList = gameState.getPlayerList();
		
		playerList.forEach(player -> System.out.println(player.getName() + " : " + player.getPosition()));
		
		boolean isGameOver = playerList.stream().anyMatch(player -> player.getPosition() == 100);
		
		if(isGameOver) {
			
			System.out.println("Game Over!");
			this.dieStreamObserver.onCompleted();
			
		} else {
			Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
			this.roll();
		}
		System.out.println("--------------------------------");
	}

	@Override
	public void onError(Throwable t) {
		this.latch.countDown();
	}

	@Override
	public void onCompleted() {
		this.latch.countDown();
	}
	
	public void setDieStreamObserver(StreamObserver<Die> dieStreamObserver) {
		this.dieStreamObserver = dieStreamObserver;
	}

	public void roll() {
		int dieValue = ThreadLocalRandom.current().nextInt(1, 7);
		
		Die die = Die.newBuilder().setValue(dieValue).build();
		
		this.dieStreamObserver.onNext(die);
	}
}
