package br.com.til.game.client;

import java.util.concurrent.CountDownLatch;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import br.com.til.models.Die;
import br.com.til.models.GameServiceGrpc;
import br.com.til.models.GameServiceGrpc.GameServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GameClientTest {

	private GameServiceStub stub;

	
	@BeforeAll
	public void setUp() {
		
		ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090)
			.usePlaintext()
			.build();
		
		this.stub = GameServiceGrpc.newStub(managedChannel);
		
	}
	
	@Test
	public void clientGame() throws InterruptedException {
		
		CountDownLatch latch = new CountDownLatch(1);
		GameStateStreamingResponse gameStateStreamingResponse = new GameStateStreamingResponse(latch);
		
		StreamObserver<Die> dieStreamObserver = this.stub.roll(gameStateStreamingResponse);
		gameStateStreamingResponse.setDieStreamObserver(dieStreamObserver);
		
		gameStateStreamingResponse.roll();
		latch.await();
	}
}
