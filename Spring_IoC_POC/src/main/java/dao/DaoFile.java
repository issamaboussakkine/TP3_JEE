package dao;

import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Profile;

@Repository("daoFile")
//@Profile("file")
public class DaoFile implements IDao {
    @Override
    public double getValue() {
        return 666.0;
    }
}