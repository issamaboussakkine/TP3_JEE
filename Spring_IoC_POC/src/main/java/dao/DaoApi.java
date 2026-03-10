package dao;

import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Profile;

@Repository("daoApi")
//@Profile("api")
public class DaoApi implements IDao {
    @Override
    public double getValue() {
        return 555.0;
    }
}