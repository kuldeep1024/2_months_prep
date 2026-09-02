import static org.junit.jupiter.api.Assertions.*;

import org.example.java21.day2.task_3_BuildResult.Failure;
import org.example.java21.day2.task_3_BuildResult.Result;
import org.example.java21.day2.task_3_BuildResult.Success;
import org.example.java21.day2.task_3_BuildResult.User;
import org.example.java21.day2.task_3_BuildResult.after.UserService;
import org.example.java21.day2.task_3_BuildResult.repo.InMemoryUserRepository;
import org.example.java21.day2.task_3_BuildResult.repo.UserRepository;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    @Test
    void shouldReturnSuccessWhenUserExists() {

        UserRepository repository = new InMemoryUserRepository();

        UserService service = new UserService(repository);

        Result<User> result = service.findUser("1");

        assertInstanceOf(Success.class, result);

        Success<User> success = (Success<User>) result;

        assertEquals("1", success.value().id());

        assertEquals("Kuldeep", success.value().name());
    }

    @Test
    void shouldReturnFailureWhenUserDoesNotExist() {

        UserRepository repository = new InMemoryUserRepository();

        UserService service = new UserService(repository);

        Result<User> result = service.findUser("999");

        assertInstanceOf(Failure.class, result);

        Failure<User> failure = (Failure<User>) result;

        assertEquals("User not found: 999", failure.error());
    }
}