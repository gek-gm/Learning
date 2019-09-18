package smell;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
 
public class Order {
 
    private List<LineItem> _lineItems = new Vector<LineItem>(); 
 
    public Order(List<LineItem> lineItems) {
        _lineItems = new ArrayList<LineItem>(lineItems);
    }
    
    public List<LineItem> getLineItems() {
        return Collections.unmodifiableList(_lineItems);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_lineItems == null) ? 0 : _lineItems.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Order other = (Order) obj;
        if (_lineItems == null) {
            if (other._lineItems != null) return false;
        } else if (!_lineItems.equals(other._lineItems)) return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LineItem item : _lineItems)
            sb.append(item.toString());
        sb.append("Order total = " + getTotal());
        return sb.toString();
    }
    
    public double getTotal() {
        double total = 0;
        for (LineItem item : _lineItems)
            total += item.getTotal();
        return total;
    }
    
    public static void writeOrder(Order order, PrintWriter pw) {
        pw.print(order.toString());
    }
 
    /** This method saves the order to the database */
    public void save()  throws SQLException
    {
        Connection dbConnection = DatabaseConnectionProvider.getConnection();
        String sql = new StringBuilder()
            .append("INSERT INTO T_ORDER " )
            .append("(AUTHORIZATION_CODE, " )
            .append("SHIPMETHOD_ID, USER_ID, ADDRESS_ID) " )
            .append("VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ).toString();
        // Set parameters ...
        PreparedStatement orderStatement = dbConnection.prepareStatement(sql);
        
        orderStatement.executeUpdate();    
    }
}
