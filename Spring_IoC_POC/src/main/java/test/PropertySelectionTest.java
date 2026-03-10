package test;

import metier.IMetier;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import presentation.PresentationIssam;
import config.PropertyDrivenConfig;
import static org.junit.Assert.assertEquals;

public class PropertySelectionTest {

    private double runWithProperty(String target) {
        System.setProperty("dao.target", target);
        System.out.println("\n=== TEST AVEC target = " + target + " ===");

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(PresentationIssam.class);

        System.out.println("Beans IDao dans le contexte:");
        String[] beanNames = ctx.getBeanNamesForType(dao.IDao.class);
        for (String name : beanNames) {
            dao.IDao dao = ctx.getBean(name, dao.IDao.class);
            System.out.println(" - " + name + " → " + dao.getValue());
        }

        IMetier m = ctx.getBean(IMetier.class);
        double result = m.calcul();
        System.out.println("Résultat = " + result);

        ctx.close();
        System.clearProperty("dao.target");
        return result;
    }

    @Test
    public void propertyDao_1554() {
        assertEquals(1554.0, runWithProperty("dao"), 1e-6);
    }

    @Test
    public void propertyDao2_1776() {
        assertEquals(1776.0, runWithProperty("dao2"), 1e-6);
    }

    @Test
    public void propertyDaoFile_1332() {
        assertEquals(1332.0, runWithProperty("daoFile"), 1e-6);
    }

    @Test
    public void propertyDaoApi_1110() {
        assertEquals(1110.0, runWithProperty("daoApi"), 1e-6);
    }
}