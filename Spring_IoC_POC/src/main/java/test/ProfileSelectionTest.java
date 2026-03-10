package test;

import metier.IMetier;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import presentation.PresentationIssam;
import static org.junit.Assert.assertEquals;

public class ProfileSelectionTest {

    private double runWithProfile(String profile) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles(profile);
        ctx.register(PresentationIssam.class);  // ← Utilise PresentationIssam directement
        ctx.refresh();
        IMetier m = ctx.getBean(IMetier.class);
        double result = m.calcul();
        ctx.close();
        return result;
    }

    @Test
    public void devProfile_1554() {
        assertEquals(1554.0, runWithProfile("dev"), 1e-6);
    }

    @Test
    public void prodProfile_220() {
        assertEquals(220.0, runWithProfile("prod"), 1e-6);
    }

    @Test
    public void fileProfile_1332() {
        assertEquals(1332.0, runWithProfile("file"), 1e-6);
    }

    @Test
    public void apiProfile_1110() {
        assertEquals(1110.0, runWithProfile("api"), 1e-6);
    }
}