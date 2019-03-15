package Trade_SO;

import java.awt.AWTException;

import Education_LOB.Education_LOB.AcceptPayment;
import Education_LOB.Education_LOB.BillSO;
import Education_LOB.Education_LOB.Fullfill;
import Education_LOB.Education_LOB.SalesOrder;

public class Master {

	public static void main(String[] args) throws InterruptedException, AWTException {
		    Sales_Order_Trade.create();
		    Fullfill.validation();
		    BillSO.invoice();
		    AcceptPayment.payment();
		   // ReturnReceived.receivedReturn();
			}

	}


