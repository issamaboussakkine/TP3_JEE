package dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Profile;

@Repository("dao")
//@Profile("prod")
public class DaoImplissam implements IDao {
    @Override
    public double getValue() {
        return  777.0;
    }
}