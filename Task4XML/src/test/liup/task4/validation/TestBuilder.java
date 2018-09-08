package test.liup.task4.validation;

import com.liup.task4.builder.AbstractPaperBuilder;
import com.liup.task4.builder.PaperBuilderFactory;
import com.liup.task4.entity.Magazine;
import com.liup.task4.entity.MagazineCharacter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestBuilder {
        private static final String FILE_PATH = "text/test.xml";
        private static final String EMPTY_FILE_PATH = "text/empty.xml";
        private static final String TEXT_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<papers xmlns=\"http://www.example.com/papers\">\n" +
                "    <magazine id=\"ID-8\" category=\"fashion\">\n" +
                "        <title>Cosmopolitan</title>\n" +
                "        <monthly>true</monthly>\n" +
                "        <magazine-chars>\n" +
                "            <color>true</color>\n" +
                "            <volume>65</volume>\n" +
                "            <glossiness>true</glossiness>\n" +
                "            <subscription-index>51284</subscription-index>\n" +
                "        </magazine-chars>\n" +
                "    </magazine>\n" +
                "</papers>";
        private static Magazine expected;
        private static PaperBuilderFactory sFactory;
        private static File file;
        private static final String DOM = "dom";
        private static final String SAX = "sax";
        private static final String STAX = "stax";
        @BeforeSuite
        public static void initBuilderComponents(){
                sFactory = new PaperBuilderFactory();
                expected = new Magazine("Cosmopolitan", true, "ID-8", "fashion",
                        new MagazineCharacter(true, 65, true, 51284));
        }
        @BeforeClass
        public static void initFileComponents() throws IOException {
                file = new File(FILE_PATH);
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(TEXT_XML);
                fileWriter.close();
        }

        @Test
        public void testDOMBuilder(){
                AbstractPaperBuilder builder = sFactory.createStudentBuilder(DOM);
                builder.buildSetPaperEdition(file.getPath());
                Magazine result = (Magazine) builder.getPapers().iterator().next();
                Assert.assertEquals(expected, result);
        }

        @Test
        public void testSTAXBuilder(){
                AbstractPaperBuilder builder = sFactory.createStudentBuilder(STAX);
                builder.buildSetPaperEdition(file.getPath());
                Magazine result = (Magazine) builder.getPapers().iterator().next();
                Assert.assertEquals(expected, result);
        }
        @Test
        public void testSAXBuilder(){
                AbstractPaperBuilder builder = sFactory.createStudentBuilder(SAX);
                builder.buildSetPaperEdition(file.getPath());
                Magazine result = (Magazine) builder.getPapers().iterator().next();
                Assert.assertEquals(expected, result);
        }

        @AfterClass
        public void deleteFile() {
                file.delete();

        }
}
