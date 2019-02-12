package algorithms.part1.unionfind.exercises;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class SocialNetworkTest {

  @Test
  void socialNetworkConnectivityTest() throws NoSuchAlgorithmException {
    final int N = 100;
    final SocialNetwork socialNetwork = new SocialNetwork(N);
    final Random random = SecureRandom.getInstanceStrong();
    final Optional<Connection> result =
        Stream.generate(() -> new Connection(random.nextInt(N), random.nextInt(N), Instant.now()))
            .peek(connection -> socialNetwork.union(connection.member1, connection.member2))
            .filter(connection -> socialNetwork.isFullyConnected())
            .findFirst();
    assertTrue(result.isPresent());
    assertTrue(IntStream.range(0, N - 1).allMatch(i -> socialNetwork.connected(i, N - 1)));
  }

  private static class Connection {

    final int member1;
    final int member2;
    final Instant timestamp;

    private Connection(final int member1, final int member2, final Instant timestamp) {
      this.member1 = member1;
      this.member2 = member2;
      this.timestamp = timestamp;
    }
  }
}
