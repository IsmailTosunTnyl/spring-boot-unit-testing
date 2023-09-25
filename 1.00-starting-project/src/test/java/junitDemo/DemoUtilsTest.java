package junitDemo;

import com.luv2code.junitdemo.DemoUtils;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
 class DemoUtilsTest {
    private DemoUtils demoUtils;

    @BeforeEach
    public void setUp() {
        demoUtils = new DemoUtils();
    }

    @AfterEach
    public void tearDown() {
        demoUtils = null;
        System.out.println("tearDown called");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll called");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll called");
    }

    @Test
    @DisplayName("Test addNumbers method")
    public void testAddNumbers() {

        int result = demoUtils.addNumbers(10, 20);
        assertEquals(30, result, "10 + 20 should equal 30");
        assertNotEquals(40, result);
    }


    @Test
    public void testChekNull() {

        Object result = demoUtils.checkNull(null);
        assertNull(result);
        assertNotNull(demoUtils.checkNull("Hello"));
    }

    @Test
    @DisplayName("Test Same Object")
    public void testSame() {
        String academy = demoUtils.getAcademy();
        String academyDuplicate = demoUtils.getAcademyDuplicate();
        assertSame(academy, academyDuplicate);
        assertNotSame(academy, "Academy not same one");
    }

    @Test
    @DisplayName("Test True-False")
    public void testTrueFalse() {
        assertTrue(demoUtils.isGreater(10, 5));
        assertFalse(demoUtils.isGreater(5, 10));
    }

    @Test
    @DisplayName("Test Array")
    public void testArray() {
        String[] firstThreeLettersOfAlphabet = demoUtils.getFirstThreeLettersOfAlphabet();
        String[] expected = {"A", "B", "C"};
        assertArrayEquals(expected, firstThreeLettersOfAlphabet);

    }

    @Test
    @DisplayName("Test Iterable")
    public void testItterable() {
        List<String> academyInList = demoUtils.getAcademyInList();
        List<String> expected = List.of("luv", "2", "code");
        assertIterableEquals(expected, academyInList);
    }

    @Test
    @DisplayName("Test Exception")
    public void testException() {
        assertThrows(Exception.class, () -> demoUtils.throwException(-1));
        assertDoesNotThrow(() -> demoUtils.throwException(1));

    }

    @Test
    @DisplayName("Test Timeout")
    public void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> demoUtils.checkTimeout());
    }



}
