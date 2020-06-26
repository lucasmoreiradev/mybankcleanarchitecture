package br.com.fauker.bank.domain;

import java.math.BigInteger;

public class Money {

	public static Money ZERO = Money.of(0L);
	
	private BigInteger amount;
	
	@Deprecated
	public Money() {}
	
	public Money(BigInteger amount) {
		this.amount = amount;
	}
	
	public BigInteger getAmount() {
		return amount;
	}
	
	public boolean isGreaterThan(Money money) {
		return this.amount.compareTo(money.amount) >= 0;
	}
	
	public boolean isPositive() {
		return this.amount.compareTo(BigInteger.ZERO) > 0;
	}
	
	public static Money of(Long value) {
		return new Money(BigInteger.valueOf(value));
	}
	
	public static Money add(Money a, Money b) {
		return new Money(a.amount.add(b.amount));
	}
	
	public Money subtract(Money money){
		return new Money(this.amount.subtract(money.amount));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		return true;
	}
	
}
