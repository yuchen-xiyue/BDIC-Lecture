import java.awt.Point;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

public class ListMapTest {
	@Test 
	public void testPutAndGet() {
		ListMap l = new ListMap(); 
		Point p = new Point(1, 1);
		l.put(0, p);
		
		Assert.assertEquals(p, l.get(0));
		Assert.assertEquals(1, l.size());
	}
	
	
}
