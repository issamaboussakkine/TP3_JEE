package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component("metier")
public class MetierImplissam implements IMetier {

    @Autowired
    @Qualifier("selectedDao")
    private IDao dao;

    @Override
    public double calcul() {
        return dao.getValue() * 2;
    }

    @PostConstruct
    private void init() {
        System.out.println("[TRACE] DAO injecté = " +
                dao.getClass().getSimpleName() + " → valeur = " + dao.getValue());
    }
}