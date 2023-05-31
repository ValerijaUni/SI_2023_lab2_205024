import org.example.SILab2;
import org.example.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    @Test
    void everyBranch() {
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class,() -> SILab2.function(null, Collections.emptyList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        assertFalse(SILab2.function(new User("User", "abcd", "abc"),Collections.emptyList()));
        assertTrue(SILab2.function(new User(null, "abcd12345!", "a@."), Collections.emptyList()));
        assertFalse(SILab2.function(new User("User", "ab cdef123!", "abc@"),Collections.emptyList()));
        assertFalse(SILab2.function(new User("User", "abcdefgh", "a@."), new ArrayList<>(List.of(
                new User("User2", "abcd123456", "a@h."),
                new User("User", "abcdefgh", "a@.")))));
    }

    @Test
    void multipleConditions(){
        RuntimeException ex;
        assertTrue(SILab2.function(new User(null, "ab123456!", "a@."), Collections.emptyList()));
        ex = assertThrows(RuntimeException.class,() -> SILab2.function(new User("User","abcde12345",null), Collections.emptyList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        ex = assertThrows(RuntimeException.class,() -> SILab2.function(new User("User",null,"user@."), Collections.emptyList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        ex = assertThrows(RuntimeException.class,() -> SILab2.function(null, Collections.emptyList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }

}
