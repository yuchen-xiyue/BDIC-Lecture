import org.junit.Test;

import junit.framework.Assert;

public class LPMapTest {
	@Test
	public void TestLPMap() {
		LPMap lpmp = new LPMap(10);
		lpmp.put(50, new Integer(1));
		lpmp.put(60, new Integer(2));
		lpmp.put(70, new Integer(3));
		lpmp.put(80, new Integer(4));
		lpmp.put(91, new Integer(5));
		Assert.assertEquals(5, (int)lpmp.get(91));
		
		lpmp.put(91, new Integer(6));
		Assert.assertEquals(6, (int)lpmp.get(91));
		
		lpmp.remove(91);
		Assert.assertEquals(null, lpmp.get(91));
	}
}
