import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    @Test
    public void TestBMICalculator() {
        BodyMassIndex e = new BodyMassIndex(70.0D, 180.0D);
        Assertions.assertEquals(25.824489795918367D, BodyMassIndex.BMI_Calculator(e.height, e.weight)); }

    @Test
    public void TestBMICategoryforOverweight() {
        BodyMassIndex e = new BodyMassIndex(70.0D, 180.0D);
        Assertions.assertEquals("Overweight", BodyMassIndex.BMI_Category(BodyMassIndex.BMI_Calculator(e.height, e.weight)));
    }

    @Test
    public void TestBMICategoryforObese() {
        BodyMassIndex e = new BodyMassIndex(70.0D, 300.0D);
        Assertions.assertEquals("Obesity", BodyMassIndex.BMI_Category(BodyMassIndex.BMI_Calculator(e.height, e.weight)));
    }

    @Test
    public void TestBMICategoryforUnderweight() {
        BodyMassIndex e = new BodyMassIndex(70.0D, 90.0D);
        Assertions.assertEquals("Underweight", BodyMassIndex.BMI_Category(BodyMassIndex.BMI_Calculator(e.height, e.weight)));
    }

    @Test
    public void TestBMICategoryforNormalWeight() {
        BodyMassIndex e = new BodyMassIndex(70.0D, 160.0D);
        Assertions.assertEquals("Normal Weight", BodyMassIndex.BMI_Category(BodyMassIndex.BMI_Calculator(e.height, e.weight)));
    }

}