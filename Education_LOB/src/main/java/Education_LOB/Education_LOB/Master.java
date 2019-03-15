package Education_LOB.Education_LOB;

import java.awt.AWTException;

public class Master {

	public static void main(String[] args) throws Exception, AWTException {
		
    SalesOrder.create();
    Fullfill.validation();
    BillSO.invoice();
    AcceptPayment.payment();
   // ReturnReceived.receivedReturn();
	}

}
