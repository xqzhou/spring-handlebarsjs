package template;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class PerformanceTest {

    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    @Test
    @PerfTest(duration = 1000)
    public void testReplace() throws IOException {
        Handlebars handlebars = new Handlebars();

        Template template = handlebars.compile("Hello {{name}}! You have {{count}} new messages.");

        HashMap map = new HashMap();
        map.put("name", "Mick");
        map.put("count", 30);

        template.apply(map);
    }


    @Test
    @PerfTest(duration = 1000)
    public void testString() throws IOException {
        Handlebars handlebars = new Handlebars();

        Template template = handlebars.compile("");

        template.apply(new Object());
    }
}
