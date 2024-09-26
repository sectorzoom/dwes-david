import org.example.Youtuber;
import org.example.YoutuberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


class YoutuberServiceTest {

    private YoutuberService youtuberService;

    @BeforeEach
    void setUp() {
        youtuberService = new YoutuberService();
        // Agregar algunos youtubers genéricos
        youtuberService.addYoutuber(new Youtuber("Alice", "2013-05-01", 200, 8000));
        youtuberService.addYoutuber(new Youtuber("Bob", "2015-10-12", 150, 12000));
        youtuberService.addYoutuber(new Youtuber("Charlie", "2018-01-20", 300, 6000));
        youtuberService.addYoutuber(new Youtuber("Dave", "2019-07-15", 250, 15000));
        // Agregar más youtubers para cumplir con los tests
        youtuberService.addYoutuber(new Youtuber("Whindersson Nunes", "2013-01-01", 1000, 183000000));
        youtuberService.addYoutuber(new Youtuber("Another Youtuber", "2014-01-01", 1200, 90000));
        youtuberService.addYoutuber(new Youtuber("Third Youtuber", "2015-01-01", 800, 50000));
    }

    @Test
    void testGetYoutuberWithMostFollowersWithValidData() {
        Optional<Youtuber> youtuber = youtuberService.getYoutuberWithMostFollowers();
        assertTrue(youtuber.isPresent());
        assertEquals(183000000, youtuber.get().numFollowers());
    }

    @Test
    void testGetYoutuberWithMostFollowersWithEmptyList() {
        youtuberService = new YoutuberService(); // Reiniciar para la prueba vacía
        Optional<Youtuber> youtuber = youtuberService.getYoutuberWithMostFollowers();
        assertFalse(youtuber.isPresent());
    }

    @Test
    void testGetAverageVideosWithValidData() {
        double averageVideos = youtuberService.getAverageVideos();
        assertEquals(557.1428571428571, averageVideos); // Cambiar este valor basado en los videos totales de youtubers añadidos
    }

    @Test
    void testGetAverageVideosWithEmptyList() {
        youtuberService = new YoutuberService(); // Reiniciar para la prueba vacía
        double averageVideos = youtuberService.getAverageVideos();
        assertEquals(0, averageVideos);
    }

    @Test
    void testGetYoutuberStarted2013WithValidData() {
        List<Youtuber> youtubers2013 = youtuberService.getYoutuberStarted2013();
        assertEquals(2, youtubers2013.size()); // Cambiar según los youtubers de 2013 que has añadido
        assertEquals("Alice", youtubers2013.get(0).name());
    }

    @Test
    void testGetYoutuberStarted2013WithNoMatches() {
        youtuberService = new YoutuberService(); // Reiniciar para la prueba vacía
        List<Youtuber> youtubers2013 = youtuberService.getYoutuberStarted2013();
        assertTrue(youtubers2013.isEmpty());
    }

    @Test
    void testGetTop3WithMoreEarns() {
        List<Youtuber> top3Youtubers = youtuberService.getTop3WithMoreEarns();
        assertEquals(3, top3Youtubers.size());
        assertTrue(top3Youtubers.get(0).estimatedIncome() >= top3Youtubers.get(1).estimatedIncome());
    }

    @Test
    void testGetYoutubersGroupedByYear() {
        Map<String, List<Youtuber>> youtubersByYear = youtuberService.getYoutubersGroupedByYear();

        // Asegúrate de que el número de grupos refleje a los youtubers que has añadido.
        assertEquals(5, youtubersByYear.size()); // Hay youtubers de 2013, 2014, 2015, 2018, 2019

        // Asegúrate de que 2020 no esté presente en los grupos
        assertFalse(youtubersByYear.containsKey("2020")); // Verifica que no hay grupo para el año 2020

        // Puedes agregar aserciones para verificar otros años si es necesario
        assertEquals(2, youtubersByYear.get("2015").size()); // Por ejemplo, Bob y Third Youtuber
    }

}
