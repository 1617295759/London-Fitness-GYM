package team.gym.Dao.Impl;

import junit.framework.TestCase;
import team.gym.Beans.Trainer;

public class TrainerDaoImplTest extends TestCase {

    public void testSaveTrainer() {
        new TrainerDaoImpl().saveUser(new Trainer());
    }

    public void testGetTrainerMap() {
        System.out.println(new TrainerDaoImpl().getUserMap().values());;
    }

    public void testFindTrainerByName() {
        System.out.println(new TrainerDaoImpl().findUserByAccount(
                (String) new TrainerDaoImpl().getUserMap().keySet().toArray()[0]
        ));
    }
}