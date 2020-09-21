import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    BodyMassIndexTest()
    {
        }
        @Test
        public void TestBMICalculator() {
            BodyMassIndex e = new BodyMassIndex(70.0D, 180.0D);
            Assertions.assertEquals(25.824489795918367D, BodyMassIndex.BMI_Calculator(e.height, e.weight)); }

        @Test
        public void TestBMICategory() {
            BodyMassIndex e = new BodyMassIndex(70.0D, 180.0D);
            Assertions.assertEquals("Overweight", BodyMassIndex.BMI_Category(BodyMassIndex.BMI_Calculator(e.height, e.weight)));
        }
}
