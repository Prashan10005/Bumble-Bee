package ModelBean;

public class order extends product {
		private int orderID;
		private String uID;
		private int quantity;
		private String date;
		
		public order() {
			
		}
		
		public order(int orderID,String uID, int quantity, String date ) {
			super();
			this.orderID = orderID;
			this.uID = uID;
			this.quantity = quantity;
			this.date = date;
		}
		
		public order(String uID, int quantity, String date ) {
			super();
			this.uID = uID;
			this.quantity = quantity;
			this.date = date;
		}

		public int getOrderID() {
			return orderID;
		}

		public void setOrderID(int orderID) {
			this.orderID = orderID;
		}

		public String getuID() {
			return uID;
		}

		public void setuID(String uID) {
			this.uID = uID;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		
		
		
}
