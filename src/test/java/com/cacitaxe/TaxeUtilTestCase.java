package com.cacitaxe;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.cacitaxe.entities.TaxeUtil;

public class TaxeUtilTestCase {
	private TaxeUtil taxesUtil;
	
	@Test
	public void testArrondi() {
		
		Assert.assertEquals(new BigDecimal("1.00"), taxesUtil.arrondi(new BigDecimal("0.99")));
		Assert.assertEquals(new BigDecimal("1.00"), taxesUtil.arrondi(new BigDecimal("1.00")));
		Assert.assertEquals(new BigDecimal("1.05"), taxesUtil.arrondi(new BigDecimal("1.01")));
		Assert.assertEquals(new BigDecimal("1.05"), taxesUtil.arrondi(new BigDecimal("1.02")));
	}
	

}
