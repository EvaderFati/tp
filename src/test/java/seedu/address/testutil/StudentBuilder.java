package seedu.address.testutil;

import java.util.Optional;

import seedu.address.model.student.Email;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;
import seedu.address.model.student.StudentId;
import seedu.address.model.student.Telegram;

/**
 * A utility class to help with building Student objects.
 */
public class StudentBuilder {

    public static final String DEFAULT_ID = "E0123456";
    public static final String DEFAULT_NAME = "John Doe";
    public static final String DEFAULT_EMAIL = "johnd@example.com";
    public static final String DEFAULT_TELEGRAM_ID = "john_doe";

    private StudentId id;
    private Name name;
    private Email email;
    private Optional<Telegram> telegram;

    /**
     * Creates a {@code StudentBuilder} with the default details.
     */
    public StudentBuilder() {
        id = new StudentId(DEFAULT_ID);
        name = new Name(DEFAULT_NAME);
        email = new Email(DEFAULT_EMAIL);
        telegram = Optional.of(new Telegram(DEFAULT_TELEGRAM_ID));
    }

    /**
     * Initializes the StudentBuilder wit the data of {@code studentToCopy}.
     */
    public StudentBuilder(Student studentToCopy) {
        id = studentToCopy.getStudentId();
        name = studentToCopy.getName();
        email = studentToCopy.getEmail();
        telegram = studentToCopy.getTelegram();
    }

    /**
     * Sets the {@code StudentId} of the {@code Person} that we are building.
     */
    public StudentBuilder withStudentId(String id) {
        this.id = new StudentId(id);
        return this;
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public StudentBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public StudentBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code Telegram} of the {@code Person} that we are building.
     */
    public StudentBuilder withTelegram(String telegram) {
        this.telegram = Optional.of(new Telegram(telegram));
        return this;
    }

    public Student build() {
        return new Student(id, name, email, telegram);
    }
}
