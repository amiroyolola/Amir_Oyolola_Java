import com.company.AccountRecord;
import com.company.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {


    @Test
    public void testGetBalance(){
        Customer testCustomer = new Customer();
        AccountRecord accountRecord0 = new AccountRecord();
        accountRecord0.setCharge(1000);
        accountRecord0.setChargeDate("1-22-2023");
        testCustomer.setId(0);
        testCustomer.setName("Test Customer 0");
        testCustomer.getCharges().add(accountRecord0);
        //Balance at this point should be 1,000
        assertEquals(1000,testCustomer.getBalance());

        //Another account record to test negative values
        AccountRecord accountRecord1 = new AccountRecord();
        accountRecord1.setCharge(-1500);
        accountRecord1.setChargeDate("1-23-2023");
        testCustomer.getCharges().add(accountRecord1);
        //Balance at this point should be negative 500. (1000 + -1500)
        assertEquals(-500,testCustomer.getBalance());

        //Testing multiple additions and subtractions to balance

        AccountRecord accountRecord2 = new AccountRecord();
        accountRecord2.setCharge(6598);
        accountRecord2.setChargeDate("1-23-2023");
        testCustomer.getCharges().add(accountRecord2);



        AccountRecord accountRecord3 = new AccountRecord();
        accountRecord3.setCharge(-754);
        accountRecord3.setChargeDate("1-23-2023");
        testCustomer.getCharges().add(accountRecord3);


        AccountRecord accountRecord4 = new AccountRecord();
        accountRecord4.setCharge(-100);
        accountRecord4.setChargeDate("1-23-2023");
        testCustomer.getCharges().add(accountRecord4);

        AccountRecord accountRecord5 = new AccountRecord();
        accountRecord5.setCharge(123500);
        accountRecord5.setChargeDate("1-23-2023");
        testCustomer.getCharges().add(accountRecord5);

        //123500 + -100 + -754 + 6598 + curr balance which -500 should be 128744

        assertEquals(128744,testCustomer.getBalance());
    }

    @Test
    public void testToString(){
        //Customer 0
        Customer testCustomer0 = new Customer();
        AccountRecord accountRecord0 = new AccountRecord();
        accountRecord0.setCharge(1000);
        accountRecord0.setChargeDate("1-22-2023");
        testCustomer0.setId(0);
        testCustomer0.setName("Test Customer 0");
        testCustomer0.getCharges().add(accountRecord0);
        assertEquals("ID: 0, Name: Test Customer 0, Balance: 1000",testCustomer0.toString());

        //Customer 1
        Customer testCustomer1 = new Customer();
        AccountRecord accountRecord1 = new AccountRecord();
        accountRecord1.setCharge(1800);
        accountRecord1.setChargeDate("12-2-2023");
        testCustomer1.setId(1);
        testCustomer1.setName("Michael");
        testCustomer1.getCharges().add(accountRecord1);
        assertEquals("ID: 1, Name: Michael, Balance: 1800",testCustomer1.toString());

        //Customer two
        Customer testCustomer2 = new Customer();
        AccountRecord accountRecord2 = new AccountRecord();
        accountRecord2.setCharge(180930);
        accountRecord2.setChargeDate("12-2-2023");
        testCustomer2.setId(2);
        testCustomer2.setName("Michael");
        testCustomer2.getCharges().add(accountRecord2);
        assertEquals("ID: 2, Name: Michael, Balance: 180930",testCustomer2.toString());
        //All three cases have id, name, and balance correct



    }
}
