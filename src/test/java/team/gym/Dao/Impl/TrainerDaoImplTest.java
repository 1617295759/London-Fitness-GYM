package team.gym.Dao.Impl;

import junit.framework.TestCase;
import team.gym.Beans.Trainer;

public class TrainerDaoImplTest extends TestCase {

    public void testSaveTrainer() {
        new TrainerDaoImpl().saveTrainer(new Trainer());
    }

    public void testGetTrainerMap() {
        System.out.println(new TrainerDaoImpl().getTrainerMap().values());;
    }

    public void testFindTrainerByName() {
        System.out.println(new TrainerDaoImpl().findUserByAccount(
                (String) new TrainerDaoImpl().getTrainerMap().keySet().toArray()[0]
        ));
    }
}