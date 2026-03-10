package dao;

import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Profile;

@Repository("dao2")
//@Profile("dev")
public class DaoImplissam2 implements IDao {
    @Override
    public double getValue() {
        return 888.0;
    }
}