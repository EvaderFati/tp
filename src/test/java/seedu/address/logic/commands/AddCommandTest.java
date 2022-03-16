package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.testutil.Assert.assertThrows;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyTAssist;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.classgroup.ClassGroup;
import seedu.address.model.entity.Entity;
import seedu.address.model.entity.EntityConverter;
import seedu.address.model.entity.EntityType;
import seedu.address.model.student.Student;
import seedu.address.model.tamodule.TaModule;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.function.Predicate;

public class AddCommandTest {

    @Test
    public void constuctor_nullEntity_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddCommand(null));
    }

    @Test
    public void execute_entityAcceptedByModel_addSuccessful() throws Exception {

    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should noe be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getTAssistFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTAssistFilePath(Path tAssistFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTAssist(ReadOnlyTAssist tAssist) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyTAssist getTAssist() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasEntity(Entity entity) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteEntity(Entity target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addEntity(Entity entity) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setEntity(Entity target, Entity editedEntity) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Student> getFilteredStudentList() {
            throw new AssertionError("This method should not be called."); }

        @Override
        public ObservableList<TaModule> getFilteredModuleList() {
            throw new AssertionError("This method should not be called."); }

        @Override
        public ObservableList<ClassGroup> getFilteredClassGroupList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredStudentList(Predicate<? super Student> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredModuleList(Predicate<? super TaModule> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredClassGroupList(Predicate<? super ClassGroup> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single student.
     */
    private class ModelStubWithStudent extends AddCommandTest.ModelStub {
        private final Student student;

        ModelStubWithStudent(Student student) {
            requireNonNull(student);
            this.student = student;
        }

        @Override
        public boolean hasEntity(Entity entity) {
            requireNonNull(entity);
            if (entity.getEntityType() == EntityType.STUDENT) {
                return this.student.isSameStudent(EntityConverter.entityToStudent(entity));
            } else {
                return false;
            }
        }
    }

    /**
     * A Model stub that contains a single TA module
     */
    private class ModelStubWithModule extends AddCommandTest.ModelStub {
        private final TaModule module;

        ModelStubWithModule(TaModule module) {
            requireNonNull(module);
            this.module = module;
        }

        @Override
        public boolean hasEntity(Entity entity) {
            requireNonNull(entity);
            if (entity.getEntityType() == EntityType.TA_MODULE) {
                return this.module.isSameModule(EntityConverter.entityToTaModule(entity));
            } else {
                return false;
            }
        }
    }

    /**
     * A Model stub that always accept the student being added.
     */
    private class ModelStubAcceptingEntityAdded extends ModelStub {
        final ArrayList<Student> studentsAdded = new ArrayList<>();
        final ArrayList<TaModule> taModulesAdded = new ArrayList<>();
        final ArrayList<ClassGroup> classGroupsAdded = new ArrayList<>();

        @Override
        public boolean hasEntity(Entity entity) {
            requireNonNull(entity);
            switch (entity.getEntityType()) {
                case STUDENT:
                    Student student = EntityConverter.entityToStudent(entity);
                    return studentsAdded.stream().anyMatch(student::isSameStudent);
                case TA_MODULE:
                    TaModule taModule = EntityConverter.entityToTaModule(entity);
                    return taModulesAdded.stream().anyMatch(taModule::isSameModule);
                case CLASS_GROUP:
                    ClassGroup classGroup = EntityConverter.entityToClassGroup(entity);
                    return classGroupsAdded.stream().anyMatch(classGroup::isSameClassGroup);
                default:
                    

            }
            if (entity.getEntityType() == EntityType.STUDENT) {
                Student student = EntityConverter.entityToStudent(entity);
                return studentsAdded.stream().anyMatch(student::isSameStudent);
            } else {
                return false;
            }
        }

        @Override
        public void addEntity(Entity entity) {
            requireNonNull(entity);
            studentsAdded.add()
        }
    }

    /**
     * A Model stub that always accept the module being added.
     */
    private class ModelStubAcceptingModuleAdded extends ModelStub {
        final ArrayList<TaModule> modulesAdded = new ArrayList<>();

        @Override
        public boolean hasEntity(Entity entity) {
            requireNonNull(entity);
            if (entity.getEntityType() == EntityType.TA_MODULE) {
                TaModule module = EntityConverter.entityToTaModule(entity);
                return modulesAdded.stream().anyMatch(module::isSameModule);
            } else {
                return false;
            }
        }
    }
}
