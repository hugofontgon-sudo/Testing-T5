import com.germangascon.ed.Player;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Steve", 100, 10);
    }

    @AfterEach
    void tearDown() {
        player = null;
    }

    @Test
    void curarSumaVida() {
        player = new Player("Steve", 5, 10);
        player.curar(5);
        assertEquals(10, player.getVida());
    }

    @Test
    void curarHastaMaximoExacto() {
        player = new Player("Steve", 80, 10);
        player.curar(20);
        assertEquals(100, player.getVida());
    }

    @Test
    void curarAUnMuertoNoFunciona() {
        player.recibirDanyo(100);
        player.curar(100);
        assertEquals(0, player.getVida());
    }
}