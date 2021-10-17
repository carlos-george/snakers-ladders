package br.com.til.game.server;

import java.io.IOException;

import br.com.til.game.server.services.GameService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(9090)
		.addService(new GameService())
		.build();
		
		server.start();
		
		System.out.println("Server is up on port " + server.getPort());
		
		server.awaitTermination();
	}
}
