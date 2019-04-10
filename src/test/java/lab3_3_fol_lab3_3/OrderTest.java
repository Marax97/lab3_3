package lab3_3_fol_lab3_3;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import edu.iis.mto.time.FakeDateTime;
import edu.iis.mto.time.Order;
import edu.iis.mto.time.Order.State;
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

    @Test
    public void shouldCheckIfStateIsNotCancelledAfterConfirmToDateLowerThen24h() {
        fakeDate.setNewDataTime(new DateTime(2019, 1, 1, 0, 0));
        order.submit();
        fakeDate.setNewDataTime(new DateTime(2019, 1, 1, 0, 0));
        order.confirm();
        assertThat(order.getOrderState(), is(not(equalTo(State.CANCELLED))));
    }

    @Test
    public void shouldCheckIfStateIsNotCancelledAfterConfirmToDateEqualTo24h() {
        fakeDate.setNewDataTime(new DateTime(2019, 1, 1, 0, 0));
        order.submit();
        fakeDate.setNewDataTime(new DateTime(2019, 1, 2, 0, 0));
        order.confirm();
        assertThat(order.getOrderState(), is(not(equalTo(State.CANCELLED))));
    }
}
