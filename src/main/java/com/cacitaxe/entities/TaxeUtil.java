package com.cacitaxe.entities;

import java.math.BigDecimal;

public class TaxeUtil {
	public static BigDecimal PRECISION = new BigDecimal("0.05"); 

	public static BigDecimal arrondi(BigDecimal val){
	     val = val.divide(PRECISION);
	     val = new BigDecimal(Math.ceil(val.doubleValue()));
	     val= val.multiply(PRECISION);
	     
	     return val;
		
	}
	
}
