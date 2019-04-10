package lab3_3_fol_lab3_3;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import edu.iis.mto.time.FakeDateTime;
import edu.iis.mto.time.Order;
import edu.iis.mto.time.OrderExpiredException;

public class OrderTest {

    private FakeDateTime fakeDate;
    private Order order;

    @Before
    public void setUp() {
        order = new Order();
        fakeDate = new FakeDateTime();
        order.setFakeDataTime(fakeDate);
    }

    @Test(expected = OrderExpiredException.class)
    public void shouldThroExceptionIfDataOfSubmitIsBiggerThenDay() {
        fakeDate.setNewDataTime(new DateTime(2019, 1, 1, 0, 0));
        order.submit();
        fakeDate.setNewDataTime(new DateTime(2019, 1, 3, 0, 0));
        order.confirm();
    }
}
