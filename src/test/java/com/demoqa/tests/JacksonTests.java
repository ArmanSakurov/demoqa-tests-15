package com.demoqa.tests;
import com.demoqa.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.assertj.core.api.Assertions.assertThat;

public class JacksonTests {

    @Test
    void jsonJacksonTest() throws Exception {
        File file = new File("src/test/resources/student.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(file, Student.class);
        assertThat(student.name).isEqualTo("Oleg");
        assertThat(student.age).isEqualTo(15);
        assertThat(student.isStudent).isEqualTo(true);
        assertThat(student.education.type).isEqualTo("group");
        assertThat(student.education.groupId).isEqualTo(321);
    }
}
